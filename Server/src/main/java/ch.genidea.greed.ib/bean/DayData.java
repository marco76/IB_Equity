package ch.genidea.greed.ib.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/26/12
 * Time: 8:06 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class DayData {
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;
    Date date;
    Integer dateInt;
    @ManyToOne (cascade = CascadeType.ALL)
    Comment dailyComment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getDateInt() {
        return dateInt;
    }

    public void setDateInt(Integer dateInt) {
        this.dateInt = dateInt;
    }

    public Comment getDailyComment() {
        return dailyComment;
    }

    public void setDailyComment(Comment dailyComment) {
        this.dailyComment = dailyComment;
    }
}
