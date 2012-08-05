package ch.genidea.greed.ib.dao;

import ch.genidea.greed.ib.bean.DayData;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/26/12
 * Time: 8:28 PM
 * To change this template use File | Settings | File Templates.
 */
public interface DayDataDao {
    DayData getDayByInt(Integer day);

    @Transactional
    void save(DayData dayData);

    List getAll();

    DayData getById(Long id);
}
