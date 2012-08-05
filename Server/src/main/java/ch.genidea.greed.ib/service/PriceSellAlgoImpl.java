package ch.genidea.greed.ib.service;

import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: marcomolteni
 * Date: 09.07.11
 * Time: 11:55
 * To change this template use File | Settings | File Templates.
 */
@Service
public class PriceSellAlgoImpl implements PriceSellAlgo{
        public static double priceToSell(int quantity, double price, float transactionCost, float earningMultiCost){
            double expense = quantity * price + transactionCost;
            double earning = earningMultiCost * (transactionCost * 2) + expense;
            double sellPrice = earning / quantity;

            return sellPrice;
        }

    public static void main (String args[]){
        System.out.println(PriceSellAlgoImpl.priceToSell(100, 345.50f, 1, 3));
    }


}
