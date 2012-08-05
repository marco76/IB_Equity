package ch.genidea.greed.ib.constants;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 5/1/12
 * Time: 7:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class FundamentalDataConstants {
    public static enum REPORT_TYPE {
        ESTIMATES {
            public String toString() {
                return "estimates";
            }
        },

        FINANCIAL_STATEMENTS {
            public String toString() {
                return "finstat";
            }
        }
        ,

        SUMMARY {
            public String toString() {
                return "snapshot";
            }
        }
    }
}
