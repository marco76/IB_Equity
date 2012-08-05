package ch.genidea.greed.ib.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: marcomolteni
 * Date: 13.11.11
 * Time: 17:42
 * To change this template use File | Settings | File Templates.
 */

@Entity
public class AccountInfo {
    @Id
    private long id;

    private String code = null;
    private Boolean ready = null;
    private String  type = null;
    private BigDecimal cashBase = new BigDecimal(0);
    private BigDecimal cash = new BigDecimal(0);
    private BigDecimal accruedCashBase = new BigDecimal(0);
    private BigDecimal accruedCash = new BigDecimal(0);
    private BigDecimal accruedCashC = new BigDecimal(0);
    private BigDecimal accruedCashS = new BigDecimal(0);
    private BigDecimal accruedDividend = new BigDecimal(0);
    private BigDecimal accrueddividendC = new BigDecimal(0);
    private BigDecimal accruedDividendS = new BigDecimal(0);
    private BigDecimal availableFunds = new BigDecimal(0);
    private BigDecimal availableFundsC = new BigDecimal(0);
    private BigDecimal availableFundsS = new BigDecimal(0);
    private BigDecimal billable = new BigDecimal(0);
    private BigDecimal billableC = new BigDecimal(0);
    private BigDecimal billableS = new BigDecimal(0);
    private BigDecimal buyingPower = new BigDecimal(0);
    private BigDecimal cashBalance = new BigDecimal(0);
    private BigDecimal cashBalanceBase = new BigDecimal(0);
    private BigDecimal cushion = new BigDecimal(0);
    private Integer dayTradesRemaining = new Integer(-1);
    private Integer dayTradesRemaining1 = new Integer(-1);
    private Integer dayTradesRemaining2 = new Integer(-1);
    private Integer dayTradesRemaining3 = new Integer(-1);
    private Integer dayTradesRemaining4 = new Integer(-1);
    private BigDecimal equityWithLoanValue = new BigDecimal(0);
    private BigDecimal equityWithLoanValueC = new BigDecimal(0);
    private BigDecimal equityWithLoanValueS = new BigDecimal(0);
    private BigDecimal excessLiquidity = new BigDecimal(0);
    private BigDecimal excessLiquidityC = new BigDecimal(0);
    private BigDecimal excessLiquidityS = new BigDecimal(0);
    private BigDecimal exchangeRate = new BigDecimal(0);
    private BigDecimal exchangeRateBase = new BigDecimal(0);
    private BigDecimal fullAvailableFunds = new BigDecimal(0);
    private BigDecimal fullAvailableFundsC = new BigDecimal(0);
    private BigDecimal fullAvailableFundsS = new BigDecimal(0);
    private BigDecimal fullAvailableLiquidity = new BigDecimal(0);
    private BigDecimal fullAvailableLiquidityC = new BigDecimal(0);
    private BigDecimal fullAvailableLiquidityS = new BigDecimal(0);
    private BigDecimal fullExcessLiquidity = new BigDecimal(0);
    private BigDecimal fullExcessLiquidityC = new BigDecimal(0);
    private BigDecimal fullExcessLiquidityS = new BigDecimal(0);
    private BigDecimal fullInitMarginReq = new BigDecimal(0);
    private BigDecimal fullInitMarginReqC = new BigDecimal(0);
    private BigDecimal fullInitMarginReqS = new BigDecimal(0);

    private BigDecimal fullMaintMarginReq = new BigDecimal(0);
    private BigDecimal fullMaintMarginReqC = new BigDecimal(0);
    private BigDecimal fullMaintMarginReqS = new BigDecimal(0);
    private BigDecimal fundValue = new BigDecimal(0);
    private BigDecimal fundValueBase = new BigDecimal(0);
    private BigDecimal futureOptionValue = new BigDecimal(0);
    private BigDecimal futureOptionValueBase = new BigDecimal(0);
    private BigDecimal futurePnl = new BigDecimal(0);
    private BigDecimal futurePnlBase = new BigDecimal(0);
    private BigDecimal fxCashBalance = new BigDecimal(0);
    private BigDecimal fxCashBalanceBase = new BigDecimal(0);
    private BigDecimal grossPositionValue = new BigDecimal(0);
    private BigDecimal grossPositionValueS = new BigDecimal(0);
    private BigDecimal indianStockHaircut = new BigDecimal(0);
    private BigDecimal indianStockHaircutC = new BigDecimal(0);
    private BigDecimal indianStockHaircutS = new BigDecimal(0);
    private BigDecimal initMarginReq = new BigDecimal(0);
    private BigDecimal initMarginReqC = new BigDecimal(0);
    private BigDecimal initMarginReqS = new BigDecimal(0);
    private BigDecimal leverageS = new BigDecimal(0);
    private BigDecimal lookAheadAvailableFunds = new BigDecimal(0);
    private BigDecimal lookAheadAvailableFundsC = new BigDecimal(0);
    private BigDecimal lookAheadAvailableFundsS = new BigDecimal(0);
    private BigDecimal lookAheadExcessLiquidity = new BigDecimal(0);
    private BigDecimal lookAheadExcessLiquidityC = new BigDecimal(0);
    private BigDecimal lookAheadExcessLiquidityS = new BigDecimal(0);
    private BigDecimal lookAheadInitMarginReq = new BigDecimal(0);
    private BigDecimal lookAheadInitMarginReqC = new BigDecimal(0);
    private BigDecimal lookAheadInitMarginReqS = new BigDecimal(0);
    private BigDecimal lookAheadMaintMarginReq = new BigDecimal(0);
    private BigDecimal lookAheadMaintMarginReqC = new BigDecimal(0);
    private BigDecimal lookAheadMaintMarginReqS = new BigDecimal(0);
    private Integer lookAheadNextChange = new Integer(0);
    private BigDecimal maintMarginReq = new BigDecimal(0);
    private BigDecimal maintMarginReqC = new BigDecimal(0);
    private BigDecimal maintMarginReqS = new BigDecimal(0);
    private BigDecimal moneyMarketFundValue = new BigDecimal(0);
    private BigDecimal moneyMarketFundValueBase = new BigDecimal(0);
    private BigDecimal mutualFundValue = new BigDecimal(0);
    private BigDecimal mutualFundValueBase = new BigDecimal(0);
    private BigDecimal netDividend = new BigDecimal(0);
    private BigDecimal netDividendBase = new BigDecimal(0);
    private BigDecimal netLiquidation = new BigDecimal(0);
    private BigDecimal netLiquidationC = new BigDecimal(0);
    private BigDecimal netLiquidationS = new BigDecimal(0);
    private BigDecimal netLiquidationByCurrency = new BigDecimal(0);
    private BigDecimal netLiquidationByCurrencyBase = new BigDecimal(0);
    private BigDecimal optionMarketValue = new BigDecimal(0);
    private BigDecimal optionMarketValueBase = new BigDecimal(0);
    private BigDecimal paSharesValue = new BigDecimal(0);
    private BigDecimal paSharesValueC = new BigDecimal(0);
    private BigDecimal paSharesValueD = new BigDecimal(0);
    private Boolean pnl = null;
    private BigDecimal previousDayEquityWithLoanValue = new BigDecimal(0);
    private BigDecimal previousDayEquityWithLoanValueS = new BigDecimal(0);
    private BigDecimal realizedPnl = new BigDecimal(0);
    private BigDecimal realizedPnlBase = new BigDecimal(0);
    private BigDecimal regTEquity = new BigDecimal(0);
    private BigDecimal regTEquityS = new BigDecimal(0);
    private BigDecimal regTMargin = new BigDecimal(0);
    private BigDecimal regTMarginS = new BigDecimal(0);
    private BigDecimal sma = new BigDecimal(0);
    private BigDecimal smaS = new BigDecimal(0);
    private BigDecimal stockMarketValue = new BigDecimal(0);
    private BigDecimal stockMarketValueBase = new BigDecimal(0);
    private BigDecimal tBillValue = new BigDecimal(0);
    private BigDecimal tBillValueBase = new BigDecimal(0);
    private BigDecimal tBondValue = new BigDecimal(0);
    private BigDecimal tBondValueBase = new BigDecimal(0);

    private BigDecimal totalCashBalance = new BigDecimal(0);
    private BigDecimal totalCashBalanceBase = new BigDecimal(0);
    private BigDecimal totalCashValue = new BigDecimal(0);
    private BigDecimal totalCashValueC = new BigDecimal(0);
    private BigDecimal totalCashValueS = new BigDecimal(0);
    private String tradingTypeS = null;
    private BigDecimal unalteredInitMarginReq = new BigDecimal(0);
    private BigDecimal unalteredMaintMarginReq = new BigDecimal(0);
    private BigDecimal unrealizedPnl = new BigDecimal(0);
    private BigDecimal unrealizedPnlBase = new BigDecimal(0);
    private BigDecimal warrantValue = new BigDecimal(0);
    private BigDecimal warrantValueBase = new BigDecimal(0);
    private Boolean whatIfPMEnabled = new Boolean(false);

    private Date updateDate;

    private transient Boolean updated;

    public AccountInfo(){
        id = Calendar.getInstance().getTimeInMillis();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getReady() {
        return ready;
    }

    public void setReady(Boolean ready) {
        this.ready = ready;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getCashBase() {
        return cashBase;
    }

    public void setCashBase(BigDecimal cashBase) {
        this.cashBase = cashBase;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    public BigDecimal getAccruedCashBase() {
        return accruedCashBase;
    }

    public void setAccruedCashBase(BigDecimal accruedCashBase) {
        this.accruedCashBase = accruedCashBase;
    }

    public BigDecimal getAccruedCash() {
        return accruedCash;
    }

    public void setAccruedCash(BigDecimal accruedCash) {
        this.accruedCash = accruedCash;
    }

    public BigDecimal getAccruedCashC() {
        return accruedCashC;
    }

    public void setAccruedCashC(BigDecimal accruedCashC) {
        this.accruedCashC = accruedCashC;
    }

    public BigDecimal getAccruedCashS() {
        return accruedCashS;
    }

    public void setAccruedCashS(BigDecimal accruedCashS) {
        this.accruedCashS = accruedCashS;
    }

    public BigDecimal getAccruedDividend() {
        return accruedDividend;
    }

    public void setAccruedDividend(BigDecimal accruedDividend) {
        this.accruedDividend = accruedDividend;
    }

    public BigDecimal getAccrueddividendC() {
        return accrueddividendC;
    }

    public void setAccrueddividendC(BigDecimal accrueddividendC) {
        this.accrueddividendC = accrueddividendC;
    }

    public BigDecimal getAccruedDividendS() {
        return accruedDividendS;
    }

    public void setAccruedDividendS(BigDecimal accruedDividendS) {
        this.accruedDividendS = accruedDividendS;
    }

    public BigDecimal getAvailableFunds() {
        return availableFunds;
    }

    public void setAvailableFunds(BigDecimal availableFunds) {
        this.availableFunds = availableFunds;
    }

    public BigDecimal getAvailableFundsC() {
        return availableFundsC;
    }

    public void setAvailableFundsC(BigDecimal availableFundsC) {
        this.availableFundsC = availableFundsC;
    }

    public BigDecimal getAvailableFundsS() {
        return availableFundsS;
    }

    public void setAvailableFundsS(BigDecimal availableFundsS) {
        this.availableFundsS = availableFundsS;
    }

    public BigDecimal getBillable() {
        return billable;
    }

    public void setBillable(BigDecimal billable) {
        this.billable = billable;
    }

    public BigDecimal getBillableC() {
        return billableC;
    }

    public void setBillableC(BigDecimal billableC) {
        this.billableC = billableC;
    }

    public BigDecimal getBillableS() {
        return billableS;
    }

    public void setBillableS(BigDecimal billableS) {
        this.billableS = billableS;
    }

    public BigDecimal getBuyingPower() {
        return buyingPower;
    }

    public void setBuyingPower(BigDecimal buyingPower) {
        this.buyingPower = buyingPower;
    }

    public BigDecimal getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(BigDecimal cashBalance) {
        this.cashBalance = cashBalance;
    }

    public BigDecimal getCashBalanceBase() {
        return cashBalanceBase;
    }

    public void setCashBalanceBase(BigDecimal cashBalanceBase) {
        this.cashBalanceBase = cashBalanceBase;
    }

    public BigDecimal getCushion() {
        return cushion;
    }

    public void setCushion(BigDecimal cushion) {
        this.cushion = cushion;
    }

    public Integer getDayTradesRemaining() {
        return dayTradesRemaining;
    }

    public void setDayTradesRemaining(Integer dayTradesRemaining) {
        this.dayTradesRemaining = dayTradesRemaining;
    }

    public Integer getDayTradesRemaining1() {
        return dayTradesRemaining1;
    }

    public void setDayTradesRemaining1(Integer dayTradesRemaining1) {
        this.dayTradesRemaining1 = dayTradesRemaining1;
    }

    public Integer getDayTradesRemaining2() {
        return dayTradesRemaining2;
    }

    public void setDayTradesRemaining2(Integer dayTradesRemaining2) {
        this.dayTradesRemaining2 = dayTradesRemaining2;
    }

    public Integer getDayTradesRemaining3() {
        return dayTradesRemaining3;
    }

    public void setDayTradesRemaining3(Integer dayTradesRemaining3) {
        this.dayTradesRemaining3 = dayTradesRemaining3;
    }

    public Integer getDayTradesRemaining4() {
        return dayTradesRemaining4;
    }

    public void setDayTradesRemaining4(Integer dayTradesRemaining4) {
        this.dayTradesRemaining4 = dayTradesRemaining4;
    }

    public BigDecimal getEquityWithLoanValue() {
        return equityWithLoanValue;
    }

    public void setEquityWithLoanValue(BigDecimal equityWithLoanValue) {
        this.equityWithLoanValue = equityWithLoanValue;
    }

    public BigDecimal getEquityWithLoanValueC() {
        return equityWithLoanValueC;
    }

    public void setEquityWithLoanValueC(BigDecimal equityWithLoanValueC) {
        this.equityWithLoanValueC = equityWithLoanValueC;
    }

    public BigDecimal getEquityWithLoanValueS() {
        return equityWithLoanValueS;
    }

    public void setEquityWithLoanValueS(BigDecimal equityWithLoanValueS) {
        this.equityWithLoanValueS = equityWithLoanValueS;
    }

    public BigDecimal getExcessLiquidity() {
        return excessLiquidity;
    }

    public void setExcessLiquidity(BigDecimal excessLiquidity) {
        this.excessLiquidity = excessLiquidity;
    }

    public BigDecimal getExcessLiquidityC() {
        return excessLiquidityC;
    }

    public void setExcessLiquidityC(BigDecimal excessLiquidityC) {
        this.excessLiquidityC = excessLiquidityC;
    }

    public BigDecimal getExcessLiquidityS() {
        return excessLiquidityS;
    }

    public void setExcessLiquidityS(BigDecimal excessLiquidityS) {
        this.excessLiquidityS = excessLiquidityS;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public BigDecimal getExchangeRateBase() {
        return exchangeRateBase;
    }

    public void setExchangeRateBase(BigDecimal exchangeRateBase) {
        this.exchangeRateBase = exchangeRateBase;
    }

    public BigDecimal getFullAvailableFunds() {
        return fullAvailableFunds;
    }

    public void setFullAvailableFunds(BigDecimal fullAvailableFunds) {
        this.fullAvailableFunds = fullAvailableFunds;
    }

    public BigDecimal getFullAvailableFundsC() {
        return fullAvailableFundsC;
    }

    public void setFullAvailableFundsC(BigDecimal fullAvailableFundsC) {
        this.fullAvailableFundsC = fullAvailableFundsC;
    }

    public BigDecimal getFullAvailableFundsS() {
        return fullAvailableFundsS;
    }

    public void setFullAvailableFundsS(BigDecimal fullAvailableFundsS) {
        this.fullAvailableFundsS = fullAvailableFundsS;
    }

    public BigDecimal getFullAvailableLiquidity() {
        return fullAvailableLiquidity;
    }

    public void setFullAvailableLiquidity(BigDecimal fullAvailableLiquidity) {
        this.fullAvailableLiquidity = fullAvailableLiquidity;
    }

    public BigDecimal getFullAvailableLiquidityC() {
        return fullAvailableLiquidityC;
    }

    public void setFullAvailableLiquidityC(BigDecimal fullAvailableLiquidityC) {
        this.fullAvailableLiquidityC = fullAvailableLiquidityC;
    }

    public BigDecimal getFullAvailableLiquidityS() {
        return fullAvailableLiquidityS;
    }

    public void setFullAvailableLiquidityS(BigDecimal fullAvailableLiquidityS) {
        this.fullAvailableLiquidityS = fullAvailableLiquidityS;
    }


    public BigDecimal getFundValue() {
        return fundValue;
    }

    public void setFundValue(BigDecimal fundValue) {
        this.fundValue = fundValue;
    }

    public BigDecimal getFundValueBase() {
        return fundValueBase;
    }

    public void setFundValueBase(BigDecimal fundValueBase) {
        this.fundValueBase = fundValueBase;
    }

    public BigDecimal getFutureOptionValue() {
        return futureOptionValue;
    }

    public void setFutureOptionValue(BigDecimal futureOptionValue) {
        this.futureOptionValue = futureOptionValue;
    }

    public BigDecimal getFutureOptionValueBase() {
        return futureOptionValueBase;
    }

    public void setFutureOptionValueBase(BigDecimal futureOptionValueBase) {
        this.futureOptionValueBase = futureOptionValueBase;
    }

    public BigDecimal getFuturePnl() {
        return futurePnl;
    }

    public void setFuturePnl(BigDecimal futurePnl) {
        this.futurePnl = futurePnl;
    }

    public BigDecimal getFuturePnlBase() {
        return futurePnlBase;
    }

    public void setFuturePnlBase(BigDecimal futurePnlBase) {
        this.futurePnlBase = futurePnlBase;
    }

    public BigDecimal getFxCashBalance() {
        return fxCashBalance;
    }

    public void setFxCashBalance(BigDecimal fxCashBalance) {
        this.fxCashBalance = fxCashBalance;
    }

    public BigDecimal getFxCashBalanceBase() {
        return fxCashBalanceBase;
    }

    public void setFxCashBalanceBase(BigDecimal fxCashBalanceBase) {
        this.fxCashBalanceBase = fxCashBalanceBase;
    }

    public BigDecimal getGrossPositionValue() {
        return grossPositionValue;
    }

    public void setGrossPositionValue(BigDecimal grossPositionValue) {
        this.grossPositionValue = grossPositionValue;
    }

    public BigDecimal getGrossPositionValueS() {
        return grossPositionValueS;
    }

    public void setGrossPositionValueS(BigDecimal grossPositionValueS) {
        this.grossPositionValueS = grossPositionValueS;
    }

    public BigDecimal getIndianStockHaircut() {
        return indianStockHaircut;
    }

    public void setIndianStockHaircut(BigDecimal indianStockHaircut) {
        this.indianStockHaircut = indianStockHaircut;
    }

    public BigDecimal getIndianStockHaircutC() {
        return indianStockHaircutC;
    }

    public void setIndianStockHaircutC(BigDecimal indianStockHaircutC) {
        this.indianStockHaircutC = indianStockHaircutC;
    }

    public BigDecimal getIndianStockHaircutS() {
        return indianStockHaircutS;
    }

    public void setIndianStockHaircutS(BigDecimal indianStockHaircutS) {
        this.indianStockHaircutS = indianStockHaircutS;
    }

    public BigDecimal getInitMarginReq() {
        return initMarginReq;
    }

    public void setInitMarginReq(BigDecimal initMarginReq) {
        this.initMarginReq = initMarginReq;
    }

    public BigDecimal getInitMarginReqC() {
        return initMarginReqC;
    }

    public void setInitMarginReqC(BigDecimal initMarginReqC) {
        this.initMarginReqC = initMarginReqC;
    }

    public BigDecimal getInitMarginReqS() {
        return initMarginReqS;
    }

    public void setInitMarginReqS(BigDecimal initMarginReqS) {
        this.initMarginReqS = initMarginReqS;
    }

    public BigDecimal getLeverageS() {
        return leverageS;
    }

    public void setLeverageS(BigDecimal leverageS) {
        this.leverageS = leverageS;
    }

    public BigDecimal getLookAheadAvailableFunds() {
        return lookAheadAvailableFunds;
    }

    public void setLookAheadAvailableFunds(BigDecimal lookAheadAvailableFunds) {
        this.lookAheadAvailableFunds = lookAheadAvailableFunds;
    }

    public BigDecimal getLookAheadAvailableFundsC() {
        return lookAheadAvailableFundsC;
    }

    public void setLookAheadAvailableFundsC(BigDecimal lookAheadAvailableFundsC) {
        this.lookAheadAvailableFundsC = lookAheadAvailableFundsC;
    }

    public BigDecimal getLookAheadAvailableFundsS() {
        return lookAheadAvailableFundsS;
    }

    public void setLookAheadAvailableFundsS(BigDecimal lookAheadAvailableFundsS) {
        this.lookAheadAvailableFundsS = lookAheadAvailableFundsS;
    }

    public BigDecimal getLookAheadExcessLiquidity() {
        return lookAheadExcessLiquidity;
    }

    public void setLookAheadExcessLiquidity(BigDecimal lookAheadExcessLiquidity) {
        this.lookAheadExcessLiquidity = lookAheadExcessLiquidity;
    }

    public BigDecimal getLookAheadExcessLiquidityC() {
        return lookAheadExcessLiquidityC;
    }

    public void setLookAheadExcessLiquidityC(BigDecimal lookAheadExcessLiquidityC) {
        this.lookAheadExcessLiquidityC = lookAheadExcessLiquidityC;
    }

    public BigDecimal getLookAheadExcessLiquidityS() {
        return lookAheadExcessLiquidityS;
    }

    public void setLookAheadExcessLiquidityS(BigDecimal lookAheadExcessLiquidityS) {
        this.lookAheadExcessLiquidityS = lookAheadExcessLiquidityS;
    }

    public BigDecimal getLookAheadInitMarginReq() {
        return lookAheadInitMarginReq;
    }

    public void setLookAheadInitMarginReq(BigDecimal lookAheadInitMarginReq) {
        this.lookAheadInitMarginReq = lookAheadInitMarginReq;
    }

    public BigDecimal getLookAheadInitMarginReqC() {
        return lookAheadInitMarginReqC;
    }

    public void setLookAheadInitMarginReqC(BigDecimal lookAheadInitMarginReqC) {
        this.lookAheadInitMarginReqC = lookAheadInitMarginReqC;
    }

    public BigDecimal getLookAheadInitMarginReqS() {
        return lookAheadInitMarginReqS;
    }

    public void setLookAheadInitMarginReqS(BigDecimal lookAheadInitMarginReqS) {
        this.lookAheadInitMarginReqS = lookAheadInitMarginReqS;
    }

    public BigDecimal getLookAheadMaintMarginReq() {
        return lookAheadMaintMarginReq;
    }

    public void setLookAheadMaintMarginReq(BigDecimal lookAheadMaintMarginReq) {
        this.lookAheadMaintMarginReq = lookAheadMaintMarginReq;
    }

    public BigDecimal getLookAheadMaintMarginReqC() {
        return lookAheadMaintMarginReqC;
    }

    public void setLookAheadMaintMarginReqC(BigDecimal lookAheadMaintMarginReqC) {
        this.lookAheadMaintMarginReqC = lookAheadMaintMarginReqC;
    }

    public BigDecimal getLookAheadMaintMarginReqS() {
        return lookAheadMaintMarginReqS;
    }

    public void setLookAheadMaintMarginReqS(BigDecimal lookAheadMaintMarginReqS) {
        this.lookAheadMaintMarginReqS = lookAheadMaintMarginReqS;
    }

    public Integer getLookAheadNextChange() {
        return lookAheadNextChange;
    }

    public void setLookAheadNextChange(Integer lookAheadNextChange) {
        this.lookAheadNextChange = lookAheadNextChange;
    }

    public BigDecimal getMaintMarginReq() {
        return maintMarginReq;
    }

    public void setMaintMarginReq(BigDecimal maintMarginReq) {
        this.maintMarginReq = maintMarginReq;
    }

    public BigDecimal getMaintMarginReqC() {
        return maintMarginReqC;
    }

    public void setMaintMarginReqC(BigDecimal maintMarginReqC) {
        this.maintMarginReqC = maintMarginReqC;
    }

    public BigDecimal getMaintMarginReqS() {
        return maintMarginReqS;
    }

    public void setMaintMarginReqS(BigDecimal maintMarginReqS) {
        this.maintMarginReqS = maintMarginReqS;
    }

    public BigDecimal getMoneyMarketFundValue() {
        return moneyMarketFundValue;
    }

    public void setMoneyMarketFundValue(BigDecimal moneyMarketFundValue) {
        this.moneyMarketFundValue = moneyMarketFundValue;
    }

    public BigDecimal getMoneyMarketFundValueBase() {
        return moneyMarketFundValueBase;
    }

    public void setMoneyMarketFundValueBase(BigDecimal moneyMarketFundValueBase) {
        this.moneyMarketFundValueBase = moneyMarketFundValueBase;
    }

    public BigDecimal getMutualFundValue() {
        return mutualFundValue;
    }

    public void setMutualFundValue(BigDecimal mutualFundValue) {
        this.mutualFundValue = mutualFundValue;
    }

    public BigDecimal getMutualFundValueBase() {
        return mutualFundValueBase;
    }

    public void setMutualFundValueBase(BigDecimal mutualFundValueBase) {
        this.mutualFundValueBase = mutualFundValueBase;
    }

    public BigDecimal getNetDividend() {
        return netDividend;
    }

    public void setNetDividend(BigDecimal netDividend) {
        this.netDividend = netDividend;
    }

    public BigDecimal getNetDividendBase() {
        return netDividendBase;
    }

    public void setNetDividendBase(BigDecimal netDividendBase) {
        this.netDividendBase = netDividendBase;
    }

    public BigDecimal getNetLiquidation() {
        return netLiquidation;
    }

    public void setNetLiquidation(BigDecimal netLiquidation) {
        this.netLiquidation = netLiquidation;
    }

    public BigDecimal getNetLiquidationC() {
        return netLiquidationC;
    }

    public void setNetLiquidationC(BigDecimal netLiquidationC) {
        this.netLiquidationC = netLiquidationC;
    }

    public BigDecimal getNetLiquidationS() {
        return netLiquidationS;
    }

    public void setNetLiquidationS(BigDecimal netLiquidationS) {
        this.netLiquidationS = netLiquidationS;
    }

    public BigDecimal getNetLiquidationByCurrency() {
        return netLiquidationByCurrency;
    }

    public void setNetLiquidationByCurrency(BigDecimal netLiquidationByCurrency) {
        this.netLiquidationByCurrency = netLiquidationByCurrency;
    }

    public BigDecimal getNetLiquidationByCurrencyBase() {
        return netLiquidationByCurrencyBase;
    }

    public void setNetLiquidationByCurrencyBase(BigDecimal netLiquidationByCurrencyBase) {
        this.netLiquidationByCurrencyBase = netLiquidationByCurrencyBase;
    }

    public BigDecimal getOptionMarketValue() {
        return optionMarketValue;
    }

    public void setOptionMarketValue(BigDecimal optionMarketValue) {
        this.optionMarketValue = optionMarketValue;
    }

    public BigDecimal getOptionMarketValueBase() {
        return optionMarketValueBase;
    }

    public void setOptionMarketValueBase(BigDecimal optionMarketValueBase) {
        this.optionMarketValueBase = optionMarketValueBase;
    }

    public BigDecimal getPaSharesValue() {
        return paSharesValue;
    }

    public void setPaSharesValue(BigDecimal paSharesValue) {
        this.paSharesValue = paSharesValue;
    }

    public BigDecimal getPaSharesValueC() {
        return paSharesValueC;
    }

    public void setPaSharesValueC(BigDecimal paSharesValueC) {
        this.paSharesValueC = paSharesValueC;
    }

    public BigDecimal getPaSharesValueD() {
        return paSharesValueD;
    }

    public void setPaSharesValueD(BigDecimal paSharesValueD) {
        this.paSharesValueD = paSharesValueD;
    }

    public Boolean getPnl() {
        return pnl;
    }

    public void setPnl(Boolean pnl) {
        this.pnl = pnl;
    }

    public BigDecimal getPreviousDayEquityWithLoanValue() {
        return previousDayEquityWithLoanValue;
    }

    public void setPreviousDayEquityWithLoanValue(BigDecimal previousDayEquityWithLoanValue) {
        this.previousDayEquityWithLoanValue = previousDayEquityWithLoanValue;
    }

    public BigDecimal getPreviousDayEquityWithLoanValueS() {
        return previousDayEquityWithLoanValueS;
    }

    public void setPreviousDayEquityWithLoanValueS(BigDecimal previousDayEquityWithLoanValueS) {
        this.previousDayEquityWithLoanValueS = previousDayEquityWithLoanValueS;
    }

    public BigDecimal getRealizedPnl() {
        return realizedPnl;
    }

    public void setRealizedPnl(BigDecimal realizedPnl) {
        this.realizedPnl = realizedPnl;
    }

    public BigDecimal getRealizedPnlBase() {
        return realizedPnlBase;
    }

    public void setRealizedPnlBase(BigDecimal realizedPnlBase) {
        this.realizedPnlBase = realizedPnlBase;
    }

    public BigDecimal getRegTEquity() {
        return regTEquity;
    }

    public void setRegTEquity(BigDecimal regTEquity) {
        this.regTEquity = regTEquity;
    }

    public BigDecimal getRegTEquityS() {
        return regTEquityS;
    }

    public void setRegTEquityS(BigDecimal regTEquityS) {
        this.regTEquityS = regTEquityS;
    }

    public BigDecimal getRegTMargin() {
        return regTMargin;
    }

    public void setRegTMargin(BigDecimal regTMargin) {
        this.regTMargin = regTMargin;
    }

    public BigDecimal getRegTMarginS() {
        return regTMarginS;
    }

    public void setRegTMarginS(BigDecimal regTMarginS) {
        this.regTMarginS = regTMarginS;
    }

    public BigDecimal getSma() {
        return sma;
    }

    public void setSma(BigDecimal sma) {
        this.sma = sma;
    }

    public BigDecimal getSmaS() {
        return smaS;
    }

    public void setSmaS(BigDecimal smaS) {
        this.smaS = smaS;
    }

    public BigDecimal getStockMarketValue() {
        return stockMarketValue;
    }

    public void setStockMarketValue(BigDecimal stockMarketValue) {
        this.stockMarketValue = stockMarketValue;
    }

    public BigDecimal getStockMarketValueBase() {
        return stockMarketValueBase;
    }

    public void setStockMarketValueBase(BigDecimal stockMarketValueBase) {
        this.stockMarketValueBase = stockMarketValueBase;
    }

    public BigDecimal gettBillValue() {
        return tBillValue;
    }

    public void settBillValue(BigDecimal tBillValue) {
        this.tBillValue = tBillValue;
    }

    public BigDecimal gettBillValueBase() {
        return tBillValueBase;
    }

    public void settBillValueBase(BigDecimal tBillValueBase) {
        this.tBillValueBase = tBillValueBase;
    }

    public BigDecimal gettBondValue() {
        return tBondValue;
    }

    public void settBondValue(BigDecimal tBondValue) {
        this.tBondValue = tBondValue;
    }

    public BigDecimal gettBondValueBase() {
        return tBondValueBase;
    }

    public void settBondValueBase(BigDecimal tBondValueBase) {
        this.tBondValueBase = tBondValueBase;
    }

    public BigDecimal getTotalCashValue() {
        return totalCashValue;
    }

    public void setTotalCashValue(BigDecimal totalCashValue) {
        this.totalCashValue = totalCashValue;
    }

    public BigDecimal getTotalCashValueC() {
        return totalCashValueC;
    }

    public void setTotalCashValueC(BigDecimal totalCashValueC) {
        this.totalCashValueC = totalCashValueC;
    }

    public BigDecimal getTotalCashValueS() {
        return totalCashValueS;
    }

    public void setTotalCashValueS(BigDecimal totalCashValueS) {
        this.totalCashValueS = totalCashValueS;
    }

    public String getTradingTypeS() {
        return tradingTypeS;
    }

    public void setTradingTypeS(String tradingTypeS) {
        this.tradingTypeS = tradingTypeS;
    }

    public BigDecimal getUnalteredInitMarginReq() {
        return unalteredInitMarginReq;
    }

    public void setUnalteredInitMarginReq(BigDecimal unalteredInitMarginReq) {
        this.unalteredInitMarginReq = unalteredInitMarginReq;
    }

    public BigDecimal getUnalteredMaintMarginReq() {
        return unalteredMaintMarginReq;
    }

    public void setUnalteredMaintMarginReq(BigDecimal unalteredMaintMarginReq) {
        this.unalteredMaintMarginReq = unalteredMaintMarginReq;
    }

    public BigDecimal getUnrealizedPnl() {
        return unrealizedPnl;
    }

    public void setUnrealizedPnl(BigDecimal unrealizedPnl) {
        this.unrealizedPnl = unrealizedPnl;
    }

    public BigDecimal getUnrealizedPnlBase() {
        return unrealizedPnlBase;
    }

    public void setUnrealizedPnlBase(BigDecimal unrealizedPnlBase) {
        this.unrealizedPnlBase = unrealizedPnlBase;
    }

    public BigDecimal getWarrantValue() {
        return warrantValue;
    }

    public void setWarrantValue(BigDecimal warrantValue) {
        this.warrantValue = warrantValue;
    }

    public BigDecimal getWarrantValueBase() {
        return warrantValueBase;
    }

    public void setWarrantValueBase(BigDecimal warrantValueBase) {
        this.warrantValueBase = warrantValueBase;
    }

    public Boolean getWhatIfPMEnabled() {
        return whatIfPMEnabled;
    }

    public void setWhatIfPMEnabled(Boolean whatIfPMEnabled) {
        this.whatIfPMEnabled = whatIfPMEnabled;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public BigDecimal getFullExcessLiquidityS() {
        return fullExcessLiquidityS;
    }

    public void setFullExcessLiquidityS(BigDecimal fullExcessLiquidityS) {
        this.fullExcessLiquidityS = fullExcessLiquidityS;
    }

    public BigDecimal getFullInitMarginReq() {
        return fullInitMarginReq;
    }

    public void setFullInitMarginReq(BigDecimal fullInitMarginReq) {
        this.fullInitMarginReq = fullInitMarginReq;
    }

    public BigDecimal getFullInitMarginReqC() {
        return fullInitMarginReqC;
    }

    public void setFullInitMarginReqC(BigDecimal fullInitMarginReqC) {
        this.fullInitMarginReqC = fullInitMarginReqC;
    }

    public BigDecimal getFullInitMarginReqS() {
        return fullInitMarginReqS;
    }

    public void setFullInitMarginReqS(BigDecimal fullInitMarginReqS) {
        this.fullInitMarginReqS = fullInitMarginReqS;
    }

    public BigDecimal getFullMaintMarginReq() {
        return fullMaintMarginReq;
    }

    public void setFullMaintMarginReq(BigDecimal fullMaintMarginReq) {
        this.fullMaintMarginReq = fullMaintMarginReq;
    }

    public BigDecimal getFullMaintMarginReqC() {
        return fullMaintMarginReqC;
    }

    public void setFullMaintMarginReqC(BigDecimal fullMaintMarginReqC) {
        this.fullMaintMarginReqC = fullMaintMarginReqC;
    }

    public BigDecimal getFullMaintMarginReqS() {
        return fullMaintMarginReqS;
    }

    public void setFullMaintMarginReqS(BigDecimal fullMaintMarginReqS) {
        this.fullMaintMarginReqS = fullMaintMarginReqS;
    }

    public BigDecimal getFullExcessLiquidity() {
        return fullExcessLiquidity;
    }

    public void setFullExcessLiquidity(BigDecimal fullExcessLiquidity) {
        this.fullExcessLiquidity = fullExcessLiquidity;
    }

    public BigDecimal getFullExcessLiquidityC() {
        return fullExcessLiquidityC;
    }

    public void setFullExcessLiquidityC(BigDecimal fullExcessLiquidityC) {
        this.fullExcessLiquidityC = fullExcessLiquidityC;
    }
    public BigDecimal getTotalCashBalance() {
           return totalCashBalance;
       }

       public void setTotalCashBalance(BigDecimal totalCashBalance) {
           this.totalCashBalance = totalCashBalance;
       }

       public BigDecimal getTotalCashBalanceBase() {
           return totalCashBalanceBase;
       }

       public void setTotalCashBalanceBase(BigDecimal totalCashBalanceBase) {
           this.totalCashBalanceBase = totalCashBalanceBase;
       }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Boolean getUpdated() {
        return updated;
    }

    public void setUpdated(Boolean updated) {
        this.updated = updated;
    }
}
