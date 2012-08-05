package ch.genidea.greed.ib.test.service;

import ch.genidea.greed.ib.service.Connection;
import ch.genidea.greed.ib.service.ContractService;
import ch.genidea.greed.ib.service.EquityQueryService;
import ch.genidea.greed.ib.wrapper.ContractGen;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 3/24/12
 * Time: 5:07 PM
 * To change this template use File | Settings | File Templates.
 */

@ContextConfiguration({"classpath:nojms-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class QuoteTest {
    @Resource
    Connection connection;
    @Resource
    EquityQueryService equityQueryService;
    @Resource
    ContractService contractService;


    @Test
    public void registerAccountInfo(){
        connection.connect();
        //connection.requestAccountInfo(true);
        ContractGen contract = new ContractGen();
        contract.setSymbol("TVIX");
        contractService.updateContractList(contract);
       // equityQueryService.sendRealTimeQuotes(contract, false, true);
        //contractService.initializeContractDetails(contract);
        for (int i = 0; i < 1000000000l; i++){
            // do nothing
        }
    }



}
