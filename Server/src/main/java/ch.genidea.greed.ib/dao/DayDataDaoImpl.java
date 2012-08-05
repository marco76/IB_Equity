package ch.genidea.greed.ib.dao;

import ch.genidea.greed.ib.bean.DayData;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/26/12
 * Time: 8:28 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class DayDataDaoImpl implements DayDataDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public DayData getDayByInt(Integer day){
    Query query = em.createQuery("from DayData d where d.dateInt = :dayInt").setParameter("dayInt", day);
        DayData dayData = null;
        try {
            dayData = (DayData) query.getSingleResult();
        } catch (Exception e){
            e.printStackTrace();
        }
        return dayData;
    }



    @Override
    @Transactional
    public void save(DayData dayData){
        em.merge(dayData);
    }


    @Override
    public List getAll(){
        return em.createQuery("from DayData d").getResultList();

    }



    @Override
    public DayData getById(Long id) {
        return (DayData)em.createQuery("from DayData e where id = :id").setParameter("id", id).getSingleResult();  //To change body of implemented methods use File | Settings | File Templates.
    }
}
