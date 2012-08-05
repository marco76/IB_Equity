package ch.genidea.greed.ib.test.service;

import ch.genidea.greed.ib.constants.FundamentalDataConstants;
import ch.genidea.greed.ib.service.Connection;
import ch.genidea.greed.ib.service.ContractService;
import ch.genidea.greed.ib.service.FundamentalDataService;
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
public class FundamentalsTest {
    @Resource
    Connection connection;
    
    @Resource
    ContractService contractService;
    @Resource
    FundamentalDataService fundamentalDataService;

    @Test
    public void getFundamentalData(){
        connection.connect();
        //connection.requestAccountInfo(true);
        ContractGen contract = new ContractGen();
        contract.setSymbol("WYNN");
        contractService.updateContractList(contract);
       // equityQueryService.sendRealTimeQuotes(contract, false, true);
        //contractService.initializeContractDetails(contract);

        fundamentalDataService.startFundamentals(contract, FundamentalDataConstants.REPORT_TYPE.FINANCIAL_STATEMENTS.toString());
        for (int i = 0; i < 1000000000l; i++){
            // do nothing
        }
        fundamentalDataService.cancelFundamentals(contract.getId());
    }



}
