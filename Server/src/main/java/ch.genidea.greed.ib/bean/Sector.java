package ch.genidea.greed.ib.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/29/12
 * Time: 11:26 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Sector {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private
    Integer id;

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
