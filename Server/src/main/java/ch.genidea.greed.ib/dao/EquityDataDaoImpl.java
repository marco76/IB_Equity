package ch.genidea.greed.ib.dao;

import ch.genidea.greed.ib.bean.Equity;
import ch.genidea.greed.ib.bean.EquityData;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/15/12
 * Time: 10:34 AM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class EquityDataDaoImpl implements EquityDataDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void insertData(Equity equity, EquityData equityData){
        equityData.setEquity(equity);
        em.persist(equityData);
    }

    @Override
    public List<EquityData> getEquityDataForEquity(Equity equity){
       return em.createQuery("from EquityData ed where ed.equity = :equity").setParameter("equity", equity).getResultList();
    }

    @Override
    public EquityData getLastEquityDataForEquity(Equity equity){
        Long maxId = (Long)em.createQuery("select max (ed.id) from EquityData ed where ed.equity = :equity").setParameter("equity", equity).getSingleResult();
        if (maxId == null)
            return null;
        return em.find(EquityData.class, maxId);
    }
}
