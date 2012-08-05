package ch.genidea.greed.ib.wrapper;

import com.ib.client.Contract;
import com.ib.client.Order;

/**
 * Created by IntelliJ IDEA.
 * User: marcomolteni
 * Date: 09.07.11
 * Time: 11:01
 * To change this template use File | Settings | File Templates.
 */
public class OrderGen extends Order{



    public enum OrderAction {BUY, SELL, SSHORT}
    public enum OrderType {MKT, MKTCLS, LMT, LMTCLS, PEGMKT, SCALE, STP, STPLMT, TRAIL, REL, VWAP, TRAILLIMIT}
    public enum OrderObjective {OPEN_AUTOMATIC_POSITION, CLOSE_AUTOMATIC_POSITION, OPEN_MANUAL_POSITION}
    enum TimeInForce {DAY, GTC, IOC, GTD}
    static int nextOrderId = 0;

    private OrderGen closingOrder = null;

    private OrderStatus status = new OrderStatus();
    private ContractGen contract;
    // if this order is needed to close another one then store the reference
    private int orderParentId = -1;

    private int maxMonetaryLoss = 100;

    private int maxOpenMinutes = 100;

    private double priceTarget = 1000000d;

    private double priceTrailingStart = 1000000d;

    private double priceTrailingDistance = 1000000d;
    private double priceStopLoss = -1;
    private double priceToBreakEven = 1000000d;
    private double parentPrice = 1000000d;



    public OrderGen(){
     orderId = ++nextOrderId;
     m_action = "BUY";
     m_totalQuantity = 100;
     m_orderType = "MKT";
     objective = OrderObjective.OPEN_AUTOMATIC_POSITION;
    }

    public OrderGen(OrderAction action, int quantity, OrderType type, double limitPrice, double stopPrice, OrderObjective objective){
        orderId = ++nextOrderId;
        m_action = action.toString();
        m_totalQuantity = quantity;
        m_orderType = type.toString();
        m_lmtPrice = limitPrice;
        m_auxPrice = stopPrice;
        this.objective = objective;
    }

    public void transformInTrailLimit(){
        m_lmtPrice = priceToBreakEven;
        m_trailStopPrice = priceToBreakEven - 0.05;
        m_orderType = "TRAILLIMIT";
        m_auxPrice = 0.05; //(priceTarget - priceToBreakEven)/2;

    }

    public void transformManualTrail(){
        m_lmtPrice = priceToBreakEven;
        m_auxPrice = (priceTarget - priceToBreakEven)/2;
        m_orderType = "STPLMT";
    }

    public void setOrderType(OrderType type){
        m_orderType = type.toString();
    }

    public void setOrderAction(OrderAction action){
        m_action = action.toString();
    }

    public int getOrderId(){
        return m_orderId;
    }

    private int orderId;
    private int clientId;
    private int permId;
    private int totalQuantity;
    private OrderObjective objective;
    // used for limit, stop-limit and relative order otherwise 0
    private double lmtPrice = 0;
    // stop price for stop-limit orders and the offset amount for relative orders
    private double auxPrice = 0;
    private double timeInForce;
    // block orders
    private int ocaType;
    // only for institutional customers
    //String account;
    // institutional only
    //String openClose;
    // institutional only
    //int origin;
    // String orderRef
    // if false the order will be created but not sent
    private boolean transmit = true;
    // The order ID of the parent order, used for bracket and auto trailing stop orders.
    private int parentId;
    // If set to true, specifies that the order is an ISE Block order.
    // boolean blockOrder;
    // If set to true, specifies that the order is a Sweep-to-Fill order.
    // boolean sweepToFill
    // The publicly disclosed order size, used when placing Iceberg orders.
    private int displaySize;
    /*
    Specifies how Simulated Stop, Stop-Limit and Trailing Stop orders are triggered. Valid values are:
          0 - The default value. The "double bid/ask" method will be used for orders for OTC stocks and US options. All other orders will used the "last" method.

          1 - use "double bid/ask" method, where stop orders are triggered based on two consecutive bid or ask prices.

          2 - "last" method, where stop orders are triggered based on the last price.

          3 - double last method.

          4 - bid/ask method.

          7 - last or bid/ask method.

          8 - mid-point method.
     */
    private int triggerMethod;
    // If set to true, allows orders to also trigger or fill outside of regular trading hours.
    private boolean outsideRth = false;

    /*
    If set to true, the order will not be visible when viewing the market depth. This option only applies to orders routed to the ISLAND exchange.
     */
    private boolean hidden = true;
    /*
    The amount off the limit price allowed for discretionary orders
     */
    private double discretionaryAmount;

    /*
    You must enter a tif value of GTD. The trade's "Good Till Date," format is:
YYYYMMDD hh:mm:ss (optional time zone)
Use an empty String if not applicable.
     */

    private String goodTillDate;

    /*
    The Financial Advisor group the trade will be allocated to -- use an empty String if not applicable.
     */
    //String faGroup;
    // String faMethod;
    //String faPercentage;
    // Values are 1 or 2
    private int shortSaleSlot;
    // Use only when shortSaleSlot value = 2.
    private String designatedLocation;

    /*
    Cancel on Fill with Block = 1
Reduce on Fill with Block = 2
Reduce on Fill without Block = 3
     */
    private int ocaType2;

    /*
    Precautionary constraints are defined on the TWS Presets page, and help ensure tha tyour price and size order values are reasonable. Orders sent from the API are also validated against these safety constraints, and may be rejected if any constraint is violated. To override validation, set this parameter�s value to True.
Valid values include:
�          0 = False

�          1 = True
     */
    private int overridePercentageConstraints = 1;
   /*
Valid values are:
�          Individual = 'I'

�          Agency = 'A',

�          AgentOtherMember = 'W'

�          IndividualPTIA = 'J'

�          AgencyPTIA = 'U'

�          AgentOtherMemberPTIA = 'M'

�          IndividualPT = 'K'

�          AgencyPT = 'Y'

�          AgentOtherMemberPT = 'N'
    */

    String rule80A;
    private boolean allOrNone=false;
    /*
    dentifies a minimum quantity order type.
     */
    private int mintQty;

    private double percentOffset;
    private boolean eTradeOnly;
    private boolean firmQuoteOnly;
    private double nbboPriceCap;
    /*
      Valid values are:
�          match = 1

�          improvement = 2

�          transparent = 3

For BOX exchange only.
     */
    private int auctionStrategy;
    /*
       The starting price. Valid on BOX orders only.
     */
    private double startingPrice;

    private double stockRefPrice;

    /*
    The stock delta. Valid on BOX orders only.
     */
    private double delta;

    /*The lower value for the acceptable underlying stock price range. For price improvement option orders on BOX and VOL orders with dynamic management.*/

    private double stockRangeLower;
    private double stockRangeUpper;
    /*
    What the price is, computed via TWSs Options Analytics. For VOL orders, the limit price sent to an exchange is not editable, as it is the output of a function.  Volatility is expressed as a percentage.

     */
    private double volatility;
    /* How the volatility is calculated.
�          Daily = 1

�          Annual = 2
    */
    private int volatilityType;
    private String deltaNeutralOrderType;
    private String deltaNeutralAuxPrice;
    private int continuousUpdate;
    private int referencePriceType;
    /*
    For TRAILLIMIT orders only
     */
    private double trailStopPrice;

    private int scaleInitLevelSize;
    private int scaleSubsLevelSize;
    private double scalePriceIncrement;
    private double basisPoints;
    private int basisPointsType;
    /*
    Use to request pre-trade commissions and margin information.
If set to true, margin and commissions data is received back via the OrderState() object for the openOrder() callback.
     */
    private boolean whatif;

    public void prepareOrder(){
        m_orderId     =   orderId;
        m_clientId    =   clientId;
        m_permId      =   permId;
        m_tif         =   "GTC";
        m_transmit    =   transmit;
        // order.m_account     =   ???
        // m_lmtPrice    =   500;

    }

    public OrderStatus getStatus() {
           return status;
       }

       public void setStatus(OrderStatus status) {
           this.status = status;
       }

    public OrderObjective getObjective() {
           return objective;
       }

       public void setObjective(OrderObjective objective) {
           this.objective = objective;
       }

    public int getQuantity(){
        return m_totalQuantity;
    }

    public ContractGen getContract() {
        return contract;
    }

    public void setContract(ContractGen contract) {
        this.contract = contract;
    }

    public int getOrderParentId() {
        return orderParentId;
    }

    public void setOrderParentId(int orderParentId) {
        this.orderParentId = orderParentId;
    }

    public int getMaxMonetaryLoss() {
        return maxMonetaryLoss;
    }

    public void setMaxMonetaryLoss(int maxMonetaryLoss) {
        this.maxMonetaryLoss = maxMonetaryLoss;
    }

    public int getMaxOpenMinutes() {
        return maxOpenMinutes;
    }

    public void setMaxOpenMinutes(int maxOpenMinutes) {
        this.maxOpenMinutes = maxOpenMinutes;
    }

    public double getPriceTarget() {
        return priceTarget;
    }

    public void setPriceTarget(double priceTarget) {
        this.priceTarget = priceTarget;
    }

    public double getPriceTrailingStart() {
        return priceTrailingStart;
    }

    public void setPriceTrailingStart(double priceTrailingStart) {
        this.priceTrailingStart = priceTrailingStart;
    }

    public double getPriceTrailingDistance() {
        return priceTrailingDistance;
    }

    public void setPriceTrailingDistance(double priceTrailingDistance) {
        this.priceTrailingDistance = priceTrailingDistance;
    }

    public double getPriceStopLoss() {
        return priceStopLoss;
    }

    public void setPriceStopLoss(double priceStopLoss) {
        this.priceStopLoss = priceStopLoss;
    }

    public double getPriceToBreakEven() {
        return priceToBreakEven;
    }

    public void setPriceToBreakEven(double priceToBreakEven) {
        this.priceToBreakEven = priceToBreakEven;
    }

    public double getParentPrice() {
        return parentPrice;
    }

    public void setParentPrice(double parentPrice) {
        this.parentPrice = parentPrice;
    }

    public OrderGen getClosingOrder() {
        return closingOrder;
    }

    public void setClosingOrder(OrderGen closingOrder) {
        this.closingOrder = closingOrder;
    }
}
