package bg.framework.app.functional.test.sales;

import static bg.framework.app.functional.entities.FunctionalCategory.BetterDeal;
import static bg.framework.app.functional.entities.FunctionalCategory.Smoke;
import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.action.sales.BetterDealAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.SiebelDataBase;
import bg.framework.app.functional.util.TestDataHelper;

public class BetterDealTest extends TestBase {

	SiebelDataBase siebelDataBase = new SiebelDataBase();
	/******************************************* Mandatory Data(UserProfile.xml) ***********************************************/
	/*---ELE,GAS,JI
	Registered Scenarios
			<email>bgdigitaltest@gmail.com</email>
            <password>password12</password>
            <accNumber>850000491112</accNumber>
			<tariffName1>Standard</tariffName1>
			<tariffName2>Fixed Price June 2013</tariffName2>
	Registered Login Scenarios
			<email>bgdigitaltest@gmail.com</email>
            <password>password12</password>
            <accNumber>850000491112</accNumber>
			<tariffName1>Standard</tariffName1>
			<tariffName2>Fixed Price June 2013</tariffName2>
	Not Registered Scenarios
			<email>bgdigitaltest@gmail.com</email>
            <password>password12</password>
            <firstName>John</firstName>
            <lastName>IRVING</lastName>
            <title>Mr</title>
            <accNumber>850000491112</accNumber>
			<tariffName1>Standard</tariffName1>
			<tariffName2>Fixed Price June 2013</tariffName2>
			
			/*---DUAL
	Registered Scenarios
			<email>bgdigitaltest@gmail.com</email>
            <password>password12</password>
            <elecAccount></elecAccount>
            <gasAccount></gasAccount>
            <accNumber>850000491112</accNumber>
			<tariffName1>Standard</tariffName1>
			<tariffName2>Fixed Price June 2013</tariffName2>
	Registered Login Scenarios
			<email>bgdigitaltest@gmail.com</email>
            <password>password12</password>
            <elecAccount></elecAccount>
            <gasAccount></gasAccount>
            <accNumber>850000491112</accNumber>
			<tariffName1>Standard</tariffName1>
			<tariffName2>Fixed Price June 2013</tariffName2>
	Not Registered Scenarios
			<email>bgdigitaltest@gmail.com</email>
            <password>password12</password>
            <firstName>John</firstName>
            <lastName>IRVING</lastName>
            <title>Mr</title>
            <elecAccount></elecAccount>
            <gasAccount></gasAccount>
            <accNumber>850000491112</accNumber>
			<tariffName1>Standard</tariffName1>
			<tariffName2>Fixed Price June 2013</tariffName2>
	
	*/
	
	/********************************************************************************************************/

	/******************************************* DUAL JOURNEY ***********************************************/
	@Test(groups = { BetterDeal, Smoke })
	public void dualRegistered1() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Registered- GAS&ELE-DD,ES,PrimaryUCRN,Nector Registered-YES");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");
		String nectorRegistered = "YES";
		String directDebitELE = "DD";
		String directDebitGAS = "DD";
		String esmartEle = "YES";
		String esmartGas = "YES";
		String fualtype = "Dual";
		new BetterDealAction().betterDealUrl(userProfile, fualtype).loginUserDetails(userProfile)
				.betterDealHeading(userProfile).saveMoneyQuestion(userProfile)
				.saveMoneyAnswer(userProfile).fualType(userProfile, fualtype)
				.postCodeTitle(userProfile).currentTariff(userProfile)
				.currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebit(userProfile, directDebitELE, directDebitGAS)
				.nector(userProfile, nectorRegistered)
				.esmart(userProfile, esmartEle, esmartGas);
		// .logout();
	}

	@Test(groups = { BetterDeal, Smoke })
	public void dualRegisteredLogedin2() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Registered- GAS-CC&ELE-DD,Gas&Ele-ES,SecondaryUCRN,Nector Registered-YES");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");
		String nectorRegistered = "YES";
		String directDebitELE = "DD";
		String directDebitGAS = "CC";
		String esmartEle = "YES";
		String esmartGas = "YES";
		String fualtype = "Dual";
		new BetterDealAction().loginUrl(userProfile).loginUserDetails(userProfile)
				.deepUrl(userProfile, fualtype).betterDealHeading(userProfile)
				.saveMoneyQuestion(userProfile).saveMoneyAnswer(userProfile)
				.fualType(userProfile, fualtype).postCodeTitle(userProfile)
				.currentTariff(userProfile).currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebit(userProfile, directDebitELE, directDebitGAS)
				.nector(userProfile, nectorRegistered)
				.esmart(userProfile, esmartEle, esmartGas);
		// .logout();
	}

	@Test(groups = { BetterDeal, Smoke })
	public void dualNotRegistered3() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Registered- GASELE-VDD,Gas&Ele-Non-ES,PrimaryUCRN,Nector Registered-YES");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");
		String nectorRegistered = "YES";
		String directDebitELE = "VDD";
		String directDebitGAS = "VDD";
		String esmartEle = "NO";
		String esmartGas = "NO";
		String fualtype = "Dual";
		new BetterDealAction().betterDealUrl(userProfile, fualtype)
				.deepUrlRegistartion(userProfile)
				.loginUserDetails(userProfile)
				.betterDealHeading(userProfile)
				.saveMoneyQuestion(userProfile).saveMoneyAnswer(userProfile)
				.fualType(userProfile, fualtype).postCodeTitle(userProfile)
				.currentTariff(userProfile).currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebit(userProfile, directDebitELE, directDebitGAS)
				.nector(userProfile, nectorRegistered)
				.esmart(userProfile, esmartEle, esmartGas);
		// .logout();
	}

	@Test(groups = { BetterDeal, Smoke })
	public void dualRegistered4() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Registered- GAS-Non ES&ELE-ES,GAS-DD,ELE-Fual Type,PrimaryUCRN,Nector Registered-YES");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");
		String nectorRegistered = "NO";
		String directDebitELE = "SO";
		String directDebitGAS = "DD";
		String esmartEle = "YES";
		String esmartGas = "NO";
		String fualtype = "Dual";
		new BetterDealAction().betterDealUrl(userProfile, fualtype).loginUserDetails(userProfile)
				.betterDealHeading(userProfile).saveMoneyQuestion(userProfile)
				.saveMoneyAnswer(userProfile).fualType(userProfile, fualtype)
				.postCodeTitle(userProfile).currentTariff(userProfile)
				.currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebit(userProfile, directDebitELE, directDebitGAS)
				.nector(userProfile, nectorRegistered)
				.esmart(userProfile, esmartEle, esmartGas);
		// .logout();
	}

	@Test(groups = { BetterDeal, Smoke })
	public void dualRegisteredLogedin5() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Registered- GAS&ELE-DD,Gas&Ele-ES,SecondaryUCRN,Nector Registered-NO");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");
		String nectorRegistered = "NO";
		String directDebitELE = "DD";
		String directDebitGAS = "DD";
		String esmartEle = "YES";
		String esmartGas = "YES";
		String fualtype = "Dual";
		new BetterDealAction().loginUrl(userProfile).loginUserDetails(userProfile)
				.deepUrl(userProfile, fualtype).betterDealHeading(userProfile)
				.saveMoneyQuestion(userProfile).saveMoneyAnswer(userProfile)
				.fualType(userProfile, fualtype).postCodeTitle(userProfile)
				.currentTariff(userProfile).currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebit(userProfile, directDebitELE, directDebitGAS)
				.nector(userProfile, nectorRegistered)
		 		.esmart(userProfile, esmartEle, esmartGas);
		// .logout();
	}

	@Test(groups = { BetterDeal, Smoke })
	public void dualNotRegistered6() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Registered- GAS-MC&ELE-VDD,Gas&Ele-ES,PrimaryUCRN,Nector Registered-NO");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");
		String nectorRegistered = "NO";
		String directDebitELE = "VDD";
		String directDebitGAS = "CC";
		String esmartEle = "YES";
		String esmartGas = "YES";
		String fualtype = "Dual";
		new BetterDealAction()
				.betterDealUrl(userProfile, fualtype)
				.deepUrlRegistartion(userProfile)
				.loginUserDetails(userProfile)
				.betterDealHeading(userProfile)
				.saveMoneyQuestion(userProfile).saveMoneyAnswer(userProfile)
				.fualType(userProfile, fualtype).postCodeTitle(userProfile)
				.currentTariff(userProfile).currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebit(userProfile, directDebitELE, directDebitGAS)
				.nector(userProfile, nectorRegistered)
				.esmart(userProfile, esmartEle, esmartGas);
		// .logout();
	}

	@Test(groups = { BetterDeal, Smoke })
	public void dualRegistered7() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Registered- GAS-ES&ELE-Non ES,GAS-DD,ELE-VDD,PrimaryUCRN,Nector Registered-No");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");
		String nectorRegistered = "NO";
		String directDebitELE = "VDD";
		String directDebitGAS = "DD";
		String esmartEle = "NO";
		String esmartGas = "YES";
		String fualtype = "Dual";
		new BetterDealAction().betterDealUrl(userProfile, fualtype).loginUserDetails(userProfile)
				.betterDealHeading(userProfile).saveMoneyQuestion(userProfile)
				.saveMoneyAnswer(userProfile).fualType(userProfile, fualtype)
				.postCodeTitle(userProfile).currentTariff(userProfile)
				.currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebit(userProfile, directDebitELE, directDebitGAS)
				.nector(userProfile, nectorRegistered)
		 		.esmart(userProfile, esmartEle, esmartGas);
		// .logout();
	}

	@Test(groups = { BetterDeal, Smoke })
	public void dualNotRegistered8() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Not Registered- GAS&ELE-CC,Gas&Ele-Non ES,PrimaryUCRN,Nector Registered-NO");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");
		String nectorRegistered = "NO";
		String directDebitELE = "CC";
		String directDebitGAS = "CC";
		String esmartEle = "NO";
		String esmartGas = "NO";
		String fualtype = "Dual";
		new BetterDealAction()
				.betterDealUrl(userProfile, fualtype)
				.deepUrlRegistartion(userProfile)
				.loginUserDetails(userProfile)
				.betterDealHeading(userProfile)
				.saveMoneyQuestion(userProfile).saveMoneyAnswer(userProfile)
				.fualType(userProfile, fualtype).postCodeTitle(userProfile)
				.currentTariff(userProfile).currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebit(userProfile, directDebitELE, directDebitGAS)
				.nector(userProfile, nectorRegistered)
				.esmart(userProfile, esmartEle, esmartGas);
		// .logout();
	}

	@Test(groups = { BetterDeal, Smoke })
	public void dualRegistered9() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Registered- GAS&ELE-CC,Gas&Ele-Non ES,SecondaryUCRN,Nector Registered-NO");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");
		String nectorRegistered = "NO";
		String directDebitELE = "CC";
		String directDebitGAS = "CC";
		String esmartEle = "NO";
		String esmartGas = "NO";
		String fualtype = "Dual";
		new BetterDealAction().betterDealUrl(userProfile, fualtype).loginUserDetails(userProfile)
				.betterDealHeading(userProfile)
				.saveMoneyQuestion(userProfile).saveMoneyAnswer(userProfile)
				.fualType(userProfile, fualtype).postCodeTitle(userProfile)
				.currentTariff(userProfile).currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebit(userProfile, directDebitELE, directDebitGAS)
				.nector(userProfile, nectorRegistered)
				.esmart(userProfile, esmartEle, esmartGas);
		// .logout();
	}

	@Test(groups = { BetterDeal, Smoke })
	public void dualRegisteredLogedin10() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Registered- GAS&ELE-Non ES,GAS&ELE-DD,SecondaryUCRN,Nector Registered-YES");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");
		String nectorRegistered = "YES";
		String directDebitELE = "DD";
		String directDebitGAS = "DD";
		String esmartEle = "NO";
		String esmartGas = "NO";
		String fualtype = "Dual";
		new BetterDealAction().loginUrl(userProfile).loginUserDetails(userProfile)
				.deepUrl(userProfile, fualtype).betterDealHeading(userProfile).saveMoneyQuestion(userProfile)
				.saveMoneyAnswer(userProfile).fualType(userProfile, fualtype)
				.postCodeTitle(userProfile).currentTariff(userProfile)
				.currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebit(userProfile, directDebitELE, directDebitGAS)
				.nector(userProfile, nectorRegistered)
				.esmart(userProfile, esmartEle, esmartGas);
		// .logout();
	}

	@Test(groups = { BetterDeal, Smoke })
	public void dualRegistered11() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Registered- DUAL-DD&ELE-CC,Gas&Ele-Non ES,PrimaryUCRN,Nector Registered-YES");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");
		String nectorRegistered = "YES";
		String directDebitELE = "CC";
		String directDebitGAS = "DD";
		String esmartEle = "NO";
		String esmartGas = "NO";
		String fualtype = "Dual";
		new BetterDealAction().betterDealUrl(userProfile, fualtype).loginUserDetails(userProfile)
				.betterDealHeading(userProfile)
				.saveMoneyQuestion(userProfile).saveMoneyAnswer(userProfile)
				.fualType(userProfile, fualtype).postCodeTitle(userProfile)
				.currentTariff(userProfile).currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebit(userProfile, directDebitELE, directDebitGAS)
				.nector(userProfile, nectorRegistered)
				.esmart(userProfile, esmartEle, esmartGas);
		// .logout();
	}

	@Test(groups = { BetterDeal, Smoke })
	public void dualNotRegistered12() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Registered- GAS&ELE-DD,Gas-Non ES&Ele-ES,PrimaryUCRN,Nector Registered-NO");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");
		String nectorRegistered = "NO";
		String directDebitELE = "DD";
		String directDebitGAS = "DD";
		String esmartEle = "YES";
		String esmartGas = "NO";
		String fualtype = "Dual";
		new BetterDealAction()
				.betterDealUrl(userProfile, fualtype)
				.deepUrlRegistartion(userProfile)
				.loginUserDetails(userProfile)
				.betterDealHeading(userProfile)
				.saveMoneyQuestion(userProfile).saveMoneyAnswer(userProfile)
				.fualType(userProfile, fualtype).postCodeTitle(userProfile)
				.currentTariff(userProfile).currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebit(userProfile, directDebitELE, directDebitGAS)
				.nector(userProfile, nectorRegistered)
				.esmart(userProfile, esmartEle, esmartGas);
		// .logout();
	}

	/******************************************* JI JOURNEY ***********************************************/

	@Test(groups = { BetterDeal, Smoke })
	public void jiRegistered1() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Registered JI- DD,ES,PrimaryUCRN,Nector Registered-YES");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JIAccount");
		String nectorRegistered = "YES";
		String directDebit = "DD";
		String esmart = "YES";
		String fualtype = "JI";
		new BetterDealAction().betterDealUrl(userProfile, fualtype).loginUserDetails(userProfile)
				.betterDealHeading(userProfile).saveMoneyQuestion(userProfile)
				.saveMoneyAnswer(userProfile).fualType(userProfile, fualtype)
				.postCodeTitle(userProfile).currentTariff(userProfile)
				.currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebitSingle(userProfile, directDebit)
				.nector(userProfile, nectorRegistered)
				.esmartSingle(userProfile, esmart);
		// .logout();
	}

	@Test(groups = { BetterDeal, Smoke })
	public void jiRegisteredLogedin2() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Registered JI- DD,ES,SecondaryUCRN,Nector Registered-YES");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JIAccount");
		String nectorRegistered = "YES";
		String directDebit = "CC";
		String esmart = "YES";
		String fualtype = "JI";
		new BetterDealAction().loginUrl(userProfile).loginUserDetails(userProfile)
				.deepUrl(userProfile, fualtype)
				.betterDealHeading(userProfile)
				.saveMoneyQuestion(userProfile).saveMoneyAnswer(userProfile)
				.fualType(userProfile, fualtype).postCodeTitle(userProfile)
				.currentTariff(userProfile).currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebitSingle(userProfile, directDebit)
				.nector(userProfile, nectorRegistered)
				.esmartSingle(userProfile, esmart);
		// .logout();
	}

	@Test(groups = { BetterDeal, Smoke })
	public void jiNotRegistered3() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Registered JI- VDD,Non-ES,PrimaryUCRN,Nector Registered-YES");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JIAccount");
		String nectorRegistered = "YES";
		String directDebit = "VDD";
		String esmart = "NO";
		String fualtype = "JI";
		new BetterDealAction()
				.betterDealUrl(userProfile, fualtype)
				.deepUrlRegistartion(userProfile)
				.loginUserDetails(userProfile)
				.betterDealHeading(userProfile)
				.saveMoneyQuestion(userProfile).saveMoneyAnswer(userProfile)
				.fualType(userProfile, fualtype).postCodeTitle(userProfile)
				.currentTariff(userProfile).currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebitSingle(userProfile, directDebit)
				.nector(userProfile, nectorRegistered)
				.esmartSingle(userProfile, esmart);
		// .logout();
	}

	@Test(groups = { BetterDeal, Smoke })
	public void jiRegistered4() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Registered JI- FD,-ES,SecondaryUCRN,Nector Registered-NO");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JIAccount");
		String nectorRegistered = "YES";
		String directDebit = "FD";
		String esmart = "YES";
		String fualtype = "JI";
		new BetterDealAction().betterDealUrl(userProfile, fualtype).loginUserDetails(userProfile)
				.betterDealHeading(userProfile).saveMoneyQuestion(userProfile)
				.saveMoneyAnswer(userProfile).fualType(userProfile, fualtype)
				.postCodeTitle(userProfile).currentTariff(userProfile)
				.currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebitSingle(userProfile, directDebit)
				.nector(userProfile, nectorRegistered)
				.esmartSingle(userProfile, esmart);
		// .logout();
	}

	@Test(groups = { BetterDeal, Smoke })
	public void jiRegisteredLogedin5() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Registered JI- DD,Non-ES,PrimaryUCRN,Nector Registered-No");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JIAccount");
		String nectorRegistered = "NO";
		String directDebit = "DD";
		String esmart = "NO";
		String fualtype = "JI";
		new BetterDealAction().loginUrl(userProfile).loginUserDetails(userProfile)
				.deepUrl(userProfile, fualtype).betterDealHeading(userProfile)
				.saveMoneyQuestion(userProfile).saveMoneyAnswer(userProfile)
				.fualType(userProfile, fualtype).postCodeTitle(userProfile)
				.currentTariff(userProfile).currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebitSingle(userProfile, directDebit)
				.nector(userProfile, nectorRegistered)
				.esmartSingle(userProfile, esmart);
		// .logout();
	}

	@Test(groups = { BetterDeal, Smoke })
	public void jiNotRegistered6() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Registered JI- MC,ES,PrimaryUCRN,Nector Registered-No");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JIAccount");
		String nectorRegistered = "NO";
		String directDebit = "MC";
		String esmart = "YES";
		String fualtype = "JI";
		new BetterDealAction()
				.betterDealUrl(userProfile, fualtype)
				.deepUrlRegistartion(userProfile)
				.loginUserDetails(userProfile)
				.betterDealHeading(userProfile)
				.saveMoneyQuestion(userProfile).saveMoneyAnswer(userProfile)
				.fualType(userProfile, fualtype).postCodeTitle(userProfile)
				.currentTariff(userProfile).currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebitSingle(userProfile, directDebit)
				.nector(userProfile, nectorRegistered)
				.esmartSingle(userProfile, esmart);
		// .logout();
	}

	@Test(groups = { BetterDeal, Smoke })
	public void jiRegistered7() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Registered JI- DD,Non-ES,PrimaryUCRN,Nector Registered-NO");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JIAccount");
		String nectorRegistered = "NO";
		String directDebit = "DD";
		String esmart = "NO";
		String fualtype = "JI";
		new BetterDealAction().betterDealUrl(userProfile, fualtype).loginUserDetails(userProfile)
				.betterDealHeading(userProfile).saveMoneyQuestion(userProfile)
				.saveMoneyAnswer(userProfile).fualType(userProfile, fualtype)
				.postCodeTitle(userProfile).currentTariff(userProfile)
				.currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebitSingle(userProfile, directDebit)
				.nector(userProfile, nectorRegistered)
				.esmartSingle(userProfile, esmart);
		// .logout();
	}

	@Test(groups = { BetterDeal, Smoke })
	public void jiNotRegistered8() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Not Registered JI- CC,Non-ES,PrimaryUCRN,Nector Registered-No");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JIAccount");
		String nectorRegistered = "NO";
		String directDebit = "CC";
		String esmart = "NO";
		String fualtype = "JI";
		new BetterDealAction()
				.betterDealUrl(userProfile, fualtype)
				.deepUrlRegistartion(userProfile)
				.loginUserDetails(userProfile)
				.betterDealHeading(userProfile)
				.saveMoneyQuestion(userProfile).saveMoneyAnswer(userProfile)
				.fualType(userProfile, fualtype).postCodeTitle(userProfile)
				.currentTariff(userProfile).currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebitSingle(userProfile, directDebit)
				.nector(userProfile, nectorRegistered)
				.esmartSingle(userProfile, esmart);
		// .logout();
	}

	/******************************************* Electricity JOURNEY ************************************************/
	@Test(groups = { BetterDeal, Smoke })
	public void electricityRegistered1() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Registered Electricity- DD,ES,PrimaryUCRN,Nector Registered-YES");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");
		String nectorRegistered = "YES";
		String directDebit = "DD";
		String esmart = "YES";
		String fualtype = "Ele";
		new BetterDealAction()
				.betterDealUrl(userProfile, fualtype)
				.loginUserDetails(userProfile)
				.betterDealHeading(userProfile).saveMoneyQuestion(userProfile)
				.saveMoneyAnswer(userProfile).fualType(userProfile, fualtype)
				.postCodeTitle(userProfile).currentTariff(userProfile)
				.currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebitSingle(userProfile, directDebit)
				.nector(userProfile, nectorRegistered)
				.esmartSingle(userProfile, esmart);
		// .logout();
	}

	@Test(groups = { BetterDeal, Smoke })
	public void electricityRegisteredLogedin2() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Registered Electricity- DD,ES,SecondaryUCRN,Nector Registered-YES");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");
		String nectorRegistered = "YES";
		String directDebit = "CC";
		String esmart = "YES";
		String fualtype = "Ele";
		new BetterDealAction().loginUrl(userProfile).loginUserDetails(userProfile)
				.deepUrl(userProfile, fualtype).betterDealHeading(userProfile)
				.saveMoneyQuestion(userProfile).saveMoneyAnswer(userProfile)
				.fualType(userProfile, fualtype).postCodeTitle(userProfile)
				.currentTariff(userProfile).currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebitSingle(userProfile, directDebit)
				.nector(userProfile, nectorRegistered)
				.esmartSingle(userProfile, esmart);
		// .logout();
	}

	@Test(groups = { BetterDeal, Smoke })
	public void electricityNotRegistered3() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Registered Electricity- VDD,Non-ES,PrimaryUCRN,Nector Registered-YES");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");
		String nectorRegistered = "YES";
		String directDebit = "VDD";
		String esmart = "NO";
		String fualtype = "Ele";
		new BetterDealAction()
				.betterDealUrl(userProfile, fualtype)
				.deepUrlRegistartion(userProfile)
				.loginUserDetails(userProfile)
				.betterDealHeading(userProfile)
				.saveMoneyQuestion(userProfile).saveMoneyAnswer(userProfile)
				.fualType(userProfile, fualtype).postCodeTitle(userProfile)
				.currentTariff(userProfile).currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebitSingle(userProfile, directDebit)
				.nector(userProfile, nectorRegistered)
				.esmartSingle(userProfile, esmart);
		// .logout();
	}

	@Test(groups = { BetterDeal, Smoke })
	public void electricityRegistered4() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Registered Electricity- FUAL Direct,Non-ES,SecondaryUCRN,Nector Registered-YES");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");
		String nectorRegistered = "YES";
		String directDebit = "FD";
		String esmart = "NO";
		String fualtype = "Ele";
		new BetterDealAction().betterDealUrl(userProfile, fualtype)
				.loginUserDetails(userProfile)
				.betterDealHeading(userProfile).saveMoneyQuestion(userProfile)
				.saveMoneyAnswer(userProfile).fualType(userProfile, fualtype)
				.postCodeTitle(userProfile).currentTariff(userProfile)
				.currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebitSingle(userProfile, directDebit)
				.nector(userProfile, nectorRegistered)
				.esmartSingle(userProfile, esmart);
		// .logout();
	}

	@Test(groups = { BetterDeal, Smoke })
	public void electricityRegisteredLogedin5() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Registered Electricity- DD,Non-ES,PrimaryUCRN,Nector Registered-No");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");
		String nectorRegistered = "NO";
		String directDebit = "DD";
		String esmart = "NO";
		String fualtype = "Ele";
		new BetterDealAction().loginUrl(userProfile).loginUserDetails(userProfile)
				.deepUrl(userProfile, fualtype).betterDealHeading(userProfile)
				.saveMoneyQuestion(userProfile).saveMoneyAnswer(userProfile)
				.fualType(userProfile, fualtype).postCodeTitle(userProfile)
				.currentTariff(userProfile).currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebitSingle(userProfile, directDebit)
				.nector(userProfile, nectorRegistered)
				.esmartSingle(userProfile, esmart);
		// .logout();
	}

	@Test(groups = { BetterDeal, Smoke })
	public void electricityNotRegistered6() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Registered Electricity- MC,ES,PrimaryUCRN,Nector Registered-No");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");
		String nectorRegistered = "NO";
		String directDebit = "MC";
		String esmart = "NO";
		String fualtype = "Ele";
		new BetterDealAction()
				.betterDealUrl(userProfile, fualtype)
				.deepUrlRegistartion(userProfile)
				.loginUserDetails(userProfile)
				.betterDealHeading(userProfile)
				.saveMoneyQuestion(userProfile).saveMoneyAnswer(userProfile)
				.fualType(userProfile, fualtype).postCodeTitle(userProfile)
				.currentTariff(userProfile).currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebitSingle(userProfile, directDebit)
				.nector(userProfile, nectorRegistered)
				.esmartSingle(userProfile, esmart);
		// .logout();
	}

	@Test(groups = { BetterDeal, Smoke })
	public void electricityRegistered7() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Registered Electricity- DD,Non-ES,PrimaryUCRN,Nector Registered-NO");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");
		String nectorRegistered = "NO";
		String directDebit = "DD";
		String esmart = "NO";
		String fualtype = "Ele";
		new BetterDealAction()
				.betterDealUrl(userProfile, fualtype).loginUserDetails(userProfile)
				.betterDealHeading(userProfile).saveMoneyQuestion(userProfile)
				.saveMoneyAnswer(userProfile).fualType(userProfile, fualtype)
				.postCodeTitle(userProfile).currentTariff(userProfile)
				.currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebitSingle(userProfile, directDebit)
				.nector(userProfile, nectorRegistered)
				.esmartSingle(userProfile, esmart);
		// .logout();
	}

	@Test(groups = { BetterDeal, Smoke })
	public void electricityNotRegistered8() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Registered Electricity- CC,Non-ES,PrimaryUCRN,Nector Registered-No");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");
		String nectorRegistered = "NO";
		String directDebit = "CC";
		String esmart = "NO";
		String fualtype = "Ele";
		new BetterDealAction()
				.betterDealUrl(userProfile, fualtype)
				.deepUrlRegistartion(userProfile)
				.loginUserDetails(userProfile)
				.betterDealHeading(userProfile)
				.saveMoneyQuestion(userProfile).saveMoneyAnswer(userProfile)
				.fualType(userProfile, fualtype).postCodeTitle(userProfile)
				.currentTariff(userProfile).currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebitSingle(userProfile, directDebit)
				.nector(userProfile, nectorRegistered)
				.esmartSingle(userProfile, esmart);
		// .logout();
	}

	/******************************************* Gas JOURNEY ********************************************************/

	@Test(groups = { BetterDeal, Smoke })
	public void gasRegistered1() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Registered Gas- DD,ES,PrimaryUCRN,Nector Registered-YES");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");
		String nectorRegistered = "YES";
		String directDebit = "DD";
		String esmart = "YES";
		String fualtype = "Gas";
		new BetterDealAction()
				.betterDealUrl(userProfile, fualtype)
				.loginUserDetails(userProfile)
				.betterDealHeading(userProfile).saveMoneyQuestion(userProfile)
				.saveMoneyAnswer(userProfile).fualType(userProfile, fualtype)
				.postCodeTitle(userProfile).currentTariff(userProfile)
				.currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebitSingle(userProfile, directDebit)
				.nector(userProfile, nectorRegistered)
				.esmartSingle(userProfile, esmart);
		// .logout();
	}

	@Test(groups = { BetterDeal, Smoke })
	public void gasRegisteredLogedin2() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Registered Gas- DD,ES,SecondaryUCRN,Nector Registered-YES");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");
		String nectorRegistered = "YES";
		String directDebit = "CC";
		String esmart = "YES";
		String fualtype = "Gas";
		new BetterDealAction().loginUrl(userProfile).loginUserDetails(userProfile)
				.deepUrl(userProfile, fualtype).betterDealHeading(userProfile)
				.saveMoneyQuestion(userProfile).saveMoneyAnswer(userProfile)
				.fualType(userProfile, fualtype).postCodeTitle(userProfile)
				.currentTariff(userProfile).currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebitSingle(userProfile, directDebit)
				.nector(userProfile, nectorRegistered)
				.esmartSingle(userProfile, esmart);
		// .logout();
	}

	@Test(groups = { BetterDeal, Smoke })
	public void gasNotRegistered3() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Registered Gas- VDD,Non-ES,PrimaryUCRN,Nector Registered-YES");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");
		String nectorRegistered = "YES";
		String directDebit = "VDD";
		String esmart = "NO";
		String fualtype = "Gas";
		new BetterDealAction()
				.betterDealUrl(userProfile, fualtype)
				.deepUrlRegistartion(userProfile)
				.loginUserDetails(userProfile)
				.betterDealHeading(userProfile)
				.saveMoneyQuestion(userProfile).saveMoneyAnswer(userProfile)
				.fualType(userProfile, fualtype).postCodeTitle(userProfile)
				.currentTariff(userProfile).currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebitSingle(userProfile, directDebit)
				.nector(userProfile, nectorRegistered)
				.esmartSingle(userProfile, esmart);
		// .logout();
	}

	@Test(groups = { BetterDeal, Smoke })
	public void gasRegistered4() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Registered Gas- SO,Non-ES,SecondaryUCRN,Nector Registered-YES");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");
		String nectorRegistered = "YES";
		String directDebit = "FD";
		String esmart = "NO";
		String fualtype = "Gas";
		new BetterDealAction()
				.betterDealUrl(userProfile, fualtype)
				.loginUserDetails(userProfile)
				.betterDealHeading(userProfile).saveMoneyQuestion(userProfile)
				.saveMoneyAnswer(userProfile).fualType(userProfile, fualtype)
				.postCodeTitle(userProfile).currentTariff(userProfile)
				.currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebitSingle(userProfile, directDebit)
				.nector(userProfile, nectorRegistered)
				.esmartSingle(userProfile, esmart);
		// .logout();
	}

	@Test(groups = { BetterDeal, Smoke })
	public void gasRegisteredLogedin5() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Registered Gas- DD,Non-ES,PrimaryUCRN,Nector Registered-No");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");
		String nectorRegistered = "NO";
		String directDebit = "DD";
		String esmart = "NO";
		String fualtype = "Gas";
		new BetterDealAction().loginUrl(userProfile).loginUserDetails(userProfile)
				.deepUrl(userProfile, fualtype).betterDealHeading(userProfile)
				.saveMoneyQuestion(userProfile).saveMoneyAnswer(userProfile)
				.fualType(userProfile, fualtype).postCodeTitle(userProfile)
				.currentTariff(userProfile).currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebitSingle(userProfile, directDebit)
				.nector(userProfile, nectorRegistered)
				.esmartSingle(userProfile, esmart);
		// .logout();
	}

	@Test(groups = { BetterDeal, Smoke })
	public void gasNotRegistered6() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Registered Gas- MC,ES,PrimaryUCRN,Nector Registered-No");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");
		String nectorRegistered = "NO";
		String directDebit = "MC";
		String esmart = "YES";
		String fualtype = "Gas";
		new BetterDealAction()
				.betterDealUrl(userProfile, fualtype)
				.deepUrlRegistartion(userProfile)
				.loginUserDetails(userProfile)
				.betterDealHeading(userProfile)
				.saveMoneyQuestion(userProfile).saveMoneyAnswer(userProfile)
				.fualType(userProfile, fualtype).postCodeTitle(userProfile)
				.currentTariff(userProfile).currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebitSingle(userProfile, directDebit)
				.nector(userProfile, nectorRegistered)
				.esmartSingle(userProfile, esmart);
		// .logout();
	}

	@Test(groups = { BetterDeal, Smoke })
	public void gasRegistered7() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Registered Gas- DD,Non-ES,PrimaryUCRN,Nector Registered-NO");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");
		String nectorRegistered = "NO";
		String directDebit = "DD";
		String esmart = "NO";
		String fualtype = "Gas";
		new BetterDealAction()
				.betterDealUrl(userProfile, fualtype)
				.loginUserDetails(userProfile)
				.betterDealHeading(userProfile).saveMoneyQuestion(userProfile)
				.saveMoneyAnswer(userProfile).fualType(userProfile, fualtype)
				.postCodeTitle(userProfile).currentTariff(userProfile)
				.currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebitSingle(userProfile, directDebit)
				.nector(userProfile, nectorRegistered)
				.esmartSingle(userProfile, esmart);
		// .logout();
	}

	@Test(groups = { BetterDeal, Smoke })
	public void gasNotRegistered8() {
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal Page Not Registered Gas- CC,Non-ES,PrimaryUCRN,Nector Registered-No");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");
		String nectorRegistered = "NO";
		String directDebit = "CC";
		String esmart = "NO";
		String fualtype = "Gas";
		new BetterDealAction()
				.betterDealUrl(userProfile, fualtype)
				.deepUrlRegistartion(userProfile)
				.loginUserDetails(userProfile)
				.betterDealHeading(userProfile)
				.saveMoneyQuestion(userProfile).saveMoneyAnswer(userProfile)
				.fualType(userProfile, fualtype).postCodeTitle(userProfile)
				.currentTariff(userProfile).currentSpendTitle(userProfile)
				.currentSpendTimeSpan(userProfile)
				.tariffTableTextValidation(userProfile, fualtype)
				.tariffCount(userProfile).twoDecimalCurrentSpend(userProfile)
				.tariffCalculation(userProfile).betterBanner(userProfile)
				.findOutMore(userProfile).whatisthis(userProfile)
				.switchNow(userProfile)
				.directDebitSingle(userProfile, directDebit)
				.nector(userProfile, nectorRegistered)
				.esmartSingle(userProfile, esmart);
		// .logout();
	}

	/******************************************* Error Validation ***************************************************/

	@Test(groups = { BetterDeal, Smoke })
	public void dualRegisteredError1() {
		String fualtype = "Dual";
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal error message Registered- Dual-PP&ELE-NonPP,Meter type-Gas-PP&Ele-Credit,PrimaryUCRN");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");
		new BetterDealAction().betterDealUrl(userProfile, fualtype).loginUserDetails(userProfile).loginErrorMessage(
				userProfile);
	}
		
	@Test(groups = { BetterDeal, Smoke })
	public void dualRegisteredLoggedError2() {
		String fualtype = "Dual";
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal error message RegisteredLogged- GAS-NonPP&ELE-PP,Meter type-Gas-Credit&Ele-PP,SecondaryUCRN");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");
		new BetterDealAction().betterDealUrl(userProfile, fualtype).loginUserDetails(userProfile)
		.deepUrl(userProfile, fualtype).errorMessage(userProfile);
	}
	
	@Test(groups = { BetterDeal, Smoke })
	public void eleRegisteredError4() {
		String fualtype = "Ele";
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal error message Registered-Electricity- Payment-PP,Meter type-PP,PrimaryUCRN");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");
		new BetterDealAction().betterDealUrl(userProfile, fualtype).loginUserDetails(userProfile).errorMessage(
				userProfile);
	}
	
	@Test(groups = { BetterDeal, Smoke })
	public void dualRegisteredError5() {
		String fualtype = "Dual";
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal error message Registered- Dual&ELE-NonPP,Meter type-Gas-Complex&Ele-E7,PrimaryUCRN");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");
		new BetterDealAction().betterDealUrl(userProfile, fualtype).loginUserDetails(userProfile).loginErrorMessage(
				userProfile);
	}
	
	@Test(groups = { BetterDeal, Smoke })
	public void dualRegisteredLoggedError6() {
		String fualtype = "Dual";
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal error message RegisteredLogged-DUAL- GAS&ELE-NonPP,Meter type-Gas-Credit&Ele-Complex,SecondaryUCRN");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");
		new BetterDealAction().betterDealUrl(userProfile, fualtype).loginUserDetails(userProfile)
		.deepUrl(userProfile, fualtype).errorMessage(userProfile);
	}
	
	@Test(groups = { BetterDeal, Smoke })
	public void eleRegisteredError7() {
		String fualtype = "Dual";
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal error message Registered-Electricity- Payment-NonPP,Meter type-Complex,PrimaryUCRN");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");
		new BetterDealAction().betterDealUrl(userProfile, fualtype).loginUserDetails(userProfile).errorMessage(
				userProfile);
	}
	
	@Test(groups = { BetterDeal, Smoke })
	public void gasNotRegisteredError8() {
		String fualtype = "Gas";
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal error message Not Registered-PrimaryUCRN, Complex, Non-pre payment");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");
		new BetterDealAction().betterDealUrl(userProfile, fualtype).deepUrlRegistartionErrorMessage(
				userProfile);
	}
	
	@Test(groups = { BetterDeal, Smoke })
	public void dualRegisteredError9() {
		String fualtype = "Dual";
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal error message Registered-DUAL- GAS&ELE-NonPP,Meter type-GasEle-Credit,SecondaryUCRN");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");
		new BetterDealAction().betterDealUrl(userProfile, fualtype).loginUserDetails(userProfile).loginErrorMessage(
				userProfile);
	}
	
	@Test(groups = { BetterDeal, Smoke })
	public void dualRegisteredLoggedError10() {
		String fualtype = "Dual";
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal error message RegisteredLogged- GAS&ELE-NonPP,Meter type-Gas&Ele-Credit,SecondaryUCRN");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");
		new BetterDealAction().betterDealUrl(userProfile, fualtype).loginUserDetails(userProfile)
		.deepUrl(userProfile, fualtype).errorMessage(userProfile);
	}
	
	@Test(groups = { BetterDeal, Smoke })
	public void jiRegisteredError12() {
		String fualtype = "JI";
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal error message Registered- JI-NonPP,Meter type-Credit,PrimaryUCRN-Closed less than 6 month");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JIAccount");
		new BetterDealAction().betterDealUrl(userProfile, fualtype).loginUserDetails(userProfile).loginErrorMessage(
				userProfile);
	}
	
	@Test(groups = { BetterDeal, Smoke })
	public void eleNotRegisteredError17() {
		String fualtype = "Ele";
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal error message Not Registered-PrimaryUCRN, Payment, Non-pre payment, Smart");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");
		new BetterDealAction()
		.betterDealUrl(userProfile, fualtype)
		.deepUrlRegistartion(userProfile)
		.loginUserDetails(userProfile)
		.errorMessage(userProfile);
	}

	@Test(groups = { BetterDeal, Smoke })
	public void dualRegisteredError18() {
		String fualtype = "Dual";
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal error message Registered-DUAL- GASELE-NonPP,Meter type-Gas&Ele-Credit,SecondaryUCRN");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");
		new BetterDealAction()//.loginUserDetails(userProfile)
		.betterDealUrl(userProfile, fualtype)
		.errorMessage(userProfile);
	}
	
	@Test(groups = { BetterDeal, Smoke })
	public void dualRegisteredError20() {
		String fualtype = "Dual";
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal error message Registered-DUAL- GASELE-NonPP,Meter type-Gas&Ele-Credit,PrimaryUCRN-4 digit match both ele and gas");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");
		new BetterDealAction().betterDealUrl(userProfile, fualtype).loginUserDetails(userProfile).errorMessage(
				userProfile);
	}
	
	@Test(groups = { BetterDeal, Smoke })
	public void dualRegisteredError21() {
		String fualtype = "Dual";
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal error message Registered-DUAL- GASELE-NonPP,Meter type-Gas&Ele-Credit,PrimaryUCRN-lessthan 4 digit");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");
		new BetterDealAction().betterDealUrl(userProfile, fualtype)
		.errorMessage(userProfile);
	}
	
	@Test(groups = { BetterDeal, Smoke })
	public void jiRegisteredError24() {
		String fualtype = "JI";
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal error message Registered- JI-NonPP,Meter type-Credit,PrimaryUCRN-Less Than 4 digit");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JIAccount");
		new BetterDealAction().betterDealUrl(userProfile, fualtype).errorMessage(
				userProfile);
	}
	
	
	@Test(groups = { BetterDeal, Smoke })
	public void dualRegisteredError28() {
		String fualtype = "Dual";
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal error message Registered-DUAL- GAS&ELE-NonPP,Meter type-Gas&Ele-Credit,PrimaryUCRN");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");
		new BetterDealAction().betterDealUrl(userProfile, fualtype).loginUserDetails(userProfile).errorMessage(
				userProfile);
	}
	
	
	@Test(groups = { BetterDeal, Smoke })
	public void dualRegisteredError29() {
		String fualtype = "Dual";
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal error message Registered- GAS-NonPP&ELE-PP,Meter type-Gas-Credit&Ele-PP,PrimaryUCRN");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");
		new BetterDealAction().betterDealUrl(userProfile, fualtype).loginUserDetails(userProfile).errorMessage(
				userProfile);
	}
	
	
	
	@Test(groups = { BetterDeal, Smoke })
	public void gasRegisteredError30() {
		String fualtype = "Gas";
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal error message Registered- DUAL-nonPP,Meter typeCredit,PrimaryUCRN-SAP Down");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");
		new BetterDealAction().betterDealUrl(userProfile, fualtype).loginUserDetails(userProfile).errorMessage(
				userProfile);
	}
	
	
	@Test(groups = { BetterDeal, Smoke })
	public void gasRegisteredError32() {
		String fualtype = "Gas";
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal error message Registered- GAS-nonPP,Meter typeCredit,PrimaryUCRN");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");
		new BetterDealAction().betterDealUrl(userProfile, fualtype).loginUserDetails(userProfile).errorMessage(
				userProfile);
	}
	
	@Test(groups = { BetterDeal, Smoke })
	public void dualRegisteredError33() {
		String fualtype = "Dual";
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal error message Registered- DUAL-nonPP,Meter typeCredit,PrimaryUCRN-GAD Fails");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");
		new BetterDealAction().betterDealUrl(userProfile, fualtype).loginUserDetails(userProfile).errorMessage(
				userProfile);
	}
	
	
	@Test(groups = { BetterDeal, Smoke })
	public void eleRegisteredError35() {
		String fualtype = "Ele";
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal error message Registered- Electricity-nonPP,Meter typeCredit,PrimaryUCRN");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");
		new BetterDealAction().betterDealUrl(userProfile, fualtype).loginUserDetails(userProfile).errorMessage(
				userProfile);
	}
		
	
	@Test(groups = { BetterDeal, Smoke })
	public void dualRegisteredLoggedError36() {
		String fualtype = "Dual";
		Report.createTestLogHeader(
				"BetterDeal Journey",
				"Validating BetterDeal error message RegisteredLogged- PrimaryUCRN, Non prepayment, Credit");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");
		new BetterDealAction().betterDealUrl(userProfile, fualtype).loginUserDetails(userProfile)
		.deepUrl(userProfile, fualtype).errorMessage(userProfile);
	}
	
	// *********************************** RMR Changes ************************************* //
	@Test(groups = { BetterDeal, Smoke })
	public void verifyTCRForGasAccount(){
		String fuelType = "Gas";
		String payment = "QCC";
		Report.createTestLogHeader("Better Deal Journey", "Gas account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
		.navigateToAccountSummaryPage(userProfile);
		new BetterDealAction()
		.navigateToTariffCheckPage()
		.verifyTCRValue(fuelType, payment, userProfile);
		
	}

	
}
