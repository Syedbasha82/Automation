package bg.framework.app.functional.action.selfServe;


import bg.framework.app.functional.entities.MakeAPaymentProfile;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.selfServe.MakeAPaymentPage;
import bg.framework.app.functional.page.selfServe.MakeAPaymentPageNew;

public class MakeAPaymentActionNew {
	private MakeAPaymentProfile makeAPaymentProfile;
	
	public MakeAPaymentActionNew(MakeAPaymentProfile makeAPaymentProfile) {
        this.makeAPaymentProfile = makeAPaymentProfile;
    }

    public MakeAPaymentActionNew() {
    	
    }
    MakeAPaymentPageNew makeAPaymentPage = new MakeAPaymentPageNew();
    
    public MakeAPaymentActionNew makeAPaymentJourney(UserProfile userProfile, int cardtype){    	
    	makeAPaymentPage.makeAPaymentJourney(makeAPaymentProfile,cardtype);
    	return this;
    }
    
}
