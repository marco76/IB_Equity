package ch.genidea.greed.ib.bean;

import ch.genidea.greed.ib.wrapper.ContractGen;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/18/12
 * Time: 9:31 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class PortfolioElement {
    @Id
    String ticker;

    int position;
    double marketPrice;
    double marketValue;
    double averageCost;
    double unrealizedPNL;
    double realizedPNL;
    boolean activeInPortfolio = false;
    String accountName;
    String strategyName;
    boolean strategyActive;
    @Transient boolean strategyActivated = false;
    @Transient
    ContractGen contractGen;

    @ManyToOne
    StrategyData strategyData;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }

    public double getAverageCost() {
        return averageCost;
    }

    public void setAverageCost(double averageCost) {
        this.averageCost = averageCost;
    }

    public double getUnrealizedPNL() {
        return unrealizedPNL;
    }

    public void setUnrealizedPNL(double unrealizedPNL) {
        this.unrealizedPNL = unrealizedPNL;
    }

    public double getRealizedPNL() {
        return realizedPNL;
    }

    public void setRealizedPNL(double realizedPNL) {
        this.realizedPNL = realizedPNL;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getStrategyName() {
        return strategyName;
    }

    public void setStrategyName(String strategyName) {
        this.strategyName = strategyName;
    }

    public boolean isStrategyActive() {
        return strategyActive;
    }

    public void setStrategyActive(boolean strategyActive) {
        this.strategyActive = strategyActive;
    }

    public boolean isStrategyActivated() {
        return strategyActivated;
    }

    public void setStrategyActivated(boolean strategyActivated) {
        this.strategyActivated = strategyActivated;
    }

    public StrategyData getStrategyData() {
        return strategyData;
    }

    public void setStrategyData(StrategyData strategyData) {
        this.strategyData = strategyData;
    }

    public ContractGen getContractGen() {
        return contractGen;
    }

    public void setContractGen(ContractGen contractGen) {
        this.contractGen = contractGen;
    }

    public boolean isActiveInPortfolio() {
        return activeInPortfolio;
    }

    public void setActiveInPortfolio(boolean activeInPortfolio) {
        this.activeInPortfolio = activeInPortfolio;
    }
}
