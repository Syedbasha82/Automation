package bg.framework.app.functional.action.selfServe;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.reFactoring.ASVAction;
import bg.framework.app.functional.action.reFactoring.BookingCompleteAction;
import bg.framework.app.functional.action.reFactoring.IBAction;
import bg.framework.app.functional.action.reFactoring.LandlordPhase2Action;
import bg.framework.app.functional.action.reFactoring.ServiceAndExperienceAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.reFactoring.AccountOverviewPage;
import bg.framework.app.functional.page.reFactoring.IBPage;
import bg.framework.app.functional.page.reFactoring.LandlordPhase2Page;
import bg.framework.app.functional.page.selfServe.ASVIBPage;

public class ASVIBAction {

	public ASVIBAction()
	{
		
	}
	ASVIBPage ASVIB = new ASVIBPage();
	public ASVIBAction navigateToAccountSummary(UserProfile userProfile)
	{
		
		ASVIB.navigateToAccountSummary(userProfile);
		return this;
	}
	
	public IBAction verifyAddress(UserProfile userProfile) {
		new IBPage().verifyAddress(userProfile);
		return new IBAction();
	}
	
	public LandlordPhase2Action verifyAddressLL(UserProfile userProfile) {
		new IBPage().verifyAddress(userProfile);
		return new LandlordPhase2Action();
	}
	
	public BookingCompleteAction verifyAddressBook(UserProfile userProfile) {
		new IBPage().verifyAddress(userProfile);
		return new BookingCompleteAction();
	}
	
	public ASVIBAction verifyAddressASVIB(UserProfile userProfile) {
		new IBPage().verifyAddress(userProfile);
		return new ASVIBAction();
	}
	
	public ASVIBAction verifyAddressIB(UserProfile userProfile) {
		new IBPage().verifyAddress(userProfile);
		return new ASVIBAction();
	}
	public IBAction verifyAddressIBPage(UserProfile userProfile) {
		new IBPage().verifyAddress(userProfile);
		return new IBAction();
	}
	
	public ASVIBAction verifyPiCallErrorMessage()
	{
		
		ASVIB.verifyPiCallErrorMessage();
		return this;
	}
	
	public ASVIBAction verifyPiCallErrorMessageConf()
	{
		
		ASVIB.verifyPiCallErrorMessageConf();
		return this;
	}
	
	public ASVIBAction bookAnEngineer(UserProfile userProfile,String strType)
	{
		
		ASVIB.bookAnEngineer(userProfile,strType);
		return this;
	}
	public IBAction bookAnEngineerIB(UserProfile userProfile,String strType)
	{
		
		ASVIB.bookAnEngineer(userProfile,strType);
		return new IBAction();
	}public ASVAction bookAnEngineerASV(UserProfile userProfile,String strType)
	{
		
		ASVIB.bookAnEngineer(userProfile,strType);
		return new ASVAction();
	}
	public BookingCompleteAction bookAnEngineerBook(UserProfile userProfile,String strType)
	{
		
		ASVIB.bookAnEngineer(userProfile,strType);
		return new BookingCompleteAction();
	}
	
	public ASVIBAction navigateToIdentifyFault(UserProfile userProfile)
	{
		
	    ASVIB.navigateToIdentifyFault(userProfile);
	    return this;
		 
	}
	
	public ASVIBAction navigateToReview(int intFlag)
	{
		
		ASVIB.navigateToReview(intFlag);
		return this;
	}
	
	public IBAction navigateToReviewIB(int intFlag)
	{
		
		ASVIB.navigateToReview(intFlag);
		return new IBAction();
	}
	
	public ASVIBAction navigateToConfirmation(UserProfile userProfile,int intOtion)
	{
		
		ASVIB.navigateToConfirmation(userProfile,intOtion);
		return this;
	}
	
	public ASVIBAction accountOverviewBookAnEngineer()
	{
		
		ASVIB.accountOverviewBookAnEngineer();
		return this;
	}
	
	public ASVIBAction navigateTrackCancelChange()
	{
		
		ASVIB.navigateTrackCancelChange();
		return this;
	}
	public ASVIBAction navigateTrackCancelChangeTrack()
	{
		
		ASVIB.navigateTrackCancelChangeTrack();
		return this;
	}
	
	
	public ASVAction navigateTrackCancelChangeASV()
	{
		
		ASVIB.navigateTrackCancelChange();
		return new ASVAction();
	}
	
	public IBAction navigateTrackCancelChangeIB()
	{
		
		ASVIB.navigateTrackCancelChange();
		return new IBAction();
	}
	
	public BookingCompleteAction navigateTrackCancelChangeBook()
	{
		
		ASVIB.navigateTrackCancelChange();
		return new BookingCompleteAction();
	}
	
	public ASVIBAction verifyPrint()
	{
		
		ASVIB.verifyPrint();
		return this;
	}
	
	public ASVIBAction changeAppointment(int intOption)
	{
		
		ASVIB.changeAppointment(intOption);
		return this;
	}
	
	public LandlordPhase2Action changeAppointmentLL(int intOption)
	{
		
		ASVIB.changeAppointment(intOption);
		return new LandlordPhase2Action();
	}
	
	public ASVIBAction viewDetails()
	{
		
		ASVIB.viewDetails();
		return this;
	}
	
	public BookingCompleteAction viewDetailsBook()
	{
		
		ASVIB.viewDetails();
		return new BookingCompleteAction();
	}
	
	public ASVIBAction continueWithASV()
	{
		
		ASVIB.continueWithASV();
		return this;
	}
	
	public IBAction continueWithASVIB()
	{
		
		ASVIB.continueWithASV();
		return new IBAction();
	}
	
	public ASVIBAction accountSummaryChangeAppointment()
	{
		
		ASVIB.accountSummaryChangeAppointment();
		return this;
	}
	
	public IBAction accountSummaryChangeAppointmentIB()
	{
		
		ASVIB.accountSummaryChangeAppointment();
		return new IBAction();
	}
	
	public ServiceAndExperienceAction accountSummaryChangeAppointmentSAE()
	{
		
		ASVIB.accountSummaryChangeAppointment();
		return new ServiceAndExperienceAction();
	}
	
	public ASVIBAction accountSummarycancelAppointment()
	{
		
		ASVIB.accountSummarycancelAppointment();
		return this;
	}
	
	public ASVIBAction accountSummarycancelAppointmentLL()
	{
		new LandlordPhase2Page().continueLandlordOverlay(1, "2Hr");
		ASVIB.accountSummarycancelAppointment();
		return this;
	}
	
	public ASVIBAction logout()
	{
		new AccountOverviewAction().logout();
		return this;
	}
	
	public HomePageAction logoutReturn()
	{
		new AccountOverviewPage().logout();
		return new HomePageAction();
	}
	
	public ASVIBAction verifyErrorMessage()
	{
		ASVIB.verifyErrorMessage();
		return this;
	}
	
	public ASVIBAction navigateToASVFromOverviewPage()
	{
		ASVIB.navigateToASVFromOverviewPage();
		return this;
	}
	
	public ASVIBAction noSlotAvailable()
	{
		ASVIB.noSlotAvailable();
		return this;
	}
	
	public ASVIBAction navigateToViewAllAppointments()
	{
		ASVIB.navigateToViewAllAppointments();
		return this;
	}
	
	public ServiceAndExperienceAction navigateToViewAllAppointmentsSAE()
	{
		ASVIB.navigateToViewAllAppointments();
		return new ServiceAndExperienceAction();
	}
	
	public BookingCompleteAction navigateToViewAllAppointmentsBook()
	{
		ASVIB.navigateToViewAllAppointments();
		return new BookingCompleteAction();
	}
	
	public IBAction navigateToViewAllAppointmentsIB()
	{
		ASVIB.navigateToViewAllAppointments();
		return new IBAction();
	}
	
	public ASVIBAction selectAnAppointment()
	{
		ASVIB.selectAnAppointment();
		return this;
	}
	
	public ASVIBAction selectAnAppointmentBookingCtrlOff()
	{
		ASVIB.selectAnAppointmentBookingCtrlOff();
		return this;
	}
	
	public ASVIBAction accountSummarycancelAppointmentViewDetail()
	{
		ASVIB.accountSummarycancelAppointmentViewDetail();
		return this;
	}	
	
	public ASVIBAction navigateToConfirmation()
	{
		ASVIB.navigateToConfirmation();
		return this;
	}
	
	public ASVIBAction confirmationImageCheck()
	{
		ASVIB.confirmationImageCheck();
		return this;
	}	
	
	public ASVIBAction reviewDetailsPage()
	{
		ASVIB.reviewDetailsPage();
		return this;
	}
	
	public IBAction reviewDetailsPageIB()
	{
		ASVIB.reviewDetailsPage();
		return new IBAction();
	}
	
	public ASVIBAction viewDetailsCompletePage(UserProfile userProfile)
	{
		ASVIB.viewDetailsCompletePage(userProfile);
		return this;
	}	
	
	public ASVIBAction loginUser(UserProfile userProfile)
	{
		ASVIB.loginUser(userProfile);
		return this;
	}
	
	public ASVIBAction navigateToAccountSummaryPage(UserProfile userProfile)
	{
		ASVIB.navigateToAccountSummaryPage(userProfile);
		return this;
	}
	
	public ASVIBAction addCOD(UserProfile userProfile)
	{
		ASVIB.addCOD(userProfile);
		return this;
	}
	
	public ASVIBAction addGAC()
	{
		ASVIB.addGAC();
		return this;
	}
	
	public ASVIBAction clickGAC()
	{
		ASVIB.clickGAC();
		return this;
	}
	
	public ASVIBAction fastTrackASVnavigateToLogin()
	{
		ASVIB.fastTrackASVnavigateToLogin();
		return this;
	}
	public ASVIBAction fastTrackASVLogin()
	{
		ASVIB.fastTrackASVLogin();
		return this;
	}
	public ASVIBAction fastTrackConfirmAddressDetails()
	{
		ASVIB.fastTrackConfirmAddressDetails();
		return this;
	}
	public ASVIBAction fastTrackSelectAppointment()
	{
		ASVIB.fastTrackSelectAppointment();
		return this;
	}
	public ASVIBAction fastTrackReviewPageDetailsAC(UserProfile userProfile)
	{
		ASVIB.fastTrackReviewPageDetails(userProfile);
		return this;
	}
	public ASVIBAction fastTrackConfirmationPage()
	{
		ASVIB.fastTrackConfirmationPage();
		return this;
	}
	public IBAction verifySlot(String strSlotType)
	{
		new IBPage().verifySlot(strSlotType);
		return new IBAction();
	}
	
	public ASVIBAction verifySlotASVIB(String strSlotType)
	{
		new IBPage().verifySlot(strSlotType);
		return new ASVIBAction();
	}
	
	public ASVAction verifySlotASV(String strSlotType)
	{
		new IBPage().verifySlot(strSlotType);
		return new ASVAction();
	}
	public BookingCompleteAction verifySlotBook(String strSlotType)
	{
		new IBPage().verifySlot(strSlotType);
		return new BookingCompleteAction();
	}

}
