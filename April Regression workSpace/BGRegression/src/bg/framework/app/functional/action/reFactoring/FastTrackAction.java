package bg.framework.app.functional.action.reFactoring;

import bg.framework.app.functional.action.selfServe.ASVIBAction;
import bg.framework.app.functional.action.selfServe.AccountOverviewAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.reFactoring.FastTrackPage;
import bg.framework.app.functional.page.reFactoring.IBPage;
import bg.framework.app.functional.page.selfServe.ASVIBPage;


public class FastTrackAction {
	
	public FastTrackAction navigateToFastTrackPage()
	{
		FastTrackPage FastTrack = new FastTrackPage();
		FastTrack.navigateToFastTrackPage();
		return this;
	}
	
	
	public FastTrackAction fastTrackASVLogin(UserProfile userProfile)
	{
		FastTrackPage FastTrack = new FastTrackPage();
		FastTrack.fastTrackASVLogin(userProfile);
		return this;
	}
	
	public FastTrackAction verifyAddress(UserProfile userProfile)
	{
		IBPage ibPage = new IBPage();
		ibPage.verifyAddress(userProfile);
		return this;
	}
	
	public FastTrackAction fastTrackConfirmAddressDetails(UserProfile userProfile)
	{
		FastTrackPage FastTrack = new FastTrackPage();
		FastTrack.fastTrackConfirmAddressDetails(userProfile);
		return this;
	}
	
	public ServiceAndExperienceAction fastTrackConfirmAddressDetailsSAE(UserProfile userProfile)
	{
		FastTrackPage FastTrack = new FastTrackPage();
		FastTrack.fastTrackConfirmAddressDetails(userProfile);
		return new ServiceAndExperienceAction();
	}
	
	public FastTrackAction fastTrackSelectAppointment(String strSlotType)
	{
		FastTrackPage FastTrack = new FastTrackPage();
		FastTrack.fastTrackSelectAppointment(strSlotType);
		return this;
	}
	public FastTrackAction fastTrackReviewPageDetailsAC(UserProfile userProfile)
	{
		FastTrackPage FastTrack = new FastTrackPage();
		FastTrack.fastTrackReviewPageDetails(userProfile);
		return this;
	}
	public FastTrackAction checkErrorMsgForInvalidDetails()
	{
		FastTrackPage FastTrack = new FastTrackPage();
		FastTrack.checkErrorMsgForInvalidDetails();
		return this;
	}
	public IBAction fastTrackReviewPageDetailsACIB(UserProfile userProfile)
	{
		FastTrackPage FastTrack = new FastTrackPage();
		FastTrack.fastTrackReviewPageDetails(userProfile);
		return new IBAction();
	}
	public FastTrackAction fastTrackConfirmationPage()
	{
		FastTrackPage FastTrack = new FastTrackPage();
		FastTrack.fastTrackConfirmationPage();
		return this;
	}
	
	public ASVIBAction fastTrackConfirmationPageAsv()
	{
		FastTrackPage FastTrack = new FastTrackPage();
		FastTrack.fastTrackConfirmationPage();
		return new ASVIBAction();
	}
	
	public FastTrackAction verifyNA2Message()
	{
		FastTrackPage FastTrack = new FastTrackPage();
		FastTrack.verifyNA2Message();
		return this;
	}
	
	public FastTrackAction fastTrackNavigateToConfirmation()
	{
		FastTrackPage FastTrack = new FastTrackPage();
		FastTrack.fastTrackNavigateToConfirmation();
		return this;
	}
	
	public FastTrackAction loginUserDetails(UserProfile userProfile)
	{
		FastTrackPage FastTrack = new FastTrackPage();
		FastTrack.loginUser(userProfile);
		return this;
	}
	
	public FastTrackAction navigateToAccountSummaryPage(UserProfile userProfile)
	{
		FastTrackPage FastTrack = new FastTrackPage();
		FastTrack.navigateToAccountSummaryPage(userProfile);
		return this;
	}
	
	public FastTrackAction verifyWorkReq(String strWorkReq)
	{
		FastTrackPage FastTrack = new FastTrackPage();
		FastTrack.verifyWorkReq(strWorkReq);
		return this;
	}
	
	public FastTrackAction accountSummarycancelAppointment()
	{
		FastTrackPage FastTrack = new FastTrackPage();
		FastTrack.accountSummarycancelAppointment();
		return this;
	}
	
	public FastTrackAction addCOD(UserProfile userProfile)
	{
		FastTrackPage FastTrack = new FastTrackPage();
		FastTrack.addCOD(userProfile);
		return this;
	}	
	public FastTrackAction confirmButton()
	{
		FastTrackPage FastTrack = new FastTrackPage();
		FastTrack.confirmButton();
		return this;
	}	
	
	public FastTrackAction fastTrackOneClickRegistrationPage(UserProfile userProfile)
	{
		FastTrackPage FastTrack = new FastTrackPage();
		FastTrack.fastTrackOneClickRegistrationPage(userProfile);
		return this;
	}
	public FastTrackAction addGAC()
	{		
		FastTrackPage FastTrack = new FastTrackPage();
		FastTrack.addGAC();
		return this;
	}	
	
	public FastTrackAction selectNoAppointment(String strType)
	{		
		IBAction ibaction = new IBAction();
		ibaction.selectNoAppointment(strType);
		return this;
	}
	
	public FastTrackAction logout()
	{
		new AccountOverviewAction().logout();
		return this;
	}
	
	public FastTrackAction verifyBookedSlotPage()
	{
		FastTrackPage FastTrack = new FastTrackPage();
		FastTrack.verifyBookedSlotPage();
		return this;
	}
	public FastTrackAction verifyAppointmentSelectionCalender()
    {
          FastTrackPage FastTrack = new FastTrackPage();
          FastTrack.verifyAppointmentSelectionCalender();
          return this;
    }



	public FastTrackAction  navigateToLoginPage()
    {
          FastTrackPage FastTrack = new FastTrackPage();
          FastTrack.navigateToLoginPage();
          return this;
    }


   public FastTrackAction verifyAppointmentSectioninAccountOverview(UserProfile userProfile) {
	       FastTrackPage FastTrack = new FastTrackPage();
	       FastTrack.verifyAppointmentSectioninAccountOverview(userProfile);
	       return new FastTrackAction();
	}
  public FastTrackAction navigateToAccountSummaryPageviaAppointmentLink() {
		    FastTrackPage FastTrack = new FastTrackPage();
		    FastTrack.navigateToAccountSummaryPageviaAppointmentLink();
		    return new FastTrackAction();
	}
  public FastTrackAction verifyAppointmentSectioninAccountSummary() {
      FastTrackPage FastTrack = new FastTrackPage();
      FastTrack.verifyAppointmentSectioninAccountSummary();
      return new FastTrackAction();
}

  public FastTrackAction verifySlotDates() {
      FastTrackPage FastTrack = new FastTrackPage();
            FastTrack.verifySlotDates();
        return new FastTrackAction();
    }
  public FastTrackAction AgainChooseApoitmnet() {
      FastTrackPage FastTrack = new FastTrackPage();
            FastTrack.AgainChooseApoitmnet();
        return new FastTrackAction();
    }
  public FastTrackAction ClickAccountSummary() {
      FastTrackPage FastTrack = new FastTrackPage();
            FastTrack.ClickAccountSummary();
        return new FastTrackAction();
    }
  public FastTrackAction ClickCancelbutton() {
      FastTrackPage FastTrack = new FastTrackPage();
            FastTrack.ClickCancelbutton();
        return new FastTrackAction();
    }

}
