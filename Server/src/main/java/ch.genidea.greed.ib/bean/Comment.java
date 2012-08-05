package ch.genidea.greed.ib.bean;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/26/12
 * Time: 8:18 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)

    Long id;

    @Column( columnDefinition="TEXT")
    String comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
