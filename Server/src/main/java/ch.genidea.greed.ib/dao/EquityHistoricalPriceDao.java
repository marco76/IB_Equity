package ch.genidea.greed.ib.dao;

import ch.genidea.greed.ib.bean.Equity;
import ch.genidea.greed.ib.bean.EquityHistoricalPrice;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/29/12
 * Time: 10:30 AM
 * To change this template use File | Settings | File Templates.
 */
public interface EquityHistoricalPriceDao {
    void save (EquityHistoricalPrice price);

    List<EquityHistoricalPrice> getPricesFor(Equity equity);

      void insertBatch(List<EquityHistoricalPrice> prices);
}
