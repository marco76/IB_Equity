package ch.genidea.greed.ib.service;

import ch.genidea.greed.ib.bean.Comment;
import ch.genidea.greed.ib.bean.DayData;
import ch.genidea.greed.ib.dao.DayDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/26/12
 * Time: 8:27 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class DayDataServiceImpl implements DayDataService {
    @Autowired
    DayDataDao dayDataDao;
    @Override
    public DayData getTodayDayData(){
       Integer today = DateUtil.convertDateToInt(Calendar.getInstance().getTime());
       DayData todayData = dayDataDao.getDayByInt(today);
        if (todayData == null){
            todayData = new DayData();
            todayData.setDailyComment(new Comment());
            todayData.setDate(Calendar.getInstance().getTime());
            todayData.setDateInt(today);
            dayDataDao.save(todayData);
        }
        return todayData;
    }

    @Override
    public void updateDayData(DayData dayData){
        dayDataDao.save(dayData);
    }

    @Override
    public List<DayData> getAll(){
        return dayDataDao.getAll();
    }

    @Override
    public DayData getById(Long id){
        return dayDataDao.getById(id);
    }


}
