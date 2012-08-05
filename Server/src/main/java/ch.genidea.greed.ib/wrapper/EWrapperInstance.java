package ch.genidea.greed.ib.wrapper;

import ch.genidea.greed.ib.WatchListRealTime;
import ch.genidea.greed.ib.bean.PortfolioElementRT;
import ch.genidea.greed.ib.bean.StockArrayRT;
import ch.genidea.greed.ib.service.AccountService;
import ch.genidea.greed.ib.service.Connection;
import ch.genidea.greed.ib.service.ContractService;
import ch.genidea.greed.ib.service.PortfolioService;
import ch.genidea.greed.ib.strategy.StrategyService;
import com.ib.client.*;
import org.springframework.beans.factory.annotation.Autowired;
                    ////
/**
 * Created by IntelliJ IDEA.
 * User: marcomolteni
 * Date: 18.06.11
 * Time: 00:13
 * To change this template use File | Settings | File Templates.
 */
public class EWrapperInstance implements EWrapper {

private static final int NOT_AN_FA_ACCOUNT_ERROR = 321 ;
    private int faErrorCodes[] = { 503, 504, 505, 522, 1100, NOT_AN_FA_ACCOUNT_ERROR } ;
    private boolean faError ;
    public WatchListRealTime listRealTime;

    @Autowired
    private AccountService accountService;
    @Autowired
    private PortfolioService portfolioService;
    @Autowired
    private ContractService contractService;
    @Autowired
    private StockArrayRT stockArrayRT;
    @Autowired
    StrategyService strategyService;
    @Autowired
    Connection connection;



public void tickEFP(int tickerId, int tickType, double basisPoints,
			String formattedBasisPoints, double impliedFuture, int holdDays,
			String futureExpiry, double dividendImpact, double dividendsToExpiry) {
		System.out.println("tickEFP ...");
	}

	public void tickGeneric(int tickerId, int tickType, double value) {
		System.out.println("tickGeneric ...");
	}

	public void tickOptionComputation(int tickerId, int field,
			double impliedVol, double delta, double optPrice,
			double pvDividend, double gamma, double vega,
			double theta, double undPrice) {
		System.out.println("tickOptionComputation ...");
	}

	public void tickPrice(int tickerId, int field, double price,
			int canAutoExecute) {
          stockArrayRT.update(tickerId, field, price);
          strategyService.checkPriceAction(tickerId, price, field);
        // if (field == 4)
        //    System.out.println("" + tickerId + " :"  + field + ": " + price + ("tickPrice"));

	}

	public void tickSize(int tickerId, int field, int size) {
	  	 //System.out.println(""+tickerId+":" + field + ":" + size +": tickSize ...");
	}

	public void tickString(int tickerId, int tickType, String value) {
		//System.out.println("" + tickerId + ":" + tickType + ":"+ value +": tickString ...");
	}

	public void tickSnapshotEnd(int tickerId) {
		System.out.println("tickSnapshotEnd ...");
	}

    @Override
    public void marketDataType(int i, int i1) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void commissionReport(CommissionReport commissionReport) {
        //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override
    public void orderStatus(int orderId, String status, int filled, int remaining, double avgFillPrice, int permId, int parentId, double lastFillPrice, int clientId, String whyHeld) {
        System.out.print("order id: " + orderId + "; status " + status + ": filled :" + filled + "; remaining: " + remaining + "; avgFillPrice:" + avgFillPrice);
        System.out.println("; permId: " + permId + "; parentId: " + parentId + "; lastFillPrice : " + lastFillPrice + "; clientId: " + clientId + "; whyHeld " + whyHeld );

       }

    @Override
    public void openOrder(int i, Contract contract, Order order, OrderState orderState) {
        System.out.print("open order id: " +i);
    }

    @Override
    public void openOrderEnd() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void updateAccountValue(String key, String value, String currency, String accountName) {
       // String test = "key: " + key + " - value: " + value + " - currency: " + currency + " - accountName: " + accountName;
       // System.out.println(test);
        accountService.fillField(key, value, currency, accountName);


    }

    @Override
    public void updatePortfolio(Contract contract, int position, double marketPrice, double marketValue, double averageCost, double unrealizedPNL, double realizedPNL, String accountName) {
        System.out.println("Getting updatePorfolio: " + contract.m_symbol);

        PortfolioElementRT portfolioElementRT = new PortfolioElementRT();
        /*
            Contract: m_conid is set by IB
         */
        portfolioElementRT.setContract(contract);
        portfolioElementRT.setPosition(position);
        portfolioElementRT.setMarketPrice(marketPrice);
        portfolioElementRT.setMarketValue(marketValue);
        portfolioElementRT.setAverageCost(averageCost);
        portfolioElementRT.setUnrealizedPNL(unrealizedPNL);
        portfolioElementRT.setRealizedPNL(realizedPNL);
        portfolioElementRT.setAccountName(accountName);

        portfolioService.updatePortfolioRTElement(portfolioElementRT);
    }

    @Override
    public void updateAccountTime(String s) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void accountDownloadEnd(String s) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void nextValidId(int i) {
        System.out.println("next valid id : " + i);
        connection.setNextValidId(i);
    }

    @Override
    public void contractDetails(int requestId, ContractDetails contractDetails) {
        System.out.println("Getting contract details back");
        contractService.setContractDetails(requestId, contractDetails);

    }

    @Override
    public void bondContractDetails(int i, ContractDetails contractDetails) {
        }

    @Override
    public void contractDetailsEnd(int i) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void execDetails(int i, Contract contract, Execution execution) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void execDetailsEnd(int i) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void updateMktDepth(int i, int i1, int i2, int i3, double v, int i4) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void updateMktDepthL2(int i, int i1, String s, int i2, int i3, double v, int i4) {
        //To change body of implemented methods use File | Settings | File Templates.
    }



    @Override
    public void updateNewsBulletin(int msgId, int msgType, String message, String origExchange) {
        System.out.println(msgId + ":"+msgType+":"+message+":"+origExchange);
    }

    @Override
    public void managedAccounts(String s) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void receiveFA(int i, String s) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void historicalData(int reqId, String date, double open, double high, double low,
      double close, int volume, int count, double WAP, boolean hasGaps) {

        System.out.println(reqId + ":" + date + ":" + open + " -> close :" + close);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void scannerParameters(String s) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void scannerData(int i, int i1, ContractDetails contractDetails, String s, String s1, String s2, String s3) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void scannerDataEnd(int i) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void realtimeBar(int reqId, long time, double open, double high, double low, double close, long volume, double wap, int count) {
        System.out.println("" + time + ":" + open);

    }

    @Override
    public void currentTime(long l) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void fundamentalData(int i, String s) {
        System.out.print("Fund:" + i + ", value:"+ s);
    }

    @Override
    public void deltaNeutralValidation(int i, UnderComp underComp) {
        //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override
    public void error(Exception e) {
 // do not report exceptions if we initiated disconnect
            String msg = EWrapperMsgGenerator.error(e);
            System.out.println(msg.toString());
    }

    @Override
    public void error(String s) {
         String msg = EWrapperMsgGenerator.error(s);
            System.out.println(msg.toString());
    }


    @Override
    public void error(int id, int errorCode, String errorMsg) {
// received error
        String msg = EWrapperMsgGenerator.error(id, errorCode, errorMsg);
        for (int ctr=0; ctr < faErrorCodes.length; ctr++) {
            faError |= (errorCode == faErrorCodes[ctr]);
        }
        System.out.println(msg);

    }

    @Override
    public void connectionClosed() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setListRealTime(WatchListRealTime listRealTime){
        this.listRealTime = listRealTime;
    }


}
