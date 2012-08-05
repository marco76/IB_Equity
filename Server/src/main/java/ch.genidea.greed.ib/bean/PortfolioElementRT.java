package ch.genidea.greed.ib.bean;

import com.ib.client.Contract;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/14/12
 * Time: 12:43 PM
 * To change this template use File | Settings | File Templates.
 */

public class PortfolioElementRT {
    Contract contract;
    int position;
    double marketPrice;
    double marketValue;
    double averageCost;
    double unrealizedPNL;
    double realizedPNL;
    String accountName;

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

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
}
