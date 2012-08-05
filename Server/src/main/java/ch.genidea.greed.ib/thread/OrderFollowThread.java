package ch.genidea.greed.ib.thread;

import ch.genidea.greed.ib.bean.StockArrayRT;
import ch.genidea.greed.ib.maps.OrderMapService;
import ch.genidea.greed.ib.service.Connection;
import ch.genidea.greed.ib.service.PrepareAutomaticOrders;
import ch.genidea.greed.ib.wrapper.ContractGen;
import ch.genidea.greed.ib.wrapper.OrderGen;

import java.util.HashSet;

/**
 * Created by IntelliJ IDEA.
 * User: marcomolteni
 * Date: 09.07.11
 * Time: 17:15
 * To change this template use File | Settings | File Templates.
 */


/**
 * This class follow the behaviour of the stock price action in real time and apply some strategies
 * according to the prices changes
 */
public class OrderFollowThread extends  Thread{
    OrderMapService orderMapService;
    Connection connection;
    StockArrayRT prices;
    PrepareAutomaticOrders prepareAutomaticOrders;
    // put in a property
    private final boolean USING_TRAILING = false;

    public OrderFollowThread(Connection connection, OrderMapService orderMapService, StockArrayRT prices, PrepareAutomaticOrders prepareAutomaticOrders){
        this.orderMapService = orderMapService;
        this.connection = connection;
        this.prices = prices;
        this.prepareAutomaticOrders = prepareAutomaticOrders;
    }

    private void doFast(){
        // these order have been filled but they are still actives on the market
        HashSet<Integer> openOrders = OrderMapService.getOrdersActiveOnTheMarket();

        // we check the open stop orders to update if necessary

        //HashSet<Integer> openOrders = OrderMapService.getOpenOrders();

        for (Integer orderId : openOrders){
            OrderGen order = orderMapService.getOrder(orderId);
            ContractGen contract = order.getContract();

            // we retrieve the last price from the array
            double lastPrice = prices.getPrice(contract.getId(), StockArrayRT.BID);
            double lastBid = prices.getPrice(contract.getId(), StockArrayRT.BID);

            // info, how much is earning or losing
            double actualResult = order.getQuantity()*(lastPrice - order.getStatus().getAvgFillPrice());

            // @todo log this
            System.out.println("price : " + lastPrice);
            System.out.println("Temp result for: " + contract.getSymbol() + " : " + actualResult + "; stopLoss : " + order.getPriceStopLoss() + "; trailing stop loss : " + order.getPriceTrailingStart() + "; pr target: " + order.getPriceTarget() + "; pr break: " + order.getPriceToBreakEven() + "; tr dif: " + order.getPriceTrailingDistance());

            // This will be exported in a strategy
            if (USING_TRAILING){
                // last price launch a trigger
                if (lastBid > order.getPriceTrailingStart())
                {
                    // we are earning money, we want to be sure to don't lose everything we create stop loss order
                    System.out.println("Trying to create a stop loss order");
                     connection.sendOrder(orderId, order.getContract(), order);
                    //  at the moment it creates only 1 order, in the future it has to update the order
                   // prepareAutomaticOrders.prepareStopLossOrder(order);

            }


            }

            if (true){
                if (lastBid > order.getPriceTarget() && order.getClosingOrder() == null){
                    prepareAutomaticOrders.prepareStopLossOrder(order);
        }
            }




        }

    }

     public void run(){
        while(true){
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
             doFast();
        }

     }

}
