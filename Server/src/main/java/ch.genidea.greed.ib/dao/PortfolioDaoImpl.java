package ch.genidea.greed.ib.dao;

import ch.genidea.greed.ib.bean.PortfolioElement;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/18/12
 * Time: 9:50 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class PortfolioDaoImpl implements PortfolioDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void cleanPorfolio(){
        em.createQuery("delete from PortfolioElement").executeUpdate();
    }

    @Override
    @Transactional
    public void save(PortfolioElement portfolioElement){
        em.merge(portfolioElement);
    }

    @Override
    public List<PortfolioElement> getAll(){
       return em.createQuery("from PortfolioElement p where activeInPortfolio = 1").getResultList();
    }

    @Override
    public PortfolioElement getById(long id){
        return em.find(PortfolioElement.class, id);
    }

    @Override
    public PortfolioElement getByTicker(String ticker){
        try{
           return (PortfolioElement) em.createQuery("from PortfolioElement p where ticker = :ticker").setParameter("ticker", ticker).getSingleResult();
        } catch(javax.persistence.NoResultException e) {
            return null;
        }
        }

    @Override
    @Transactional
    public void resetPortfolio(){
        em.createQuery("Update PortfolioElement set activeInPortfolio = 0").executeUpdate();
    }

}
