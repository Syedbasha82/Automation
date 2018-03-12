package bg.framework.app.functional.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("GetAQuoteDetails")
public class GetAQuoteDetails {

	private String firstName;
	private String lastName;
	private String ddlTitle;
	private String emailAddress;
	private String businessname;
	private String telephone;
	private String SupplyNumber1;
	private String SupplyNumber2;
	private String SupplyNumber3;
	private String SupplyNumber4;
	private String SupplyNumber5;
	private String SupplyNumber6;
	private String SupplyNumber7;
	private String postCode;
	private String charityNumber;
	private String accountName;
	private String sortCodea;
	private String sortCodeb;
	private String sortCodec;
	private String accountNumber;
	private String annualGasSpend;
	private String gasmeterRefnumber;
	private String txtbuildingname;
	private String txtstreetname;
	private String annualElecSpend;
	private double gasUnitrateBand1;
	private double gasUnitrateBand2;
	private double gasUnitrateBand3;
	private double gasUnitrateBand4;
	private double elecProfileClass1Unitrate;
	private double elecProfileClass2Unitrate;
	private double elecProfileClass3Unitrate;
	private double elecProfileClass4Unitrate;
	private double elecProfileClass5Unitrate;
	private double elecProfileClass6Unitrate;
	private double elecProfileClass7Unitrate;
	private double elecProfileClass8Unitrate;
	private String paymentOption;
	private String gaqLeadtype;
	private double defaultConsumptionRateClass1;
	private double defaultConsumptionRateClass2;
	private double defaultConsumptionRateClass3;
	private double defaultConsumptionRateClass4;
	private double defaultConsumptionRateClass5;
	private double defaultConsumptionRateClass6;
	private double defaultConsumptionRateClass7;
	private double defaultConsumptionRateClass8;
	private String badOrganizations;
	private String badTelephones;
	private String postCodes;
	private String MonthlySpend;
	private String QuarterlySpend;
	private String AnnualSpend;
	private String EleValue_1;
	public GetAQuoteDetails() {

	}

	public GetAQuoteDetails(String firstName, String lastName, String ddlTitle,
	        String emailAddress, String annualElecSpend, String businessname,
	        String telephone, String SupplyNumber1, String SupplyNumber2,
	        String SupplyNumber3, String SupplyNumber4, String SupplyNumber5,
	        String SupplyNumber6, String SupplyNumber7, String postCode,
	        String charityNumber, String accountName, String sortCodea, String sortCodeb,
	        String sortCodec, String accountNumber, String annualGasSpend,
	        String gasmeterRefnumber, String txtbuildingname, String txtstreetname,
	        double gasUnitrateBand1, double gasUnitrateBand2, double gasUnitrateBand3,
	        double gasUnitrateBand4, double elecProfileClass1Unitrate,
	        double elecProfileClass2Unitrate, double elecProfileClass3Unitrate,
	        double elecProfileClass4Unitrate, double elecProfileClass5Unitrate,
	        double elecProfileClass6Unitrate, double elecProfileClass7Unitrate,
	        double elecProfileClass8Unitrate, String paymentOption, String gaqLeadtype,
	        double defaultConsumptionRateClass1, double defaultConsumptionRateClass2,
	        double defaultConsumptionRateClass3, double defaultConsumptionRateClass4,
	        double defaultConsumptionRateClass5, double defaultConsumptionRateClass6,
	        double defaultConsumptionRateClass7, double defaultConsumptionRateClass8,String MonthlySpend,
	        String QuarterlySpend,String AnnualSpend,String EleValue_1) {
		this.emailAddress = emailAddress;
		this.telephone = telephone;
		this.businessname = businessname;
		this.firstName = firstName;
		this.lastName = lastName;
		this.ddlTitle = ddlTitle;
		this.SupplyNumber1 = SupplyNumber1;
		this.SupplyNumber2 = SupplyNumber2;
		this.SupplyNumber3 = SupplyNumber3;
		this.SupplyNumber4 = SupplyNumber4;
		this.SupplyNumber5 = SupplyNumber5;
		this.SupplyNumber6 = SupplyNumber6;
		this.SupplyNumber7 = SupplyNumber7;
		this.postCode = postCode;
		this.charityNumber = charityNumber;
		this.accountName = accountName;
		this.sortCodea = sortCodea;
		this.sortCodeb = sortCodeb;
		this.sortCodec = sortCodec;
		this.accountNumber = accountNumber;
		this.annualGasSpend = annualGasSpend;
		this.gasmeterRefnumber = gasmeterRefnumber;
		this.txtbuildingname = txtbuildingname;
		this.txtstreetname = txtstreetname;
		this.annualElecSpend = annualElecSpend;
		this.gasUnitrateBand1 = gasUnitrateBand1;
		this.gasUnitrateBand2 = gasUnitrateBand2;
		this.gasUnitrateBand3 = gasUnitrateBand3;
		this.gasUnitrateBand4 = gasUnitrateBand4;
		this.elecProfileClass1Unitrate = elecProfileClass1Unitrate;
		this.elecProfileClass2Unitrate = elecProfileClass2Unitrate;
		this.elecProfileClass3Unitrate = elecProfileClass3Unitrate;
		this.elecProfileClass4Unitrate = elecProfileClass4Unitrate;
		this.elecProfileClass5Unitrate = elecProfileClass5Unitrate;
		this.elecProfileClass6Unitrate = elecProfileClass6Unitrate;
		this.elecProfileClass7Unitrate = elecProfileClass7Unitrate;
		this.elecProfileClass8Unitrate = elecProfileClass8Unitrate;
		this.paymentOption = paymentOption;
		this.gaqLeadtype = gaqLeadtype;
		this.defaultConsumptionRateClass1 = defaultConsumptionRateClass1;
		this.defaultConsumptionRateClass2 = defaultConsumptionRateClass2;
		this.defaultConsumptionRateClass3 = defaultConsumptionRateClass3;
		this.defaultConsumptionRateClass4 = defaultConsumptionRateClass4;
		this.defaultConsumptionRateClass5 = defaultConsumptionRateClass5;
		this.defaultConsumptionRateClass6 = defaultConsumptionRateClass6;
		this.defaultConsumptionRateClass7 = defaultConsumptionRateClass7;
		this.defaultConsumptionRateClass8 = defaultConsumptionRateClass8;
		this.MonthlySpend=MonthlySpend;
		this.QuarterlySpend=QuarterlySpend;
		this.AnnualSpend=AnnualSpend;
		this.EleValue_1=EleValue_1;
	}

	public void setannualGasSpend(String gasSpend) {
		this.annualGasSpend = gasSpend;
	}

	public String getEmail() {
		return emailAddress;
	}

	public String getElecAnnualspend() {
		return annualElecSpend;
	}

	public String getBuildingName() {
		return txtbuildingname;
	}

	public String getStreetName() {
		return txtstreetname;
	}

	public void setSupplyNumber1(String supplyPoint) {
		if (supplyPoint.length() == 2) {
			this.SupplyNumber1 = supplyPoint;
			updateSupplypointValues();
		}

	}

	private void updateSupplypointValues() {
		int supplyValue = Integer.parseInt(SupplyNumber1);
		switch (supplyValue) {
		case 1:
			SupplyNumber2 = "500";
			SupplyNumber3 = "100";
			SupplyNumber4 = "23";
			SupplyNumber5 = "6090";
			SupplyNumber6 = "3179";
			SupplyNumber7 = "112";
			break;
		case 2:
			SupplyNumber2 = "807";
			SupplyNumber3 = "007";
			SupplyNumber4 = "10";
			SupplyNumber5 = "1290";
			SupplyNumber6 = "5804";
			SupplyNumber7 = "624";
			break;
		case 3:
			SupplyNumber2 = "801";
			SupplyNumber3 = "126";
			SupplyNumber4 = "20";
			SupplyNumber5 = "0000";
			SupplyNumber6 = "3717";
			SupplyNumber7 = "196";
			break;
		case 4:
			SupplyNumber2 = "807";
			SupplyNumber3 = "242";
			SupplyNumber4 = "10";
			SupplyNumber5 = "1236";
			SupplyNumber6 = "8756";
			SupplyNumber7 = "693";
			break;
		case 5:
			SupplyNumber2 = "801";
			SupplyNumber3 = "250";
			SupplyNumber4 = "10";
			SupplyNumber5 = "1456";
			SupplyNumber6 = "9927";
			SupplyNumber7 = "760";
			break;
		case 6:
			SupplyNumber2 = "817";
			SupplyNumber3 = "081";
			SupplyNumber4 = "11";
			SupplyNumber5 = "0003";
			SupplyNumber6 = "9241";
			SupplyNumber7 = "568";
			break;
		case 7:
			SupplyNumber2 = "816";
			SupplyNumber3 = "081";
			SupplyNumber4 = "11";
			SupplyNumber5 = "0003";
			SupplyNumber6 = "9206";
			SupplyNumber7 = "670";
			break;
		case 8:
			SupplyNumber2 = "801";
			SupplyNumber3 = "009";
			SupplyNumber4 = "10";
			SupplyNumber5 = "1290";
			SupplyNumber6 = "5803";
			SupplyNumber7 = "471";
			break;
		}

	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getTitle() {
		return ddlTitle;
	}

	public String getbusinessname() {
		return businessname;
	}

	public void setbusinessname(String businessName) {
		this.businessname = businessName;
	}

	public String getSupplyNumber1() {
		return SupplyNumber1;
	}

	public String getSupplyNumber2() {
		return SupplyNumber2;
	}

	public String getSupplyNumber3() {
		return SupplyNumber3;
	}

	public String getSupplyNumber4() {
		return SupplyNumber4;
	}

	public String getSupplyNumber5() {
		return SupplyNumber5;
	}

	public String getSupplyNumber6() {
		return SupplyNumber6;
	}

	public String getSupplyNumber7() {
		return SupplyNumber7;
	}

	public String gettelephone() {
		return telephone;
	}

	public String getPostcode() {
		return postCode;
	}
	public void setPostcode(String postCode)
	{
		this.postCode=postCode;
	}
	public String getPostcodes() {
		return postCodes;
	}

	public String getCharityNumber() {
		return charityNumber;
	}

	public String getaccountName() {
		return accountName;
	}

	public String getsortCodea() {
		return sortCodea;
	}

	public String getsortCodeb() {
		return sortCodeb;
	}

	public String getsortCodec() {
		return sortCodec;
	}

	public String getaccountNumber() {
		return accountNumber;
	}

	public String getannualGasSpend() {
		return annualGasSpend;
	}

	public String getgasmeterRefnumber() {
		return gasmeterRefnumber;
	}

	public double getgasUnitrateBand1() {
		return gasUnitrateBand1;
	}

	public double getgasUnitrateBand2() {
		return gasUnitrateBand2;
	}

	public double getgasUnitrateBand3() {
		return gasUnitrateBand3;
	}

	public double getgasUnitrateBand4() {
		return gasUnitrateBand4;
	}

	public double getelecProfileClass1Unitrate() {
		return elecProfileClass1Unitrate;
	}

	public double getelecProfileClass2Unitrate() {
		return elecProfileClass2Unitrate;
	}

	public double getelecProfileClass3Unitrate() {
		return elecProfileClass3Unitrate;
	}

	public double getelecProfileClass4Unitrate() {
		return elecProfileClass4Unitrate;
	}

	public double getelecProfileClass5Unitrate() {
		return elecProfileClass5Unitrate;
	}

	public double getelecProfileClass6Unitrate() {
		return elecProfileClass6Unitrate;
	}

	public double getelecProfileClass7Unitrate() {
		return elecProfileClass7Unitrate;
	}

	public double getelecProfileClass8Unitrate() {
		return elecProfileClass8Unitrate;
	}

	public String getPaymentOption() {
		return paymentOption;
	}

	public String getLeadType() {
		return gaqLeadtype;
	}

	public double getdefaultConsumptionRateClass1() {
		return defaultConsumptionRateClass1;
	}

	public double getdefaultConsumptionRateClass2() {
		return defaultConsumptionRateClass2;
	}

	public double getdefaultConsumptionRateClass3() {
		return defaultConsumptionRateClass3;
	}

	public double getdefaultConsumptionRateClass4() {
		return defaultConsumptionRateClass4;
	}

	public double getdefaultConsumptionRateClass5() {
		return defaultConsumptionRateClass5;
	}

	public double getdefaultConsumptionRateClass6() {
		return defaultConsumptionRateClass6;
	}

	public double getdefaultConsumptionRateClass7() {
		return defaultConsumptionRateClass7;
	}

	public double getdefaultConsumptionRateClass8() {
		return defaultConsumptionRateClass8;
	}

	public String getBadOrganizations() {
		return badOrganizations;
	}

	public void setBadOrganizations(String badOrganizations) {
		this.badOrganizations = badOrganizations;
	}

	public String[] getbadOrganizations() {
		badOrganizations = badOrganizations.replace("\n", "");
		badOrganizations = badOrganizations.replace("\t", "");
		return badOrganizations.split(";");
	}

	public String[] getbadTelephones() {
		badTelephones = badTelephones.replace("\n", "");
		badTelephones = badTelephones.replace("\t", "");
		return badTelephones.split(";");
	}

	public void setbadTelephones(String badPhone) {
		this.telephone = badPhone;

	}
	public String getAnnualSpend() {
		return AnnualSpend;
	}
	public String getMonthlySpend() {
		return MonthlySpend;
	}
	public String getQuarterlySpend() {
		return QuarterlySpend;
	}
	public String getCurrentUsage_Value() {
		return EleValue_1;
	}
}

/*
 * public void updateWith(UpdateUserFormFields updateUserFormFields) {
 * if(isNotEmpty(updateUserFormFields.getEmail())){ this.email =
 * trim(updateUserFormFields.getEmail()); }
 * if(isNotEmpty(updateUserFormFields.getPassword())){ this.password =
 * updateUserFormFields.getPassword(); }
 * if(isNotEmpty(updateUserFormFields.getMobileNumber())){ this.mobileNumber =
 * updateUserFormFields.getMobileNumber(); }
 * if(isNotEmpty(updateUserFormFields.getWorkNumber())){ this.workNumber =
 * updateUserFormFields.getWorkNumber(); }
 * if(isNotEmpty(updateUserFormFields.getHomeNumber())){ this.homeNumber =
 * updateUserFormFields.getHomeNumber(); } }
 */
