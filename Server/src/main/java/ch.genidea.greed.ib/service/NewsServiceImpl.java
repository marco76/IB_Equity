package ch.genidea.greed.ib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 5/1/12
 * Time: 8:07 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    Connection connection;
    @Override
    public void startNews(boolean allDayMessages){
       connection.getMarketNews(allDayMessages);
    }

    @Override
    public void cancelNews(){
        connection.cancelMarketNews();
    }
}
