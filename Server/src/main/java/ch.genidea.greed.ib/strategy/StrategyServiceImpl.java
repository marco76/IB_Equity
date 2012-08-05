package ch.genidea.greed.ib.strategy;

import ch.genidea.greed.ib.service.Connection;
import ch.genidea.greed.ib.wrapper.ContractGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/21/12
 * Time: 6:52 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class StrategyServiceImpl implements StrategyService {
    @Autowired
    Connection connection;
    private Map <ContractGen, Strategy> activeStrategies = new HashMap<ContractGen, Strategy>();
    private Map <Integer, Strategy> activeStrategiesByContractId = new HashMap<Integer, Strategy>();

    /*
       Each time a price arrive we check if some rules have to be activated
     */

    @Override
    public void checkPriceAction(int contractId, double price, int field){
          Strategy strategy = activeStrategiesByContractId.get(contractId);
        if (strategy != null){
            strategy.checkRealTimePrices(price, field);
        }

    }

    @Override
    public void addStrategy(ContractGen contractGen, Strategy strategy){
        activeStrategies.put(contractGen, strategy);
        activeStrategiesByContractId.put(contractGen.getEquityID(), strategy);
    }

    @Override
    public Strategy getStrategy(ContractGen portfolioElement){
        return activeStrategies.get(activeStrategies.get(portfolioElement));
    }

    @Override
    public Strategy getStrategyByContractGenEquityId(ContractGen contractGen){
        return activeStrategiesByContractId.get(contractGen.getEquityID());
    }

    @Override
    public void linkStrategy(ContractGen contractGen, String strategy){
        if (strategy.equalsIgnoreCase("DontAllowWinToLose")){
            Strategy strategyImplemented = new StrategyDontAllowWinToLose(contractGen,connection );
            this.addStrategy(contractGen, strategyImplemented);
        }
    }
}
