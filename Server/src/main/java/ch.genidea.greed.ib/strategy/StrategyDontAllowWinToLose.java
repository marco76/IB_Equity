package ch.genidea.greed.ib.strategy;

import ch.genidea.greed.ib.service.Connection;
import ch.genidea.greed.ib.wrapper.ContractGen;
import ch.genidea.greed.ib.wrapper.OrderGen;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/21/12
 * Time: 7:09 PM
 * To change this template use File | Settings | File Templates.
 */

public class StrategyDontAllowWinToLose extends Strategy {
    Connection connection;

    public StrategyDontAllowWinToLose(ContractGen contractGen, Connection  connection){
        this.setContract(contractGen);
        this.setName("DontAllowWinToLose");
        double avgCost = contractGen.getPortfolioElement().getAverageCost();
        this.setTriggerPriceUp(avgCost/100*102);
        this.setTriggerPriceDown(avgCost/100*98.5);
        this.connection = connection;
    }


    @Override
    protected void triggerUpAction(double price) {
        if (getContract().getPortfolioElement().getPosition() == 0)
            return;
        OrderGen order = new OrderGen(OrderGen.OrderAction.SELL, getContract().getPortfolioElement().getPosition(), OrderGen.OrderType.LMT, getContract().getPortfolioElement().getAverageCost()/100*98, 0, OrderGen.OrderObjective.OPEN_AUTOMATIC_POSITION);
        connection.sendOrder(connection.getNextValidId(), getContract(), order);
    }

    @Override
    protected void triggerDownAction(double price) {
        if (getContract().getPortfolioElement().getPosition() == 0)
            return;
        OrderGen order = new OrderGen(OrderGen.OrderAction.SELL, getContract().getPortfolioElement().getPosition(), OrderGen.OrderType.LMT, getContract().getPortfolioElement().getAverageCost(), 0, OrderGen.OrderObjective.OPEN_AUTOMATIC_POSITION);
        connection.sendOrder(connection.getNextValidId(), getContract(), order);

        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void execute() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
