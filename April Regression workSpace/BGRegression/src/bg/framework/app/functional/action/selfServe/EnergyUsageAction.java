package bg.framework.app.functional.action.selfServe;

import java.util.ArrayList;

import bg.framework.app.functional.action.reFactoring.ChangeEmailAction;
import bg.framework.app.functional.action.reFactoring.ForgotEmailAction;
import bg.framework.app.functional.action.reFactoring.ForgotPasswordAction;
import bg.framework.app.functional.action.reFactoring.RegistrationAction;
import bg.framework.app.functional.action.reFactoring.PaymentHistoryAction;
import bg.framework.app.functional.action.sales.*;
import bg.framework.app.functional.action.selfServe.ContactUsAction;
import bg.framework.app.functional.action.selfServe.HelpAndAdviceAction;
import bg.framework.app.functional.action.selfServe.SelfServeRegistrationAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.LegacyHomePage;
import bg.framework.app.functional.page.common.LegacyLoginPage;
import bg.framework.app.functional.page.reFactoring.PaymentHistoryPage;
import bg.framework.app.functional.page.selfServe.EnergyUsagePage;

//import bg.framework.app.functional.action.selfServe.SelfServeRegistrationAction;
//import bg.framework.app.functional.action.selfServe.SelfServeRegistrationAction;

/**
 * Created by IntelliJ IDEA.
 * User: !jithendb
 * Date: 23/01/12
 * Time: 17:14
 * To change this template use File | Settings | File Templates.
 */
public class EnergyUsageAction {
    public EnergyUsageAction navigateToReduceBill() {
    	EnergyUsagePage legacyHomePage = new EnergyUsagePage();
        legacyHomePage.navigateToReduceBill();
        return this;
    }
    
    public EnergyUsageAction reduceYourBillValidation() {
    	EnergyUsagePage legacyHomePage = new EnergyUsagePage();
        legacyHomePage.reduceYourBillValidation();
        return this;
    }   
    public EnergyUsageAction dragAndDrop() {
    	EnergyUsagePage legacyHomePage = new EnergyUsagePage();
        legacyHomePage.dragAndDrop();
        return this;
    }     
    public EnergyUsageAction ReduceBillNonES() {
    	EnergyUsagePage legacyHomePage = new EnergyUsagePage();
        legacyHomePage.ReduceBillNonES();
        return this;
    }   
    public EnergyUsageAction navigateToEnergyLink() {
    	EnergyUsagePage legacyHomePage = new EnergyUsagePage();
        legacyHomePage.navigateToEnergyLink();
        return this;
    }   
    public EnergyUsageAction esClose() {
    	EnergyUsagePage legacyHomePage = new EnergyUsagePage();
        legacyHomePage.esClose();
        return this;
    } 
    public EnergyUsageAction energyUsageES() {
    	EnergyUsagePage legacyHomePage = new EnergyUsagePage();
        legacyHomePage.energyUsageES();
        return this;
    } 
    public EnergyUsageAction energyUsageSubmit() {
    	EnergyUsagePage legacyHomePage = new EnergyUsagePage();
        legacyHomePage.energyUsageSubmit();
        return this;
    } 
    
    public EnergyUsageAction tableView() {
    	EnergyUsagePage legacyHomePage = new EnergyUsagePage();
        legacyHomePage.tableView();
        return this;
    } 
    
    
    
        
    
}

