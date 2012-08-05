package ch.genidea.greed.ib.service.historicalData;

import ch.genidea.greed.ib.bean.Equity;
import ch.genidea.greed.ib.bean.EquityHistoricalPrice;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/29/12
 * Time: 10:35 AM
 * To change this template use File | Settings | File Templates.
 */
public interface EquityHistoricalPriceService {
    void importAllDataForAllStocksIntoFile(String directory, String market);

    void getAllHistoricalPricesFromYahooToFiles(String directory);

    void importAllDataFromFiles(String directory);

    void importDataForEquityFromFile(String directory, Equity equity);

    List<EquityHistoricalPrice> getHistoricalPrices(Equity equity, int limit);
}
