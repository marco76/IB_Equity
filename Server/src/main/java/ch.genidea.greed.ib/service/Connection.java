package ch.genidea.greed.ib.service;

import ch.genidea.greed.ib.wrapper.ContractGen;
import ch.genidea.greed.ib.wrapper.OrderGen;

/**
 * Created by IntelliJ IDEA.
 * User: marcomolteni
 * Date: 18.06.11
 * Time: 00:20
 * To change this template use File | Settings | File Templates.
 */
public interface Connection {
    void connect();

    void disconnect();

    void getRealTimeBars();

    void requestAccountInfo(boolean subscribe);

    void requestMktData(ContractGen contract, boolean snapshot);

    void cancelMktData(ContractGen contract);


    void sendOrder(int id, ContractGen contract, OrderGen order);

    void getHistoricalDataForRT(ContractGen contractGen);

    void requestContractDetails(ContractGen contract);

    void getMarketNews(Boolean allDay);

    int getNextValidId();

    void setNextValidId(int nextValidId);

    void startFundamentalData(int idRequest, ContractGen contract, String reportType);

    void cancelFundamentalData(int idRequest);

    void cancelMarketNews();
}
