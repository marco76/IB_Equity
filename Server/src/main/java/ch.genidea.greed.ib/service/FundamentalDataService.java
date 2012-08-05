package ch.genidea.greed.ib.service;

import ch.genidea.greed.ib.wrapper.ContractGen;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 5/1/12
 * Time: 7:34 PM
 * To change this template use File | Settings | File Templates.
 */
public interface FundamentalDataService {
    void startFundamentals(ContractGen contractGen, String type);

    void cancelFundamentals(int id);
}
