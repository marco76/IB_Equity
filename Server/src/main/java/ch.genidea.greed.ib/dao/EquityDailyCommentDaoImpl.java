package ch.genidea.greed.ib.dao;

import ch.genidea.greed.ib.bean.Equity;
import ch.genidea.greed.ib.bean.EquityDailyComment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/28/12
 * Time: 8:06 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class EquityDailyCommentDaoImpl implements EquityDailyCommentDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void save(EquityDailyComment equityDailyComment){
        equityDailyComment.setEquityId(equityDailyComment.getEquity().getId());
        em.merge(equityDailyComment);
    }

    @Override
    @Transactional(readOnly = true)
    public EquityDailyComment getByEquityAndDate(Equity equity, Integer dateInt){
        return (EquityDailyComment) em.createQuery("select EquityDailyComment as eq where eq.equity = :equity and eq.dateInt = :dateInt").setParameter("equity", equity)
                .setParameter("dateInt", dateInt).getSingleResult();
    }

    @Override
    @Transactional(readOnly = true)
    public EquityDailyComment getById(Long id){
        return (EquityDailyComment) em.createQuery("select EquityDailyComment as eq where eq.id = :id").setParameter("id", id).getSingleResult();
    }


    @Override
    @Transactional(readOnly = true)
    public List<EquityDailyComment> getCommentsByEntityId(Long id){
        try{
        return (List<EquityDailyComment>) em.createQuery("select eq from EquityDailyComment as eq where eq.equity.id = :id order by eq.dateInt desc").setParameter("id", id).getResultList();
    } catch(Exception e){
       System.out.println("no data found");
    }
        return new ArrayList<EquityDailyComment>();
 }
}
