package ch.genidea.greed.ib.dao;

import ch.genidea.greed.ib.bean.Equity;
import ch.genidea.greed.ib.bean.EquityDailyComment;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/28/12
 * Time: 8:06 PM
 * To change this template use File | Settings | File Templates.
 */
public interface EquityDailyCommentDao {
    @Transactional
    void save(EquityDailyComment equityDailyComment);

    @Transactional(readOnly = true)
    EquityDailyComment getByEquityAndDate(Equity equity, Integer dateInt);

    @Transactional(readOnly = true)
    EquityDailyComment getById(Long id);

    @Transactional(readOnly = true)
    List<EquityDailyComment> getCommentsByEntityId(Long id);
}
