package ch.genidea.greed.ib.service;

import ch.genidea.greed.ib.bean.PortfolioElement;
import ch.genidea.greed.ib.bean.PortfolioElementRT;
import ch.genidea.greed.ib.bean.PortfolioRT;
import ch.genidea.greed.ib.wrapper.ContractGen;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/14/12
 * Time: 12:35 PM
 * To change this template use File | Settings | File Templates.
 */
public interface
    PortfolioService {
    PortfolioRT getPortfolioRT();

    void updatePortfolioRTElement(PortfolioElementRT portfolioElementRT);


    void resetPorfolioRT();

    @Transactional
    void updateDatabase();

    @Transactional
    void savePortfolioElement(PortfolioElement element);

    List<PortfolioElement> getAllPortfolioElements();



    @Scheduled(cron = "0 * 11-23 * * MON-FRI")
    @Transactional
    void updatePortfolio();


    PortfolioElement getById(long id);

    PortfolioElement getByTicker(String ticker);

    ContractGen getContractForPortfolioElement(PortfolioElement portfolioElement);

    @Scheduled(cron = "0 * * * * ?")
    @Transactional
    void updateStrategies();

    void resetPortfolio();
}
