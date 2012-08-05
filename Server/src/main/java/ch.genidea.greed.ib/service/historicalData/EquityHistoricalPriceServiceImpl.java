package ch.genidea.greed.ib.service.historicalData;

import ch.genidea.greed.ib.bean.Equity;
import ch.genidea.greed.ib.bean.EquityHistoricalPrice;
import ch.genidea.greed.ib.dao.EquityHistoricalPriceDao;
import ch.genidea.greed.ib.service.EquityService;
import ch.genidea.greed.ib.utils.ReadYahooHistoricalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/29/12
 * Time: 10:35 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class EquityHistoricalPriceServiceImpl implements EquityHistoricalPriceService {
    @Autowired
    @Qualifier("equityHistoricalPriceDaoImpl")
    EquityHistoricalPriceDao equityHistoricalPriceDao;
    @Autowired
    EquityService equityService;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void importEquityDataForTicker(String ticker){


    }
    @Override
    @Transactional
    public void importAllDataForAllStocksIntoFile(String directory, String market){
       String[][] equityList =  ReadYahooHistoricalData.readAllSymbolsFromFile(directory, market);
       for (int i = 0; i < equityList.length; i++){
           // check/create sector
           // check/create industry
           // if there are no more equities exit
           if (equityList[i][0] == null)
               break;
           Equity equity = new Equity();
           equity.setTicker(equityList[i][0]);
           equity.setName(equityList[i][1]);
           if (!equityList[i][5].contains("n")){
               equity.setIpoYear(Integer.decode(equityList[i][5]));
      }
         equityService.saveImportedEquity(equity);
    }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void importDataForEquityFromFile(String directory, Equity equity){
        String [][] data = null;
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
                equityHistoricalPriceDao.save(price);
            }
        } catch (Exception e) {
            System.out.println("Impossible to read file for: " + equity.getTicker());
        }
    }

    @Override
    public void importAllDataFromFiles(String directory){
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


    }


    }

    @Override
    public void getAllHistoricalPricesFromYahooToFiles(String directory){
        List<Equity> equities = equityService.findAll();
        for(Equity equity : equities){

        ReadYahooHistoricalData.writeYahooHistoricalDataPageToFile(equity.getTicker(), directory);
        }

    }

    @Override
    public List<EquityHistoricalPrice> getHistoricalPrices(Equity equity, int limit){
        return equityHistoricalPriceDao.getPricesFor(equity);
    }


}
