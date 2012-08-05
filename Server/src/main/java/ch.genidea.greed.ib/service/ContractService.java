package ch.genidea.greed.ib.service;

import ch.genidea.greed.ib.bean.Equity;
import ch.genidea.greed.ib.wrapper.ContractGen;
import com.ib.client.ContractDetails;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/14/12
 * Time: 4:05 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ContractService {
    void updateContractList(ContractGen contractGen);

    ContractGen getContract(Integer id);

    void initializeContractDetails(ContractGen contract);

    void setContractDetails(Integer contractGenId, ContractDetails contractDetails);

    void initializeRealTime();

    @Scheduled(fixedDelay = 60000)
    void updateRTEquities();

    ContractGen getContractRT(Integer id);

    void initializeContract(Equity equity);

    ContractGen getContractGenByTicker(String ticker);

    int getNextOrderId();

    void setNextOrderId(int nextOrderId);
}
