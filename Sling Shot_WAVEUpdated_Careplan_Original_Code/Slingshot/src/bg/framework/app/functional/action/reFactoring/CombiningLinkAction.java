package bg.framework.app.functional.action.reFactoring;

import bg.framework.app.functional.action.selfServe.ASVIBAction;
import bg.framework.app.functional.action.selfServe.AccountOverviewAction;
import bg.framework.app.functional.entities.UserProfile;

public class CombiningLinkAction {
	public CombiningLinkAction verifyAccountOverview()
	{
		return new CombiningLinkAction();
	}
	
	public CombiningLinkAction clickBookThisAppointment(UserProfile userProfile,String strType)
	{
		new ASVIBAction().bookAnEngineer(userProfile, strType);
		return new CombiningLinkAction();
	}
	
	public CombiningLinkAction GACReviewDetails()
	{
		new ASVIBAction().reviewDetailsPage();
		return new CombiningLinkAction();
	}
	
	public CombiningLinkAction addGAC()
	{
		new ASVIBAction().addGAC();
		return new CombiningLinkAction();
	}
	
	public CombiningLinkAction  navigateToViewAllAppointments()
	{
		new ASVIBAction().navigateToViewAllAppointments();
		return new CombiningLinkAction();
	}
	
	public CombiningLinkAction  selectAnAppointment()
	{
		new ASVIBAction().selectAnAppointment();
		return new CombiningLinkAction();
	}
	
	public CombiningLinkAction  reviewDetailsPage()
	{
		new ASVIBAction().reviewDetailsPage();
		return new CombiningLinkAction();
	}
	
	public CombiningLinkAction navigateToConfirmation()
	{
		new ASVIBAction().navigateToConfirmation();
		return new CombiningLinkAction();
	}
	
	
	public CombiningLinkAction accountSummarycancelAppointment()
	{
		new ASVIBAction().accountSummarycancelAppointment();
		return new CombiningLinkAction();
	}	
	
	
	public CombiningLinkAction navigateTrackCancelChange()
	{
		new ASVIBAction().navigateTrackCancelChange();
		return new CombiningLinkAction();
	}	
		
	public CombiningLinkAction navigateToIdentifyFault()
	{
		new ASVIBAction().navigateToIdentifyFault();
		return new CombiningLinkAction();
	}	
	
	public CombiningLinkAction navigateToReview(int intOption)
	{
		new ASVIBAction().navigateToReview(intOption);
		return new CombiningLinkAction();
	}	
	
	public CombiningLinkAction clickGAC()
	{
		new ASVIBAction().clickGAC();
		return new CombiningLinkAction();
	}
	
	public CombiningLinkAction navigateToConfirmation(UserProfile userProfile, int intOption)
	{
		new ASVIBAction().navigateToConfirmation(userProfile,intOption);
		return new CombiningLinkAction();
	}
	
	public CombiningLinkAction bookAnEngineer(UserProfile userProfile,String strType)
	{
		
		new ASVIBAction().bookAnEngineer(userProfile,strType);
		return new CombiningLinkAction();
	}
	
	public CombiningLinkAction changeAppointment(int intOption)
	{
		
		new ASVIBAction().changeAppointment(intOption);
		return new CombiningLinkAction();
	}
	
	public void logout()
	{
		new AccountOverviewAction().logout();		
	}	

}
