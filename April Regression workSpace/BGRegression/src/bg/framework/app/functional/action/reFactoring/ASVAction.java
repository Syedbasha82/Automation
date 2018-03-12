package bg.framework.app.functional.action.reFactoring;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.action.selfServe.ASVIBAction;
import bg.framework.app.functional.action.selfServe.AccountOverviewAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.reFactoring.ASVPage;
import bg.framework.app.functional.page.selfServe.ASVIBPage;
import bg.framework.app.functional.page.selfServe.AccountOverviewPage;

public class ASVAction {
	
	public ASVAction checkMobileNumber(UserProfile userProfile)
	{
		new ASVPage().checkMobileNumber(userProfile);
		return new ASVAction();
	}
	
	public ASVAction checkHomeNumber(UserProfile userProfile)
	{
		new ASVPage().checkHomeNumber(userProfile);
		return new ASVAction();
	}
	
	public ASVAction modifyHomeNumber()
	{
		new ASVPage().modifyHomeNumber();
		return new ASVAction();
	}

	public ASVAction logout()
	{
		new AccountOverviewPage().logout();
		return new ASVAction();
	}
	
	public ASVAction accountSummaryChangeAppointment()
	{
		
		new ASVIBPage().accountSummaryChangeAppointment();
		return this;
	}
	
	public IBAction accountSummaryChangeAppointmentIB()
	{
		
		new ASVIBPage().accountSummaryChangeAppointment();
		return new IBAction();
	}
	
	public ASVAction selectAnAppointment()
	{
		new ASVIBPage().selectAnAppointment();
		return this;
	}
	
	public ASVAction checkNewMobileNumber(UserProfile userProfile)
	{
		new ASVPage().checkNewMobileNumber(userProfile);
		return this;
	}
	
	public ASVAction verifyBookingDB(UserProfile userProfile,String strType)
	{
		new ASVPage().verifyBookingDB(userProfile,strType);
		return this;
	}
	public ASVAction navigateToAsvBookingPage(UserProfile userProfile)
	{
		new ASVPage().navigateToAsvBookingPage(userProfile);
		return this;
	}
	public ASVAction navigateToFVBookingPage(UserProfile userProfile)
	{
		new ASVPage().navigateToFVBookingPage(userProfile);
		return this;
	}
	public ASVAction verifyChooseYourAppointmentPage()
	{
		new ASVPage().verifyChooseYourAppointmentPage();
		return this;
	}
	public ASVAction navigateToReviewYourAppointmentPageFirstAvailableAppointment()
	{
		new ASVPage().navigateToReviewYourAppointmentPageFirstAvailableAppointment();
		return this;
	}
	public ASVAction navigateToReviewYourAppointmentPageThroughCalendar()
	{
		new ASVPage().navigateToReviewYourAppointmentPageThroughCalendar();
		return this;
	}
	public ASVAction verifyServiceOverviewPage()
	{
		new ASVPage().verifyServiceOverviewPage();
		return this;
	}
	public ASVAction verifyReviewYourAppointmentPage(UserProfile userProfile)
	{
		new ASVPage().verifyReviewYourAppointmentPage(userProfile);
		return this;
	}
	public ASVAction navigateToConfirmationPage()
	{
		new ASVPage().navigateToConfirmationPage();
		return this;
	}
	public ASVAction verifyConfirmationPage()
	{
		new ASVPage().verifyConfirmationPage();
		return this;
	}
	public ASVAction verifyConfirmationPageFV()
	{
		new ASVPage().verifyConfirmationPageFV();
		return this;
	}
	public ASVAction navigateToAccountSumaryPageFromConfirmationPage()
	{
		new ASVPage().navigateToAccountSumaryPageFromConfirmationPage();
		return this;
	}
	public ASVAction verifyAccountSummaryPage()
	{
		new ASVPage().verifyAccountSummaryPage();
		return this;
	}
	public ASVAction returnToYourAccount()
	{
		new ASVPage().returnToYourAccount();
		return this;
	}
	public ASVAction cancelBooking()
	{
		new ASVPage().cancelBooking();
		return this;
	}
	public ASVAction cancelBookingFV()
	{
		new ASVPage().cancelBookingFV();
		return this;
	}
	public ASVAction changeBooking()
	{
		new ASVPage().changeBooking();
		return this;
	}
	public ASVAction verifyCancelfunctionality()
	{
		new ASVPage().verifyCancelfunctionality();
		return this;
	}

	public ASVAction navigateToLandlordServiceOverviewPage()
	{
		new ASVPage().navigateToLandlordServiceOverviewPage();
		return this;
	}
	public ASVAction verifyLandlordCalendarPage()
	{
		new ASVPage().verifyLandlordCalendarPage();
		return this;
	}
	public ASVAction loginUserDetails(UserProfile userprofile)
	{
		new LoginAction().loginUserDetails(userprofile);
		return new ASVAction();
	}
	public ASVAction trackAnEngineer()
	{
		new ASVPage().trackAnEngineer();
		return new ASVAction();
	}
	
	public ASVAction verifyTrackAnEnginerrAppointmentSection()
	{
		new ASVPage().verifyTrackAnEnginerrAppointmentSection();
		return new ASVAction();
	}
	
	
	public ASVAction  verifyRescheduleConfirmationPage()
	{
		new ASVPage().verifyRescheduleConfirmationPage();
		return new ASVAction();
	}
	
}
