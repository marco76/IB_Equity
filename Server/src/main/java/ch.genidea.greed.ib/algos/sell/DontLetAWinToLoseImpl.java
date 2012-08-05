package ch.genidea.greed.ib.algos.sell;

import ch.genidea.greed.ib.bean.Equity;
import ch.genidea.greed.ib.bean.PortfolioElementRT;
import ch.genidea.greed.ib.bean.PortfolioRT;
import ch.genidea.greed.ib.bean.StockArrayRT;
import ch.genidea.greed.ib.service.ContractService;
import com.ib.client.Contract;
import com.ib.client.Order;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/19/12
 * Time: 9:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class DontLetAWinToLoseImpl {

    @Autowired
    StockArrayRT stockArrayRT;
    @Autowired
    PortfolioRT portfolioRT;
    @Autowired
    ContractService contractService;
    /*
    Strategia : se un azione è in utile non è permesso perdere a meno che ci sia un gap iniziale
    1. quando l'azione comprata è a + 1%
    2. mettere uno stop loss a livello di prezzo originale
   */

    // store the Id of the entity and the price limit to send the order
    Map<Long, Double> priceLimits = new HashMap<Long, Double>();
    ArrayList<Long> stocksUnderSurveillance = new ArrayList<Long>();

    public void checkStockPrice(){
        List<Equity> equitiesInPortfolioToBeChecked = new ArrayList<Equity>();
        for(Equity equity : equitiesInPortfolioToBeChecked){
            double bid = stockArrayRT.getPrice(StockArrayRT.BID, (int)equity.getId());
            /*
            the price in the stock market is higher than the target price, a protection on
            the initial price should be added
            */
            if (!stocksUnderSurveillance.contains(equity.getId())){
                if (bid > priceLimits.get(equity.getId()).doubleValue()){
                    stocksUnderSurveillance.add(equity.getId());
                }
            }
         }
    }
    public void createOrder(int id){
        Contract contract = contractService.getContract(id);
        PortfolioElementRT element = portfolioRT.getPortfolioElementByTicker(contract.m_symbol);
        Order order = new Order();
        order.m_action = "SELL";
        order.m_totalQuantity = element.getPosition();
        order.m_orderType = "LMT";
        order.m_lmtPrice = element.getAverageCost();

    }

}
