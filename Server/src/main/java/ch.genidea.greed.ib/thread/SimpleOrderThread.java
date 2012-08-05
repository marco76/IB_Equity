package ch.genidea.greed.ib.thread;

import ch.genidea.greed.ib.bean.StockArrayRT;
import ch.genidea.greed.ib.maps.OrderMapService;
import ch.genidea.greed.ib.service.Connection;
import ch.genidea.greed.ib.service.PrepareAutomaticOrders;
import ch.genidea.greed.ib.wrapper.ContractGen;
import ch.genidea.greed.ib.wrapper.OrderGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: marcomolteni
 * Date: 09.07.11
 * Time: 14:39
 * To change this template use File | Settings | File Templates.
 */

public class SimpleOrderThread extends Thread{

    OrderMapService orderMapService;
    Connection connection;
     StockArrayRT stockArrayRT;
    ContractGen contractGen;

   public SimpleOrderThread(Connection connection, OrderMapService orderMapService, StockArrayRT stockArrayRT){
        this.orderMapService = orderMapService;
        this.connection = connection;
       this.stockArrayRT = stockArrayRT;

    }

    public void setOrderMapService (OrderMapService orderMapService){
        this.orderMapService = orderMapService;
    }

    public void setConnection (Connection connection){
        this.connection = connection;
    }

    public void run(){
        while(true){
        try {
            sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
       // System.out.println("Thread -> open orders :" + OrderMapService.countOpenOrders());
        if (OrderMapService.countOrdersActiveOnTheMarket() == 0){
              try {
                sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

            // the spread cannot be to big we don't want to overpay
            if (stockArrayRT.getAskBidSpread(contractGen.getId()) > 0.20){
                System.out.println("Send and order? Spread at : " +  stockArrayRT.getAskBidSpread(contractGen.getId()) );
                return;

            }

            OrderGen order = new OrderGen();
            order.prepareOrder();
            orderMapService.addOrder(order);

             connection.sendOrder(order.getOrderId(), contractGen, order);

        }
    }
    }

    public void setContractGen(ContractGen contractGen){
        this.contractGen = contractGen;
    }


}
