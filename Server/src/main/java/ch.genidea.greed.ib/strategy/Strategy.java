package ch.genidea.greed.ib.strategy;

import ch.genidea.greed.ib.bean.StockArrayRT;
import ch.genidea.greed.ib.wrapper.ContractGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/21/12
 * Time: 6:51 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public  abstract class Strategy {
       private String name = "Basic strategy";
        @Autowired
        protected StockArrayRT stockArrayRT;
        private ContractGen contract = new ContractGen();
        private double triggerPriceUp;
        private double triggerPriceDown;
        private boolean priceUpTriggered;
        private boolean priceDownTriggered;
        protected abstract void triggerUpAction(double currentPrice);
        protected abstract void triggerDownAction(double currentPrice);
         enum Status {STATUS_BOTTOM_TARGET, STATUS_BETWEEN_TARGETS, STATUS_OVER_TARGET};
        Status status = Status.STATUS_BETWEEN_TARGETS;


        public abstract void execute();


    protected void checkRealTimePrices(double price, int field) {
         if (field == StockArrayRT.BID){
             if (status == Status.STATUS_BETWEEN_TARGETS){
                 // if bid > price down
                 if (price > triggerPriceUp){
                     triggerUpAction(price);
                     priceUpTriggered = true;
                     status =  Status.STATUS_OVER_TARGET;
                 }
             }
         }
         if (field == StockArrayRT.ASK){
             if (status == Status.STATUS_BETWEEN_TARGETS){
                 if (price < triggerPriceDown){
                         triggerDownAction(price);
                         priceDownTriggered = true;
                         status = Status.STATUS_BOTTOM_TARGET;
                     }
                 }

         }
    }
    protected  void checkStaticPrices(){
            if (status == Status.STATUS_BETWEEN_TARGETS){
                // if bid > price down
                if (stockArrayRT.getPrice((int)contract.getEquityID(), StockArrayRT.BID)>triggerPriceUp){

                        triggerUpAction(stockArrayRT.getPrice((int)contract.getEquityID(), StockArrayRT.BID));
                        priceUpTriggered = true;
                        status =  Status.STATUS_OVER_TARGET;
                } else {
                        if (stockArrayRT.getPrice((int)contract.getEquityID(), StockArrayRT.ASK)<triggerPriceDown){
                            triggerDownAction(stockArrayRT.getPrice((int)contract.getEquityID(), StockArrayRT.ASK));
                        priceDownTriggered = true;
                        status = Status.STATUS_BOTTOM_TARGET;
                        }

                }



                    }


        }
    ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ContractGen getContract() {
        return contract;
    }

    public void setContract(ContractGen contract) {
        this.contract = contract;
    }

    public double getTriggerPriceUp() {
        return triggerPriceUp;
    }

    public void setTriggerPriceUp(double triggerPriceUp) {
        this.triggerPriceUp = triggerPriceUp;
    }

    public double getTriggerPriceDown() {
        return triggerPriceDown;
    }

    public void setTriggerPriceDown(double triggerPriceDown) {
        this.triggerPriceDown = triggerPriceDown;
    }

    public boolean isPriceUpTriggered() {
        return priceUpTriggered;
    }

    public void setPriceUpTriggered(boolean priceUpTriggered) {
        this.priceUpTriggered = priceUpTriggered;
    }

    public boolean isPriceDownTriggered() {
        return priceDownTriggered;
    }

    public void setPriceDownTriggered(boolean priceDownTriggered) {
        this.priceDownTriggered = priceDownTriggered;
    }
}
