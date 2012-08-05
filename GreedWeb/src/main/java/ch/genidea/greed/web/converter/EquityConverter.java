package ch.genidea.greed.web.converter;

import ch.genidea.greed.ib.bean.Equity;
import ch.genidea.greed.ib.service.EquityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/29/12
 * Time: 6:33 PM
 * To change this template use File | Settings | File Templates.
 */
@Component("equityConverter")
public class EquityConverter implements Converter {

    @Autowired
    EquityService equityService;
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String submittedValue) {
        if (submittedValue.trim().equals("")) {
            return null;
        } else {
              return equityService.getEquityByTicker(submittedValue);
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((Equity) value).getTicker());
        }
    }
}
