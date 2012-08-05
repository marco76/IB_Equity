package ch.genidea.greed.web.vo;

import ch.genidea.greed.ib.bean.Equity;
import ch.genidea.greed.ib.bean.EquityData;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/15/12
 * Time: 12:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class ListEquityVO {
    private Equity equity;
    private EquityData equityData;

    public Equity getEquity() {
        return equity;
    }

    public void setEquity(Equity equity) {
        this.equity = equity;
    }

    public EquityData getEquityData() {
        return equityData;
    }

    public void setEquityData(EquityData equityData) {
        this.equityData = equityData;
    }

    public boolean isTargetUpReached(){
        if (equity.getTargetUp1() > 0d){
            if (equity.getTargetUp1() < equityData.getBid().doubleValue()){
                return true;
            }

        }
        return false;
    }


    public boolean isTargetDownReached(){
        if (equity.getTargetDown1() > 0d){
            if (equity.getTargetDown1() > equityData.getAsk().doubleValue()){
                return true;
            }

        }
        return false;
    }


        public String getRowStyle() {
            if (isTargetUpReached())
                return "green";
            if (isTargetDownReached())
                return "red";
            return "";
        }

    public BigDecimal getPercentRangeDay(){
        BigDecimal result = new BigDecimal(0l);
        try{
            result = (this.getEquityData().getLast().subtract(this.getEquityData().getLow())).divide(this.getEquityData().getHigh().subtract(this.getEquityData().getLow())).setScale(2, RoundingMode.HALF_EVEN).multiply(new BigDecimal("100"));
        } catch(java.lang.ArithmeticException e){

        }
        return result;
    }


}
