package bg.framework.app.functional.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import static org.apache.commons.lang.StringUtils.isNotEmpty;
import static org.apache.commons.lang.StringUtils.trim;

@XStreamAlias("Acquisition")
public class Acquisition {

    private String firstName;
    private String lastName;
    private String title;
    private String email;
    private String password;
    private String mobileNumber;
    private String homeNumber;
    private String workNumber;
    private String ucrn;
    private String tariff;
    private String fuelType;
    private String gasSupplier;
    private String elecSupplier;
    private String accountNumber;
    private String paymentType;
    private String sortCode1;
    private String sortCode2;
    private String sortCode3;
    private String accountName;
    private String payday;
    private String currentGasSupplier;
    private String currentElecSupplier;
    private String day;
    private String month;
    private String year;
    private String telephoneType;
    private String emailType;
    private String postCode;
    private String address;
    private String monthsLived;
    private String yearsLived;
    private String tariffForElectricity;
    private String tariffForGas;
    private String tariffForDual;
    private String createPassword;
    private String retypePassword;
    private String securityQuestion;
    private String securityAnswer;
    private String gasAccountNumber;
    private String elecAccountNumber;
    private String cardType;
    private String cardName;
    private String cardNumber;
    private String startMonth;
    private String startYear;
    private String expiryMonth;
    private String expiryYear;
    private String cvvCode;
    private String threedSecure;
    private String secureCode;
    private String salesShopBatch;
    private String salesSmartBatch;
    private String standardCode;
    private String standardEE50Code;
    private String energysmartcode;
    private String gasonlineenergyTariffCode;
    private String eleconlineenergyTariffCode;
    private String dualonlineenergyTariffCode;
    private String gasfixedprice2013TariffCode;
    private String elecfixedprice2013TariffCode;
    private String dualfixedprice2013TariffCode;
    private String energyshareTariffCode;
    private String energysmartCode;
    private String gasCSCode;
    private String elecCSCode;
    private String dualCSCode;
    private String sapGasCSCode;
    private String sapElecCSCode;
    private String sapGasFPcode;
    private String sapElecFPcode;
    private String sapGasOVcode;
    private String sapElecOVcode;
    private String fusionGasCScode;
    private String fusionElecCScode;
    private String fusionDualCScode;
    private String fusionGasOVA2103code;
    private String fusionElecOVA2103code;
    private String fusionDualOVA2103code;
    private String fusionGasFPM2014code;
    private String fusionElecFPM2014CScode;
    private String fusionDualFPM2014CScode;
    private String smartmetergasyes;
    private String smartmetergasno;
    private String smartmeterelecyes;
    private String smartmeterelecno;
    private String tariffClearSimple;
    private String tariffOnlineVariable;
    private String tariffFixFall;
    private String monthlyVDD;
    private String monthlyFixedDD;
    private String monthlyDebCredCard;
    private String visaDebit;
    private String visaDelta;
    private String masterCard;
    private String maestro;
    private String cardNumberVDebit;
    private String expiryMonthVDebit;
    private String expiryYearVDebit;
    private String cvvCodeVDebit;
    private String cardNumberVDelta;
    private String expiryMonthVDelta;
    private String expiryYearVDelta;
    private String cvvCodeVDelta;
    private String cardNumberMaster;
    private String expiryMonthMaster;
    private String expiryYearMaster;
    private String cvvCodeMaster;
    private String cardNumberMaestro;
    private String expiryMonthMaestro;
    private String expiryYearMaestro;
    private String cvvCodeMaestro;
    private String region;
    private int indexNo;
    
    
    


    public Acquisition() {
    }

    public Acquisition(String smartmetergasyes,String smartmetergasno,String fusionGasCScode,String fusionElecCScode,String fusionDualCScode, String sapGasCSCode,String sapElecCSCode, String sapGasFPcode,String sapElecFPcode,String sapGasOVcode,String sapElecOVcode,String ucrn, String firstName, String lastName, String title, String email, String postCode, String address, String monthsLived, String tariffForGas, String createPassword, String gasAccountNumber, String cardNumber, String expiryYear,String salesSmartBatch, String energysmartcode,String dualonlineenergyTariffCode,String energysmartCode,
    				   String smartmeterelecyes,String smartmeterelecno,String fusionGasOVA2103code,String fusionElecOVA2103code,String fusionDualOVA2103code,String gasCSCode,String password, String gasSupplier, String elecSupplier, String currentGasSupplier, String currentElecSupplier, String yearsLived, String tariffForDual, String retypePassword, String elecAccountNumber, String startMonth, String cvvCode,String standardCode,String gasonlineenergyTariffCode,String gasfixedprice2013TariffCode,
    		           String fusionGasFPM2014code,String fusionElecFPM2014CScode,String fusionDualFPM2014CScode,String elecCSCode,String mobileNumber, String homeNumber, String workNumber, String tariff, String fuelType, String paymentType, String tariffForElectricity, String securityQuestion, String securityAnswer, String cardType, String startYear, String secureCode,String standardEE50Code,String eleconlineenergyTariffCode,String elecfixedprice2013TariffCode,
                       String dualCSCode,String accountNumber, String sortCode1, String sortCode2, String sortCode3, String accountName, String payday, String day, String month, String year, String emailType, String telephoneType, String cardName, String expiryMonth,String salesShopBatch,String dualfixedprice2013TariffCode, String energyshareTariffCode,String tariffClearSimple,String tariffOnlineVariable,String tariffFixFall,String monthlyVDD,String monthlyFixedDD,String monthlyDebCredCard,
                       String visaDebit,String visaDelta,String masterCard,String maestro,String cardNumberVDebit,String expiryMonthVDebit,String expiryYearVDebit,
                       String cvvCodeVDebit,String cardNumberVDelta,String expiryMonthVDelta,String expiryYearVDelta,String cvvCodeVDelta,String cardNumberMaster,String expiryMonthMaster,String expiryYearMaster,
                       String cvvCodeMaster,String cardNumberMaestro,String expiryMonthMaestro,String expiryYearMaestro,String cvvCodeMaestro,String region, int indexNo) {
    	
    	this.smartmetergasyes=smartmetergasyes;
    	this.smartmetergasno=smartmetergasno;
    	this.smartmeterelecyes=smartmeterelecyes;
    	this.smartmeterelecno=smartmeterelecno;
    	this.ucrn = ucrn;
        this.sapGasCSCode=sapGasCSCode;
        this.sapElecCSCode=sapElecCSCode;
        this.sapGasFPcode=sapGasFPcode;
        this.sapElecFPcode=sapElecFPcode;
        this.sapGasOVcode=sapGasOVcode;
        this.sapElecOVcode=sapElecOVcode;
        this.email = email;
        this.gasCSCode=gasCSCode;
        this.elecCSCode=elecCSCode;
        this.dualCSCode=dualCSCode;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.homeNumber = homeNumber;
        this.workNumber = workNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.tariff = tariff;
        this.fuelType = fuelType;
        this.gasSupplier = gasSupplier;
        this.elecSupplier = elecSupplier;
        this.paymentType = paymentType;
        this.accountNumber = accountNumber;
        this.sortCode1 = sortCode1;
        this.sortCode2 = sortCode2;
        this.sortCode3 = sortCode3;
        this.accountName = accountName;
        this.payday = payday;
        this.currentGasSupplier = currentGasSupplier;
        this.currentElecSupplier = currentElecSupplier;
        this.day = day;
        this.month = month;
        this.year = year;
        this.homeNumber = homeNumber;
        this.telephoneType = telephoneType;
        this.postCode = postCode;
        this.address = address;
        this.yearsLived = yearsLived;
        this.monthsLived = monthsLived;
        this.tariffForElectricity = tariffForElectricity;
        this.tariffForGas = tariffForGas;
        this.tariffForDual = tariffForDual;
        this.createPassword = createPassword;
        this.retypePassword = retypePassword;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
        this.gasAccountNumber = gasAccountNumber;
        this.elecAccountNumber = elecAccountNumber;
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.startMonth = startMonth;
        this.startYear = startYear;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
        this.cvvCode = cvvCode;
        this.secureCode = secureCode;
        this.salesShopBatch=salesShopBatch;
        this.salesSmartBatch=salesSmartBatch;
        this.standardCode=standardCode;
        this.standardEE50Code=standardEE50Code;
        this.energysmartcode=energysmartcode;
        this.gasonlineenergyTariffCode=gasonlineenergyTariffCode;
        this.eleconlineenergyTariffCode=eleconlineenergyTariffCode;
        this.dualonlineenergyTariffCode = dualonlineenergyTariffCode;
        this.gasfixedprice2013TariffCode= gasfixedprice2013TariffCode;
        this.elecfixedprice2013TariffCode= elecfixedprice2013TariffCode;
        this.dualfixedprice2013TariffCode=dualfixedprice2013TariffCode;
        this.energyshareTariffCode= energyshareTariffCode;
        this.energysmartCode=energysmartCode;
        this.fusionGasCScode=fusionGasCScode;
        this.fusionElecCScode=fusionElecCScode;
        this.fusionDualCScode=fusionDualCScode;
        this.fusionGasOVA2103code=fusionGasOVA2103code;
        this.fusionElecOVA2103code=fusionElecOVA2103code;
        this.fusionDualOVA2103code=fusionDualOVA2103code;
        this.fusionGasFPM2014code=fusionGasFPM2014code;
        this.fusionElecFPM2014CScode=fusionElecFPM2014CScode;
        this.fusionDualFPM2014CScode=fusionDualFPM2014CScode;
        this.tariffClearSimple=tariffClearSimple;
        this.tariffOnlineVariable=tariffOnlineVariable;
        this.tariffFixFall=tariffFixFall;
        this.monthlyVDD=monthlyVDD;
    	this.monthlyFixedDD=monthlyFixedDD;
    	this.monthlyDebCredCard=monthlyDebCredCard;
    	this.visaDebit=visaDebit;
    	this.visaDelta=visaDelta;
    	this.masterCard=masterCard;
    	this.maestro=maestro;
    	this.cardNumberVDebit=cardNumberVDebit;
    	this.expiryMonthVDebit=expiryMonthVDebit;
    	this.expiryYearVDebit=expiryYearVDebit;
    	this.cvvCodeVDebit=cvvCodeVDebit;
    	this.cardNumberVDelta=cardNumberVDelta;
    	this.expiryMonthVDelta=expiryMonthVDelta;
    	this.expiryYearVDelta=expiryYearVDelta;
    	this.cvvCodeVDelta=cvvCodeVDelta;
    	this.cardNumberMaster=cardNumberMaster;
    	this.expiryMonthMaster=expiryMonthMaster;
    	this.expiryYearMaster=expiryYearMaster;
    	this.cvvCodeMaster=cvvCodeMaster;
    	this.cardNumberMaestro=cardNumberMaestro;
    	this.expiryMonthMaestro=expiryMonthMaestro;
    	this.expiryYearMaestro=expiryYearMaestro;
    	this.cvvCodeMaestro=cvvCodeMaestro;
    	this.region= region;
    	this.indexNo=indexNo;
    }
    
    public String getcardNumberVDebit(){
    	return cardNumberVDebit;
    }
    public String getexpiryMonthVDebit(){
    	return expiryMonthVDebit;
    }
    public String getexpiryYearVDebit(){
    	return expiryYearVDebit;
    }
    public String getcvvCodeVDebit(){
    	return cvvCodeVDebit;
    }
    public String getcardNumberVDelta(){
    	return cardNumberVDelta;
    }
    public String getexpiryMonthVDelta(){
    	return expiryMonthVDelta;
    }
    public String getexpiryYearVDelta(){
    	return expiryYearVDelta;
    }
    public String getcvvCodeVDelta(){
    	return cvvCodeVDelta;
    }
    public String getcardNumberMaster(){
    	return cardNumberMaster;
    }
    public String getexpiryMonthMaster(){
    	return expiryMonthMaster;
    }
    public String getexpiryYearMaster(){
    	return expiryYearMaster;
    }
    public String getcvvCodeMaster(){
    	return cvvCodeMaster;
    }
    public String getcardNumberMaestro(){
    	return cardNumberMaestro;
    }
    public String getexpiryMonthMaestro(){
    	return expiryMonthMaestro;
    }
    public String getexpiryYearMaestro(){
    	return expiryYearMaestro;
    }
    public String getcvvCodeMaestro(){
    	return cvvCodeMaestro;
    }
    public String getRegion(){
    	return region;
    }
    public int getIndexNo(){
    	return indexNo;
    }
    
    public String getMonthlyVDD(){
    	return monthlyVDD;
    }
    public String getMonthlyFixedDD(){
    	return monthlyFixedDD;
    }
    public String getMonthlyDebCredCard(){
    	return monthlyDebCredCard;
    }
    public String getVisaDebit(){
    	return visaDebit;
    }
    public String getVisaDelta(){
    	return visaDelta;
    }
    public String getMasterCard(){
    	return masterCard;
    }
    public String getMaestro(){
    	return maestro;
    }
    public String gettariffClearSimple(){
    	return tariffClearSimple;
    }
    
    public String gettariffOnlineVariable(){
    	return tariffOnlineVariable;
    }
    
    public String gettariffFixFall(){
    	return tariffFixFall;
    }

    public String getSmartMeterGasYes(){
    	return smartmetergasyes;   	
    }
    
    public String getSmartMeterGasNo(){
    	return smartmetergasno;
    }

    public String getSmartMeterElecYes(){
    	return smartmeterelecyes;
    }
    
    public String getSmartMeterElecNo(){
    	return smartmeterelecno;
    }
    
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    
    public String sapCSGas() { 	
    	return sapGasCSCode;
    }
	public String sapCSElec() {
	    	
	    	return sapElecCSCode;
	    }
	public String sapFPGas() {
		
		return sapGasFPcode;
	}
	public String sapFPElec() {
		
		return sapElecFPcode;
	}
	public String sapOVGas() {
		
		return sapGasOVcode;
	}
	public String sapOVElec() {
		
		return   sapElecOVcode;
	}
	
	    
    public String getShopBatch(){
    	return salesShopBatch;
    }
    
    public String getSmartBatch(){
    	return salesSmartBatch;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public String getUcrn() {
        return ucrn;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTitle() {
        return title;
    }

    public String getTariff() {
        return tariff;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getGasSupplier() {
        return gasSupplier;
    }

    public String getElecSupplier() {
        return elecSupplier;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public String getPaymentAccountNumber() {
        return accountNumber;
    }

    public String getSortCode1() {
        return sortCode1;
    }

    public String getSortCode2() {
        return sortCode2;
    }

    public String getSortCode3() {
        return sortCode3;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getPayDay() {
        return payday;
    }

    public String getCurrentGasSupplier() {
        return currentGasSupplier;
    }

    public String getCurrentElecSupplier() {
        return currentElecSupplier;
    }

    public String getDay() {
        return day;
    }

    public String getEmailtype() {
        return emailType;
    }

    public String getMonth() {
        return month;
    }

    public String getTelephonetype() {
        return telephoneType;
    }

    public String getYear() {
        return year;
    }

    public String getPostcode() {
        return postCode;
    }

    public String getAddress() {
        return address;
    }

    public String getMonthsLived() {
        return monthsLived;
    }

    public String getYearsLived() {
        return yearsLived;
    }

    public String getTarifffordual() {
        return tariffForDual;
    }

    public String getTariffforelectricity() {
        return tariffForElectricity;
    }

    public String getTariffforgas() {
        return tariffForGas;
    }

    public String getCreatePassword() {
        return createPassword;
    }

    public String getRetypePassword() {
        return retypePassword;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public String getGasAccountNumber() {
        return gasAccountNumber;
    }

    public String getElecAccountNumber() {
        return elecAccountNumber;
    }

    public String getCardName() {
        return cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public String getStartMonth() {
        return startMonth;
    }

    public String getStartYear() {
        return startYear;
    }

    public String getExpiryMonth() {
        return expiryMonth;
    }

    public String getExpiryYear() {
        return expiryYear;
    }
    
    public String getthreedSecure() {
        return threedSecure;
    }
    
    public String getCvvCode() {
        return cvvCode;
    }

    public String getSecureCode() {
        return secureCode;
    }
    
    public String getStandardCode(){
    	return standardCode;
    }
    
    public String getStandardEE50Code(){
    	return standardEE50Code;
    }
    
   
    
    public String getGasonlineenergyTariffCode(){
    	return gasonlineenergyTariffCode;
    }
    
    public String getEleconlineenergyTariffCode(){
    	 return eleconlineenergyTariffCode;
    }
    
    public String getDualonlineenergyTariffCode(){
    	return dualonlineenergyTariffCode;
    }
    
    public String getGasFP2013TariffCode(){
    	return gasfixedprice2013TariffCode;

    }
    
    public String getElecFP2013TariffCode(){
    	return elecfixedprice2013TariffCode;
    }
    
    public String getDualFP2013TariffCode(){
    	return dualfixedprice2013TariffCode;
    }
    
    public String getEnergyShareTariffCode(){
    	return energyshareTariffCode;
    }
    
    public String getEnergySmartCode(){
    	return energysmartCode;
    }
    
    public String getGasCsCode(){
    	return gasCSCode;
    	
    }
    
    public String getElecCsCode(){
    	return elecCSCode;
    	
    }
    
    public String getDualCsCode(){
    	return dualCSCode;
    	
    }
    public String getFusionGasCScode(){
        return fusionGasCScode;
    }
    
    public String getFusionDualCScode(){
        return fusionDualCScode;
    } 
    public String getFusionElecCScode(){
        return fusionElecCScode;
    }
    
    public String getFusionGasOVA2013code(){
        return fusionGasOVA2103code;
    }
    public String getFusionElecOVA2013code(){
        return fusionElecOVA2103code;
    }
    public String getFusionDualOVA2013code(){
        return fusionDualOVA2103code;
    }
    
    public String getFusionGasFPM2014code(){
        return fusionGasFPM2014code;
    }
    public String getFusionElecFPM2014code(){
        return fusionElecFPM2014CScode;
    }
    public String getFusionDualFPM2014code(){
        return fusionDualFPM2014CScode;
    }
        
    //
    //set
    //
    public void setSmartMeterGasYes(String strSmartmetergasyes){
    	this.smartmetergasyes = strSmartmetergasyes;   	
    }
    
    public void setSmartMeterGasNo(String strsmartmetergasno){
    	this.smartmetergasno= strsmartmetergasno ;
    }

    public void setSmartMeterElecYes(String strsmartmeterelecyes){
    	this.smartmeterelecyes= strsmartmeterelecyes ;
    }
    
    public void setSmartMeterElecNo(String strsmartmeterelecno){
    	this.smartmeterelecno= strsmartmeterelecno ;
    }
    
    public void setEmail(String stremail) {
        this.email= stremail ;
    }

    public void setPassword(String strpassword) {
        this.password= strpassword ;
    }
    
    /*public void sapCSGas(String str) { 	
    	this.sapGasCSCode= str ;
    }
	public void sapCSElec(String str) {
	    	
	    	this.sapElecCSCode= str ;
	    }
	public void sapFPGas(String str) {
		
		this.sapGasFPcode= str ;
	}
	public void sapFPElec(String str) {
		
		this.sapElecFPcode= str ;
	}
	public void sapOVGas(String str) {
		
		this.sapGasOVcode= str ;
	}
	public void sapOVElec(String str) {
		
		this.  sapElecOVcode= str ;
	}
	*/
	    
    public void setShopBatch(String strsalesShopBatch){
    	this.salesShopBatch= strsalesShopBatch;
    }
    
    public void setSmartBatch(String strsalesSmartBatch){
    	this.salesSmartBatch= strsalesSmartBatch ;
    }

    public void setMobileNumber(String strmobileNumber) {
        this.mobileNumber= strmobileNumber ;
    }

    public void setHomeNumber(String strhomeNumber) {
        this.homeNumber= strhomeNumber ;
    }

    public void setWorkNumber(String strworkNumber) {
        this.workNumber= strworkNumber ;
    }

    public void setUcrn(String strucrn) {
        this.ucrn= strucrn ;
    }

    public void setFirstName(String strfirstName) {
        this.firstName= strfirstName ;
    }

    public void setLastName(String strlastName) {
        this.lastName= strlastName ;
    }

    public void setTitle(String strtitle) {
        this.title= strtitle ;
    }

    public void setTariff(String strtariff) {
        this.tariff= strtariff ;
    }

    public void setFuelType(String strfuelType) {
        this.fuelType= strfuelType ;
    }

    public void setGasSupplier(String strgasSupplier) {
        this.gasSupplier= strgasSupplier ;
    }

    public void setElecSupplier(String strelecSupplier) {
        this.elecSupplier= strelecSupplier ;
    }

    public void setPaymentType(String strpaymentType) {
        this.paymentType= strpaymentType ;
    }

    public void setPaymentAccountNumber(String straccountNumber) {
        this.accountNumber= straccountNumber ;
    }

    public void setSortCode1(String strsortCode1) {
        this.sortCode1= strsortCode1 ;
    }

    public void setSortCode2(String strsortCode2) {
        this.sortCode2= strsortCode2 ;
    }

    public void setSortCode3(String strsortCode3) {
        this.sortCode3= strsortCode3 ;
    }

    public void setAccountName(String straccountName) {
        this.accountName= straccountName ;
    }

    public void setPayDay(String strpayday) {
        this.payday= strpayday ;
    }

    public void setCurrentGasSupplier(String strcurrentGasSupplier) {
        this.currentGasSupplier= strcurrentGasSupplier ;
    }

    public void setCurrentElecSupplier(String strcurrentElecSupplier) {
        this.currentElecSupplier= strcurrentElecSupplier ;
    }

    public void setDay(String strday) {
        this.day= strday ;
    }

    public void setEmailtype(String stremailType) {
        this.emailType= stremailType ;
    }

    public void setMonth(String strmonth) {
        this.month= strmonth ;
    }

    public void setTelephonetype(String strtelephoneType) {
        this.telephoneType= strtelephoneType ;
    }

    public void setYear(String stryear) {
        this.year= stryear ;
    }

    public void setPostcode(String strpostCode) {
        this.postCode= strpostCode ;
    }

    public void setAddress(String straddress) {
        this.address= straddress ;
    }

    public void setMonthsLived(String strmonthsLived) {
        this.monthsLived= strmonthsLived ;
    }

    public void setYearsLived(String stryearsLived) {
        this.yearsLived= stryearsLived ;
    }

    public void setTarifffordual(String strtariffForDual) {
        this.tariffForDual= strtariffForDual;
    }

    public void setTariffforelectricity(String strtariffForElectricity) {
        this.tariffForElectricity= strtariffForElectricity ;
    }

    public void setTariffforgas(String strtariffForGas) {
        this.tariffForGas= strtariffForGas ;
    }

    public void setCreatePassword(String strcreatePassword) {
        this.createPassword= strcreatePassword ;
    }

    public void setRetypePassword(String strretypePassword) {
        this.retypePassword= strretypePassword ;
    }

    public void setSecurityQuestion(String strsecurityQuestion) {
        this.securityQuestion= strsecurityQuestion ;
    }

    public void setSecurityAnswer(String strsecurityAnswer) {
        this.securityAnswer= strsecurityAnswer ;
    }

    public void setGasAccountNumber(String strgasAccountNumber) {
        this.gasAccountNumber= strgasAccountNumber ;
    }

    public void setElecAccountNumber(String strelecAccountNumber) {
        this.elecAccountNumber= strelecAccountNumber ;
    }

    public void setCardName(String strcardName) {
        this.cardName= strcardName ;
    }

    public void setCardNumber(String strcardNumber) {
        this.cardNumber= strcardNumber ;
    }

    public void setCardType(String strcardType) {
        this.cardType= strcardType ;
    }

    public void setStartMonth(String strstartMonth) {
        this.startMonth= strstartMonth ;
    }

    public void setStartYear(String strstartYear) {
        this.startYear= strstartYear ;
    }

    public void setExpiryMonth(String strexpiryMonth) {
        this.expiryMonth= strexpiryMonth ;
    }

    public void setExpiryYear(String strexpiryYear) {
        this.expiryYear= strexpiryYear ;
    }

    public void setCvvCode(String strcvvCode) {
        this.cvvCode= strcvvCode ;
    }

    public void setSecureCode(String strsecureCode) {
        this.secureCode= strsecureCode ;
    }
    
    public void setStandardCode(String strstandardCode){
    	this.standardCode= strstandardCode ;
    }
    
    public void setStandardEE50Code(String strstandardCode){
    	this.standardEE50Code= strstandardCode ;
    }
    
   
    
    public void setGasonlineenergyTariffCode(String strgasonlineenergyTariffCode){
    	this.gasonlineenergyTariffCode= strgasonlineenergyTariffCode ;
    }
    
    public void setEleconlineenergyTariffCode(String streleconlineenergyTariffCode){
    	 this.eleconlineenergyTariffCode= streleconlineenergyTariffCode ;
    }
    
    public void setDualonlineenergyTariffCode(String strdualonlineenergyTariffCode){
    	this.dualonlineenergyTariffCode= strdualonlineenergyTariffCode ;
    }
    
    public void setGasFP2013TariffCode(String strgasfixedprice2013TariffCode){
    	this.gasfixedprice2013TariffCode= strgasfixedprice2013TariffCode ;

    }
    
    public void setElecFP2013TariffCode(String strelecfixedprice2013TariffCode){
    	this.elecfixedprice2013TariffCode= strelecfixedprice2013TariffCode ;
    }
    
    public void setDualFP2013TariffCode(String strdualfixedprice2013TariffCode){
    	this.dualfixedprice2013TariffCode= strdualfixedprice2013TariffCode ;
    }
    
    public void setEnergyShareTariffCode(String strenergyshareTariffCode){
    	this.energyshareTariffCode= strenergyshareTariffCode ;
    }
    
    public void setEnergySmartCode(String strenergysmartCode){
    	this.energysmartCode= strenergysmartCode ;
    }
    
    public void setGasCsCode(String strgasCSCode){
    	this.gasCSCode= strgasCSCode ;
    	
    }
    
    public void setElecCsCode(String strelecCSCode){
    	this.elecCSCode= strelecCSCode ;
    	
    }
    
    public void setDualCsCode(String strdualCSCode){
    	this.dualCSCode= strdualCSCode ;
    	
    }
    public void setFusionGasCScode(String strfusionGasCScode){
        this.fusionGasCScode= strfusionGasCScode ;
    }
    
    public void setFusionDualCScode(String strfusionDualCScode){
        this.fusionDualCScode= strfusionDualCScode ;
    } 
    public void setFusionElecCScode(String strfusionElecCScode){
        this.fusionElecCScode= strfusionElecCScode ;
    }
    
    public void setFusionGasOVA2013code(String strfusionGasOVA2103code){
        this.fusionGasOVA2103code= strfusionGasOVA2103code ;
    }
    public void setFusionElecOVA2013code(String strfusionElecOVA2103code){
        this.fusionElecOVA2103code= strfusionElecOVA2103code ;
    }
    public void setFusionDualOVA2013code(String strfusionDualOVA2103code){
        this.fusionDualOVA2103code= strfusionDualOVA2103code ;
    }
    
    public void setFusionGasFPM2014code(String strfusionGasFPM2014code){
        this.fusionGasFPM2014code= strfusionGasFPM2014code ;
    }
    public void setFusionElecFPM2014code(String strfusionElecFPM2014CScode){
        this.fusionElecFPM2014CScode= strfusionElecFPM2014CScode;
    }
    public void setFusionDualFPM2014code(String strfusionDualFPM2014CScode){
        this.fusionDualFPM2014CScode= strfusionDualFPM2014CScode;
    }
        
    

    public void updateWith(UpdateUserFormFields updateUserFormFields) {
        if (isNotEmpty(updateUserFormFields.getEmail())) {
            this.email = trim(updateUserFormFields.getEmail());
        }
        if (isNotEmpty(updateUserFormFields.getPassword())) {
            this.password = updateUserFormFields.getPassword();
        }
        if (isNotEmpty(updateUserFormFields.getMobileNumber())) {
            this.mobileNumber = updateUserFormFields.getMobileNumber();
        }
        if (isNotEmpty(updateUserFormFields.getWorkNumber())) {
            this.workNumber = updateUserFormFields.getWorkNumber();
        }
        if (isNotEmpty(updateUserFormFields.getHomeNumber())) {
            this.homeNumber = updateUserFormFields.getHomeNumber();
        }
    }

}
