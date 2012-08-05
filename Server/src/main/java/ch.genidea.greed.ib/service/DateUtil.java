package ch.genidea.greed.ib.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/26/12
 * Time: 8:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class DateUtil {

    public static Integer convertDateToInt(Date date){
    String DATE_FORMAT = "yyyyMMdd";
    SimpleDateFormat sdf =
            new SimpleDateFormat(DATE_FORMAT);

    Calendar c1 = Calendar.getInstance(); // today
    System.out.println("Today is " + sdf.format(date));
        return  Integer.decode(sdf.format(c1.getTime()));
    }
}
