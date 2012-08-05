package ch.genidea.greed.ib;

import ch.genidea.greed.ib.service.EquityQueryService;
import ch.genidea.greed.ib.service.MainService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * User: marcomolteni
 * Date: 18.06.11
 * Time: 00:52
 * To change this template use File | Settings | File Templates.
 */
public class MainNoJms {

    public static void main (String args[]){

        // load spring configuration
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("nojms-config.xml");

        // open the connection with interactive brokers
        EquityQueryService equityQueryService = (EquityQueryService)applicationContext.getBean("equityQueryServiceImpl");
        MainService mainService = (MainService)applicationContext.getBean("mainServiceImpl");

       mainService.initialiseConnection();


        mainService.initialiseRealTime();
        mainService.initialisePortfolio();
    }
}
