package bg.framework.app.functional.action.reFactoring;

import bg.framework.app.functional.action.selfServe.ASVIBAction;
import bg.framework.app.functional.action.selfServe.AccountOverviewAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.reFactoring.FastTrackPage;
import bg.framework.app.functional.page.reFactoring.IBPage;
import bg.framework.app.functional.page.selfServe.ASVIBPage;


public class FastTrackAction {
	
	
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

}
