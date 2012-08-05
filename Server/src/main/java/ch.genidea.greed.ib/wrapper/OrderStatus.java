package ch.genidea.greed.ib.wrapper;

/**
 * Created by IntelliJ IDEA.
 * User: marcomolteni
 * Date: 09.07.11
 * Time: 12:24
 * To change this template use File | Settings | File Templates.
 */
public class OrderStatus {



    public enum Status {PendingSubmit, PendingCancel, PreSubmitted, Submitted, Cancelled, Filled, Inactive}
    private int id;
    private Status status;
    private int filled;
    private int remaining;
    private double avgFillPrice;
    private int permiId;
    private int parentId;
    private double lastFillPrice;
    private int clientId;
    private String whyHeld;

     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getFilled() {
        return filled;
    }

    public void setFilled(int filled) {
        this.filled = filled;
    }

    public double getAvgFillPrice() {
        return avgFillPrice;
    }

    public void setAvgFillPrice(double avgFillPrice) {
        this.avgFillPrice = avgFillPrice;
    }

    public void setRemaining(int remaining) {
      this.remaining = remaining;
    }


}
