
/**
 * Class Name:
 * Description:	
 **/
package bg.framework.app.functional.page.bgb;

/**
 * @author !boobalas
 */
public class ErrorMessages {
    //Registration --> Link validity
    public static final String LINK_INVALID = "Sorry, your registration link is not recognised. Please try again by selecting the link in the email you received.";
    public static final String LINK_EXPIRED = "Sorry, your registration link has expired and you are not able to continue.Please contact your Account Manager.";
    public static final String LINK_ALREADY_REGISTERED = "You have already registered. Please click here to log in";// <A> TAG TO BE VERIFIED


    //Registration --> step 1
    public static final String INVALID_ACCOUNT_NUMBER = "Your account number has not been recognised.You can find your account number on your invoice.Please check and try again.";
    public static final String INVALID_ACCOUNT_NUMBER_ATTEMPTS = "You have made several attempts to register without success. For security reasons we will not allow any further attempts today.";

    //Registration --> step 2
    public static final String PASSWORD_EMPTY = "Please enter your password. ";
    public static final String CONFIRM_PASSWORD_EMPTY = "Please confirm your password.";
    public static final String PASSWORD_INVALID = "The password you entered is not at least 8 characters long or doesn't contains both letters and numbers. Please try again. ";
    public static final String PASSWORD_SAME_AS_EMAIL = "The password you entered is not at least 8 characters long or doesn't contains both letters and numbers. Please try again.";
    public static final String CONFIRM_PASSWORD_NOT_MATCH = "Your password doesn't match. Please check and try again. ";
    public static final String TERMS_CONDITIONS_NOT_ACCEPTED = "You must accept the Terms of Use before your registration can be completed. ";

    //Login
    public static final String ACCOUNT_LOCKED = "You have entered the incorrect log in details three times. As a security precaution we will not accept anymore attempts today. Please try again tomorrow or unlock it now by resetting your password.";
    public static final String EMAIL_MANDATORY = " Please enter the email address you used to register.";
    public static final String PASSWORD_MANDATORY = " Please enter your password.";
    public static final String USER_NOT_AUTHENTICATED = "Your log in details have not been recognised. Either your email address or your password are incorrect. Please check and try again.";

    //General error 
    public static final String USER_INACTIVE = "Your access has been temporarily disabled.Please try again later or contact your Account Manager.";

    //Forgotten Password ---> Email
    public static final String SYSTEM_UNAVAILABLE = "Sorry, we're unable to send you a temporary password at the moment. Please try again later.";
    public static final String EMAIL_INVALID_FORMAT = "We didn't recognise your email address. Please enter the email address you used to register with us.";
    //public static final String USER_INACTIVE="";

    //Forgotten Password ---> Reset password
    public static final String TEMP_PASSWORD_MANDATORY = "Please enter the temporary password we emailed to you.";
    public static final String RESET_PASSWORD_FAILED = "Sorry, we're unable to reset your password at the moment. Please try again later.";
    public static final String TEMP_PASSWORD_INCORRECT = "Your password has not been recognised. Please enter the temporary password we emailed to you.";
    public static final String SAME_AS_TEMP_PASSWORD = "Your new password cannot be the same as your temporary password. Please try again.";

    //Copy Invoices
    public static final String SELECT_MANDATORY = "Please select one or more invoices from this page to download.";
    public static final String TEXT_MANDATORY = "Please enter your search criteria.";
    public static final String ACCOUNT_NO_INVALID = "Please enter a valid account number. This may start with an 'A'.";
    public static final String SITE_NO_INVALID = "Please enter a valid site number. This may start with a 'S'.";
    public static final String MPRN_INVALID = "Please enter a valid Meter Point Reference number.";
    public static final String MPAN_INVALID = "Please enter a valid 13 digit Meter Point Administration Number.";
    public static final String CONTRACT_NO_INVALID = "Please enter a valid contract number. This may start with a 'T'.";
    public static final String CUSTOMER_NO_INVALID = "Please enter a valid Customer number. This may start with a 'C'.";
    public static final String INVOICE_NO_INVALID = "Please enter a valid invoice number.";
    public static final String CUSTOMER_NAME_INVALID = "Please enter a valid customer/business name.";
    public static final String RESULT_EXCEEDED = "Your search has returned too many results. Please refine your search.";//done
    public static final String RESULT_NOT_FOUND = "Your search has returned no results.";//done
    public static final String TDDATE_INVALID = "From (dd/mm/yyyy) : The date range you selected is not valid. Please ensure the 'To' date is later than the 'From' date.";//done
    public static final String FROM_DATE_PATTERN_INVALID = "From (dd/mm/yyyy) : The date you entered is not valid. Please enter date as DD/MM/YYYY.";//done
    public static final String TO_DATE_PATTERN_INVALID = "To (dd/mm/yyyy) : The date you entered is not valid. Please enter date as DD/MM/YYYY.";//done


    //General two
    public static final String PI_SYSTEM_UNAVAILABLE = "Sorry, our systems are currently unavailable.Please try again later.";//done


}



/**
 * Class Name:
 * Description:	
 **//*
package bg.framework.app.functional.page.bgb;

*//**
 * @author !boobalas
 *//*
public class ErrorMessages {
    //Registration --> Link validity
    public static final String LINK_INVALID = "Sorry, your registration link is not recognised. Please try again by selecting the link in the email you received.";
    public static final String LINK_EXPIRED = "Sorry, your registration link has expired and you are not able to continue.Please contact your Account Manager.";
    public static final String LINK_ALREADY_REGISTERED = "You have already registered. Please click here to log in";// <A> TAG TO BE VERIFIED


    //Registration --> step 1
    public static final String INVALID_ACCOUNT_NUMBER = "Your account number has not been recognised.You can find your account number on your invoice.Please check and try again.";
    public static final String INVALID_ACCOUNT_NUMBER_ATTEMPTS = "You have made several attempts to register without success. For security reasons we will not allow any further attempts today.";

    //Registration --> step 2
    public static final String PASSWORD_EMPTY = "Please enter your password. ";
    public static final String CONFIRM_PASSWORD_EMPTY = "Please confirm your password. ";
    public static final String PASSWORD_INVALID = "The password you entered is not at least 8 characters long or doesn't contains both letters and numbers. Please try again. ";
    public static final String PASSWORD_SAME_AS_EMAIL = "Your password cannot be the same as your email address. Please try again. ";
    public static final String CONFIRM_PASSWORD_NOT_MATCH = "Your password doesn't match. Please check and try again. ";
    public static final String TERMS_CONDITIONS_NOT_ACCEPTED = "You must accept the Terms of Use before your registration can be completed. ";

    //Login
    public static final String ACCOUNT_LOCKED = "You have entered the incorrect log in details three times. As a security precaution we will not accept anymore attempts today. Please try again tomorrow or unlock it now by resetting your password.";
    public static final String EMAIL_MANDATORY = " Please enter the email address you used to register.";
    public static final String PASSWORD_MANDATORY = " Please enter your password.";
    public static final String USER_NOT_AUTHENTICATED = "Your log in details have not been recognised. Either your email address or your password are incorrect. Please check and try again.";

    //General error 
    public static final String USER_INACTIVE = "Your access has been temporarily disabled.Please try again later or contact your Account Manager.";

    //Forgotten Password ---> Email
    public static final String SYSTEM_UNAVAILABLE = "Sorry, we're unable to send you a temporary password at the moment. Please try again later.";
    public static final String EMAIL_INVALID_FORMAT = "We didn't recognise your email address. Please enter the email address you used to register with us.";
    //public static final String USER_INACTIVE="";

    //Forgotten Password ---> Reset password
    public static final String TEMP_PASSWORD_MANDATORY = "Please enter the temporary password we emailed to you.";
    public static final String RESET_PASSWORD_FAILED = "Sorry, we're unable to reset your password at the moment. Please try again later.";
    public static final String TEMP_PASSWORD_INCORRECT = "Your password has not been recognised. Please enter the temporary password we emailed to you.";
    public static final String SAME_AS_TEMP_PASSWORD = "Your new password cannot be the same as your temporary password. Please try again.";

    //Copy Invoices
    public static final String SELECT_MANDATORY = "Please select one or more invoices from this page to download.";
    public static final String TEXT_MANDATORY = "Please enter your search criteria.";
    public static final String ACCOUNT_NO_INVALID = "Please enter a valid account number. This may start with an 'A'.";
    public static final String SITE_NO_INVALID = "Please enter a valid site number. This may start with a 'S'.";
    public static final String MPRN_INVALID = "Please enter a valid Meter Point Reference number.";
    public static final String MPAN_INVALID = "Please enter a valid 13 digit Meter Point Administration Number.";
    public static final String CONTRACT_NO_INVALID = "Please enter a valid contract number. This may start with a 'T'.";
    public static final String CUSTOMER_NO_INVALID = "Please enter a valid Customer number. This may start with a 'C'.";
    public static final String INVOICE_NO_INVALID = "Please enter a valid invoice number.";
    public static final String CUSTOMER_NAME_INVALID = "Please enter a valid customer/business name.";
    public static final String RESULT_EXCEEDED = "Your search has returned too many results. Please refine your search.";//done
    public static final String RESULT_NOT_FOUND = "Your search has returned no results.";//done
    public static final String TDDATE_INVALID = "From (dd/mm/yyyy) : The date range you selected is not valid. Please ensure the 'To' date is later than the 'From' date.";//done
    public static final String FROM_DATE_PATTERN_INVALID = "From (dd/mm/yyyy) : The date you entered is not valid. Please enter date as DD/MM/YYYY.";//done
    public static final String TO_DATE_PATTERN_INVALID = "To (dd/mm/yyyy) : The date you entered is not valid. Please enter date as DD/MM/YYYY.";//done


    //General two
    public static final String PI_SYSTEM_UNAVAILABLE = "Sorry, our systems are currently unavailable.Please try again later.";//done


}
*/