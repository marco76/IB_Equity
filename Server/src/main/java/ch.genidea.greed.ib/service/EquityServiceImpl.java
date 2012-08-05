package ch.genidea.greed.ib.service;

import ch.genidea.greed.ib.bean.Equity;
import ch.genidea.greed.ib.bean.EquityData;
import ch.genidea.greed.ib.bean.StockArrayRT;
import ch.genidea.greed.ib.dao.EquityDao;
import ch.genidea.greed.ib.dao.EquityDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/14/12
 * Time: 6:08 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class EquityServiceImpl implements EquityService {
    @Autowired
    EquityDao equityDao;
    @Autowired
    EquityDataDao equityDataDao;
    @Autowired
    StockArrayRT stockArrayRT;
    @Autowired
    ContractService contractService;

    @Override
    public List<Equity> findAll(){
        return equityDao.getAll();
    }

    @Override
    public List<Equity> getFavourites(){
        return equityDao.getFavourites();
    }

    @Override
    @Transactional
    public void updateEquity(Equity equity){
        equityDao.save(equity);
        contractService.initializeContract(equity);

    }

    @Override
    public Equity getById(Long id){
        return equityDao.getById(id);
    }

    @Override
    public List<Equity> getRealTimeEquities(){
        return equityDao.getRealTime();
    }

    @Override
    public void saveEquityData(Equity equity, EquityData equityData) {
        equityDataDao.insertData(equity, equityData);

    }

    @Override
    public void saveEquityData(EquityData equityData){
        equityDataDao.insertData(equityData.getEquity(), equityData);
    }

    @Override
    public List<EquityData> getDataForEquity(Equity equity){
        return equityDataDao.getEquityDataForEquity(equity);
    }

    @Override
    public EquityData getLastDataForEquity(Equity equity){
        return equityDataDao.getLastEquityDataForEquity(equity);
    }

    @Override
    public List<Equity> getUpdatedEquities(Date date){
        return equityDao.getUpdatedEquities(date);
    }


    @Override
    // executed every minute between 10 am et 11 pm from monday to friday
   // @Scheduled(cron = "* 10-22 * * 1-5")
   // http://stackoverflow.com/questions/3665441/cron-expression-for-particular-date
    @Scheduled (cron = "0 */2 11-23 * * MON-FRI")
    @Transactional
    public void saveEquityDataRegularly(){
        System.out.println("save equity data");
        List<Equity> equities = getRealTimeEquities();
        for (Equity equity : equities){
            EquityData equityData = new EquityData();
            equityData.setEquity(equity);
            Integer position = (int)equity.getId();
            equityData.setClose(new BigDecimal(stockArrayRT.getPrice(position, StockArrayRT.CLOSE)));
            equityData.setLast(new BigDecimal(stockArrayRT.getPrice(position, StockArrayRT.LAST)));
            equityData.setHigh(new BigDecimal(stockArrayRT.getPrice(position, StockArrayRT.HIGH)));
            equityData.setLow(new BigDecimal(stockArrayRT.getPrice(position, StockArrayRT.LOW)));
            equityData.setAsk(new BigDecimal(stockArrayRT.getPrice(position, StockArrayRT.ASK)));
            equityData.setBid(new BigDecimal(stockArrayRT.getPrice(position, StockArrayRT.BID)));
            equityData.setHigh13week(new BigDecimal(stockArrayRT.getPrice(position, StockArrayRT.HIGH_13_WEEK)));

            equityData.setHigh52week(new BigDecimal(stockArrayRT.getPrice(position, StockArrayRT.HIGH_52_WEEK)));
            equityData.setMarkPrice(new BigDecimal(stockArrayRT.getPrice(position, StockArrayRT.MARK_PRICE)));
            this.saveEquityData(equityData);
        }
    }

    @Override
    public Date getLastUpdate(){
        return equityDao.getLastUpdate();
    }

    @Override
    public Equity getEquityByTicker(String ticker){
        return equityDao.getEquityByTicker(ticker);
    }


    @Override
    @Transactional
    public Equity addFavoriteEquityAndInitialiseContract(Equity equity){
            equityDao.save(equity);
            contractService.initializeContract(equity);
         return equity;
    }
    @Override
    @Transactional
    public void saveImportedEquity(Equity equity){
        Equity existingEquity = equityDao.getEquityByTicker(equity.getTicker());
        if (existingEquity != null){
            existingEquity.setIpoYear(equity.getIpoYear());
            existingEquity.setName(equity.getName());
            equityDao.save(existingEquity);
        } else {
            equityDao.save(equity);
        }
    }

    @Override
    public List<Equity> getEquityStartingTickerWith(String ticker, int max){
        if (ticker.length() > 1)
          return equityDao.getEquityStartingTickerWith(ticker, max);
        return
             new ArrayList<Equity>();
    }
}
