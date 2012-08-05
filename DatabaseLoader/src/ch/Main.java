package ch;

import ch.genidea.greed.db.loader.Loader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * User: marcomolteni
 * Date: 22.06.11
 * Time: 22:16
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Loader loader = (Loader) context.getBean("loader");

        loader.loadWebPage(2011,1,1,2011,6,21);
    }
}
