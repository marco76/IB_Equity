package ch.genidea.greed.db.loader;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: marcomolteni
 * Date: 22.06.11
 * Time: 22:43
 * To change this template use File | Settings | File Templates.
 */

@Service
public class StockDataService {


   public StockData createStockDataFromString(String yahooFormat){
       String [] data = yahooFormat.split(",");


       StockData stockData = new StockData();
       stockData.setTickerId(1);
       stockData.setDate(Integer.parseInt(data[0].replaceAll("-","")));
       //@todo convert using int
       stockData.setOpen(BigDecimal.valueOf(Double.parseDouble(data[1])));
       stockData.setHigh(BigDecimal.valueOf(Double.parseDouble(data[2])));
       stockData.setLow(BigDecimal.valueOf(Double.parseDouble(data[3])));
       stockData.setClose(BigDecimal.valueOf(Double.parseDouble(data[4])));
       stockData.setVolume(Long.parseLong(data[5]));

       return stockData;
   }
}
