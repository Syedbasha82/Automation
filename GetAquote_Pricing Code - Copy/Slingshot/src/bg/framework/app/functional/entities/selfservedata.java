//Banu's Entity file

package bg.framework.app.functional.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("SelfserveData")
public class selfservedata {
    private String Customer_ID;
    private String UCRN;
    private String Oam_Email_Address;
    private String Password;
    private String sec_que;
    private String sec_ans;
    private String Logintry_count;
    private String email_validatedflag;
    private String profile_status;
    private String Onetime_Passwordflag;

    selfservedata() {

    }

    private String getCustomerId() {
        return Customer_ID;
    }

    private String getUCRN() {
        return UCRN;
    }

    private String getOAMEmail() {
        return Oam_Email_Address;
    }

    private String getPassword() {
        return Password;
    }

    private String getSecQuestion() {
        return sec_que;
    }

    private String getSecAnswer() {
        return sec_ans;
    }

    private String getLoginTryCOunt() {
        return Logintry_count;
    }

    private String getemail_validatedflag() {
        return email_validatedflag;
    }

    private String getprofilestatus() {
        return profile_status;
    }

    private String getOneTime_PasswordFlag() {
        return Onetime_Passwordflag;
    }
}
