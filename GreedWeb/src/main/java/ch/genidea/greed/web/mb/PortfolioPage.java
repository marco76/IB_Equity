package ch.genidea.greed.web.mb;

import ch.genidea.greed.ib.bean.PortfolioElement;
import ch.genidea.greed.ib.service.PortfolioService;
import ch.genidea.greed.web.vo.ListPortfolioVO;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
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
@ManagedBean(name="portfolioPage")
@SessionScoped
@Scope("request")
public class PortfolioPage implements Serializable {

    @ManagedProperty("#{portfolioService}")
    private PortfolioService portfolioService;

    List<PortfolioElement> portfolioElementList;
    List<ListPortfolioVO> portfolioVO;
    private PortfolioElement selectedElement;

    @PostConstruct
    public void init(){
        getAllPotfolioElements();
       }

    public List<ListPortfolioVO> getAllPotfolioElements(){
        portfolioVO = new ArrayList<ListPortfolioVO>();

        portfolioElementList = portfolioService.getAllPortfolioElements();
            for (PortfolioElement portfolioElement :portfolioElementList){
              ListPortfolioVO po = new ListPortfolioVO();
              po.setPortfolioElement(portfolioElement);
              portfolioVO.add(po);
        }
        return portfolioVO;
    }

    public String saveSelected(){
        portfolioService.savePortfolioElement(selectedElement);
        portfolioElementList = null;
        return "listPortfolio?faces-redirect=true";
    }

    public String editRecord(String ticker){
        selectedElement = portfolioService.getByTicker(ticker);
        return "editPortfolio";
    }

    public PortfolioService getPortfolioService() {
        return portfolioService;
    }

    public void setPortfolioService(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    public List<PortfolioElement> getPortfolioElementList() {
        return portfolioElementList;
    }

    public void setPortfolioElementList(List<PortfolioElement> portfolioElementList) {
        this.portfolioElementList = portfolioElementList;
    }

    public PortfolioElement getSelectedElement() {
        return selectedElement;
    }

    public void setSelectedElement(PortfolioElement selectedElement) {
        this.selectedElement = selectedElement;
    }
}
