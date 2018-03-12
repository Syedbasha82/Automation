/**
 * 
 */
package bg.framework.app.functional.action.Slingshot;

import bg.framework.app.functional.entities.CrmUserProfile;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.Slingshot.GetaQuotePage;
import bg.framework.app.functional.page.Slingshot.SapCrmPage;
/**
 * @author 255501
 *
 */
public class GetaQuoteAction {
		
	String quoteno=null;
	String annualprice=null;
	
	public GetaQuoteAction ManageLinkNavigation(UserProfile userProfile) {
		GetaQuotePage AcctPage = new GetaQuotePage();
		AcctPage.verifyManageAccountLink(userProfile);		
		return this;
	}
	public GetaQuoteAction ClickGetaGasQuoteAction(UserProfile userProfile){
		GetaQuotePage quote = new GetaQuotePage();
		quote.GAQ_logged();
		quote.GetaquoteNavigation("Gas");
		quote.GetaQuote(userProfile);
		quote.verifysiteaddress(userProfile,"Gas quote: Site details");
		quote.movedintosidelastthreemonths(userProfile);
		quote.enterToDate();
		quote.enterFromDate(1);
		quote.quotecontiue();
		quote.GetaQuoteLink();
		quote.oneyearcontract();
		quoteno=quote.QuoteReferencenumber();
		annualprice =quote.Annualprice();	
		return this;
		}	
	public GetaQuoteAction GetelecQuoteverification(UserProfile userProfile){
		GetaQuotePage quote = new GetaQuotePage();
		quote.GAQ_logged();
		quote.GetaquoteNavigation("Gas");
		quote.GetaQuote(userProfile);
		quote.validationsiteaddress(userProfile,"Gas quote: Site details");		
		return this;
		}	
	public GetaQuoteAction ClickGetelecQuoteAction(UserProfile userProfile){
		GetaQuotePage quote = new GetaQuotePage();
		quote.GAQ_logged();
		quote.GetaquoteNavigation("Elec");		
		quote.GetaQuote(userProfile);
		quote.verifysiteaddress(userProfile,"Electricity quote: Site details");
		quote.movedintosidelastthreemonths(userProfile);
		quote.enterToDate();
		quote.enterFromDate(1);
		quote.quotecontiue();
		quote.GetaQuoteLink();
		quote.oneyearcontract();
		quoteno=quote.QuoteReferencenumber();
		annualprice =quote.Annualprice();
		
		return this;
		}
	public GetaQuoteAction RequestcallmebackElecuser(UserProfile userProfile){
		GetaQuotePage quote = new GetaQuotePage();
		quote.GAQ_logged();
		quote.requestcallbackLink();
		quote.requestcallbackdetailsPage_loggeduser(userProfile);		
		return this;
		}	
	public GetaQuoteAction RequestcallmebackGasuser(UserProfile userProfile){
		GetaQuotePage quote = new GetaQuotePage();
		quote.GAQ_logged();
		quote.requestcallbackLink();
		quote.requestcallbackdetailsPage_loggeduser(userProfile);		
		return this;
		}		
		
	public GetaQuoteAction AnonymousGAQelec(UserProfile userProfile){
		GetaQuotePage quote = new GetaQuotePage();
	//	quote.AnonymousGetaQuote("Elec");
		quote.AnonymousGetaQuote_diffenv("Elec");
		quote.AnonymousYourdetailspage(userProfile);
		quote.verifysiteaddress(userProfile,"Electricity quote: Site details");
		quote.movedintosidelastthreemonths(userProfile);
		quote.enterToDate();
		quote.enterFromDate(1);
		quote.quotecontiue();
		quote.GetaQuoteLink();
		quote.oneyearcontract();
		quoteno=quote.QuoteReferencenumber();
		annualprice =quote.Annualprice();		
		return this;
		}	
	public GetaQuoteAction AnonymousGAQGas(UserProfile userProfile){
		GetaQuotePage quote = new GetaQuotePage();
	//	quote.AnonymousGetaQuote("Elec");
		quote.AnonymousGetaQuote_diffenv("Gas");
		quote.AnonymousYourdetailspage(userProfile);
		quote.verifysiteaddress(userProfile,"Gas quote: Site details");
		quote.movedintosidelastthreemonths(userProfile);
		quote.enterFromDate(1);
		quote.enterToDate();
		quote.quotecontiue();
		quote.GetaQuoteLink();
		quote.oneyearcontract();
		quoteno=quote.QuoteReferencenumber();
		annualprice =quote.Annualprice();		
		return this;
		}	
	public GetaQuoteAction QuoteReferencenumber(){
		GetaQuotePage quote = new GetaQuotePage();
		quoteno=quote.QuoteReferencenumber();		
		return this;
		}
	public GetaQuoteAction Annualprice()
	{
		GetaQuotePage quote = new GetaQuotePage();
		annualprice =quote.Annualprice();
		return this;
	}
	public GetaQuoteAction AnonymousElecGasVerification(UserProfile userProfile){
		GetaQuotePage quote = new GetaQuotePage();
	//	quote.AnonymousGetaQuote("Elec");
		quote.AnonymousGetaQuote_diffenv("Elec");
		quote.AnonymousYourdetailspage(userProfile);
		quote.validationsiteaddress(userProfile,"Electricity quote: Site details");		
		return this;
		}
	public GetaQuoteAction AnonymousGAQGasVerification(UserProfile userProfile){
		GetaQuotePage quote = new GetaQuotePage();
		quote.AnonymousGetaQuote("Gas");
	//	quote.AnonymousGetaQuote_diffenv("Gas");
		quote.AnonymousYourdetailspage(userProfile);
		quote.validationsiteaddress(userProfile,"Gas quote: Site details");		
		return this;
		}
	public GetaQuoteAction AnonymousGAQGas_LargerbusinessOverlay(UserProfile userProfile){
		GetaQuotePage quote = new GetaQuotePage();
		quote.AnonymousGetaQuote("Gas");
		//quote.AnonymousGetaQuote_diffenv("Gas");
		quote.AnonymousYourdetailspage(userProfile);
		quote.LargerbusinessOverlaydetails(userProfile,"Gas quote: Site details");		
		quote.largerbusinessOverlaycontinue();	
		return this;
		}
	public GetaQuoteAction AnonymousGAQElec_LargerbusinessOverlay(UserProfile userProfile){
		GetaQuotePage quote = new GetaQuotePage();
		quote.AnonymousGetaQuote("Elec");
	//	quote.AnonymousGetaQuote_diffenv("Elec");
		quote.AnonymousYourdetailspage(userProfile);
		quote.LargerbusinessOverlaydetails(userProfile,"Electricity quote: Site details");		
		quote.largerbusinessOverlaycontinue();
		return this;
		}
	public GetaQuoteAction AnonymousGAQGas_LBoverlayforElec(UserProfile userProfile){
		GetaQuotePage quote = new GetaQuotePage();
		quote.AnonymousGetaQuote("Elec");
	//	quote.AnonymousGetaQuote_diffenv("Elec");
		quote.AnonymousYourdetailspage(userProfile);
		quote.verifysiteaddress(userProfile,"Electricity quote: Site details");
		quote.movedintosidelastthreemonths(userProfile);
		quote.enterFromDate(1);
		quote.enterToDate();
		quote.quotecontiue();
		quote.largerbusinessOverlaycloseandeditvalues();
		quote.quotecontiue();
		quote.GetaQuoteLink();
		return this;
		}
	public GetaQuoteAction  AnonymousGAQGas_LBoverlayforGas(UserProfile userProfile){
		GetaQuotePage quote = new GetaQuotePage();
	//	quote.AnonymousGetaQuote("Gas");
		quote.AnonymousGetaQuote_diffenv("Gas");
		quote.AnonymousYourdetailspage(userProfile);
		quote.verifysiteaddress(userProfile,"Gas quote: Site details");
		quote.movedintosidelastthreemonths(userProfile);
		quote.enterFromDate(1);
		quote.enterToDate();
		quote.quotecontiue();
		quote.largerbusinessOverlaycloseandeditvalues();
		quote.quotecontiue();
		quote.GetaQuoteLink();
		return this;
		}
	public GetaQuoteAction AnonymousGAQgas(UserProfile userProfile){
		GetaQuotePage quote = new GetaQuotePage();
	   // quote.AnonymousGetaQuote("Gas");
		quote.AnonymousGetaQuote_diffenv("Gas");
		quote.AnonymousYourdetailspage(userProfile);
		quote.verifysiteaddress(userProfile,"Gas quote: Site details");
		quote.movedintosidelastthreemonths(userProfile);
		quote.enterToDate();
		quote.enterFromDate(1);
		
		quote.quotecontiue();
		quote.GetaQuoteLink();		
		quote.oneyearcontract();
		quoteno=quote.QuoteReferencenumber();
		annualprice =quote.Annualprice();		
		return this;
		}	
	public GetaQuoteAction AnonymousLoggesinforelec(UserProfile userProfile){
		GetaQuotePage quote = new GetaQuotePage();
		quote.AnonymousGetaQuote("Elec");
	//	quote.AnonymousGetaQuote_diffenv("Elec");
		quote.AnonymousYourdetailspage(userProfile);	
		quote.GetaQuotePageLoggedUser(userProfile);
		return this;
		}	
	public GetaQuoteAction AnonymousGAQlink(){
		GetaQuotePage quote = new GetaQuotePage();
		quote.GAQ_Anonyomousnavigatinlink();
		return this;
		}
	
	public GetaQuoteAction Anonymousincompletesiteoverlayforelec(UserProfile userProfile){
		GetaQuotePage quote = new GetaQuotePage();
		quote.AnonymousGetaQuote("Elec");
	//	quote.AnonymousGetaQuote_diffenv("Elec");
		quote.AnonymousYourdetailspage(userProfile);	
		quote.verifysiteaddress(userProfile,"Electricity quote: Site details");
		quote.movedintosidelastthreemonths(userProfile);
		quote.enterFromDate(1);
		quote.enterToDate();
		quote.quotecontiue();
		quote.incompletesiteOverlay(userProfile);
		quote.GetaQuoteLink();
		return this;
		}
	public GetaQuoteAction Anonymousincompletesiteoverlayforgas(UserProfile userProfile){
		GetaQuotePage quote = new GetaQuotePage();
		quote.AnonymousGetaQuote("Gas");
	//	quote.AnonymousGetaQuote_diffenv("Gas");
		quote.AnonymousYourdetailspage(userProfile);	
		quote.verifysiteaddress(userProfile,"Gas quote: Site details");
		quote.movedintosidelastthreemonths(userProfile);
		quote.enterFromDate(1);
		quote.enterToDate();
		quote.quotecontiue();	
		quote.incompletesiteOverlay(userProfile);
		quote.GetaQuoteLink();
		return this;
		}
	public GetaQuoteAction AnonymousLoggesinforGas(UserProfile userProfile){
		GetaQuotePage quote = new GetaQuotePage();
		quote.AnonymousGetaQuote("Gas");
	//	quote.AnonymousGetaQuote_diffenv("Gas");
		quote.AnonymousYourdetailspage(userProfile);	
		quote.GetaQuotePageLoggedUser(userProfile);
		return this;
		}
	
	public GetaQuoteAction MaxiumAddanothersiteElec(UserProfile userProfile){
		GetaQuotePage quote = new GetaQuotePage();
	//	quote.AnonymousGetaQuote("Gas");
		quote.AnonymousGetaQuote_diffenv("Elec");
		quote.AnonymousYourdetailspage(userProfile);	
		quote.AddanothersitemaxiumElec(userProfile);
		return this;
		}	
	public GetaQuoteAction MaxiumAddanothersiteGas(UserProfile userProfile){
		GetaQuotePage quote = new GetaQuotePage();
	//	quote.AnonymousGetaQuote("Gas");
		quote.AnonymousGetaQuote_diffenv("Gas");
		quote.AnonymousYourdetailspage(userProfile);	
		quote.AddanothersitemaxiumGas(userProfile);
		return this;
		}
	public GetaQuoteAction deenergisederror(UserProfile userProfile){
		GetaQuotePage quote = new GetaQuotePage();
	  //quote.AnonymousGetaQuote("Elec");
		quote.AnonymousGetaQuote_diffenv("Elec");
		quote.AnonymousYourdetailspage(userProfile);
		quote.Entersitedetails(userProfile);
		quote.Deenergize();
		return this;
		}
	public GetaQuoteAction morefuelfoundvalidation(UserProfile userProfile){
		GetaQuotePage quote = new GetaQuotePage();
		quote.AnonymousGetaQuote("Elec");
	//	quote.AnonymousGetaQuote_diffenv("Elec");
		quote.AnonymousYourdetailspage(userProfile);
		quote.Entersitedetails(userProfile);
		quote.morefuelfound();
		return this;
		}
	public GetaQuoteAction Greentickmark(UserProfile userProfile,String fuel){
		GetaQuotePage quote = new GetaQuotePage();
	//	quote.AnonymousGetaQuote(fuel);
		quote.AnonymousGetaQuote_diffenv(fuel);
		quote.AnonymousYourdetailspage(userProfile);
		if(fuel.equals("Elec"))
		{
			quote.verifysiteaddress(userProfile,"Electricity quote: Site details");
		}
		else if(fuel.equals("gas"))
		{
			quote.verifysiteaddress(userProfile,"Gas quote: Site details");
		}		
		quote.movedintosidelastthreemonths(userProfile);
		quote.enterFromDate(1);
		quote.enterToDate();
		quote.quotecontiue();
		quote.GetaQuoteLink();
		
		return this;
		}	
		//String quoteno1="3000058833";
	public GetaQuoteAction GAQ_Auditdetails(UserProfile userProfile){
		GetaQuotePage quote = new GetaQuotePage();
		quote.verifyLeadTable_businesscreateprospect_status(userProfile,userProfile.getNewEmail());
		quote.verifyLeadTable_GAQcontactdetails(userProfile,userProfile.getNewEmail());
		quote.verifyLeadTable_QuoteGenerationfornewEmail(userProfile,"345","1823");
		quote.verifyLeadTable_Quoteunchangedstatuschangesuccess(userProfile,"346","1824");
		quote.verifyLeadTable_Savequote(userProfile,userProfile.getNewEmail());
		quote.verifyLeadTable_Journeyname(userProfile,userProfile.getNewEmail());
		quote.verifyLeadTable_GAQ_opportinitystatus(userProfile,userProfile.getNewEmail());
		quote.Audit_GAQLeadTracking_Savelead(userProfile,quoteno);	
		return this;
		}	
	public GetaQuoteAction GAQ_Auditdetails_logged(UserProfile userProfile){
		GetaQuotePage quote = new GetaQuotePage();
	//	quote.verifyLeadTable_businesscreateprospect_status(userProfile,userProfile.getEmail());
		quote.verifyLeadTable_GAQcontactdetails(userProfile,userProfile.getEmail());
		quote.verifyLeadTable_QuoteGenerationfornewEmail(userProfile,"345","1823");
		quote.verifyLeadTable_Quoteunchangedstatuschangesuccess(userProfile,"346","1824");
		quote.verifyLeadTable_Savequote(userProfile,userProfile.getEmail());
		quote.verifyLeadTable_Journeyname(userProfile,userProfile.getEmail());
		quote.verifyLeadTable_GAQ_opportinitystatus(userProfile,userProfile.getEmail());
		quote.Audit_GAQLeadTracking_Savelead(userProfile,quoteno);	
		return this;
		}	
	public GetaQuoteAction loginDetailsforpaperbilling(CrmUserProfile crmuserProfile){
		SapCrmPage sapcrmpage=new SapCrmPage();		
		sapcrmpage.openCRMUrl();
		sapcrmpage.enterLoginDetails(crmuserProfile);
	//	sapcrmpage.verifyAndClickLoginContinue();
		return this;
	}
	public GetaQuoteAction SearchCRMFields_GAQ(CrmUserProfile crmuserProfile, UserProfile userProfile){
		SapCrmPage sapcrmpage=new SapCrmPage();
		sapcrmpage.GetaQuote_CRM(crmuserProfile,userProfile,quoteno);
		return this;
	}
	public GetaQuoteAction SAPISU_GAQAction(UserProfile userProfile){
		GetaQuotePage quote = new GetaQuotePage();
		quote.VerifySAPISU_GAQChange(userProfile,quoteno,annualprice);
		
		return this;
	}
	
	public GetaQuoteAction AnonymousGAQbaddata(UserProfile userProfile){
		GetaQuotePage quote = new GetaQuotePage();
	//	quote.AnonymousGetaQuote("Gas");
		quote.AnonymousGetaQuote_diffenv("Gas");
		quote.AnonymousYourdetailspage(userProfile);
		quote.verifybaddata();		
		return this;
		}
	
	public GetaQuoteAction Validatehalfhourlymeter(UserProfile userProfile){
		GetaQuotePage quote = new GetaQuotePage();
		quote.AnonymousGetaQuote("Elec");
	//	quote.AnonymousGetaQuote_diffenv("Elec");
		quote.AnonymousYourdetailspage(userProfile);
		quote.Entersitedetails(userProfile);
		quote.verifyhalfhourlymeterfound();
		return this;
		}
	public GetaQuoteAction AnonymousGAQgasRCB(UserProfile userProfile){
		GetaQuotePage quote = new GetaQuotePage();
	//	quote.AnonymousGetaQuote("Gas");
		quote.AnonymousGetaQuote_diffenv("Gas");
		quote.AnonymousYourdetailspage(userProfile);
		quote.verifysiteaddress(userProfile,"Gas quote: Site details");
		quote.movedintosidelastthreemonths(userProfile);
		quote.enterFromDate(1);
		quote.enterToDate();
		quote.quotecontiue();
		quote.GetaQuoteLink();
		return this;
		}	
	public GetaQuoteAction AnonymousGAQElecRCB(UserProfile userProfile){
		GetaQuotePage quote = new GetaQuotePage();
	//	quote.AnonymousGetaQuote("Elec");
		quote.AnonymousGetaQuote_diffenv("Elec");
		quote.AnonymousYourdetailspage(userProfile);
		quote.verifysiteaddress(userProfile,"Electricity quote: Site details");
		quote.movedintosidelastthreemonths(userProfile);
		quote.enterFromDate(1);
		quote.enterToDate();
		quote.quotecontiue();
		quote.GetaQuoteLink();
		return this;
		}
	public GetaQuoteAction AnonymousGAQSummaryRCB(UserProfile userProfile){
		GetaQuotePage quote = new GetaQuotePage();
		quote.Requestcallback_GAQsummary(userProfile);			
		return this;
		}
	
	
}
