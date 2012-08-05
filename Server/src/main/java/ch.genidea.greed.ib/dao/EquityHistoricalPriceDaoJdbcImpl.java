package ch.genidea.greed.ib.dao;

import ch.genidea.greed.ib.bean.Equity;
import ch.genidea.greed.ib.bean.EquityHistoricalPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/30/12
 * Time: 6:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class EquityHistoricalPriceDaoJdbcImpl implements EquityHistoricalPriceDao {
    @Autowired
    DataSource dataSource;
    @Override
    public void save(EquityHistoricalPrice price) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<EquityHistoricalPrice> getPricesFor(Equity equity) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
    @Override
    @Transactional
    public void insertBatch(final List<EquityHistoricalPrice> prices){
        String sql = "INSERT INTO EquityHistoricalPrice (dateInt, equityId, adjClose, close, high, low, open, volume, equity_id)" +
                "values (?,?,?,?,?,?,?,?,?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                EquityHistoricalPrice equityHistoricalPrice = prices.get(i);
                preparedStatement.setInt(1, equityHistoricalPrice.getDateInt());
                preparedStatement.setLong(2, equityHistoricalPrice.getEquity().getId());
                preparedStatement.setDouble(3, equityHistoricalPrice.getAdjClose());
                preparedStatement.setDouble(4, equityHistoricalPrice.getClose());
                preparedStatement.setDouble(5, equityHistoricalPrice.getHigh());
                preparedStatement.setDouble(6, equityHistoricalPrice.getLow());
                preparedStatement.setDouble(7, equityHistoricalPrice.getOpen());
                preparedStatement.setLong(8, equityHistoricalPrice.getVolume());
                preparedStatement.setLong(9, equityHistoricalPrice.getEquity().getId());
           }

            @Override
            public int getBatchSize() {
                return prices.size();  //To change body of implemented methods use File | Settings | File Templates.
            }
        });
    }
}
