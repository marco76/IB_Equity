package ch.genidea.greed.ib.test.service;

import ch.genidea.greed.ib.utils.ReadYahooHistoricalData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

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
public class ReadYahooHistoricalDataTest {

    @Test
    public void registerAccountInfo(){
        ReadYahooHistoricalData read = new ReadYahooHistoricalData();
        read.writeYahooHistoricalDataPageToFile("MSFT", "/Users/marco/j2ee/stockData/");

    }

    @Test
    public void readSymbolsFromFile(){
        ReadYahooHistoricalData read = new ReadYahooHistoricalData();
        read.readAllSymbolsFromFile("nasdaq", "/Users/marco/Downloads/");
    }

    @Test
    public void readFileOfPrices(){
        String[][] result = ReadYahooHistoricalData.readHistoricalDataFromFile("/Users/marco/j2ee/StockData", "aapl");
        for(int i=0; i<10; i++)
            System.out.println(result[i][0] + " - " + result[i][1]);
    }




}
