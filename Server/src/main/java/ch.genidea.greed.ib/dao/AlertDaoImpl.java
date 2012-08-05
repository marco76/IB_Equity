package ch.genidea.greed.ib.dao;

import ch.genidea.greed.ib.bean.Alert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 3/30/12
 * Time: 5:55 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class AlertDaoImpl implements AlertDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Alert getAlertByName(String name){
      Query query = em.createQuery("from Alert a where a.name like :name").setParameter("name", name);
      Alert alert = null;
      try {
        alert = (Alert) query.getSingleResult();
      } catch (Exception e){
          e.printStackTrace();
      }
      return alert;
    }

    @Override
    @Transactional
    public void save(Alert alert){
        em.merge(alert);
    }

    @Override
    public List<Alert> getStocksActiveAlerts(){
        Query query = em.createQuery("from Alert a where a.equity is not null and a.active = 1");
        List<Alert> alerts = query.getResultList();
        return alerts;
    }

    @Override
    public Alert getById(long id){
     return em.find(Alert.class, id);
    }

    @Override
    public List<Alert> getAll(){
        return em.createQuery("from Alert").getResultList();
    }

}
