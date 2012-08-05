package ch.genidea.greed.ib.dao;

import ch.genidea.greed.ib.bean.Equity;
import ch.genidea.greed.ib.bean.EquityHistoricalPrice;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/29/12
 * Time: 10:30 AM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class EquityHistoricalPriceDaoImpl implements EquityHistoricalPriceDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void save(EquityHistoricalPrice price){
        em.merge(price);
    }

    @Override
    public List<EquityHistoricalPrice> getPricesFor(Equity equity){
        return em.createQuery("Select ep from EquityHistoricalPrice as ep where ep.equity = :equity").setParameter("equity", equity).getResultList();
    }

    @Override
    public void insertBatch(List<EquityHistoricalPrice> prices) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
