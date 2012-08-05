package ch.genidea.greed.ib.service;

import ch.genidea.greed.ib.bean.AccountInfo;
import ch.genidea.greed.ib.dao.AccountInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: marcomolteni
 * Date: 13.11.11
 * Time: 18:20
 * To change this template use File | Settings | File Templates.
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountInfoDao accountInfoDao;

    private AccountInfo account = new AccountInfo();

    @Override
    public void fillField(String key, String value, String currency, String accountName) {
        if (key.equalsIgnoreCase("AccountCode"))
            account.setCode(value);
        if (key.equalsIgnoreCase("AccruedCash")){
            if (currency.equalsIgnoreCase("USD"))
                account.setAccruedCash(new BigDecimal(value));
        }
        if (key.equalsIgnoreCase("AvailableFunds"))
            account.setAvailableFunds(new BigDecimal(value));
        if (key.equalsIgnoreCase("BuyingPower"))
            account.setBuyingPower(new BigDecimal(value));
        if (key.equalsIgnoreCase("CashBalance")) {
            if (currency.equalsIgnoreCase("USD"))
                account.setCashBalance(new BigDecimal(value));
            else if (currency.equalsIgnoreCase("BASE")){
                account.setTotalCashBalanceBase(new BigDecimal(value));
            }
        }
        if (key.equalsIgnoreCase("Cushion"))
            account.setCushion(new BigDecimal(value));
        if (key.equalsIgnoreCase("EquityWithLoanValue"))
            account.setEquityWithLoanValue(new BigDecimal(value));
        if (key.equalsIgnoreCase("ExcessLiquidity"))
            account.setExcessLiquidity(new BigDecimal(value));
        if (key.equalsIgnoreCase("FullAvailableFunds"))
            account.setFullAvailableFunds(new BigDecimal(value));
        if (key.equalsIgnoreCase("FullExcessLiquidity"))
            account.setFullExcessLiquidity(new BigDecimal(value));
        if (key.equalsIgnoreCase("FullInitMarginReq"))
            account.setFullInitMarginReq(new BigDecimal(value));
        if (key.equalsIgnoreCase("FullMaintMarginReq"))
            account.setFullMaintMarginReq(new BigDecimal(value));
        if (key.equalsIgnoreCase("GrossPositionValue"))
            account.setGrossPositionValue(new BigDecimal(value));
        if (key.equalsIgnoreCase("InitMarginReq"))
            account.setInitMarginReq(new BigDecimal(value));
        if (key.equalsIgnoreCase("Leverage-S"))
            account.setLeverageS(new BigDecimal(value));
        if (key.equalsIgnoreCase("LookAheadAvailableFunds"))
            account.setLookAheadAvailableFunds(new BigDecimal(value));
        if (key.equalsIgnoreCase("LookAheadExcessLiquidity"))
            account.setLookAheadExcessLiquidity(new BigDecimal(value));
        if (key.equalsIgnoreCase("LookAheadInitMarginReq"))
            account.setLookAheadInitMarginReq(new BigDecimal(value));
        if (key.equalsIgnoreCase("LookAheadMaintMarginReq"))
            account.setLookAheadMaintMarginReq(new BigDecimal(value));
        if (key.equalsIgnoreCase("MaintMarginReq"))
            account.setMaintMarginReq(new BigDecimal(value));
        if (key.equalsIgnoreCase("NetLiquidation")){
            if (account.getNetLiquidation().compareTo(new BigDecimal(value)) != 0)
                account.setUpdated(true);
            account.setNetLiquidation(new BigDecimal(value));
        }
        if (key.equalsIgnoreCase("OptionMarketValue")){
            if (currency.equalsIgnoreCase("USD")){
                account.setOptionMarketValue(new BigDecimal(value));
            }
        }
        if (key.equalsIgnoreCase("PreviousDayEquityWithLoanValue"))
            account.setPreviousDayEquityWithLoanValue(new BigDecimal(value));
        if (key.equalsIgnoreCase("RegTEquity"))
            account.setRegTEquity(new BigDecimal(value));
        if (key.equalsIgnoreCase("ReqTMargin"))
            account.setRegTMargin(new BigDecimal(value));
        if (key.equalsIgnoreCase("SMA"))
            account.setSma(new BigDecimal(value));
        if (key.equalsIgnoreCase("StockMarketValue"))
            if (currency.equalsIgnoreCase("USD")){
              account.setStockMarketValue(new BigDecimal(value));
            }
        if (key.equalsIgnoreCase("TotalCashBalance"))
            if (currency.equalsIgnoreCase("BASE")){
              account.setTotalCashBalance(new BigDecimal(value));
            }
        if (key.equalsIgnoreCase("TotalCashValue"))
            account.setTotalCashValue(new BigDecimal(value));
        if (key.equalsIgnoreCase("UnrealizedPnL"))
            if (currency.equalsIgnoreCase("USD")){
            account.setUnrealizedPnl(new BigDecimal(value));
        }



    }

    @Override
    public List<AccountInfo> findAllAccountInfo(){
        return accountInfoDao.findAll();
    }

    @Override
    public AccountInfo getLastAccountInfo() {
        return accountInfoDao.getLastAccountInfo();
    }

    @Override
    public List<AccountInfo> getFindLasts(int periods){
        return accountInfoDao.findLasts(periods);
    }

    @Override
    @Transactional
    public void register(AccountInfo accountInfo){
        accountInfoDao.save(accountInfo);
    }

    @Override
    @Scheduled(cron = "0 * 10-23 * * MON-FRI")
    @Transactional
    public void saveAccountRegularly(){
        System.out.println("check for updates");
        if (account.getUpdated()){
            accountInfoDao.save(account);
            account = new AccountInfo();
            account.setUpdated(false);
        }
    }

}
