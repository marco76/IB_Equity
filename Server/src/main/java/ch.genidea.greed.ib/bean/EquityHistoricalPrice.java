package ch.genidea.greed.ib.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/29/12
 * Time: 10:23 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@IdClass(EquityDailyCommentKey.class)
public class EquityHistoricalPrice {
    @Id
    private Long equityId;
    @ManyToOne
    private Equity equity;
    @Id
    private Integer dateInt;

    private Date date;

    private double open;
    private double high;
    private double low;
    private double close;
    private long volume;
    private double adjClose;

    public EquityHistoricalPrice(){};

    public EquityHistoricalPrice(Long equityId, Integer dateInt){
        this.equityId = equityId;
        this.dateInt = dateInt;
    }

    public Long getEquityId() {
        return equityId;
    }

    public void setEquityId(Long equityId) {
        this.equityId = equityId;
    }

    public Equity getEquity() {
        return equity;
    }

    public void setEquity(Equity equity) {
        this.equity = equity;
    }

    public Integer getDateInt() {
        return dateInt;
    }

    public void setDateInt(Integer dateInt) {
        this.dateInt = dateInt;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public double getAdjClose() {
        return adjClose;
    }

    public void setAdjClose(double adjClose) {
        this.adjClose = adjClose;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
