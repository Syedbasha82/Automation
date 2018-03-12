package bg.framework.app.functional.action.reFactoring;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.reFactoring.ESSCallBackPage;

/**
 * Created by IntelliJ IDEA.
 * User: !jithendb
 * Date: 24/04/12
 * Time: 14:34
 * To change this template use File | Settings | File Templates.
 */
public class EssCallBackAction {

    public EssCallBackAction enterRequestCallBackDetails(UserProfile userProfile){
        ESSCallBackPage essCallBackPage = new ESSCallBackPage();
        essCallBackPage.validateESSCallBackPage(userProfile);
        return new EssCallBackAction();
    }

    public EssCallBackAction navigateToESSCallbackPage(){
        ESSCallBackPage essCallBackPage = new ESSCallBackPage();
        essCallBackPage.navigateToRequestCallBackPage();
        return new EssCallBackAction();
    }
    public EssCallBackAction navigateToRequestaCallBackPage(){
        ESSCallBackPage essCallBackPage = new ESSCallBackPage();
        essCallBackPage.navigateToLHSRequestCallBack();
        return new EssCallBackAction();
    }
    public EssCallBackAction navigateToSERequestaCallBackPage(){
        ESSCallBackPage essCallBackPage = new ESSCallBackPage();
        essCallBackPage.navigateToSELHSRequestCallBack();
        return new EssCallBackAction();
    }
    public EssCallBackAction navigateToHeatingPage(){
        ESSCallBackPage essCallBackPage = new ESSCallBackPage();
        essCallBackPage.navigateToHeatingESSLink();
        return new EssCallBackAction();
    }
    public EssCallBackAction navigateToBottomRequestCallBack(){
        ESSCallBackPage essCallBackPage = new ESSCallBackPage();
        essCallBackPage.navigateToBottomRequestCallBack();
        return new EssCallBackAction();
    }
    public EssCallBackAction navigateToStandbypowersaversLink(){
        ESSCallBackPage essCallBackPage = new ESSCallBackPage();
        essCallBackPage.navigateToStandbypowersaversLink();
        return new EssCallBackAction();
    }
    public EssCallBackAction navigateToGreenGadgets(){
        ESSCallBackPage essCallBackPage = new ESSCallBackPage();
        essCallBackPage.navigateToGreenGadgets();
        return new EssCallBackAction();
    }
    public EssCallBackAction enterAnonyRequestCallBackDetails(){
        ESSCallBackPage essCallBackPage = new ESSCallBackPage();
        essCallBackPage.validateESSCallBackAnonyPage();
        return new EssCallBackAction();
    }
    public EssCallBackAction selectSingleProduct(){
        ESSCallBackPage essCallBackPage = new ESSCallBackPage();
        essCallBackPage.selectSingleProduct();
        return new EssCallBackAction();
    }
    public EssCallBackAction selectSESingleProduct(){
        ESSCallBackPage essCallBackPage = new ESSCallBackPage();
        essCallBackPage.selectSESingleProduct();
        return new EssCallBackAction();
    }
    public EssCallBackAction verifySingleProduct(){
        ESSCallBackPage essCallBackPage = new ESSCallBackPage();
        essCallBackPage.verifySingleEssCallConfirmationPage();
        //essCallBackPage.verifyCallBackLeadType();
        return new EssCallBackAction();
    }
    public EssCallBackAction selectMultipleProduct(){
        ESSCallBackPage essCallBackPage = new ESSCallBackPage();
        essCallBackPage.selectMultipleProduct();
        return new EssCallBackAction();
    }
    public EssCallBackAction verifyMultipleProduct(){
        ESSCallBackPage essCallBackPage = new ESSCallBackPage();
        essCallBackPage.verifyEssCallConfirmationPage();
        //essCallBackPage.verifyCallBackLeadType();
        return new EssCallBackAction();
    }
    public EssCallBackAction navigateToContinueShoppingPage(){
        ESSCallBackPage essCallBackPage = new ESSCallBackPage();
        essCallBackPage.navigateToContinueShoppingPage();
        return new EssCallBackAction();
    }
    public EssCallBackAction navigateToSaveCreatePage(){
        ESSCallBackPage essCallBackPage = new ESSCallBackPage();
        essCallBackPage.navigateToSaveCreatePage();
        return new EssCallBackAction();
    }
    public EssCallBackAction logout(){
        ESSCallBackPage essCallBackPage = new ESSCallBackPage();
        essCallBackPage.logOut();
        return new EssCallBackAction();
    }

    public EssCallBackAction verifyErrorMessages(){
        ESSCallBackPage essCallBackPage = new ESSCallBackPage();
        essCallBackPage.validateErrorMessages();
        return new EssCallBackAction();
    }
    public EssCallBackAction verifyBrowserBack(){
        ESSCallBackPage essCallBackPage = new ESSCallBackPage();
        essCallBackPage.verifyBrowserBackbutton();
        return new EssCallBackAction();
    }
    public EssCallBackAction selectSEMultipleProduct(){
        ESSCallBackPage essCallBackPage = new ESSCallBackPage();
        essCallBackPage.selectSEMultipleProduct();
        return new EssCallBackAction();
    }
    public EssCallBackAction verifySEMultipleProduct(){
        ESSCallBackPage essCallBackPage = new ESSCallBackPage();
        essCallBackPage.verifyEssCallSEConfirmationPage();
        return new EssCallBackAction();
    }
}
