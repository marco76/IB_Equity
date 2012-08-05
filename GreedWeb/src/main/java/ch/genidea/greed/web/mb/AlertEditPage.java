package ch.genidea.greed.web.mb;

import ch.genidea.greed.ib.bean.Alert;
import ch.genidea.greed.ib.service.AlertService;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/1/12
 * Time: 7:59 PM
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean(name="alertEditPage")
@SessionScoped
@Scope("request")
public class AlertEditPage {

    @ManagedProperty("#{alertService}")
    private AlertService alertService;

    List<Alert> alerts;
    Alert alertNew;
    @PostConstruct
    public void init(){
        alerts = alertService.getAlerts();
        alertNew = new Alert();
    }


    public String saveNewAlert(){
        System.out.println("Trying to save alert");

       if (alertNew.getName() != null){
           alertService.register(alertNew);
           System.out.println("saved alert new: " + alertNew.getName());
           init();
           alertNew = new Alert();
       }
        return "alertEdit";
    }

    public String editSelected(Long id){
        alertNew = alertService.getById(id);
        return "alertEdit";
    }

    public String resetAlert(){
        alertNew = new Alert();
        return "alertEdit";
    }

    public Alert getAlertNew() {
        return alertNew;
    }

    public void setAlertNew(Alert alertNew) {
        this.alertNew = alertNew;
    }

    public AlertService getAlertService() {
        return alertService;
    }

    public void setAlertService(AlertService alertService) {
        this.alertService = alertService;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Alert> alerts) {
        this.alerts = alerts;
    }
}
