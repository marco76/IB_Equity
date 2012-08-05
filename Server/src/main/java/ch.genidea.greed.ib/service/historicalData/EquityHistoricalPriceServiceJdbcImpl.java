package ch.genidea.greed.ib.service.historicalData;

import ch.genidea.greed.ib.bean.Equity;
import ch.genidea.greed.ib.bean.EquityHistoricalPrice;
import ch.genidea.greed.ib.dao.EquityHistoricalPriceDao;
import ch.genidea.greed.ib.service.EquityService;
import ch.genidea.greed.ib.utils.ReadYahooHistoricalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/30/12
 * Time: 6:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class EquityHistoricalPriceServiceJdbcImpl implements EquityHistoricalPriceService {
    @Autowired
    @Qualifier("equityHistoricalPriceDaoImpl")
    EquityHistoricalPriceDao equityHistoricalPriceDao;
    
    @Autowired
    @Qualifier("equityHistoricalPriceDaoImplJdbc")
    EquityHistoricalPriceDao equityHistoricalPriceDaoJdbc;

    @Autowired
    EquityService equityService;
    @Override
    public void importAllDataForAllStocksIntoFile(String directory, String market) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void getAllHistoricalPricesFromYahooToFiles(String directory) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void importAllDataFromFiles(String directory) {
        List<Equity> equities = equityService.findAll();
        System.out.println("Equities to import:" + equities.size());
        long startTime = System.currentTimeMillis();
        int counter = 0;
        for (Equity equity :equities){
            this.importDataForEquityFromFile(directory, equity);
            long stopTime = System.currentTimeMillis();
            long runTime = stopTime - startTime;
            System.out.println(""+counter+++"Run time: " + runTime/1000);
            System.out.println("Run time p/e: " + runTime/1000/counter);

        }}

     public void importDataForEquityFromFile(String directory, Equity equity) {
        String [][] data = null;
            List<EquityHistoricalPrice> equityList = new ArrayList<EquityHistoricalPrice>();
        try {
            data =  ReadYahooHistoricalData.readHistoricalDataFromFile(directory, equity.getTicker());
            for (int i = 0; i < data.length; i++){
                // if there are no more equities exit
                if (data[i][0] == null)
                    break;
                EquityHistoricalPrice price = new EquityHistoricalPrice();
                price.setDateInt(Integer.parseInt(data[i][0]));
                price.setOpen(Double.parseDouble(data[i][1]));
                price.setHigh(Double.parseDouble(data[i][2]));
                price.setLow(Double.parseDouble(data[i][3]));
                price.setClose(Double.parseDouble(data[i][4]));
                price.setVolume(Long.parseLong(data[i][5]));
                price.setAdjClose(Double.parseDouble(data[i][6]));
                price.setEquity(equity);
                price.setEquityId(equity.getId());
                equityList.add(price);
            }
        } catch (Exception e) {
            System.out.println("Impossible to read file for: " + equity.getTicker());
        }
         if (equityList.size() > 0)
             equityHistoricalPriceDaoJdbc.insertBatch(equityList);
    }

    @Override
    public List<EquityHistoricalPrice> getHistoricalPrices(Equity equity, int limit) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
