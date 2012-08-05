package ch.genidea.greed.db.loader;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: marcomolteni
 * Date: 22.06.11
 * Time: 22:38
 * To change this template use File | Settings | File Templates.
 */
public class StockData {
    int tickerId;
    int date;
    BigDecimal open;
    BigDecimal close;
    BigDecimal high;
    BigDecimal low;
    long volume;

    public StockData(){
        open = new BigDecimal(0);
        close = new BigDecimal(0);
        high = new BigDecimal(0);
        low = new BigDecimal(0);
    }

    public int getTickerId() {
        return tickerId;
    }

    public void setTickerId(int tickerId) {
        this.tickerId = tickerId;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public BigDecimal getClose() {
        return close;
    }

    public void setClose(BigDecimal close) {
        this.close = close;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }
}
