package ch.genidea.greed.ib.service;

import ch.genidea.greed.ib.bean.Alert;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 3/30/12
 * Time: 6:03 PM
 * To change this template use File | Settings | File Templates.
 */
public interface AlertService {

    Alert getAlertByName(String name);

    @Transactional
    void register(Alert alert);

    @Scheduled(fixedDelay = 120000)
    void checkAlert();

    void checkStockAlert();

    List<Alert> getStocksActiveAlerts();

    List<Alert> getAlerts();

    Alert getById(long id);
}
