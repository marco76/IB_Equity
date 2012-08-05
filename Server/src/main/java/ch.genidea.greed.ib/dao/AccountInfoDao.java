package ch.genidea.greed.ib.dao;

import ch.genidea.greed.ib.bean.AccountInfo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 3/24/12
 * Time: 5:10 PM
 * To change this template use File | Settings | File Templates.
 */
public interface AccountInfoDao {
    List<AccountInfo> findAll();

    void save(AccountInfo accountInfo);
    AccountInfo getLastAccountInfo();
    List<AccountInfo> findLasts(int periods);
}
