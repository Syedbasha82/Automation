package bg.framework.app.functional.action.reFactoring;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.selfServe.ASVIBAction;
import bg.framework.app.functional.action.selfServe.AccountOverviewAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.reFactoring.BookingCompletePage;
import bg.framework.app.functional.page.reFactoring.IBPage;
import bg.framework.app.functional.page.selfServe.ASVIBPage;
import bg.framework.app.functional.page.selfServe.AccountOverviewPage;

public class BookingCompleteAction {
	
	public BookingCompleteAction verifyAccountOverview(String strStatus)
	{
		new IBPage().verifyAccountOverview(strStatus);
		return new BookingCompleteAction();
	}	
	
	public BookingCompleteAction firstAvailableSlot(UserProfile userProfile)
	{
		new IBPage().firstAvailableSlot(userProfile);
		return new BookingCompleteAction();
	}
	
	public BookingCompleteAction verifyLinkNavigation(String strType)
	{
		new IBPage().verifyLinkNavigation(strType);
		return new BookingCompleteAction();
	}
	
	public ASVIBAction verifyAccountOverviewASV(String strStatus)
	{
		new IBPage().verifyAccountOverview(strStatus);
		return new ASVIBAction();
	}
	
	public BookingCompleteAction clickBookThisAppointment(UserProfile userProfile,String strType)
	{
		new ASVIBPage().bookAnEngineer(userProfile, strType);
		return new BookingCompleteAction();
	}
	
	public BookingCompleteAction GACReviewDetails()
	{
		new ASVIBPage().reviewDetailsPage();
		return new BookingCompleteAction();
	}
	public BookingCompleteAction viewDetailsCompletePage(UserProfile userProfile)
	{
		new ASVIBPage().viewDetailsCompletePage(userProfile);
		return new BookingCompleteAction();
	}
	
	
	public BookingCompleteAction addGAC()
	{
		new ASVIBPage().addGAC();
		return new BookingCompleteAction();
	}
	
	public IBAction navigateBack()
	{
		new IBPage().navigateBack();
		return new IBAction();
	}
	
	public BookingCompleteAction addCOD(UserProfile userProfile)
	{
		new ASVIBPage().addCOD(userProfile);
		return new BookingCompleteAction();
	}
	
	public BookingCompleteAction  navigateToViewAllAppointments()
	{
		new ASVIBPage().navigateToViewAllAppointments();
		return new BookingCompleteAction();
	}
	
	public ServiceAndExperienceAction  navigateToViewAllAppointmentsSAE()
	{
		new ASVIBPage().navigateToViewAllAppointments();
		return new ServiceAndExperienceAction();
	}
	
	public IBAction  navigateToViewAllAppointmentsIB()
	{
		new ASVIBPage().navigateToViewAllAppointments();
		return new IBAction();
	}
	
	public BookingCompleteAction  selectAnAppointment()
	{
		new ASVIBPage().selectAnAppointment();
		return new BookingCompleteAction();
	}
	public ASVIBAction verifyErrorMessage() {  	  
	     new ASVIBPage().verifyErrorMessage();
	 return new ASVIBAction();
	}
	
	public BookingCompleteAction  selectAnAppointmentBookingCtrlOff()
	{
		new ASVIBPage().selectAnAppointmentBookingCtrlOff();
		return new BookingCompleteAction();
	}
	
	public IBAction  selectAnAppointmentBookingCtrlOffIB()
	{
		new ASVIBPage().selectAnAppointmentBookingCtrlOff();
		return new IBAction();
	}
	
	public BookingCompleteAction  reviewDetailsPage()
	{
		new ASVIBPage().reviewDetailsPage();
		return new BookingCompleteAction();
	}
	
	public BookingCompleteAction navigateToConfirmation()
	{
		new ASVIBPage().navigateToConfirmation();
		return new BookingCompleteAction();
	}
	
	public BookingCompleteAction verifyPiCallErrorMessage()
	{
		new ASVIBPage().verifyPiCallErrorMessage();
		return new BookingCompleteAction();
	}
	
	public BookingCompleteAction confirmationImageCheck()
	{
		new ASVIBPage().confirmationImageCheck();
		return new BookingCompleteAction();
	}
	
	public BookingCompleteAction accountSummarycancelAppointment()
	{
		new ASVIBPage().accountSummarycancelAppointment();
		return new BookingCompleteAction();
	}	
	
	public IBAction accountSummarycancelAppointmentIB()
	{
		new ASVIBPage().accountSummarycancelAppointment();
		return new IBAction();
	}	
	
	public BookingCompleteAction accountSummarycancelAppointmentViewDetail()
	{
		new ASVIBPage().accountSummarycancelAppointmentViewDetail();
		return new BookingCompleteAction();
	}	
	public BookingCompleteAction navigateTrackCancelChange()
	{
		new ASVIBPage().navigateTrackCancelChange();
		return new BookingCompleteAction();
	}
	
	public IBAction navigateTrackCancelChangeIB()
	{
		new ASVIBPage().navigateTrackCancelChange();
		return new IBAction();
	}
	
	public ASVIBAction navigateTrackCancelChangeASV()
	{
		new ASVIBPage().navigateTrackCancelChange();
		return new ASVIBAction();
	}
		
	public BookingCompleteAction navigateToIdentifyFault(UserProfile userProfile)
	{
		new ASVIBPage().navigateToIdentifyFault(userProfile);
		return new BookingCompleteAction();
	}	
	
	public BookingCompleteAction navigateToReview(int intOption)
	{
		new ASVIBPage().navigateToReview(intOption);
		return new BookingCompleteAction();
	}
	
	public BookingCompleteAction navigateToReviewBook(int intFlag)
	{
		
		new ASVIBPage().navigateToReview(intFlag);
		return new BookingCompleteAction();
	}
	
	public BookingCompleteAction selectFirstAvailableSlot()
	{
		new IBPage().selectFirstAvailableSlot();
		return new BookingCompleteAction();
	}
	
	public IBAction continueWithASV()
	{
		new ASVIBPage().continueWithASV();
		return new IBAction();
	}
	
	public IBAction navigateToReviewIB(int intOption)
	{
		new ASVIBPage().navigateToReview(intOption);
		return new IBAction();
	}
	
	public ASVAction navigateToReviewASV(int intOption)
	{
		new ASVIBPage().navigateToReview(intOption);
		return new ASVAction();
	}	
	
	public BookingCompleteAction navigateToIdentifyFault(int intOption,UserProfile userProfile)
	{
		new IBPage().navigateToIdentifyFault(intOption,userProfile);
		return new BookingCompleteAction();
	}
	
	public BookingCompleteAction navigatePriorityPageASV(int intOption)
	{
		new IBPage().navigatePriorityPage(intOption);
		return new BookingCompleteAction();
	}
	
	public IBAction navigatePriorityPageIB(int intOption)
	{
		new IBPage().navigatePriorityPage(intOption);
		return new IBAction();
	}
	
	public IBAction verifyAddressIB(UserProfile userProfile)
	{
		new ASVIBPage().verifyAddress(userProfile);
		return new IBAction();
	}
	
	public ASVIBAction verifyAddressASV(UserProfile userProfile)
	{
		new ASVIBPage().verifyAddress(userProfile);
		return new ASVIBAction();
	}
	
	public BookingCompleteAction verifyAddressBook(UserProfile userProfile)
	{
		new ASVIBPage().verifyAddress(userProfile);
		return new BookingCompleteAction();
	}
	
	public ASVIBAction navigatePriorityPageASVIB(int intOption)
	{
		new IBPage().navigatePriorityPage(intOption);
		return new ASVIBAction();
	}
	
	
	public BookingCompleteAction clickGAC()
	{
		new ASVIBPage().clickGAC();
		return new BookingCompleteAction();
	}
	
	public BookingCompleteAction navigateToConfirmation(UserProfile userProfile, int intOption)
	{
		new ASVIBPage().navigateToConfirmation(userProfile,intOption);
		return new BookingCompleteAction();
	}
	
	public BookingCompleteAction bookAnEngineer(UserProfile userProfile,String strType)
	{
		
		new ASVIBPage().bookAnEngineer(userProfile,strType);
		return new BookingCompleteAction();
	}
	
	public ASVAction bookAnEngineerASV(UserProfile userProfile,String strType)
	{
		
		new ASVIBPage().bookAnEngineer(userProfile,strType);
		return new ASVAction();
	}
	
	public IBAction bookAnEngineerIB(UserProfile userProfile,String strType)
	{
		
		new ASVIBPage().bookAnEngineer(userProfile,strType);
		return new IBAction();
	}
	
	public LandlordPhase2Action bookAnEngineerLL(UserProfile userProfile,String strType)
	{
		
		new ASVIBPage().bookAnEngineer(userProfile,strType);
		return new LandlordPhase2Action();
	}
	
	public BookingCompleteAction changeAppointment(int intOption)
	{
		
		new ASVIBPage().changeAppointment(intOption);
		return new BookingCompleteAction();
	}
	
	public IBAction changeAppointmentIB(int intOption)
	{
		
		new ASVIBPage().changeAppointment(intOption);
		return new IBAction();
	}
	
	public void logout()
	{
		new AccountOverviewAction().logout();		
	}
	public HomePageAction logoutReturn()
	{
		new AccountOverviewPage().logout();		
		return new HomePageAction();
	}
	
	public ServiceAndExperienceAction verifyAddressSAE(UserProfile userProfile) {
		new IBPage().verifyAddress(userProfile);
		return new ServiceAndExperienceAction();
	}
}
