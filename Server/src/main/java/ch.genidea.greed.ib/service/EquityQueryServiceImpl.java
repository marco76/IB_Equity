package ch.genidea.greed.ib.service;

import ch.genidea.greed.ib.bean.StockArrayRT;
import ch.genidea.greed.ib.wrapper.ContractGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: marcomolteni
 * Date: 19.06.11
 * Time: 18:31
 * To change this template use File | Settings | File Templates.
 */
@Service
public class EquityQueryServiceImpl implements EquityQueryService{
    @Autowired
    Connection connection;
    @Autowired
    ContractService contractService;
    @Autowired
    StockArrayRT stockArrayRT;

    Map<String, Integer> openTickerList = new HashMap<String, Integer>();
    Map<Integer, String> openTickerById = new HashMap<Integer, String>();
    @Override
    public void sendRealTimeQuotes(Integer requestId, String symbol, boolean snapshot, boolean realTime){
       ContractGen contract = new ContractGen();
       contract.setId(requestId);
       contract.setSymbol(symbol);
       sendRealTimeQuotes(contract, snapshot, realTime);
   }
    public void sendRealTimeQuotes(ContractGen contract, boolean snapshot, boolean realTime){
       // stockArrayRT.getNextSlot(contract.getId());

        if (snapshot){
            connection.requestMktData(contract, true);
        } else if (realTime){
      //      if (openTickerById.containsKey(contract.getId()) || openTickerList.containsKey(contract.getSymbol()))
      //           return;

            connection.requestMktData(contract, false);
        //    openTickerById.put(contract.getId(), contract.getSymbol());
        //    openTickerList.put(contract.getSymbol(),contract.getId());
        } else {

            connection.cancelMktData(contract);
        //    openTickerById.remove(contract.getId());
        //    openTickerById.remove(contract.getSymbol());
        }
    }
    @Override
    public void closeAllRTConnections(){
        Set<Integer> keys = openTickerById.keySet();
        for (Integer key :keys){
            ContractGen contract = new ContractGen();
            contract.setId(key);
            contract.setSymbol(openTickerById.get(key));
            connection.cancelMktData(contract);
        }
        openTickerById.clear();
        openTickerList.clear();
    }




}
