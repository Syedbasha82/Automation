package bg.framework.app.functional.test.selfServe;

import static bg.framework.app.functional.entities.FunctionalCategory.*;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.selfServe.MessageCentreAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class MessageCentreTest extends TestBase {

	/*
	 * Mandatory field in UserProfile: UCRN,Account Number,GasAccount,Email. OAM
	 * Message Journey:PET0057 Treatment id message should be there
	 */
	@Test(groups = { MessageCentre, Regression })
	public void oamTreatmentMessageJourney() {
		Report.createTestLogHeader("Treament Message Centre Journey test",
				"OAM");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");

		new MessageCentreAction().navigateToLogin().loginUser(userProfile)
				.navigateToMessages()
				.chkUnreadMessages(userProfile, "GasAccount")
				.readUnreadMessages(userProfile, "GasAccount", "Treatment");
	}

	/*
	 * Mandatory field in UserProfile: UCRN,Account Number,GasAccount,Email. OAM
	 * Message Journey : Broadcast unread Message should be there
	 */
	@Test(groups = { MessageCentre, Regression })
	public void oamBroadcastMessageJourney() {
		Report.createTestLogHeader("Broadcast Message Centre Journey test",
				"OAM");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");

		new MessageCentreAction().navigateToLogin().loginUser(userProfile)
				.navigateToMessages()
				.chkUnreadMessages(userProfile, "GasAccount")
				.readUnreadMessages(userProfile, "GasAccount", "Broadcast")
				.logout();
	}
	@Test(groups = { MessageCentre, Regression })
	public void SmartAccMessageJourney() {
		Report.createTestLogHeader("Broadcast Message Centre Journey test",
				"OAM");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");

		new MessageCentreAction().navigateToLogin().loginUser(userProfile)
				.navigateToMessages()
				.chkUnreadMessages(userProfile, "GasAccount")
				.readUnreadMessages(userProfile, "GasAccount", "Broadcast")
				.logout();
	}

	/*
	 * Mandatory field in UserProfile: UCRN,Account Number OAM BGS Message
	 * Journey : PET0065 Treatment id message should be there
	 */
	@Test(groups = { MessageCentre, Regression })
	public void bgsTreatmentMessageJourney() {
		Report.createTestLogHeader("Treatment Message Centre Journey test",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeSerivcesAccount");

		new MessageCentreAction()
				.navigateToLogin()
				.loginUser(userProfile)
				.navigateToMessages()
				.chkUnreadMessages(userProfile, "HomeSerivcesAccount")
				.readUnreadMessages(userProfile, "HomeSerivcesAccount",
						"Treatment").logout();
	}

	/*
	 * Mandatory field in UserProfile: UCRN,Account Number OAM BGS Message
	 * Journey: Broadcast unread Message should be there
	 */
	@Test(groups = { MessageCentre, Regression })
	public void bgsBroadcastMessageJourney() {
		Report.createTestLogHeader("Broadcast Message Centre Journey test",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeSerivcesAccount");

		new MessageCentreAction()
				.navigateToLogin()
				.loginUser(userProfile)
				.navigateToMessages()
				.chkUnreadMessages(userProfile, "HomeSerivcesAccount")
				.readUnreadMessages(userProfile, "HomeSerivcesAccount",
						"Broadcast").logout().logout();
	}

	/*
	 * Mandatory field in UserProfile: UCRN,Account Number SSO Account Message
	 * Journey : PET0326 Treatment id message should be there
	 */
	@Test(groups = { MessageCentre, Regression })
	public void SSOTreatmentMessageJourney() {
		Report.createTestLogHeader("Treatment Message Centre Journey test",
				"SSOAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("SSOAccount");

		new MessageCentreAction().navigateToLogin().loginUser(userProfile)
				.navigateToMessages()
				.chkUnreadMessages(userProfile, "SSOAccount")
				.readUnreadMessages(userProfile, "SSOAccount", "Treatment")
				.logout();
	}

	/*
	 * Mandatory field in UserProfile: UCRN,Account Number SSO Account Message
	 * Journey: Broadcast unread Message should be there
	 */
	@Test(groups = { MessageCentre, Regression })
	public void SSOBroadCastMessageJourney() {
		Report.createTestLogHeader("Broadcast Message Centre Journey test",
				"SSOAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("SSOAccount");

		new MessageCentreAction().navigateToLogin().loginUser(userProfile)
				.navigateToMessages()
				.chkUnreadMessages(userProfile, "SSOAccount")
				.readUnreadMessages(userProfile, "SSOAccount", "Broadcast")
				.logout();
	}
	/*
	 * Mandatory field in UserProfile: UCRN,Account Number SSO Account Message
	 * Journey: Broadcast unread Message should be there
	 */
	@Test(groups = { MessageCentre, Regression })
	public void DeleteDefault1message() {
		Report.createTestLogHeader("DeleteDefault1message",
				"OAM");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");

		new MessageCentreAction().navigateToLogin().loginUser(userProfile)
				.navigateToMessages()
			    .navigateToDefault1Message()			   
			    .navigateToDelete()
				.logout();
	}
	
	/*
	 * Mandatory field in UserProfile: UCRN,Account Number SSO Account Message
	 * Journey: Broadcast unread Message should be there
	 */
	@Test(groups = { MessageCentre, Regression })
	public void CheckDefault3Message() {
		Report.createTestLogHeader("CheckDefault3Message",
				"OAM");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");

		new MessageCentreAction().navigateToLogin().loginUser(userProfile)
				.navigateToMessages()
			    .navigateToDefault3Message()
			    .navigateToDelete()
				.logout();
	}
	

	/*
	 * Mandatory field in UserProfile: UCRN,Account Number SSO Account Message
	 * Journey: Broadcast unread Message should be there
	 */
	@Test(groups = { MessageCentre, Regression })
	public void CheckDefault2Message() {
		Report.createTestLogHeader("CheckDefault3Message",
				"OAM");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");

		new MessageCentreAction().navigateToLogin().loginUser(userProfile)
				.navigateToMessages()
			    .navigateToDefault2Message()
			    .navigateToDelete()
				.logout();
	}
	



}
