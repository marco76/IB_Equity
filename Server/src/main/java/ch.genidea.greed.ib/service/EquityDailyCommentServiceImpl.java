package ch.genidea.greed.ib.service;

import ch.genidea.greed.ib.bean.Equity;
import ch.genidea.greed.ib.bean.EquityDailyComment;
import ch.genidea.greed.ib.dao.EquityDailyCommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/28/12
 * Time: 8:06 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class EquityDailyCommentServiceImpl implements EquityDailyCommentService {
    @Autowired
    EquityDailyCommentDao equityDailyCommentDao;

    @Override
    public void save(EquityDailyComment equityDailyComment){
         equityDailyCommentDao.save(equityDailyComment);
    }

    @Override
    public EquityDailyComment getByEquityAndDate(Equity equity, Integer dateInt){
       return equityDailyCommentDao.getByEquityAndDate(equity,dateInt);
    }

    @Override
    public EquityDailyComment getById(Long id){
        return equityDailyCommentDao.getById(id);
    }

    @Override
    public List<EquityDailyComment> getCommentsByEquityId(Long id){
        return equityDailyCommentDao.getCommentsByEntityId(id);

    }
}
