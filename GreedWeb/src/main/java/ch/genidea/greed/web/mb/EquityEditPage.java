package ch.genidea.greed.web.mb;

import ch.genidea.greed.ib.bean.Equity;
import ch.genidea.greed.ib.service.EquityService;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/1/12
 * Time: 7:59 PM
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean(name="equityEditPage")
@SessionScoped
@Scope("request")
public class EquityEditPage implements Serializable {

    @ManagedProperty("#{equityService}")
    private EquityService equityService;

    Equity equityNew = new Equity();
    Equity selectedEquity;
    List<Equity> allEquities;

    @PostConstruct
    public void init(){
       allEquities =  equityService.getFavourites();
    }


    public String saveNewEquity(){
        System.out.println("Trying to save equity");

       if (equityNew.getTicker() != null){
           // @todo equity New contain already the bean thanks to the converter
           equityNew.setFavourite(true);
           Equity equity = equityService.addFavoriteEquityAndInitialiseContract(equityNew);
           if (equity != null)
               equityNew = equity;
           else
               equityService.updateEquity(equityNew);
           allEquities = equityService.getFavourites();
           return "equityEdit";
       }
        return null;
    }
    public String saveSelectedEquity(){
        System.out.println("Trying to save equity");
     equityService.updateEquity(selectedEquity);
        allEquities = null;
        return "equityEdit";
    }

    public String editRecord(Long id){
      selectedEquity = equityService.getById(id);
        return "editEquity";
    }

    public List<Equity> getAllEquities(){
        return allEquities;
    }

    public EquityService getEquityService() {
        return equityService;
    }

    public void setEquityService(EquityService equityService) {
        this.equityService = equityService;
    }

    public Equity getEquityNew() {
        return equityNew;
    }

    public void setEquityNew(Equity equityNew) {
        this.equityNew = equityNew;
    }

    public Equity getSelectedEquity() {
        return selectedEquity;
    }

    public void setSelectedEquity(Equity selectedEquity) {
        this.selectedEquity = selectedEquity;
    }

    public List<Equity> getEquitiesStartingWith(String ticker){
        return equityService.getEquityStartingTickerWith(ticker, 10);
    }
}
