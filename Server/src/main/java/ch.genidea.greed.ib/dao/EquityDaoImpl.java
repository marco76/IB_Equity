package ch.genidea.greed.ib.dao;

import ch.genidea.greed.ib.bean.Equity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/14/12
 * Time: 6:04 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class EquityDaoImpl implements EquityDao {
    @PersistenceContext
    private EntityManager em;


    @Override
    public Equity getEquityByTicker(String ticker){
        Query query = em.createQuery("from Equity e where e.ticker like :ticker").setParameter("ticker", ticker);
        Equity equity = null;
        try {
            equity = (Equity) query.getSingleResult();
        } catch (Exception e){

            return null;
        }
        return equity;
    }


    @Override
    @Transactional
    public void save(Equity equity){
        em.merge(equity);
    }

    @Override
    public List getAll(){
        return em.createQuery("from Equity e").getResultList();
    }

    @Override
    public List getFavourites(){
        return em.createQuery("from Equity e where e.favourite = 1").getResultList();
    }

    @Override
    public Equity getById(Long id) {
        return (Equity)em.createQuery("from Equity e where id = :id").setParameter("id", id).getSingleResult();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Equity> getRealTime(){
        return em.createQuery("from Equity e where realTime = 1").getResultList();
    }

    @Override
    public Date getLastUpdate(){
        return (Date) em.createQuery("select max(e.updated)from Equity e ").getSingleResult();
    }

    @Override
    public List<Equity> getUpdatedEquities(Date date){
        return em.createQuery("select e from Equity e where e.updated >= :date").setParameter("date",date).getResultList();
    }

    @Override
    public List<Equity> getEquityStartingTickerWith(String ticker, int max){
        Query query = em.createQuery("from Equity e where e.ticker like :ticker || '%'").setParameter("ticker", ticker).setMaxResults(max);
        return  query.getResultList();
    }
}
