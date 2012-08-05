package ch.genidea.greed.ib.maps;

import ch.genidea.greed.ib.wrapper.OrderGen;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by IntelliJ IDEA.
 * User: marcomolteni
 * Date: 09.07.11
 * Time: 12:30
 * To change this template use File | Settings | File Templates.
 */
@Service
public class OrderMapService {
    HashMap<Integer, OrderGen> orders = new HashMap<Integer, OrderGen>();

    public static HashSet<Integer> ordersActiveOnTheMarket = new HashSet<Integer>();
    public static HashSet<Integer> openOrders = new HashSet<Integer>();

    public void addOrder (OrderGen order){
        if (!orders.containsKey(order.getOrderId()))
          orders.put(order.getOrderId(), order);
    }

    public OrderGen getOrder(int orderId){
        return orders.get(orderId);
    }

    public static void addOpenOrder(Integer orderId){
        openOrders.add(orderId);
    }

    public static void closeOpenOrder(Integer orderId){
        openOrders.remove(orderId);
    }

    public static int countOpenOrders(){
        return openOrders.size();
    }

    public static HashSet<Integer> getOpenOrders(){
        return  openOrders;
    }

    public static HashSet<Integer> getOrdersActiveOnTheMarket(){
        return ordersActiveOnTheMarket;
    }

    public static void addActiveOrder(Integer orderId){
        ordersActiveOnTheMarket.add(orderId);
    }

    public static void closeActiveOrder(Integer orderId){
        ordersActiveOnTheMarket.remove(orderId);
    }

    public static int countOrdersActiveOnTheMarket(){
        return ordersActiveOnTheMarket.size();
    }


}
