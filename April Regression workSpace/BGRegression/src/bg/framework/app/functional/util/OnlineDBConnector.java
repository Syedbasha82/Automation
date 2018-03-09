package bg.framework.app.functional.util;

import bg.framework.app.functional.action.bgb.GetAQuoteAction;
import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.GetAQuoteDetails;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.bgb.GaqQuotePage;
import bg.framework.app.functional.page.bgb.GetaQuoteDetailsPage;
import bg.framework.app.functional.page.bgb.GetaquoteCombinedEnergyPage;
//import bg.framework.app.functional.page.bgb.GaqQuotePage;
import net.sf.saxon.functions.Parse;
import oracle.jdbc.pool.OracleDataSource;

import org.springframework.core.Conventions;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import javax.sql.DataSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class OnlineDBConnector {

    private static SimpleJdbcTemplate jdbcTemplate;
    private static OracleDataSource dataSource;
    private OracleDataSource MLUdataSource;
    static String systemDate;

    public static DataSource getDataSource() {
        if (dataSource != null) {
            return dataSource;
        }
        try {
            Class.forName(ApplicationConfig.DATABASE_DRIVER);
            dataSource = new OracleDataSource();
            dataSource.setURL(ApplicationConfig.DATABASE_URL);
            dataSource.setUser(ApplicationConfig.DATABASE_USERNAME);
            dataSource.setPassword(ApplicationConfig.DATABASE_PASSWORD);
            return dataSource;
        } catch (Exception e) {
            System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
            Report.updateTestLog("Connection to online database failed", "FAIL");
            e.printStackTrace();
        }
        return null;
    }

      
    public  DataSource getMLUDataSource(){
    	if (MLUdataSource != null) {
            return MLUdataSource;
        }
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            MLUdataSource = new OracleDataSource();
            MLUdataSource.setURL(ApplicationConfig.MLUDBUrl);
            MLUdataSource.setUser(ApplicationConfig.MLUDBUsername);
            MLUdataSource.setPassword(ApplicationConfig.MLUDBPassword);
            return MLUdataSource;
        } catch (Exception e) {
            System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
            Report.updateTestLog("Connection to online database failed", "FAIL");
            e.printStackTrace();
        }
        return null;
    }
    
    public String anonymousAudit(String email) {
        
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        
        //Select * from PO_Ta_audit_details where Audit_Details like '%sowmiya@gmail.com%' and Audit_Details like '%Successful confirm appointment%' and audit_event_type_id='994'
        //and transaction_type_id='976'
        String strQuery = "Select Audit_Details from PO_Ta_audit_details where Audit_Details like '%"+email+"%' and Audit_Details like '%Successful confirm appointment%' and audit_event_type_id='994'  and rownum=1 ORDER BY audit_TIMESTAMP DESC ";
        System.out.println(strQuery);
        return jdbcTemplate.queryForObject(strQuery, String.class);
    }

    
    public String getCustomerMasterDB(String UCRN){
    	try{
    		String CustomerMasterDB=null;
        	jdbcTemplate = new SimpleJdbcTemplate(getMLUDataSource());
        	String strQuery = "select CUST_MASTERSHIP from ZTONS_CUST where UCRN = '"+UCRN+"'";
        	
        	CustomerMasterDB = jdbcTemplate.queryForObject(strQuery,String.class);
        	
        	return CustomerMasterDB;
    	}
    	catch(EmptyResultDataAccessException e){
    		return null;
    	}
    	
    }
    
    public String getBPnumber(String UCRN){
    	String BPnumber="";
    	jdbcTemplate = new SimpleJdbcTemplate(getMLUDataSource());
    	String strQuery = "select BP_NUMBER from ZTONS_CUST where UCRN = '"+UCRN+"'";
    	BPnumber = jdbcTemplate.queryForObject(strQuery,String.class);
    	return BPnumber;
    }
    
    

    public int getRegDBCount(String strQuery) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        System.out.print(strQuery);
        int rowCount = jdbcTemplate.queryForInt(strQuery);
        return (rowCount);
    }
    
    public String leadOfLandLord(String date) {
    	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    	String strQuery = "Select LEAD_DATA from PO_TA_LANDLORDS_QUOTE_LEAD  where LEAD_TIME_STAMP >  to_Date ('"
				+ date + "','dd-mm-yy-hh24.mi.ss')";
    	System.out.println(strQuery);
    	 return jdbcTemplate.queryForObject(strQuery, String.class);
    }

    public String getEshopNotificationDetailsSMB(String date) {
    	System.out.println("11111111111111111111111"+date);
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strQuery = "Select NOTIFICATION_EMAIL_ADDRESS from PO_TA_NOTIFICATION_DETAILS where NOTIFICATION_SEND_TIMESTAMP > to_Date('"
				+ date
				+ "','dd-mm-yy-hh24.mi.ss') and rownum=1 and NOTIFICATION_TEMPLATE_ID = '5030' ORDER BY NOTIFICATION_SEND_TIMESTAMP DESC ";
        System.out.println(strQuery);
        return jdbcTemplate.queryForObject(strQuery, String.class);
    }
	
	public String DBsysdateDdmmyyhhmi() {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		systemDate = jdbcTemplate.queryForObject(
				"select to_char(SYSTIMESTAMP -(5/1440),'DD-MM-YY HH24.MI') from dual",
				String.class);
        return systemDate;
    }
	
    public String getEshopLeadIDSMB(String date) {
    	
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strQuery = "Select LEAD_ID from PO_TA_LEAD  where LEAD_TIME_STAMP > to_Date('"
				+ date
				+ "','dd-mm-yy-hh24.mi.ss') and rownum=1 ORDER BY LEAD_TIME_STAMP DESC ";
        System.out.println(strQuery);
        return jdbcTemplate.queryForObject(strQuery, String.class);
    }
    public String getEshopAuditDetailsSMB(String date, String accountnumber) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strQuery = "Select AUDIT_DETAILS from PO_TA_AUDIT_DETAILS where AUDIT_TIMESTAMP > to_Date('"
				+ date
				+ "','dd-mm-yy-hh24.mi.ss') and rownum=1 and ACCOUNT_NUMBER = '"+ accountnumber + "' ORDER BY AUDIT_TIMESTAMP DESC ";
        System.out.println(strQuery);
        return jdbcTemplate.queryForObject(strQuery, String.class);
    }
    public String getEshopAuditEventTypeSMB(String date,String accountnumber) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strQuery = "Select AUDIT_EVENT_TYPE_ID from PO_TA_AUDIT_DETAILS where AUDIT_TIMESTAMP > to_Date('"
				+ date
				+ "','dd-mm-yy-hh24.mi.ss') and rownum=1 and ACCOUNT_NUMBER = '"+ accountnumber + "' ORDER BY AUDIT_TIMESTAMP DESC ";
        System.out.println(strQuery);
        return jdbcTemplate.queryForObject(strQuery, String.class);
    }
    
    public String getOAMdetailsSMB(String email) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strQuery = "Select UCRN from PO_TA_OAM_CUSTOMER where oam_email_address ='"
				+ email
				+ "'and rownum=1 ORDER BY LAST_LOGIN_TIMESTAMP DESC ";
        System.out.println(strQuery);
        return jdbcTemplate.queryForObject(strQuery, String.class);
    }
    public String getOAMdetailsemailSMB(String ucrn) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strQuery = "Select OAM_EMAIL_ADDRESS from PO_TA_OAM_CUSTOMER where ucrn ='"
				+ ucrn
				+ "' and rownum=1 ORDER BY LAST_LOGIN_TIMESTAMP DESC ";
        System.out.println(strQuery);
        return jdbcTemplate.queryForObject(strQuery, String.class);
    }
    
    public String getOAMEmail(String ucrn) {
    	String OAMEmail = null;
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strQuery = "Select OAM_EMAIL_ADDRESS from PO_TA_OAM_CUSTOMER where ucrn ='"
				+ ucrn
				+ "'";
        System.out.println(strQuery);
       OAMEmail = jdbcTemplate.queryForObject(strQuery, String.class);
       return OAMEmail;
    }
    
    public String getOAMcustomerIDSMB(String ucrn) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strQuery = "Select OAM_CUSTOMER_ID from OAM_CUSTOMER_BRANDS where ucrn ='"
				+ ucrn
				+ "' and rownum=1 ORDER BY LAST_LOGIN_TIMESTAMP DESC ";
        System.out.println(strQuery);
        return jdbcTemplate.queryForObject(strQuery, String.class);
    }
    public String getOAMcustomeriddetailsemailSMB(String ucrn) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strQuery = "Select CUSTOMER_ID from PO_TA_OAM_CUSTOMER where ucrn ='"
				+ ucrn
				+ "'and rownum=1 ORDER BY LAST_LOGIN_TIMESTAMP DESC ";
        System.out.println(strQuery);
        return jdbcTemplate.queryForObject(strQuery, String.class);
    }
    public String getCustomerIdSMB(String CustomerID) {
    	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strQuery = "select OAM_CUSTOMER_ID from OAM_CUSTOMER_BRANDS where oam_customer_id="+CustomerID+" and rownum=1";
        System.out.println(jdbcTemplate.queryForObject(strQuery, String.class));
        //String xmlValue=jdbcTemplate.queryForObject(strQuery, String.class);
        return jdbcTemplate.queryForObject(strQuery, String.class);
    }
    public String getBrandIdSMB(String CustomerID) {
    	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strQuery = "select BRAND_ID from OAM_CUSTOMER_BRANDS where oam_customer_id="+CustomerID+" and rownum=1";
        System.out.println(jdbcTemplate.queryForObject(strQuery, String.class));
        //String xmlValue=jdbcTemplate.queryForObject(strQuery, String.class);
        return jdbcTemplate.queryForObject(strQuery, String.class);
    }
    public String getEshopTransactionTypeSMB(String date, String accountnumber) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strQuery = "Select TRANSACTION_TYPE_ID from PO_TA_AUDIT_DETAILS where AUDIT_TIMESTAMP > to_Date('"
				+ date
				+ "','dd-mm-yy-hh24.mi.ss') and rownum=1 and ACCOUNT_NUMBER = '"+ accountnumber + "' ORDER BY AUDIT_TIMESTAMP DESC ";
        System.out.println(strQuery);
        return jdbcTemplate.queryForObject(strQuery, String.class);
    }
    
    public String getCustomeridSMB(String date) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strQuery = "Select TRANSACTION_TYPE_ID from PO_TA_AUDIT_DETAILS where AUDIT_TIMESTAMP > to_Date('"
				+ date
				+ "','dd-mm-yy-hh24.mi.ss') and rownum=1 ORDER BY AUDIT_TIMESTAMP DESC ";
        System.out.println(strQuery);
        return jdbcTemplate.queryForObject(strQuery, String.class);
    }

/*	public static void main(String rr[]){
		String a="10014052";
		String orderDate=new OnlineDBConnector().DBsysdate();
		OnlineDBConnector obj=new OnlineDBConnector();
		 jdbcTemplate = new SimpleJdbcTemplate(obj.getDataSource());
	        String strQuery = "select OAM_CUSTOMER_ID from OAM_CUSTOMER_BRANDS where oam_customer_id="+a+"";
	        System.out.println("Senthil"+strQuery);
	        System.out.println(jdbcTemplate.queryForObject(strQuery, String.class));
	        
	        String xmlValue=jdbcTemplate.queryForObject(strQuery, String.class);
	        
	        if (xmlValue.contains("<FirstName>")) {
	            String supplyPointString = xmlValue.substring(
	                    (xmlValue.indexOf("<FirstName>") + 6),
	                    xmlValue.indexOf("</FirstName>")
	                            );
				System.out.println("supply pin String:"+ xmlValue);
				
	}*/
		 
		/* new OnlineDBConnector().DBsysdate();
			new OnlineDBConnector();
			 jdbcTemplate = new SimpleJdbcTemplate(obj.getDataSource());
		        String strQuery = "Select OAM_CUSTOMER_ID from OAM_CUSTOMER_ID where OAM_CUSTOMER_ID='10014672'"; //BRAND_ID
		        
		        int rowcount= jdbcTemplate
	            .queryForInt( "Select count(*)  from OAM_CUSTOMER_ID where OAM_CUSTOMER_ID='10014672'");
			
		        System.out.println("Senthil"+rowcount);*/
				

    public String getColumn(String strColName, String strQuery) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String result = null;
		try {
			System.out.println("query: " + strQuery);
        result = jdbcTemplate.queryForObject(strQuery, String.class);
		} catch (IncorrectResultSizeDataAccessException e) {
             Report.updateTestLog("Test data error", "FAIL");
        }
        return result;
    }

    public void activateUser(String UCRN) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        int rowsAffected = jdbcTemplate
                .update("update PO_TA_OAM_CUSTOMER set  LOGIN_TRY_COUNT = 0, PASSWORD = 'EMKPnPBmhZXUXBCQp7Sirpjt+lg=', ONETIME_PASSWORD_FLAG = 'N',FREEZE_ACCOUNT = 'N'"
						+ ", PROFILE_STATUS = 'Active' where UCRN='"
						+ UCRN
						+ "'");
		// PASSWORD = 'EMKPnPBmhZXUXBCQp7Sirpjt+lg=';
        if (rowsAffected == 0) {
			try {
				String selectStatus = "select PROFILE_STATUS from PO_TA_OAM_CUSTOMER where UCRN='"
						+ UCRN + "'";
				String status = jdbcTemplate.queryForObject(selectStatus,
						String.class);
				if (status.equalsIgnoreCase("Active")) {
					Report.updateTestLog(
							"User status already active in Online database",
							"PASS");
                return;
            }
				Report.updateTestLog(
						"Unable to activate customer in Online database",
						"FAIL");
			} catch (Exception e) {

                }
		} else if (rowsAffected >= 1)
			Report.updateTestLog(
					"User status updated to Active in Online database", "PASS");

    }

    public String DBsysdate() {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		systemDate = jdbcTemplate.queryForObject(
				"select to_char(SYSTIMESTAMP,'DD-MM-YY HH24.MI.SS') from dual",
				String.class);
        return systemDate;
    }
    
    
/*    public static void main(String args[]) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		systemDate = jdbcTemplate.queryForObject(
				"select to_char(SYSTIMESTAMP,'DD-MM-YY HH24.MI.SS') from dual",
				String.class);
       System.out.println("sys date: "+systemDate);
    }*/
    
    public String DBsysdateless() {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		systemDate = jdbcTemplate.queryForObject(
				"select to_char(SYSTIMESTAMP + (5/1440),'DD-MM-YY HH24.MI.SS') from dual",
				String.class);
        return systemDate;
    }


    public String verifyLeadDBforAutoCef(String referenceNo) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        if ((jdbcTemplate.queryForInt(
				"Select count(*) from PO_TA_LEAD_AUTOCEF where LEAD_ID = ?",
				referenceNo)) != 0) {
            String leadType = jdbcTemplate.queryForObject(
                    "Select LEAD_TYPE from PO_TA_LEAD_AUTOCEF where LEAD_ID = "
                            + referenceNo, String.class);
            return leadType;
		} else {
			Report.updateTestLog("Autocef lead not in online DB", "DONE");
        }
        return "";
    }

    public String verifyQuote(String referenceNo) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        if ((jdbcTemplate.queryForInt(
				"Select count(*) from PO_TA_LEAD_AUTOCEF where LEAD_ID = ?",
				referenceNo)) != 0) {
            String leadType = jdbcTemplate.queryForObject(
                    "Select LEAD_TYPE from PO_TA_LEAD_AUTOCEF where LEAD_ID = "
                            + referenceNo, String.class);
            return leadType;
		} else {
			Report.updateTestLog("Autocef lead not in online DB", "DONE");
        }
        return "";
    }

    public int verifyAuditDBContactUs(String Email) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd HH:mm:ss");
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        int rowCount = jdbcTemplate
                .queryForInt("Select count(*) from PO_TA_AUDIT_DETAILS  where(OAM_EMAIL_ADDRESS = '"
                        + Email
                        + "')  AND AUDIT_TIMESTAMP > to_date('"
                        + Report.startDate + "','yyyyMMddHH24miss')");
		if (rowCount == 0) {
			Report.updateTestLog("Contactus audit not stored in Online DB",
					"FAIL");
            return 0;
        }
        return rowCount;
    }

    public int verifyAudit(String Email) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd HH:mm:ss");
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        int rowCount = jdbcTemplate
                .queryForInt("Select count(*) from PO_TA_AUDIT_DETAILS where (OAM_EMAIL_ADDRESS = '"
                        + Email
                        + "') AND AUDIT_TIMESTAMP > to_date('"
                        + Report.startDate+"','yyyyMMddHH24miss')");
		if (rowCount == 0) {
			Report.updateTestLog(
					"Forgot Password audit not stored in Online DB", "FAIL");
            return 0;
		} else {
			Report.updateTestLog("Forgot Password audit stored in Online DB",
					"PASS");
        }
        return rowCount;
    }

        public String verifyAuditDetails(String date, String audit_event_type_id) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd HH:mm:ss");
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		String data = jdbcTemplate.queryForObject(
				"Select audit_details from PO_TA_AUDIT_DETAILS  where AUDIT_EVENT_TYPE_ID = '"
						+ audit_event_type_id
						+ "' AND AUDIT_TIMESTAMP > to_date('" + date
						+ "','dd-mm-yy-hh24.mi.ss')", String.class);
        return data;
    }

    public void addnewuserprofile() {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        int rowsAffected = jdbcTemplate
                .update("Insert INTO PO_TA_OAM_CUSTOMER(CUSTOMER_ID,UCRN,OAM_EMAIL_ADDRESS,PASSWORD,"
                        + "SECURITY_QUESTION,SECURITY_ANSWER,LOGIN_TRY_COUNT,SECURITY_TRY_COUNT,EMAIL_VALIDATED_FLAG,"
                        + "PROFILE_STATUS,ONETIME_PASSWORD_FLAG,LAST_LOGIN_TIMESTAMP,PASSWORD_CHANGE_TIMESTAMP,"
                        + "UNSUCCESSFUL_LOGIN_TIMESTAMP,VALIDATION_KEY,FREEZE_REASON,FREEZE_ACCOUNT,FIRST_NAME,"
                        + "LAST_NAME,TITLE,REGISTER_DATE,NUM_OF_LOGINS,CUST_DISCUSSION_RQD,CUST_DISCUSSION_LEAD_TIMESTAMP,"
                        + "DATA_CHECK_DONE_FLAG,TREATMENT_REFRESH_TIMESTAMP,CUSTOMER_LEVEL,REG_TYPE,REG_COMP_DATE) "
                        + "VALUES(11111,111111000000,'randommail@bgdigitaltest.co.uk','EMKPnPBmhZXUXBCQp7Sirpjt+lg=','place of birth',"
                        + "'4HQTjUWwSUlmuFqy4x+nugaE9Ds=',0,0,'Y','Active','N','13-DEC-11 18.01.58.000000000','02-NOV-11 11.36.38.000000000',"
                        + "'24-NOV-11 16.24.02.000000000',null,null,'N','banu','rajendran','Miss','11-OCT-10 13.01.07.497560000',0,null,null,'Y',null,'M',null,null");
        if (rowsAffected != 1) {
        }
    }
    

    public void updateUserEmail(String strUCRN, String strEmail) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strUpdateEmailQry = "Update po_ta_oam_customer Set oam_email_address = 'EMAIL' where UCRN='USERUCRN'";
        strUpdateEmailQry = strUpdateEmailQry.replace("USERUCRN", strUCRN);
        strUpdateEmailQry = strUpdateEmailQry.replace("EMAIL", strEmail);
        int rowsAffected = jdbcTemplate.update(strUpdateEmailQry);

        jdbcTemplate.update("commit");
        if (rowsAffected != 1) {
			Report.updateTestLog(
					"Unable to update customer email in Online DB", "FAIL");
        } else {
            Report.updateTestLog("Customer email updated in Online DB", "DONE");
        }
    }

    public void updateTempPassword(String UCRN) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        int rowsAffected = jdbcTemplate
                .update("update PO_TA_OAM_CUSTOMER set PASSWORD = '6HJGT00iErJ7VbUS7pineJ4R838=' where UCRN='"
                        + UCRN + "'");
        if (rowsAffected != 1) {
			Report.updateTestLog(
					"Unable to update customer password in Online DB", "FAIL");
        } else {
			Report.updateTestLog("Temporary Password Set to 'temp12345'",
					"DONE");
        }
    }

    public void updateOneTimePassword(String UCRN, String pwd) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        int rowsAffected = jdbcTemplate
				.update("update PO_TA_OAM_CUSTOMER set ONETIME_PASSWORD = '"
						+ pwd + "',PASSWORD = '" + pwd + "'where UCRN='" + UCRN
						+ "'");
        if (rowsAffected != 1) {
			Report.updateTestLog(
					"Precondition: One Time Password Setup failed", "FAIL");
        } else {
			Report.updateTestLog("Temporary Password Set to 'password12'",
					"DONE");
        }
    }

    public void deleteuserprofile() {
        int UCRN = 0;
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		jdbcTemplate.update("Delete from PO_TA_OAM_CUSTOMER where(UCRN='"
				+ UCRN + "'");

    }

    public void updateDB(String strQuery) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        jdbcTemplate.update(strQuery);
        jdbcTemplate.update("commit");
    }

    public String verifyleadDBforGaq(String leadTypeGaq) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        return jdbcTemplate.queryForObject(
				"Select LEAD_TYPE from BGB_TA_LEAD where LEAD_ID ='"
						+ leadTypeGaq + "'", String.class);
    }
    
    public String getAddress(String PostCode){
    	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    	String strSelectQry = "Select ADDRESSID from PO_TR_ADDRESS where POSTCODE='PostCode'";
    	strSelectQry = strSelectQry.replace("PostCode", PostCode);
    	 System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj" + strSelectQry);
    	return jdbcTemplate.queryForObject(strSelectQry, String.class);
    	
    }
    
    public void deRegisterAddress(String PostCode){
    	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    	String AddresId = new OnlineDBConnector().getAddress(PostCode);
    	String strDeleteQry = "Delete from PO_TR_ADDRESS where POSTCODE='PostCode'";
    	String strDeleteQry2 = "Delete from PO_TR_ENERGYSHOP_ADDRRESS where ADDRESSID='AddressID'";
    	strDeleteQry = strDeleteQry.replace("PostCode", PostCode);
    	strDeleteQry2 = strDeleteQry2.replace("AddressID", AddresId);
        jdbcTemplate.update(strDeleteQry);
        jdbcTemplate.update(strDeleteQry2);
        jdbcTemplate.update("commit");
        System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj" + AddresId);
    }
    
    public String DBsystemdate() {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		systemDate = jdbcTemplate.queryForObject(
				"select to_char(SYSTIMESTAMP,'DD-MON-YY') from dual",
				String.class);
        return systemDate;
    }
    
    public String getLeadIDforUddingston(){
    	String sysDate = DBsystemdate();
    	System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj" + sysDate);
    	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    	String strSelectQry = "Select LEAD_ID from PO_TA_SERVICES_LEAD where LEAD_TIME_STAMP >" + "'" + sysDate + "'" + "and rownum=1 order by lead_time_stamp desc";
    	return jdbcTemplate.queryForObject(strSelectQry, String.class);
    }
  
    public void deRegister(String strUCRN) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String logStatus = "PASS";
        String logInfo = "";
        String[] unRegister = {
                "Delete FROM PO_TA_REG_PROFILE_TEMP where UCRN='USERUCRN'",
                "DELETE FROM PO_TA_SECONDARY_UCRN where PRIMARY_UCRN='USERUCRN'",
                "DELETE FROM PO_TA_SECONDARY_UCRN where SECONDARY_UCRN='USERUCRN'",
                "DELETE FROM ASV_TA_PRE_REG_TEMP where UCRN='USERUCRN'",
                "DELETE FROM HS_MIGRATED_USER where HS_SIEBEL_UCRN='USERUCRN'",
                "Delete FROM OAM_CUSTOMER_BRANDS Where OAM_CUSTOMER_ID = (SELECT  CUSTOMER_ID FROM PO_TA_OAM_CUSTOMER where UCRN='USERUCRN')",
				"DELETE FROM PO_TA_OAM_CUSTOMER where UCRN='USERUCRN'" };
        logInfo = logInfo + "Executing Delete Queries for UCRN: " + strUCRN
                + " in tables: ";
        for (String query : unRegister) {
            query = query.replace("USERUCRN", strUCRN);
            jdbcTemplate.update(query);
            jdbcTemplate.update("commit");
            System.out.println("Completed Query: " + query);
			logInfo = logInfo
					+ ", "
					+ query.substring(query.indexOf("FROM") + 4,
							query.indexOf("where"));
        }
        Report.updateTestLog(logInfo, logStatus);
    }

    public String getPassword(String strUCRN) {
		String strRetreivePwdQry = "select password from po_ta_oam_customer where UCRN='"
				+ strUCRN + "'and rownum=1";
        System.out.print(strRetreivePwdQry);
        return getColumn("PASSWORD", strRetreivePwdQry);
    }

    public String getUserEmail(String strUCRN) {
        String strRetreiveEmailQry = "select oam_email_address from po_ta_oam_customer where UCRN='USERUCRN' and rownum=1";
        strRetreiveEmailQry = strRetreiveEmailQry.replace("USERUCRN", strUCRN);
        System.out.print(strRetreiveEmailQry);
        return getColumn("oam_email_address", strRetreiveEmailQry);
    }

    public String getTitle(String strUCRN) {
        String strRetreiveEmailQry = "select title from po_ta_oam_customer where UCRN='USERUCRN'";
        strRetreiveEmailQry = strRetreiveEmailQry.replace("USERUCRN", strUCRN);
        return getColumn("Title", strRetreiveEmailQry);
    }

    public String getFirstName(String strUCRN) {
        String strRetreiveEmailQry = "select first_name from po_ta_oam_customer where UCRN='USERUCRN'";
        strRetreiveEmailQry = strRetreiveEmailQry.replace("USERUCRN", strUCRN);
        return getColumn("First_name", strRetreiveEmailQry);
    }

    public String getLastName(String strUCRN) {
        String strRetreiveEmailQry = "select last_name from po_ta_oam_customer where UCRN='USERUCRN'";
        strRetreiveEmailQry = strRetreiveEmailQry.replace("USERUCRN", strUCRN);
        return getColumn("Last_name", strRetreiveEmailQry);
    }

    public String getSecurityQuestion(String strUCRN) {
        String strRetreiveEmailQry = "select Security_question from po_ta_oam_customer where UCRN='USERUCRN'";
        strRetreiveEmailQry = strRetreiveEmailQry.replace("USERUCRN", strUCRN);
        return getColumn("Security_question", strRetreiveEmailQry);
    }

    public String getSecurityAnswer(String strUCRN) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        int rowsAffected = jdbcTemplate
                .update("update PO_TA_OAM_CUSTOMER set Security_answer = 'EMKPnPBmhZXUXBCQp7Sirpjt+lg=' where UCRN='"
                        + strUCRN + "'");
        String strRetreiveEmailQry = "select security_answer from po_ta_oam_customer where UCRN='USERUCRN'";
        strRetreiveEmailQry = strRetreiveEmailQry.replace("USERUCRN", strUCRN);
        return "password12";
    }

    public void deleteUserDetails(String strUCRN) {
        String strDeleteEmailQry = "DELETE FROM PO_TA_OAM_CUSTOMER where UCRN='USERUCRN'";
        strDeleteEmailQry = strDeleteEmailQry.replace("USERUCRN", strUCRN);
        jdbcTemplate.update(strDeleteEmailQry);
        jdbcTemplate.update("commit");
    }

    public int verifyAuditBgbMs(String Email) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd HH:mm:ss");
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        return jdbcTemplate
                .queryForInt("Select count(*) from BG_BUSINESS_TA_AUDIT_DETAILS where(EMAIL_ADDRESS = '"
                        + Email
                        + "')  AND AUDIT_TIMESTAMP > to_date('"
                        + Report.startDate + "','dd-mm-yy-hh24.mi.ss')");
    }

    public String getTransactionTypeMs(String Email, String sysDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd HH:mm:ss");
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		return jdbcTemplate
				.queryForObject(
                "Select TRANSACTION_TYPE_ID from BG_BUSINESS_TA_AUDIT_DETAILS where(EMAIL_ADDRESS = '"
								+ Email
								+ "')  AND AUDIT_TIMESTAMP > to_date('"
								+ sysDate + "','dd-mm-yy-hh24.mi.ss')",
						String.class);
    }

    public String getAuditTypeMs(String Email, String sysDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd HH:mm:ss");
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());//
		return jdbcTemplate
				.queryForObject(
                "Select AUDIT_EVENT_TYPE_ID from BG_BUSINESS_TA_AUDIT_DETAILS where EMAIL_ADDRESS = '"
								+ Email
								+ "'  AND AUDIT_TIMESTAMP > to_date('"
								+ sysDate + "','dd-mm-yy-hh24.mi.ss')",
						String.class);
    }

    public String getAuditType(String auditType) {

        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        return jdbcTemplate
                .queryForObject(
                        "Select AUDIT_EVENT_TYPE from BG_BUSINESS_TR_AUDITEVENT_TYPE where AUDIT_EVENT_TYPE_ID = '"
                                + auditType + "'", String.class);
    }

    public int  getAuditTypeIdMs(String Email, String sysDate, int auditType) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd HH:mm:ss");
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());//
		System.out.println("query" + Email + sysDate + auditType);
		return jdbcTemplate
				.queryForInt("Select count(*) from BG_BUSINESS_TA_AUDIT_DETAILS where EMAIL_ADDRESS = '"
						+ Email
						+ "'  AND AUDIT_TIMESTAMP > to_date('"
						+ sysDate
						+ "','dd-mm-yy-hh24.mi.ss') AND AUDIT_EVENT_TYPE_ID = '"
						+ auditType + "'");

        }

    public int getAuditTypeId(String auditType) {

        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        return jdbcTemplate
				.queryForInt("Select AUDIT_EVENT_TYPE_ID from BG_BUSINESS_TR_AUDITEVENT_TYPE where AUDIT_EVENT_TYPE = '"
                                + auditType + "'");
    }

    public String getTransType(String transType) {

        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        return jdbcTemplate
                .queryForObject(
                        "Select TRANSACTION_TYPE from BG_BUSINESS_TR_TRANSACTIONTYPE where TRANSACTION_TYPE_ID = '"
                                + transType + "'", String.class);
    }

    public int getLoginTryCount(String ucrn) {

        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		return jdbcTemplate.queryForObject(
				"Select Login_try_count from PO_TA_OAM_CUSTOMER where ucrn = '"
						+ ucrn + "'", Integer.class);
    }

    public int getLeadCount(String USERLEADTYPE) {
        String sysDate = DBsysdate();
        String strQuery = "Select count(*) from PO_TA_PRODUCT_LEAD  where LEAD_TYPE = 'USERLEADTYPE' and LEAD_TIME_STAMP > to_Date("
                + "(sysdate)" + ",'DD-MON-YY') and rownum=1";
        strQuery = strQuery.replace("USERLEADTYPE", USERLEADTYPE);
        return jdbcTemplate.queryForInt(strQuery);
    }

    public int getLoftLeadCount(String USERLEADTYPE) {
        String sysDate = DBsysdate();
        String strQuery = "Select count(*) from PO_TA_ESS_CALLBACK_LEAD_SITEL  where LEAD_TYPE = 'USERLEADTYPE' and LEAD_TIME_STAMP > to_Date("
                + "(sysdate)" + ",'DD-MON-YY') and rownum=1";
        strQuery = strQuery.replace("USERLEADTYPE", USERLEADTYPE);
        return jdbcTemplate.queryForInt(strQuery);
    }

    public String getHelpandAdviceAuditType(String auditType) {

        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		return jdbcTemplate
				.queryForObject(
                "Select AUDIT_EVENT_TYPE_ID from PO_TA_AUDIT_DETAILS where UCRN = '"
                        + auditType + "' and rownum=1", String.class);
    }

    public void dbAccountunlock(String ucrn) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        jdbcTemplate
                .update("Update PO_TA_OAM_CUSTOMER Set  LOGIN_TRY_COUNT=0,  PROFILE_STATUS = 'Active', ONETIME_PASSWORD_FLAG ='N' , FREEZE_ACCOUNT='N' where UCRN='"
                        + ucrn + "'");
    }

    public String getLeadType() {
        String sysDate = DBsysdate();
        String strQuery = "Select LEAD_TYPE from PO_TA_LEAD  where LEAD_TIME_STAMP > to_Date("
                + sysDate + ",'DD-MON-YY')";
        return jdbcTemplate.queryForObject(strQuery, String.class);
    }

    public void resetMeterReadCount(String accountNumber) {
        String resetMeterReadQuery = "Update PO_TA_PAYMENT_METER_COUNT Set  METER_READ_TRY_COUNT=0 where ACCOUNT_NUMBER='"
                + accountNumber + "'";
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        jdbcTemplate.update(resetMeterReadQuery);
    }

	public int getSupplyPointNumbernew(String leadID) {
        int RetVal = 0;
        String queryLeadData = "Select LEAD_DATA from BGB_TA_LEAD where lead_id='USERLEADID'";
        queryLeadData = queryLeadData.replace("USERLEADID", leadID);
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		String xmlValue = jdbcTemplate.queryForObject(queryLeadData,
				String.class);
        if (xmlValue.contains("<supplypointnumber>0")) {
            String supplyPointString = xmlValue.substring(
                    (xmlValue.indexOf("<supplypointnumber>0") + 19),
                    xmlValue.indexOf("</supplypointnumber>",
                            xmlValue.indexOf("<supplypointnumber>0")));
			System.out.println("supply pin String:           "
					+ supplyPointString);
            RetVal = Integer.parseInt(supplyPointString.substring(0, 2));
        }
        return RetVal;
    }

    public void dbAccountlock(String ucrn) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        jdbcTemplate
                .update("Update PO_TA_OAM_CUSTOMER Set  LOGIN_TRY_COUNT=0,  PROFILE_STATUS = 'Active', ONETIME_PASSWORD_FLAG ='N' , FREEZE_ACCOUNT='Y' where UCRN='"
                        + ucrn + "'");
    }

    public void updateTestPassword(String email) {
        System.out.println(email);
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String query = "update BG_BUSINESS_TA_CUSTOMER_REG set PASSWORD='1QWDIobiwdKDnzlN6Js6+Nw/jB8=' where email='"
                + email + "'";
        int rowsAffected = jdbcTemplate.update(query);
        if (rowsAffected == 1) {
            System.out.println("Row Updated");
        } else {
            System.out.println("Row Not Updated");
        }
    }

    public void updateDefPassword(String email) {
        System.out.println(email);
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String query = "update BG_BUSINESS_TA_CUSTOMER_REG set PASSWORD='EMKPnPBmhZXUXBCQp7Sirpjt+lg=' where email='"
                + email + "'";
        int rowsAffected = jdbcTemplate.update(query);
        if (rowsAffected == 1) {
            System.out.println("Row Updated");
        } else {
            System.out.println("Row Not Updated");
        }
    }

	public String getCustomerID(String UCRN) {
		String bname2 = "SELECT  CUSTOMER_ID FROM PO_TA_OAM_CUSTOMER where UCRN = '"
				+ UCRN + "'";
    	    return getColumn("CUSTOMER_ID", bname2);

    }

	public void changeBrandName(String bname, String BrandName) {
		jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		String queryForBrandCount = "select count(*) from OAM_CUSTOMER_BRANDS where OAM_CUSTOMER_ID ='"
				+ bname + "'";
		int rowCount = Integer.parseInt(getColumn("count(*)",
				queryForBrandCount));

		if (BrandName.trim().equalsIgnoreCase("BG") && rowCount > 1) {
			jdbcTemplate
					.update("Delete from OAM_CUSTOMER_BRANDS where OAM_CUSTOMER_ID = '"
							+ bname + "' and BRAND_ID='2'");
			Report.updateTestLog("updated to SE" + bname, "PASS");
		} else if (BrandName.trim().equalsIgnoreCase("SE") && rowCount > 1) {
			jdbcTemplate
					.update("Delete from OAM_CUSTOMER_BRANDS where OAM_CUSTOMER_ID = '"
							+ bname + "' and BRAND_ID='1'");
			Report.updateTestLog("updated to BG" + bname, "PASS");
        }

		if (BrandName.trim() == "BG" && rowCount == 1) {
			jdbcTemplate
					.update("update OAM_CUSTOMER_BRANDS set BRAND_ID = '1' where OAM_CUSTOMER_ID = '"
							+ bname + "'");
			Report.updateTestLog("updated to BG" + bname, "PASS");
		} else if (BrandName.trim() == "SE" && rowCount == 1) {
			jdbcTemplate
					.update("update OAM_CUSTOMER_BRANDS set BRAND_ID = '2' where OAM_CUSTOMER_ID = '"
							+ bname + "'");
			Report.updateTestLog("updated to SE" + bname, "PASS");
    	}
    }

    public void addexistinguserprofileinDB(UserProfile userProfile) {
        String ucrn = userProfile.getUCRN();
        String email = userProfile.getEmail();
        String title = userProfile.getTitle();
        String fName = userProfile.getFirstName();
        String lName = userProfile.getLastName();
        String sysDate = DBsysdate();
        // deRegister(ucrn);
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String query = "";
        int rowsAffected = 0;

        try {
            rowsAffected = jdbcTemplate
                    .update("Insert INTO PO_TA_OAM_CUSTOMER(CUSTOMER_ID,UCRN,OAM_EMAIL_ADDRESS,PASSWORD,"
                            + "SECURITY_QUESTION,SECURITY_ANSWER,LOGIN_TRY_COUNT,SECURITY_TRY_COUNT,EMAIL_VALIDATED_FLAG,"
                            + "PROFILE_STATUS,ONETIME_PASSWORD_FLAG,LAST_LOGIN_TIMESTAMP,PASSWORD_CHANGE_TIMESTAMP,"
                            + "UNSUCCESSFUL_LOGIN_TIMESTAMP,VALIDATION_KEY,FREEZE_REASON,FREEZE_ACCOUNT,FIRST_NAME,"
                            + "LAST_NAME,TITLE,REGISTER_DATE,NUM_OF_LOGINS,CUST_DISCUSSION_RQD,CUST_DISCUSSION_LEAD_TIMESTAMP,"
                            + "DATA_CHECK_DONE_FLAG,TREATMENT_REFRESH_TIMESTAMP,CUSTOMER_LEVEL) "
                            + "VALUES(PO_TA_OAM_CUSTOMER_CUST_ID_SEQ.NEXTVAL,'"
                            + ucrn
                            + "','"
                            + email
                            + "','EMKPnPBmhZXUXBCQp7Sirpjt+lg=','place of birth',"
                            + "'4HQTjUWwSUlmuFqy4x+nugaE9Ds=',0,0,'Y','Active','N',to_date('"
                            + sysDate
                            + "','dd-mm-yy-hh24.mi.ss'),'02-NOV-11 11.36.38.000000000',"
                            + "'24-NOV-11 16.24.02.000000000',null,null,'N','"
                            + fName
                            + "','"
                            + lName
                            + "','"
                            + title
                            + "','01-MAR-12 21.20.10.537000000',0,null,null,'Y',null,'M')");
        } catch (EmptyResultDataAccessException e) {
            System.out.println(e.getMessage());
        }
        if (rowsAffected != 1) {
            System.out.println("User Registration in Online DB : FAILED");
        } else {
            System.out.println("User Registration in Online DB : PASSED");
        }
    }

    public String retreiveQuoteType(String quoteReferenceId) {
        String getQuoteTypequery = "SELECT quote_type from BGB_TA_QUOTE_LEAD_TEMP  where LEAD_ID='USERLEADID'";
		getQuoteTypequery = getQuoteTypequery.replace("USERLEADID",
				quoteReferenceId);
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        System.out.println("QUOTE TYPE QUERY: " + getQuoteTypequery);
        return jdbcTemplate.queryForObject(getQuoteTypequery, String.class);
    }

    public String retreiveQuoteTypeSales(String quoteReferenceId) {
        String getQuoteTypequery = "SELECT quote_type from BGB_TA_QUOTE_LEAD_TEMP  where LEAD_ID='USERLEADID'";
		getQuoteTypequery = getQuoteTypequery.replace("USERLEADID",
				quoteReferenceId);
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        System.out.println("QUOTE TYPE QUERY: " + getQuoteTypequery);
        return jdbcTemplate.queryForObject(getQuoteTypequery, String.class);
    }

    public String retreiveRecentlyAbandonedQuteId(String emailAddress) {
        String getQuoteTypequery = "SELECT ref_id from BGB_TA_ABANDONED_QUOTES  where email_address like '%USERLEADID%' and rownum=1 order by CREATED_TIMESTAMP desc ";
		getQuoteTypequery = getQuoteTypequery.replace("USERLEADID",
				emailAddress);
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        System.out.println(getQuoteTypequery);
        return jdbcTemplate.queryForObject(getQuoteTypequery, String.class);

    }

    public String retreiveRecentlyAbandonedStatus(String quoteId) {
        String getQuoteTypequery = "SELECT quote_abandon_status from BGB_TA_ABANDONED_QUOTES  where ref_id ='USERREFID'";
        getQuoteTypequery = getQuoteTypequery.replace("USERREFID", quoteId);
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        System.out.println(getQuoteTypequery);
        return jdbcTemplate.queryForObject(getQuoteTypequery, String.class);

    }

    public void deleteWTP(String Email) {

        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		jdbcTemplate.update("Delete from PO_TA_WTP_REG where EMAIL_ADDRESS='"
				+ Email + "'");
        jdbcTemplate.update("commit");

    }

    public String getLeadID(String date) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strQuery = "Select LEAD_ID from PO_TA_LEAD  where LEAD_TIME_STAMP > to_Date('"
				+ date
				+ "','dd-mm-yy-hh24.mi.ss') and rownum=1 ORDER BY LEAD_TIME_STAMP DESC ";
        System.out.println(strQuery);
        return jdbcTemplate.queryForObject(strQuery, String.class);
    }

    public String getLeadData(String date) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strQuery = "Select LEAD_DATA from PO_TA_LEAD  where LEAD_TIME_STAMP > to_Date('"
				+ date
				+ "','dd-mm-yy-hh24.mi.ss') and rownum=1 ORDER BY LEAD_TIME_STAMP DESC ";
        System.out.println(strQuery);
        return jdbcTemplate.queryForObject(strQuery, String.class);
    }

    public String getTransActionID(String date) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strQuery = "Select LEAD_DATA from PO_TA_ENERGYSHOP_LEAD  where LEAD_TIME_STAMP > to_Date('"
				+ date
				+ "','dd-mm-yy-hh24.mi.ss') and rownum=1 ORDER BY LEAD_TIME_STAMP DESC ";
        System.out.println(strQuery);
        return jdbcTemplate.queryForObject(strQuery, String.class);
    }
    
    public String getLoftLeadData(String date) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strQuery = "Select LEAD_DATA from PO_TA_ESS_CALLBACK_LEAD_SITEL  where LEAD_TIME_STAMP > to_Date('"
				+ date
				+ "','dd-mm-yy-hh24.mi.ss') and rownum=1 ORDER BY LEAD_TIME_STAMP DESC ";
        System.out.println(strQuery);
        return jdbcTemplate.queryForObject(strQuery, String.class);
    }

    public String getOtherLeadData(String date) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strQuery = "Select LEAD_DATA from PO_TA_ESS_CALLBACK_LEAD_NEBS  where LEAD_TIME_STAMP > to_Date('"
				+ date
				+ "','dd-mm-yy-hh24.mi.ss') and rownum=1 ORDER BY LEAD_TIME_STAMP DESC ";
        System.out.println(strQuery);
        return jdbcTemplate.queryForObject(strQuery, String.class);
    }
    	public String[] getBGSTAQuoteLead(String date) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		String query = "select product_chosen,product_order_name,asv_selection,excess_selection,quote_status, Quote_id from BGS_TA_QUOTE_LEAD"
				+ " where quote_time_stamp > to_Date('"
				+ date
				+ "','dd-mm-yy-hh24.mi.ss') and rownum=1 ORDER BY QUOTE_TIME_STAMP DESC ";
		List<Map<String, Object>> ss = jdbcTemplate.queryForList(query);
        String[] list = new String[6];
		if (!ss.isEmpty()) {
			list[0] = ss.get(0).get("PRODUCT_CHOSEN").toString();
			list[1] = ss.get(0).get("PRODUCT_ORDER_NAME").toString();
			list[2] = ss.get(0).get("ASV_SELECTION").toString();
			list[3] = ss.get(0).get("EXCESS_SELECTION").toString();
			list[4] = ss.get(0).get("QUOTE_STATUS").toString();
			list[5] = ss.get(0).get("QUOTE_id").toString();
        }
        return list;
    }

    public int getInsuranceAndRepairLeadCount(String leadId) {
        String sysDate = DBsysdate();
        String strQuery = "Select count(*) from BGS_TA_QUOTE_LEAD  where Quote_id = quoteID";
        strQuery = strQuery.replace("quoteID", leadId);
        return jdbcTemplate.queryForInt(strQuery);
    }

	public int leadDataOfLandLord(String date) {
    	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    	System.out.println(date);
		String strQuery = "Select LEAD_STATUS from PO_TA_LANDLORDS_QUOTE_LEAD  where LEAD_TIME_STAMP >  to_Date ('"
				+ date + "','dd-mm-yy-hh24.mi.ss')";
    	 return jdbcTemplate.queryForInt(strQuery);
    }

	public int leadIDOfLandLord(String date) {
    	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		System.out.println("DATE:LEAD: " + date);
		String strQuery = "Select LEAD_ID from PO_TA_LANDLORDS_QUOTE_LEAD  where LEAD_TIME_STAMP >  to_Date ('"
				+ date + "','dd-mm-yy-hh24.mi.ss')";
    	 return jdbcTemplate.queryForInt(strQuery);
    }

	public int retreiveUnitChargesCount(String unitCharge, String supplyNumber4) {
		String strQuery = "select count(*) from BGB_TR_PRICE_ELEC_BOOK where TARIFF_CODE like '%USERSUPPLYNUMBER-%' and unit_charge='USERUNITCHARGE'";
		strQuery = strQuery.replace("USERSUPPLYNUMBER", supplyNumber4);
		strQuery = strQuery.replace("USERUNITCHARGE", unitCharge);

    	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());

    	 return jdbcTemplate.queryForInt(strQuery);
    }

    public int getSupplyPointNumber(String leadID) {
        int RetVal = 0;
        String queryLeadData = "Select LEAD_DATA from BGB_TA_LEAD where lead_id='USERLEADID'";
        queryLeadData = queryLeadData.replace("USERLEADID", leadID);
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		String xmlValue = jdbcTemplate.queryForObject(queryLeadData,
				String.class);
        if (xmlValue.contains("<supplypointnumber>0")) {
            String supplyPointString = xmlValue.substring(
                    (xmlValue.indexOf("<supplypointnumber>0") + 19),
                    xmlValue.indexOf("</supplypointnumber>",
                            xmlValue.indexOf("<supplypointnumber>0")));
			System.out.println("supply pin String:           "
					+ supplyPointString);
            RetVal = Integer.parseInt(supplyPointString.substring(0, 2));
        }
        return RetVal;
    }

	public int addressCalculation(GetAQuoteDetails getDetails, String leadID,
			String annualconsumption, String FirstMonthlyQuarter, String Dual) {
        int RetVal = 0;
        String queryLeadData = "Select QUOTE_LEAD from BGB_TA_QUOTE_LEAD_TEMP where lead_id='USERLEADID'";
        queryLeadData = queryLeadData.replace("USERLEADID", leadID);
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		String xmlValue = jdbcTemplate.queryForObject(queryLeadData,
				String.class);
        if (xmlValue.contains("<supplypointnumber>0")) {
            String supplyPointString = xmlValue.substring(
                    (xmlValue.indexOf("<supplypointnumber>0") + 19),
                    xmlValue.indexOf("</supplypointnumber>",
                            xmlValue.indexOf("<supplypointnumber>0")));
			System.out.println("supply pin String:           "
					+ supplyPointString);
			String pc = supplyPointString.substring(0, 2);
			String mtc = supplyPointString.substring(2, 5);
			String pes = supplyPointString.substring(8, 10);
			int PC = Integer.parseInt(pc);
			eleNotchPlusUnit(getDetails, pc, mtc, pes, annualconsumption,
					FirstMonthlyQuarter, PC, Dual);

        }
        return RetVal;
    }
    
	public void findProfileClass(GetAQuoteDetails getDetails, String leadID, String FirstMonthly) {
        String queryLeadData = "Select QUOTE_LEAD from BGB_TA_QUOTE_LEAD_TEMP where lead_id='USERLEADID'";
        queryLeadData = queryLeadData.replace("USERLEADID", leadID);
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		String xmlValue = jdbcTemplate.queryForObject(queryLeadData,
				String.class);
        if (xmlValue.contains("<supplypointnumber>0")) {
            String supplyPointString = xmlValue.substring(
                    (xmlValue.indexOf("<supplypointnumber>0") + 19),
                    xmlValue.indexOf("</supplypointnumber>",
                            xmlValue.indexOf("<supplypointnumber>0")));
			System.out.println("supply pin String:           "
					+ supplyPointString);
			String pc = supplyPointString.substring(0, 2);
    
		if(FirstMonthly.equals("1") || FirstMonthly.equals("4"))
        {
			new GetaquoteCombinedEnergyPage()
			.firstYearDual(pc, getDetails);	   
        }
		if(FirstMonthly.equals("2") || FirstMonthly.equals("5"))
        {
			new GetaquoteCombinedEnergyPage()
			.secondYearDual(pc, getDetails);	   
        }
		if(FirstMonthly.equals("3") || FirstMonthly.equals("6"))
        {
			new GetaquoteCombinedEnergyPage()
			.thirdYearDual(pc, getDetails);	   
        }
    }
        }
	public int validateDefalutConsumption(String leadID,
			String com_unitrate_111, String com_standingrate_111,
			String com_unitrate_222, String com_standingrate_222,
			String com_unitrate_333, String com_standingrate_333,
			String com_nightrate_111, String com_nightrate_222,
			String com_nightrate_333) {
        int RetVal = 0;
		// String queryLeadData =
		// "Select LEAD_DATA from BGB_TA_LEAD where lead_id='USERLEADID'";
        String queryLeadData = "Select QUOTE_LEAD from BGB_TA_QUOTE_LEAD_TEMP where lead_id='USERLEADID'";
        queryLeadData = queryLeadData.replace("USERLEADID", leadID);
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		String xmlValue = jdbcTemplate.queryForObject(queryLeadData,
				String.class);
        if (xmlValue.contains("<supplypointnumber>0")) {
            String supplyPointString = xmlValue.substring(
                    (xmlValue.indexOf("<supplypointnumber>0") + 19),
                    xmlValue.indexOf("</supplypointnumber>",
                            xmlValue.indexOf("<supplypointnumber>0")));
			System.out.println("supply pin String:           "
					+ supplyPointString);
			String aa = supplyPointString.substring(0, 2);
        	System.out.println(aa);
			int Defaultcon = Integer.parseInt(aa);

			new GaqQuotePage().validateDefalutConsumption(null, Defaultcon);
        }
        return RetVal;
    }

	public String verifyAuditDetailsEntryDB(String Email, String sysDate) {

		jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		String AuditEntry = jdbcTemplate.queryForObject(
				"Select audit_details from PO_TA_AUDIT_DETAILS where (OAM_EMAIL_ADDRESS = '"
						+ Email + "')  AND AUDIT_TIMESTAMP > to_date('"
						+ sysDate + "','dd-mm-yy-hh24.mi.ss')and AUDIT_EVENT_TYPE_ID=60 and rownum=1 ORDER BY AUDIT_TIMESTAMP DESC", String.class);

		return AuditEntry;
	}

	public void passwordreset(String email) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		jdbcTemplate
				.update("update BG_BUSINESS_TA_CUSTOMER_REG set password='EMKPnPBmhZXUXBCQp7Sirpjt+lg=' where email='"
						+ email + "'");
        int rowCount = jdbcTemplate
				.queryForInt("select count(*) from BG_BUSINESS_TA_CUSTOMER_REG where email='"
						+ email
						+ "' and password='EMKPnPBmhZXUXBCQp7Sirpjt+lg='");
		if (rowCount == 1) {
			Report.updateTestLog("Onetime password Update successfully in DB ",
					"PASS");
		} else {
			Report.updateTestLog("Onetime password is not Updated in DB ",
					"Fail");
        }

	}

	public String getPrimaryUCRN(String UCRN) {
		String strucrn = "SELECT  SECONDARY_UCRN FROM PO_TA_SECONDARY_UCRN where PRIMARY_UCRN = '"
				+ UCRN + "'";
	    return getColumn("PRIMARY_UCRN", strucrn);

	}

	public String getEshopLeadData(String date) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strQuery = "Select LEAD_DATA from PO_TA_ENERGYSHOP_LEAD  where LEAD_TIME_STAMP > to_Date('"
				+ date
				+ "','dd-mm-yy-hh24.mi.ss') and rownum=1 ORDER BY LEAD_TIME_STAMP DESC ";
        System.out.println(strQuery);
        return jdbcTemplate.queryForObject(strQuery, String.class);
    }

	public String getEshopLeadID(String date) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strQuery = "Select LEAD_ID from PO_TA_ENERGYSHOP_LEAD  where LEAD_TIME_STAMP > to_Date('"
				+ date
				+ "','dd-mm-yy-hh24.mi.ss') and rownum=1 ORDER BY LEAD_TIME_STAMP DESC ";
        System.out.println(strQuery);
        return jdbcTemplate.queryForObject(strQuery, String.class);
    }
	
	public String getModelSalesAuditDetails(String date, String email) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strQuery = "Select AUDIT_DETAILS from PO_TA_AUDIT_DETAILS  where AUDIT_EVENT_TYPE_ID = '184' AND OAM_EMAIL_ADDRESS = '"+email+"'" ;
        System.out.println(strQuery);
        return jdbcTemplate.queryForObject(strQuery, String.class);
    }
	
	
    public String getAuditID(String email) {
    	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strQuery = "Select AUDIT_EVENT_TYPE_ID from PO_TA_AUDIT_DETAILS  where OAM_EMAIL_ADDRESS= email'"+email+"'";
        System.out.println(strQuery);
        return strQuery;
    }
	public String verifyMessageShowFlagUnread(String strUCRN) {
		jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		String strFlag = jdbcTemplate.queryForObject(
				"Select Count(SHOW_FLAG) from PO_TA_UCRN_TREATMENTS where UCRN = '"
						+ strUCRN + "' and READ_FLAG ='N'", String.class);

		return strFlag;
	}

	public String verifyMessageShowFlagToShow(String strUCRN) {
		jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		String strFlag = jdbcTemplate.queryForObject(
				"Select Count(SHOW_FLAG) from PO_TA_UCRN_TREATMENTS where UCRN = '"
						+ strUCRN + "' and SHOW_FLAG ='Y'", String.class);

		return strFlag;
	}

	public String verifyMessageShowFlagAll(String strUCRN) {
		jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		String strFlag = jdbcTemplate.queryForObject(
				"Select Count(SHOW_FLAG) from PO_TA_UCRN_TREATMENTS where UCRN = '"
						+ strUCRN + "'", String.class);

		return strFlag;
	}

	public List verifyTreatmentCode(String strUCRN)

	{
		List rs;

		jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		rs = jdbcTemplate
				.queryForList("Select b.TREATMENT_CODE from PO_TA_UCRN_TREATMENTS a Inner join PO_TR_TREATMENTS b on a.TREATMENT_ID = b.TREATMENT_ID Where  a.UCRN = '"
						+ strUCRN + "'");
		Iterator i = rs.iterator();
		while (i.hasNext()) {
        	  System.out.println(i.next());
          }
		return rs;
	}

	public String getLeadTypeNectar(String sysDate) {
		String strQuery = "Select LEAD_TYPE from PO_TA_LEAD  where LEAD_TIME_STAMP > to_date('"
				+ sysDate + "','dd-mm-yy-hh24.mi.ss')";
		return jdbcTemplate.queryForObject(strQuery, String.class);
		

	}

	public String getLeadStatusNectar(String sysDate) {
		String strQuery = "Select LEAD_STATUS from PO_TA_LEAD  where LEAD_TIME_STAMP > to_date('"
				+ sysDate + "','dd-mm-yy-hh24.mi.ss')";
		return strQuery;
	}

public String getLeadStatusCA(String date) {
		jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		String strleadID = "Select LEAD_ID from PO_TA_ENERGYSHOP_LEAD  where LEAD_TIME_STAMP > to_Date('"
				+ date
				+ "','dd-mm-yy-hh24.mi.ss') and rownum=1 ORDER BY LEAD_TIME_STAMP DESC ";
		System.out.println(strleadID);
		strleadID = jdbcTemplate.queryForObject(strleadID, String.class);
		String strQuery = "Select LEAD_STATUS from PO_TA_ENERGYSHOP_LEAD where LEAD_ID = '"
				+ strleadID
				+ "' AND LEAD_TIME_STAMP > to_Date('"
				+ date
				+ "','dd-mm-yy-hh24.mi.ss') and rownum=1 ORDER BY LEAD_TIME_STAMP DESC ";
		System.out.println(strQuery);
		return jdbcTemplate.queryForObject(strQuery, String.class);

	}

	public void eleNotchPlusUnit(GetAQuoteDetails getDetails, String PC,
			String MTC, String PES, String annualconsumption, String Year,
			int PClass, String Dual) {
		String NightCharge1 = "";
		jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		if (PClass == 1 || PClass == 3 || PClass == 5) {
			String UnitCharge = "SELECT UNIT_CHARGE"
					+ " FROM BGB_TR_PRICE_ELEC_BOOK "
					+ " WHERE tariff_code ="
					+ " (SELECT tariff_code"
					+ " FROM BGB_TR_PRICE_ELEC_METER_TARIFF"
					+ " WHERE mtc = '"
					+ MTC
					+ "' AND profile_class = '"
					+ PC
					+ "' AND pes = '"
					+ PES
					+ "') AND LINE_DESCRIPTION='Unit Charge'"
					+ " AND reference_pricebook_id = (SELECT reference_pricebook_id"
					+ " FROM BGB_TR_PRICE_ELEC_BOOK_REF"
					+ " WHERE contract_type_id = '" + Year + "')";
			System.out.println(UnitCharge);
			String StandingCharge = "SELECT UNIT_CHARGE"
					+ " FROM BGB_TR_PRICE_ELEC_BOOK "
					+ " WHERE tariff_code ="
					+ " (SELECT tariff_code"
					+ " FROM BGB_TR_PRICE_ELEC_METER_TARIFF"
					+ " WHERE mtc = '"
					+ MTC
					+ "' AND profile_class = '"
					+ PC
					+ "' AND pes = '"
					+ PES
					+ "') AND LINE_DESCRIPTION='Standing Charge'"
					+ " AND reference_pricebook_id = (SELECT reference_pricebook_id"
					+ " FROM BGB_TR_PRICE_ELEC_BOOK_REF"
					+ " WHERE contract_type_id = '" + Year + "')";
			System.out.println(StandingCharge);
			UnitCharge = jdbcTemplate.queryForObject(UnitCharge, String.class);
			StandingCharge = jdbcTemplate.queryForObject(StandingCharge,
					String.class);
			int consumption = Integer.parseInt(annualconsumption);
			eleCalculation(getDetails, NightCharge1, StandingCharge,
					consumption, PClass, UnitCharge, Year, Dual);
		} else {
			String UnitCharge = "SELECT UNIT_CHARGE"
					+ " FROM BGB_TR_PRICE_ELEC_BOOK "
					+ " WHERE tariff_code ="
					+ " (SELECT tariff_code"
					+ " FROM BGB_TR_PRICE_ELEC_METER_TARIFF"
					+ " WHERE mtc = '"
					+ MTC
					+ "' AND profile_class = '"
					+ PC
					+ "' AND pes = '"
					+ PES
					+ "') AND LINE_DESCRIPTION='Day Unit Charge'"
					+ " AND reference_pricebook_id = (SELECT reference_pricebook_id"
					+ " FROM BGB_TR_PRICE_ELEC_BOOK_REF"
					+ " WHERE contract_type_id = '" + Year + "')";
			System.out.println(UnitCharge);
			String NightCharge = "SELECT UNIT_CHARGE"
					+ " FROM BGB_TR_PRICE_ELEC_BOOK "
					+ " WHERE tariff_code ="
					+ " (SELECT tariff_code"
					+ " FROM BGB_TR_PRICE_ELEC_METER_TARIFF"
					+ " WHERE mtc = '"
					+ MTC
					+ "' AND profile_class = '"
					+ PC
					+ "' AND pes = '"
					+ PES
					+ "') AND LINE_DESCRIPTION='Night Unit Charge'"
					+ " AND reference_pricebook_id = (SELECT reference_pricebook_id"
					+ " FROM BGB_TR_PRICE_ELEC_BOOK_REF"
					+ " WHERE contract_type_id = '" + Year + "')";
			System.out.println(NightCharge);
			String StandingCharge = "SELECT UNIT_CHARGE"
					+ " FROM BGB_TR_PRICE_ELEC_BOOK "
					+ " WHERE tariff_code ="
					+ " (SELECT tariff_code"
					+ " FROM BGB_TR_PRICE_ELEC_METER_TARIFF"
					+ " WHERE mtc = '"
					+ MTC
					+ "' AND profile_class = '"
					+ PC
					+ "' AND pes = '"
					+ PES
					+ "') AND LINE_DESCRIPTION='Standing Charge'"
					+ " AND reference_pricebook_id = (SELECT reference_pricebook_id"
					+ " FROM BGB_TR_PRICE_ELEC_BOOK_REF"
					+ " WHERE contract_type_id = '" + Year + "')";
			System.out.println(StandingCharge);
			UnitCharge = jdbcTemplate.queryForObject(UnitCharge, String.class);
			NightCharge = jdbcTemplate
					.queryForObject(NightCharge, String.class);
			StandingCharge = jdbcTemplate.queryForObject(StandingCharge,
					String.class);
			int consumption = Integer.parseInt(annualconsumption);
			eleCalculation(getDetails, NightCharge, StandingCharge,
					consumption, PClass, UnitCharge, Year, Dual);
		}
	}

	public void eleCalculation(GetAQuoteDetails getDetails, String NightCharge,
			String StandingCharge, int consumption, int PClass,
			String UnitCharge, String Year, String Dual) {
		if (consumption >= 0 && consumption <= 7999) {
			if (Year.equals("1") || Year.equals("4")) {
				String NotchValue = "SELECT UNITPRICE_NOTCH FROM BGB_TR_ELEC_CONSUMPTION_NOTCH WHERE MIN_CONSUMPTION = '0' AND MAX_CONSUMPTION = '7999' AND CONTRACT_LENGTH='1'";
				NotchValue = jdbcTemplate.queryForObject(NotchValue,
						String.class);
				if("Dual".equals(Dual))
				{
				new GetaquoteCombinedEnergyPage().validateFirstYearContractMonthlyAndQuarter(
						getDetails, NightCharge, StandingCharge, PClass,
						UnitCharge, NotchValue);	
				}
				else
				{	
				new GaqQuotePage().validateFirstYearContractMonthlyAndQuarter(
						getDetails, NightCharge, StandingCharge, PClass,
						UnitCharge, NotchValue);
				}
			}
			if (Year.equals("2") || Year.equals("5")) {
				String NotchValue = "SELECT UNITPRICE_NOTCH FROM BGB_TR_ELEC_CONSUMPTION_NOTCH WHERE MIN_CONSUMPTION = '0' AND MAX_CONSUMPTION = '7999' AND CONTRACT_LENGTH='2'";
				NotchValue = jdbcTemplate.queryForObject(NotchValue,
						String.class);
				if("Dual".equals(Dual))
				{
				new GetaquoteCombinedEnergyPage().validateSecondYearContractMonthlyAndQuarter(
						getDetails, NightCharge, StandingCharge, PClass,
						UnitCharge, NotchValue);	
				}
				else
				{	
				new GaqQuotePage().validateSecondYearContractMonthlyAndQuarter(
						getDetails, NightCharge, StandingCharge, PClass,
						UnitCharge, NotchValue);
				}
			}
			if (Year.equals("3") || Year.equals("6")) {
				String NotchValue = "SELECT UNITPRICE_NOTCH FROM BGB_TR_ELEC_CONSUMPTION_NOTCH WHERE MIN_CONSUMPTION = '0' AND MAX_CONSUMPTION = '7999' AND CONTRACT_LENGTH='3'";
				NotchValue = jdbcTemplate.queryForObject(NotchValue,
						String.class);
				if("Dual".equals(Dual))
				{
				new GetaquoteCombinedEnergyPage().validateThirdYearContractMonthlyAndQuarter(
						getDetails, NightCharge, StandingCharge, PClass,
						UnitCharge, NotchValue);	
				}
				else
				{	
				new GaqQuotePage().validateThirdYearContractMonthlyAndQuarter(
						getDetails, NightCharge, StandingCharge, PClass,
						UnitCharge, NotchValue);
				}
			}
		}
		if (consumption >= 8000 && consumption <= 29999) {
			if (Year.equals("1") || Year.equals("4")) {
				String NotchValue = "SELECT UNITPRICE_NOTCH FROM BGB_TR_ELEC_CONSUMPTION_NOTCH WHERE MIN_CONSUMPTION = '8000' AND MAX_CONSUMPTION = '29999' AND CONTRACT_LENGTH='1'";
				NotchValue = jdbcTemplate.queryForObject(NotchValue,
						String.class);
				if("Dual".equals(Dual))
				{
				new GetaquoteCombinedEnergyPage().validateFirstYearContractMonthlyAndQuarter(
						getDetails, NightCharge, StandingCharge, PClass,
						UnitCharge, NotchValue);	
				}
				else
				{	
				new GaqQuotePage().validateFirstYearContractMonthlyAndQuarter(
						getDetails, NightCharge, StandingCharge, PClass,
						UnitCharge, NotchValue);
				}
			}
			if (Year.equals("2") || Year.equals("5")) {
				String NotchValue = "SELECT UNITPRICE_NOTCH FROM BGB_TR_ELEC_CONSUMPTION_NOTCH WHERE MIN_CONSUMPTION = '8000' AND MAX_CONSUMPTION = '29999' AND CONTRACT_LENGTH='2'";
				NotchValue = jdbcTemplate.queryForObject(NotchValue,
						String.class);
				if("Dual".equals(Dual))
				{
				new GetaquoteCombinedEnergyPage().validateSecondYearContractMonthlyAndQuarter(
						getDetails, NightCharge, StandingCharge, PClass,
						UnitCharge, NotchValue);	
				}
				else
				{	
				new GaqQuotePage().validateSecondYearContractMonthlyAndQuarter(
						getDetails, NightCharge, StandingCharge, PClass,
						UnitCharge, NotchValue);
				}
			}
			if (Year.equals("3") || Year.equals("6")) {
				String NotchValue = "SELECT UNITPRICE_NOTCH FROM BGB_TR_ELEC_CONSUMPTION_NOTCH WHERE MIN_CONSUMPTION = '8000' AND MAX_CONSUMPTION = '29999' AND CONTRACT_LENGTH='3'";
				NotchValue = jdbcTemplate.queryForObject(NotchValue,
						String.class);
				if("Dual".equals(Dual))
				{
				new GetaquoteCombinedEnergyPage().validateThirdYearContractMonthlyAndQuarter(
						getDetails, NightCharge, StandingCharge, PClass,
						UnitCharge, NotchValue);	
				}
				else
				{	
				new GaqQuotePage().validateThirdYearContractMonthlyAndQuarter(
						getDetails, NightCharge, StandingCharge, PClass,
						UnitCharge, NotchValue);
				}
			}
		}
		if (consumption >= 30000 && consumption <= 69999) {
			if (Year.equals("1") || Year.equals("4")) {
				String NotchValue = "SELECT UNITPRICE_NOTCH FROM BGB_TR_ELEC_CONSUMPTION_NOTCH WHERE MIN_CONSUMPTION = '30000' AND MAX_CONSUMPTION = '69999' AND CONTRACT_LENGTH='1'";
				NotchValue = jdbcTemplate.queryForObject(NotchValue,
						String.class);
				if("Dual".equals(Dual))
				{
				new GetaquoteCombinedEnergyPage().validateFirstYearContractMonthlyAndQuarter(
						getDetails, NightCharge, StandingCharge, PClass,
						UnitCharge, NotchValue);	
				}
				else
				{	
				new GaqQuotePage().validateFirstYearContractMonthlyAndQuarter(
						getDetails, NightCharge, StandingCharge, PClass,
						UnitCharge, NotchValue);
				}
			}
			if (Year.equals("2") || Year.equals("5")) {
				String NotchValue = "SELECT UNITPRICE_NOTCH FROM BGB_TR_ELEC_CONSUMPTION_NOTCH WHERE MIN_CONSUMPTION = '30000' AND MAX_CONSUMPTION = '69999' AND CONTRACT_LENGTH='2'";
				NotchValue = jdbcTemplate.queryForObject(NotchValue,
						String.class);
				if("Dual".equals(Dual))
				{
				new GetaquoteCombinedEnergyPage().validateSecondYearContractMonthlyAndQuarter(
						getDetails, NightCharge, StandingCharge, PClass,
						UnitCharge, NotchValue);	
				}
				else
				{	
				new GaqQuotePage().validateSecondYearContractMonthlyAndQuarter(
						getDetails, NightCharge, StandingCharge, PClass,
						UnitCharge, NotchValue);
				}
			}
			if (Year.equals("3") || Year.equals("6")) {
				String NotchValue = "SELECT UNITPRICE_NOTCH FROM BGB_TR_ELEC_CONSUMPTION_NOTCH WHERE MIN_CONSUMPTION = '30000' AND MAX_CONSUMPTION = '69999' AND CONTRACT_LENGTH='3'";
				NotchValue = jdbcTemplate.queryForObject(NotchValue,
						String.class);
				if("Dual".equals(Dual))
				{
				new GetaquoteCombinedEnergyPage().validateThirdYearContractMonthlyAndQuarter(
						getDetails, NightCharge, StandingCharge, PClass,
						UnitCharge, NotchValue);	
				}
				else
				{	
				new GaqQuotePage().validateThirdYearContractMonthlyAndQuarter(
						getDetails, NightCharge, StandingCharge, PClass,
						UnitCharge, NotchValue);
				}
			}
		}
		if (consumption >= 70000 && consumption <= 999999) {
			if (Year.equals("1") || Year.equals("4")) {
				String NotchValue = "SELECT UNITPRICE_NOTCH FROM BGB_TR_ELEC_CONSUMPTION_NOTCH WHERE MIN_CONSUMPTION = '70000' AND MAX_CONSUMPTION = '999999' AND CONTRACT_LENGTH='1'";
				NotchValue = jdbcTemplate.queryForObject(NotchValue,
						String.class);
				if("Dual".equals(Dual))
				{
				new GetaquoteCombinedEnergyPage().validateFirstYearContractMonthlyAndQuarter(
						getDetails, NightCharge, StandingCharge, PClass,
						UnitCharge, NotchValue);	
				}
				else
				{	
				new GaqQuotePage().validateFirstYearContractMonthlyAndQuarter(
						getDetails, NightCharge, StandingCharge, PClass,
						UnitCharge, NotchValue);
				}
			}
			if (Year.equals("2") || Year.equals("5")) {
				String NotchValue = "SELECT UNITPRICE_NOTCH FROM BGB_TR_ELEC_CONSUMPTION_NOTCH WHERE MIN_CONSUMPTION = '70000' AND MAX_CONSUMPTION = '999999' AND CONTRACT_LENGTH='2'";
				NotchValue = jdbcTemplate.queryForObject(NotchValue,
						String.class);
				if("Dual".equals(Dual))
				{
				new GetaquoteCombinedEnergyPage().validateSecondYearContractMonthlyAndQuarter(
						getDetails, NightCharge, StandingCharge, PClass,
						UnitCharge, NotchValue);	
				}
				else
				{	
				new GaqQuotePage().validateSecondYearContractMonthlyAndQuarter(
						getDetails, NightCharge, StandingCharge, PClass,
						UnitCharge, NotchValue);
				}
			}
			if (Year.equals("3") || Year.equals("6")) {
				String NotchValue = "SELECT UNITPRICE_NOTCH FROM BGB_TR_ELEC_CONSUMPTION_NOTCH WHERE MIN_CONSUMPTION = '70000' AND MAX_CONSUMPTION = '999999' AND CONTRACT_LENGTH='3'";
				NotchValue = jdbcTemplate.queryForObject(NotchValue,
						String.class);
				if("Dual".equals(Dual))
				{
				new GetaquoteCombinedEnergyPage().validateThirdYearContractMonthlyAndQuarter(
						getDetails, NightCharge, StandingCharge, PClass,
						UnitCharge, NotchValue);	
				}
				else
				{	
				new GaqQuotePage().validateThirdYearContractMonthlyAndQuarter(
						getDetails, NightCharge, StandingCharge, PClass,
						UnitCharge, NotchValue);
				}
			}
		}
	}

	public void gasRetreiveUnitCharges(GetAQuoteDetails getDetails,
			String PostCode, String Bandid, String monthlyQuarter,
			int Consumption, String Dual) {
		jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		String UnitCharge = "SELECT UNIT_RATE FROM BGB_TR_PRICE_GAS_BOOK WHERE former_pes = (SELECT former_pes FROM BGB_TR_PRICE_GAS_POSTCODES WHERE postcode = '"
				+ PostCode
				+ "' )AND contract_type_id = '"
				+ monthlyQuarter
				+ "'AND band_id = '" + Bandid + "'";
		System.out.println(UnitCharge);
		UnitCharge = jdbcTemplate.queryForObject(UnitCharge, String.class);
		String StandingCharge = "SELECT UNITCHARGE_DAY FROM BGB_TR_PRICE_GAS_BOOK WHERE former_pes = (SELECT former_pes FROM BGB_TR_PRICE_GAS_POSTCODES WHERE postcode = '"
				+ PostCode
				+ "' )AND contract_type_id = '"
				+ monthlyQuarter
				+ "'AND band_id = '" + Bandid + "'";
		System.out.println(StandingCharge);
		StandingCharge = jdbcTemplate.queryForObject(StandingCharge,
				String.class);
		gasCalculation(getDetails, UnitCharge, StandingCharge, monthlyQuarter,
				Consumption, Dual);
	}

	public void gasCalculation(GetAQuoteDetails getDetails, String UnitCharge,
			String StandingCharge, String Year, int Consumption, String Dual) {

		if (Consumption >= 0 && Consumption <= 39999) {
			if (Year.equals("1") || Year.equals("4")) {
				String NotchValue = "SELECT UNITPRICE_NOTCH FROM BGB_TR_GAS_CONSUMPTION_NOTCH WHERE MIN_CONSUMPTION = '0' AND MAX_CONSUMPTION = '39999' AND CONTRACT_LENGTH='1'";
				NotchValue = jdbcTemplate.queryForObject(NotchValue,
						String.class);
				if("Dual".equals(Dual))
				{
					new GetaquoteCombinedEnergyPage().validateFirstYearContractMonthlyGas(
							getDetails, UnitCharge, StandingCharge, NotchValue);
				}else
				{
					new GaqQuotePage().validateFirstYearContractMonthlyGas(
							getDetails, UnitCharge, StandingCharge, NotchValue);	
				}
			}
			if (Year.equals("2") || Year.equals("5")) {
				String NotchValue = "SELECT UNITPRICE_NOTCH FROM BGB_TR_GAS_CONSUMPTION_NOTCH WHERE MIN_CONSUMPTION = '0' AND MAX_CONSUMPTION = '39999' AND CONTRACT_LENGTH='2'";
				NotchValue = jdbcTemplate.queryForObject(NotchValue,
						String.class);
				if("Dual".equals(Dual))
				{
					new GetaquoteCombinedEnergyPage().validateSecondYearContractMonthlyGas(
							getDetails, UnitCharge, StandingCharge, NotchValue);
				}else
				{
					new GaqQuotePage().validateSecondYearContractMonthlyGas(
							getDetails, UnitCharge, StandingCharge, NotchValue);	
				}
			}
			if (Year.equals("3") || Year.equals("6")) {
				String NotchValue = "SELECT UNITPRICE_NOTCH FROM BGB_TR_GAS_CONSUMPTION_NOTCH WHERE MIN_CONSUMPTION = '0' AND MAX_CONSUMPTION = '39999' AND CONTRACT_LENGTH='3'";
				NotchValue = jdbcTemplate.queryForObject(NotchValue,
						String.class);
				if("Dual".equals(Dual))
				{
					new GetaquoteCombinedEnergyPage().validateThirdYearContractMonthlyGas(
							getDetails, UnitCharge, StandingCharge, NotchValue);
				}else
				{
					new GaqQuotePage().validateThirdYearContractMonthlyGas(
							getDetails, UnitCharge, StandingCharge, NotchValue);	
				}
			}
		}
		if (Consumption >= 40000 && Consumption <= 79999) {
			if (Year.equals("1") || Year.equals("4")) {
				String NotchValue = "SELECT UNITPRICE_NOTCH FROM BGB_TR_GAS_CONSUMPTION_NOTCH WHERE MIN_CONSUMPTION = '40000' AND MAX_CONSUMPTION = '79999' AND CONTRACT_LENGTH='1'";
				NotchValue = jdbcTemplate.queryForObject(NotchValue,
						String.class);
				if("Dual".equals(Dual))
				{
					new GetaquoteCombinedEnergyPage().validateFirstYearContractMonthlyGas(
							getDetails, UnitCharge, StandingCharge, NotchValue);
				}else
				{
					new GaqQuotePage().validateFirstYearContractMonthlyGas(
							getDetails, UnitCharge, StandingCharge, NotchValue);	
				}
			}
			if (Year.equals("2") || Year.equals("5")) {
				String NotchValue = "SELECT UNITPRICE_NOTCH FROM BGB_TR_GAS_CONSUMPTION_NOTCH WHERE MIN_CONSUMPTION = '40000' AND MAX_CONSUMPTION = '79999' AND CONTRACT_LENGTH='2'";
				NotchValue = jdbcTemplate.queryForObject(NotchValue,
						String.class);
				if("Dual".equals(Dual))
				{
					new GetaquoteCombinedEnergyPage().validateSecondYearContractMonthlyGas(
							getDetails, UnitCharge, StandingCharge, NotchValue);
				}else
				{
					new GaqQuotePage().validateSecondYearContractMonthlyGas(
							getDetails, UnitCharge, StandingCharge, NotchValue);	
				}
			}
			if (Year.equals("3") || Year.equals("6")) {
				String NotchValue = "SELECT UNITPRICE_NOTCH FROM BGB_TR_GAS_CONSUMPTION_NOTCH WHERE MIN_CONSUMPTION = '40000' AND MAX_CONSUMPTION = '79999' AND CONTRACT_LENGTH='3'";
				NotchValue = jdbcTemplate.queryForObject(NotchValue,
						String.class);
				if("Dual".equals(Dual))
				{
					new GetaquoteCombinedEnergyPage().validateThirdYearContractMonthlyGas(
							getDetails, UnitCharge, StandingCharge, NotchValue);
				}else
				{
					new GaqQuotePage().validateThirdYearContractMonthlyGas(
							getDetails, UnitCharge, StandingCharge, NotchValue);	
				}
			}
		}
		if (Consumption >= 80000 && Consumption <= 119999) {
			if (Year.equals("1") || Year.equals("4")) {
				String NotchValue = "SELECT UNITPRICE_NOTCH FROM BGB_TR_GAS_CONSUMPTION_NOTCH WHERE MIN_CONSUMPTION = '80000' AND MAX_CONSUMPTION = '119999' AND CONTRACT_LENGTH='1'";
				NotchValue = jdbcTemplate.queryForObject(NotchValue,
						String.class);
				if("Dual".equals(Dual))
				{
					new GetaquoteCombinedEnergyPage().validateFirstYearContractMonthlyGas(
							getDetails, UnitCharge, StandingCharge, NotchValue);
				}else
				{
					new GaqQuotePage().validateFirstYearContractMonthlyGas(
							getDetails, UnitCharge, StandingCharge, NotchValue);	
				}
			}
			if (Year.equals("2") || Year.equals("5")) {
				String NotchValue = "SELECT UNITPRICE_NOTCH FROM BGB_TR_GAS_CONSUMPTION_NOTCH WHERE MIN_CONSUMPTION = '80000' AND MAX_CONSUMPTION = '119999' AND CONTRACT_LENGTH='2'";
				NotchValue = jdbcTemplate.queryForObject(NotchValue,
						String.class);
				if("Dual".equals(Dual))
				{
					new GetaquoteCombinedEnergyPage().validateSecondYearContractMonthlyGas(
							getDetails, UnitCharge, StandingCharge, NotchValue);
				}else
				{
					new GaqQuotePage().validateSecondYearContractMonthlyGas(
							getDetails, UnitCharge, StandingCharge, NotchValue);	
				}
			}
			if (Year.equals("3") || Year.equals("6")) {
				String NotchValue = "SELECT UNITPRICE_NOTCH FROM BGB_TR_GAS_CONSUMPTION_NOTCH WHERE MIN_CONSUMPTION = '80000' AND MAX_CONSUMPTION = '119999' AND CONTRACT_LENGTH='3'";
				NotchValue = jdbcTemplate.queryForObject(NotchValue,
						String.class);
				if("Dual".equals(Dual))
				{
					new GetaquoteCombinedEnergyPage().validateThirdYearContractMonthlyGas(
							getDetails, UnitCharge, StandingCharge, NotchValue);
				}else
				{
					new GaqQuotePage().validateThirdYearContractMonthlyGas(
							getDetails, UnitCharge, StandingCharge, NotchValue);	
				}
			}
		}
		if (Consumption >= 120000 && Consumption <= 999999) {
			if (Year.equals("1") || Year.equals("4")) {
				String NotchValue = "SELECT UNITPRICE_NOTCH FROM BGB_TR_GAS_CONSUMPTION_NOTCH WHERE MIN_CONSUMPTION = '120000' AND MAX_CONSUMPTION = '999999' AND CONTRACT_LENGTH='1'";
				NotchValue = jdbcTemplate.queryForObject(NotchValue,
						String.class);
				if("Dual".equals(Dual))
				{
					new GetaquoteCombinedEnergyPage().validateFirstYearContractMonthlyGas(
							getDetails, UnitCharge, StandingCharge, NotchValue);
				}else
				{
					new GaqQuotePage().validateFirstYearContractMonthlyGas(
							getDetails, UnitCharge, StandingCharge, NotchValue);	
				}
			}
			if (Year.equals("2") || Year.equals("5")) {
				String NotchValue = "SELECT UNITPRICE_NOTCH FROM BGB_TR_GAS_CONSUMPTION_NOTCH WHERE MIN_CONSUMPTION = '120000' AND MAX_CONSUMPTION = '999999' AND CONTRACT_LENGTH='2'";
				NotchValue = jdbcTemplate.queryForObject(NotchValue,
						String.class);
				if("Dual".equals(Dual))
				{
					new GetaquoteCombinedEnergyPage().validateSecondYearContractMonthlyGas(
							getDetails, UnitCharge, StandingCharge, NotchValue);
				}else
				{
					new GaqQuotePage().validateSecondYearContractMonthlyGas(
							getDetails, UnitCharge, StandingCharge, NotchValue);	
				}
			}
			if (Year.equals("3") || Year.equals("6")) {
				String NotchValue = "SELECT UNITPRICE_NOTCH FROM BGB_TR_GAS_CONSUMPTION_NOTCH WHERE MIN_CONSUMPTION = '120000' AND MAX_CONSUMPTION = '999999' AND CONTRACT_LENGTH='3'";
				NotchValue = jdbcTemplate.queryForObject(NotchValue,
						String.class);
				if("Dual".equals(Dual))
				{
					new GetaquoteCombinedEnergyPage().validateThirdYearContractMonthlyGas(
							getDetails, UnitCharge, StandingCharge, NotchValue);
				}else
				{
					new GaqQuotePage().validateThirdYearContractMonthlyGas(
							getDetails, UnitCharge, StandingCharge, NotchValue);	
				}
			}
		}
	}

	public int getAuditDetailsCount(String strPremise,String strType,String strAuditDet)
	{
		String strCount = null;
		jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		if(strType == "ASV")
		{
			strCount = jdbcTemplate.queryForObject(
				"Select Count(*) from ASV_TA_AUDIT_DETAILS where PREMISE_NUMBER = '"
						+ strPremise + "' and TRANSACTION_TYPE='ASV_BOOK_APPT' and AUDIT_DETAILS='"+strAuditDet+"'", String.class);
		}
		if(strType == "IB")
		{
			strCount = jdbcTemplate.queryForObject(
					"Select Count(*) from ASV_TA_AUDIT_DETAILS where PREMISE_NUMBER = '"
							+ strPremise + "' and TRANSACTION_TYPE='IB_BOOK_APPT' and AUDIT_DETAILS=''", String.class);
		}
		if(strCount == null)
		{
			return 0;
		}
		else
		{
		return Integer.parseInt(strCount);
		}
	}

	public String verifyLeadQuoteDB(String date){
		jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		System.out.println("Select LEAD_STATUS from PO_TA_QUOTE  where LEAD_TIME_STAMP > to_Date('"
                + date + "','dd-mm-yy-hh24.mi.ss') and rownum=1 ORDER BY LEAD_TIME_STAMP DESC ");
        String strQuery = "Select LEAD_STATUS from PO_TA_QUOTE  where LEAD_TIME_STAMP > to_Date('"
                + date + "','dd-mm-yy-hh24.mi.ss') and rownum=1 ORDER BY LEAD_TIME_STAMP DESC ";
		return jdbcTemplate.queryForObject(strQuery, String.class);
	}
        
	public String getQuoteId(String date){
		jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		String strQuery = "Select LEAD_ID from PO_TA_QUOTE  where LEAD_TIME_STAMP > to_Date('"
                + date + "','dd-mm-yy-hh24.mi.ss') and rownum=1 ORDER BY LEAD_TIME_STAMP DESC ";
        return jdbcTemplate.queryForObject(strQuery, String.class);
	}
	
	public String verifyLeadQuoteAferBatch(String quoteId){
		jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strQuery = "Select LEAD_STATUS from PO_TA_QUOTE  where LEAD_ID ='"+quoteId+"'";
     
        return jdbcTemplate.queryForObject(strQuery, String.class);
	}
	
	public String getQuoteLeadData(String quoteId){
		jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strQuery = "Select LEAD_DATA from PO_TA_QUOTE  where LEAD_ID ='"+quoteId+"'";
        return jdbcTemplate.queryForObject(strQuery, String.class);
	}
	public String getEshopLeadType(String date) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strleadID = "Select LEAD_ID from PO_TA_ENERGYSHOP_LEAD  where LEAD_TIME_STAMP > to_Date('"
            + date + "','dd-mm-yy-hh24.mi.ss') and rownum=1 ORDER BY LEAD_TIME_STAMP DESC ";
       System.out.println(strleadID);
       strleadID = jdbcTemplate.queryForObject(strleadID, String.class);
       String strQuery = "Select LEAD_TYPE from PO_TA_ENERGYSHOP_LEAD where LEAD_ID = '"+strleadID+"' AND LEAD_TIME_STAMP > to_Date('"
                + date + "','dd-mm-yy-hh24.mi.ss') and rownum=1 ORDER BY LEAD_TIME_STAMP DESC ";
        System.out.println(strQuery);
        return jdbcTemplate.queryForObject(strQuery, String.class);
    }

	public String getAuditEventID(String date,String emailId) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strQuery = "Select AUDIT_EVENT_TYPE_ID from PO_TA_AUDIT_DETAILS where OAM_EMAIL_ADDRESS = '"+ emailId +"' AND AUDIT_TIMESTAMP > to_Date('"
                + date + "','dd-mm-yy-hh24.mi.ss') and rownum=1";
        System.out.println(strQuery);
        return jdbcTemplate.queryForObject(strQuery, String.class);
    }
	
	public int verifyCancelEntryCount() {

        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		
        int recCount = jdbcTemplate.queryForInt("select count(*) from po_tr_energy_dropoff_customers where email_address='centrica_digitaeww@bgdigitaltest.co.uk' and TARIFF_NAME='ClearAndSimple'");
        //String strQuery = "select email_address from po_tr_energy_dropoff_customers where email_address='centrica_digitaeww@bgdigitaltest.co.uk' and TARIFF_NAME='ClearAndSimple'";  
        //recCount = jdbcTemplate.queryForObject(strQuery, int.class);
//        recCount=Integer.parseInt(strQuery);
        return recCount;
    }
	
	public String[] verifyASVEmailConfirmation(String strPremiseId)
	{
		List rs;

		jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		String query = "Select AUDIT_ID,USER_TYPE,TRANSACTION_TYPE,AUDIT_TIME_STAMP,AUDIT_DETAILS,PREMISE_NUMBER from ASV_TA_AUDIT_DETAILS" +
						" Where  PREMISE_NUMBER = '"
						+ strPremiseId + "' order by AUDIT_TIME_STAMP desc";
		List<Map<String, Object>> ss = jdbcTemplate.queryForList(query);
        String[] list = new String[8];
		if (!ss.isEmpty()) {
			list[0] = ss.get(0).get("AUDIT_ID").toString();
			list[1] = ss.get(0).get("USER_TYPE").toString();
			list[2] = ss.get(0).get("TRANSACTION_TYPE").toString();
			list[3] = ss.get(0).get("AUDIT_TIME_STAMP").toString();	
			list[4] = ss.get(0).get("AUDIT_DETAILS").toString();	
			list[5] = ss.get(0).get("PREMISE_NUMBER").toString();	
        }
        return list;
		
	}
	

	public String verifyASVEmailConfirmationStatus(String strPremiseId)
	{
		List rs;

		jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		String query = "Select NOTIFICATION_STATUS from ASV_TA_NOTIFICATION_DETAILS Where PREMISE_NUMBER = '"
						+ strPremiseId + "' order by NOTIFICATION_CREATED_TIMESTAMP desc";
		List<Map<String, Object>> ss = jdbcTemplate.queryForList(query);
        String[] list = new String[8];
		if (!ss.isEmpty()) {
			list[0] = ss.get(0).get("NOTIFICATION_STATUS").toString();			
        }
        return list[0];
		
	}
public String verifyFastrackRegCustomer(String Ucrn) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String stremail;
        try{
        String strQuery = "Select EMAIL_ADDRESS from PO_TA_FT_REG where UCRN = '"+ Ucrn +"' and rownum=1";
        System.out.println(strQuery); 
        stremail=jdbcTemplate.queryForObject(strQuery, String.class);
        }catch(EmptyResultDataAccessException e){
        	stremail="0";
        }
        return stremail;
	}
	public String verifyRegProfileTempCustomer(String Ucrn) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String stremail;
        try{
        String strQuery = "Select OAM_EMAIL_ADDRESS from PO_TA_REG_PROFILE_TEMP where UCRN = '"+ Ucrn +"' and rownum=1";
        System.out.println(strQuery);
        stremail=jdbcTemplate.queryForObject(strQuery, String.class);
        }catch(EmptyResultDataAccessException e){
        	stremail="0";
        }
        return  stremail;
	}
	public String verifyFastrackRegCustomerUCRN(String Ucrn) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strUCRN;
        try{
        String strQuery = "Select UCRN from PO_TA_FT_REG where UCRN = '"+ Ucrn +"' and rownum=1";
        System.out.println(strQuery);
        strUCRN = jdbcTemplate.queryForObject(strQuery, String.class);
        }catch(EmptyResultDataAccessException e){
        	strUCRN="0";
        }
        return  strUCRN;
	}
	public String verifyRegProfileTempCustomerUCRN(String Ucrn) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strUCRN;
        try{
        String strQuery = "Select UCRN from PO_TA_REG_PROFILE_TEMP where UCRN = '"+ Ucrn +"' and rownum=1";
        System.out.println(strQuery);
        strUCRN = jdbcTemplate.queryForObject(strQuery, String.class);
        }catch(EmptyResultDataAccessException e){
        	strUCRN="0";
        }
        return  strUCRN;
	}
	public String verifyFastrackRegCustomerEmail(String Email) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strUCRN;
        try{
        String strQuery = "Select EMAIL_ADDRESS from PO_TA_FT_REG where EMAIL_ADDRESS = '"+ Email +"' and rownum=1";
        System.out.println(strQuery);
        strUCRN = jdbcTemplate.queryForObject(strQuery, String.class);
        }catch(EmptyResultDataAccessException e){
        	strUCRN="0";
        }
        return  strUCRN;
	}
	
	public String verifyPreRegASVCustomerEmail(String Email) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strUCRN;
        try{
        String strQuery = "Select EMAIL_ADDRESS from ASV_TA_REG_MI where EMAIL_ADDRESS = '"+ Email +"' and rownum=1";
        System.out.println(strQuery);
        strUCRN = jdbcTemplate.queryForObject(strQuery, String.class);
        }catch(EmptyResultDataAccessException e){
        	strUCRN="0";
        }
        return  strUCRN;
	}
	
	public String verifyPreRegASVTempCustomerEmail(String Email) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strUCRN;
        try{
        String strQuery = "Select OAM_EMAIL_ADDRESS from ASV_TA_PRE_REG_TEMP where OAM_EMAIL_ADDRESS = '"+ Email +"' and rownum=1";
        System.out.println(strQuery);
        strUCRN = jdbcTemplate.queryForObject(strQuery, String.class);
        }catch(EmptyResultDataAccessException e){
        	strUCRN="0";
        }
        return  strUCRN;
	}
	public String verifyPreRegASVCustomerUCRN(String Email) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strUCRN;
        try{
        String strQuery = "Select UCRN from ASV_TA_REG_MI where UCRN = '"+ Email +"' and rownum=1";
        System.out.println(strQuery);
        strUCRN = jdbcTemplate.queryForObject(strQuery, String.class);
        }catch(EmptyResultDataAccessException e){
        	strUCRN="0";
        }
        return  strUCRN;
	}
	public String verifyPreRegASVTempCustomerUCRN(String Email) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strUCRN;
        try{
        String strQuery = "Select UCRN from ASV_TA_PRE_REG_TEMP where UCRN = '"+ Email +"' and rownum=1";
        System.out.println(strQuery);
        strUCRN = jdbcTemplate.queryForObject(strQuery, String.class);
        }catch(EmptyResultDataAccessException e){
        	strUCRN="0";
        }
        return  strUCRN;
	}
	public String verifyRegProfileTempCustomerEmail(String Email) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strUCRN;
        try{
        String strQuery = "Select OAM_EMAIL_ADDRESS from PO_TA_REG_PROFILE_TEMP where OAM_EMAIL_ADDRESS = '"+ Email +"' and rownum=1";
        System.out.println(strQuery);
        strUCRN = jdbcTemplate.queryForObject(strQuery, String.class);
        }catch(EmptyResultDataAccessException e){
        	strUCRN="0";
        }
        return strUCRN;
	}
	public String verifyFastrackRegWTPCustomer(String Email) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strUCRN;
        try{
        String strQuery = "Select EMAIL_ADDRESS from PO_TA_WTP_REG where EMAIL_ADDRESS = '"+ Email +"' and rownum=1";
        System.out.println(strQuery);
        strUCRN = jdbcTemplate.queryForObject(strQuery, String.class);
        }catch(EmptyResultDataAccessException e){
        	strUCRN="0";
        }
        return  strUCRN;
	}
	public String getRegAuditEventID(String date,String emailId) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strQuery = "Select AUDIT_EVENT_TYPE_ID from PO_TA_AUDIT_DETAILS where OAM_EMAIL_ADDRESS = '"+ emailId +"' AND AUDIT_TIMESTAMP > to_Date('"
                + date + "','dd-mm-yy-hh24.mi.ss') and AUDIT_EVENT_TYPE_ID=60 and rownum=1";
        System.out.println(strQuery);
        return jdbcTemplate.queryForObject(strQuery, String.class);
    }
	public String verifyPreRegPBCustomerEmail(String Email) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strUCRN;
        try{
        String strQuery = "Select EMAIL_ADDRESS from PO_TA_PB_CUSTOMER where EMAIL_ADDRESS = '"+ Email +"' and rownum=1";
        System.out.println(strQuery);
        strUCRN = jdbcTemplate.queryForObject(strQuery, String.class);
        }catch(EmptyResultDataAccessException e){
        	strUCRN="0";
        }
        return  strUCRN;
	}
	public String verifyPreRegPBCustomerUCRN(String Email) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strUCRN;
        try{
        String strQuery = "Select UCRN from PO_TA_PB_CUSTOMER where UCRN = '"+ Email +"' and rownum=1";
        System.out.println(strQuery);
        strUCRN = jdbcTemplate.queryForObject(strQuery, String.class);
        }catch(EmptyResultDataAccessException e){
        	strUCRN="0";
        }
        return  strUCRN;
	}
	
	public int verifyLoginTryCount(String Email) {

        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        int recCount;
		try{
        String strQuery = "Select LOGIN_TRY_COUNT from BG_BUSINESS_TA_CUSTOMER_REG  where Email = '"+ Email +"' and rownum=1";  
        recCount = jdbcTemplate.queryForObject(strQuery, int.class);
        }catch(EmptyResultDataAccessException e){
        	recCount=0;
        }
        return recCount;
    }
	public String verifyAuditDetailsContactUs(String referenceno) {
        String details;
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        try{
        String strQuery = "Select AUDIT_DETAILS from PO_TA_AUDIT_DETAILS  where Reference_number = '"+ referenceno +"'";
        details = jdbcTemplate.queryForObject(strQuery, String.class);
        }catch(EmptyResultDataAccessException e){
        	details="0";
        }
        return details;
	}
	public String verifyAuditDetails(String ucrnno) {
        String details;
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        try{
        String strQuery = "Select AUDIT_DETAILS from PO_TA_AUDIT_DETAILS  where OAM_EMAIL_ADDRESS = '"+ ucrnno +"' and rownum=1";
        details = jdbcTemplate.queryForObject(strQuery, String.class);
        }catch(EmptyResultDataAccessException e){
        	details="0";
        }
        return details;
	}
	public String changePaymentTryCount(UserProfile userProfile) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        /*String strQuery1 = "Update PO_TA_PAYMENT_METER_COUNT set PAY_LAST_TIMESTAMP='16-APR-13 07.20.20.000000000' where ACCOUNT_NUMBER = '"
        		+userProfile.getAccNumber()+"' and PAY_LAST_TIMESTAMP is NULL";*/
        /*String strQuery2 = "Update PO_TA_PAYMENT_METER_COUNT set PAY_TRY_Count='3' where ACCOUNT_NUMBER = '"+userProfile.getAccNumber()+"'";*/
       
       int rowsAffected = jdbcTemplate
               .update("Update PO_TA_PAYMENT_METER_COUNT set PAY_TRY_Count='3' where ACCOUNT_NUMBER = '"
						+userProfile.getAccNumber()+
						 "'");
      String strQuery1 = "select * from po_ta_payment_meter_count where ACCOUNT_NUMBER = '"
						 +userProfile.getAccNumber()+
						 "'";
       System.out.println("The query result is" +rowsAffected);
       return strQuery1;
    }
	public String revertPaymentTryCount(UserProfile userProfile) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strQuery = "Update PO_TA_PAYMENT_METER_COUNT set PAY_TRY_Count='0' where ACCOUNT_NUMBER = '"+userProfile.getAccNumber()+"'";
        return jdbcTemplate.queryForObject(strQuery, String.class);
    }
	
	public String verifyAuditDetailsEntryDBNew(String Email, String sysDate, String registerType) {

		jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		if(registerType.equals("AccNo"))
		{
		String AuditEntry = jdbcTemplate.queryForObject(
				"Select audit_details from PO_TA_AUDIT_DETAILS where (OAM_EMAIL_ADDRESS = '"
						+ Email + "')  AND AUDIT_TIMESTAMP > to_date('"
						+ sysDate + "','dd-mm-yy-hh24.mi.ss')and AUDIT_EVENT_TYPE_ID=60 and rownum=1 ORDER BY AUDIT_TIMESTAMP DESC", String.class);
		return AuditEntry;
		}
		if(registerType.equals("DD"))
		{
		String AuditEntry = jdbcTemplate.queryForObject(
				"Select audit_details from PO_TA_AUDIT_DETAILS where (OAM_EMAIL_ADDRESS = '"
						+ Email + "')  AND AUDIT_TIMESTAMP > to_date('"
						+ sysDate + "','dd-mm-yy-hh24.mi.ss')and AUDIT_EVENT_TYPE_ID=80 and rownum=1 ORDER BY AUDIT_TIMESTAMP DESC", String.class);
		return AuditEntry;
		}
		return registerType;
		
	}

public String getRegAuditEventIDNew(String date,String emailId, String registerType) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        if(registerType.equals("AccNo"))
        {
        String strQuery = "Select AUDIT_EVENT_TYPE_ID from PO_TA_AUDIT_DETAILS where OAM_EMAIL_ADDRESS = '"+ emailId +"' AND AUDIT_TIMESTAMP > to_Date('"
                + date + "','dd-mm-yy-hh24.mi.ss') and AUDIT_EVENT_TYPE_ID=60 and rownum=1";
        System.out.println(strQuery);
        return jdbcTemplate.queryForObject(strQuery, String.class);
        }
        if(registerType.equals("DD"))
        {
        String strQuery = "Select AUDIT_EVENT_TYPE_ID from PO_TA_AUDIT_DETAILS where OAM_EMAIL_ADDRESS = '"+ emailId +"' AND AUDIT_TIMESTAMP > to_Date('"
                + date + "','dd-mm-yy-hh24.mi.ss') and AUDIT_EVENT_TYPE_ID=80 and rownum=1";
        System.out.println(strQuery);
        return jdbcTemplate.queryForObject(strQuery, String.class);
        }
        if(registerType.equals("SO"))
        {
        String strQuery = "Select AUDIT_EVENT_TYPE_ID from PO_TA_AUDIT_DETAILS where OAM_EMAIL_ADDRESS = '"+ emailId +"' AND AUDIT_TIMESTAMP > to_Date('"
                + date + "','dd-mm-yy-hh24.mi.ss') and AUDIT_EVENT_TYPE_ID=79 and rownum=1";
        System.out.println(strQuery);
        return jdbcTemplate.queryForObject(strQuery, String.class);
        }
        if(registerType.equals("Email"))
        {
        String strQuery = "Select AUDIT_EVENT_TYPE_ID from PO_TA_AUDIT_DETAILS where OAM_EMAIL_ADDRESS = '"+ emailId +"' AND AUDIT_TIMESTAMP > to_Date('"
                + date + "','dd-mm-yy-hh24.mi.ss') and AUDIT_EVENT_TYPE_ID=77 and rownum=1";
        System.out.println(strQuery);
        return jdbcTemplate.queryForObject(strQuery, String.class);
        }
		return emailId;
        
    }
public void updatePassword(String UCRN, String pwd) {
    jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    int rowsAffected = jdbcTemplate
			.update("update PO_TA_OAM_CUSTOMER set PASSWORD = '" + pwd + "'where UCRN='" + UCRN	+ "'");
    if (rowsAffected != 1) {
		Report.updateTestLog(
				"Precondition: One Time Password Setup failed", "FAIL");
    } else {
		Report.updateTestLog("Temporary Password Set to 'password12'",
				"DONE");
    }
}
public String getServicesLeadType(String date) {
    jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    String strleadID = "Select LEAD_ID from PO_TA_SERVICES_LEAD  where LEAD_TIME_STAMP > to_Date('"
        + date + "','dd-mm-yyyy') and rownum=1 ORDER BY LEAD_TIME_STAMP DESC ";
   System.out.println(strleadID);
   strleadID = jdbcTemplate.queryForObject(strleadID, String.class);
   String strQuery = "Select LEAD_TYPE from PO_TA_ENERGYSHOP_LEAD where LEAD_ID = '"+strleadID+"' AND LEAD_TIME_STAMP > to_Date('"
            + date + "','dd-mm-yyyy" +
            		"') and rownum=1 ORDER BY LEAD_TIME_STAMP DESC ";
    System.out.println(strQuery);
    
    return jdbcTemplate.queryForObject(strQuery, String.class);
}
public String getServicesLeadData(String date) {
    jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    String strQuery = "Select LEAD_DATA from PO_TA_SERVICES_LEAD  where LEAD_TIME_STAMP > to_Date('"
			+ date
			+ "','dd-mm-yyyy') and rownum=1 ORDER BY LEAD_TIME_STAMP DESC ";
    System.out.println(strQuery);
    return jdbcTemplate.queryForObject(strQuery, String.class);
}

public String getQuoteStatus(String emailId,String date) {
    jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    String strQuery = "Select QUOTE_STATUS from bgs__ta_quote_lead where EMAILADDRESS = '"+ emailId +"' AND QUOTE_TIME_STAMP > to_Date('"
            + date + "','dd-mm-yy-hh24.mi.ss') AND rownum=1"; 
    
    Report.updateTestLog("Quote status"+strQuery,"Warn");
    
    return strQuery;    
  
}

public String getAuditDetailsIDCA(String Ucrn, String date) {
    jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    String strQuery = "Select audit_details from po_ta_audit_details  where ucrn ='"+Ucrn+"' and audit_event_type_id='6120' and transaction_type_id='6120' and audit_timestamp > to_Date('"
			+ date
			+ "','dd-mm-yy-hh24.mi.ss') and rownum=1 ORDER BY audit_timestamp DESC ";
    System.out.println("Audit Details Query: "+strQuery);
    System.out.println(strQuery);
    return jdbcTemplate.queryForObject(strQuery, String.class);
}

public String getNotifDetailsCA( String date) {
    jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    String strQuery = "select NOTIFICATION_EMAIL_ADDRESS from PO_Ta_notification_details  where NOTIFICATION_SEND_TIMESTAMP > to_Date('"
			+ date
			+ "','dd-mm-yy-hh24.mi.ss') and NOTIFICATION_TEMPLATE_ID = '10000632' and rownum=1 ORDER BY NOTIFICATION_SEND_TIMESTAMP DESC ";
    System.out.println("Audit Details Query: "+strQuery);
    System.out.println(strQuery);	
    return jdbcTemplate.queryForObject(strQuery, String.class);
}


/*------------------------------------------------------------------SMB Phase 2--------------------------------------------------------------------*/

public String changebillDateDB(String date) {
	
    jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    String strQuery = "select audit_details from po_ta_audit_details where audit_TIMESTAMP > to_Date('"
			+ date
			+ "','dd-mm-yy-hh24.mi.ss') and audit_event_type_id='515' and transaction_type_id='58' and rownum=1 ORDER BY audit_TIMESTAMP DESC ";
       
    //select audit_details from po_ta_audit_details where audit_TIMESTAMP > to_Date('12-02-14 06.13.36','dd-mm-yy-hh24.mi.ss') and audit_event_type_id='515' and transaction_type_id='58' and rownum=1 ORDER BY audit_TIMESTAMP DESC
    System.out.println(strQuery);
    return jdbcTemplate.queryForObject(strQuery, String.class);
}


public String getemailID(String date) {
    jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    String strQuery = "select NOTIFICATION_EMAIL_ADDRESS from PO_Ta_notification_details  where NOTIFICATION_SEND_TIMESTAMP > to_Date('"
			+ date
			+ "','dd-mm-yy-hh24.mi.ss') and NOTIFICATION_TEMPLATE_ID = '10000632' and rownum=1 ORDER BY NOTIFICATION_SEND_TIMESTAMP DESC ";
    System.out.println("Audit Details Query: "+strQuery);
    System.out.println(strQuery);	
    return jdbcTemplate.queryForObject(strQuery, String.class);
}



/*public static void  main(String args) {

	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
	if(registerType.equals("AccNo"))
	{
	String AuditEntry = jdbcTemplate.queryForObject(
			"Select audit_details from PO_TA_AUDIT_DETAILS where (OAM_EMAIL_ADDRESS = '"+ Email + "')  AND AUDIT_TIMESTAMP > to_date('"+ sysDate + "','dd-mm-yy-hh24.mi.ss')and AUDIT_EVENT_TYPE_ID=60 and rownum=1 ORDER BY AUDIT_TIMESTAMP DESC", String.class);
		}
	if(registerType.equals("DD"))
	{
	String AuditEntry = jdbcTemplate.queryForObject(
			"Select audit_details from PO_TA_AUDIT_DETAILS where (OAM_EMAIL_ADDRESS = '"
					+ Email + "')  AND AUDIT_TIMESTAMP > to_date('"
					+ sysDate + "','dd-mm-yy-hh24.mi.ss')and AUDIT_EVENT_TYPE_ID=80 and rownum=1 ORDER BY AUDIT_TIMESTAMP DESC", String.class);
	return AuditEntry;
	}
	return registerType;
	
}*/

/*public static void  main(String args[]) {
	System.out.println("1111");
    jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    System.out.println("2222");
	systemDate = jdbcTemplate.queryForObject(
			"select to_char(SYSTIMESTAMP,'DD-MM-YY HH24.MI.SS') from dual",
			String.class);
   	System.out.println("systemDate: "+systemDate);
}*/
/*
public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	System.out.println("1111");
}
*/

/*public String getEshopAuditDetailsSMB(String date, String accountnumber) {
    jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    String strQuery = "Select AUDIT_DETAILS from PO_TA_AUDIT_DETAILS where AUDIT_TIMESTAMP > to_Date('"
			+ date
			+ "','dd-mm-yy-hh24.mi.ss') and rownum=1 and ACCOUNT_NUMBER = '"+ accountnumber + "' ORDER BY AUDIT_TIMESTAMP DESC ";
    System.out.println(strQuery);
    return jdbcTemplate.queryForObject(strQuery, String.class);
}*/


/*public static void main(String args[]) {
	
    jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
     	systemDate = jdbcTemplate.queryForObject(
   			"select to_char(SYSTIMESTAMP,'DD-MM-YY HH24.MI.SS') from dual",
   			String.class);
    String strQuery = "Select LEAD_ID from PO_TA_LEAD  where LEAD_TIME_STAMP > to_Date('"
			+ systemDate
			+ "','dd-mm-yy-hh24.mi.ss') and rownum=1 ORDER BY LEAD_TIME_STAMP DESC ";
    System.out.println(strQuery);*/


   /* return jdbcTemplate.queryForObject(strQuery, String.class);*/



}

