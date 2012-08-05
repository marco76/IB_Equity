package ch.genidea.greed.web.vo;

import ch.genidea.greed.ib.bean.PortfolioElement;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/15/12
 * Time: 12:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class ListPortfolioVO {
    private PortfolioElement portfolioElement;

    public PortfolioElement getPortfolioElement() {
        return portfolioElement;
    }

    public void setPortfolioElement(PortfolioElement portfolioElement) {
        this.portfolioElement = portfolioElement;
    }

    public BigDecimal getAverageCost(){
        return new BigDecimal(portfolioElement.getAverageCost()).setScale(2,RoundingMode.HALF_EVEN);
    }
    public BigDecimal getPrice(){
        return new BigDecimal(portfolioElement.getMarketPrice()).setScale(2,RoundingMode.HALF_EVEN);
    }

    public BigDecimal getEarning(){
        return new BigDecimal(portfolioElement.getUnrealizedPNL()/portfolioElement.getMarketValue()*100).setScale(2, RoundingMode.HALF_EVEN);
    }
}
