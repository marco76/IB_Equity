package ch.genidea.greed.ib.bean;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 3/30/12
 * Time: 5:51 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Alert {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String name;
    private BigDecimal limitMin;
    transient Boolean limitMinNotified;
    private BigDecimal limitUp;
    transient Boolean limitUpNotified;
    private String level;
    private String message;
    private String color;
    private Boolean notified = Boolean.FALSE;
    private Boolean toNotifyOnPhone = Boolean.TRUE;
    @ManyToOne
    private Equity equity;
    private String ticker;
    private Boolean active;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getLimitMin() {
        return limitMin;
    }

    public void setLimitMin(BigDecimal limitMin) {
        this.limitMin = limitMin;
    }

    public BigDecimal getLimitUp() {
        return limitUp;
    }

    public void setLimitUp(BigDecimal limitUp) {
        this.limitUp = limitUp;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getNotified() {
        if (notified == null)
            return Boolean.FALSE;

        return notified;
    }

    public void setNotified(Boolean notified) {
        this.notified = notified;
    }

    public Boolean getToNotifyOnPhone() {
        return toNotifyOnPhone;
    }

    public void setToNotifyOnPhone(Boolean toNotifyOnPhone) {
        this.toNotifyOnPhone = toNotifyOnPhone;
    }

    public Equity getEquity() {
        return equity;
    }

    public void setEquity(Equity equity) {
        this.equity = equity;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getLimitMinNotified() {
        return limitMinNotified;
    }

    public void setLimitMinNotified(Boolean limitMinNotified) {
        this.limitMinNotified = limitMinNotified;
    }

    public Boolean getLimitUpNotified() {
        return limitUpNotified;
    }

    public void setLimitUpNotified(Boolean limitUpNotified) {
        this.limitUpNotified = limitUpNotified;
    }
}
