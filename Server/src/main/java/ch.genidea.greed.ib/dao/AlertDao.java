package ch.genidea.greed.ib.dao;

import ch.genidea.greed.ib.bean.Alert;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 3/30/12
 * Time: 5:55 PM
 * To change this template use File | Settings | File Templates.
 */
public interface AlertDao {

    Alert getAlertByName(String name);

    @Transactional
    void save(Alert alert);

    List<Alert> getStocksActiveAlerts();

    List<Alert> getAll();

    Alert getById(long id);
}
