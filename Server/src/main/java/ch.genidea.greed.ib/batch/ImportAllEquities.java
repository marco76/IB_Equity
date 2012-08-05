package ch.genidea.greed.ib.batch;

import ch.genidea.greed.ib.service.historicalData.EquityHistoricalPriceService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/29/12
 * Time: 12:57 PM
 * To change this template use File | Settings | File Templates.
 */

public class ImportAllEquities {
    public static void main(String args[]){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("nojms-config.xml");
        EquityHistoricalPriceService service = (EquityHistoricalPriceService) ctx.getBean("equityHistoricalPriceService");
        service.importAllDataForAllStocksIntoFile("/Users/marco/Documents/j2ee/stockData/", "nasdaq");
        service.importAllDataForAllStocksIntoFile("/Users/marco/Documents/j2ee/stockData/", "nyse");
        service.importAllDataForAllStocksIntoFile("/Users/marco/Documents/j2ee/stockData/", "amex");
   }
    }

