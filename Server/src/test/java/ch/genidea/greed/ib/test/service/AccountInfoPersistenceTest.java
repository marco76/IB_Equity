package ch.genidea.greed.ib.test.service;

import ch.genidea.greed.ib.bean.AccountInfo;
import ch.genidea.greed.ib.service.AccountService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 3/24/12
 * Time: 5:07 PM
 * To change this template use File | Settings | File Templates.
 */
@TransactionConfiguration
@ContextConfiguration({"classpath:nojms-config.xml"})
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountInfoPersistenceTest {
    @Resource
    AccountService accountService;

    @Test
    public void registerAccountInfo(){
        AccountInfo accountInfo = new AccountInfo();
        int startingAccounts = accountService.findAllAccountInfo().size();
        accountService.register(accountInfo);
        startingAccounts += 1;
        List<AccountInfo> accounts = accountService.findAllAccountInfo();
        Assert.assertEquals("There should be at least " + startingAccounts + " records ", startingAccounts , accounts.size());

    }

    @Test
    public void getLastAccountInfo(){
        AccountInfo accountInfo = new AccountInfo();
        accountService.register(accountInfo);
        long id = accountInfo.getId();
        AccountInfo account = accountService.getLastAccountInfo();
        Assert.assertEquals("Get the last Id ", id, account.getId());

    }
    @Test
    public void getFindLast(){
        AccountInfo accountInfo = new AccountInfo();
       /*
        AccountInfo account = accountService.getFindLasts(2);
        Assert.assertEquals("Get the last Id ", id, account.getId());
        */
    }
}
