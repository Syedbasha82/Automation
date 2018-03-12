package bg.framework.app.functional.entities;


import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("SMRAccountDetails")
public class SMRAccountDetails {

    private String address;
    private String accountType;
    private String lastMeterRead;
    private String afterSubmitMeterRead;
    private String meterSerialNumber;
    private String actualReadOn;
    private String lastMeterReadDay;
    private String lastMeterReadNight;
    private String previousBalance;
    private String lastMeterReadElectricity;
    private String lastMeterReadGas;
    private String meterSerialNumberElectricity;
    private String meterSerialNumberGas;
    private String auditDetails;

    public SMRAccountDetails() {
    }

    public String getAddress() {
        return address;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getLastMeterRead() {
        return lastMeterRead;
    }

    public String getAfterSubmitMeterRead() {
        return afterSubmitMeterRead;
    }

    public String getMeterSerialNumber() {
        return meterSerialNumber;
    }


    public String getActualReadOn() {
        return actualReadOn;
    }

    public String getLastMeterReadDay() {
        return lastMeterReadDay;
    }

    public String getLastMeterReadNight() {
        return lastMeterReadNight;
    }

    public String getPreviousBalance() {
        return previousBalance;
    }

    public String getLastMeterReadElectricity() {
        return lastMeterReadElectricity;
    }

    public String getLastMeterReadGas() {
        return lastMeterReadGas;
    }

    public String getMeterSerialNumberElectricity() {
        return meterSerialNumberElectricity;
    }

    public String getMeterSerialNumberGas() {
        return meterSerialNumberGas;
    }

    public String getAuditDetails() {
        return auditDetails;
    }
}
