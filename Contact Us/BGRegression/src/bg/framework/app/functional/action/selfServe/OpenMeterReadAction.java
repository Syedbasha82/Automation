package bg.framework.app.functional.action.selfServe;

import bg.framework.app.functional.page.selfServe.OpenMeterReadPage;
import bg.framework.app.functional.entities.UserProfile;

public class OpenMeterReadAction {

	
	public OpenMeterReadAction navigateToLoginSSO()
	{
		new OpenMeterReadPage().navigatetoLoginSSO();
		return new OpenMeterReadAction();
	}
	
	public OpenMeterReadAction loginSSO(UserProfile userProfile) {
		new OpenMeterReadPage().loginSSO(userProfile);
		return new OpenMeterReadAction();
	}
	
	public OpenMeterReadAction navigateToSubmitMeterRead()
	{
		new OpenMeterReadPage().navigateToSubmitMeterRead();
		return new OpenMeterReadAction();
	}
	
	public OpenMeterReadAction navigateToSubmitOpenReading()
	{
		new OpenMeterReadPage().navigateToSubmitOpenReading();
		return new OpenMeterReadAction();
	}
	
	
	public OpenMeterReadAction fillGasMeterRead()
	{
		new OpenMeterReadPage().fillGasMeterRead();
		return new OpenMeterReadAction();
	}
	
	public OpenMeterReadAction verifyWithOnlineDB(UserProfile userProfile)
	{
		new OpenMeterReadPage().verifyWithOnlineDB(userProfile);
		return new OpenMeterReadAction();
	}
	
	public void logout()
	{
		new OpenMeterReadPage().logout();
	}
	
}
