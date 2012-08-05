package ch.genidea.greed.db.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by IntelliJ IDEA.
 * User: marcomolteni
 * Date: 22.06.11
 * Time: 21:59
 * To change this template use File | Settings | File Templates.
 */
@Service()
public class Loader {

    @Autowired
    StockDataService stockDataService;
    @Autowired
    StockDataDailyInsertOperation stockDataDailyInsertOperation;


    public void loadWebPage(int yearStart, int monthStart, int dayStart, int yearEnd, int monthEnd, int dayEnd){
        try {


			URL yahooUrl = new URL("http://ichart.finance.yahoo.com/table.csv?s=%5EGSPC&d="+(monthEnd-1)+"&e="+dayEnd+"&f="+yearEnd+"&g=d&a="+(monthStart-1)+"&b="+dayStart+"&c="+yearStart+"&ignore=.csv");
			URLConnection connection = yahooUrl.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(connection
					.getInputStream()));
			String inputLine;
            // first is only the format
            inputLine = in.readLine();
			while ((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);
                writeDb(inputLine);

			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    public void writeDb(String line){
        StockData stockData = stockDataService.createStockDataFromString(line);
         stockDataDailyInsertOperation.perform(stockData);
        stockData = null;

    }
  }
