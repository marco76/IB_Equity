package ch.genidea.greed.web.mb;

import ch.genidea.greed.ib.bean.DayData;
import ch.genidea.greed.ib.service.DayDataService;
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
@ManagedBean(name="dayDataPage")
@SessionScoped
@Scope("request")
public class DayDataPage implements Serializable {

    @ManagedProperty("#{dayDataService}")
    private DayDataService dayDataService;

    private DayData selectedDayData;
    List<DayData> allDayData;

    @PostConstruct
    public void init(){
        allDayData = dayDataService.getAll();

    }

    public DayDataService getDayDataService() {
        return dayDataService;
    }

    public void setDayDataService(DayDataService dayDataService) {
        this.dayDataService = dayDataService;
    }

    public List<DayData> getAllDayData() {
        return allDayData;
    }

    public void setAllDayData(List<DayData> allDayData) {
        this.allDayData = allDayData;
    }

    public String saveSelectedDayData(){
        dayDataService.updateDayData(selectedDayData);
        allDayData = dayDataService.getAll();
        return "listDayData";
    }

    public String editRecord(Long id){
        selectedDayData = dayDataService.getById(id);
        return "editDayData";
    }

    public DayData getSelectedDayData() {
        return selectedDayData;
    }

    public void setSelectedDayData(DayData selectedDayData) {
        this.selectedDayData = selectedDayData;
    }

    public String createTodayData(){
        selectedDayData = dayDataService.getTodayDayData();
        return "editDayData";
    }
}
