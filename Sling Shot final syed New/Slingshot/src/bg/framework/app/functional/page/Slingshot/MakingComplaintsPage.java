/**
 * 
 */
package bg.framework.app.functional.page.Slingshot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.common.SlingshotErrorMessages;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.RobotSendKeys;

/**
 * @author 292238
 *
 */
public class MakingComplaintsPage extends BasePage{
	private final static String FILE_NAME = "resources/Slingshot/MakingComplaint.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	SlingshotErrorMessages errormsg = new SlingshotErrorMessages();
	public void openMakingComplaintPage(String journey){
		if(journey.equalsIgnoreCase("Corporate")){
			if(!browser.isElementVisible("MakingComplaint.LogoutLink")){
				verifyAndClickWithXpath(pageProperties.getProperty("MakingComplaint.CorporateLink"), "Corporate Link");	
				verifyAndClickWithXpath(pageProperties.getProperty("MakingComplaint.ContactUsLink"), "Contact us link");
				verifyAndClickWithXpath(pageProperties.getProperty("MakingComplaint.makingComplaintCorporate"),"Making a complaint");
				browser.wait(getWaitTime());
			}
		}else{
		verifyAndClickWithXpath(pageProperties.getProperty("MakingComplaint.ContactUsLink"), "Contact us link");
		browser.clickWithXpath(pageProperties.getProperty("MakingComplaint.makingComplaintBusiness"));
		//verifyAndClickWithXpath(pageProperties.getProperty("MakingComplaint.makingComplaintBusiness"),"Making a business complaint");
		browser.wait(getWaitTime());
		}
		//verifyIsTextPresent(pageProperties.getProperty("MakingComplaint.MakingComplaint"));
		verifyAndClickWithXpath(pageProperties.getProperty("MakingComplaint.MakingComplaintContactUsLink"), "Contact us link");
		
	}
	public void verifyContactUsInComplaints(UserProfile userProfile){
		ArrayList<String> accountNumber = null;
		try{
		accountNumber = browser.getFromDropBox("id", pageProperties.getProperty("MakingComplaint.accountNumber"));
		verifyAndSelectDropDownBox(pageProperties.getProperty("MakingComplaint.accountNumber"), "Account number: "+accountNumber.get(1), accountNumber.get(1));
		String address = browser.getTextByXpath(pageProperties.getProperty("MakingComplaint.AddressSection"));
		//System.out.println("Address&&&&&&&&&&&&&&"+address1);
		System.out.println("Address&&&&&&&&&&&&&&"+address);
		verifyAddress(address);
		}
		catch(Exception e){
			verifyAndInputById(pageProperties.getProperty("MakingComplaint.accountNumber"), "Account number",userProfile.getAccNumber());
			//accountNumber1 = new String[] {userProfile.getAccNumber()};
		}
		//String address1 = browser.getAttributeByXpath(pageProperties.getProperty("MakingComplaint.AddressSection"), "p");
		
		ArrayList<String> complaint = browser.getFromDropBox("id", pageProperties.getProperty("MakingComplaint.complaintorQueryCategory"));
		verifyAndSelectDropDownBox(pageProperties.getProperty("MakingComplaint.complaintorQueryCategory"), "Complaint: ",complaint.get(1));
		ArrayList<String> contact = browser.getFromDropBox("id", pageProperties.getProperty("MakingComplaint.preferredContact"));
		verifyAndSelectDropDownBox(pageProperties.getProperty("MakingComplaint.preferredContact"), "Contact ", contact.get(1));
		verifyAndInputById(pageProperties.getProperty("MakingComplaint.description"), "Description","Testing");
		verifyAndClickWithXpath(pageProperties.getProperty("MakingComplaint.submit"), "Submit button");
		
		
	}
		
		public void verifyConfirmationinPage(UserProfile userprofile) {
		verifyPageTitle("Confirmation");
		verifyIsTextPresent(SlingshotErrorMessages.Complaints_ConfirmationMessage);
		verifyIsTextPresent(userprofile.getAccNumber());
		//verifyIsTextPresent("A member of our team will contact you within one working day");	
		//Report.updateTestLog(""+browser.getTextByXpath(pageProperties.getProperty("MakingComplaint.ReferenceNumber")), "DONE");
		OnlineDBConnector dbFunctions = new OnlineDBConnector();
		String date=dbFunctions.DBsysdateDdmmyyhhmi();
		String[] auditType = dbFunctions.getAuditEventTypeId(date, userprofile.getEmail(),"Complaint");
		String data = dbFunctions.getAuditType(auditType[0]);	
		//String data1 = dbFunctions.getAuditType(auditType[1]);	
		System.out.println(Arrays.asList(auditType));
		Report.updateTestLog("Audit id is made in audit table as expected. Audit id: "+auditType[0]+ " Audit event type is"+data, data.trim().equalsIgnoreCase("BGB_CONTACTUS_COMPLAINTS_EMAIL_SENT_SUCCESS")?"PASS":"FAIL");
		Report.updateTestLog("Audit data is made in audit table as expected. Audit data: "+auditType[1],"PASS");
	}
		public void verifyLinks(){
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("MakingComplaint.ProcedureLink"))){
				verifyAndClickWithXpath(pageProperties.getProperty("MakingComplaint.ProcedureLink"), "Complaints Handling Procedure");
				if(browser.getTitle().contains("Complaints-Procedure.pdf")){
					browser.browserBack();
					browser.wait(getWaitTime());
					Report.updateTestLog("Complaints-Procedure.pdf is downloaded as expected", "PASS");
				}
				else{
					Report.updateTestLog("Complaints-Procedure.pdf is downloaded as expected", "FAIL");
				}
			}else{
				//Report.updateTestLog("Complaints Handling Procedure is available in RHN", "FAIL");
			}
		}
		public void verifyAddress(String address){
			//String billingAddress=null;
			String addressInCompPage = browser.getTextByXpath(pageProperties.getProperty("MakingComplaint.AddressSection"));
			System.out.println("Address displayed in complaint page is "+addressInCompPage);	
			System.out.println("Address displayed in account overview page is "+address);	
			Report.updateTestLog("Both address are same as expected."+address+"."+addressInCompPage, 	address.contains(addressInCompPage)?"PASS":"FAIL");
			}
			
			
					
		public String getAddress(){
			String billingAddressFull=null;
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("MakingComplaint.AccountOverviewAddress"))){
				 billingAddressFull = browser.getTextByXpath(pageProperties.getProperty("MakingComplaint.AccountOverviewAddress"));
				//String billingPostCode1 = (String) billingAddressFull.subSequence(billingAddressFull.length()-8, (billingAddressFull.length()));
				System.out.println("Billing Address1: "+billingAddressFull);
				//System.out.println("Billing Address2: "+address);
				
				}
				else{
					Report.updateTestLog("Billing address is not available for this customer", "DONE");
					}
			return billingAddressFull;
		}
		public void verifyWhereCanIFindThisLink() {
			verifyAndClickWithXpath(pageProperties.getProperty("ContactUs.Wherecanifindthis"), "Where Can I Find This");
			//verifyAndClickWithXpath(pageProperties.getProperty("ContactUs.Close"), "Close");
		}
		public void validateAccountNumberField(UserProfile userProfile){
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("MakingComplaint.AccountNumberType"))){
				Report.updateTestLog("Normal search field is displaying for moretha 15 account", "PASS");			
			
			 final String[] accountNum = { "","         ","600256061","600104694324", "600304694123", "600&*4694", "600ab4694"};
		
			ArrayList<String> complaint = browser.getFromDropBox("id", pageProperties.getProperty("MakingComplaint.complaintorQueryCategory"));
			verifyAndSelectDropDownBox(pageProperties.getProperty("MakingComplaint.complaintorQueryCategory"), "Complaint: ",complaint.get(1));
			ArrayList<String> contact = browser.getFromDropBox("id", pageProperties.getProperty("MakingComplaint.preferredContact"));
			verifyAndSelectDropDownBox(pageProperties.getProperty("MakingComplaint.preferredContact"), "Contact ", contact.get(1));
			verifyAndInputById(pageProperties.getProperty("MakingComplaint.description"), "Description", "testing");
			for (int i = 0; i < accountNum.length; i++) {
			verifyAndInputByXpath(pageProperties.getProperty("MakingComplaint.AccountNumberType"), "Account Number", accountNum[i]);
			verifyAndClickWithXpath(pageProperties.getProperty("MakingComplaint.submit"), "Submit button");
			 errorMessageComparison(SlingshotErrorMessages.SlingShot_AccountNumberEmpty);
		       }
			}
			else{
				Report.updateTestLog("Drop down account field is displaying for lessthan 15 account", "PASS");
			}
		}
		// Capture the error message displayed and verify the actual and error message displayed by making a call to the verifyErrorMessage method
	    public void errorMessageComparison(final String expectedErrorMsg) {
	        final String displayedErrorMsg = browser.getTextByXpath(pageProperties.getProperty("MakingComplaint.ErrorMessageValidationID"));
	        verifyErrorMessage(displayedErrorMsg, expectedErrorMsg);
	    }
	    

	//  Validation for Inappropriate data for the fields displayed in Complaints Compare the error message displayed in the 
	//  application against the Expected data  	 
	     public void verifyErrorMessage(final String displayedErrorMsg, final String expectedErrorMsg) {
	    	 System.out.println(displayedErrorMsg);
	    	 System.out.println(expectedErrorMsg);
	         if (displayedErrorMsg.trim().contains(expectedErrorMsg.trim())) {
	             Report.updateTestLog("Error message validation is done. Expected error message: "+ expectedErrorMsg+" Displayed error message: "+ displayedErrorMsg, "PASS");
	         } else {
	        	 Report.updateTestLog("Error message validation is done. Expected error message: "+ expectedErrorMsg+" Displayed error message: "+ displayedErrorMsg, "FAIL");
	         }
	     }
	   //Verifying 'Query Complaint' field contents
	     public void verifyAndValidateQueryComplaintField(UserProfile userProfile){
	    	 int flg = 0;
	    	 final String[] QueryFieldContents = {"Please select", 
	    			 "My account & billing", 
	    			 "Customer service",
	    			 "My meter readings & meter",
	    			 "Moving premises", 
	    			 "My payment", 
	    			 "Breakdown & servicing", "Sales", "Renewal", "Cancellation ","Other"};
	    	 final ArrayList<String> actualTitleContent =browser.getFromDropBox("id", pageProperties.getProperty("MakingComplaint.complaintorQueryCategory"));
	    	 for(int i=0;i<QueryFieldContents.length; i++){
	    		 if(actualTitleContent.get(i).trim().equalsIgnoreCase(QueryFieldContents[i].trim())){
	    			flg = flg + 1;
	    		 }
	    		 else {
	    			 Report.updateTestLog("Expected 'Complaint' fileld content does not present", "FAIL"); 
	    		 }
	    		 if(flg == QueryFieldContents.length)
	    			 Report.updateTestLog("Expected 'Complaint' field content is present", "PASS");  
	    	 }
	    	 validateField(userProfile.getAccNumber(),QueryFieldContents[0],"By email","Testing");
	     }
	   //Validate 'Query Complaint' field content without selecting any value
	     public void validateField(String accNumber, String complaint, String contact, String description){
	    	 enterComplainField(accNumber, complaint,contact,description);
	    	 errorMessageComparison(SlingshotErrorMessages.SlingShot_InvalidComplainSelection);
	     }
	   //Validate 'Query Complaint' field content without selecting any value
	     public void validatePreferTimeField(String accNumber, String complaint, String contact, String preferTime,String description){
	    	 enterComplainField1(accNumber, complaint,contact,preferTime,description);
	    	 errorMessageComparison(SlingshotErrorMessages.SlingShot_InvalidComplainSelection);
	     }
	     //Validate 'Query Complaint' field content without selecting any value
	     public void validatePreferTimeField1(String accNumber, String complaint, String contact, String preferTime,String description){
	    	 enterComplainField1(accNumber, complaint,contact,preferTime,description);
	     }
	     public void enterComplainField(String accNumber, String complaint, String contact, String description){
	    	 try{
	    	verifyAndSelectDropDownBox(pageProperties.getProperty("MakingComplaint.accountNumber"), "Account number: "+accNumber,accNumber);	}
	    	 catch(Exception e){
	 			verifyAndInputById(pageProperties.getProperty("MakingComplaint.accountNumber"), "Account number",accNumber);

	    	 }
	 		verifyAndSelectDropDownBox(pageProperties.getProperty("MakingComplaint.complaintorQueryCategory"), "Complaint: ",complaint);
	 		verifyAndSelectDropDownBox(pageProperties.getProperty("MakingComplaint.preferredContact"), "Contact ", contact);
	 		verifyAndInputById(pageProperties.getProperty("MakingComplaint.description"), "Description", description);
	 		verifyAndClickWithXpath(pageProperties.getProperty("MakingComplaint.submit"), "Submit button");
	     }
	     public void enterComplainField1(String accNumber, String complaint, String contact, String preferTime,String description){
	    	// verifyAndSelectDropDownBox(pageProperties.getProperty("MakingComplaint.accountNumber"), "Account number: "+accNumber,accNumber);	 	
	 		verifyAndSelectDropDownBox(pageProperties.getProperty("MakingComplaint.complaintorQueryCategory"), "Complaint: ",complaint);
	 		verifyAndSelectDropDownBox(pageProperties.getProperty("MakingComplaint.preferredContact"), "Contact ", contact);
	 		verifyAndSelectDropDownBox(pageProperties.getProperty("MakingComplaint.telephoneContactPreference"), "Prefer time ", preferTime);
	 		verifyAndInputById(pageProperties.getProperty("MakingComplaint.description"), "Description", description);
	 		verifyAndClickWithXpath(pageProperties.getProperty("MakingComplaint.submit"), "Submit button");
	     }
	     //Verifying 'Query Complaint' field contents
	     public void verifyAndValidatePreferContactField(UserProfile userProfile){
	    	 int flg = 0;
	    	 final String[] PreferContact = {"Please select","By email","By telephone","By post"};
	    	 final ArrayList<String> actualPreferContact =browser.getFromDropBox("id", pageProperties.getProperty("MakingComplaint.preferredContact"));
	    	 for(int i=0;i<PreferContact.length; i++){
	    		 if(actualPreferContact.get(i).trim().equalsIgnoreCase(PreferContact[i].trim())){
	    			flg = flg + 1;
	    		 }
	    		 else {
	    			 Report.updateTestLog("Expected 'Prefer contact' field content does not present", "FAIL"); 
	    		 }
	    		 if(flg == PreferContact.length)
	    			 Report.updateTestLog("Expected 'Prefer contact' field content is present", "PASS");  
	    	 }
	    	 validateField(userProfile.getAccNumber(),"My account & billing",PreferContact[0],"Testing");
	    	 validateTelephoneOption(userProfile.getAccNumber(),"My account & billing",PreferContact[2],"Testing");
	     }
	   //Verifying 'Prefer Time' field contents
	     public void verifyAndValidatePreferTime(String accNumber){
	    	 int flg = 0;
	    	 final String[] PreferTime = {"Please select", 
	    			 "8.00am - 10.00am", 
	    			 "10.00am - 12.00pm",
	    			 "12.00pm - 2.00pm",
	    			 "2.00pm - 4.00 pm",
	    			 "4.00pm - 6.00pm"};
	    	 final ArrayList<String> telephoneContactPreference =browser.getFromDropBox("id", pageProperties.getProperty("MakingComplaint.telephoneContactPreference"));
	    	 for(int i=0;i<PreferTime.length; i++){
	    		 if(telephoneContactPreference.get(i).trim().equalsIgnoreCase(PreferTime[i].trim())){
	    			flg = flg + 1;
	    		 }
	    		 else {
	    			 Report.updateTestLog("Expected 'Prefer contact' fileld content does not present", "FAIL"); 
	    		 }
	    		 if(flg == PreferTime.length)
	    			 Report.updateTestLog("Expected 'Prefer contact' field content is present", "PASS");  
	    	 }
	    	 validatePreferTimeField(accNumber,"My account & billing","By telephone",PreferTime[0],"Testing");
	    	 validatePreferTimeField1(accNumber,"My account & billing","By telephone",PreferTime[2],"Testing");
	    	 //validateTelephoneOption(userProfile.getAccNumber(),"My account & billing",PreferTime[2],"Testing");
	     }
	     public void validateTelephoneOption(String accNumber, String complaint, String contact, String description){
	    	// verifyAndSelectDropDownBox(pageProperties.getProperty("MakingComplaint.accountNumber"), "Account number: "+accNumber,accNumber);	 	
		 		verifyAndSelectDropDownBox(pageProperties.getProperty("MakingComplaint.complaintorQueryCategory"), "Complaint: ",complaint);
		 		verifyAndSelectDropDownBox(pageProperties.getProperty("MakingComplaint.preferredContact"), "Contact ", contact);
		 		verifyAndValidatePreferTime(accNumber);
		 		//verifyAndSelectDropDownBox(pageProperties.getProperty("MakingComplaint.accountNumber"), "Account number: "+accNumber,accNumber);	
				/*ArrayList<String> preferTime = browser.getFromDropBox("id", pageProperties.getProperty("MakingComplaint.preferredContact"));
		 		verifyAndSelectDropDownBox(pageProperties.getProperty("MakingComplaint.preferredContact"), "Prefer time ", preferTime.get(2));
		 		verifyAndInputById(pageProperties.getProperty("MakingComplaint.description"), "Description", description);
		 		verifyAndClickWithXpath(pageProperties.getProperty("MakingComplaint.submit"), "Submit button");*/
	     }
	     public void verifyContactUsPageLinks(){
	 		ArrayList<String> list = new ArrayList<String>();
	 		/*list.add("MakingComplaint.MakingComplaintLink");
	 		list.add(pageProperties.getProperty("MakingComplaint.MakingComplaintTitle"));*/
	 		list.add("MakingComplaint.AddDocumentLink");
	 		list.add(pageProperties.getProperty("MakingComplaint.UploadFileContent"));
	 		list.add("MakingComplaint.HelpLink");
	 		list.add(pageProperties.getProperty("MakingComplaint.OverlayContent"));
	 		list.add("MakingComplaint.WhereCanIfindThis");
	 		list.add(pageProperties.getProperty("MakingComplaint.AccountNumberContent"));
	 		
	 		for (int i=0;i<list.size();i=i+2) {
	 			verifyLinksandText(list.get(i),list.get(i+1));
	 		}
	 	}
	 	
	 	private void verifyLinksandText(String link, String title) {
	 		String linkName = link.substring(link.indexOf('.') + 1, link.length());
	 		if(browser.isElementVisibleWithXpath(pageProperties.getProperty(link))) {
	 			Report.updateTestLog(linkName + " Link Exist", "PASS");
	 			browser.clickWithXpath(pageProperties.getProperty(link));
	 			browser.wait(2000);	
	 			verifyIsElementVisibleWithXpath(title, title);
	 			browser.wait(2000);	
	 		} 
	 		else {
	 			Report.updateTestLog(linkName + " Link not Exist", "FAIL");
	 		}
	 	}
	 	public void verifyConfirmation() {
			verifyPageTitle("Confirmation");
			verifyIsTextPresent(SlingshotErrorMessages.Complaints_ConfirmationMessage);			
			Report.updateTestLog(""+browser.getTextByXpath(pageProperties.getProperty("MakingComplaint.ReferenceNumber")), "DONE");
	 	}
	 	
	 	public void verifyCallUs(){
	 		final String contactNumber = "0800 652 4040";
	 		verifyAndClickWithXpath(pageProperties.getProperty("MakingComplaint.CallUs1"), "Call Us in step1 procedure");
	 		String contactNum = browser.getTextByXpath(pageProperties.getProperty("MakingComplaint.CallUsPhoneNum"));
	 		Report.updateTestLog(contactNum+" is displayed in call us overlay as expected. Actual: "+contactNum+" and Expected: "+contactNumber, contactNum.equalsIgnoreCase(contactNumber)?"PASS":"FAIL");
	 		closeOverlay();
	 		}
	 	public void verifyEmailUs(){
	 		final String emailAddress[] = {"Multimedia Team" , "British Gas Business" ,"Spinneyside", "Penman Way" ,"Grove Park", "Leicester" ,	"LE19 1SZ"};
	 		verifyAndClickWithXpath(pageProperties.getProperty("MakingComplaint.writeus1"), "Write Us in step1 procedure");
	 		String emailAddressFromApp = browser.getTextByXpath(pageProperties.getProperty("MakingComplaint.writeusAdress1"));
	 		String[] add = emailAddressFromApp.split("\\n");
	 		System.out.println("emailAddress from Code"+Arrays.asList(emailAddress));
	 		System.out.println("emailAddress from APP"+Arrays.asList(add));
	 		int j=0;
	 		for(int i=0;i<emailAddress.length;i++){
	 			
	 			if((add[i].trim()).equalsIgnoreCase(emailAddress[i].trim())){
	 				j++;
	 				System.out.println("j *********** "+j);
	 			}
	 		}
	 		Report.updateTestLog(Arrays.asList(emailAddress)+" is displayed in Write us overlay as expected.Actual: "+Arrays.asList(add),(j==emailAddress.length?"PASS":"FAIL"));
	 		closeOverlay();
	 		}
	 	public void verifyEmailUs2(){
	 		final String contactUsEmail = "businesscustomerrelations@britishgas.co.uk";
	 		verifyAndClickWithXpath(pageProperties.getProperty("MakingComplaint.emailus1"), "Email Us in step2 procedure");
	 		String emailId = browser.getTextByXpath(pageProperties.getProperty("MakingComplaint.emailusId"));
	 		System.out.println("emailAddressFromApp"+emailId);
	 		System.out.println("emailAddress"+contactUsEmail);
	 		Report.updateTestLog(emailId+" is displayed in call us overlay as expected", emailId.equalsIgnoreCase(contactUsEmail)?"PASS":"FAIL");
	 		closeOverlay();	 		
	 	}
		public void verifyCallUs2(){
	 		final String contactNumber = "0800 294 0015";
	 		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("MakingComplaint.CallUs2"))){
	 		verifyAndClickWithXpath(pageProperties.getProperty("MakingComplaint.CallUs2"), "Call Us in step2 procedure");
	 		System.out.println("link exist");
	 		}
	 		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("MakingComplaint.CallUs2"))){

	 		verifyAndClickWithXpath(pageProperties.getProperty("MakingComplaint.CallUs21"), "Call Us in step2 procedure");
	 		System.out.println("link2 exist");
	 		}
	 		String contactNum = browser.getTextByXpath(pageProperties.getProperty("MakingComplaint.CallUsPhoneNum2"));
	 		Report.updateTestLog(contactNum+" is displayed in call us overlay as expected", contactNum.equalsIgnoreCase(contactNumber)?"PASS":"FAIL");
	 		closeOverlay();
	 			 	}
		public void closeOverlay(){
			String jqueryToCloseOverlay=("$('a.ui-dialog-titlebar-close').trigger('click');");
    		browser.executeScript(jqueryToCloseOverlay);
			browser.wait(getWaitTime());
			/*verifyAndClickWithXpath(pageProperties.getProperty("MakingComplaint.CloseOverlay"), "Close overlay");
			while(browser.isElementVisibleWithXpath(pageProperties.getProperty("MakingComplaint.CloseOverlay"))){
	 			 RobotSendKeys.typeEsc();
	 		      browser.wait(3000);		 			 		
		 		}*/
		}
	 	public void verifyWriteUsStep2(){
	 		final String address[] = {"Customer Care Team", "British Gas Business", "Spinneyside", "Penman Way", "Grove Park", "Leicester", "LE19 1SZ"};
	 		verifyAndClickWithXpath(pageProperties.getProperty("MakingComplaint.write2us2"), "Write Us in step2 procedure");
	 		String addressFromApp = browser.getTextByXpath(pageProperties.getProperty("MakingComplaint.writeusAdress2").trim());
	 		String[] add = addressFromApp.split("\\n");
	 		System.out.println("emailAddress from Code"+Arrays.asList(address));
	 		System.out.println("emailAddress from APP"+Arrays.asList(add));
	 		int j=0;
	 		for(int i=0;i<address.length;i++){
	 			
	 			if((add[i].trim()).equalsIgnoreCase(address[i].trim())){
	 				j++;
	 				System.out.println("j *********** "+j);
	 			}
	 		}
	 		Report.updateTestLog(Arrays.asList(address)+" is displayed in Write us overlay as expected.Actual: "+Arrays.asList(add),(j==address.length?"PASS":"FAIL"));
	 		closeOverlay();	 	}
		public void verifyEmailUs3(){
	 		final String contactUsEmail = "customer.service.director@britishgas.co.uk";
	 		verifyAndClickWithXpath(pageProperties.getProperty("MakingComplaint.step3email"), "By email in step3 procedure");
	 		String emailId = browser.getTextByXpath(pageProperties.getProperty("MakingComplaint.emailusId3"));
	 		System.out.println("emailAddressFromApp"+contactUsEmail);
	 		System.out.println("emailAddress"+emailId);
	 		Report.updateTestLog(emailId+" is displayed in call us overlay as expected", emailId.equalsIgnoreCase(contactUsEmail)?"PASS":"FAIL");
	 		closeOverlay();	 	
	 	}
		public void verifyWriteUsStep3(){
	 		final String address[] = {"Customer Services Director"
									,"British Gas Business"
									,"Spinneyside"
									,"Penman Way"
									,"Grove Park"
									,"Leicester"
									,"LE19 1SZ"};
	 		verifyAndClickWithXpath(pageProperties.getProperty("MakingComplaint.step3post"), "By post in step3 procedure");
	 		String addressFromApp = browser.getTextByXpath(pageProperties.getProperty("MakingComplaint.post3"));
	 		String[] add = addressFromApp.split("\\n");
	 		System.out.println("emailAddress from Code"+Arrays.asList(address));
	 		System.out.println("emailAddress from APP"+Arrays.asList(add));
	 		int j=0;
	 		for(int i=0;i<address.length;i++){
	 			
	 			if((add[i].trim()).equalsIgnoreCase(address[i].trim())){
	 				j++;
	 				System.out.println("j *********** "+j);
	 			}
	 		}
	 		Report.updateTestLog(Arrays.asList(address)+" is displayed in Write us overlay as expected.Actual: "+Arrays.asList(add),(j==address.length?"PASS":"FAIL"));
	 		closeOverlay(); 	}
		public void openMakingComplaint(String journey){
			verifyAndClickWithXpath(pageProperties.getProperty("MakingComplaint.ContactUsLink"), "Contact us link");
			browser.clickWithXpath(pageProperties.getProperty("MakingComplaint.makingComplaintBusiness"));
			//verifyAndClickWithXpath(pageProperties.getProperty("MakingComplaint.makingComplaintBusiness"),"Making a business complaint");
			browser.wait(getWaitTime());
			verifyIsTextPresent(pageProperties.getProperty("MakingComplaint.MakingComplaint"));
			//verifyAndClickWithXpath(pageProperties.getProperty("MakingComplaint.MakingComplaintContactUsLink"), "Contact us link");
			
		}
		public void validateEnterAddressManually(UserProfile userProfile, String Cust, String Wordings, String addr) {
			ArrayList<String> complaint = browser.getFromDropBox("id", pageProperties.getProperty("MakingComplaint.QueryEmailUs"));
			verifyAndSelectDropDownBox(pageProperties.getProperty("MakingComplaint.QueryEmailUs"), "Complaint: ",complaint.get(1));
			verifyAndInputById(pageProperties.getProperty("MakingComplaint.FirstName"), "First Name", userProfile.getFirstName().trim());
			verifyAndInputById(pageProperties.getProperty("MakingComplaint.SurName"),"Surname",userProfile.getLastName().trim());
			verifyAndInputById(pageProperties.getProperty("MakingComplaint.BusinessName"),"BusinessName","BG Agency");
			verifyAndInputById(pageProperties.getProperty("MakingComplaint.EmailAddress"),"EmailAddress",userProfile.getEmail().trim());
			verifyAndInputById(pageProperties.getProperty("MakingComplaint.TelephoneNumber"),"MobileNo",userProfile.getMobileNumber().trim());
			verifyAndClick(pageProperties.getProperty("MakingComplaint."+ Cust), Wordings);
			verifyAndInputById(pageProperties.getProperty("MakingComplaint.Postcode"),"Postcode",userProfile.getPostCode().trim());
			verifyAndClick(pageProperties.getProperty("MakingComplaint.FindAddress"), "Find Address Button");
			browser.wait(getWaitTime());
			waitForObjectExistance(pageProperties.getProperty("MakingComplaint.EnterAddressManually"),"xpath");

			if(addr.equalsIgnoreCase("Manual")){				
				verifyAndClick(pageProperties.getProperty("MakingComplaint.EnterAddressManually"), "Enter Your Address Manually");
				verifyAndInputById(pageProperties.getProperty("MakingComplaint.FlatNumber"),"Flat Number","Unit 5");
				verifyAndInputById(pageProperties.getProperty("MakingComplaint.Address1"),"Address 1","Greenfield Farm Industrial Estate");
				verifyAndInputById(pageProperties.getProperty("MakingComplaint.PostalTown"),"Postal Town","CONGLETON");
				browser.selectfromDropBox("id",pageProperties.getProperty("MakingComplaint.County"), "Cheshire");
				verifyAndInputById(pageProperties.getProperty("MakingComplaint.PostCode"),"PostCode",userProfile.getPostCode());
			}
			else{
				ArrayList<String> contact = browser.getFromDropBox("id", pageProperties.getProperty("MakingComplaint.Displayaddr"));
				verifyAndSelectDropDownBox(pageProperties.getProperty("MakingComplaint.Displayaddr"), "Preferred Contact ", contact.get(1));
			}
			
			verifyAndInputById(pageProperties.getProperty("MakingComplaint.AcctNoEmailUs"),"Account Number",userProfile.getAccNumber().trim());
			if(browser.isElementVisible(pageProperties.getProperty("MakingComplaint.preferredContact"))){
			ArrayList<String> contact = browser.getFromDropBox("id", pageProperties.getProperty("MakingComplaint.preferredContact"));
			verifyAndSelectDropDownBox(pageProperties.getProperty("MakingComplaint.preferredContact"), "Preferred Contact ", contact.get(1));}		
			verifyAndInputById(pageProperties.getProperty("MakingComplaint.yourquery"),"Description","Test Mail");
			verifyAndClickWithXpath(pageProperties.getProperty("MakingComplaint.submit"), "Submit");
					}
		public void verifyYourComplaintField(UserProfile userProfile, String Cust, String Wordings, String addr){		
				ArrayList<String> complaint = browser.getFromDropBox("id", pageProperties.getProperty("MakingComplaint.QueryEmailUs"));
				verifyAndSelectDropDownBox(pageProperties.getProperty("MakingComplaint.QueryEmailUs"), "Complaint: ",complaint.get(1));
				verifyAndInputById(pageProperties.getProperty("MakingComplaint.FirstName"), "First Name", userProfile.getFirstName().trim());
				verifyAndInputById(pageProperties.getProperty("MakingComplaint.SurName"),"Surname",userProfile.getLastName().trim());
				verifyAndInputById(pageProperties.getProperty("MakingComplaint.BusinessName"),"BusinessName","British gas business");
				verifyAndInputById(pageProperties.getProperty("MakingComplaint.EmailAddress"),"EmailAddress",userProfile.getEmail().trim());
				verifyAndInputById(pageProperties.getProperty("MakingComplaint.TelephoneNumber"),"MobileNo",userProfile.getMobileNumber().trim());
				verifyAndClick(pageProperties.getProperty("MakingComplaint."+ Cust), Wordings);
				verifyAndInputById(pageProperties.getProperty("MakingComplaint.Postcode"),"Postcode",userProfile.getPostCode().trim());
				verifyAndClick(pageProperties.getProperty("MakingComplaint.FindAddress"), "Find Address Button");
				browser.wait(getWaitTime());
				//do{System.out.println("Searching for address");}
				//while(!browser.isElementVisible(pageProperties.getProperty("MakingComplaint.EnterAddressManually")));
				waitForObjectExistance(pageProperties.getProperty("MakingComplaint.EnterAddressManually"),"xpath");
				if(addr.equalsIgnoreCase("Manual")){				
					verifyAndClick(pageProperties.getProperty("MakingComplaint.EnterAddressManually"), "Enter Your Address Manually");
					verifyAndInputById(pageProperties.getProperty("MakingComplaint.FlatNumber"),"Flat Number","Unit 5");
					verifyAndInputById(pageProperties.getProperty("MakingComplaint.Address1"),"Address 1","Greenfield Farm Industrial Estate");
					verifyAndInputById(pageProperties.getProperty("MakingComplaint.PostalTown"),"Postal Town","CONGLETON");
					browser.selectfromDropBox("id",pageProperties.getProperty("MakingComplaint.County"), "Cheshire");
					verifyAndInputById(pageProperties.getProperty("MakingComplaint.PostCode"),"PostCode",userProfile.getPostCode());
				}
				else{
					ArrayList<String> contact = browser.getFromDropBox("id", pageProperties.getProperty("MakingComplaint.Displayaddr"));
					verifyAndSelectDropDownBox(pageProperties.getProperty("MakingComplaint.Displayaddr"), "Preferred Contact ", contact.get(1));
				}
				
				verifyAndInputById(pageProperties.getProperty("MakingComplaint.AcctNoEmailUs"),"Account Number",userProfile.getAccNumber().trim());
				if(browser.isElementVisible(pageProperties.getProperty("MakingComplaint.preferredContact"))){
				ArrayList<String> contact = browser.getFromDropBox("id", pageProperties.getProperty("MakingComplaint.preferredContact"));
				verifyAndSelectDropDownBox(pageProperties.getProperty("MakingComplaint.preferredContact"), "Preferred Contact ", contact.get(1));}	
				
				for(int i=1;i<=3500;i++){					
					String s="K";
					browser.input(pageProperties.getProperty("MakingComplaint.yourquery"),s);
				}
				verifyAndClickWithXpath(pageProperties.getProperty("MakingComplaint.submit"), "Submit");
						
		}
		public void logoutSession(){
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("MakingComplaint.Logout"))) {
				browser.clickWithXpath(pageProperties.getProperty("MakingComplaint.Logout"));
				browser.wait(getWaitTime());
				System.out.println("logout button clicked");
						}
		}
}
