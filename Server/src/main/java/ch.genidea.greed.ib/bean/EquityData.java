package ch.genidea.greed.ib.bean;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/14/12
 * Time: 10:11 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class EquityData {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private BigDecimal bid;
    private int bidSize;
    private BigDecimal ask;
    private int askSize;
    private BigDecimal last;
    private int lastSize;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal close;
    private BigDecimal open;
    private BigDecimal low13week;
    private BigDecimal high13week;
    private BigDecimal low52week;
    private BigDecimal high52week;
    private BigDecimal avgVolume;
    private BigDecimal markPrice;
    private Date lastTimestamp;

    @ManyToOne
    private Equity equity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getBid() {
        return bid;
    }

    public void setBid(BigDecimal bid) {
        this.bid = bid;
    }

    public int getBidSize() {
        return bidSize;
    }

    public void setBidSize(int bidSize) {
        this.bidSize = bidSize;
    }

    public BigDecimal getAsk() {
        return ask;
    }

    public void setAsk(BigDecimal ask) {
        this.ask = ask;
    }

    public int getAskSize() {
        return askSize;
    }

    public void setAskSize(int askSize) {
        this.askSize = askSize;
    }

    public BigDecimal getLast() {
        return last;
    }

    public void setLast(BigDecimal last) {
        this.last = last;
    }

    public int getLastSize() {
        return lastSize;
    }

    public void setLastSize(int lastSize) {
        this.lastSize = lastSize;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getClose() {
        return close;
    }

    public void setClose(BigDecimal close) {
        this.close = close;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public BigDecimal getLow13week() {
        return low13week;
    }

    public void setLow13week(BigDecimal low13week) {
        this.low13week = low13week;
    }

    public BigDecimal getHigh13week() {
        return high13week;
    }

    public void setHigh13week(BigDecimal high13week) {
        this.high13week = high13week;
    }

    public BigDecimal getLow52week() {
        return low52week;
    }

    public void setLow52week(BigDecimal low52week) {
        this.low52week = low52week;
    }

    public BigDecimal getHigh52week() {
        return high52week;
    }

    public void setHigh52week(BigDecimal high52week) {
        this.high52week = high52week;
    }

    public BigDecimal getAvgVolume() {
        return avgVolume;
    }

    public void setAvgVolume(BigDecimal avgVolume) {
        this.avgVolume = avgVolume;
    }

    public BigDecimal getMarkPrice() {
        return markPrice;
    }

    public void setMarkPrice(BigDecimal markPrice) {
        this.markPrice = markPrice;
    }

    public Date getLastTimestamp() {
        return lastTimestamp;
    }

    public void setLastTimestamp(Date lastTimestamp) {
        this.lastTimestamp = lastTimestamp;
    }

    public Equity getEquity() {
        return equity;
    }

    public void setEquity(Equity equity) {
        this.equity = equity;
    }
}
