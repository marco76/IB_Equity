package ch.genidea.greed.ib.service;

import ch.genidea.greed.ib.bean.Equity;
import ch.genidea.greed.ib.bean.EquityDailyComment;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/28/12
 * Time: 8:05 PM
 * To change this template use File | Settings | File Templates.
 */
public interface EquityDailyCommentService {
    void save(EquityDailyComment equityDailyComment);

    EquityDailyComment getByEquityAndDate(Equity equity, Integer dateInt);

    EquityDailyComment getById(Long id);

    List<EquityDailyComment> getCommentsByEquityId(Long id);
}
