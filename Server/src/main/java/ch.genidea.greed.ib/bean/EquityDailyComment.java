package ch.genidea.greed.ib.bean;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/28/12
 * Time: 7:56 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@IdClass(EquityDailyCommentKey.class)
public class EquityDailyComment {

   @Id private Long equityId;

    @ManyToOne
    private Equity equity;
    @Id
    private Integer dateInt;
    private String pictureName1;
    private String pictureName2;
    private String pictureName3;
    @Column(columnDefinition = "TEXT")
    private String comment1;
    @Column(columnDefinition = "TEXT")
    private String comment2;
    @Column(columnDefinition = "TEXT")
    private String comment3;



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

    public String getPictureName1() {
        return pictureName1;
    }

    public void setPictureName1(String pictureName1) {
        this.pictureName1 = pictureName1;
    }

    public String getPictureName2() {
        return pictureName2;
    }

    public void setPictureName2(String pictureName2) {
        this.pictureName2 = pictureName2;
    }

    public String getPictureName3() {
        return pictureName3;
    }

    public void setPictureName3(String pictureName3) {
        this.pictureName3 = pictureName3;
    }

    public String getComment1() {
        return comment1;
    }

    public void setComment1(String comment1) {
        this.comment1 = comment1;
    }

    public String getComment2() {
        return comment2;
    }

    public void setComment2(String comment2) {
        this.comment2 = comment2;
    }

    public String getComment3() {
        return comment3;
    }

    public void setComment3(String comment3) {
        this.comment3 = comment3;
    }

    public Long getEquityId() {
        return equityId;
    }

    public void setEquityId(Long equityId) {
        this.equityId = equityId;
    }
}
