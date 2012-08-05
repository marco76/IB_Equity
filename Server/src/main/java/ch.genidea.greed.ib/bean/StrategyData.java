package ch.genidea.greed.ib.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/22/12
 * Time: 1:59 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class StrategyData {
    @Id
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
