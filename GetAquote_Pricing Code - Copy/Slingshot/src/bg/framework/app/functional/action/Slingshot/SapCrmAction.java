package bg.framework.app.functional.action.Slingshot;
import java.text.ParseException;
import bg.framework.app.functional.entities.CrmUserProfile;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.Slingshot.SapCrmPage;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.entities.UserProfile;

public class SapCrmAction extends BasePage {   

	public SapCrmAction loginDetails(CrmUserProfile crmuserProfile){
		SapCrmPage sapcrmpage=new SapCrmPage();
		sapcrmpage.openCRMUrl();
		sapcrmpage.enterLoginDetails(crmuserProfile);
		sapcrmpage.verifyAndClickLoginContinue();
		return this;
	}
	public SapCrmAction fetchDetails(CrmUserProfile crmuserProfile){
		SapCrmPage sapcrmpage=new SapCrmPage();
		sapcrmpage.fetchDetailsandInsert(crmuserProfile);
		return this;
	}
	public SapCrmAction searchByAccountId(CrmUserProfile crmuserProfile, UserProfile userProfile){
		SapCrmPage sapcrmpage=new SapCrmPage();
		sapcrmpage.searchCrmFields(crmuserProfile,userProfile);
		return this;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////
	public SapCrmAction loginDetails1(UserProfile userProfile){
		SapCrmPage sapcrmpage=new SapCrmPage();		
		sapcrmpage.AddnewUser_CrmVerification(userProfile);		
		return this;
	}
	
	public SapCrmAction searchCrmFieldsVerification(CrmUserProfile crmuserProfile, UserProfile userProfile){
		SapCrmPage sapcrmpage=new SapCrmPage();
		sapcrmpage.searchCrmFieldsVerification(crmuserProfile,userProfile);
		return this;
	}
	public SapCrmAction verifyPaperLessStatus(CrmUserProfile crmuserProfile, UserProfile userProfile){
		SapCrmPage sapcrmpage=new SapCrmPage();
		sapcrmpage.verifyPaperLessStatus(crmuserProfile, userProfile);
		return this;
	}
	public SapCrmAction verifyReminderAlertAndCRMStatus(CrmUserProfile crmuserProfile, UserProfile userProfile){
		SapCrmPage sapcrmpage=new SapCrmPage();
		sapcrmpage.verifyReminderAlertStatus(crmuserProfile);
		sapcrmpage.verifyDetailsUpdation(crmuserProfile);
		return this;
	}
	public SapCrmAction verify1YearFixedRate(CrmUserProfile crmuserProfile, UserProfile userProfile) throws ParseException{
		SapCrmPage sapcrmpage=new SapCrmPage();
		sapcrmpage.verify1YearFixedRate(crmuserProfile);
		return this;
	}
	public SapCrmAction loginDetailsforpaperbilling(CrmUserProfile crmuserProfile){
		SapCrmPage sapcrmpage=new SapCrmPage();		
		sapcrmpage.openCRMUrl();
		sapcrmpage.enterLoginDetails(crmuserProfile);
	//	sapcrmpage.verifyAndClickLoginContinue();
		return this;
	}
	public SapCrmAction SearchCRMFields_MPD(CrmUserProfile crmuserProfile, UserProfile userProfile){
		SapCrmPage sapcrmpage=new SapCrmPage();
		sapcrmpage.SearchCRMFields_MPD(crmuserProfile,userProfile);
		return this;
	}
	/*public SapCrmAction SearchCRMFields_GAQ(CrmUserProfile crmuserProfile, UserProfile userProfile){
		SapCrmPage sapcrmpage=new SapCrmPage();
		sapcrmpage.GetaQuote_CRM(crmuserProfile,userProfile);
		return this;
	}*/
	
}
