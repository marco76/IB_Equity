package ch.genidea.greed.ib.service;

import ch.genidea.greed.ib.bean.PortfolioElement;
import ch.genidea.greed.ib.bean.PortfolioElementRT;
import ch.genidea.greed.ib.bean.PortfolioRT;
import ch.genidea.greed.ib.dao.PortfolioDao;
import ch.genidea.greed.ib.strategy.StrategyService;
import ch.genidea.greed.ib.wrapper.ContractGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/14/12
 * Time: 12:35 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    PortfolioDao portfolioDao;
    @Autowired
    StrategyService strategyService;
    @Autowired
    ContractService contractService;

    PortfolioRT portfolioRT = new PortfolioRT();

    @Override
    public void resetPorfolioRT() {
        portfolioRT.resetPortfolio();
    }

    @Override
    public void resetPortfolio(){
      portfolioDao.resetPortfolio();
    }

    @Override
    public PortfolioRT getPortfolioRT(){
        return portfolioRT;
    }

    @Override
    public void updatePortfolioRTElement(PortfolioElementRT portfolioElementRT){
        portfolioRT.updateElement(portfolioElementRT);
    }

    @Override
    @Transactional
    public void updateDatabase(){
       //  portfolioDao.cleanPorfolio();
        List<PortfolioElementRT> listElements = new ArrayList<PortfolioElementRT>(portfolioRT.getPortfolioMap().values());

        for(PortfolioElementRT elementRt : listElements){
            PortfolioElement pe = portfolioDao.getByTicker(elementRt.getContract().m_symbol);
            if (pe == null){

                pe = new PortfolioElement();
                pe.setTicker(elementRt.getContract().m_symbol);

            }
                pe.setAverageCost(elementRt.getAverageCost());
                pe.setMarketPrice(elementRt.getMarketPrice());
                pe.setMarketValue(elementRt.getMarketValue());
                pe.setPosition(elementRt.getPosition());
                pe.setRealizedPNL(elementRt.getRealizedPNL());
                pe.setUnrealizedPNL(elementRt.getUnrealizedPNL());
                pe.setActiveInPortfolio(true);

            portfolioDao.save(pe);

        }
       }
    @Override
    @Transactional
    public void savePortfolioElement(PortfolioElement element){
        portfolioDao.save(element);
    }

    @Override
   // @Scheduled(cron = "0 0/5 11-23 * * MON-FRI")
   // @TODO PROD
    @Scheduled(cron = "0 * * * * ?")
    @Transactional
    public void updatePortfolio(){
        this.updateDatabase();
    }

    @Override
    @Scheduled(cron = "0 * * * * ?")
    @Transactional
    public void updateStrategies(){
       List<PortfolioElement> elements =  portfolioDao.getAll();
       for (PortfolioElement element : elements){
           if (element.isStrategyActive()){
              if (strategyService.getStrategyByContractGenEquityId(this.getContractForPortfolioElement(element))!=null){
                  // ok the strategy exist, @todo check which strategy
              } else {
                  // create the strategy
                  // get the contract linked to the porfolio
                  // create the strategy
                  if (!element.isStrategyActivated()){
                  if (element.getContractGen() == null){
                      ContractGen contractGen = getContractForPortfolioElement(element);
                      if (contractGen == null){
                          System.out.println("Error impossible to find contract: " + element.getTicker());
                          return;
                      }
                      element.setContractGen(contractGen);
                      contractGen.setPortfolioElement(element);
                      strategyService.linkStrategy(element.getContractGen(), element.getStrategyName());
                      element.setStrategyActivated(true);
                  }
                  }

              }
           }
       }
    }

    @Override
    public PortfolioElement getById(long id){
        return portfolioDao.getById(id);
    }

    @Override
    public List<PortfolioElement> getAllPortfolioElements(){
        return portfolioDao.getAll();
    }

    @Override
    public PortfolioElement getByTicker(String ticker){
        return portfolioDao.getByTicker(ticker);
    }

    @Override
    public ContractGen getContractForPortfolioElement(PortfolioElement portfolioElement){
        return contractService.getContractGenByTicker(portfolioElement.getTicker());
    }

}
