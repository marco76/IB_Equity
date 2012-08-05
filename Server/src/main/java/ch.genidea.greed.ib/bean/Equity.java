package ch.genidea.greed.ib.bean;

import org.hibernate.annotations.Index;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/14/12
 * Time: 6:00 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Equity {
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @Index(name="tickerIndex")
    private String ticker;
    private Boolean realTime;
    private Boolean monitorNewHigh;
    @Index(name="equityFav")
    private Boolean favourite;
    private double targetUp1 = -1d;
    private double targetDown1 = -1d;
    private String name;
    private Integer ipoYear;


    private Date updated;

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Boolean getRealTime() {
        return realTime;
    }

    public void setRealTime(Boolean realTime) {
        this.realTime = realTime;
    }

    public Boolean getMonitorNewHigh() {
        return monitorNewHigh;
    }

    public void setMonitorNewHigh(Boolean monitorNewHigh) {
        this.monitorNewHigh = monitorNewHigh;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public double getTargetUp1() {
        return targetUp1;
    }

    public void setTargetUp1(double targetUp1) {
        this.targetUp1 = targetUp1;
    }

    public double getTargetDown1() {
        return targetDown1;
    }

    public void setTargetDown1(double targetDown1) {
        this.targetDown1 = targetDown1;
    }

    public Boolean getFavourite() {
        return favourite;
    }

    public void setFavourite(Boolean favourite) {
        this.favourite = favourite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIpoYear() {
        return ipoYear;
    }

    public void setIpoYear(Integer ipoYear) {
        this.ipoYear = ipoYear;
    }
}
