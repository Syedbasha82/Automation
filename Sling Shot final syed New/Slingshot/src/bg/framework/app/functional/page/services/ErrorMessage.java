package bg.framework.app.functional.page.services;

import java.util.ArrayList;

public class ErrorMessage {

	public static final String FORM_ERROR = "Sorry, we need you to look at the following areas of the form again.";
	public static final String RECOGNISE_ERROR = "We're missing or don't recognise some information in:";
	
	public static final String INVALID_UK_POSTCODE = "Please enter a valid UK postcode.";
	public static final String HOUSE_NUMBER = "Please enter a valid house number";
	public static final String INVALID_POSTCODE = "Please enter a valid postcode";
	public static final String NON_AGREEMENT_UK = "We cannot provide you with the quote for our insurance and repair products.";
									
	public static final String SELECT_ADDRESS = "Please select an address.";
	public static final String DUPLICATE_ADDRESS = "Please add another UK address.";	
	public static final String MAN_HOUSE_NUMBER = "Please enter a valid house number,house name or flat number";
	public static final String ENTER_ADDRESSS = "Please enter a valid address line 1";
	public static final String POSTAL_TOWN = "Please enter a valid postal town";
	
	public static final String INVALID_DATE = "Please enter a valid CP12 date format DD/MM/YYYY.";
	public static final String INVALID_PACKAGE= "Please select which package you would like to receive a quote for.";
	public static final String INVALID_HOUSE="Please enter a house number,house name or flat number.";
	
	
	public String e(String err){
	ArrayList<String> errors=new ArrayList<String>();
	String res="Y";
	errors.add("Please enter a valid postcode");
	errors.add("Please enter your first name");
	errors.add("Please enter a valid email address");
	errors.add("Please enter a valid telephone number");
	errors.add("Please enter a valid name on card");
	errors.add("Please enter a valid card number");
	errors.add("Please enter a valid issue no");
	errors.add("Please enter a house number,house name or flat number.");
	
	errors.add("Please select valid card type");
	errors.add("Please select valid start month and year");
	errors.add("Please select valid expiry month and year");
	errors.add("Please select an address to proceed");
		
	errors.add("Please enter the account holder name to continue this process");
	errors.add("Please enter the name as it appears on the card");
	errors.add("Please enter the card number as it appears on the card");
	errors.add("Please enter the expiry date as it appears on the card");
	errors.add("Please enter a start date to continue with this process");
	errors.add("Please enter your town/city.");
	errors.add("Please enter your bank account number to continue this process");
	errors.add("Please enter your address.");
	errors.add("Please enter your surname.");
	
	errors.add("Please select an address.");
	
	errors.add("Please choose a card type from the drop down to proceed.");
		
	errors.add("Please specify a sort code to continue this process");
	errors.add("Please search and select the address");
	
	for(String error:errors){
		
		if(err.contains(error)){
			res="Y";
			return error;
			
		}else{
			res="N";
		}
	}
	return res;
	}
	
}
