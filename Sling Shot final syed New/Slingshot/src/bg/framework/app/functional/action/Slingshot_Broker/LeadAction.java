package bg.framework.app.functional.action.Slingshot_Broker;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.Slingshot_Broker.LeadPage;

public class LeadAction {
	LeadPage leadPage = new LeadPage();
	
	public LeadAction verifyAndClickLeadLink(){
		LeadPage leadPage = new LeadPage();
		leadPage.clickLeadLink();
		return this;
	}
	public LeadAction loginLeadBroker(UserProfile userProfile){		
		leadPage.loginLeadBroker(userProfile);
		return this;
	}
	public LeadAction verifyLeadPage(){		
		leadPage.verifyLeadPage();
		return this;
	}
	public LeadAction verifyCreateNewLead(UserProfile userProfile){		
		leadPage.verifyCreateNewLead(userProfile);
		return this;
	}
	public LeadAction verifyConfirmation(){		
		leadPage.verifyConfirmation();
		return this;
	}
	public LeadAction verifyAudits(UserProfile userProfile){		
		leadPage.verifyAudits(userProfile);
		return this;
	}
	public LeadAction verifyViewLead(UserProfile userProfile){		
		leadPage.verifyViewLead("",userProfile);
		return this;
	}
	public LeadAction verifyEditLead(){		
		leadPage.verifyEditLead();
		return this;
	}
	public LeadAction verifyAmendLeadAudit(UserProfile userProfile){		
		leadPage.verifyAmendLeadAudit(userProfile);
		return this;
	}
	
}
