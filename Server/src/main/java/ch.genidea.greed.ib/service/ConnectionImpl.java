package ch.genidea.greed.ib.service;

import ch.genidea.greed.ib.WatchListRealTime;
import ch.genidea.greed.ib.wrapper.ContractGen;
import ch.genidea.greed.ib.wrapper.OrderGen;
import com.ib.client.Contract;
import com.ib.client.EClientSocket;
import com.ib.client.EWrapper;
import com.ib.client.EWrapperMsgGenerator;
import org.springframework.beans.factory.annotation.Value;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: marcomolteni
 * Date: 17.06.11
 * Time: 23:50
 * To change this template use File | Settings | File Templates.
 */
public class ConnectionImpl implements Connection {

    // Spring instances
    private EClientSocket client;
    private EWrapper wrapper;

    // variables
    // IP of TWS
    String ip = "127.0.0.1";
    // port of TWS
    @Value("${tws.port}")
    private int port;
    //int port = 4001;

    // unique client ID
    int clientId = 1;

    int nextValidId = 0;

    String accountCode = "spart726";
    //String accountCode = "genid754";
    //String accountCode = "DU15078";


    WatchListRealTime tickers = new WatchListRealTime();

    @Override
    public void startFundamentalData(int idRequest, ContractGen contract, String reportType){
        client.reqFundamentalData(idRequest,  contract, reportType);
    }

    @Override
    public void cancelFundamentalData(int idRequest){
        client.cancelFundamentalData(idRequest);
    }


    @Override
    public void connect(){
      try{
        client.eConnect("127.0.0.1", port, clientId);
        if (client.isConnected()){
            System.out.println("Connected to Tws server version " + client.serverVersion() + " at " + client.TwsConnectionTime());
        }
      } catch(Exception e){
          String msg = EWrapperMsgGenerator.error(e);
      }
    }

    @Override
    public void disconnect(){
        client.eDisconnect();
    }


    @Override
    public void requestMktData(ContractGen contract, boolean snapshot){
      //  System.out.println("Request real time data for: " + contract.getSymbol() + ", is snapshot: " + snapshot);
        if (snapshot){
            client.reqMktData(contract.getEquityID(), contract, "100", snapshot );
        } else
       // client.reqMktData(contract.getId(), contract, "165,221", snapshot );
            client.reqMktData((int)contract.getEquityID(), contract, "165,221", snapshot );
    }

    @Override
    public void requestContractDetails(ContractGen contract){
        System.out.println("Request contract details" + contract.getSymbol());
        client.reqContractDetails(contract.getEquityID(), contract);
    }

    @Override
    public void cancelMktData(ContractGen contract){
        System.out.println("Cancel real time data for: " + contract.getSymbol());
        client.cancelMktData(contract.getEquityID());
  }


    @Override
    public void requestAccountInfo(boolean subscribe){
      client.reqAccountUpdates(subscribe, accountCode);
    }

    @Override
    public void getHistoricalDataForRT(ContractGen contractGen){
        //client.cancelHistoricalData(1);
        // parameters : tickerId, contract, endTime, durationStr, size of bars, whatToShow, useRTH, formatDate
        Date date = new Date();
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("yyyyMMdd hh:mm:ss");

        client.reqHistoricalData(1, contractGen,"20110707 15:30:00 Europe/Paris", "2 D", "1 min", "TRADES", 1,1);
       // client.reqHistoricalData(contractGen.getId(), contractGen, sdf.format(date) + " Europe/Paris", "3600 S", "1 min", "TRADES", 1,1);

    }

    @Override
    public void sendOrder(int id, ContractGen contract, OrderGen order){
        PrepareAutomaticOrders.addOpenOrder(id);
        order.setContract(contract);
        client.placeOrder(id, contract, order);

    }

    @Override
    @Deprecated
    public void getRealTimeBars(){
        Contract contract = new ContractGen("AAPL");
        try{
        client.reqRealTimeBars(1, contract, 5, "MIDPOINT", false);
         tickers.add(1, (ContractGen)contract);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void getMarketNews(Boolean allDay){
        client.reqNewsBulletins(allDay);
    }

    @Override
    public void cancelMarketNews(){
        client.cancelNewsBulletins();
    }

    public EClientSocket getClient() {
        return client;
    }

    public void setClient(EClientSocket client) {
        this.client = client;
    }

    public EWrapper getWrapper() {
        return wrapper;
    }

    public void setWrapper(EWrapper wrapper) {
        this.wrapper = wrapper;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public int getNextValidId() {
        return nextValidId;
    }

    @Override
    public void setNextValidId(int nextValidId) {
        this.nextValidId = nextValidId;
    }
}
