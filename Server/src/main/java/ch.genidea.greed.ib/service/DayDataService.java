package ch.genidea.greed.ib.service;

import ch.genidea.greed.ib.bean.DayData;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/26/12
 * Time: 8:27 PM
 * To change this template use File | Settings | File Templates.
 */
public interface DayDataService {

    DayData getTodayDayData();

    void updateDayData(DayData dayData);

    List<DayData> getAll();

    DayData getById(Long id);
}
