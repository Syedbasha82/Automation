package bg.framework.app.functional.page.selfServe;

import java.util.Properties;

import com.sun.jna.platform.win32.Netapi32Util.User;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;

public class PBFlagPage extends BasePage{
	private final static String FILE_NAME = "resources/selfServe/PBFlag.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	private UserProfile userProfile;
	
	public PBFlagPage(){
		
	}
	
	public PBFlagPage(UserProfile userProfile) {
	this.userProfile=userProfile;
	}
			  
	    
	    public void clickCheckBox(){
	    	browser.wait(1000);
	    	//verifyAndClickWithXpath(pageProperties.getProperty("PBFlag.selectAccountBox").replace("ACCOUNTNUMBER",userProfile.getAccNumber()), "Check box for Pb Flag");
	    	verifyAndClickWithXpath(pageProperties.getProperty("PBFlag.selectAccountBox01"), "Check box for Pb Flag");
	    }
	    
	    public void clickContinueButton(){
	    	//verifyAndClick(pageProperties.getProperty("PBFlag.continueButton"), "Continue");
	    	verifyAndClickWithXpath(pageProperties.getProperty("PBFlag.continueButtonNew"), "Continue");
	    }
	    
	    public void verifyPaperlessBillingSuccess(){
	    	verifyIsTextPresent("You've now switched to paperless billing");
	    }
	    
	    public void clickCardNumber(){
	    	verifyAndClick(pageProperties.getProperty("PBFlag.cardNumber"), "");
	    }
	    
	    public void clickSignUp(){
	    	verifyAndClick(pageProperties.getProperty("PbFlag.cardSignup"), "");
	    }
		public void clickNectorLater(){
			verifyAndClick(pageProperties.getProperty("PBFlag.nectorCard_later"), "");
		}
		public void clickNoThanks(){
			verifyAndClick(pageProperties.getProperty("PBFlag.noThanks"), "");
		}
		public void clickTermsAndCondotion(){
			verifyAndClick(pageProperties.getProperty("PBFlag.termsAndCondition"), "");
		}
}
