package ch.genidea.greed.ib.service;

import ch.genidea.greed.ib.bean.Equity;
import ch.genidea.greed.ib.wrapper.ContractGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/14/12
 * Time: 8:27 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class MainServiceImpl implements MainService {
        @Autowired
        EquityService equityService;
        @Autowired
        ContractService contractService;
        @Autowired
        Connection connectionService;
    @Autowired
    PortfolioService portfolioService;

        @Override
        public void initialiseRealTime(){
            List<Equity> equityList = equityService.getFavourites();
            for (Equity equity:equityList){
                ContractGen contractGen = new ContractGen();
                contractGen.setSymbol(equity.getTicker());
                contractGen.setEquityID(equity.getId());
                //contractGen.setId((int)equity.getId());
                contractService.updateContractList(contractGen);
            }
            contractService.initializeRealTime();
        }

    @Override
    public void initialiseNews(){
        System.out.println("Starting news");

        connectionService.getMarketNews(true);
    }

    @Override
    public void initialiseConnection() {
        System.out.println("Starting connection");
        connectionService.connect();

    }

    @Override
    public void initialisePortfolio(){
        portfolioService.resetPorfolioRT();
        portfolioService.resetPortfolio();
        connectionService.requestAccountInfo(true);
    }

    public EquityService getEquityService() {
        return equityService;
    }

    public void setEquityService(EquityService equityService) {
        this.equityService = equityService;
    }

    public ContractService getContractService() {
        return contractService;
    }

    public void setContractService(ContractService contractService) {
        this.contractService = contractService;
    }
}
