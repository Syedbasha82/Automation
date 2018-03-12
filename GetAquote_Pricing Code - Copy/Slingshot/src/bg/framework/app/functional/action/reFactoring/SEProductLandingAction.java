package bg.framework.app.functional.action.reFactoring;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.reFactoring.SEProductLandingPage;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.Slinshot.CompareTariff;

public class SEProductLandingAction {
	
	public SEProductLandingAction navigateToSEcompareTariffPage () {
		SEProductLandingPage SEProductLandingPage=new SEProductLandingPage();
		SEProductLandingPage.navigateToSEProductLandingPage();
		return this;	
		}
	public SEProductLandingAction SelectTariff(CompareTariff CompareTariff) {
		SEProductLandingPage SEProductLandingPage=new SEProductLandingPage();
		SEProductLandingPage.SelectTariff(CompareTariff);
		return this;	
		}
	public SEProductLandingAction enterPostCodeNew(CompareTariff CompareTariff) {
		SEProductLandingPage SEProductLandingPage=new SEProductLandingPage();
		SEProductLandingPage.enterPostCodeNew(CompareTariff);
		return this;	
		}
	public SEProductLandingAction SelectPaymentType(CompareTariff CompareTariff) {
		SEProductLandingPage SEProductLandingPage=new SEProductLandingPage();
		SEProductLandingPage.SelectPaymentType(CompareTariff);
		return this;	
		}
	public SEProductLandingAction VerifyFuelStatus(CompareTariff CompareTariff) {
		SEProductLandingPage SEProductLandingPage=new SEProductLandingPage();
		SEProductLandingPage.VerifyFuelStatus(CompareTariff);
		return this;	
		}
	

}
