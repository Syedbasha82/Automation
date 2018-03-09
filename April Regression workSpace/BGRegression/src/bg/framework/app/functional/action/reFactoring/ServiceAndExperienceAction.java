package bg.framework.app.functional.action.reFactoring;

import java.util.ArrayList;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.reFactoring.ServiceAndExperiencePage;

public class ServiceAndExperienceAction {

	public ServiceAndExperienceAction navigateToASV2HrSlot(UserProfile userProfile)
	{
		new ServiceAndExperiencePage().navigateToASV2HrSlot(userProfile);
		return new ServiceAndExperienceAction();
	}
	
	public IBAction navigateToASV2HrSlotIB(UserProfile userProfile)
	{
		new ServiceAndExperiencePage().navigateToASV2HrSlot(userProfile);
		return new IBAction();
	}
	
	public ServiceAndExperienceAction navigateToASVStdSlot(UserProfile userProfile)
	{
		new ServiceAndExperiencePage().navigateToASVStdSlot(userProfile);
		return new ServiceAndExperienceAction();
	}
	
	public IBAction navigateToASVStdSlotIB(UserProfile userProfile)
	{
		new ServiceAndExperiencePage().navigateToASVStdSlot(userProfile);
		return new IBAction();
	}
	public ServiceAndExperienceAction selectThisAppointment(String strSlotType)
	{
		new ServiceAndExperiencePage().selectThisAppointment(strSlotType);
		return new ServiceAndExperienceAction();
	}
	public ServiceAndExperienceAction selectSlotType(String strSlotType)
	{
		new ServiceAndExperiencePage().selectSlotType(strSlotType);
		return new ServiceAndExperienceAction();
	}
	public ServiceAndExperienceAction selectAnAppointmentStd(String strSlotType)
	{
		new ServiceAndExperiencePage().selectAnAppointmentStd(strSlotType);
		return new ServiceAndExperienceAction();
	}
	
	public FastTrackAction selectAnAppointmentStdFastTrack(String strSlotType)
	{
		new ServiceAndExperiencePage().selectAnAppointmentStd(strSlotType);
		return new FastTrackAction();
	}
	
	public IBAction selectAnAppointmentStdIB(String strSlotType)
	{
		new ServiceAndExperiencePage().selectAnAppointmentStd(strSlotType);
		return new IBAction();
	}
	
	public LandlordPhase2Action selectAnAppointmentStdLL(String strSlotType)
	{
		new ServiceAndExperiencePage().selectAnAppointmentStd(strSlotType);
		return new LandlordPhase2Action();
	}
	public ServiceAndExperienceAction selectAnAppointment2Hr(String strSlotType)
	{
		new ServiceAndExperiencePage().selectAnAppointment2Hr(strSlotType);
		return new ServiceAndExperienceAction();
	}
	public LandlordPhase2Action selectAnAppointment2HrLL(String strSlotType)
	{
		new ServiceAndExperiencePage().selectAnAppointment2Hr(strSlotType);
		return new LandlordPhase2Action();
	}
	
	public IBAction selectAnAppointment2HrIB(String strSlotType)
	{
		new ServiceAndExperiencePage().selectAnAppointment2Hr(strSlotType);
		return new IBAction();
	}
	
	public IBAction selectAnAppointment2HrWeekend(String strSlotType)
	{
		new ServiceAndExperiencePage().selectAnAppointment2HrWeekend(strSlotType);
		return new IBAction();
	}
	
	public IBAction selectAnAppointmentStdWeekend(String strSlotType)
	{
		new ServiceAndExperiencePage().selectAnAppointmentStdWeekend(strSlotType);
		return new IBAction();
	}
	
	public ServiceAndExperienceAction verifyCalendarPageSAE()
	{
		new ServiceAndExperiencePage().verifyCalendarPage();
		return new ServiceAndExperienceAction();
	}
	
	public IBAction verifyCalendarPage()
	{
		new ServiceAndExperiencePage().verifyCalendarPage();
		return new IBAction();
	}
	
	public ServiceAndExperienceAction selectFirstAvailable2Hr()
	{
		new ServiceAndExperiencePage().selectFirstAvailable2Hr();
		return new ServiceAndExperienceAction();
	}
	
	public LandlordPhase2Action selectFirstAvailable2HrLL()
	{
		new ServiceAndExperiencePage().selectFirstAvailable2Hr();
		return new LandlordPhase2Action();
	}
	public IBAction selectFirstAvailable2HrIB()
	{
		new ServiceAndExperiencePage().selectFirstAvailable2Hr();
		return new IBAction();
	}
	public ServiceAndExperienceAction selectFirstAvailableStd()
	{
		new ServiceAndExperiencePage().selectFirstAvailableStd();
		return new ServiceAndExperienceAction();
	}
	public LandlordPhase2Action selectFirstAvailableStdLL()
	{
		new ServiceAndExperiencePage().selectFirstAvailableStd();
		return new LandlordPhase2Action();
	}
	
	public IBAction selectFirstAvailableStdIB()
	{
		new ServiceAndExperiencePage().selectFirstAvailableStd();
		return new IBAction();
	}
	
	public IBAction verifyErrorMessage(ArrayList<String> errList)
	{
		new ServiceAndExperiencePage().errorMessage(errList);
		return new IBAction();
	}
	
	public IBAction selectNoAppointment(String strSlotType)
	{
		new ServiceAndExperiencePage().selectNoAppointmentStd(strSlotType);
		return new IBAction();
	}
}
