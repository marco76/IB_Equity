package ch.genidea.greed.ib.wrapper;

import ch.genidea.greed.ib.bean.PortfolioElement;
import com.ib.client.Contract;
import com.ib.client.ContractDetails;

/**
 * Created by IntelliJ IDEA.
 * User: marcomolteni
 * Date: 18.06.11
 * Time: 01:19
 * To change this template use File | Settings | File Templates.
 */
public class ContractGen extends Contract{
    ContractDetails contractDetails;

    private long equityID;

    public ContractGen(){
        m_secType = "STK";
        m_exchange = "SMART";
        //m_conId = 1;
        m_currency = "USD";
        m_primaryExch = "ISLAND";
    }

    private PortfolioElement portfolioElement;

    public ContractGen(String ticker){
        this();
        m_symbol = ticker;
    }

    public void setSymbol(String symbol){
       m_symbol = symbol;
    }

    public String getSymbol(){
        return m_symbol;
    }

    public void setSecurityType(String securityType){
        if (securityType == null)
            m_secType = "STK";
        else
            m_secType = securityType;
    }
    public void setExchange(String exchange){
        m_exchange = exchange;
    }

    public void setId(int id){
        m_conId = id;
    }

    public int getId(){
        return m_conId;
    }

    public String getCurrency(){
        return m_currency;
    }

    public void setCurrency(String currency){
        m_currency = currency;
    }

    public ContractDetails getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(ContractDetails contractDetails) {
        this.contractDetails = contractDetails;
    }

    public int getEquityID() {
        return (int) equityID;
    }

    public void setEquityID(long equityID) {
        this.equityID = equityID;
    }

    public PortfolioElement getPortfolioElement() {
        return portfolioElement;
    }

    public void setPortfolioElement(PortfolioElement portfolioElement) {
        this.portfolioElement = portfolioElement;
    }
}
