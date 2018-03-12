package bg.framework.app.functional.action.reFactoring;

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
}
