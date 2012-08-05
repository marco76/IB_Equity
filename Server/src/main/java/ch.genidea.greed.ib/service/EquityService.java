package ch.genidea.greed.ib.service;

import ch.genidea.greed.ib.bean.Equity;
import ch.genidea.greed.ib.bean.EquityData;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/14/12
 * Time: 6:08 PM
 * To change this template use File | Settings | File Templates.
 */
public interface EquityService {
    List<Equity> findAll();

    void updateEquity(Equity equity);

    Equity getById(Long id);

    List<Equity> getRealTimeEquities();

    void saveEquityData(Equity equity, EquityData equityData);

    List<EquityData> getDataForEquity(Equity equity);

    void saveEquityData(EquityData equityData);

    void saveEquityDataRegularly();

    EquityData getLastDataForEquity(Equity equity);

    Date getLastUpdate();

    Equity getEquityByTicker(String ticker);

    List<Equity> getUpdatedEquities(Date date);

    void saveImportedEquity(Equity equity);

    List<Equity> getFavourites();


    List<Equity> getEquityStartingTickerWith(String ticker, int max);

    Equity addFavoriteEquityAndInitialiseContract(Equity equity);
}
