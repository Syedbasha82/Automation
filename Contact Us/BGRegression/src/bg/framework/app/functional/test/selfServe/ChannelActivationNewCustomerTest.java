package bg.framework.app.functional.test.selfServe;

import static bg.framework.app.functional.entities.FunctionalCategory.Smoke;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.reFactoring.EshopAction;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.EshopTariffProfile;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class ChannelActivationNewCustomerTest extends TestBase {

	private int TariffIncrement;
	private int FuelIncrement;

	/* No data setup required. */

	@Test(groups = { Smoke })
	public void CA_Fun_001_ComboRegisterInterest_and_SmartMeterLandingPage_YesOption() {
		Report.createTestLogHeader("CA_Fun_001",
				"ComboRegisterInterest_and_SmartMeterLandingPage_YesOption");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectYesOption()
				.verifyComboRegisterInterestSMlandingPageYesOption();
	}

	/* No data setup required. */

	@Test(groups = { Smoke })
	public void CA_Fun_002_ComboRegisterInterest_and_SmartMeterLandingPage_NoOption() {
		Report.createTestLogHeader("CA_Fun_002",
				"ComboRegisterInterest_and_SmartMeterLandingPage_NoOption");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption();
	}

	/*
	 * data setup required for test case 003 to 64 Enter below data in
	 * userProfile.xml file
	 * 
	 * 1. Email id 2. Password 3. FirstName 4. LastName 5. title 6. mobileNumber
	 * 7. accNumber 8. address 9. postalCode 10. answer1 11. answer2 12. answer3
	 * 13. answer4 14. answer5 15. dayOfBirth 16. monthOfBirth 17. yearOfBirth
	 * 18. elecSpendDuration 19. gasSpendDuration 20. sortCode1 21. sortCode2
	 * 22. sortCode3 23. annualElecSpendAmount 24. annualGasSpendAmount 25.
	 * monthAtAddress 26. yearAtAddress 27. currentEnergySupplier 28.
	 * currentEnergyPaymentMethod 29. currentEnergyTafiff
	 */
	@Test(groups = { Smoke })
	public void CA_Fun_003_ScreeningQuestion_AltFlow01() {
		Report.createTestLogHeader("CA_Fun_003",
				"ComboRegisterInterest_and_SmartMeterLandingPage_NoOption");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_003");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption()
				.fillDetailsForRegisterInterest(userProfile)
				.answerScreeningQuestions(userProfile)
				.checkPropertySuitability()
				.verifyRegisterYourInterestLinkAtSMLpage();
	}

	@Test(groups = { Smoke })
	public void CA_Fun_004_ScreeningQuestion_AltFlow02() {
		Report.createTestLogHeader("CA_Fun_004",
				"ComboRegisterInterest_and_SmartMeterLandingPage_NoOption");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_004");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption()
				.fillDetailsForRegisterInterest(userProfile)
				.answerScreeningQuestions(userProfile)
				.checkPropertySuitability()
				.verifyRegisterYourInterestLinkAtSMLpage();
	}

	@Test(groups = { Smoke })
	public void CA_Fun_005_ScreeningQuestion_AltFlow03() {
		Report.createTestLogHeader("CA_Fun_005",
				"ComboRegisterInterest_and_SmartMeterLandingPage_NoOption");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_005");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption()
				.fillDetailsForRegisterInterest(userProfile)
				.answerScreeningQuestions(userProfile)
				.checkPropertySuitability()
				.verifyRegisterYourInterestLinkAtSMLpage();
	}

	@Test(groups = { Smoke })
	public void CA_Fun_006_ScreeningQuestion_AltFlow04() {
		Report.createTestLogHeader("CA_Fun_006",
				"ComboRegisterInterest_and_SmartMeterLandingPage_NoOption");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_006");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption()
				.fillDetailsForRegisterInterest(userProfile)
				.answerScreeningQuestions(userProfile)
				.checkPropertySuitability()
				.verifyRegisterYourInterestLinkAtSMLpage();
	}

	@Test(groups = { Smoke })
	public void CA_Fun_007_ScreeningQuestion_AltFlow05() {
		Report.createTestLogHeader("CA_Fun_007",
				"ComboRegisterInterest_and_SmartMeterLandingPage_NoOption");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_007");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption()
				.fillDetailsForRegisterInterest(userProfile)
				.answerScreeningQuestions(userProfile)
				.checkPropertySuitability()
				.verifyRegisterYourInterestLinkAtSMLpage();
	}

	@Test(groups = { Smoke })
	public void CA_Fun_008_ScreeningQuestion_AltFlow06() {
		Report.createTestLogHeader("CA_Fun_008",
				"ComboRegisterInterest_and_SmartMeterLandingPage_NoOption");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_008");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption()
				.fillDetailsForRegisterInterest(userProfile)
				.answerScreeningQuestions(userProfile)
				.checkPropertySuitability()
				.verifyRegisterYourInterestLinkAtSMLpage();
	}

	@Test(groups = { Smoke })
	public void CA_Fun_009_ScreeningQuestion_AltFlow07() {
		Report.createTestLogHeader("CA_Fun_009",
				"ComboRegisterInterest_and_SmartMeterLandingPage_NoOption");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_009");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption()
				.fillDetailsForRegisterInterest(userProfile)
				.answerScreeningQuestions(userProfile)
				.checkPropertySuitability()
				.verifyRegisterYourInterestLinkAtSMLpage();
	}

	@Test(groups = { Smoke })
	public void CA_Fun_010_ScreeningQuestion_AltFlow08() {
		Report.createTestLogHeader("CA_Fun_010",
				"ComboRegisterInterest_and_SmartMeterLandingPage_NoOption");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_010");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption()
				.fillDetailsForRegisterInterest(userProfile)
				.answerScreeningQuestions(userProfile)
				.checkPropertySuitability()
				.verifyRegisterYourInterestLinkAtSMLpage();
	}

	@Test(groups = { Smoke })
	public void CA_Fun_011_ScreeningQuestion_AltFlow09() {
		Report.createTestLogHeader("CA_Fun_011",
				"ComboRegisterInterest_and_SmartMeterLandingPage_NoOption");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_011");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption()
				.fillDetailsForRegisterInterest(userProfile)
				.answerScreeningQuestions(userProfile)
				.checkPropertySuitability()
				.verifyRegisterYourInterestLinkAtSMLpage();
	}

	@Test(groups = { Smoke })
	public void CA_Fun_012_ScreeningQuestion_AltFlow10() {
		Report.createTestLogHeader("CA_Fun_012",
				"ComboRegisterInterest_and_SmartMeterLandingPage_NoOption");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_012");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption()
				.fillDetailsForRegisterInterest(userProfile)
				.answerScreeningQuestions(userProfile)
				.checkPropertySuitability()
				.verifyRegisterYourInterestLinkAtSMLpage();
	}

	@Test(groups = { Smoke })
	public void CA_Fun_013_ScreeningQuestion_AltFlow11() {
		Report.createTestLogHeader("CA_Fun_013",
				"ComboRegisterInterest_and_SmartMeterLandingPage_NoOption");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_013");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption()
				.fillDetailsForRegisterInterest(userProfile)
				.answerScreeningQuestions(userProfile)
				.checkPropertySuitability()
				.verifyRegisterYourInterestLinkAtSMLpage();
	}

	@Test(groups = { Smoke })
	public void CA_Fun_014_ScreeningQuestion_AltFlow12() {
		Report.createTestLogHeader("CA_Fun_014",
				"ComboRegisterInterest_and_SmartMeterLandingPage_NoOption");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_014");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption()
				.fillDetailsForRegisterInterest(userProfile)
				.answerScreeningQuestions(userProfile)
				.checkPropertySuitability()
				.verifyRegisterYourInterestLinkAtSMLpage();
	}

	@Test(groups = { Smoke })
	public void CA_Fun_015_ScreeningQuestion_AltFlow13() {
		Report.createTestLogHeader("CA_Fun_015",
				"ComboRegisterInterest_and_SmartMeterLandingPage_NoOption");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_015");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption()
				.fillDetailsForRegisterInterest(userProfile)
				.answerScreeningQuestions(userProfile)
				.checkPropertySuitability()
				.verifyRegisterYourInterestLinkAtSMLpage();
	}

	@Test(groups = { Smoke })
	public void CA_Fun_016_ScreeningQuestion_AltFlow14() {
		Report.createTestLogHeader("CA_Fun_016",
				"ComboRegisterInterest_and_SmartMeterLandingPage_NoOption");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_016");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption()
				.fillDetailsForRegisterInterest(userProfile)
				.answerScreeningQuestions(userProfile)
				.checkPropertySuitability()
				.verifyRegisterYourInterestLinkAtSMLpage();
	}

	@Test(groups = { Smoke })
	public void CA_Fun_017_ScreeningQuestion_AltFlow15() {
		Report.createTestLogHeader("CA_Fun_017",
				"ComboRegisterInterest_and_SmartMeterLandingPage_NoOption");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_017");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption()
				.fillDetailsForRegisterInterest(userProfile)
				.answerScreeningQuestions(userProfile)
				.checkPropertySuitability()
				.verifyRegisterYourInterestLinkAtSMLpage();
	}

	@Test(groups = { Smoke })
	public void CA_Fun_018_ScreeningQuestion_AltFlow16() {
		Report.createTestLogHeader("CA_Fun_018",
				"ComboRegisterInterest_and_SmartMeterLandingPage_NoOption");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_018");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption()
				.fillDetailsForRegisterInterest(userProfile)
				.answerScreeningQuestions(userProfile)
				.checkPropertySuitability()
				.verifyRegisterYourInterestLinkAtSMLpage();
	}

	@Test(groups = { Smoke })
	public void CA_Fun_019_ScreeningQuestion_AltFlow17() {
		Report.createTestLogHeader("CA_Fun_019",
				"ComboRegisterInterest_and_SmartMeterLandingPage_NoOption");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_019");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption()
				.fillDetailsForRegisterInterest(userProfile)
				.answerScreeningQuestions(userProfile)
				.checkPropertySuitability()
				.verifyRegisterYourInterestLinkAtSMLpage();
	}

	@Test(groups = { Smoke })
	public void CA_Fun_020_ScreeningQuestion_AltFlow18() {
		Report.createTestLogHeader("CA_Fun_020",
				"ComboRegisterInterest_and_SmartMeterLandingPage_NoOption");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_020");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption()
				.fillDetailsForRegisterInterest(userProfile)
				.answerScreeningQuestions(userProfile)
				.checkPropertySuitability()
				.verifyRegisterYourInterestLinkAtSMLpage();
	}

	@Test(groups = { Smoke })
	public void CA_Fun_021_ScreeningQuestion_AltFlow19() {
		Report.createTestLogHeader("CA_Fun_021",
				"ComboRegisterInterest_and_SmartMeterLandingPage_NoOption");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_021");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption()
				.fillDetailsForRegisterInterest(userProfile)
				.answerScreeningQuestions(userProfile)
				.checkPropertySuitability()
				.verifyRegisterYourInterestLinkAtSMLpage();
	}

	@Test(groups = { Smoke })
	public void CA_Fun_022_ScreeningQuestion_AltFlow20() {
		Report.createTestLogHeader("CA_Fun_022",
				"ComboRegisterInterest_and_SmartMeterLandingPage_NoOption");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_022");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption()
				.fillDetailsForRegisterInterest(userProfile)
				.answerScreeningQuestions(userProfile)
				.checkPropertySuitability()
				.verifyRegisterYourInterestLinkAtSMLpage();
	}

	@Test(groups = { Smoke })
	public void CA_Fun_023_ScreeningQuestion_AltFlow21() {
		Report.createTestLogHeader("CA_Fun_023",
				"ComboRegisterInterest_and_SmartMeterLandingPage_NoOption");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_023");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption()
				.fillDetailsForRegisterInterest(userProfile)
				.answerScreeningQuestions(userProfile)
				.checkPropertySuitability()
				.verifyRegisterYourInterestLinkAtSMLpage();
	}

	@Test(groups = { Smoke })
	public void CA_Fun_024_ScreeningQuestion_AltFlow22() {
		Report.createTestLogHeader("CA_Fun_024",
				"ComboRegisterInterest_and_SmartMeterLandingPage_NoOption");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_024");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption()
				.fillDetailsForRegisterInterest(userProfile)
				.answerScreeningQuestions(userProfile)
				.checkPropertySuitability()
				.verifyRegisterYourInterestLinkAtSMLpage();
	}

	@Test(groups = { Smoke })
	public void CA_Fun_025_ScreeningQuestion_AltFlow23() {
		Report.createTestLogHeader("CA_Fun_025",
				"ComboRegisterInterest_and_SmartMeterLandingPage_NoOption");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_025");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption()
				.fillDetailsForRegisterInterest(userProfile)
				.answerScreeningQuestions(userProfile)
				.checkPropertySuitability()
				.verifyRegisterYourInterestLinkAtSMLpage();
	}

	@Test(groups = { Smoke })
	public void CA_Fun_026_ScreeningQuestion_AltFlow24() {
		Report.createTestLogHeader("CA_Fun_026",
				"ComboRegisterInterest_and_SmartMeterLandingPage_NoOption");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_026");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption()
				.fillDetailsForRegisterInterest(userProfile)
				.answerScreeningQuestions(userProfile)
				.checkPropertySuitability()
				.verifyRegisterYourInterestLinkAtSMLpage();
	}

	@Test(groups = { Smoke })
	public void CA_Fun_027_ScreeningQuestion_AltFlow25() {
		Report.createTestLogHeader("CA_Fun_027",
				"ComboRegisterInterest_and_SmartMeterLandingPage_NoOption");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_027");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption()
				.fillDetailsForRegisterInterest(userProfile)
				.answerScreeningQuestions(userProfile)
				.checkPropertySuitability()
				.verifyRegisterYourInterestLinkAtSMLpage();
	}

	@Test(groups = { Smoke })
	public void CA_Fun_028_ScreeningQuestion_AltFlow26() {
		Report.createTestLogHeader("CA_Fun_028",
				"ComboRegisterInterest_and_SmartMeterLandingPage_NoOption");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_028");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption()
				.fillDetailsForRegisterInterest(userProfile)
				.answerScreeningQuestions(userProfile)
				.checkPropertySuitability()
				.verifyRegisterYourInterestLinkAtSMLpage();
	}

	@Test(groups = { Smoke })
	public void CA_Fun_029_ScreeningQuestion_AltFlow27() {
		Report.createTestLogHeader("CA_Fun_029",
				"ComboRegisterInterest_and_SmartMeterLandingPage_NoOption");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_029");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption()
				.fillDetailsForRegisterInterest(userProfile)
				.answerScreeningQuestions(userProfile)
				.checkPropertySuitability()
				.verifyRegisterYourInterestLinkAtSMLpage();
	}

	@Test(groups = { Smoke })
	public void CA_Fun_030_ScreeningQuestion_AltFlow28() {
		Report.createTestLogHeader("CA_Fun_030",
				"ComboRegisterInterest_and_SmartMeterLandingPage_NoOption");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_030");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption()
				.fillDetailsForRegisterInterest(userProfile)
				.answerScreeningQuestions(userProfile)
				.checkPropertySuitability()
				.verifyRegisterYourInterestLinkAtSMLpage();
	}

	@Test(groups = { Smoke })
	public void CA_Fun_031_ScreeningQuestion_AltFlow29() {
		Report.createTestLogHeader("CA_Fun_031",
				"ComboRegisterInterest_and_SmartMeterLandingPage_NoOption");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_031");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption()
				.fillDetailsForRegisterInterest(userProfile)
				.answerScreeningQuestions(userProfile)
				.checkPropertySuitability()
				.verifyRegisterYourInterestLinkAtSMLpage();
	}

	@Test(groups = { Smoke })
	public void CA_Fun_032_ScreeningQuestion_AltFlow30() {
		Report.createTestLogHeader("CA_Fun_032",
				"ComboRegisterInterest_and_SmartMeterLandingPage_NoOption");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_032");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption()
				.fillDetailsForRegisterInterest(userProfile)
				.answerScreeningQuestions(userProfile)
				.checkPropertySuitability()
				.verifyRegisterYourInterestLinkAtSMLpage();
	}

	@Test(groups = { Smoke })
	public void CA_Fun_033_ScreeningQuestion_AltFlow31() {
		Report.createTestLogHeader("CA_Fun_033",
				"ComboRegisterInterest_and_SmartMeterLandingPage_NoOption");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_033");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption()
				.fillDetailsForRegisterInterest(userProfile)
				.answerScreeningQuestions(userProfile)
				.checkPropertySuitability()
				.verifyRegisterYourInterestLinkAtSMLpage();
	}

	@Test(groups = { Smoke })
	public void CA_Fun_034_ScreeningQuestion_MainFlow() {
		Report.createTestLogHeader("CA_Fun_034",
				"ComboRegisterInterest_and_SmartMeterLandingPage_NoOption");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_034");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption()
				.fillDetailsForRegisterInterest(userProfile)
				.answerScreeningQuestions(userProfile)
				.checkPropertySuitability().verifyGetAQuotePage();
	}

	/* get a quote test cases */

	@Test(groups = { Smoke })
	public void CA_Fun_035_getAQuoteSameTariff() {
		Report.createTestLogHeader("CA_Fun_034",
				"ComboRegisterInterest_and_SmartMeterLandingPage_NoOption");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_034");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption()
				.fillDetailsForRegisterInterest(userProfile)
				.answerScreeningQuestions(userProfile)
				.checkPropertySuitability().verifyGetAQuotePage()
				.getAQuote(userProfile).verifyGetAQuoteLeadCreation()
				.verifyQuoteLeadStatusBefore().runQuoteBatch()
				.verifyQuoteLeadStatusAfter();
	}

	@Test(groups = { Smoke })
	public void CA_Fun_036_getAQuoteDifferentTariff() {
		Report.createTestLogHeader("CA_Fun_034",
				"ComboRegisterInterest_and_SmartMeterLandingPage_NoOption");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_034");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption()
				.fillDetailsForRegisterInterest(userProfile)
				.answerScreeningQuestions(userProfile)
				.checkPropertySuitability().verifyGetAQuotePage()
				.getAQuote(userProfile).verifyGetAQuoteLeadCreation()
				.verifyQuoteLeadStatusBefore().runQuoteBatch()
				.verifyQuoteLeadStatusAfter();
	}

	/* energy shop test cases */

	/*
	 * Add below fields to the Userprofile.xml file
	 * 
	 * 1. Email id 2. Password 3. FirstName 4. LastName 5. title 6. mobileNumber
	 * 7. accNumber 8. address 9. postalCode 10. answer1 11. answer2 12. answer3
	 * 13. answer4 14. answer5 15. dayOfBirth 16. monthOfBirth 17. yearOfBirth
	 * 18. elecSpendDuration 19. gasSpendDuration 20. sortCode1 21. sortCode2
	 * 22. sortCode3 23. annualElecSpendAmount 24. annualGasSpendAmount 25.
	 * monthAtAddress 26. yearAtAddress 27. currentEnergySupplier 28.
	 * currentEnergyPaymentMethod 29. currentEnergyTafiff
	 */

	@Test(groups = { Smoke })
	public void CA_Fun_037_EnergyShop_01() {
		Report.createTestLogHeader("CA_Fun_037", "EnergyShop01");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_034");

		/*
		 * 
		 * RMR changes to run same test case for each tarrif type
		 */
		TariffIncrement = 1;
		while (TariffIncrement <= 4) {
			userProfile.setEmail(TariffIncrement + userProfile.getEmail());
			new HomePageAction().navigateToSMLandingPage()
					.navigateTocomboRegisterInterestSMlandingPage()
					.selectNoOption()
					.verifyComboRegisterInterestSMlandingPageNoOption()
					.fillDetailsForRegisterInterest(userProfile)
					.answerScreeningQuestions(userProfile)
					.checkPropertySuitability().verifyGetAQuotePage()
					.getAQuote(userProfile).verifyYourResultsPage()
					.switchToTarrifs(TariffIncrement)
					.continueToPersonalDetailsPage()
					.continueToMeterDetailsPage(userProfile)
					.continueToPaymentOptionsPage()
					.continueToReviewOrderPage(userProfile)
					.verifyAndConfirmOrder().verifyLeadCreation()
					.verifyLeadType().verifyLeadStatusBefore().runAcqBatch()
					.verifyLeadStatusAfter().verifyLogin(userProfile).logout();

			++TariffIncrement;
		}
		TariffIncrement = 1;
	}

	@Test(groups = { Smoke })
	public void CA_Fun_038_EnergyShop_02() {
		Report.createTestLogHeader("CA_Fun_038", "EnergyShop02");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_034");
		TariffIncrement = 1;
		while (TariffIncrement <= 4) {
			userProfile.setEmail(TariffIncrement + userProfile.getEmail());

			new HomePageAction().navigateToSMLandingPage()
					.navigateTocomboRegisterInterestSMlandingPage()
					.selectNoOption()
					.verifyComboRegisterInterestSMlandingPageNoOption()
					.fillDetailsForRegisterInterest(userProfile)
					.answerScreeningQuestions(userProfile)
					.checkPropertySuitability().verifyGetAQuotePage()
					.getAQuote(userProfile).verifyYourResultsPage()
					.switchToTarrifs(1).continueToPersonalDetailsPage()
					.continueToMeterDetailsPage(userProfile)
					.continueToPaymentOptionsPage()
					.continueToReviewOrderPage(userProfile)
					.verifyAndConfirmOrder().verifyLeadCreation()
					.verifyLeadType().verifyLeadStatusBefore().runAcqBatch()
					.verifyLeadStatusAfter().verifyLogin(userProfile).logout();

			++TariffIncrement;
		}
		TariffIncrement = 1;
	}

	@Test(groups = { Smoke })
	public void CA_Fun_039_EnergyShop_03() {
		Report.createTestLogHeader("CA_Fun_039", "EnergyShop03");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_034");

		TariffIncrement = 1;
		while (TariffIncrement <= 4) {
			userProfile.setEmail(TariffIncrement + userProfile.getEmail());
			new HomePageAction().navigateToSMLandingPage()
					.navigateTocomboRegisterInterestSMlandingPage()
					.selectNoOption()
					.verifyComboRegisterInterestSMlandingPageNoOption()
					.fillDetailsForRegisterInterest(userProfile)
					.answerScreeningQuestions(userProfile)
					.checkPropertySuitability().verifyGetAQuotePage()
					.getAQuote(userProfile).verifyYourResultsPage()
					.switchToTarrifs(2).continueToPersonalDetailsPage()
					.continueToMeterDetailsPage(userProfile)
					.continueToPaymentOptionsPage()
					.continueToReviewOrderPage(userProfile)
					.verifyAndConfirmOrder().verifyLeadCreation()
					.verifyLeadType().verifyLeadStatusBefore().runAcqBatch()
					.verifyLeadStatusAfter().verifyLogin(userProfile).logout();
			++TariffIncrement;
		}
		TariffIncrement = 1;

	}

	@Test(groups = { Smoke })
	public void CA_Fun_040_EnergyShop_04() {
		Report.createTestLogHeader("CA_Fun_040", "EnergyShop04");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_034");

		TariffIncrement = 1;
		while (TariffIncrement <= 4) {
			userProfile.setEmail(TariffIncrement + userProfile.getEmail());
			new HomePageAction().navigateToSMLandingPage()
					.navigateTocomboRegisterInterestSMlandingPage()
					.selectNoOption()
					.verifyComboRegisterInterestSMlandingPageNoOption()
					.fillDetailsForRegisterInterest(userProfile)
					.answerScreeningQuestions(userProfile)
					.checkPropertySuitability().verifyGetAQuotePage()
					.getAQuote(userProfile).verifyYourResultsPage()
					.switchToTarrifs(2).continueToPersonalDetailsPage()
					.continueToMeterDetailsPage(userProfile)
					.continueToPaymentOptionsPage()
					.continueToReviewOrderPage(userProfile)
					.verifyAndConfirmOrder().verifyLeadCreation()
					.verifyLeadType().verifyLeadStatusBefore().runAcqBatch()
					.verifyLeadStatusAfter().verifyLogin(userProfile).logout();
			++TariffIncrement;
		}
		TariffIncrement = 1;

	}

	@Test(groups = { Smoke })
	public void CA_Fun_041_EnergyShop_05() {
		Report.createTestLogHeader("CA_Fun_041", "EnergyShop05");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_034");

		TariffIncrement = 1;
		while (TariffIncrement <= 4) {
			userProfile.setEmail(TariffIncrement + userProfile.getEmail());
			new HomePageAction().navigateToSMLandingPage()
					.navigateTocomboRegisterInterestSMlandingPage()
					.selectNoOption()
					.verifyComboRegisterInterestSMlandingPageNoOption()
					.fillDetailsForRegisterInterest(userProfile)
					.answerScreeningQuestions(userProfile)
					.checkPropertySuitability().verifyGetAQuotePage()
					.getAQuote(userProfile).verifyYourResultsPage()
					.switchToTarrifs(2).continueToPersonalDetailsPage()
					.continueToMeterDetailsPage(userProfile)
					.continueToPaymentOptionsPage()
					.continueToReviewOrderPageWithDirectDebit(userProfile)
					.verifyAndConfirmOrder().verifyLeadCreation()
					.verifyLeadType().verifyLeadStatusBefore().runAcqBatch()
					.verifyLeadStatusAfter().verifyLogin(userProfile).logout();
			++TariffIncrement;
		}
		TariffIncrement = 1;

	}

	@Test(groups = { Smoke })
	public void CA_Fun_042_EnergyShop_06() {
		Report.createTestLogHeader("CA_Fun_042", "EnergyShop06");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_034");

		TariffIncrement = 1;
		while (TariffIncrement <= 4) {
			userProfile.setEmail(TariffIncrement + userProfile.getEmail());
			new HomePageAction().navigateToSMLandingPage()
					.navigateTocomboRegisterInterestSMlandingPage()
					.selectNoOption()
					.verifyComboRegisterInterestSMlandingPageNoOption()
					.fillDetailsForRegisterInterest(userProfile)
					.answerScreeningQuestions(userProfile)
					.checkPropertySuitability().verifyGetAQuotePage()
					.getAQuote(userProfile).verifyYourResultsPage()
					.switchToTarrifs(2).continueToPersonalDetailsPage()
					.continueToMeterDetailsPage(userProfile)
					.continueToPaymentOptionsPage()
					.continueToReviewOrderPageWithDirectDebit(userProfile)
					.verifyAndConfirmOrder().verifyLeadCreation()
					.verifyLeadType().verifyLeadStatusBefore().runAcqBatch()
					.verifyLeadStatusAfter().verifyLogin(userProfile).logout();
			++TariffIncrement;
		}
		TariffIncrement = 1;

	}

	@Test(groups = { Smoke })
	public void CA_Fun_043_EnergyShop_07() {
		Report.createTestLogHeader("CA_Fun_043", "EnergyShop07");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_034");

		TariffIncrement = 1;
		while (TariffIncrement <= 4) {
			userProfile.setEmail(TariffIncrement + userProfile.getEmail());
			new HomePageAction().navigateToSMLandingPage()
					.navigateTocomboRegisterInterestSMlandingPage()
					.selectNoOption()
					.verifyComboRegisterInterestSMlandingPageNoOption()
					.fillDetailsForRegisterInterest(userProfile)
					.answerScreeningQuestions(userProfile)
					.checkPropertySuitability().verifyGetAQuotePage()
					.getAQuote(userProfile).verifyYourResultsPage()
					.switchToTarrifs(2).continueToPersonalDetailsPage()
					.continueToMeterDetailsPage(userProfile)
					.continueToPaymentOptionsPage()
					.continueToReviewOrderPageWithDirectDebit(userProfile)
					.verifyAndConfirmOrder().verifyLeadCreation()
					.verifyLeadType().verifyLeadStatusBefore().runAcqBatch()
					.verifyLeadStatusAfter().verifyLogin(userProfile).logout();
			++TariffIncrement;
		}
		TariffIncrement = 1;

	}

	@Test(groups = { Smoke })
	public void CA_Fun_044_EnergyShop_08() {
		Report.createTestLogHeader("CA_Fun_044", "EnergyShop08");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_034");

		TariffIncrement = 1;
		while (TariffIncrement <= 4) {
			userProfile.setEmail(TariffIncrement + userProfile.getEmail());
			new HomePageAction().navigateToSMLandingPage()
					.navigateTocomboRegisterInterestSMlandingPage()
					.selectNoOption()
					.verifyComboRegisterInterestSMlandingPageNoOption()
					.fillDetailsForRegisterInterest(userProfile)
					.answerScreeningQuestions(userProfile)
					.checkPropertySuitability().verifyGetAQuotePage()
					.getAQuote(userProfile).verifyYourResultsPage()
					.switchToTarrifs(2).continueToPersonalDetailsPage()
					.continueToMeterDetailsPage(userProfile)
					.continueToPaymentOptionsPage()
					.continueToReviewOrderPageWithDirectDebit(userProfile)
					.verifyAndConfirmOrder().verifyLeadCreation()
					.verifyLeadType().verifyLeadStatusBefore().runAcqBatch()
					.verifyLeadStatusAfter().verifyLogin(userProfile).logout();
			++TariffIncrement;
		}
		TariffIncrement = 1;

	}

	@Test(groups = { Smoke })
	public void CA_Fun_045_EnergyShop_09() {
		Report.createTestLogHeader("CA_Fun_045", "EnergyShop09");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_034");

		TariffIncrement = 1;
		while (TariffIncrement <= 4) {
			userProfile.setEmail(TariffIncrement + userProfile.getEmail());
			new HomePageAction().navigateToSMLandingPage()
					.navigateTocomboRegisterInterestSMlandingPage()
					.selectNoOption()
					.verifyComboRegisterInterestSMlandingPageNoOption()
					.fillDetailsForRegisterInterest(userProfile)
					.answerScreeningQuestions(userProfile)
					.checkPropertySuitability().verifyGetAQuotePage()
					.getAQuote(userProfile).verifyYourResultsPage()
					.switchToTarrifs(2).continueToPersonalDetailsPage()
					.continueToMeterDetailsPage(userProfile)
					.continueToPaymentOptionsPage()
					.continueToReviewOrderPageWithDirectDebit(userProfile)
					.verifyAndConfirmOrder().verifyLeadCreation()
					.verifyLeadType().verifyLeadStatusBefore().runAcqBatch()
					.verifyLeadStatusAfter().verifyLogin(userProfile).logout();
			++TariffIncrement;
		}
		TariffIncrement = 1;

	}

	@Test(groups = { Smoke })
	public void CA_Fun_046_EnergyShop_10() {
		Report.createTestLogHeader("CA_Fun_046", "EnergyShop10");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_034");

		TariffIncrement = 1;
		while (TariffIncrement <= 4) {
			userProfile.setEmail(TariffIncrement + userProfile.getEmail());
			new HomePageAction().navigateToSMLandingPage()
					.navigateTocomboRegisterInterestSMlandingPage()
					.selectNoOption()
					.verifyComboRegisterInterestSMlandingPageNoOption()
					.fillDetailsForRegisterInterest(userProfile)
					.answerScreeningQuestions(userProfile)
					.checkPropertySuitability().verifyGetAQuotePage()
					.getAQuote(userProfile).verifyYourResultsPage()
					.switchToTarrifs(2).continueToPersonalDetailsPage()
					.continueToMeterDetailsPage(userProfile)
					.continueToPaymentOptionsPage()
					.continueToReviewOrderPageWithDirectDebit(userProfile)
					.verifyAndConfirmOrder().verifyLeadCreation()
					.verifyLeadType().verifyLeadStatusBefore().runAcqBatch()
					.verifyLeadStatusAfter().verifyLogin(userProfile).logout();
			++TariffIncrement;
		}
		TariffIncrement = 1;

	}

	@Test(groups = { Smoke })
	public void CA_Fun_047_EnergyShop_11() {
		Report.createTestLogHeader("CA_Fun_047", "EnergyShop11");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_034");

		TariffIncrement = 1;
		while (TariffIncrement <= 4) {
			userProfile.setEmail(TariffIncrement + userProfile.getEmail());
			new HomePageAction().navigateToSMLandingPage()
					.navigateTocomboRegisterInterestSMlandingPage()
					.selectNoOption()
					.verifyComboRegisterInterestSMlandingPageNoOption()
					.fillDetailsForRegisterInterest(userProfile)
					.answerScreeningQuestions(userProfile)
					.checkPropertySuitability().verifyGetAQuotePage()
					.getAQuote(userProfile).verifyYourResultsPage()
					.switchToTarrifs(2).continueToPersonalDetailsPage()
					.continueToMeterDetailsPage(userProfile)
					.continueToPaymentOptionsPage()
					.continueToReviewOrderPageWithDirectDebit(userProfile)
					.verifyAndConfirmOrder().verifyLeadCreation()
					.verifyLeadType().verifyLeadStatusBefore().runAcqBatch()
					.verifyLeadStatusAfter().verifyLogin(userProfile).logout();
			++TariffIncrement;
		}
		TariffIncrement = 1;

	}

	@Test(groups = { Smoke })
	public void CA_Fun_048_EnergyShop_12() {
		Report.createTestLogHeader("CA_Fun_048", "EnergyShop12");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_034");

		TariffIncrement = 1;
		while (TariffIncrement <= 4) {
			userProfile.setEmail(TariffIncrement + userProfile.getEmail());
			new HomePageAction().navigateToSMLandingPage()
					.navigateTocomboRegisterInterestSMlandingPage()
					.selectNoOption()
					.verifyComboRegisterInterestSMlandingPageNoOption()
					.fillDetailsForRegisterInterest(userProfile)
					.answerScreeningQuestions(userProfile)
					.checkPropertySuitability().verifyGetAQuotePage()
					.getAQuote(userProfile).verifyYourResultsPage()
					.switchToTarrifs(2).continueToPersonalDetailsPage()
					.continueToMeterDetailsPage(userProfile)
					.continueToPaymentOptionsPage()
					.continueToReviewOrderPageWithDirectDebit(userProfile)
					.verifyAndConfirmOrder().verifyLeadCreation()
					.verifyLeadType().verifyLeadStatusBefore().runAcqBatch()
					.verifyLeadStatusAfter().verifyLogin(userProfile).logout();
			++TariffIncrement;
		}
		TariffIncrement = 1;

	}

	/* register your interest test cases */

	/*
	 * Add below fields to the Userprofile.xml file
	 * 
	 * 1. Email id 2. Password 3. FirstName 4. lastName 5. title 6. mobileNumber
	 * 7. accNumber 8. address 9. postalCode 10. answer1 11. answer2 12. answer3
	 * 13. answer4 14. answer5 15. dayOfBirth 16. monthOfBirth 17. yearOfBirth
	 * 18. elecSpendDuration 19. gasSpendDuration 20. sortCode1 21. sortCode2
	 * 22. sortCode3 23. annualElecSpendAmount 24. annualGasSpendAmount 25.
	 * monthAtAddress 26. yearAtAddress 27. currentEnergySupplier 28.
	 * currentEnergyPaymentMethod 29. currentEnergyTafiff
	 */

	@Test(groups = { Smoke })
	public void CA_Fun_049_RegisterYourInterest() {
		Report.createTestLogHeader("CA_Fun_033", "RegisterInterest");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_033");

		new HomePageAction().navigateToSMLandingPage()
				.navigateTocomboRegisterInterestSMlandingPage()
				.selectNoOption()
				.verifyComboRegisterInterestSMlandingPageNoOption()
				.fillDetailsForRegisterInterest(userProfile)
				.answerScreeningQuestions(userProfile)
				.checkPropertySuitability()
				.verifyRegisterYourInterestLinkAtSMLpage()
				.navigateToRegisterYourInterestPage()
				.registerInterest(userProfile).runRegIntBatch()
				.verifyInterestRegistration();
	}

	/* energy smart test cases */

	/*
	 * Add below fields to the Userprofile.xml file
	 * 
	 * 1. Email id 2. Password 3. FirstName 4. lastName 5. title 6. mobileNumber
	 * 7. accNumber 8. address 9. postalCode 10. answer1 11. answer2 12. answer3
	 * 13. answer4 14. answer5 15. dayOfBirth 16. monthOfBirth 17. yearOfBirth
	 * 18. elecSpendDuration 19. gasSpendDuration 20. sortCode1 21. sortCode2
	 * 22. sortCode3 23. annualElecSpendAmount 24. annualGasSpendAmount 25.
	 * monthAtAddress 26. yearAtAddress 27. currentEnergySupplier 28.
	 * currentEnergyPaymentMethod 29. currentEnergyTafiff
	 */

	@Test(groups = { Smoke })
	public void CA_Fun_050_EnergySmart_01() {
		Report.createTestLogHeader("CA_Fun_050", "EnergySmart01");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_034");

		TariffIncrement = 1;
		while (TariffIncrement <= 4) {
			FuelIncrement = 1;
			while (FuelIncrement <= 3) {
				userProfile.setEmail(TariffIncrement +""+ FuelIncrement
						+ userProfile.getEmail());

				new HomePageAction()
						.navigateToOurNewTariffsPage()
						.switchToSmartTariff(TariffIncrement, FuelIncrement)
						.continueToPersonalDetailsPage()
						.continueToMeterDetailsPageEsmart(userProfile)
						.continueToPaymentOptionsPage(FuelIncrement)
						.continueToReviewOrderPageWithVariableDirectDebit(
								userProfile).verifyAndConfirmOrder()
						.verifyLeadCreation().verifyLeadType()
						.verifyLeadStatusBefore().runESmartBatch()
						.verifyLeadStatusAfter().verifyLogin(userProfile)
						.logout();
				++FuelIncrement;
			}
			++TariffIncrement;
		}
		TariffIncrement = 1;

	}

	@Test(groups = { Smoke })
	public void CA_Fun_051_EnergySmart_02() {
		Report.createTestLogHeader("CA_Fun_051", "EnergySmart02");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_034");

		TariffIncrement = 1;
		while (TariffIncrement <= 4) {
			FuelIncrement = 1;
			while (FuelIncrement <= 3) {
				userProfile.setEmail(TariffIncrement +""+ FuelIncrement
						+ userProfile.getEmail());
				new HomePageAction().navigateToOurNewTariffsPage()
						.switchToSmartTariff(TariffIncrement, FuelIncrement)
						.continueToPersonalDetailsPage()
						.continueToMeterDetailsPageEsmart(userProfile)
						.continueToPaymentOptionsPage(FuelIncrement)
						.continueToReviewOrderPageWithDirectDebit(userProfile)
						.verifyAndConfirmOrder().verifyLeadCreation()
						.verifyLeadType().verifyLeadStatusBefore()
						.runESmartBatch().verifyLeadStatusAfter()
						.verifyLogin(userProfile).logout();
				++FuelIncrement;
			}
			++TariffIncrement;
		}
		TariffIncrement = 1;

	}

	@Test(groups = { Smoke })
	public void CA_Fun_052_EnergySmart_03() {
		Report.createTestLogHeader("CA_Fun_052", "EnergySmart03");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_052");

		TariffIncrement = 1;
		while (TariffIncrement <= 4) {
			FuelIncrement = 1;
			while (FuelIncrement <= 3) {
				userProfile.setEmail(TariffIncrement +""+ FuelIncrement
						+ userProfile.getEmail());
				new HomePageAction().navigateToOurNewTariffsPage()
						.switchToSmartTariff(TariffIncrement, FuelIncrement)
						.continueToPersonalDetailsPage()
						.continueToMeterDetailsPageEsmart(userProfile)
						.continueToPaymentOptionsPage(FuelIncrement)
						.continueToReviewOrderPageWithDirectDebit(userProfile)
						.verifyAndConfirmOrder().verifyLeadCreation()
						.verifyLeadType().verifyLeadStatusBefore()
						.runESmartBatch().verifyLeadStatusAfter()
						.verifyLogin(userProfile).logout();
				++FuelIncrement;
			}
			++TariffIncrement;
		}
		TariffIncrement = 1;

	}

	@Test(groups = { Smoke })
	public void CA_Fun_053_EnergySmart_04() {
		Report.createTestLogHeader("CA_Fun_052", "EnergySmart03");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_052");

		TariffIncrement = 1;
		while (TariffIncrement <= 4) {
			FuelIncrement = 1;
			while (FuelIncrement <= 3) {
				userProfile.setEmail(TariffIncrement +""+ FuelIncrement
						+ userProfile.getEmail());
				new HomePageAction().navigateToOurNewTariffsPage()
						.switchToSmartTariff(TariffIncrement, FuelIncrement)
						.continueToPersonalDetailsPage()
						.continueToMeterDetailsPageEsmart(userProfile)
						.continueToPaymentOptionsPage(FuelIncrement)
						.continueToReviewOrderPageWithDirectDebit(userProfile)
						.verifyAndConfirmOrder().verifyLeadCreation()
						.verifyLeadType().verifyLeadStatusBefore()
						.runESmartBatch().verifyLeadStatusAfter()
						.verifyLogin(userProfile).logout();
				++FuelIncrement;
			}
			++TariffIncrement;
		}
		TariffIncrement = 1;

	}

	@Test(groups = { Smoke })
	public void CA_Fun_054_EnergySmart_05() {
		Report.createTestLogHeader("CA_Fun_052", "EnergySmart03");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_052");

		TariffIncrement = 1;
		while (TariffIncrement <= 4) {
			FuelIncrement = 1;
			while (FuelIncrement <= 3) {
				userProfile.setEmail(TariffIncrement +""+ FuelIncrement
						+ userProfile.getEmail());
				new HomePageAction().navigateToOurNewTariffsPage()
						.switchToSmartTariff(TariffIncrement, FuelIncrement)
						.continueToPersonalDetailsPage()
						.continueToMeterDetailsPageEsmart(userProfile)
						.continueToPaymentOptionsPage(FuelIncrement)
						.continueToReviewOrderPageWithDirectDebit(userProfile)
						.verifyAndConfirmOrder().verifyLeadCreation()
						.verifyLeadType().verifyLeadStatusBefore()
						.runESmartBatch().verifyLeadStatusAfter()
						.verifyLogin(userProfile).logout();
				++FuelIncrement;
			}
			++TariffIncrement;
		}
		TariffIncrement = 1;

	}

	@Test(groups = { Smoke })
	public void CA_Fun_055_EnergySmart_06() {
		Report.createTestLogHeader("CA_Fun_052", "EnergySmart03");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_052");

		TariffIncrement = 1;
		while (TariffIncrement <= 4) {
			FuelIncrement = 1;
			while (FuelIncrement <= 3) {
				userProfile.setEmail(TariffIncrement +""+ FuelIncrement
						+ userProfile.getEmail());
				new HomePageAction().navigateToOurNewTariffsPage()
						.switchToSmartTariff(TariffIncrement, FuelIncrement)
						.continueToPersonalDetailsPage()
						.continueToMeterDetailsPageEsmart(userProfile)
						.continueToPaymentOptionsPage(FuelIncrement)
						.continueToReviewOrderPageWithDirectDebit(userProfile)
						.verifyAndConfirmOrder().verifyLeadCreation()
						.verifyLeadType().verifyLeadStatusBefore()
						.runESmartBatch().verifyLeadStatusAfter()
						.verifyLogin(userProfile).logout();
				++FuelIncrement;
			}
			++TariffIncrement;
		}
		TariffIncrement = 1;

	}

	@Test(groups = { Smoke })
	public void CA_Fun_056_EnergySmart_07() {
		Report.createTestLogHeader("CA_Fun_052", "EnergySmart03");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_052");

		TariffIncrement = 1;
		while (TariffIncrement <= 4) {
			FuelIncrement = 1;
			while (FuelIncrement <= 3) {
				userProfile.setEmail(TariffIncrement +""+ FuelIncrement
						+ userProfile.getEmail());
				new HomePageAction().navigateToOurNewTariffsPage()
						.switchToSmartTariff(TariffIncrement, FuelIncrement)
						.continueToPersonalDetailsPage()
						.continueToMeterDetailsPageEsmart(userProfile)
						.continueToPaymentOptionsPage(FuelIncrement)
						.continueToReviewOrderPageWithDirectDebit(userProfile)
						.verifyAndConfirmOrder().verifyLeadCreation()
						.verifyLeadType().verifyLeadStatusBefore()
						.runESmartBatch().verifyLeadStatusAfter()
						.verifyLogin(userProfile).logout();
				++FuelIncrement;
			}
			++TariffIncrement;
		}
		TariffIncrement = 1;

	}

	@Test(groups = { Smoke })
	public void CA_Fun_057_EnergySmart_08() {
		Report.createTestLogHeader("CA_Fun_052", "EnergySmart03");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_052");

		TariffIncrement = 1;
		while (TariffIncrement <= 4) {
			FuelIncrement = 1;
			while (FuelIncrement <= 3) {
				userProfile.setEmail(TariffIncrement +""+ FuelIncrement
						+ userProfile.getEmail());
				new HomePageAction().navigateToOurNewTariffsPage()
						.switchToSmartTariff(TariffIncrement, FuelIncrement)
						.continueToPersonalDetailsPage()
						.continueToMeterDetailsPageEsmart(userProfile)
						.continueToPaymentOptionsPage(FuelIncrement)
						.continueToReviewOrderPageWithDirectDebit(userProfile)
						.verifyAndConfirmOrder().verifyLeadCreation()
						.verifyLeadType().verifyLeadStatusBefore()
						.runESmartBatch().verifyLeadStatusAfter()
						.verifyLogin(userProfile).logout();
				++FuelIncrement;
			}
			++TariffIncrement;
		}
		TariffIncrement = 1;

	}

	@Test(groups = { Smoke })
	public void CA_Fun_058_EnergySmart_09() {
		Report.createTestLogHeader("CA_Fun_052", "EnergySmart03");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_052");

		TariffIncrement = 1;
		while (TariffIncrement <= 4) {
			FuelIncrement = 1;
			while (FuelIncrement <= 3) {
				userProfile.setEmail(TariffIncrement +""+ FuelIncrement
						+ userProfile.getEmail());
				new HomePageAction().navigateToOurNewTariffsPage()
						.switchToSmartTariff(TariffIncrement, FuelIncrement)
						.continueToPersonalDetailsPage()
						.continueToMeterDetailsPageEsmart(userProfile)
						.continueToPaymentOptionsPage(FuelIncrement)
						.continueToReviewOrderPageWithDirectDebit(userProfile)
						.verifyAndConfirmOrder().verifyLeadCreation()
						.verifyLeadType().verifyLeadStatusBefore()
						.runESmartBatch().verifyLeadStatusAfter()
						.verifyLogin(userProfile).logout();
				++FuelIncrement;
			}
			++TariffIncrement;
		}
		TariffIncrement = 1;

	}

	@Test(groups = { Smoke })
	public void CA_Fun_059_EnergySmart_10() {
		Report.createTestLogHeader("CA_Fun_052", "EnergySmart03");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_052");

		TariffIncrement = 1;
		while (TariffIncrement <= 4) {
			FuelIncrement = 1;
			while (FuelIncrement <= 3) {
				userProfile.setEmail(TariffIncrement +""+ FuelIncrement
						+ userProfile.getEmail());
				new HomePageAction().navigateToOurNewTariffsPage()
						.switchToSmartTariff(TariffIncrement, FuelIncrement)
						.continueToPersonalDetailsPage()
						.continueToMeterDetailsPageEsmart(userProfile)
						.continueToPaymentOptionsPage(FuelIncrement)
						.continueToReviewOrderPageWithDirectDebit(userProfile)
						.verifyAndConfirmOrder().verifyLeadCreation()
						.verifyLeadType().verifyLeadStatusBefore()
						.runESmartBatch().verifyLeadStatusAfter()
						.verifyLogin(userProfile).logout();
				++FuelIncrement;
			}
			++TariffIncrement;
		}
		TariffIncrement = 1;

	}

	@Test(groups = { Smoke })
	public void CA_Fun_060_EnergySmart_11() {
		Report.createTestLogHeader("CA_Fun_052", "EnergySmart03");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_052");

		TariffIncrement = 1;
		while (TariffIncrement <= 4) {
			FuelIncrement = 1;
			while (FuelIncrement <= 3) {
				userProfile.setEmail(TariffIncrement +""+ FuelIncrement
						+ userProfile.getEmail());
				new HomePageAction().navigateToOurNewTariffsPage()
						.switchToSmartTariff(TariffIncrement, FuelIncrement)
						.continueToPersonalDetailsPage()
						.continueToMeterDetailsPageEsmart(userProfile)
						.continueToPaymentOptionsPage(FuelIncrement)
						.continueToReviewOrderPageWithDirectDebit(userProfile)
						.verifyAndConfirmOrder().verifyLeadCreation()
						.verifyLeadType().verifyLeadStatusBefore()
						.runESmartBatch().verifyLeadStatusAfter()
						.verifyLogin(userProfile).logout();
				++FuelIncrement;
			}
			++TariffIncrement;
		}
		TariffIncrement = 1;

	}

	@Test(groups = { Smoke })
	public void CA_Fun_061_EnergySmart_12() {
		Report.createTestLogHeader("CA_Fun_052", "EnergySmart03");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_052");

		TariffIncrement = 1;
		while (TariffIncrement <= 4) {
			FuelIncrement = 1;
			while (FuelIncrement <= 3) {
				userProfile.setEmail(TariffIncrement +""+ FuelIncrement
						+ userProfile.getEmail());
				new HomePageAction().navigateToOurNewTariffsPage()
						.switchToSmartTariff(TariffIncrement, FuelIncrement)
						.continueToPersonalDetailsPage()
						.continueToMeterDetailsPageEsmart(userProfile)
						.continueToPaymentOptionsPage(FuelIncrement)
						.continueToReviewOrderPageWithDirectDebit(userProfile)
						.verifyAndConfirmOrder().verifyLeadCreation()
						.verifyLeadType().verifyLeadStatusBefore()
						.runESmartBatch().verifyLeadStatusAfter()
						.verifyLogin(userProfile).logout();
				++FuelIncrement;
			}
			++TariffIncrement;
		}
		TariffIncrement = 1;

	}

	@Test(groups = { Smoke })
	public void CA_Fun_062_EnergySmart_13() {
		Report.createTestLogHeader("CA_Fun_062", "EnergySmart13");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_0062");

		TariffIncrement = 1;
		while (TariffIncrement <= 4) {
			FuelIncrement = 1;
			while (FuelIncrement <= 3) {
				userProfile.setEmail(TariffIncrement +""+ FuelIncrement
						+ userProfile.getEmail());
				new HomePageAction().navigateToOurNewTariffsPage()
						.switchToSmartTariff(TariffIncrement, FuelIncrement)
						.continueToPersonalDetailsPage()
						.continueToMeterDetailsPageEsmart(userProfile)
						.continueToPaymentOptionsPage(FuelIncrement)
						.continueToReviewOrderPageWithDirectDebit(userProfile)
						.verifyAndConfirmOrder().verifyLeadCreation()
						.verifyLeadType().verifyLeadStatusBefore()
						.runESmartBatch().verifyLeadStatusAfter()
						.verifyLogin(userProfile).logout();
				++FuelIncrement;
			}
			++TariffIncrement;
		}
		TariffIncrement = 1;

	}

	@Test(groups = { Smoke })
	public void CA_Fun_063_EnergySmart_14() {
		Report.createTestLogHeader("CA_Fun_063", "EnergySmart14");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_063");

		TariffIncrement = 1;
		while (TariffIncrement <= 4) {
			FuelIncrement = 1;
			while (FuelIncrement <= 3) {
				userProfile.setEmail(TariffIncrement +""+ FuelIncrement
						+ userProfile.getEmail());
				new HomePageAction().navigateToOurNewTariffsPage()
						.switchToSmartTariff(TariffIncrement, FuelIncrement)
						.continueToPersonalDetailsPage()
						.continueToMeterDetailsPageEsmart(userProfile)
						.continueToPaymentOptionsPage(FuelIncrement)
						.continueToReviewOrderPageWithDirectDebit(userProfile)
						.verifyAndConfirmOrder().verifyLeadCreation()
						.verifyLeadType().verifyLeadStatusBefore()
						.runESmartBatch().verifyLeadStatusAfter()
						.verifyLogin(userProfile).logout();
				++FuelIncrement;
			}
			++TariffIncrement;
		}
		TariffIncrement = 1;

	}

	@Test(groups = { Smoke })
	public void CA_Fun_064_EnergySmart_15() {
		Report.createTestLogHeader("CA_Fun_064", "EnergySmart15");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("CA_Fun_064");

		TariffIncrement = 1;
		while (TariffIncrement <= 4) {
			FuelIncrement = 1;
			while (FuelIncrement <= 3) {
				userProfile.setEmail(TariffIncrement +""+ FuelIncrement
						+ userProfile.getEmail());
				new HomePageAction().navigateToOurNewTariffsPage()
						.switchToSmartTariff(TariffIncrement, FuelIncrement)
						.continueToPersonalDetailsPage()
						.continueToMeterDetailsPageEsmart(userProfile)
						.continueToPaymentOptionsPage(FuelIncrement)
						.continueToReviewOrderPageWithDirectDebit(userProfile)
						.verifyAndConfirmOrder().verifyLeadCreation()
						.verifyLeadType().verifyLeadStatusBefore()
						.runESmartBatch().verifyLeadStatusAfter()
						.verifyLogin(userProfile).logout();
				++FuelIncrement;
			}
			++TariffIncrement;
		}
		TariffIncrement = 1;

	}

}
