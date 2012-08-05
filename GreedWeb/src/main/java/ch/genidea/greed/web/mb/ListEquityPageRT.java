package ch.genidea.greed.web.mb;

import ch.genidea.greed.ib.bean.Equity;
import ch.genidea.greed.ib.bean.EquityData;
import ch.genidea.greed.ib.service.EquityService;
import ch.genidea.greed.web.vo.ListEquityVO;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/1/12
 * Time: 7:59 PM
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean(name="listEquityPageRT")
@RequestScoped
@Scope("request")
public class ListEquityPageRT implements Serializable {

    @ManagedProperty("#{equityService}")
    private EquityService equityService;

    List<Equity> allEquities;
    List<ListEquityVO> equities;

    @PostConstruct
    public void init(){
        equities = new ArrayList<ListEquityVO>();
        allEquities = equityService.getRealTimeEquities();
        for (Equity equity : allEquities){
          EquityData data = equityService.getLastDataForEquity(equity);
          ListEquityVO equityVO = new ListEquityVO();
            equityVO.setEquity(equity);
            equityVO.setEquityData(data);
          equities.add(equityVO);
        }
    }

    public List<Equity> getAllEquities(){
        if (allEquities == null){
            allEquities = equityService.getFavourites();
        }
        return allEquities;
    }

    public EquityService getEquityService() {
        return equityService;
    }

    public void setEquityService(EquityService equityService) {
        this.equityService = equityService;
    }

    public List<ListEquityVO> getEquities() {
        return equities;
    }

    public void setEquities(List<ListEquityVO> equities) {
        this.equities = equities;
    }
}
