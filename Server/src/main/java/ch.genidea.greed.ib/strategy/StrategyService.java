package ch.genidea.greed.ib.strategy;

import ch.genidea.greed.ib.wrapper.ContractGen;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/21/12
 * Time: 6:51 PM
 * To change this template use File | Settings | File Templates.
 */
public interface StrategyService {
    void addStrategy(ContractGen contractGen, Strategy strategy);


    Strategy getStrategy(ContractGen contractGen);

    void linkStrategy(ContractGen contractGen, String strategy);

    void checkPriceAction(int contractId, double price, int field);

    Strategy getStrategyByContractGenEquityId(ContractGen contractGen);
}
