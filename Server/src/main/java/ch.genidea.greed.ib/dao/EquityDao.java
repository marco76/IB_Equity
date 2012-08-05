package ch.genidea.greed.ib.dao;

import ch.genidea.greed.ib.bean.Equity;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/14/12
 * Time: 6:03 PM
 * To change this template use File | Settings | File Templates.
 */
public interface EquityDao {
    Equity getEquityByTicker(String ticker);

    @Transactional
    void save(Equity equity);

    List getAll();

    Equity getById(Long id);

    List<Equity> getRealTime();

    Date getLastUpdate();

    List<Equity> getUpdatedEquities(Date date);

    List getFavourites();

    List<Equity> getEquityStartingTickerWith(String ticker, int max);
}
