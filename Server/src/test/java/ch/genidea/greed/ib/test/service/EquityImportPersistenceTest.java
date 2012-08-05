package ch.genidea.greed.ib.test.service;

import ch.genidea.greed.ib.bean.Equity;
import ch.genidea.greed.ib.bean.EquityHistoricalPrice;
import ch.genidea.greed.ib.service.EquityService;
import ch.genidea.greed.ib.service.historicalData.EquityHistoricalPriceService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 3/24/12
 * Time: 5:07 PM
 * To change this template use File | Settings | File Templates.
 */
@TransactionConfiguration
@ContextConfiguration({"classpath:nojms-config.xml"})
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
public class EquityImportPersistenceTest {
    @Resource
    EquityHistoricalPriceService equityHistoricalPriceService;
    @Resource
    EquityService equityService;

    @Test
    public void registerHistoricalData(){
       equityHistoricalPriceService.importAllDataForAllStocksIntoFile("/Users/marco/Downloads/", "nasdaq");
       List<Equity> equities = equityService.findAll();
        Assert.assertTrue("There should be at least 1000  records ", 1000 <= equities.size());

    }

    @Test
    public void insertDataFromFile(){
        Equity aapl = equityService.getEquityByTicker("AAPL");
        List <EquityHistoricalPrice> prices = equityHistoricalPriceService.getHistoricalPrices(aapl, 100);
        equityHistoricalPriceService.importDataForEquityFromFile("/Users/marco/j2ee/stockData", aapl);
        List <EquityHistoricalPrice> prices2 = equityHistoricalPriceService.getHistoricalPrices(aapl, 100);
        Assert.assertTrue("There are more prices than before", prices.size() < prices2.size());
        Assert.assertTrue("There are more than 1000 prices", prices2.size() > 1000);

    }


}
