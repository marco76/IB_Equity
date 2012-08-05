package ch.genidea.greed.ib.service;

import ch.genidea.greed.ib.wrapper.ContractGen;

/**
 * Created by IntelliJ IDEA.
 * User: marcomolteni
 * Date: 19.06.11
 * Time: 18:31
 * To change this template use File | Settings | File Templates.
 */
public interface EquityQueryService {
    void sendRealTimeQuotes(Integer requestId, String symbol, boolean snapshot, boolean realTime);
    void sendRealTimeQuotes(ContractGen contractGen, boolean snapshot, boolean realTime);

    void closeAllRTConnections();
}
