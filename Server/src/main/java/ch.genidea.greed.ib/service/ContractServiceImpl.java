package ch.genidea.greed.ib.service;

import ch.genidea.greed.ib.bean.Equity;
import ch.genidea.greed.ib.wrapper.ContractGen;
import com.ib.client.ContractDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/14/12
 * Time: 4:05 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    Connection connection;
    @Autowired
    EquityQueryServiceImpl equityQueryService;
    @Autowired
    EquityService equityService;

    int nextOrderId;

    Map<Integer, ContractGen> contractsList = new HashMap();
    Map<String, ContractGen> contractsListByTicker = new HashMap<String, ContractGen>();
    Map<Integer, ContractGen> contractsListRT = new HashMap<Integer, ContractGen>();

    @Override
    public void updateContractList(ContractGen contractGen){
        contractsList.put((int)contractGen.getEquityID(), contractGen);
        contractsListByTicker.put(contractGen.getSymbol(), contractGen);
     //   initializeContractDetails(contractGen);
     }

    @Override
    public ContractGen getContract(Integer id){
        return contractsList.get(id);
    }

    @Override
    public ContractGen getContractRT(Integer id){
        return contractsListRT.get(id);
    }

    @Override
    public void initializeContractDetails(ContractGen contract){
       connection.requestContractDetails(contract);
      }

    @Override
    public void setContractDetails(Integer contractGenId, ContractDetails contractDetails){
      contractsList.get(contractGenId).setContractDetails(contractDetails);
    }

    @Override
    public void initializeRealTime(){
        List<Equity> equities = equityService.findAll();
        for (Equity equity : equities){
            // si dans RT mais pas dans la liste RT
            if (equity.getRealTime() == null)
                continue;
            if (equity.getRealTime() && !contractsListRT.containsKey((int)equity.getId())){
                contractsListRT.put((int)equity.getId(), contractsList.get((int)equity.getId()));
                equityQueryService.sendRealTimeQuotes(contractsList.get((int)equity.getId()), false, true);
            }
            // si pas dans RT mais dans la liste RT
            else if ((!equity.getRealTime() && contractsListRT.containsKey((int)equity.getId()))){
                contractsListRT.remove((int)equity.getId());
                equityQueryService.sendRealTimeQuotes(contractsList.get((int)equity.getId()), false, false);
            }
        }

    }

    @Override
    public void initializeContract(Equity equity){

        ContractGen contractGen = null;

        // verify is the equity is already in the list, in this case update
        if (contractsList.containsKey((int)equity.getId())){
             contractGen = contractsList.get((int)equity.getId());
        } else {
            contractGen = new ContractGen();
        }

        contractGen.setSymbol(equity.getTicker());
        contractGen.setEquityID(equity.getId());
        //contractGen.setId((int)equity.getId());
        updateContractList(contractGen);
    }

    @Override
    @Scheduled(fixedDelay = 60000)
    public void updateRTEquities(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -2);
        Date test = calendar.getTime();
       if (equityService.getLastUpdate().after(test)){
        List<Equity> equityList = equityService.getUpdatedEquities(test);
          for (Equity equity : equityList)  {
           System.out.println("update " + equity.getTicker());
              initializeContract(equity);
          }
          System.out.println("Update RT List");
          initializeRealTime();
        }

    }

    @Override
    public ContractGen getContractGenByTicker(String ticker){
        return contractsListByTicker.get(ticker);
    }

    @Override
    public int getNextOrderId() {
        return nextOrderId;
    }

    @Override
    public void setNextOrderId(int nextOrderId) {
        this.nextOrderId = nextOrderId;
    }
}
