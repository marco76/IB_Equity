package ch.genidea.greed.ib;

import ch.genidea.greed.ib.service.Connection;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * User: marcomolteni
 * Date: 18.06.11
 * Time: 00:52
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main (String args[]){

        // load spring configuration
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");

        // open the connection with interactive brokers
        Connection connection = (Connection)applicationContext.getBean("connection");
        connection.connect();

        connection.requestAccountInfo(true);
    }
}
