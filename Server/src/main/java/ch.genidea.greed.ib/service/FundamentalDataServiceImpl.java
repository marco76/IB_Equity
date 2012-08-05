package ch.genidea.greed.ib.service;

import ch.genidea.greed.ib.wrapper.ContractGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 5/1/12
 * Time: 7:34 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class FundamentalDataServiceImpl implements FundamentalDataService {
    @Autowired
    Connection connection;

    @Override
    public void startFundamentals(ContractGen contractGen, String type){
        connection.startFundamentalData(contractGen.getId(), contractGen, type.toString());

    }

    @Override
    public void cancelFundamentals(int id){
        connection.cancelFundamentalData(id);
    }
}
