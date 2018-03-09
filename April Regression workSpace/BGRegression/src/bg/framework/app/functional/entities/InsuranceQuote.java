package bg.framework.app.functional.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("InsuranceQuote")
public class InsuranceQuote {
    private String houseName;
    private String phoneNumber;
    private String postCode;
    private boolean boiler;
    private boolean heating;
    private boolean plumbing;
    private boolean electrics;
    private boolean annualService;
    private int excess1;
    private int excess2;
    private boolean emergency;
    private boolean pipe;
    private boolean applianceCover;
    private boolean appliance1;
    private boolean appliance2;
    private boolean appliance3;
    private int noOfAppliances;
    private String paymentType;
    private String national;
    private String london;
    private String online_name;
    private String db_name;
    private String LOS1;
    private String LOS2;
    private String LOS3;
    private String monthlyPrice;
    private String annualPrice;
    private String firstName;

    public InsuranceQuote() {
    }

    public InsuranceQuote(String firstName,String monthlyPrice,String annualPrice,String postCode, String houseName, String phoneNumber,boolean boiler, boolean heating,
                          boolean plumbing, boolean electrics, boolean annualService, int excess1, int excess2,boolean emergency, boolean pipe,
                          boolean applianceCover,String NationalAnnual,String LondonAnnual,
                          boolean appliance1,boolean appliance2, boolean appliance3, int noOfAppliances, String paymentType, String online_name, String db_name, String LOS1, String LOS2, String LOS3) {
        this.national=NationalAnnual;
        this.london = LondonAnnual;
        this.houseName = houseName;
        this.phoneNumber = phoneNumber;
        this.postCode = postCode;
        this.boiler = boiler;
        this.heating = heating;
        this.plumbing = plumbing;
        this.electrics = electrics;
        this.annualService = annualService;
        this.excess1 = excess1;
        this.excess2 = excess2;
        this.emergency = emergency;
        this.pipe = pipe;
        this.appliance1 = appliance1;
        this.appliance2 = appliance2;
        this.appliance3 = appliance3;
        this.applianceCover = applianceCover;
        this.noOfAppliances = noOfAppliances;
        this.paymentType=paymentType;
        this.online_name=online_name;
        this.db_name=db_name;
        this.LOS1 = LOS1;
        this.LOS2 = LOS2;
        this.LOS3 = LOS3;
        this.monthlyPrice=monthlyPrice;
        this.annualPrice=annualPrice;
        this.firstName=firstName;
    }

    public String getPostCode() {
        return postCode;
    }
    public void setPostCode(String value) {
    	this.postCode=value;
    }
    public String getHouseName() {
        return houseName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String value) {
    	this.phoneNumber=value;
    }
    public boolean getBoiler() {
        return boiler;
    }

    public boolean getHeating() {
        return heating;
    }

    public boolean getPlumbing() {
        return plumbing;
    }

    public boolean getElectrics() {
        return electrics;
    }

    public boolean getAnnualService() {
        return annualService;
    }

    public int getExcess1() {
        return excess1;
    }

    public int getExcess2() {
        return excess2;
    }
    public boolean getEmergency() {
        return emergency;
    }

    public boolean getPipe() {
        return pipe;
    }

    public boolean getAppliance1() {
        return appliance1;
    }

    public boolean getAppliance2() {
        return appliance2;
    }

    public boolean getAppliance3() {
        return appliance3;
    }
    public boolean getAppliancecover(){
        return applianceCover;
    }
    public int getNoOfAppliances(){
        return noOfAppliances;
    }
    public String getPaymentType(){
        return paymentType;
    }
    public String getLondonAnnual(){
        return london;
    }
    public String getNationalAnnual(){
        return national;
    }
    public String getDb_name(){
        return db_name;
    }
    public String getOnline_name(){
        return online_name;
    }
    public String getLOS1(){
        return LOS1;
    }
    public String getLOS2(){
        return LOS2;
    }
    public String getLOS3(){
        return LOS3;
    }
    public String getMonthlyPrice(){
    	return monthlyPrice;
    }
    public String getAnnualPrice(){
    	return annualPrice;
    }
    public String getFirstName(){
    	return firstName;
    }
    
    
}
