package ch.genidea.greed.ib.service;

import ch.genidea.greed.ib.maps.OrderMapService;
import ch.genidea.greed.ib.wrapper.OrderGen;
import com.ib.client.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by IntelliJ IDEA.
 * User: marcomolteni
 * Date: 09.07.11
 * Time: 12:58
 * To change this template use File | Settings | File Templates.
 */
@Service
public class PrepareAutomaticOrders {

    @Autowired
    OrderMapService orderMapService;
    @Autowired
    Connection connection;

    public static int nextOrderIdFromIB;
    private static HashSet<Integer> openOrders = new HashSet<Integer>(10);
    private final int EARNING_MULTIPLIER = 4;
    private final int PRICE_ONE_WAY = 1;

    /**
     * Prepare statistics for the order just filled, a Thread will check constantly if there are some trigger prices.
     * In this case a children order will be created
     * This is due because IB don't accept easily to change the type of the order.
     *
     * @param orderGen
     */

    public void fillStatisticsForOpenOrder(OrderGen orderGen){
  //      public OrderGen(OrderAction action, int quantity, OrderType type, float price, OrderObjective objective){
        if (!openOrders.contains(orderGen.getOrderId()))
            return;
        openOrders.remove(orderGen.getOrderId());

        // close price target
        double closePrice = PriceSellAlgoImpl.priceToSell(orderGen.getQuantity(), orderGen.getStatus().getAvgFillPrice(), PRICE_ONE_WAY, EARNING_MULTIPLIER);
        // OrderGen closeOrderGen = new OrderGen(OrderGen.OrderAction.SELL, orderGen.getQuantity(), OrderGen.OrderType.LMT, closePrice, OrderGen.OrderObjective.CLOSE_AUTOMATIC_POSITION);
        orderGen.setPriceTarget(closePrice);

        // STOP LOSS
        double stopLoss = orderGen.getStatus().getAvgFillPrice() - (orderGen.getQuantity() / orderGen.getMaxMonetaryLoss());

        orderGen.setPriceStopLoss(stopLoss);
        orderGen.setMaxOpenMinutes(100);
        orderGen.setPriceToBreakEven(orderGen.getStatus().getAvgFillPrice() + ((PRICE_ONE_WAY * 2)/orderGen.getQuantity()));
        orderGen.setPriceTrailingStart((orderGen.getPriceTarget() + orderGen.getPriceToBreakEven()) / 2);
    }


    public void prepareCloseAutomaticOrder(OrderGen orderGen){
  //      public OrderGen(OrderAction action, int quantity, OrderType type, float price, OrderObjective objective){
        if (!openOrders.contains(orderGen.getOrderId()))
            return;
        openOrders.remove(orderGen.getOrderId());

        double closePrice = PriceSellAlgoImpl.priceToSell(orderGen.getQuantity(), orderGen.getStatus().getAvgFillPrice(), PRICE_ONE_WAY, EARNING_MULTIPLIER);
        OrderGen closeOrderGen = new OrderGen(OrderGen.OrderAction.SELL, orderGen.getQuantity(), OrderGen.OrderType.LMT, closePrice,0, OrderGen.OrderObjective.CLOSE_AUTOMATIC_POSITION);
        closeOrderGen.setPriceTarget(closePrice);

        // STOP LOSS
        double stopLoss = orderGen.getStatus().getAvgFillPrice() - (orderGen.getQuantity() / orderGen.getMaxMonetaryLoss());

        closeOrderGen.setPriceStopLoss(stopLoss);
        closeOrderGen.setParentPrice(orderGen.getStatus().getAvgFillPrice());
        closeOrderGen.setMaxOpenMinutes(100);
        closeOrderGen.setPriceToBreakEven(orderGen.getStatus().getAvgFillPrice() + ((PRICE_ONE_WAY * 2)/orderGen.getQuantity()));
        closeOrderGen.setPriceTrailingStart((closeOrderGen.getPriceTarget() + closeOrderGen.getPriceToBreakEven()) / 2);

        closeOrderGen.setOrderParentId(orderGen.getOrderId());
        closeOrderGen.prepareOrder();
        orderMapService.addOrder(closeOrderGen);
        OrderMapService.addOpenOrder(closeOrderGen.getOrderId());

        connection.sendOrder(closeOrderGen.getOrderId(), orderGen.getContract(), closeOrderGen);

    }

    public void prepareTrailStopOrder(OrderGen orderGen){

     }

    public void prepareStopLossOrder(OrderGen orderGen){
        /**
         * We need
         * quantity
         * orderType
         * limit price
         * aux price for the stop
         */


        // this create a stop loss at the break even, the limit is de facto the actual price???

        double trailingStopRounded = Math.floor(orderGen.getPriceTrailingStart()*100)/100;
        OrderGen closeOrderGen = new OrderGen(OrderGen.OrderAction.SELL, orderGen.getQuantity(), OrderGen.OrderType.STPLMT, orderGen.getPriceToBreakEven(), orderGen.getPriceToBreakEven(), OrderGen.OrderObjective.CLOSE_AUTOMATIC_POSITION);
        closeOrderGen.setParentPrice(orderGen.getStatus().getAvgFillPrice());
        closeOrderGen.setOrderParentId(orderGen.getOrderId());
        closeOrderGen.prepareOrder();
        orderMapService.addOrder(closeOrderGen);
        OrderMapService.addOpenOrder(closeOrderGen.getOrderId());
        orderGen.setClosingOrder(closeOrderGen);
        connection.sendOrder(closeOrderGen.getOrderId(), orderGen.getContract(), closeOrderGen);

    }

    public static void addOpenOrder(Integer orderId){

        openOrders.add(orderId);

    }

    public static void closeOpenOrder(Integer orderId){
        openOrders.remove(orderId);
    }

    public static boolean canSendNewOrder(){
        if (openOrders.size() == 0)
            return true;
        return false;
    }
}
