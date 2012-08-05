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

public class SaveHistoricalDataFromFilesToDB {
    public static void main(String args[]){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("batches-config.xml");
        EquityHistoricalPriceService service = (EquityHistoricalPriceService) ctx.getBean("equityHistoricalPriceService");
        service.importAllDataFromFiles("/Users/marco/j2ee/stockData");
        System.out.println("Import completed");
   }
    }

