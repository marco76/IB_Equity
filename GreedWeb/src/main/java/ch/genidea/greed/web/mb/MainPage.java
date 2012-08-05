package ch.genidea.greed.web.mb;

import ch.genidea.greed.ib.bean.AccountInfo;
import ch.genidea.greed.ib.service.AccountService;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.MeterGaugeChartModel;
import org.springframework.context.annotation.Scope;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 3/25/12
 * Time: 11:07 AM
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean(name="mainPage")
@RequestScoped
@Scope("request")
public class MainPage implements Serializable {
    @ManagedProperty("#{accountService}")
    private AccountService accountService;

    private AccountInfo accountInfoLast;
    private MeterGaugeChartModel meterGaugeModel;
    private CartesianChartModel linearModel;
    private int linearMax = 25000;
    private int linearMin = 25000;


    private List<Number> intervals = null;
    public MainPage(){
        intervals = new ArrayList<Number>(){{
        add(20000);
        add(24000);
        add(25000);
        add(27000);
        add(50000);}
        };

    }

    public List<AccountInfo> getAccountData(){
        List<AccountInfo> accounts =
                accountService.getFindLasts(5);
        return accounts;
    }


    public AccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountService accountInfoService) {
        this.accountService = accountInfoService;
    }


    public MeterGaugeChartModel getMeterGaugeModel() {
        meterGaugeModel = (new MeterGaugeChartModel("$", accountService.getLastAccountInfo().getNetLiquidation(), intervals));
        return meterGaugeModel;
    }

    public void setMeterGaugeModel(MeterGaugeChartModel meterGaugeModel) {
        this.meterGaugeModel = meterGaugeModel;
    }


    public CartesianChartModel getLinearModel() {
        linearModel = new CartesianChartModel();
        LineChartSeries series = new LineChartSeries();
        series.setLabel("amount");
        List<AccountInfo> accountHistory = accountService.getFindLasts(100);
        int serieNo = 100;
        for (AccountInfo account:accountHistory){
            series.set(serieNo--, account.getNetLiquidation());
        }
        linearModel.addSeries(series);
        BigDecimal net = accountService.getLastAccountInfo().getNetLiquidation();
        linearMax = net.add(new BigDecimal(500)).intValue();
        linearMin = net.subtract(new BigDecimal(500)).intValue();
        return linearModel;
    }

    public void setLinearModel(CartesianChartModel linearModel) {
        this.linearModel = linearModel;
    }

    public int getLinearMax() {
        return linearMax;
    }

    public void setLinearMax(int linearMax) {
        this.linearMax = linearMax;
    }

    public int getLinearMin() {
        return linearMin;
    }

    public void setLinearMin(int linearMin) {
        this.linearMin = linearMin;
    }

    public AccountInfo getAccountInfoLast() {
        if (accountInfoLast == null){
            accountInfoLast = accountService.getLastAccountInfo();
        }
        return accountInfoLast;
    }

    public void setAccountInfoLast(AccountInfo accountInfoLast) {
        this.accountInfoLast = accountInfoLast;
    }
}
