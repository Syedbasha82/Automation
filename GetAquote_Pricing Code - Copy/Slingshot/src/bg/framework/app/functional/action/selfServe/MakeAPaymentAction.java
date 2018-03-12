package bg.framework.app.functional.action.selfServe;

import bg.framework.app.functional.entities.MakeAPaymentProfile;
import bg.framework.app.functional.page.selfServe.MakeAPaymentPage;

public class MakeAPaymentAction {
	private MakeAPaymentProfile makeAPaymentProfile;
	
	public MakeAPaymentAction(MakeAPaymentProfile makeAPaymentProfile) {
        this.makeAPaymentProfile = makeAPaymentProfile;
    }

    public MakeAPaymentAction() {
    	
    }
    MakeAPaymentPage makeAPaymentPage = new MakeAPaymentPage();
    public MakeAPaymentAction loginMakeAPayment(MakeAPaymentProfile makeAPaymentProfile,String strAccountType){    	
    	makeAPaymentPage.loginMakeAPayment(makeAPaymentProfile,strAccountType);
    	return this;
    }
    
    public MakeAPaymentAction navigateToMakeAPayment(MakeAPaymentProfile makeAPaymentProfile,String strAccountType){    	
    	makeAPaymentPage.navigateToMakeAPayment(makeAPaymentProfile,strAccountType);
    	return this;
    }

    public MakeAPaymentAction selectAccountToMakeAPayment(MakeAPaymentProfile makeAPaymentProfile,String strAccountType){    	
    	makeAPaymentPage.selectAccountToMakeAPayment(makeAPaymentProfile,strAccountType);
    	return this;
    }
    
    public MakeAPaymentAction enterDetailsToMakeAPayment(MakeAPaymentProfile makeAPaymentProfile){    	
    	makeAPaymentPage.enterDetailsToMakeAPayment(makeAPaymentProfile);
    	return this;
    }
    public MakeAPaymentAction ConfirmSecurityCheck(MakeAPaymentProfile makeAPaymentProfile){    	
    	makeAPaymentPage.ConfirmSecurityCheck(makeAPaymentProfile);
    	return this;
    }
}
