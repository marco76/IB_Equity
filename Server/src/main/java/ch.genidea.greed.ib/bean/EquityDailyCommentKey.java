package ch.genidea.greed.ib.bean;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/28/12
 * Time: 9:35 PM
 * To change this template use File | Settings | File Templates.
 */

public class EquityDailyCommentKey implements Serializable {
    private Long equityId;
    private Integer dateInt;

    public EquityDailyCommentKey(){}
    public EquityDailyCommentKey(Long equityId, Integer dateInt){
        this.equityId = equityId;
        this.dateInt = dateInt;
    }

    public Long getEquityId() {
        return equityId;
    }

    public void setEquityId(Long equityId) {
        this.equityId = equityId;
    }

    public Integer getDateInt() {
        return dateInt;
    }

    public void setDateInt(Integer dateInt) {
        this.dateInt = dateInt;
    }
}
