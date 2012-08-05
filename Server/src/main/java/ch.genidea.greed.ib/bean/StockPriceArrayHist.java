package ch.genidea.greed.ib.bean;

import ch.genidea.greed.ib.wrapper.ContractGen;
import com.ib.client.Contract;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: marcomolteni
 * Date: 10.07.11
 * Time: 13:02
 * To change this template use File | Settings | File Templates.
 */

@Component

public class StockPriceArrayHist {

        HashMap<Integer, LinkedList<Double>> priceList = new HashMap<Integer, LinkedList<Double>>(10);


        public synchronized void addPrice(Integer contractId, Double price){
            if (!priceList.containsKey(contractId)){
                priceList.put(contractId, new LinkedList<Double>());
            }

            LinkedList<Double> list = priceList.get(contractId);

            list.add(price);
            //System.out.println("StockPriceArray -> adding element");
            if (list.size() > 200){
                list.removeFirst();
            //System.out.println("StockPriceArray -> removing element");
            }
        }

        public Double[] getDoubleList(ContractGen contractGen){

            LinkedList list = priceList.get(contractGen.getId());
            if (list != null)
           //     Double[] doubleArray = Arrays.copyOf(list.toArray(), list.size(), Double[].class);

            return    Arrays.asList(list.toArray()).toArray(new Double[list.size()]);


            return null;
        }

    public LinkedList<Double> getLinkedList(ContractGen contractGen){
         LinkedList list = priceList.get(contractGen.getId());
            if (list != null)
           //     Double[] doubleArray = Arrays.copyOf(list.toArray(), list.size(), Double[].class);

            return list;


            return null;
    }
}
