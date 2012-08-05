package ch.genidea.greed.ib.dao;

import ch.genidea.greed.ib.bean.Equity;
import ch.genidea.greed.ib.bean.EquityData;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/15/12
 * Time: 10:34 AM
 * To change this template use File | Settings | File Templates.
 */
public interface EquityDataDao {
    void insertData(Equity equity, EquityData equityData);

    List<EquityData> getEquityDataForEquity(Equity equity);

    EquityData getLastEquityDataForEquity(Equity equity);
}
