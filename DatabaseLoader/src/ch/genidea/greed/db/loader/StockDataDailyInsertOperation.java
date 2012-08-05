package ch.genidea.greed.db.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.lang.reflect.Type;
import java.sql.Types;

/**
 * Created by IntelliJ IDEA.
 * User: marcomolteni
 * Date: 22.06.11
 * Time: 22:29
 * To change this template use File | Settings | File Templates.
 */

public class StockDataDailyInsertOperation extends SqlUpdate {


    public StockDataDailyInsertOperation(DataSource dataSource){
        setDataSource(dataSource);
        setSql("INSERT INTO PRICE_DATA_DAILY (TICKER, DATE, OPEN, CLOSE, HIGH, LOW, VOLUME) VALUES (?,?,?,?,?,?,?)");
        declareParameter(new SqlParameter(Types.INTEGER));
        declareParameter(new SqlParameter(Types.INTEGER));
        declareParameter(new SqlParameter(Types.DECIMAL));
        declareParameter(new SqlParameter(Types.DECIMAL));
        declareParameter(new SqlParameter(Types.DECIMAL));
        declareParameter(new SqlParameter(Types.DECIMAL));
        declareParameter(new SqlParameter(Types.DECIMAL));
    }

    public void perform (StockData stockData){
        update(new Object[] {stockData.getTickerId(), stockData.getDate(), stockData.getOpen(), stockData.getHigh(), stockData.getLow(), stockData.getClose(), stockData.getVolume()});
    }
}
