package ch.genidea.greed.ib.test.service;

import ch.genidea.greed.ib.service.AlertService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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
public class AlertServiceImplTest {
    @Resource
    AlertService alertService;

    @Test
    public void registerAccountInfo(){
        alertService.checkAlert();
    }


}
