package ch.genidea.greed.ib;

import ch.genidea.greed.ib.wrapper.ContractGen;
import com.ib.client.Contract;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: marcomolteni
 * Date: 18.06.11
 * Time: 02:33
 * To change this template use File | Settings | File Templates.
 */
public class WatchListRealTime {
    Map <Integer, ContractGen> listByTickerId= new HashMap();

    public void add(Integer id, ContractGen contract){
        listByTickerId.put(id, contract);
    }

    public Contract getContractByMarketDataId(Integer id){
        return listByTickerId.get(id);
    }


}
