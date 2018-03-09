package bg.framework.app.functional.action.reFactoring;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.reFactoring.LandlordPhase2Page;
import bg.framework.app.functional.page.selfServe.ASVIBPage;

public class LandlordPhase2Action {

	public IBAction continueLandlord()
	{
		new LandlordPhase2Page().continueLandlord();
		return new IBAction();
	}
	
	public ServiceAndExperienceAction verifyAddressSAE(UserProfile userProfile)
	{
		new ASVIBPage().verifyAddress(userProfile);
		return new ServiceAndExperienceAction();
	}
	public IBAction verifyAddressIB(UserProfile userProfile)
	{
		new ASVIBPage().verifyAddress(userProfile);
		return new IBAction();
	}
	
	public LandlordPhase2Action continueLandlordOverlay(int intOption, String slotType)
	{
		new LandlordPhase2Page().continueLandlordOverlay(intOption,slotType);
		return new LandlordPhase2Action();
	}
	
	public IBAction verifyInstallationText()
	{
		new LandlordPhase2Page().verifyInstallationText();
		return new IBAction();
	}
	
	public IBAction verifyReviewAppText()
	{
		new LandlordPhase2Page().verifyReviewAppText();
		return new IBAction();
	}
	
	public IBAction verifyReviewAppTextHeating()
	{
		new LandlordPhase2Page().verifyReviewAppTextHeating();
		return new IBAction();
	}
}
