package ch.genidea.greed.ib.service;

import ch.genidea.greed.ib.bean.AccountInfo;
import ch.genidea.greed.ib.bean.Alert;
import ch.genidea.greed.ib.bean.Equity;
import ch.genidea.greed.ib.bean.StockArrayRT;
import ch.genidea.greed.ib.dao.AlertDao;
import com.ib.client.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 3/30/12
 * Time: 6:03 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class AlertServiceImpl implements AlertService {
    @Autowired
    private AlertDao alertDao;

    @Autowired
    private AccountService accountService;

    @Autowired
    private EquityService equityService;
    @Autowired
    private ContractService contractService;

    @Autowired
    private StockArrayRT stockArrayRT;

    @Override
    public Alert getAlertByName(String name){
        return alertDao.getAlertByName(name);
    }

    @Override
    @Transactional
    public void register(Alert alert){
        if (alert.getTicker() != null){
            Equity equity = equityService.getEquityByTicker(alert.getTicker());
            if (equity != null){
                alert.setEquity(equity);
            }
        }
        alertDao.save(alert);
    }

    @Override
    public Alert getById(long id){
        return alertDao.getById(id);
    }

    @Override
    public List<Alert> getStocksActiveAlerts(){
        return alertDao.getStocksActiveAlerts();
    }

    @Override
    public List<Alert> getAlerts(){
        return alertDao.getAll();
    }

    @Override
    public void checkAlert() {

        AccountInfo account = accountService.getLastAccountInfo();
        SendNotification sendNotification = new SendNotification();

        Alert alert = alertDao.getAlertByName("account.sell.up");

        if (alert != null){
        if (!alert.getNotified() && account.getNetLiquidation().compareTo(alert.getLimitUp())>1){

            sendNotification.sendNotification("Account SELL", "Target ok", "Actual : " + account.getNetLiquidation());
            alert.setNotified(true);
            alertDao.save(alert);
        }
        if (alert.getNotified() && account.getNetLiquidation().compareTo(alert.getLimitUp())<1){
            alert.setNotified(false);
            alertDao.save(alert);
            sendNotification.sendNotification("Account Warning", "Target lost", "Actual : " + account.getNetLiquidation());
        }
        }

        alert = alertDao.getAlertByName("account.close.down");

            if (alert != null){
                if (!alert.getNotified() && account.getNetLiquidation().compareTo(alert.getLimitUp())<1){
                     sendNotification.sendNotification("Account DANGER", "Underwater", "Actual : " + account.getNetLiquidation());
                    alert.setNotified(true);
                    alertDao.save(alert);
                }
                if (alert.getNotified() && account.getNetLiquidation().compareTo(alert.getLimitUp())>1){
                    alert.setNotified(false);
                    alertDao.save(alert);
                    sendNotification.sendNotification("Account Ok", "Target regained", "Actual : " + account.getNetLiquidation());
                }
            }
            }


    @Override
    //@Scheduled(cron = "0 * 11-23 * * MON-FRI")
    @Scheduled(cron = "0 * 11-23 * * MON-FRI")
    public void checkStockAlert() {

        SendNotification sendNotification = new SendNotification();

        List<Alert> alerts = alertDao.getStocksActiveAlerts();
        for (Alert alert : alerts){
            Contract contract = contractService.getContractRT((int)alert.getEquity().getId());
            if (contract == null)
                continue;
            if (!alert.getLimitUpNotified() && !alert.getLimitMinNotified()){
                BigDecimal last = BigDecimal.valueOf(stockArrayRT.getPrice(contract.m_conId, StockArrayRT.LAST));
                if (last.compareTo(alert.getLimitUp()) > 0){
                    sendNotification.sendNotification("Target OK", alert.getTicker(), " at :"+last+", target:"+alert.getLimitUp());
                    alert.setLimitUpNotified(true);
                }
                if (last.compareTo(alert.getLimitMin()) < 0){
                    sendNotification.sendNotification("WARNING ON", alert.getTicker(), " at :"+last+", warning:"+alert.getLimitMin());
                    alert.setLimitMinNotified(true);
                }
            } else if (alert.getLimitUpNotified() || alert.getLimitMinNotified()){
                BigDecimal last = BigDecimal.valueOf(stockArrayRT.getPrice(contract.m_conId, StockArrayRT.LAST));
                if (last.compareTo(alert.getLimitUp()) < 0){
                    sendNotification.sendNotification("Target KO", alert.getTicker(), " at :"+last+", target:"+alert.getLimitUp());
                alert.setLimitUpNotified(false);
                }
                if (last.compareTo(alert.getLimitMin()) > 0){
                    sendNotification.sendNotification("Warning Off", alert.getTicker(), " at :"+last+", warning:"+alert.getLimitMin());
                    alert.setLimitMinNotified(true);
                }
           }
        }
    }
}

