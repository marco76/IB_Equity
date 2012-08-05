package ch.genidea.greed.ib.test.service;

import ch.genidea.greed.ib.bean.Equity;
import ch.genidea.greed.ib.bean.EquityData;
import ch.genidea.greed.ib.service.EquityService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 3/24/12
 * Time: 5:07 PM
 * To change this template use File | Settings | File Templates.
 */
@TransactionConfiguration
@ContextConfiguration({"classpath:nojms-config.xml"})
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
public class EquityDataPersistenceTest {
    @Resource
    EquityService equityService;

    @Test
    public void registerEquityService(){
       Equity equity = equityService.getById(2l);
        EquityData equityData = new EquityData();
        equityData.setEquity(equity);
        equityData.setLast(new BigDecimal("111.11"));
        equityService.saveEquityData(equity, equityData);
        List<EquityData> data = equityService.getDataForEquity(equity);
        Assert.assertTrue("There should be at least 1  records ", 1 <= data.size());

    }

    @Test
    public void getLastDataForEquity(){
        EquityData data = equityService.getLastDataForEquity(equityService.getById(2l));
        Assert.assertNotNull(data);
    }


}
