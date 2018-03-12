package bg.framework.app.functional.test.selfServe;

import static bg.framework.app.functional.entities.FunctionalCategory.Smoke;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.action.reFactoring.AccOverviewAction;
import bg.framework.app.functional.action.selfServe.ChannelActivationAction;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.FunctionalCategory;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class ChannelActivationTest extends TestBase{
	
	

	/**************************************************************************
    Created By          : Vishnu Prasad D
    Created Date        : 25-3-2014
    Test Case ID        : CA_P2B_TC_323
    Mandatory Fields    : SO Tube Map
	 ***************************************************************************/
	@Test(groups = { FunctionalCategory.Acquisition })
	public void SOtubeMap(){
		Report.createTestLogHeader("Channel Activation","Verify SO Tube Map");
		UserProfile userProfile = new TestDataHelper().getUserProfile("CA_Fun_034");
		new HomePageAction().logout();
		new HomePageAction().navigateToLogin().login(userProfile);	
		new AccOverviewAction().clickManageAccount();
		new ChannelActivationAction()
		.verifyTubeMap();
	}
	

	/**************************************************************************
    Created By          : Vishnu Prasad D
    Created Date        : 25-3-2014
    Test Case ID        : CA_P2B_TC_323
    Mandatory Fields    : WTP Tube Map
	 ***************************************************************************/
	
	@Test(groups = { FunctionalCategory.Acquisition })
	public void WTPtubeMap(){
		Report.createTestLogHeader("Channel Activation","Verify WTP Tube Map");
		UserProfile userProfile = new TestDataHelper().getUserProfile("CA_Fun_034");
		new HomePageAction().logout();
		new HomePageAction().navigateToLogin().login(userProfile);	
		new AccOverviewAction().clickManageAccount();
		new ChannelActivationAction()
		.verifyTubeMap();
	}
	
	/**************************************************************************
    Created By          : Vishnu Prasad D
    Created Date        : 25-3-2014
    Test Case ID        : CA_P2B_TC_012
    Mandatory Fields    : WTP Tube Map
	 ***************************************************************************/
	
	@Test(groups = { FunctionalCategory.Acquisition })
	public void NewCustCASignUpTariffA(){
		Report.createTestLogHeader("Channel Activation","New Cust Energy Shop");
		UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_12");
		final Acquisition acquisition = new TestDataHelper()
		.getAcquisitionData("standardDualAcquisition");
		String outstandingBalance="No";
		String Eco7 ="No";
		String Flat="No";
		String FuseBox="Yes";
		String Smart="No";
		String AddressDD="2";
		String Tariff="A";
		String paymentType="Pay As You Go";
		new ChannelActivationAction()
		.openChanActURL();
		new HomePageAction().logout();
		new ChannelActivationAction()
		.clickbritishgasno()
		.selectCreditMeter()
		.clickNewUserPage1Next() 
		.clickContinue()
		.newCustScreeningQues(outstandingBalance, Eco7, Flat, FuseBox, Smart)
		.screeningContinue()
		.screeningJoinUs()
       .newCusFlowDecider(acquisition,userProfile, AddressDD, outstandingBalance, Eco7, Flat, FuseBox, Smart,Tariff,paymentType);
		new HomePageAction().navigateToLogin().login(userProfile);
		new HomePageAction().logout();
		}
	@Test(groups = { FunctionalCategory.Acquisition })
	public void NewCustCASignUpTariffB(){
		Report.createTestLogHeader("Channel Activation","New Cust Energy Shop");
		UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_12");
		final Acquisition acquisition = new TestDataHelper()
		.getAcquisitionData("standardDualAcquisition");
		String outstandingBalance="No";
		String Eco7 ="No";
		String Flat="No";
		String FuseBox="Yes";
		String Smart="No";
		String AddressDD="2";
		String Tariff="B";
		String paymentType="Pay As You Go";
		new ChannelActivationAction()
		.openChanActURL();
		new HomePageAction().logout();
		new ChannelActivationAction()
		.clickbritishgasno()
		.selectCreditMeter()
		.clickNewUserPage1Next() 
		.clickContinue()
		.newCustScreeningQues(outstandingBalance, Eco7, Flat, FuseBox, Smart)
		.screeningContinue()
		.screeningJoinUs()
       .newCusFlowDecider(acquisition,userProfile, AddressDD, outstandingBalance, Eco7, Flat, FuseBox, Smart,Tariff,paymentType);
		new HomePageAction().navigateToLogin().login(userProfile);
		new HomePageAction().logout();
		}
	@Test(groups = { FunctionalCategory.Acquisition })
	public void NewCustCASignUpTariffC(){
		Report.createTestLogHeader("Channel Activation","New Cust Energy Shop");
		UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_12");
		final Acquisition acquisition = new TestDataHelper()
		.getAcquisitionData("standardDualAcquisition");
		String outstandingBalance="No";
		String Eco7 ="No";
		String Flat="No";
		String FuseBox="Yes";
		String Smart="No";
		String AddressDD="2";
		String Tariff="C";
		String paymentType="Pay As You Go";
		new ChannelActivationAction()
		.openChanActURL();
		new HomePageAction().logout();
		new ChannelActivationAction()
		.clickbritishgasno()
		.selectCreditMeter()
		.clickNewUserPage1Next() 
		.clickContinue()
		.screeningJoinUs()
		.newCustScreeningQues(outstandingBalance, Eco7, Flat, FuseBox, Smart)
		.screeningContinue()
        .newCusFlowDecider(acquisition,userProfile, AddressDD, outstandingBalance, Eco7, Flat, FuseBox, Smart,Tariff,paymentType);
		new HomePageAction().navigateToLogin().login(userProfile);
		new HomePageAction().logout();
		}
	@Test(groups = { FunctionalCategory.Acquisition })
	public void NewCustCASignUpTariffD(){
		Report.createTestLogHeader("Channel Activation","New Cust Energy Shop");
		UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_12");
		final Acquisition acquisition = new TestDataHelper()
		.getAcquisitionData("standardDualAcquisition");
		String outstandingBalance="No";
		String Eco7 ="No";
		String Flat="No";
		String FuseBox="Yes";
		String Smart="No";
		String AddressDD="2";
		String Tariff="D";
		String paymentType="Pay As You Go";
		new ChannelActivationAction()
		.openChanActURL();
		new HomePageAction().logout();
		new ChannelActivationAction()
		.clickbritishgasno()
		.selectCreditMeter()
		.clickNewUserPage1Next() 
		.clickContinue()
		.screeningJoinUs()
		.newCustScreeningQues(outstandingBalance, Eco7, Flat, FuseBox, Smart)
		.screeningContinue()
        .newCusFlowDecider(acquisition,userProfile, AddressDD, outstandingBalance, Eco7, Flat, FuseBox, Smart,Tariff,paymentType);
		new HomePageAction().navigateToLogin().login(userProfile);
		new HomePageAction().logout();
		}
	
	
	/**************************************************************************
    Created By          : Vishnu Prasad D
    Created Date        : 25-3-2014
    Test Case ID        : CA_P2B_TC_024
    Mandatory Fields    : WTP Tube Map
	 ***************************************************************************/
	
	@Test(groups = { FunctionalCategory.Acquisition })
	public void SeriveNewCustCASignUp(){
		Report.createTestLogHeader("Channel Activation","OAM Cust - Service Account with Different Address Energy Shop");
		UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_24");
		final Acquisition acquisition = new TestDataHelper()
		.getAcquisitionData("standardDualAcquisition");		
		String Eco7 ="No";
		String outstandingBalance="No";
		String Flat="No";
		String FuseBox="Yes";
		String Smart="No";
		String AddressDD="2";
		String Tariff="A";
		String paymentType="Pay As You Go";
		new ChannelActivationAction()
		.openChanActURL();
		new HomePageAction().logout();
		new ChannelActivationAction()
		.clickbritishgasno()
		.clickNewUserPage1Next()
		.clickContinue()
		.newCustScreeningQues( Eco7,outstandingBalance, Flat, FuseBox, Smart)
		.screeningContinue()
        .newCusFlowDecider(acquisition,userProfile, AddressDD,  Eco7,outstandingBalance, Flat, FuseBox, Smart,Tariff,paymentType);
		new HomePageAction().navigateToLogin().login(userProfile);
		new HomePageAction().logout();
		}
	
	

	/**************************************************************************
    Created By          : Vishnu Prasad D
    Created Date        : 25-3-2014
    Test Case ID        : CA_P2B_TC_024
    Mandatory Fields    : WTP Tube Map
	 ***************************************************************************/
	
	@Test(groups = { FunctionalCategory.Acquisition })
	public void InactiveLessSixMonthsCASignUp(){
		Report.createTestLogHeader("Channel Activation","OAM Cust - inactive less than 6 months Account Energy Shop");
		UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_24_1");
		final Acquisition acquisition = new TestDataHelper()
		.getAcquisitionData("standardDualAcquisition");
		String outstandingBalance="No";
		String Eco7 ="No";
		String Flat="No";
		String FuseBox="Yes";
		String Smart="No";
		String AddressDD="2";
		String Tariff="A";
		String paymentType="Pay As You Go";
		new ChannelActivationAction()
		.openChanActURL();
		new HomePageAction().logout();
		new ChannelActivationAction()
		.clickbritishgasno()
		.clickNewUserPage1Next()
		.clickContinue()
		.newCustScreeningQues(outstandingBalance, Eco7, Flat, FuseBox, Smart)
		.screeningContinue()
       .newCusFlowDecider(acquisition,userProfile, AddressDD, outstandingBalance, Eco7, Flat, FuseBox, Smart,Tariff,paymentType);
		new HomePageAction().navigateToLogin().login(userProfile);
		new HomePageAction().logout();
		}
	
	/**************************************************************************
    Created By          : Vishnu Prasad D
    Created Date        : 25-3-2014
    Test Case ID        : CA_P2B_TC_025
    Mandatory Fields    : WTP Tube Map
	 ***************************************************************************/
	
	@Test(groups = { FunctionalCategory.Acquisition })
	public void InactiveMoreSixMonthsCASignUp(){
		Report.createTestLogHeader("Channel Activation","OAM Cust - inactive More than 6 months Account Energy Shop");
		UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_25_1");
		final Acquisition acquisition = new TestDataHelper()
		.getAcquisitionData("standardDualAcquisition");
		String outstandingBalance="No";
		String Eco7 ="No";
		String Flat="No";
		String FuseBox="Yes";
		String Smart="No";
		String AddressDD="2";
		String Tariff="A";
		String paymentType="Pay As You Go";
		new ChannelActivationAction()
		.openChanActURL();
		new HomePageAction().logout();
		new ChannelActivationAction()
		.clickbritishgasno()
		.clickNewUserPage1Next()
		.clickContinue()
		.newCustScreeningQues(outstandingBalance, Eco7, Flat, FuseBox, Smart)
		.screeningContinue()
        .newCusFlowDecider(acquisition,userProfile, AddressDD, outstandingBalance, Eco7, Flat, FuseBox, Smart,Tariff,paymentType);
		new HomePageAction().navigateToLogin().login(userProfile);
		new HomePageAction().logout();
		}
	
	/**************************************************************************
    Created By          : Vishnu Prasad D
    Created Date        : 25-3-2014
    Test Case ID        : CA_P2B_TC_026
    Mandatory Fields    : WTP Tube Map
	 ***************************************************************************/
	
	@Test(groups = { FunctionalCategory.Acquisition })
	public void RegstdCustCASignUpDiffPremise(){
		Report.createTestLogHeader("Channel Activation - New Cust","Already registered Cust different premise Energy Shop");
		UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_12");
		final Acquisition acquisition = new TestDataHelper()
		.getAcquisitionData("standardDualAcquisition");
		String outstandingBalance="No";
		String Eco7 ="No";
		String Flat="No";
		String FuseBox="Yes";
		String Smart="No";
		String AddressDD="4";
		String Tariff="A";
		String paymentType="Pay As You Go";
		new ChannelActivationAction()
		.openChanActURL();
		new HomePageAction().logout();
		new ChannelActivationAction()
		.clickbritishgasno()
		.clickNewUserPage1Next()
		.clickContinue()
		.newCustScreeningQues(outstandingBalance, Eco7, Flat, FuseBox, Smart)
		.screeningContinue()
		.newCusFlowDecider(acquisition,userProfile, AddressDD, outstandingBalance, Eco7, Flat, FuseBox, Smart,Tariff,paymentType);
		new HomePageAction().navigateToLogin().login(userProfile);
		}
	
	/**************************************************************************
    Created By          : Manigandan R
    Created Date        : 25-3-2014
    Test Case ID        : CA_P2B_TC_13
    Mandatory Fields    : WTP Tube Map
	 ***************************************************************************/
	
	@Test(groups = { FunctionalCategory.Acquisition })
	public void NewCustCASignUpNO(){
		Report.createTestLogHeader("Channel Activation","New Cust Energy Shop - No for all Screening Questions");
		UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_12");
		final Acquisition acquisition = new TestDataHelper()
		.getAcquisitionData("standardDualAcquisition");
		String outstandingBalance="No";
		String Eco7 ="No";
		String Flat="No";
		String FuseBox="No";
		String Smart="No";
		String AddressDD="2";
		String Tariff="A";
		String paymentType="Pay As You Go";
		new ChannelActivationAction()
		.openChanActURL();
		new HomePageAction().logout();
		new ChannelActivationAction()
		.clickbritishgasno()
		.clickNewUserPage1Next()
		.clickContinue()
		.newCustScreeningQues(outstandingBalance, Eco7, Flat, FuseBox, Smart)
		.screeningContinue()
		.newCusFlowDecider(acquisition,userProfile, AddressDD, outstandingBalance, Eco7, Flat, FuseBox, Smart,Tariff,paymentType)
		.newCustNegaConfirmtn();
		}
		
		/**************************************************************************
    Created By          : Manigandan R
    Created Date        : 25-3-2014
    Test Case ID        : CA_P2B_TC_14
    Mandatory Fields    : WTP Tube Map
	 ***************************************************************************/
	
	@Test(groups = { FunctionalCategory.Acquisition })
	public void NewCustCASignUpYes(){
		Report.createTestLogHeader("Channel Activation","New Cust Energy Shop - Yes for all Screening Questions");
		UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_12");
		final Acquisition acquisition = new TestDataHelper()
		.getAcquisitionData("standardDualAcquisition");
		String outstandingBalance="Yes";
		String Eco7 ="Yes";
		String Flat="Yes";
		String FuseBox="Yes";
		String Smart="Yes";
		String AddressDD="2";
		String Tariff="A";
		String paymentType="Pay As You Go";
		new ChannelActivationAction()
		.openChanActURL();
		new HomePageAction().logout();
		new ChannelActivationAction()
		.clickbritishgasno()
		.clickNewUserPage1Next()
		.clickContinue()
		.newCustScreeningQues(outstandingBalance, Eco7, Flat, FuseBox, Smart)
		.screeningContinue()
		.newCusFlowDecider(acquisition,userProfile, AddressDD, outstandingBalance, Eco7, Flat, FuseBox, Smart,Tariff,paymentType)
		.newCustNegaConfirmtn();
		}
		
			/**************************************************************************
    Created By          : Manigandan R
    Created Date        : 25-3-2014
    Test Case ID        : CA_P2B_TC_14
    Mandatory Fields    : WTP Tube Map
	 ***************************************************************************/
	
	@Test(groups = { FunctionalCategory.Acquisition })
	public void NewCustCASignUpYesNo(){
		Report.createTestLogHeader("Channel Activation","New Cust Energy Shop - Yes No for all Screening Questions");
		UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_12");
		final Acquisition acquisition = new TestDataHelper()
		.getAcquisitionData("standardDualAcquisition");
		String outstandingBalance="Yes";
		String Eco7 ="No";
		String Flat="No";
		String FuseBox="Yes";
		String Smart="No";
		String AddressDD="2";
		String Tariff="A";
		String paymentType="Pay As You Go";
		new ChannelActivationAction()
		.openChanActURL();
		new HomePageAction().logout();
		new ChannelActivationAction()
		.clickbritishgasno()
		.clickNewUserPage1Next()
		.clickContinue()
		.newCustScreeningQues(outstandingBalance, Eco7, Flat, FuseBox, Smart)
		.screeningContinue()
		.newCusFlowDecider(acquisition,userProfile, AddressDD, outstandingBalance, Eco7, Flat, FuseBox, Smart,Tariff,paymentType)
		.newCustNegaConfirmtn();
		}
	
	
	
	/*------------------------------------------------SingUp Existing Cust-----------------------------------------*/
	
	
	
	/**************************************************************************
    	Created By          : Vishnu Prasad D
    	Created Date        : 25-3-2014
    	Test Case ID        : CA_P2B_TC_01
    	Mandatory Fields    : Existing Cust CA Sing up 
	 ***************************************************************************/
	
	@Test(groups = { FunctionalCategory.Acquisition })
	public void ExCustCASignUpDuel(){
		Report.createTestLogHeader("Channel Activation","Existing Duel Fuel Cust Energy Shop");
		UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_1");
		String ExQues1="YES";
		String ExQues2 ="NO";
		String Account="DUEL";
		new HomePageAction().logout();
		new HomePageAction().navigateToLogin().login(userProfile);
		new ChannelActivationAction()
			.exclickSmartMeterLink(userProfile,Account)
			.exScreeningQues(userProfile,ExQues1,ExQues2)
			.exClickConfrmAddContinue()
			.exSelectAppointment(userProfile)
			.exVerifyApnmtConfirm(userProfile)
			.exClickGo2Account()
			.exAppointmentExistsValidn();
		}
	
	
	/**************************************************************************
	Created By          : Vishnu Prasad D
	Created Date        : 25-3-2014
	Test Case ID        : CA_P2B_TC_02
	Mandatory Fields    : Existing Cust CA Sing up 
 ***************************************************************************/

@Test(groups = { FunctionalCategory.Acquisition })
public void ExCustCASignUpJI(){
	Report.createTestLogHeader("Channel Activation","Existing JI Fuel Cust Energy Shop");
	UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_2");
	String ExQues1="YES";
	String ExQues2 ="NO";
	String Account="JI";
	new HomePageAction().logout();
	new HomePageAction().navigateToLogin().login(userProfile);
	new ChannelActivationAction()
		.exclickSmartMeterLink(userProfile,Account)
		.exScreeningQues(userProfile,ExQues1,ExQues2)
		.exClickConfrmAddContinue()
		.exSelectAppointment(userProfile)
		.exVerifyApnmtConfirm(userProfile)
		.exClickGo2Account()
		.exAppointmentExistsValidn();
	new HomePageAction().logout();
	}



	/**************************************************************************
	Created By          : Vishnu Prasad D
	Created Date        : 25-3-2014
	Test Case ID        : CA_P2B_TC_03
	Mandatory Fields    : Existing Cust Multiple premise Sing up 
 ***************************************************************************/

		@Test(groups = { FunctionalCategory.Acquisition })
		public void ExMulPremiseDuelJI(){
			Report.createTestLogHeader("Channel Activation","Existing Cust Multiple Premise Duel and Ji ");
			UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_3_1");
			String ExQues1="YES";
			String ExQues2 ="NO";
			String Account="DUEL";
			new HomePageAction().logout();
			new HomePageAction().navigateToLogin().login(userProfile);
			new ChannelActivationAction()
			.exclickSmartMeterLink(userProfile,Account)
			.exScreeningQues(userProfile,ExQues1,ExQues2)
			.exClickConfrmAddContinue()
			.exSelectAppointment(userProfile)
			.exVerifyApnmtConfirm(userProfile)
			.exClickGo2Account()
			.exAppointmentExistsValidn();
			UserProfile userProfile2 = new TestDataHelper().getUserProfile("CA_P2B_TC_3_2");
			ExQues1="YES";
			ExQues2 ="NO";
			Account="DUEL";
			new ChannelActivationAction()
			.exclickSmartMeterLink(userProfile2,Account)
			.exScreeningQues(userProfile2,ExQues1,ExQues2)
			.exClickConfrmAddContinue()
			.exSelectAppointment(userProfile2)
			.exVerifyApnmtConfirm(userProfile2)
			.exClickGo2Account()
			.exAppointmentExistsValidn();
			new HomePageAction().logout();
		}

	/**************************************************************************
		Created By          : Vishnu Prasad D
		Created Date        : 31-3-2014
		Test Case ID        : CA_P2B_TC_04 , CA_P2B_TC_10
		Mandatory Fields    : Existing Cust one account eligible sign up
	 ***************************************************************************/

@Test(groups = { FunctionalCategory.Acquisition })
		public void ExOneAccountValid(){

	Report.createTestLogHeader("Channel Activation","Existing Cust Multi Premise Two Accounts one valid and other invalid ");
	UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_1");
	String ExQues1="YES";
	String ExQues2 ="NO";
	String Account="Single";
	String meterReadFrequency="Half Hourly";
	new HomePageAction().logout();
	new HomePageAction().navigateToLogin().login(userProfile);
	new ChannelActivationAction()
	.exclickSmartMeterLink(userProfile,Account)
	.exScreeningQues(userProfile,ExQues1,ExQues2)
	.exClickConfrmAddContinue()
	.verifyChooseYourAppointmentPage()
    .navigateToReviewYourAppointmentPageThroughCalendar()
    .verifyRevieweDtailsPage(meterReadFrequency)
    .navigateToConfirmationPage()
	.exVerifyApnmtConfirm(userProfile)
	.exClickGo2Account()
	.exAppointmentExistsValidn();
	ExQues1="YES";
	ExQues2 ="NO";
	Account="Single";
	new ChannelActivationAction()
		.exclickSmartMeterLink(userProfile,Account)
		.ineligibleCheckClick()
		.inEligibleReasonExists().InEligibleSubmitReturn();
	new HomePageAction().logout();
		}
		
		

        /*----------------------------------------------------Existing cust No Appointment------------------------------------------*/


/**************************************************************************
Created By          : Vishnu Prasad D
Created Date        : 25-3-2014
Test Case ID        : CA_P2B_TC_02
Mandatory Fields    : Existing Cust CA Sing up 
***************************************************************************/

@Test(groups = { FunctionalCategory.Acquisition })
public void ExCustMultiNoApointmnt(){
Report.createTestLogHeader("Channel Activation","Existing Multi Premise Fuel No Appointment");
UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_5");
String ExQues1="YES";
String ExQues2 ="NO";
String Account="DUEL";
new HomePageAction().logout();
new HomePageAction().navigateToLogin().login(userProfile);
new ChannelActivationAction()
	.exclickSmartMeterLink(userProfile,Account)
	.exNoApntmntValidation();
	new HomePageAction().logout();
}

/**************************************************************************
Created By          : Vishnu Prasad D
Created Date        : 25-3-2014
Test Case ID        : CA_P2B_TC_02
Mandatory Fields    : Existing Cust CA Sing up 
***************************************************************************/

@Test(groups = { FunctionalCategory.Acquisition })
public void ExCustSingleNoApointmnt(){
Report.createTestLogHeader("Channel Activation","Existing Single Premise Fuel No Appointment");
UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_5");
String ExQues1="YES";
String ExQues2 ="NO";
String Account="DUEL";
new HomePageAction().logout();
new HomePageAction().navigateToLogin().login(userProfile);
new ChannelActivationAction()
	.exclickSmartMeterLink(userProfile,Account)
	.exNoApntmntValidation();
	new HomePageAction().logout();
}



		/*------------------------------------------------Existing Cust Register Interest---------------------------------*/

		/**************************************************************************
		Created By          : Ragul M
		Created Date        : 31-11-2014
		Functionality       : Existing Customer Register Your Interest
	 ***************************************************************************/

@Test(groups = { FunctionalCategory.Acquisition })
		public void registerIntSingleJI(){

	Report.createTestLogHeader("Channel Activation","Single JI account Register Interest");
	UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_1");
	String ExQues1="YES";
	String ExQues2 ="NO";
	String Account="JI";
	new HomePageAction().logout();
	new HomePageAction().navigateToLogin().login(userProfile);
	new ChannelActivationAction()
		.exclickSmartMeterLink(userProfile,Account)
		.exScreeningQues(userProfile,ExQues1,ExQues2)
		.ineligibleCheckClick()
		.inEligibleReasonExists().InEligibleSubmitReturn()
		.InEligibleVerifyAccountOverview();
	new HomePageAction().logout();
		}

	@Test(groups = { FunctionalCategory.Acquisition })
	public void registerIntSingleELEC() {

		Report.createTestLogHeader("Channel Activation",
				"Single Electricity account Register Interest 1");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");
		String ExQues1 = "YES";
		String ExQues2 = "NO";
		String Account = "Single";
		new HomePageAction().logout();
		new HomePageAction().navigateToLogin().login(userProfile);
		new ChannelActivationAction()
				.exclickSmartMeterLink(userProfile, Account)
				.exScreeningQues(userProfile, ExQues1, ExQues2)
				.ineligibleCheckClick().inEligibleReasonExists()
				.InEligibleSubmitReturn()
				.InEligibleVerifyAccountOverview();
		new HomePageAction().logout();
	}
	@Test(groups = { FunctionalCategory.Acquisition })
	public void registerIntSingleELEC2() {

		Report.createTestLogHeader("Channel Activation",
				"Single Electricity account Register Interest 2");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");
		String ExQues1 = "YES";
		String ExQues2 = "YES";
		String Account = "Single";
		new HomePageAction().logout();
		new HomePageAction().navigateToLogin().login(userProfile);
		new ChannelActivationAction()
				.exclickSmartMeterLink(userProfile, Account)
				.exScreeningQues(userProfile, ExQues1, ExQues2)
				.ineligibleCheckClick().inEligibleReasonExists()
				.checkBritishGasCheckBox()
				.InEligibleSubmitReturn()
				.InEligibleVerifyAccountOverview();
		new HomePageAction().logout();
		
	}@Test(groups = { FunctionalCategory.Acquisition })
	public void registerIntSingleGas() {

		Report.createTestLogHeader("Channel Activation",
				"Single Gas account Register Interest 1");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");
		String ExQues1 = "YES";
		String ExQues2 = "NO";
		String Account = "Single";
		new HomePageAction().logout();
		new HomePageAction().navigateToLogin().login(userProfile);
		new ChannelActivationAction()
				.exclickSmartMeterLink(userProfile, Account)
				.exScreeningQues(userProfile, ExQues1, ExQues2)
				.ineligibleCheckClick().inEligibleReasonExists()
				.InEligibleSubmitReturn()
				.InEligibleVerifyAccountOverview();
		new HomePageAction().logout();
	}
	
	@Test(groups = { FunctionalCategory.Acquisition })
	public void registerIntSingleGas2() {

		Report.createTestLogHeader("Channel Activation",
				"Single Gas account Register Interest 2");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");
		String ExQues1 = "YES";
		String ExQues2 = "YES";
		String Account = "Single";
		new HomePageAction().logout();
		new HomePageAction().navigateToLogin().login(userProfile);
		new ChannelActivationAction()
				.exclickSmartMeterLink(userProfile, Account)
				.exScreeningQues(userProfile, ExQues1, ExQues2)
				.ineligibleCheckClick().inEligibleReasonExists()
				.checkBritishGasCheckBox()
				.InEligibleSubmitReturn()
				.InEligibleVerifyAccountOverview();
		new HomePageAction().logout();
	}
		
				/**************************************************************************
		Created By          : Ragul M
		Created Date        : 31-11-2014
		Functionality       : Existing Customer Register Your Interest
	 ***************************************************************************/

@Test(groups = { FunctionalCategory.Acquisition })
		public void registerIntSingleDual(){

	Report.createTestLogHeader("Channel Activation","Single Dual account Register Interest1");
	UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
	String ExQues1="YES";
	String ExQues2 ="NO";
	String Account="Single";
	new HomePageAction().logout();
	new HomePageAction().navigateToLogin().login(userProfile);
	new ChannelActivationAction()
		.exclickSmartMeterLink(userProfile,Account)
		.exScreeningQues(userProfile,ExQues1,ExQues2)
		.ineligibleCheckClick()
		.inEligibleReasonExists().InEligibleSubmitReturn()
		.InEligibleVerifyAccountOverview();
	new HomePageAction().logout();
		}

@Test(groups = { FunctionalCategory.Acquisition })
public void registerIntSingleDual2() {

	Report.createTestLogHeader("Channel Activation",
			"Single Dual account Register Interest 2");
	UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");
	String ExQues1 = "YES";
	String ExQues2 = "YES";
	String Account = "Single";
	new HomePageAction().logout();
	new HomePageAction().navigateToLogin().login(userProfile);
	new ChannelActivationAction()
			.exclickSmartMeterLink(userProfile, Account)
			.exScreeningQues(userProfile, ExQues1, ExQues2)
			.ineligibleCheckClick().inEligibleReasonExists()
			.checkBritishGasCheckBox()
			.InEligibleSubmitReturn()	
	        .InEligibleVerifyAccountOverview();
	new HomePageAction().logout();
}
		
		/**************************************************************************
		Created By          : Vishnu Prasad D
		Created Date        : 31-3-2014
		Test Case ID        : CA_P2B_TC_09
		Mandatory Fields    : Existing Cust one account eligible sign up
	 ***************************************************************************/

@Test(groups = { FunctionalCategory.Acquisition })
		public void registerIntMultipleDuel(){

	Report.createTestLogHeader("Channel Activation","Multiple Duel account Register Interest");
	UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_9_1");
	String ExQues1="YES";
	String ExQues2 ="NO";
	String Account="JI";
	new HomePageAction().logout();
	new HomePageAction().navigateToLogin().login(userProfile);
	new ChannelActivationAction()
		.exclickSmartMeterLink(userProfile,Account)
		.exScreeningQues(userProfile,ExQues1,ExQues2)
		.ineligibleCheckClick()
		.inEligibleReasonExists().InEligibleSubmitReturn();
		UserProfile userProfile1 = new TestDataHelper().getUserProfile("CA_P2B_TC_9_2");
	 ExQues1="YES";
	 ExQues2 ="NO";
	 Account="JI";
	new ChannelActivationAction()
		.exclickSmartMeterLink(userProfile1,Account)
		.exScreeningQues(userProfile1,ExQues1,ExQues2)
		.ineligibleCheckClick()
		.inEligibleReasonExists().InEligibleSubmitReturn();
	new HomePageAction().logout();
		}
		
	/**************************************************************************
		Created By          : Vishnu Prasad D
		Created Date        : 31-3-2014
		Test Case ID        : CA_P2B_TC_09
		Mandatory Fields    : Existing Cust one account eligible sign up
	 ***************************************************************************/

@Test(groups = { FunctionalCategory.Acquisition })
		public void registerIntMultipleJI(){

	Report.createTestLogHeader("Channel Activation","Multiple JI account Register Interest");
	UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_9_1");
	String ExQues1="YES";
	String ExQues2 ="NO";
	String Account="JI";
	new HomePageAction().logout();
	new HomePageAction().navigateToLogin().login(userProfile);
	new ChannelActivationAction()
		.exclickSmartMeterLink(userProfile,Account)
		.exScreeningQues(userProfile,ExQues1,ExQues2)
		.ineligibleCheckClick()
		.inEligibleReasonExists().InEligibleSubmitReturn();
		UserProfile userProfile1 = new TestDataHelper().getUserProfile("CA_P2B_TC_9_2");
	 ExQues1="YES";
	 ExQues2 ="NO";
	 Account="JI";
	new ChannelActivationAction()
		.exclickSmartMeterLink(userProfile1,Account)
		.exScreeningQues(userProfile1,ExQues1,ExQues2)
		.ineligibleCheckClick()
		.inEligibleReasonExists().InEligibleSubmitReturn();
	new HomePageAction().logout();
		}
						



					


			/**************************************************************************
				Created By          : Vishnu Prasad D
				Created Date        : 31-3-2014
				Test Case ID        : CA_P2B_TC_05
				Mandatory Fields    : Existing Cust Single Premise No Appointment Error
			 ***************************************************************************/
@Test(groups = { FunctionalCategory.Acquisition })
		public void exSinglePremiseNoAppointment(){
		Report.createTestLogHeader("Channel Activation","Existing Cust Single Premise No Appointment Error");
		UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_3");
		String ExQues1="Yes";
		String ExQues2 ="No";
		String Account="Duel";
		new HomePageAction().navigateToLogin().login(userProfile);
		new ChannelActivationAction()
			.exclickSmartMeterLink(userProfile, Account)
			.exNoApntmntValidation();
	}
	
	
	

				/**************************************************************************
				Created By          : Vishnu Prasad D
				Created Date        : 31-3-2014
				Test Case ID        : CA_P2B_TC_06
				Mandatory Fields    : Existing Cust Multiple Premise No Appointment Error
			 ***************************************************************************/
		@Test(groups = { FunctionalCategory.Acquisition })
				public void exMulPremiseNoAppointment(){
				Report.createTestLogHeader("Channel Activation","Existing Cust Multiple Premise No Appointment Error");
				UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_3");
			String ExQues1="Yes";
			String ExQues2 ="No";
			String Account="Duel";
				new HomePageAction().navigateToLogin().login(userProfile);
				new ChannelActivationAction()
					.exclickSmartMeterLink(userProfile, Account)
					.exNoApntmntValidation();
					
	}
				
			/**************************************************************************
				Created By          : Vishnu Prasad D
				Created Date        : 31-3-2014
				Test Case ID        : CA_P2B_TC_08
				Mandatory Fields    : Existing Cust InEligible - 
			 ***************************************************************************/
				@Test(groups = { FunctionalCategory.Acquisition })
				public void exJIInEligible(){
				Report.createTestLogHeader("Channel Activation Existing Cust","CST ineligible Joint invoiced user is displayed with an intermediate page");
				UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_3");
			String ExQues1="Yes";
			String ExQues2 ="No";
			String Account="Duel";
				new HomePageAction().navigateToLogin().login(userProfile);
				new ChannelActivationAction()
					.exRegIntrestClick()
					.exScreeningQues(userProfile,ExQues1,ExQues2)
					.exClickSmartUpdates()
					.exClickFindMoreLink();
	}
			
			/**************************************************************************
				Created By          : Vishnu Prasad D
				Created Date        : 31-3-2014
				Test Case ID        : CA_P2B_TC_08
				Mandatory Fields    : Existing Cust InEligible - 
			 ***************************************************************************/
		
		@Test(groups = { FunctionalCategory.Acquisition })
				public void exDuelInEligible(){
				Report.createTestLogHeader("Channel Activation Existing Cust","CST ineligible Duel Fuel user is displayed with an intermediate page");
				UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_3");
			String ExQues1="Yes";
			String ExQues2 ="No";
			String Account="Duel";
				new HomePageAction().navigateToLogin().login(userProfile);
				new ChannelActivationAction()
					.exRegIntrestClick()
					.exScreeningQues(userProfile,ExQues1,ExQues2)
					.exClickSmartUpdates()
					.exClickFindMoreLink();
	}
	
	/**************************************************************************
				Created By          : Vishnu Prasad D
				Created Date        : 31-3-2014
				Test Case ID        : CA_P2B_TC_08
				Mandatory Fields    : Existing Cust InEligible - 
			 ***************************************************************************/
		
		@Test(groups = { FunctionalCategory.Acquisition })
				public void exMulJiInEligible(){
				Report.createTestLogHeader("Channel Activation - Existing Cust","CST ineligible Multi Premise JI user is displayed with an intermediate page");
				UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_3");
			String ExQues1="Yes";
			String ExQues2 ="No";
			String Account="Duel";
				new HomePageAction().navigateToLogin().login(userProfile);
				new ChannelActivationAction()
					.exRegIntrestClick()
					.exScreeningQues(userProfile,ExQues1,ExQues2)
					.exClickSmartUpdates()
					.exClickFindMoreLink();
	}
	
	/**************************************************************************
				Created By          : Vishnu Prasad D
				Created Date        : 31-3-2014
				Test Case ID        : CA_P2B_TC_08
				Mandatory Fields    : Existing Cust InEligible - 
			 ***************************************************************************/
		
		@Test(groups = { FunctionalCategory.Acquisition })
				public void exOneInEligible(){
				Report.createTestLogHeader("Channel Activation Existing Cust","CST ineligible Multi Premise Duel Fuel user is displayed with an intermediate page");
				UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_3");
			String ExQues1="Yes";
			String ExQues2 ="No";
			String Account="Duel";
				new HomePageAction().navigateToLogin().login(userProfile);
				new ChannelActivationAction()
					.exRegIntrestClick()
					.exScreeningQues(userProfile,ExQues1,ExQues2)
					.exClickSmartUpdates()
					.exClickFindMoreLink();
	}
	
	/**************************************************************************
				Created By          : Vishnu Prasad D
				Created Date        : 31-3-2014
				Test Case ID        : CA_P2B_TC_08
				Mandatory Fields    : Existing Cust InEligible - 
			 ***************************************************************************/
		
		@Test(groups = { FunctionalCategory.Acquisition })
				public void exSinleElecInEligible(){
				Report.createTestLogHeader("Channel Activation Existing Cust","CST Single Elec ineligible user is displayed with an intermediate page");
				UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_3");
			String ExQues1="Yes";
			String ExQues2 ="No";
			String Account="Duel";
				new HomePageAction().navigateToLogin().login(userProfile);
				new ChannelActivationAction()
					.exRegIntrestClick()
					.exScreeningQues(userProfile,ExQues1,ExQues2)
					.exClickSmartUpdates()
					.exClickFindMoreLink();
	}
	
	/*----------------------------------------------------------------Change Appointment--------------------------------------------------*/
			/**************************************************************************
				Created By          : Vishnu Prasad D
				Created Date        : 31-3-2014
				Test Case ID        : CA_P2B_TC_16
				Mandatory Fields    : Existing Cust  - Change Appointment 
			 ***************************************************************************/
			 		
		@Test(groups = { FunctionalCategory.Acquisition })
		public void exChangeAppointment(){
		Report.createTestLogHeader("Channel Activation - Change Apointment","Single Premise Reshedule Daily");
				UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_2");
				new HomePageAction().navigateToLogin().login(userProfile);
				new ChannelActivationAction()
					.changeBooking();
				}	
				
			/**************************************************************************
				Created By          : Vishnu Prasad D
				Created Date        : 31-3-2014
				Test Case ID        : CA_P2B_TC_17
				Mandatory Fields    : Existing Cust  - Change Appointment 
			 ***************************************************************************/
			 		
		@Test(groups = { FunctionalCategory.Acquisition })
		public void exChangeAppointmet(){
		Report.createTestLogHeader("Channel Activation - Change Apointment","Multiple Premise Premise Reshedule Monthly");
				UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_2");
					new HomePageAction().logout();
				new HomePageAction().navigateToLogin().login(userProfile);
				new ChannelActivationAction()
					.changeBooking();
						new HomePageAction().logout();
				}	
				
					/**************************************************************************
				Created By          : Vishnu Prasad D
				Created Date        : 31-3-2014
				Test Case ID        : CA_P2B_TC_17
				Mandatory Fields    : Existing Cust  - Change Appointment 
			 ***************************************************************************/
			 		
		@Test(groups = { FunctionalCategory.Acquisition })
		public void exChangeAppointmetHalf(){
		Report.createTestLogHeader("Channel Activation - Change Apointment","Verify Meter Frequency is not Dispalyed for Hourly");
				UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_2");
					new HomePageAction().logout();
				new HomePageAction().navigateToLogin().login(userProfile);
				new ChannelActivationAction()
					.changeBookingHalf();
						new HomePageAction().logout();
				}
				
						/**************************************************************************
				Created By          : Vishnu Prasad D
				Created Date        : 31-3-2014
				Test Case ID        : CA_P2B_TC_16
				Mandatory Fields    : Existing Cust  - Change Appointment 
			 ***************************************************************************/
			 		 
		@Test(groups = { FunctionalCategory.Acquisition })
		public void exChangeAppointmetDaily(){
		Report.createTestLogHeader("Channel Activation - Change Apointment","Verify Meter Frequency is Dispalyed for Daily");
				UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_2");
					new HomePageAction().logout();
				new HomePageAction().navigateToLogin().login(userProfile);
				new ChannelActivationAction()
					.changeBookingDaily();
						new HomePageAction().logout();
				}
				
						/**************************************************************************
				Created By          : Vishnu Prasad D
				Created Date        : 31-3-2014
				Test Case ID        : CA_P2B_TC_17
				Mandatory Fields    : Existing Cust  - Change Appointment 
			 ***************************************************************************/
			 		
		@Test(groups = { FunctionalCategory.Acquisition })
		public void exChangeAppointmetMonthly(){
		Report.createTestLogHeader("Channel Activation - Change Apointment","Verify Meter Frequency is Dispalyed for Monthly");
				UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_2");
					new HomePageAction().logout();
				new HomePageAction().navigateToLogin().login(userProfile);
				new ChannelActivationAction()
					.changeBookingMonthly();
						new HomePageAction().logout();
				}
				
					/**************************************************************************
				Created By          : Ragul M
				Created Date        : 31-3-2014
				Mandatory Fields    :Anonymous Customer-Register your Interest
			 ***************************************************************************/
		
		@Test(groups = { FunctionalCategory.Acquisition })
		public void anonymousCustomerRegisterforInterest(){
		Report.createTestLogHeader("Channel Activation","Anonymous Customer Register for Interest");
		UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_12");
		final Acquisition acquisition = new TestDataHelper()
		.getAcquisitionData("standardDualAcquisition");
		String outstandingBalance="No";
		String Eco7 ="Yes";
		String Flat="No";
		String FuseBox="Yes";
		String Smart="No";
		String AddressDD="2";
		String Tariff="A";
		String paymentType="Pay As You Go";
		new ChannelActivationAction()
		.openChanActURL();
		new HomePageAction().logout();
		new ChannelActivationAction()
		.clickbritishgasno()
		.selectPrePayMeter()
		.clickNewUserPage1Next() 
		.clickContinue()
		.newCustScreeningQues(outstandingBalance, Eco7, Flat, FuseBox, Smart)
		.screeningContinue()
		.verifyWeAreSorryPage()
		.tellAbtYou(userProfile, AddressDD)
		.screeningJoinUsWaitingPrority();
		}	 	
		@Test(groups = { FunctionalCategory.Acquisition })
		public void anonymousCustomerRegisterforInterest1(){
		Report.createTestLogHeader("Channel Activation","New Cust Energy Shop");
		UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_12");
		final Acquisition acquisition = new TestDataHelper()
		.getAcquisitionData("standardDualAcquisition");
		String outstandingBalance="No";
		String Eco7 ="No";
		String Flat="Yes";
		String FuseBox="No";
		String Smart="Yes";
		String AddressDD="2";
		String Tariff="A";
		String paymentType="Pay As You Go";
		new ChannelActivationAction()
		.openChanActURL();
		new HomePageAction().logout();
		new ChannelActivationAction()
		.clickbritishgasno()
		.selectPrePayMeter()
		.clickNewUserPage1Next() 
		.clickContinue()
		.newCustScreeningQues(outstandingBalance, Eco7, Flat, FuseBox, Smart)
		.screeningContinue()
		.verifyWeAreSorryPage()
		.tellAbtYou(userProfile, AddressDD)
		.screeningJoinUsWaitingPrority();
		}	 		
	
		/**************************************************************************
		Created By          : Ragul M
		Created Date        : 31-11-2014
		Journey             :Existing Customer-Pre Payment-Upgrade To Smart Meter(Booking Through First Day First Slot )
	 ***************************************************************************/
		

		@Test(groups = { FunctionalCategory.Acquisition })
		public void ExCustCASignUpDualPrePayFF(){
			Report.createTestLogHeader("Channel Activation","Existing Duel Fuel Cust Energy Shop");
			UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
			String ExQues1="YES";
			String ExQues2 ="NO";
			String Account="Single";
			String meterReadFrequency="Half Hourly";
			new HomePageAction().logout();
			new HomePageAction().navigateToLogin().login(userProfile);
			new ChannelActivationAction()
				.exclickSmartMeterLink(userProfile,Account)
				.exScreeningQues(userProfile,ExQues1,ExQues2)
				.exClickConfrmAddContinue()
				.verifyChooseYourAppointmentPage()
			    .navigateToReviewYourAppointmentPageFirstAvailableAppointment()
			    .verifyRevieweDtailsPage(meterReadFrequency)
			    .navigateToConfirmationPage()
				.exVerifyApnmtConfirm(userProfile)
				.exClickGo2Account()
				.exAppointmentExistsValidn();
				new HomePageAction().logout();
			}
		@Test(groups = { FunctionalCategory.Acquisition })
		public void ExCustCASignUpDualPrePayFF1(){
			Report.createTestLogHeader("Channel Activation","Existing Duel Fuel Cust Energy Shop");
			UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount1");
			String ExQues1="YES";
			String ExQues2 ="NO";
			String Account="Single";
			String meterReadFrequency="Monthly";
			new HomePageAction().logout();
			new HomePageAction().navigateToLogin().login(userProfile);
			new ChannelActivationAction()
				.exclickSmartMeterLink(userProfile,Account)
				.exScreeningQues(userProfile,ExQues1,ExQues2)
				.exClickConfrmAddContinue()
				.verifyChooseYourAppointmentPage()
			    .navigateToReviewYourAppointmentPageFirstAvailableAppointment()
			    .verifyRevieweDtailsPage(meterReadFrequency)
			    .navigateToConfirmationPage()
				.exVerifyApnmtConfirm(userProfile)
				.exClickGo2Account()
				.exAppointmentExistsValidn();
				new HomePageAction().logout();
			}
		/**************************************************************************
		Created By          : Ragul M
		Created Date        : 31-11-2014
		Journey             :Existing Customer-Pre Payment-Upgrade To Smart Meter(Booking Through Calendar Slots )
	 ***************************************************************************/
		@Test(groups = { FunctionalCategory.Acquisition })
		public void ExCustCASignUpDualPrePayCalendar(){
			Report.createTestLogHeader("Channel Activation","Existing Duel Fuel Cust Energy Shop");
			UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
			String ExQues1="YES";
			String ExQues2 ="NO";
			String Account="Single";
			String meterReadFrequency="Daily";
			new HomePageAction().logout();
			new HomePageAction().navigateToLogin().login(userProfile);
			new ChannelActivationAction()
				.exclickSmartMeterLink(userProfile,Account)
				.exScreeningQues(userProfile,ExQues1,ExQues2)
				.exClickConfrmAddContinue()
				.verifyChooseYourAppointmentPage()
			    .navigateToReviewYourAppointmentPageThroughCalendar()
			    .verifyRevieweDtailsPage(meterReadFrequency)
			    .navigateToConfirmationPage()
				.exVerifyApnmtConfirm(userProfile)
				.exClickGo2Account()
				.exAppointmentExistsValidn();
				new HomePageAction().logout();
			}
		/**************************************************************************
		Created By          : Ragul M
		Created Date        : 31-11-2014
		Journey             :Existing Customer-Pre Payment-Upgrade To Smart Meter From Smart Meter Landing Page(Booking Through First Day First Slot)
	 ***************************************************************************/
		

		@Test(groups = { FunctionalCategory.Acquisition })
		public void ExCustCASignUpDualPrePayDeepLinkFF(){
			Report.createTestLogHeader("Channel Activation","Existing Duel Fuel Cust Energy Shop");
			UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount1");
			String ExQues1="YES";
			String ExQues2 ="NO";
			String meterReadFrequency="Half Hourly";
			String Account="Single";
			new HomePageAction().logout();
			new ChannelActivationAction()
			    .openChanActURL()
			    .selectbritishgasYes()
			    .selectPrePayMeter()
			    .clickLoginLink();
			new LoginAction().login(userProfile);
			new ChannelActivationAction()
			    .exclickSmartMeterLink(userProfile,Account)
				.exScreeningQues(userProfile,ExQues1,ExQues2)
				.exClickConfrmAddContinue()
				.verifyChooseYourAppointmentPage()
			    .navigateToReviewYourAppointmentPageFirstAvailableAppointment()
			    .verifyRevieweDtailsPage(meterReadFrequency)
			    .navigateToConfirmationPage()
				.exVerifyApnmtConfirm(userProfile)
				.exClickGo2Account()
				.exAppointmentExistsValidn();
				new HomePageAction().logout();
			}
		@Test(groups = { FunctionalCategory.Acquisition })
		public void ExCustCASignUpDualPrePayDeepLinkCalendar(){
			Report.createTestLogHeader("Channel Activation","Existing Duel Fuel Cust Energy Shop");
			UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
			String ExQues1="YES";
			String ExQues2 ="NO";
			String meterReadFrequency="Monthly";
			String Account="Single";
			new HomePageAction().logout();
			new ChannelActivationAction()
			    .openChanActURL()
			    .selectbritishgasYes()
			    .selectPrePayMeter()
			    .clickLoginLink();
			new LoginAction().login(userProfile);
			new ChannelActivationAction()
			    .exclickSmartMeterLink(userProfile,Account)
				.exScreeningQues(userProfile,ExQues1,ExQues2)
				.exClickConfrmAddContinue()
				.verifyChooseYourAppointmentPage()
			    .navigateToReviewYourAppointmentPageThroughCalendar()
			    .verifyRevieweDtailsPage(meterReadFrequency)
			    .navigateToConfirmationPage()
				.exVerifyApnmtConfirm(userProfile)
				.exClickGo2Account()
				.exAppointmentExistsValidn();
				new HomePageAction().logout();
			}
		/**************************************************************************
	    Created By          : Ragul M
	    Created Date        : 25-11-2014
	    Test Case ID        : CA_P2B_TC_012
	    Mandatory Fields    : Anonymous Customer Sign Up for Smart Meter
		 ***************************************************************************/
		
		@Test(groups = { FunctionalCategory.Acquisition })
		public void NewCustPrePaySignUpTariffA(){
			Report.createTestLogHeader("Channel Activation","New Cust Energy Shop Tariff A");
			UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_12");
			final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
			String outstandingBalance="No";
			String Eco7 ="No";
			String Flat="No";
			String FuseBox="Yes";
			String Smart="No";
			String AddressDD="2";
			String Tariff="A";
			String paymentType="Pay As You Go";
			new ChannelActivationAction()
			.openChanActURL();
			new HomePageAction().logout();
			new ChannelActivationAction()
			.clickbritishgasno()
			.selectPrePayMeter()
			.clickNewUserPage1Next() 
			//.clickContinue()
			.newCustScreeningQues(outstandingBalance, Eco7, Flat, FuseBox, Smart)
			.screeningContinue()
			.screeningJoinUs()
	       .newCusFlowDecider(acquisition,userProfile, AddressDD, outstandingBalance, Eco7, Flat, FuseBox, Smart,Tariff,paymentType);
			new HomePageAction().navigateToLogin().login(userProfile);
			new HomePageAction().logout();
			}
		@Test(groups = { FunctionalCategory.Acquisition })
		public void NewCustPrePaySignUpTariffB(){
			Report.createTestLogHeader("Channel Activation","New Cust Energy Shop Tariff B");
			UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_12");
			final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
			String outstandingBalance="No";
			String Eco7 ="No";
			String Flat="No";
			String FuseBox="Yes";
			String Smart="No";
			String AddressDD="2";
			String Tariff="B";
			String paymentType="Pay As You Go";
			new ChannelActivationAction()
			.openChanActURL();
			new HomePageAction().logout();
			new ChannelActivationAction()
			.clickbritishgasno()
			.selectPrePayMeter()
			.clickNewUserPage1Next() 
			.clickContinue()
			.newCustScreeningQues(outstandingBalance, Eco7, Flat, FuseBox, Smart)
			.screeningContinue()
			.screeningJoinUs()
	       .newCusFlowDecider(acquisition,userProfile, AddressDD, outstandingBalance, Eco7, Flat, FuseBox, Smart,Tariff,paymentType);
			new HomePageAction().navigateToLogin().login(userProfile);
			new HomePageAction().logout();
			}
		@Test(groups = { FunctionalCategory.Acquisition })
		public void NewCustPrePaySignUpTariffC(){
			Report.createTestLogHeader("Channel Activation","New Cust Energy Shop Tariff C");
			UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_13");
			final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
			String outstandingBalance="No";
			String Eco7 ="No";
			String Flat="No";
			String FuseBox="Yes";
			String Smart="No";
			String AddressDD="2";
			String Tariff="C";
			String paymentType="Pay As You Go";
			new ChannelActivationAction()
			.openChanActURL();
			new HomePageAction().logout();
			new ChannelActivationAction()
			.clickbritishgasno()
			.selectPrePayMeter()
			.clickNewUserPage1Next() 
			.clickContinue()
			.newCustScreeningQues(outstandingBalance, Eco7, Flat, FuseBox, Smart)
			.screeningContinue()
			.screeningJoinUs()
	        .newCusFlowDecider(acquisition,userProfile, AddressDD, outstandingBalance, Eco7, Flat, FuseBox, Smart,Tariff,paymentType);
			new HomePageAction().navigateToLogin().login(userProfile);
			new HomePageAction().logout();
			}
		@Test(groups = { FunctionalCategory.Acquisition })
		public void NewCustPrePaySignUpTariffD(){
			Report.createTestLogHeader("Channel Activation","New Cust Energy Shop Tariff D");
			UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_12");
			final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
			String outstandingBalance="No";
			String Eco7 ="No";
			String Flat="No";
			String FuseBox="Yes";
			String Smart="No";
			String AddressDD="2";
			String Tariff="D";
			String paymentType="Pay As You Go";
			new ChannelActivationAction()
			.openChanActURL();
			new HomePageAction().logout();
			new ChannelActivationAction()
			.clickbritishgasno()
			.selectPrePayMeter()
			.clickNewUserPage1Next() 
			.clickContinue()
			.screeningJoinUs()
			.newCustScreeningQues(outstandingBalance, Eco7, Flat, FuseBox, Smart)
			.screeningContinue()
	        .newCusFlowDecider(acquisition,userProfile, AddressDD, outstandingBalance, Eco7, Flat, FuseBox, Smart,Tariff,paymentType);
			new HomePageAction().navigateToLogin().login(userProfile);
			new HomePageAction().logout();
			}
		/**************************************************************************
		Created By          : Ragul M
		Created Date        : 31-11-2014
		Functionality    : Multiple Premise Data-One account Eligible Another Account In eligible
	 ***************************************************************************/

@Test(groups = { FunctionalCategory.Acquisition })
		public void ExOneAccountValidPrePay(){

	Report.createTestLogHeader("Channel Activation","Existing Cust Multi Premise Two Accounts one valid and other invalid ");
	UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
	String ExQues1="YES";
	String ExQues2 ="NO";
	String meterReadFrequency="Half Hourly";
	new HomePageAction().logout();
	new HomePageAction().navigateToLogin().login(userProfile);
	new ChannelActivationAction()
	.clickUpgradeToSmartMeterLink()
	.exScreeningQues(userProfile,ExQues1,ExQues2)
	.exClickConfrmAddContinue()
	.verifyChooseYourAppointmentPage()
    .navigateToReviewYourAppointmentPageThroughCalendar()
    .verifyRevieweDtailsPage(meterReadFrequency)
    .navigateToConfirmationPage()
	.exVerifyApnmtConfirm(userProfile)
	.exClickGo2Account()
	.exAppointmentExistsValidn();
	ExQues1="YES";
	ExQues2 ="NO";
	new ChannelActivationAction()
	    .clickRegisterYourSmartMeterInterestLink()
		.exScreeningQues(userProfile, ExQues1, ExQues2)
		.ineligibleCheckClick().inEligibleReasonExists()
		.checkBritishGasCheckBox()
		.InEligibleSubmitReturn()
		.InEligibleVerifyAccountOverview();
	new HomePageAction().logout();
		}
        /**************************************************************************
        Created By          : Vishnu Prasad D
        Created Date        : 31-3-2014
        Test Case ID        : CA_P2B_TC_04 , CA_P2B_TC_10
        Mandatory Fields    : Change Appointment 
        ***************************************************************************/	

@Test(groups = { FunctionalCategory.Acquisition })
		public void exChangeAppointmentPrePay(){
		Report.createTestLogHeader("Channel Activation - Change Apointment","Single Premise Reshedule Daily");
				UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
				String meterReadFrequency="Monthly";
				new HomePageAction().navigateToLogin().login(userProfile);
				new ChannelActivationAction()
					.clickChangeAppointment()
					.verifyChooseYourAppointmentPage()
				    .navigateToReviewYourAppointmentPageFirstAvailableAppointment()
				    .verifyRevieweDtailsPage(meterReadFrequency)
				    .navigateToConfirmationPage()
					.changeVerifyApnmtConfirm()
					.exClickGo2Account()
					.exAppointmentExistsValidn();
					new HomePageAction().logout();
				}

	/**************************************************************************
	 * Created By : Ragul M 
	 * Created Date : 31-3-2014 
	 * Test Case Functionality : Existing Multiple account eligible sign
	 
	 ***************************************************************************/

	@Test(groups = { FunctionalCategory.Acquisition })
	public void registerIntMultiplePrePayDuel() {

		Report.createTestLogHeader("Channel Activation",
				"Multiple Duel account Register Interest");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_P2B_TC_9_1");
		String ExQues1 = "YES";
		String ExQues2 = "NO";
		String Account = "JI";
		new HomePageAction().logout();
		new HomePageAction().navigateToLogin().login(userProfile);
		new ChannelActivationAction()
		.exclickSmartMeterLink(userProfile,Account)
		.exScreeningQues(userProfile,ExQues1,ExQues2)
		.ineligibleCheckClick()
		.inEligibleReasonExists().InEligibleSubmitReturn()
		.InEligibleVerifyAccountOverview();
		UserProfile userProfile1 = new TestDataHelper()
				.getUserProfile("CA_P2B_TC_9_2");
		ExQues1 = "YES";
		ExQues2 = "NO";
		Account = "JI";
		new ChannelActivationAction()
				.exclickSmartMeterLink(userProfile, Account)
				.exScreeningQues(userProfile, ExQues1, ExQues2)
				.ineligibleCheckClick().inEligibleReasonExists()
				.checkBritishGasCheckBox().InEligibleSubmitReturn()
				.InEligibleVerifyAccountOverview();
		new HomePageAction().logout();
	}


	/**************************************************************************
	Created By          : Vishnu Prasad D
	Created Date        : 25-3-2014
	Test Case ID        : CA_P2B_TC_03
	Mandatory Fields    : Existing Cust Multiple premise Sing up 
 ***************************************************************************/

		@Test(groups = { FunctionalCategory.Acquisition })
		public void ExMulPremisePrePayDuel(){
			Report.createTestLogHeader("Channel Activation","Existing Cust Multiple Premise Duel and Ji ");
			UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_3_1");
			String ExQues1="YES";
			String ExQues2 ="NO";
			String Account="DUEL";
			String meterReadFrequency="Monthly";
			new HomePageAction().logout();
			new HomePageAction().navigateToLogin().login(userProfile);
			new ChannelActivationAction()
			.exclickSmartMeterLink(userProfile,Account)
			.exScreeningQues(userProfile,ExQues1,ExQues2)
			.exClickConfrmAddContinue()
			.verifyChooseYourAppointmentPage()
		    .navigateToReviewYourAppointmentPageFirstAvailableAppointment()
		    .verifyRevieweDtailsPage(meterReadFrequency)
		    .navigateToConfirmationPage()
			.exVerifyApnmtConfirm(userProfile)
			.exClickGo2Account()
			.exAppointmentExistsValidn();
			UserProfile userProfile2 = new TestDataHelper().getUserProfile("CA_P2B_TC_3_2");
			ExQues1="YES";
			ExQues2 ="NO";
			Account="DUEL";
			new ChannelActivationAction()
			.exclickSmartMeterLink(userProfile2,Account)
			.exScreeningQues(userProfile2,ExQues1,ExQues2)
			.exClickConfrmAddContinue()
			.verifyChooseYourAppointmentPage()
		    .navigateToReviewYourAppointmentPageFirstAvailableAppointment()
		    .verifyRevieweDtailsPage(meterReadFrequency)
		    .navigateToConfirmationPage()
			.exVerifyApnmtConfirm(userProfile2)
			.exClickGo2Account()
			.exAppointmentExistsValidn();
			new HomePageAction().logout();
		}
		@Test(groups = { FunctionalCategory.Acquisition })
		public void ExMulPremisePrePayDuelCalendar(){
			Report.createTestLogHeader("Channel Activation","Existing Cust Multiple Premise Duel and Ji ");
			UserProfile userProfile = new TestDataHelper().getUserProfile("CA_P2B_TC_3_1");
			String ExQues1="YES";
			String ExQues2 ="NO";
			String Account="DUEL";
			String meterReadFrequency="Monthly";
			new HomePageAction().logout();
			new HomePageAction().navigateToLogin().login(userProfile);
			new ChannelActivationAction()
			.exclickSmartMeterLink(userProfile,Account)
			.exScreeningQues(userProfile,ExQues1,ExQues2)
			.exClickConfrmAddContinue()
			.verifyChooseYourAppointmentPage()
		    .navigateToReviewYourAppointmentPageFirstAvailableAppointment()
		    .verifyRevieweDtailsPage(meterReadFrequency)
		    .navigateToConfirmationPage()
			.exVerifyApnmtConfirm(userProfile)
			.exClickGo2Account()
			.exAppointmentExistsValidn();
			UserProfile userProfile2 = new TestDataHelper().getUserProfile("CA_P2B_TC_3_2");
			ExQues1="YES";
			ExQues2 ="NO";
			Account="DUEL";
			new ChannelActivationAction()
			.exclickSmartMeterLink(userProfile2,Account)
			.exScreeningQues(userProfile2,ExQues1,ExQues2)
			.exClickConfrmAddContinue()
			.verifyChooseYourAppointmentPage()
		    .navigateToReviewYourAppointmentPageThroughCalendar()
		    .verifyRevieweDtailsPage(meterReadFrequency)
		    .navigateToConfirmationPage()
			.exVerifyApnmtConfirm(userProfile2)
			.exClickGo2Account()
			.exAppointmentExistsValidn();
			new HomePageAction().logout();
		}
}

