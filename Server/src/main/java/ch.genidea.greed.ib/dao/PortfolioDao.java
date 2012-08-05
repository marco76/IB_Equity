package ch.genidea.greed.ib.dao;

import ch.genidea.greed.ib.bean.PortfolioElement;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/18/12
 * Time: 9:49 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PortfolioDao {
    void cleanPorfolio();

    void save(PortfolioElement portfolioElement);

    List<PortfolioElement> getAll();

    PortfolioElement getById(long id);

    PortfolioElement getByTicker(String ticker);

    void resetPortfolio();
}
