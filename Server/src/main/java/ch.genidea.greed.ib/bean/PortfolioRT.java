package ch.genidea.greed.ib.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/14/12
 * Time: 12:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class PortfolioRT {

    Map<String, PortfolioElementRT> portfolioMap = new HashMap<String, PortfolioElementRT>();


    public void updateElement(PortfolioElementRT portfolioElementRT){
        if (portfolioMap.containsKey(portfolioElementRT.getContract().m_conId)) {
            portfolioMap.put(portfolioElementRT.getContract().m_symbol, portfolioElementRT);
        } else {
            portfolioMap.put(portfolioElementRT.getContract().m_symbol, portfolioElementRT);
        }
    }

    public void resetPortfolio(){
        portfolioMap.clear();
    }

    public Map<String, PortfolioElementRT> getPortfolioMap() {
        return portfolioMap;
    }

    public void setPortfolioMap(Map<String, PortfolioElementRT> portfolioMap) {
        this.portfolioMap = portfolioMap;
    }

    public PortfolioElementRT getPortfolioElementByTicker(String ticker){
        return portfolioMap.get(ticker);
    }
}


