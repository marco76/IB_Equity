package ch.genidea.greed.web.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/29/12
 * Time: 4:21 PM
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean(name="loginBean")
@SessionScoped
public class SessionBean {

    private static final long serialVersionUID = 1L;

    private String user;
    private String password;
    private Boolean loggedIn;

    public SessionBean(){};
    public String logout(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        externalContext.invalidateSession();
        loggedIn = Boolean.FALSE;
        return "logout";
    }
    public String login() {
        if((user.equals("marco"))&&(password.equals("marco"))){
            loggedIn = Boolean.TRUE;
            return "listEquityRT";
        } else {
            return "index";
        }
    }
}
