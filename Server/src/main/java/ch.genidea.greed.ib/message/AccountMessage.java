package ch.genidea.greed.ib.message;

/**
 * Created by IntelliJ IDEA.
 * User: marcomolteni
 * Date: 19.06.11
 * Time: 13:39
 * To change this template use File | Settings | File Templates.
 */
public class AccountMessage {
    private String type;
    private Double value;
    private String currency;
    private String accountName;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
