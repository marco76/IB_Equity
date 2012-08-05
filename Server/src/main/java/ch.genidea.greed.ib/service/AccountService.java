package ch.genidea.greed.ib.service;

import ch.genidea.greed.ib.bean.AccountInfo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: marcomolteni
 * Date: 13.11.11
 * Time: 18:18
 * To change this template use File | Settings | File Templates.
 */
public interface AccountService {
    public void fillField(String key, String value, String currency, String accountName);

    List<AccountInfo> findAllAccountInfo();
    AccountInfo getLastAccountInfo();

    @Transactional
    void register(AccountInfo accountInfo);

    List<AccountInfo> getFindLasts(int periods);

    @Scheduled(fixedDelay = 60000)
    void saveAccountRegularly();
}
