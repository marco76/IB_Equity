package ch.genidea.greed.ib.bean;


import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: marcomolteni
 * Date: 09.07.11
 * Time: 16:57
 * To change this template use File | Settings | File Templates.
 */

@Service
public class StockArrayRT {
   // 0: stock id
    // 1: last price
    // free slots = 0

    // no enum here for performance issues
    public static final int BID_SIZE = 0;
    public static final int BID = 1;
    public static final int ASK = 2;
    public static final int ASK_SIZE = 3;
    public static final int LAST = 4;
    public static final int LAST_SIZE = 5;
    public static final int HIGH = 6;
    public static final int LOW = 7;
    public static final int VOLUME = 8;
    public static final int CLOSE = 9;
    public static final int BID_OPTION = 10;
    public static final int ASK_OPTION = 11;
    public static final int LAST_OPTION = 12;
    public static final int MODEL_OPTION = 13;
    public static final int OPEN = 14;
    public static final int LOW_13_WEEK = 15;
    public static final int HIGH_13_WEEK = 16;
    public static final int LOW_26_WEEK = 17;
    public static final int HIGH_26_WEEK = 18;
    public static final int LOW_52_WEEK = 19;
    public static final int HIGH_52_WEEK = 20;
    public static final int AVG_VOLUME = 21;
    public static final int OPEN_INTEREST = 22;
    public static final int OPTION_HISTORICAL_VOL = 23;
    public static final int OPTION_IMPLIED_VOL = 24;
    public static final int OPTION_BID_EXCH = 25;
    public static final int OPTION_ASK_EXCH = 26;
    public static final int OPTION_CALL_OPEN_INTEREST = 27;
    public static final int OPTION_PUT_OPEN_INTEREST = 28;
    public static final int OPTION_CALL_VOLUME = 29;
    public static final int OPTION_PUT_VOLUME = 30;
    public static final int INDEX_FUTURE_PREMIUM = 31;
    public static final int BID_EXCH = 32;
    public static final int ASK_EXCH = 33;
    public static final int AUCTION_VOLUME = 34;
    public static final int AUCTION_PRICE = 35;
    public static final int AUCTION_IMBALANCE = 36;
    public static final int MARK_PRICE = 37;
    public static final int BID_EFP_COMPUTATION = 38;
    public static final int ASK_EFP_COMPUTATION = 39;
    public static final int LAST_EFP_COMPUTATION = 40;
    public static final int OPEN_EFP_COMPUTATION = 41;
    public static final int HIGH_EFP_COMPUTATION = 42;
    public static final int LOW_EFP_COMPUTATION = 43;
    public static final int CLOSE_EFP_COMPUTATION = 44;
    public static final int LAST_TIMESTAMP = 45;
    public static final int SHORTABLE = 46;
    public static final int FUNDAMENTAL_RATIOS = 47;
    public static final int RT_VOLUME = 48;
    public static final int HALTED = 49;
    public static final int BID_YIELD = 50;
    public static final int ASK_YIELD = 51;
    public static final int LAST_YIELD = 52;
    public static final int CUST_OPTION_COMPUTATION = 53;
    public static final int TRADE_COUNT = 54;
    public static final int TRADE_RATE = 55;
    public static final int VOLUME_RATE = 56;
    public static final int LAST_RTH_TRADE = 57;

    int [] slots = new int[100];
    private HashMap<Integer, Integer> slotOwner = new HashMap<Integer, Integer>();
    private HashMap<Integer, Integer> slotByOwner = new HashMap<Integer, Integer>();


    public Integer getNextSlot(Integer equityId){
        for (int i = 0; i<100; i++){
            // free slots
            if (slots[i] == 0){
              slots[i] = 1;
              slotOwner.put(i, equityId);
              slotByOwner.put(equityId, i);
              return i;

            }
        }
        return -1;
    }

    double[][] array = new double[100][50];
    long [] timestampArray = new long[100];


    public void update(int tickerId, int field, double value){
        array[tickerId][field] = value;
        timestampArray[tickerId] = System.currentTimeMillis();
    }

    public Integer getSlotPosition(Integer equityId){
        return slotByOwner.get(equityId);

    }

    public Double getPrice(Integer position, int field){
        return array[position][field];
    }

    public Double getAskBidSpread(Integer position){
        return array[position][2] - array[position][1];
    }



}
