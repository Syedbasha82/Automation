package bg.framework.app.functional.action.selfServe;

import bg.framework.app.functional.page.selfServe.SSOCRMstatusPage;

public class SSOCRMstatusAction {

		public SSOCRMstatusAction verifySSOAcquisitionRejection(){
			new SSOCRMstatusPage().verifySSOAcquisitionRejection();
			return this;
		}
		
		public SSOCRMstatusAction loginSSOErrorValidation(){
			new SSOCRMstatusPage().loginSSOErrorValidation();
			return this;
		}
		
		public SSOCRMstatusAction verifySSOMeterReadOpen(){
			new SSOCRMstatusPage().verifySSOMeterReadOpen();
			return this;
		}
		
		public SSOCRMstatusAction verifySSOPendingSecurityDeposit(){
			new SSOCRMstatusPage().verifySSOPendingSecurityDeposit();
			return this;
		}
		
		public SSOCRMstatusAction verifySSOAcquisitionSent(){
			new SSOCRMstatusPage().verifySSOAcquisitionSent();
			return this;
		}
		
		public SSOCRMstatusAction verifySSOObjectionRaised(){
			new SSOCRMstatusPage().verifySSOObjectionRaised();
			return this;
		}
		
		public SSOCRMstatusAction verifySSOObjectionwindowOpen(){
			new SSOCRMstatusPage().verifySSOObjectionwindowOpen();
			return this;
		}
		
		public SSOCRMstatusAction verifySSOPendingCooloff(){
			new SSOCRMstatusPage().verifySSOPendingCooloff();
			return this;
		}
		
		public SSOCRMstatusAction verifySSOSubmitted(){
			new SSOCRMstatusPage().verifySSOSubmitted();
			return this;
		}
		
		public void logout(){
			new SSOCRMstatusPage().logout();
		}
}
