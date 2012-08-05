package ch.genidea.greed.ib.test.service;

import ch.genidea.greed.ib.service.Connection;
import ch.genidea.greed.ib.service.NewsService;
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
public class NewsTest {
    @Resource
    Connection connection;
    @Resource
    NewsService newsService;

    @Test
    public void getMarketNews(){
        connection.connect();
        //connection.requestAccountInfo(true);
        newsService.startNews(true);
         newsService.cancelNews();
    }



}
