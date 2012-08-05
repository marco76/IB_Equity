package ch.genidea.greed.ib.dao;

import ch.genidea.greed.ib.bean.AccountInfo;
import ch.genidea.greed.ib.service.AccountService;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 3/24/12
 * Time: 4:55 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class AccountInfoDaoImpl implements AccountInfoDao{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<AccountInfo> findAll(){
        return em.createQuery("from AccountInfo ai").getResultList();
    }

    @Override
    @Transactional
    public void save(AccountInfo accountInfo){
        em.persist(accountInfo);
    }

    @Override
    public AccountInfo getLastAccountInfo() {
        return em.createQuery("from AccountInfo ai Order by ai.id desc", AccountInfo.class).setMaxResults(1).getSingleResult();

    }

    @Override
    public List<AccountInfo> findLasts(int periods) {
        return em.createQuery("from AccountInfo ai Order by ai.id desc", AccountInfo.class).setMaxResults(periods).getResultList();
    }


}
