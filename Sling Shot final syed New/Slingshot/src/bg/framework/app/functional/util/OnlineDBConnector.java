package bg.framework.app.functional.util;

import bg.framework.app.functional.action.Slingshot.AccountSummaryAction;
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
import oracle.sql.ARRAY;

import org.springframework.core.Conventions;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import javax.sql.DataSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class OnlineDBConnector {

    private SimpleJdbcTemplate jdbcTemplate;
    private OracleDataSource dataSource;
    String systemDate;
    String UUID;
    String viewBill;
    

    public DataSource getDataSource() {
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

    public int getRegDBCount(String strQuery) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        System.out.print(strQuery);
        int rowCount = jdbcTemplate.queryForInt(strQuery);
        return (rowCount);
    }

    public String getColumn(String strColName, String strQuery) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String result = null;
		try {
			System.out.println("query: " + strQuery);
        result = jdbcTemplate.queryForObject(strQuery, String.class);
        System.out.println("Email value is :"+result);
		} catch (IncorrectResultSizeDataAccessException e) {
             //Report.updateTestLog("Test data error", "FAIL");
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
                        + Report.startDate + "','dd-mm-yy-hh24.mi.ss')");
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
                .queryForInt("Select count(*) from PO_TA_AUDIT_DETAILS  where(OAM_EMAIL_ADDRESS = '"
                        + Email
                        + "')  AND AUDIT_TIMESTAMP > to_date('"
                        + Report.startDate + "','dd-mm-yy-hh24.mi.ss')");
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
    public void deRegisterNew(String stremail) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String logStatus = "PASS";
        String logInfo = "";
        String[] unRegister = {
                "Delete FROM bg_business_ta_customer_reg where email='email'",
                 };
        logInfo = logInfo + "Executing Delete Queries for email: " + stremail
                + " in table: ";
        for (String query : unRegister) {
            query = query.replace("email", stremail);
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
    
    public String getAuditType_New01(String auditType) {

        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        return jdbcTemplate
                .queryForObject(
                        "Select AUDTI_DATA from bg_business_ta_audit_details where AUDIT_EVENT_TYPE_ID = '"
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
        String query = "update BG_BUSINESS_TA_CUSTOMER_REG set PASSWORD='EMKPnPBmhZXUXBCQp7Sirpjt+lg=' where email='"
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
						+ email.toLowerCase() + "'");
		jdbcTemplate.update("commit");
        int rowCount = jdbcTemplate
				.queryForInt("select count(*) from BG_BUSINESS_TA_CUSTOMER_REG where email='"
						+ email.toLowerCase()
						+ "' and password='EMKPnPBmhZXUXBCQp7Sirpjt+lg='");
		if (rowCount == 1) {
			Report.updateTestLog("Onetime password Update successfully in DB ",
					"PASS");
		} else {
			Report.updateTestLog("Onetime password Update successfully in DB ",
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

	public String getLeadTypeNectar() {
		// String LeadType = null;
     //   List rs;
      // jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		// rs =
		// jdbcTemplate.queryForList("Select LEAD_TYPE from PO_TA_LEAD  where LEAD_TIME_STAMP > to_date('"
		// + DBsysdate() + "','dd-mm-yy-hh24.mi.ss')");
      //  Iterator i = rs.iterator();
      //  LeadType = i.toString();
     //   while(i.hasNext()){
      //  	LeadType = i.next().toString();
     //   }

		String strQuery = "Select LEAD_TYPE from PO_TA_LEAD  where LEAD_TIME_STAMP > to_date('"
				+ DBsysdate() + "','dd-mm-yy-hh24.mi.ss')";
		return jdbcTemplate.queryForObject(strQuery, String.class);

	}

	public String getLeadStatusNectar() {
		String strQuery = "Select LEAD_STATUS from PO_TA_LEAD  where LEAD_TIME_STAMP > to_date('"
				+ DBsysdate() + "','dd-mm-yy-hh24.mi.ss')";
		return strQuery;
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
	
	public String[] verifyASVEmailConfirmation(String strPremiseId)
	{
		List rs;
		jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		String query = "Select AUDIT_ID,USER_TYPE,TRANSACTION_TYPE,AUDIT_TIME_STAMP from ASV_TA_AUDIT_DETAILS" +
						" Where  PREMISE_NUMBER = '"
						+ strPremiseId + "'";
		List<Map<String, Object>> ss = jdbcTemplate.queryForList(query);
        String[] list = new String[6];
		if (!ss.isEmpty()) {
			list[0] = ss.get(0).get("AUDIT_ID").toString();
			list[1] = ss.get(0).get("USER_TYPE").toString();
			list[2] = ss.get(0).get("TRANSACTION_TYPE").toString();
			list[3] = ss.get(0).get("AUDIT_TIME_STAMP").toString();			
        }
        return list;
		
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
	
	public String verifyLoginTryCount(String Email) {

        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String recCount;
		try{
        String strQuery = "Select LOGIN_TRY_COUNT from BG_BUSINESS_TA_CUSTOMER_REG  where Email = '"+ Email.toLowerCase()+"'";         
        recCount = jdbcTemplate.queryForObject(strQuery, String.class);
        System.out.println("logincount in table :"+recCount);
        }catch(EmptyResultDataAccessException e){
        	recCount="null";
        }
        
        return recCount;
        
        
    }
	
	public String getBpnumber(int bpnumber) {
        String strRetreiveEmailQry = "select EMAIL from BG_BUSINESS_TA_CUSTOMER_REG where customer_id=bpnumber";
        //strRetreiveEmailQry = strRetreiveEmailQry.replace("USERUCRN", strUCRN);
        System.out.print(strRetreiveEmailQry);
        return getColumn("email", strRetreiveEmailQry);
    }
	public String getBPnumber_fromacctno(String Acctno) {
      //  String strBpnumber = "select EMAIL from BG_BUSINESS_TA_CUSTOMER_REG where customer_id=Acctno";
        String strBpnumber = "select distinct BUSINESS_PARTNER_ORG_NUMBER from bg_business_ta_customer_reg where CONTRACT_ACCOUNT_NUMBER ='Acctno'";
        //strRetreiveEmailQry = strRetreiveEmailQry.replace("USERUCRN", strUCRN);
        System.out.print("strBpnumber in db"+strBpnumber);
        return strBpnumber;
    }
	
	public String getBgbEmail(String bpnumber) {
        String strRetreiveEmailQry = "select Email from BG_BUSINESS_TA_CUSTOMER_REG where BP_CONTACT_PERSON_NUMBER='bpnumber'";
        strRetreiveEmailQry = strRetreiveEmailQry.replace("bpnumber", bpnumber);
        System.out.print(strRetreiveEmailQry);
        return getColumn("EMAIL", strRetreiveEmailQry);
    }
	
	
	/*public String BgbverifyAuditDetails(String date, String emailaddress) {
//        DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd HH:mm:ss");
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		String data = jdbcTemplate.queryForObject(
				"Select AUDIT_EVENT_TYPE_ID from bg_business_ta_audit_details where email_address = '"+ emailaddress
                + "' AND AUDIT_TIMESTAMP > to_date('" + date
						+ "','dd-mm-yy-hh24.mi') and rownum=1 order by audit_id desc", String.class);
		String queryis = "Select AUDIT_EVENT_TYPE_ID from bg_business_ta_audit_details where email_address = '"+ emailaddress
        + "' AND AUDIT_TIMESTAMP > to_date('" + date+ "','dd-mm-yy-hh24.mi') and rownum=1 order by audit_id desc";
		
		String auditidis=getColumn("AUDIT_ID",queryis);
		System.out.println("query is:"+auditidis);
		System.out.println("query used is:"+queryis);
        return data;
    }*/
	public String BgbverifyAuditDetails(String date, String emailId) {
//      DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd HH:mm:ss");
      jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
      String query = "Select AUDIT_EVENT_TYPE_ID from bg_business_ta_audit_details where email_address = 'emailIdd' AND AUDIT_TIMESTAMP > to_date('" + date
				+ "','dd-mm-yy-hh24.mi') order by audit_id desc";
      String selectquery=query.replace("emailIdd", emailId);
      List<Map<String,Object>> ss=jdbcTemplate.queryForList(selectquery);
      System.out.println("query is:"+selectquery);
      String[] list=new String[6];
       if(!ss.isEmpty()){
    	   list[0]=ss.get(0).get("AUDIT_EVENT_TYPE_ID").toString();
       }else{
    	   System.out.println("Audit event type id is null");
       }
       return list[0];
		
  }
	
	public String DBsysdateDdmmyyhhmi() {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		//systemDate = jdbcTemplate.queryForObject("select to_char(SYSTIMESTAMP -(5/1440),'DD-MM-YY HH24.MI') from dual",String.class);
        systemDate = jdbcTemplate.queryForObject("select to_char(SYSTIMESTAMP -(5/1440),'DD-MON-YY HH12.MI.SS') from dual",String.class);
		System.out.println("++++++++"+systemDate);
        return systemDate;
    }
	
	public String verifyLastLoginTimeStamp(String date, String emailaddress) {

      jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		String data = jdbcTemplate.queryForObject(
				"Select count(*) from BG_BUSINESS_TA_CUSTOMER_REG where email = '"+ emailaddress
              + "' AND LAST_LOGIN_TIMESTAMP >= to_date('" + date
						+ "','dd-mm-yy-hh24.mi') ", String.class);
		System.out.println("db data"+data);
      return data;
  }
	
	public int BgbLoginTryCount(String emailaddress) {

        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		return jdbcTemplate.queryForObject(
				"Select Login_try_count from BG_BUSINESS_TA_CUSTOMER_REG where email = '"
						+ emailaddress + "'", Integer.class);
    }
	
	public void deRegisterinBgbonline(UserProfile userProfile) {

		String selectquer="Select count(*) FROM BG_BUSINESS_TA_CUSTOMER_REG where email='emailid'";
		String selectquery=selectquer.replace("emailid", userProfile.getEmail().toLowerCase());
		int reccount=getRegDBCount(selectquery);
		Report.updateTestLog("Email count from the userprofile in DB:"+reccount, "Done");
		if(reccount>=1){
		jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String logStatus = "PASS";
        String logInfo = "";
        String[] unRegister = {
                "Delete FROM bgb_business_profile where email='emailid'",
                "DELETE FROM BG_BUSINESS_TA_CUSTOMER_REG where email='emailid'"};
        logInfo = logInfo + "Executing Delete Queries for email: " + userProfile.getEmail().toLowerCase()
                + " in tables: ";
        for (String query : unRegister) {
            query = query.replace("emailid", userProfile.getEmail());
            jdbcTemplate.update(query);
            jdbcTemplate.update("commit");
            System.out.println("Completed Query: " + query);
			logInfo = logInfo
					+ ", "
					+ query.substring(query.indexOf("FROM") + 4,
							query.indexOf("where"));
        }
        Report.updateTestLog(logInfo, logStatus);
		}/*else{
        	deleteContractAccountNumber(userProfile.getAccNumber());
        	
		}*/
		deleteContractAccountNumber(userProfile.getAccNumber());
	}
	
	public void updateorRevertProfileRegistration(UserProfile userProfile,int status,String validation){
		
		System.out.println("Status value:"+status);
 		String sysdate=DBsysdate();
		switch(status){
		case 1:
			if(validation.equals("update")){
				jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		        jdbcTemplate
		                .update("update BG_BUSINESS_TA_CUSTOMER_REG set PROFILE_STATUS='ACTIVE',FREEZE_ACCOUNT_FLAG='Y' where email ='"+userProfile.getEmail()+"'");
		        System.out.println("Email id updated with freexe account flag as 'Y'");
		        jdbcTemplate.update("commit");
		    }else{
		    	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		        jdbcTemplate
		                .update("update BG_BUSINESS_TA_CUSTOMER_REG set PROFILE_STATUS='ACTIVE',FREEZE_ACCOUNT_FLAG='N' where email ='"+userProfile.getEmail()+"'");
		        System.out.println("Email id updated with freexe account flag as 'N'");
		    }
			break;
		case 2:
			if(validation.equals("update")){
				jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		        jdbcTemplate
		                .update("update BG_BUSINESS_TA_CUSTOMER_REG set PROFILE_STATUS='LOCKED',PROFILE_LOCK_TIMESTAMP=to_date("+"'"+sysdate+"'"+",'DD-MM-YY HH24.MI.SS')" +
		                		" where email ='"+userProfile.getEmail()+"'");
		        System.out.println("Email id updated with Lock status");
		        jdbcTemplate.update("commit");
		    }else{
		    	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		        jdbcTemplate
		                .update("update BG_BUSINESS_TA_CUSTOMER_REG set PROFILE_STATUS='ACTIVE',PROFILE_LOCK_TIMESTAMP=''where email ='"+userProfile.getEmail()+"'");
		        System.out.println("Email id updated with Active status");
		        jdbcTemplate.update("commit");
		    }
			break;
		}
		
	}
	
	//Added by slingshot
public int verifyEmailChange(String Email){
		
		//DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd HH:mm:ss");
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        
        int rowCount = jdbcTemplate
                .queryForInt("Select count(*) from bg_business_ta_customer_reg where email = '"+Email.toLowerCase() +"'" );
        jdbcTemplate.update("commit");
        try{
		if (rowCount == 0) {
			Report.updateTestLog(
					"New email is updated in Online DB", "FAIL");
            return 0;
            
		} else {
			Report.updateTestLog("New email is updated in Online DB",
					"PASS");
		}
		
        }
       
        catch (EmptyResultDataAccessException e){
        	Report.updateTestLog("Error Meesage:" +e, "PASS");
        }
        return rowCount; 
	}

public String verifyPasswordChange(String email){
	String password = null;
	 jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
	 try{
	 password = jdbcTemplate.queryForObject("Select password from bg_business_ta_customer_reg where email = '"+email.toLowerCase()+"'",String.class);
	 jdbcTemplate.update("commit");
	if(password.equals("n4Kp6Mk+aaGmJ2pzjQswYmp8o44="))
	{
		System.out.println("Password      --------------------> in DB"+password);
		Report.updateTestLog("New password is updated in DB as " +password, "PASS");
	}
	else{
		System.out.println("Password      --------------------> in DB"+password);
		Report.updateTestLog("New password is updated in DB as "+password, "FAIL");
	}
	
	}
	catch(Exception e){
		Report.updateTestLog("Exception"+e, "FAIL");
	}
	return password;	
}
public String verifyPasswordChangebroker(String email){
	String password = null;
	 jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
	 try{
	 password = jdbcTemplate.queryForObject("Select password from bg_business_ta_customer_reg where email = '"+email.toLowerCase()+"'",String.class);
	 jdbcTemplate.update("commit");
	if(password.equals("EMKPnPBmhZXUXBCQp7Sirpjt+lg="))
	{
		System.out.println("Password      --------------------> in DB"+password);
		Report.updateTestLog("New password is updated in DB as " +password, "PASS");
	}
	else{
		System.out.println("Password      --------------------> in DB"+password);
		Report.updateTestLog("New password is updated in DB as "+password, "FAIL");
	}
	
	}
	catch(Exception e){
		Report.updateTestLog("Exception"+e, "FAIL");
	}
	return password;	
}

public String getPasswordUsingEmail(String strEmail){
	String strRetreivePwdQry = "select password from bg_business_ta_customer_reg where email='"
		+ strEmail.toLowerCase() + "'and rownum=1";
System.out.print("strRetreivePwdQry"+strRetreivePwdQry);
	return getColumn("PASSWORD", strRetreivePwdQry);
}

public void resetEmailAddress(String email){
	try{
	jdbcTemplate
	.update("update BG_BUSINESS_TA_CUSTOMER_REG set email='ganthimani.s@cognizant.com' where email='"
			+ email + "'");
	 jdbcTemplate.update("commit");
	int rowCount = jdbcTemplate
			.queryForInt("select count(*) from BG_BUSINESS_TA_CUSTOMER_REG where email='"
					+ email
	
					+ "' and password='EMKPnPBmhZXUXBCQp7Sirpjt+lg='");
	
	if (rowCount >= 1) {
		Report.updateTestLog("Email address is update successfully in DB ",
				"PASS");
	} else {
		Report.updateTestLog("Email address is update successfully in DB ",
				"Fail");
	}
	}
	catch(NullPointerException npe){
		Report.updateTestLog("Zero rows retrived", "FAIL");
	}

}

public void updateFreezeAccountStatus(UserProfile userProfile,String flag,String status){
	
	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
	int rowcount=jdbcTemplate
	.update("update BG_BUSINESS_TA_CUSTOMER_REG set FREEZE_ACCOUNT_FLAG='"+flag+"',PROFILE_STATUS='"+status+"'" +
			"where email='"+userProfile.getEmail()+"'");

	if (rowcount >= 1) {
		Report.updateTestLog("Freeze Account status is updated successfully in DB ",
				"PASS");
		 jdbcTemplate.update("commit");
	} else {
		Report.updateTestLog("Freeze Account status is not updated in DB ",
				"WARN");
	}
	 

}

public void updateIsEmailValidationFlag(UserProfile userProfile,String flag,String status){

	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
	int rowcount=jdbcTemplate
	.update("update BG_BUSINESS_TA_CUSTOMER_REG set EMAIL_VALIDATION_FLAG='"+flag+"',PROFILE_STATUS='"+status+"'" +
			" where email='"+userProfile.getEmail()+"'");
	System.out.println("rowcount is"+rowcount);
	if (rowcount>= 1) {
		Report.updateTestLog("Email validation flag is updated successfully in DB ",
				"PASS");
		 jdbcTemplate.update("commit");
	} else {
		Report.updateTestLog("Email validation flag is not updated in DB ",
				"Fail");
	}
}

public void verifyauditdetails(UserProfile userProfile,String eventid) {
	 try{
	OnlineDBConnector onlinedb = new OnlineDBConnector();
	final String loginauditdate = onlinedb.DBsysdateDdmmyyhhmi();
	String auditeventtype=onlinedb.BgbverifyAuditDetails(loginauditdate, userProfile.getEmail());

	
	if(auditeventtype!=null){
		if(auditeventtype.trim().equals(eventid.trim())){   
		  Report.updateTestLog("Audit type displayed is matching : "+ auditeventtype, "Pass");
		}else{
		  Report.updateTestLog("Audit type displayed is not matching -"+"Expected Audit type is:"
		                        +eventid+"Displayed Audit type is:"+auditeventtype, "Fail");		
		}
	}else{
		Report.updateTestLog("Audit type is Null", "Fail");
	}}catch(Exception e){
		Report.updateTestLog("Error message displayed is:"+e, "FAIL");	
	}
	
}

public String[] verifyUserAccountInfo(String emailId) {
  
	  jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
	  /*String query = "Select EMAIL_VALIDATION_FLAG,BP_CONTACT_PERSON_NUMBER,EMAIL,to_char(LAST_LOGIN_TIMESTAMP,'DD Month,YYYY HH:MI:SS') as LAST_LOGIN_TIMESTAMP,PROFILE_STATUS" +
	  		" from BG_BUSINESS_TA_CUSTOMER_REG where email = 'emailIdd'";*/
	  String query = "Select EMAIL_VALIDATION_FLAG,BP_CONTACT_PERSON_NUMBER,EMAIL,LAST_LOGIN_TIMESTAMP,PROFILE_STATUS" +
		  		" from BG_BUSINESS_TA_CUSTOMER_REG where email = 'emailIdd'";
	  String selectquery=query.replace("emailIdd", emailId);
	  List<Map<String,Object>> ss=jdbcTemplate.queryForList(selectquery);
	  System.out.println("query is:"+selectquery);
	  String[] list=new String[6];
	   if(!ss.isEmpty()){
		   if(ss.get(0).get("EMAIL_VALIDATION_FLAG")!=null){
			  list[0]=ss.get(0).get("EMAIL_VALIDATION_FLAG").toString();
		   }else{
			  list[0]="";
		   }
		   if(ss.get(0).get("BP_CONTACT_PERSON_NUMBER")!=null){
			  list[1]=ss.get(0).get("BP_CONTACT_PERSON_NUMBER").toString();   
		   }else{
			  list[1]=""; 
		   }
		   if(ss.get(0).get("EMAIL")!=null){
			   list[2]=ss.get(0).get("EMAIL").toString(); 
		   }else{
			   list[2]="";
		   }		   
		   if(ss.get(0).get("LAST_LOGIN_TIMESTAMP")!=null){
			   list[3]=ss.get(0).get("LAST_LOGIN_TIMESTAMP").toString();
			   System.out.println("LAST_LOGIN_TIMESTAMP"+list[3]);
		   }else{
			   list[3]="";
		   }
		   if(ss.get(0).get("PROFILE_STATUS")!=null){
			   list[4]=ss.get(0).get("PROFILE_STATUS").toString();   
		   }else{
			   list[4]="";
		   }
		   System.out.println("status in db"+list[0]+list[1]+list[2]+list[3]+list[4]);
	   }else{
		   Report.updateTestLog("Record is null for the given email id:"+emailId, "FAIL");
	   }
	   return list;
   
}

public void updatePassword(UserProfile userProfile,String password){

	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
	int rowcount=jdbcTemplate
	.update("update BG_BUSINESS_TA_CUSTOMER_REG set password='"+password+"'" +
			" where email='"+userProfile.getEmail()+"'");
	System.out.println("rowcount is"+rowcount);
	if (rowcount>= 1) {
		Report.updateTestLog("Password has been reseted successfully in DB ","PASS");
		 jdbcTemplate.update("commit");
	} else {
		Report.updateTestLog("Password not rested in DB","Fail");
	}
}

public String verifyAuditDetails(String date, int audit_event_type_id) {
DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd HH:mm:ss");
jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
String data = jdbcTemplate.queryForObject(
		"Select audit_details from PO_TA_AUDIT_DETAILS  where AUDIT_EVENT_TYPE_ID = '"
				+ audit_event_type_id
				+ "' AND AUDIT_TIMESTAMP > to_date('" + date
				+ "','dd-mm-yy-hh24.mi.ss')", String.class);
return data;
}

public void deRegisterContractAccount(String contract) {

	String selectquer="Select count(*) FROM BG_BUSINESS_TA_CUSTOMER_REG where CONTRACT_ACCOUNT_NUMBER='contract'";
	String selectquery=selectquer.replace("contract", contract);
	int reccount=getRegDBCount(selectquery);
	Report.updateTestLog("Record count is ----- :"+reccount, "Done");
	if(reccount>=1){
	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    String logStatus = "PASS";
    String logInfo = "";
    String[] unRegister = {
            "DELETE FROM BG_BUSINESS_TA_CUSTOMER_REG where CONTRACT_ACCOUNT_NUMBER='contract'"};
    logInfo = logInfo + "Executing Delete Queries for CONTRACT_ACCOUNT_NUMBER number: " + contract
            + " in tables: ";
    for (String query : unRegister) {
        query = query.replace("contract", contract);
        jdbcTemplate.update(query);
        jdbcTemplate.update("commit");
        System.out.println("Completed Query: " + query);
		logInfo = logInfo
				+ ", "
				+ query.substring(query.indexOf("FROM") + 4,
						query.indexOf("where"));
    }
    Report.updateTestLog(logInfo, logStatus);
	}else{
    	Report.updateTestLog("Contract account number is null"+reccount, "Done");
    	
	}
}

public void deleteContractAccountNumber(String contract) {
	
	String selectquer="Select count(*) FROM BG_BUSINESS_TA_CUSTOMER_REG where CONTRACT_ACCOUNT_NUMBER='contract'";
	String selectqueri=selectquer.replace("contract",contract);
	int reccount=getRegDBCount(selectqueri);
	Report.updateTestLog("Customer account number from the userprofile in DB:"+reccount, "Done");
	if(reccount>2){
		String logStatus = "PASS";
	    String logInfo = "";
		jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
	    String query = "Select EMAIL FROM BG_BUSINESS_TA_CUSTOMER_REG where CONTRACT_ACCOUNT_NUMBER='contract'";
	    String selectquery=query.replace("contract", contract);
	    List<Map<String,Object>> ss=jdbcTemplate.queryForList(selectquery);
	    String[] list=new String[3];
	    	for(int iterate=0;iterate<ss.size();iterate++){
	    		
		     if(!ss.isEmpty()){
		  	   list[0]=ss.get(iterate).get("EMAIL").toString();
		  	 String[] unRegister = {
		         "DELETE FROM BGB_BUSINESS_PROFILE where email='"+list[0]+"'"};
		         logInfo = logInfo + "Executing Delete Queries for email : " + list[0]
		         + " in tables: ";
				for (String queri : unRegister) {
				 query = queri.replace("contract", contract);
				 jdbcTemplate.update(query);
				 jdbcTemplate.update("commit");
				 System.out.println("Completed Query: " + query);
					logInfo = logInfo
							+ ", "
							+ query.substring(query.indexOf("FROM") + 4,
									query.indexOf("where"));
				}
		     }else{
		  	   System.out.println("Audit event type id is null");
		     }
	    }
	    	String strDeleteEmailQry = "DELETE FROM BG_BUSINESS_TA_CUSTOMER_REG where contract_account_number='"+contract+"'";
	        jdbcTemplate.update(strDeleteEmailQry);
	        jdbcTemplate.update("commit");
	}else{
	}
}
 public String getEmail(String strAccountNumber) {
    String strRetreiveEmailQry = "select email from bg_business_ta_customer_reg where CONTRACT_ACCOUNT_NUMBER ='ContractAccountNumber' and rownum=1";    
    strRetreiveEmailQry = strRetreiveEmailQry.replace("ContractAccountNumber", strAccountNumber);
    System.out.print(strRetreiveEmailQry);
    return getColumn("email", strRetreiveEmailQry);
}
 public void updateFreezeAccount(UserProfile userProfile,String flag){
		
		jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		int rowcount=jdbcTemplate
		.update("update BG_BUSINESS_TA_CUSTOMER_REG set FREEZE_ACCOUNT_FLAG='"+flag+"'"+
				"where email='"+userProfile.getEmail()+"'");		
		if (rowcount >= 1) {
			Report.updateTestLog("Freeze Account status is updated successfully in DB ",
					"PASS");
			 jdbcTemplate.update("commit");
		} else {
			Report.updateTestLog("Freeze Account status is not updated in DB ",
					"WARN");
		}
		 

	}
 public void updateIsEmailValidationFlagAndStatus(UserProfile userProfile,String flag,String status){
	 System.out.println("Status value:"+status);
		String sysdate=DBsysdate();
		jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
		int rowcount=jdbcTemplate
		.update("update BG_BUSINESS_TA_CUSTOMER_REG set EMAIL_VALIDATION_FLAG='"+flag+"',PROFILE_STATUS='"+status+"'" +",REGISTER_DATE="+"to_date("+"'"+sysdate+"'"+",'DD-MM-YY HH24.MI.SS')"
				+" where email='"+userProfile.getEmail()+"'");
		
        System.out.println("update BG_BUSINESS_TA_CUSTOMER_REG set EMAIL_VALIDATION_FLAG='"+flag+"',PROFILE_STATUS='"+status+"'" +",REGISTER_DATE="+"to_date("+"'"+sysdate+"'"+",'DD-MM-YY HH24.MI.SS')"
				+" where email='"+userProfile.getEmail()+"'");
        jdbcTemplate.update("commit");       
		System.out.println("rowcount is"+rowcount);
		if (rowcount>= 1) {
			Report.updateTestLog("Email validation flag is updated successfully in DB ",
					"PASS");
			 jdbcTemplate.update("commit");
		} else {
			Report.updateTestLog("Email validation flag is not updated in DB ",
					"Fail");
		}
	}
 public String getEmailUsingBP(String strBPNumber) {
	    String strRetreiveEmailQry = "select email from bg_business_ta_customer_reg where BP_CONTACT_PERSON_NUMBER ='BP_Contact_Person_Number' and rownum=1";    
	    strRetreiveEmailQry = strRetreiveEmailQry.replace("BP_Contact_Person_Number", strBPNumber);
	    System.out.print(strRetreiveEmailQry);
	    return getColumn("email", strRetreiveEmailQry);
	}
public String[] getSurveyInfo(String emailid,String surveytype){
	
	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    String query = "Select SATISFACTORY_SCORE,SATISFACTORY_REASON from BG_BUSINESS_TA_SURVEY where email_address = '"+emailid+"'" +
    		" and survey_type='"+surveytype.toUpperCase()+"' and TIME_STAMP>=to_char(SYSTIMESTAMP,'DD-Mon-YY') order by SURVEY_ID desc";
    List<Map<String,Object>> ss=jdbcTemplate.queryForList(query);
    System.out.println("query is:"+query);
    String[] list=new String[2];
    if(!ss.isEmpty()){
    	if(ss.get(0).get("SATISFACTORY_SCORE")!=null){
    		list[0]=ss.get(0).get("SATISFACTORY_SCORE").toString();
    		Report.updateTestLog("list o value is"+list[0],"Pass");
    	}else{
    		list[0]="null";
    		Report.updateTestLog("list o value is"+list[0],"Pass");
    	}
    	if(ss.get(0).get("SATISFACTORY_REASON")!=null){
    		list[1]=ss.get(0).get("SATISFACTORY_REASON").toString(); 
    		Report.updateTestLog("list 1 value is"+list[1],"Pass");
    	}else{
    		list[1]="null";
    		Report.updateTestLog("list 1 value is"+list[1],"Pass");
    	}
    }else{
   	   System.out.println("Audit event type id is null");
    }
    
	return list;
}
public String[] getSMRLogs(String date){	
	String result1 = null;
	String[] list = null;
	try{
	jdbcTemplate =  new SimpleJdbcTemplate(getDataSource());
	String strQuery = "Select LEAD_DATA from BG_BUSINESS_TA_LEAD where LEAD_TIME_STAMP >= to_Date('"
				+ date
				+ "','dd-mm-yy-hh24.mi.ss') order by LEAD_TIME_STAMP desc";
	String countQuery = "Select count(LEAD_DATA) from BG_BUSINESS_TA_LEAD where LEAD_TIME_STAMP >= to_Date('"
				+ date
				+ "','dd-mm-yy-hh24.mi.ss')";
	System.out.println(strQuery);
	System.out.println(countQuery);
	int count = jdbcTemplate.queryForInt(countQuery);
	System.out.println("count  " +count);
	/*String result2 = jdbcTemplate.queryForObject(strQuery,String.class);
	System.out.println("result2  "+result2);*/
	//List<Map<String,Object>> ss=jdbcTemplate.queryForList(query);
	List<Map<String,Object>> result = jdbcTemplate.queryForList(strQuery);
	//System.out.println("result  "+result);
	list = new String[count];
	if(!result.isEmpty()){
		for (int i = 0; i<count; i++){
			list[i] = result.get(i).toString();					
			System.out.println("list[]*****************"+i+list[i]);	
		}		
	}
	else{
		System.out.println("Empty result");
	}
	
    //return jdbcTemplate.queryForObject(strQuery, String.class);
}
catch(Exception e){
	Report.updateTestLog("Exception occured"+e, "FIAL");
}
	return list;
}
public int getAuditCountUsingEmail(String email,String date){
	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
	String strCountQuery = "select count(audit_event_type_id) from bg_business_ta_audit_details where email_address ='"
	+email
	+"' and audit_timestamp > to_Date('"+
	date+"','dd-mm-yy')";
	System.out.println("select count(audit_event_type_id) from bg_business_ta_audit_details where email_address ='"+email+"' and audit_timestamp > to_Date('"+date+"','dd-mm-yy')");
	int count = jdbcTemplate.queryForInt(strCountQuery);
	return count;
}
public int getAuditCountUsingBp(String BpNumber,String date){
	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
	String strCountQuery = "select count(audit_event_type_id) from bg_business_ta_audit_details where business_partner_org_number ='"
	+BpNumber
	+"' and audit_timestamp > to_Date('"+
	date+"','dd-mm-yy')";
	System.out.println("select count(audit_event_type_id) from bg_business_ta_audit_details where business_partner_org_number ='"+BpNumber+"' and audit_timestamp > to_Date('"+date+"','dd-mm-yy')");
	int count = jdbcTemplate.queryForInt(strCountQuery);
	return count;
}
public String[] getAuditEventId(String date,String email){	
	
	String[] list = null;
	try{
		System.out.println("1.email id is:"+email);
	jdbcTemplate =  new SimpleJdbcTemplate(getDataSource());
	String strQuery = "select audit_event_type_id from bg_business_ta_audit_details where " +
			"email_address ='"+email+"' and audit_timestamp > to_Date('"+date+"','dd-mm-yy')";
	String countQuery = "select count(audit_event_type_id) from bg_business_ta_audit_details where " +
			"email_address ='"+email+"' and audit_timestamp > to_Date('"+date+"','dd-mm-yy')";
	/*String strQuery = "select audit_event_type_id from bg_business_ta_audit_details where " +
			"email_address ='emailid' and audit_timestamp > to_Date('"+date+"','dd-mm-yy')";
	String countQuery = "select count(audit_event_type_id) from bg_business_ta_audit_details where " +
			"email_address ='emailid' and audit_timestamp > to_Date('"+date+"','dd-mm-yy')";*/
	System.out.println(strQuery);
	System.out.println(countQuery);
	int count = jdbcTemplate.queryForInt(countQuery);
	System.out.println("count  " +count);
	/*String result2 = jdbcTemplate.queryForObject(strQuery,String.class);
	System.out.println("result2  "+result2);*/
	//List<Map<String,Object>> ss=jdbcTemplate.queryForList(query);
	List<Map<String,Object>> result = jdbcTemplate.queryForList(strQuery);
	System.out.println("result  "+result);
	list = new String[count];
	if(!result.isEmpty()){
		for (int i = 0; i<count; i++){
			list[i] = result.get(i).toString();					
			//System.out.println("list[]*****************"+i+list[i]);	
		}		
	}
	else{
		System.out.println("Empty result");
	}
	
    //return jdbcTemplate.queryForObject(strQuery, String.class);
}
catch(Exception e){
	Report.updateTestLog("Exception occured"+e, "FIAL");
}
	return list;
}
public String[] getAuditEventIdUsingBp(String date,String BpNumber){	
	
	String[] list = null;
	try{
		System.out.println("1.email id is:"+BpNumber);
	jdbcTemplate =  new SimpleJdbcTemplate(getDataSource());
	String strQuery = "select audit_event_type_id from bg_business_ta_audit_details where " +
			"business_partner_org_number ='"+BpNumber+"' and audit_timestamp > to_Date('"+date+"','dd-mm-yy')";
	String countQuery = "select count(audit_event_type_id) from bg_business_ta_audit_details where " +
			"business_partner_org_number ='"+BpNumber+"' and audit_timestamp > to_Date('"+date+"','dd-mm-yy')";
	/*String strQuery = "select audit_event_type_id from bg_business_ta_audit_details where " +
			"email_address ='emailid' and audit_timestamp > to_Date('"+date+"','dd-mm-yy')";
	String countQuery = "select count(audit_event_type_id) from bg_business_ta_audit_details where " +
			"email_address ='emailid' and audit_timestamp > to_Date('"+date+"','dd-mm-yy')";*/
	System.out.println(strQuery);
	System.out.println(countQuery);
	int count = jdbcTemplate.queryForInt(countQuery);
	System.out.println("count  " +count);
	/*String result2 = jdbcTemplate.queryForObject(strQuery,String.class);
	System.out.println("result2  "+result2);*/
	//List<Map<String,Object>> ss=jdbcTemplate.queryForList(query);
	List<Map<String,Object>> result = jdbcTemplate.queryForList(strQuery);
	System.out.println("result  "+result);
	list = new String[count];
	if(!result.isEmpty()){
		for (int i = 0; i<count; i++){
			list[i] = result.get(i).toString();					
			//System.out.println("list[]*****************"+i+list[i]);	
		}		
	}
	else{
		System.out.println("Empty result");
	}
	
    //return jdbcTemplate.queryForObject(strQuery, String.class);
}
catch(Exception e){
	Report.updateTestLog("Exception occured"+e, "FIAL");
}
	return list;
}
public String getAuditType(int auditEventId){
	String query = "select audit_event_type from bg_business_tr_auditevent_type where audit_event_type_id='"+auditEventId+"'";
	return jdbcTemplate.queryForObject(query,String.class);
}
public String DBsysdateDdmmyy() {
    jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
	systemDate = jdbcTemplate.queryForObject(
			"select to_char(SYSTIMESTAMP -(5/1440),'DD-MM-YY') from dual",
			String.class);
    return systemDate;
}

public void updateRegisterDate(UserProfile userProfile,String date){

	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
	int rowcount=jdbcTemplate
	.update("update BG_BUSINESS_TA_CUSTOMER_REG set REGISTER_DATE=add_months(sysdate,-29)" +
			" where email ='"+userProfile.getEmail()+"'");
	if (rowcount>= 1) {
		Report.updateTestLog("Register date is updated succesfully","PASS");
		 jdbcTemplate.update("commit");
	} else {
		Report.updateTestLog("Register date is not updated ","Warn");
	}
}

public String getEmailAddressAccountNumber(UserProfile userProfile) {
	String newemail="";  
	try{
		jdbcTemplate =  new SimpleJdbcTemplate(getDataSource());
		String strQuery = "select email from BG_BUSINESS_TA_CUSTOMER_REG where " +
				          "contract_account_number='"+userProfile.getAccNumber()+"'";
		System.out.println(strQuery);
		List<Map<String,Object>> result = jdbcTemplate.queryForList(strQuery);	
		System.out.println("List done:"+strQuery);
		String[] list=new String[6];
			if(!result.isEmpty()){
					list[0] = result.get(0).get("email").toString();	
					newemail=list[0];
				Report.updateTestLog("Email fetched for the account is :"+newemail, "Pass");	
			}else{
				newemail="Email id id null";
				System.out.println("email id is null:"+newemail);
				Report.updateTestLog("Email fetched for the account is :"+newemail, "Fail");
			}
		}catch(Exception e){
		  Report.updateTestLog("Exception occured while fetching email: "+e, "Fail");
	}
	return newemail;
}

public void updateMarketingConsentOption(String indicator,String email){
	try{
	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    String strUpdateEmailQry = "update BG_BUSINESS_TA_CUSTOMER_REG set MARKETING_CONSENT = 'indicator'where email='emailid'";
    strUpdateEmailQry = strUpdateEmailQry.replace("indicator", indicator.toUpperCase());
    strUpdateEmailQry = strUpdateEmailQry.replace("emailid", email);
    int rowsAffected = jdbcTemplate.update(strUpdateEmailQry);

    jdbcTemplate.update("commit");
    if (rowsAffected != 1) {
		Report.updateTestLog(
				"Unable to update Marketing consent option in Online DB", "FAIL");
    } else{
        Report.updateTestLog("Marketing consent option is updated in Online DB", "Pass");
    }}catch(Exception e){
		  Report.updateTestLog("Exception occured while updating marketing consent option,: "+e, "Fail");
	}
}

public int verifyAccountExit(String email,String accountnumber){
	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    int rowCount = jdbcTemplate
			.queryForInt("select count(*) from BG_BUSINESS_TA_CUSTOMER_REG where email='"
					+ email.toLowerCase()+ "' and contract_account_number='"+accountnumber+"'");
	if (rowCount == 1) {
		Report.updateTestLog("Account number and the Email in the xml file is exist in the application ",
				"Done");
	} else {
		Report.updateTestLog("Account number and the Email in the xml file is not exist in the application ",
				"Done");
    }
	return rowCount;
}

public String[] verifyleadDBForLeadType(String date,String email, String type){
	String[] list =null;	
	  jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
      /*String strQuery = "Select LEAD_STATUS,LEAD_TYPE,TITLE,FIRST_NAME,SURNAME,COMPANY,CONTACT_NUMBER,POSTCODE,MARKETING_CONSENT,TOTAL_ANNUAL_SPEND,COMMENTS,COMPANY_REGISTRATION_NUMBER,ADDRESS,EMAIL_ADDRESS,TOWN,COURSE,ACCOUNT_NUMBER,BILL_DATE_FROM,BILL_DATE_TO" 
	  + " from bg_business_ta_callback_lead  where email_address ='"+email+"'and LEAD_TIMESTAMP > to_Date('"
				+ date
				+ "','dd-mm-yy-hh24.mi.ss') and LEAD_TYPE='"+type+"' and rownum=1 ORDER BY LEAD_TIMESTAMP DESC";*/
	  
	  String strQuery = "Select LEAD_STATUS,LEAD_TYPE,TITLE,FIRST_NAME,SURNAME,COMPANY,CONTACT_NUMBER,POSTCODE,MARKETING_CONSENT,TOTAL_ANNUAL_SPEND,COMMENTS,COMPANY_REGISTRATION_NUMBER,ADDRESS,EMAIL_ADDRESS,TOWN,COURSE,ACCOUNT_NUMBER,BILL_DATE_FROM,BILL_DATE_TO" 
			  + " from bg_business_ta_callback_lead  where email_address ='"+email+"'";
      String[] strColumnList = {"LEAD_STATUS","LEAD_TYPE","TITLE","FIRST_NAME","SURNAME","COMPANY","CONTACT_NUMBER","POSTCODE","MARKETING_CONSENT","TOTAL_ANNUAL_SPEND","COMMENTS","COMPANY_REGISTRATION_NUMBER","ADDRESS","EMAIL_ADDRESS","TOWN","COURSE","ACCOUNT_NUMBER","BILL_DATE_FROM","BILL_DATE_TO"};
      System.out.println(strQuery);
     // return jdbcTemplate.queryForObject(strQuery, String.class);
      int columnCount = jdbcTemplate.queryForInt("SELECT COUNT(*) FROM USER_TAB_COLUMNS WHERE TABLE_NAME='BG_BUSINESS_TA_CALLBACK_LEAD'");
      List<Map<String,Object>> ss= jdbcTemplate.queryForList(strQuery);      
      list = new String[columnCount];
     
      if(!ss.isEmpty()){
    	  for(int i=0;i<strColumnList.length;i++){    		
        	  if(ss.get(0).get(strColumnList[i])!=null){
        		  list[i]=ss.get(0).get(strColumnList[i]).toString();
        		  System.out.println(list[i]+strColumnList[i]+ss.get(0).get(strColumnList[i]));
        		  
        	  }
        	  else{
        		  list[i]="null";
        		  System.out.println("Null list"+strColumnList[i]+ss.get(0).get(strColumnList[i]));
        	  }
    	  }
      }   
	return list;
}

public String[] getAuditEventTypeId(String date,String emailId, String type) {
    jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    String strQuery = "Select AUDIT_EVENT_TYPE_ID,AUDTI_DATA from bg_business_ta_audit_details where EMAIL_ADDRESS = '"+ emailId +"' AND AUDIT_TIMESTAMP > to_Date('"
            + date + "','dd-mm-yy-hh24.mi.ss') and AUDTI_DATA like '%"+type+"%' and rownum=1";
    //String strQuery = "Select EMAIL_ADDRESS from bg_business_ta_audit_details where EMAIL_ADDRESS = '"+ emailId +"' and rownum=1";
    System.out.println(strQuery); 
    List<Map<String, Object>> ss=jdbcTemplate.queryForList(strQuery);
    String[] list = new String[2];
    if(!ss.isEmpty()){
    	 if(ss.get(0).get("AUDIT_EVENT_TYPE_ID")!=null){
    		 list[0]=ss.get(0).get("AUDIT_EVENT_TYPE_ID").toString();}
    	 if(ss.get(0).get("AUDTI_DATA")!=null){
    		 list[1]=ss.get(0).get("AUDTI_DATA").toString();
    	 }
    }
    return list;    
  
}

public String[] getAuditEventTypeIdMany(String date,String emailId, String type) {
    jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    String strQuery = "Select AUDIT_EVENT_TYPE_ID,AUDTI_DATA from bg_business_ta_audit_details where EMAIL_ADDRESS = '"+ emailId +"' AND AUDIT_TIMESTAMP > to_Date('"
            + date + "','dd-mm-yy-hh24.mi.ss') and AUDTI_DATA like '%"+type+"%'";
    //String strQuery = "Select EMAIL_ADDRESS from bg_business_ta_audit_details where EMAIL_ADDRESS = '"+ emailId +"' and rownum=1";
    System.out.println(strQuery); 
    List<Map<String, Object>> ss=jdbcTemplate.queryForList(strQuery);
    String[] list = new String[4];
    if(!ss.isEmpty()){
    	 if(ss.get(0).get("AUDIT_EVENT_TYPE_ID")!=null){
    		 list[0]=ss.get(0).get("AUDIT_EVENT_TYPE_ID").toString();}
    	 if(ss.get(0).get("AUDTI_DATA")!=null){
    		 list[1]=ss.get(0).get("AUDTI_DATA").toString();}
		 if(ss.get(1).get("AUDIT_EVENT_TYPE_ID")!=null){
    		 list[2]=ss.get(1).get("AUDIT_EVENT_TYPE_ID").toString();}
    	 if(ss.get(1).get("AUDTI_DATA")!=null){
    		 list[3]=ss.get(1).get("AUDTI_DATA").toString();}
    	 }
      return list;    
 }

public int verifyEmailExists(String email){
	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    int rowCount = jdbcTemplate
			.queryForInt("select count(*) from BG_BUSINESS_TA_CUSTOMER_REG where email='"
					+ email.toLowerCase()+"'");
	if (rowCount == 1) {
		Report.updateTestLog("Email in the xml file is exist in the application ","DONE");
	} else {
		rowCount=0;
		Report.updateTestLog("Email in the xml file is not exist in the application ","DONE");
    }
	return rowCount;
}
public String[] verifyMeterRemainderTable(String date,String email){
	String[] list =null;	
	  jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
      String strQuery = "Select ACCOUNT_NUMBER,SITE_NUMBER,CUSTOMER_NAME,EMAIL_ADDRESS,LEAD_STATUS" 
	  + " from BG_BUSINESS_TA_MR_REMINDER  where EMAIL_ADDRESS ='"+email+"'and LEAD_TIMESTAMP > to_Date('"
				+ date
				+ "','dd-mm-yy-hh24.mi.ss') and rownum=1 ORDER BY LEAD_TIMESTAMP DESC";
      String[] strColumnList = {"ACCOUNT_NUMBER","SITE_NUMBER","CUSTOMER_NAME","EMAIL_ADDRESS","LEAD_STATUS"};
      System.out.println(strQuery);
      int columnCount = jdbcTemplate.queryForInt("SELECT COUNT(*) FROM USER_TAB_COLUMNS WHERE TABLE_NAME='BG_BUSINESS_TA_MR_REMINDER'");
      List<Map<String,Object>> ss= jdbcTemplate.queryForList(strQuery);      
      list = new String[columnCount];
     
      if(!ss.isEmpty()){
    	  for(int i=0;i<strColumnList.length;i++){    		
        	  if(ss.get(0).get(strColumnList[i])!=null){
        		  list[i]=ss.get(0).get(strColumnList[i]).toString();
        		  System.out.println(list[i]+strColumnList[i]+ss.get(0).get(strColumnList[i]));
        		  
        	  }
        	  else{
        		  list[i]="null";
        		  System.out.println("Null list"+strColumnList[i]+ss.get(0).get(strColumnList[i]));
        	  }
    	  }
      }   
	return list;
}

public String verifyTotalUserCount(String FlagType,String Bpnumber) {
		jdbcTemplate = new SimpleJdbcTemplate(getDataSource());		
				System.out.println("i am in ");
				String Jquery ="select  count(*) from bg_business_ta_customer_reg where business_partner_org_number ='"+Bpnumber +"' and is_super_user_flag='"+FlagType+"' and FREEZE_ACCOUNT_FLAG NOT IN 'y' and PROFILE_STATUS='ACTIVE'";
				String strFlag = jdbcTemplate.queryForObject(Jquery, String.class);	
				System.out.println("strFlag"+strFlag);
		return strFlag;
	}
public String[] getAuditEventTypeIdForMUMV(String date,String emailId, String type) {
    jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    String strQuery = "Select AUDIT_EVENT_TYPE_ID,AUDTI_DATA from bg_business_ta_audit_details where EMAIL_ADDRESS = '"+ emailId +"' and AUDTI_DATA like '%"+type+"%' and rownum=1";
    //String strQuery = "Select EMAIL_ADDRESS from bg_business_ta_audit_details where EMAIL_ADDRESS = '"+ emailId +"' and rownum=1";
    System.out.println(strQuery); 
    List<Map<String, Object>> ss=jdbcTemplate.queryForList(strQuery);
    String[] list = new String[2];
    if(!ss.isEmpty()){
    	 if(ss.get(0).get("AUDIT_EVENT_TYPE_ID")!=null){
    		 list[0]=ss.get(0).get("AUDIT_EVENT_TYPE_ID").toString();}
    	 if(ss.get(0).get("AUDTI_DATA")!=null){
    		 list[1]=ss.get(0).get("AUDTI_DATA").toString();
    	 }
    }
    return list;    
  
}

public String[] getAuditEventTypeIdForMUMV1(String date,String emailId, String type) {
    jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    String strQuery = "Select AUDIT_EVENT_TYPE_ID,AUDTI_DATA from bg_business_ta_audit_details where EMAIL_ADDRESS = '"+ emailId +"' and AUDTI_DATA like '%"+type+"%' and TRANSACTION_TYPE_ID ='1824'";
    //String strQuery = "Select EMAIL_ADDRESS from bg_business_ta_audit_details where EMAIL_ADDRESS = '"+ emailId +"' and rownum=1";
    System.out.println(strQuery); 
    List<Map<String, Object>> ss=jdbcTemplate.queryForList(strQuery);
    String[] list = new String[2];
    if(!ss.isEmpty()){
    	 if(ss.get(0).get("AUDIT_EVENT_TYPE_ID")!=null){
    		 list[0]=ss.get(0).get("AUDIT_EVENT_TYPE_ID").toString();}
    	 if(ss.get(0).get("AUDTI_DATA")!=null){
    		 list[1]=ss.get(0).get("AUDTI_DATA").toString();
    	 }
    }
    return list;    
  
}
public String[] getAuditEventTypeIdForGAQ(String date,String audittype,String type, String trasactiontype) {
    jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
 //   String strQuery = "Select AUDIT_EVENT_TYPE_ID,AUDTI_DATA from bg_business_ta_audit_details where EMAIL_ADDRESS = '"+ emailId +"' and AUDTI_DATA like '%"+type+"%' and TRANSACTION_TYPE_ID ='"+ trasactiontype +"'";
    String strQuery = "Select AUDIT_EVENT_TYPE_ID,AUDTI_DATA from bg_business_ta_audit_details  where TRANSACTION_TYPE_ID='"+ trasactiontype +"' and AUDIT_EVENT_TYPE_ID='"+ audittype +"' and rownum=1 order by audit_id desc";
    //String strQuery = "Select EMAIL_ADDRESS from bg_business_ta_audit_details where EMAIL_ADDRESS = '"+ emailId +"' and rownum=1";
    System.out.println(strQuery); 
    List<Map<String, Object>> ss=jdbcTemplate.queryForList(strQuery);
    String[] list = new String[2];
    if(!ss.isEmpty()){
    	 if(ss.get(0).get("AUDIT_EVENT_TYPE_ID")!=null){
    		 list[0]=ss.get(0).get("AUDIT_EVENT_TYPE_ID").toString();}
    	 if(ss.get(0).get("AUDTI_DATA")!=null){
    		 list[1]=ss.get(0).get("AUDTI_DATA").toString();
    	 }
    }
    return list;    
  
}
public String getBpcpnumber(String email)
{
	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());	
	String Jquery= "select BP_CONTACT_PERSON_NUMBER from bg_business_ta_customer_reg where email='"+email+"'";
	 String bpcpnumber = jdbcTemplate.queryForObject(Jquery, String.class);	
	 System.out.println("bpcpnumber"+bpcpnumber);
	 return bpcpnumber;
	}

public String verifyAuditIsSuperOrStandardUserFlag(String date, String emailaddress) {

    jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    System.out.println("Select IS_SUPER_USER_FLAG from BG_BUSINESS_TA_CUSTOMER_REG where email = '"+ emailaddress + "' AND REGISTER_DATE >= to_date('" + date + "','dd-mm-yy-hh24.mi')");
		String data = jdbcTemplate.queryForObject(
				"Select IS_SUPER_USER_FLAG from BG_BUSINESS_TA_CUSTOMER_REG where email = '"+ emailaddress
            + "' AND REGISTER_DATE >= to_date('" + date
						+ "','dd-mm-yy-hh24.mi') ", String.class);
    return data;
}
public String[] verifyAuditForPaperLessOption(String date, String emailaddress) {

    jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    String strQuery = "Select AUDIT_EVENT_TYPE_ID,AUDTI_DATA from BG_BUSINESS_TA_CUSTOMER_REG where email = '"+ emailaddress + "' AND REGISTER_DATE >= to_date('" + date + "','dd-mm-yy-hh24.mi')";
    System.out.println(strQuery); 
    List<Map<String, Object>> ss=jdbcTemplate.queryForList(strQuery);
    String[] list = new String[2];
    if(!ss.isEmpty()){
    	 if(ss.get(0).get("AUDIT_EVENT_TYPE_ID")!=null){
    		 list[0]=ss.get(0).get("AUDIT_EVENT_TYPE_ID").toString();}
    	 if(ss.get(0).get("AUDTI_DATA")!=null){
    		 list[1]=ss.get(0).get("AUDTI_DATA").toString();
    	 }
    }
    return list;    
}

public String verifyAuditforGetAQTrading(String date, String emailaddress,String quoterefno)
{
	
	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    System.out.println("Select LEAD_STATUS from bgb_ta_quote_lead_tracking where quote_reference_number='"+ quoterefno + "' and rownum=1");
		String data = jdbcTemplate.queryForObject(
				"Select LEAD_STATUS from bgb_ta_quote_lead_tracking where quote_reference_number='"+ quoterefno+"' and rownum=1", String.class);
		System.out.println("dataaaaaaaaaaa"+data);
    return data;
}

public String getAuditEventTypeIdForRenewals(String Date,String Entermail) {
	System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC");
	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
	//String Result=jdbcTemplate.queryForObject("SELECT EMAIL FROM bgb_business_profile where EMAIL='" + Entermail + "' AND AUDIT_TIMESTAMP >='"+Date+"'AND ROWNUM='1'",String.class);
	//String Result = "Select EMAIL from bgb_business_profile where email = '"+ Entermail + "' AND REGISTER_DATE >= to_date('" + Date + "','dd-mm-yy-hh24.mi')";
	String Result = "Select EMAIL from BG_BUSINESS_TA_AUDIT_DETAILS where email = '"+ Entermail + "' AND REGISTER_DATE >= to_date('" + Date + "')";
	System.out.println("  "+Result);
    return Result;
}
public String DBsysdateDdmonyyhhmi() {
    jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
	systemDate = jdbcTemplate.queryForObject(
			"select to_char(SYSTIMESTAMP -(5/1440),'DD-MON-YY HH12.MI.SS') from dual",
			String.class);
	System.out.println(" System Date query is" + systemDate); 
    return systemDate;
}

public String[] getAuditEventTypeIdForRenewals(String date,String emailId, String type) {
    jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
    //String strQuery = "Select EMAIL_ADDRESS,AUDIT_EVENT_TYPE_ID,AUDTI_DATA from bg_business_ta_audit_details where EMAIL_ADDRESS = '"+ emailId +"' and AUDTI_DATA like '%"+type+"%' and rownum=1";
    String strQuery = "Select EMAIL_ADDRESS,AUDIT_EVENT_TYPE_ID,AUDTI_DATA from bg_business_ta_audit_details where EMAIL_ADDRESS = '"+ emailId +"' and rownum=1";
    System.out.println(strQuery); 
    List<Map<String, Object>> ss=jdbcTemplate.queryForList(strQuery);
    String[] list = new String[2];
    if(!ss.isEmpty()){
    	 if(ss.get(0).get("AUDIT_EVENT_TYPE_ID")!=null){
    		 list[0]=ss.get(0).get("AUDIT_EVENT_TYPE_ID").toString();}
    	 if(ss.get(0).get("AUDTI_DATA")!=null){
    		 list[1]=ss.get(0).get("AUDTI_DATA").toString();
    	 }
    }
    return list;    
  
}

public String getRenewalAuditType(String auditType) {

    jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    return jdbcTemplate
            .queryForObject("Select AUDTI_DATA from bg_business_ta_audit_details where AUDIT_EVENT_TYPE_ID = '"
                            + auditType + "'", String.class);
}
public String Generate_UUID(String Date,String emailId) {
    jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
    System.out.println("Select UUID from bgb_ta_agent_invitation_table where email_ID = '"+ emailId + "'" );
    String UUID =jdbcTemplate.queryForObject("Select EMAIL from BG_BUSINESS_TA_CUSTOMER_REG where email = '"+ emailId + "' AND REGISTER_DATE >= to_date('" + Date + "')", String.class);
    
    
    
    System.out.println("The UUID is --> "+UUID);
    return UUID;

}

public String getUUIDType(UserProfile userProfile) {

    jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    return jdbcTemplate.queryForObject("Select UUID from bgb_business_profile where email = '"+ userProfile.getNewEmail() + "'", String.class);
}


public String getUUID01(String Entermail) {
	System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC");
	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
	System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
	//String Result = jdbcTemplate.queryForObject("Select UUID from bgb_ta_agent_invitation_table where email_id = '"+ Entermail + "' and rownum=1", String.class);
	//String Result = "Select UUID from bgb_ta_agent_invitation_table where email_id = '"+ Entermail + "'";
	String Result = jdbcTemplate.queryForObject("Select UUID from bgb_ta_agent_invitation_table where email_id = '"+ Entermail + "') ", String.class);
	System.out.println("UUID is  "+Result);
    return Result;
}
public String Generate_UUIDNew(String emailId) {
    jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
    System.out.println("Select UUID from bgb_ta_agent_invitation_table where email_id = '"+ emailId + "'" );
    String UUID = jdbcTemplate.queryForObject("Select UUID from bgb_ta_agent_invitation_table where email_id = '"+ emailId + "'", String.class);
   
    
    System.out.println("The UUID is --> "+UUID);
    return UUID;

}

public String Generate_UUIDNew01(String emailId) {
    jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
    System.out.println("Select UUID from bgb_business_profile where email = '"+ emailId + "'" );
    String UUID = jdbcTemplate.queryForObject("Select UUID from bgb_business_profile where email = '"+ emailId + "'", String.class);
   
    
    System.out.println("The UUID is --> "+UUID);
    return UUID;

}  

public String Verify_Freeze_Account(String emailId) {
    jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
    System.out.println("Select FREEZE_ACCOUNT_FLAG from BG_BUSINESS_TA_CUSTOMER_REG where email = '"+ emailId + "'" );
    String FreezeAccount = jdbcTemplate.queryForObject("Select FREEZE_ACCOUNT_FLAG from BG_BUSINESS_TA_CUSTOMER_REG where email = '"+ emailId + "'", String.class);
       
    System.out.println("The UUID is --> "+FreezeAccount);
    return FreezeAccount;

}  

public String getAUDTI_DATA_Audit_Table(String Date,String emailId, String type) {
    jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    System.out.println("/////////////////////////////////////////////////////");
    //String strQuery = jdbcTemplate.queryForObject("Select AUDTI_DATA from bg_business_ta_audit_details where EMAIL_ADDRESS = '"+ emailId +"' and AND AUDIT_TIMESTAMP > to_Date('"
      //      + date + "','dd-mm-yy-hh24.mi.ss') rownum=1", String.class);
    
    String strQuery =jdbcTemplate.queryForObject("Select AUDTI_DATA from bg_business_ta_audit_details where EMAIL_ADDRESS = '"+ emailId + "' AND AUDIT_TIMESTAMP >= to_date('" + Date + "','dd-mm-yy-hh24.mi.ss')", String.class);
    
    
    
    System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    //String strQuery = "Select EMAIL_ADDRESS from bg_business_ta_audit_details where EMAIL_ADDRESS = '"+ emailId +"' and rownum=1";
    System.out.println(strQuery); 
    /*List<Map<String, Object>> ss=jdbcTemplate.queryForList(strQuery);
    String[] list = new String[2];
    if(!ss.isEmpty()){
    	 if(ss.get(0).get("AUDIT_EVENT_TYPE_ID")!=null){
    		 list[0]=ss.get(0).get("AUDIT_EVENT_TYPE_ID").toString();}
    	 if(ss.get(0).get("AUDTI_DATA")!=null){
    		 list[1]=ss.get(0).get("AUDTI_DATA").toString();
    	 }
    }*/
    return strQuery;    
  
}

public String verifyAdditionalAccounts (String Date,String accountnumber )
{
	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
	//String querry="SELECT AUDIT_EVENT_TYPE_ID FROM BG_BUSINESS_TA_AUDIT_DETAILS where EMAIL_ADDRESS="+ emailaddress + " AND AUDIT_EVENT_TYPE_ID='98' AND AUDIT_TIMESTAMP >="+Date+"";
	//System.out.println(" "+SELECT AUDIT_EVENT_TYPE_ID FROM BG_BUSINESS_TA_AUDIT_DETAILS where EMAIL_ADDRESS="+ emailaddress + " AND AUDIT_EVENT_TYPE_ID='98' AND AUDIT_TIMESTAMP >="+Date+"");
    String Result=jdbcTemplate.queryForObject("SELECT ACCOUNT_NUMBER FROM bgb_ta_add_additional_accounts where ACCOUNT_NUMBER='" + accountnumber + "' AND CREATED_TIME_STAMP >='"+Date+"'AND ROWNUM='1'",String.class);
    System.out.println("  "+Result);
    return Result;
}

public String verifyAuditEntryForRegistrationNew (String Date,String emailaddress )
{

	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
	String Result=jdbcTemplate.queryForObject("SELECT CONTRACT_ACCOUNT_NUMBER FROM BG_BUSINESS_TA_CUSTOMER_REG where EMAIL='"+emailaddress + "'AND REGISTER_DATE >='"+Date+"'",String.class);
	//System.out.println("querryyyy " + queryForObject("SELECT CONTRACT_ACCOUNT_NUMBER FROM BG_BUSINESS_TA_CUSTOMER_REG where EMAIL='"+emailaddress + "'AND REGISTER_DATE >='"+Date+"'",String.class));
	
	System.out.println(" " +Result);
	return Result;
}
public String verifyAuditEntryForEmailConfirmationNew (String Date,String emailaddress )
{
	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
	//String querry="SELECT AUDIT_EVENT_TYPE_ID FROM BG_BUSINESS_TA_AUDIT_DETAILS where EMAIL_ADDRESS="+ emailaddress + " AND AUDIT_EVENT_TYPE_ID='98' AND AUDIT_TIMESTAMP >="+Date+"";
	//System.out.println(" "+SELECT AUDIT_EVENT_TYPE_ID FROM BG_BUSINESS_TA_AUDIT_DETAILS where EMAIL_ADDRESS="+ emailaddress + " AND AUDIT_EVENT_TYPE_ID='98' AND AUDIT_TIMESTAMP >="+Date+"");
    String Result=jdbcTemplate.queryForObject("SELECT AUDIT_EVENT_TYPE_ID FROM BG_BUSINESS_TA_AUDIT_DETAILS where EMAIL_ADDRESS='" + emailaddress + "' AND AUDIT_TIMESTAMP >='"+Date+"'AND ROWNUM='1'",String.class);
    System.out.println("  "+Result);
    return Result;
}
public String verifyAuditEntryForEmailConfirmation (String Date,String emailaddress )
{
	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
	//String querry="SELECT AUDIT_EVENT_TYPE_ID FROM BG_BUSINESS_TA_AUDIT_DETAILS where EMAIL_ADDRESS="+ emailaddress + " AND AUDIT_EVENT_TYPE_ID='98' AND AUDIT_TIMESTAMP >="+Date+"";
	//System.out.println(" "+SELECT AUDIT_EVENT_TYPE_ID FROM BG_BUSINESS_TA_AUDIT_DETAILS where EMAIL_ADDRESS="+ emailaddress + " AND AUDIT_EVENT_TYPE_ID='98' AND AUDIT_TIMESTAMP >="+Date+"");
    String Result=jdbcTemplate.queryForObject("SELECT AUDIT_EVENT_TYPE_ID FROM BG_BUSINESS_TA_AUDIT_DETAILS where EMAIL_ADDRESS='" + emailaddress + "' AND AUDIT_TIMESTAMP >='"+Date+"'AND ROWNUM='1'",String.class);
    System.out.println("  "+Result);
    return Result;
}
public String Generate_UUID(String emailId) {
    jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
    System.out.println("Select UUID from bgb_business_profile where email = '"+ emailId + "'" );
    UUID = jdbcTemplate.queryForObject("Select UUID from bgb_business_profile where email = '"+ emailId + "'", String.class);
    System.out.println("The UUID is --> "+UUID);
    return UUID;

}

public String Generate_MPD_UUID(String emailId) {
    jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
    System.out.println("Select UUID from bg_business_update_cust_dtls where email = '"+ emailId + "'" );
    UUID = jdbcTemplate.queryForObject("Select UUID from bg_business_update_cust_dtls where email = '"+ emailId + "'", String.class);
    System.out.println("The UUID is --> "+UUID);
    return UUID;

}

public String getAuditEventTypeIdForMUMVNew01(String Date,String Entermail) {
	System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC");
	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
	//String Result=jdbcTemplate.queryForObject("SELECT EMAIL FROM bgb_business_profile where EMAIL='" + Entermail + "' AND AUDIT_TIMESTAMP >='"+Date+"'AND ROWNUM='1'",String.class);
	//String Result = "Select EMAIL from bgb_business_profile where email = '"+ Entermail + "' AND REGISTER_DATE >= to_date('" + Date + "','dd-mm-yy-hh24.mi')";
	String Result = "Select EMAIL from BG_BUSINESS_TA_CUSTOMER_REG where email = '"+ Entermail + "' AND REGISTER_DATE >= to_date('" + Date + "')";
	System.out.println("  "+Result);
    return Result;
}
public String getAuditEventTypeIdForMUMVNew(String Date,String Entermail) {
	System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC");
	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
	//String Result=jdbcTemplate.queryForObject("SELECT EMAIL FROM bgb_business_profile where EMAIL='" + Entermail + "' AND AUDIT_TIMESTAMP >='"+Date+"'AND ROWNUM='1'",String.class);
	//String Result = "Select EMAIL from bgb_business_profile where email = '"+ Entermail + "' AND REGISTER_DATE >= to_date('" + Date + "','dd-mm-yy-hh24.mi')";
	String Result = "Select EMAIL from bgb_business_profile where email = '"+ Entermail + "' AND REGISTER_DATE >= to_date('" + Date + "')";
	System.out.println("  "+Result);
    return Result;
	
 
}
public String verifyAuditEntryForSuperUser (String Date,String emailaddress )
{
	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
	String Result=jdbcTemplate.queryForObject("SELECT AUDIT_EVENT_TYPE_ID FROM BG_BUSINESS_TA_AUDIT_DETAILS where EMAIL_ADDRESS='" + emailaddress + "' AND AUDIT_TIMESTAMP >='"+Date+"'AND AUDIT_EVENT_TYPE_ID='312'",String.class);
	System.out.println(" " +Result);
	return Result;
}
public String verifyAuditEntryForPasswordEmail (String Date,String emailaddress )
{
	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
	String Result=jdbcTemplate.queryForObject("SELECT AUDIT_EVENT_TYPE_ID FROM BG_BUSINESS_TA_AUDIT_DETAILS where EMAIL_ADDRESS='"+emailaddress + "'AND AUDIT_TIMESTAMP >='"+Date+"'",String.class);
	System.out.println(" " +Result);
	return Result;
}
public String verifyAuditEntryForBarclays (String Date,String emailaddress )
{
	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
	String Result=jdbcTemplate.queryForObject("SELECT CID FROM BG_BUSINESS_TA_CUSTOMER_REG WHERE EMAIL='"+emailaddress+"' AND REGISTER_DATE >='"+Date+"'",String.class);
	System.out.println(" " +Result);
	return Result;
}
public String verifyAuditEntryForSurveyConfirmation (String Date,String emailaddress )
{
	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
	String Result=jdbcTemplate.queryForObject("SELECT SURVEY_TYPE FROM BG_BUSINESS_TA_SURVEY WHERE EMAIL_ADDRESS='"+emailaddress+"' AND TIME_STAMP >='"+Date+"'",String.class);
	System.out.println(" " +Result);
	return Result;
}
public String verifyAuditEntryForRegistration (String Date,String emailaddress )
{

	jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
	String Result=jdbcTemplate.queryForObject("SELECT CONTRACT_ACCOUNT_NUMBER FROM BG_BUSINESS_TA_CUSTOMER_REG where EMAIL='"+emailaddress + "'AND REGISTER_DATE >='"+Date+"'",String.class);
	//System.out.println("querryyyy " + queryForObject("SELECT CONTRACT_ACCOUNT_NUMBER FROM BG_BUSINESS_TA_CUSTOMER_REG where EMAIL='"+emailaddress + "'AND REGISTER_DATE >='"+Date+"'",String.class));
	
	System.out.println(" " +Result);
	return Result;
}

public String Generate_UUID_Registration(String emailId) {
    jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
    System.out.println("Select UUID from bgb_business_profile where email = '"+ emailId + "'" );
    UUID = jdbcTemplate.queryForObject("Select UUID from bgb_business_profile where email = '"+ emailId + "'", String.class);
    System.out.println("The UUID is --> "+UUID);
    return UUID;

}  

public String[] getAUDTI_DATAForViewBill(String date,String emailId, String type) {
    jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    String strQuery = "Select AUDIT_EVENT_TYPE_ID,AUDTI_DATA from bg_business_ta_audit_details where EMAIL_ADDRESS = '"+ emailId +"'AND AUDIT_TIMESTAMP >='"+date+"' and AUDTI_DATA like '%"+type+"%' and rownum=1";
    //String strQuery = "Select EMAIL_ADDRESS from bg_business_ta_audit_details where EMAIL_ADDRESS = '"+ emailId +"' and rownum=1";
    System.out.println(strQuery); 
    List<Map<String, Object>> ss=jdbcTemplate.queryForList(strQuery);
    String[] list = new String[2];
    if(!ss.isEmpty()){
    	 if(ss.get(0).get("AUDIT_EVENT_TYPE_ID")!=null){
    		 list[0]=ss.get(0).get("AUDIT_EVENT_TYPE_ID").toString();}
    	 if(ss.get(0).get("AUDTI_DATA")!=null){
    		 list[1]=ss.get(0).get("AUDTI_DATA").toString();
    	 }
    }
    return list; 
	
	
}

public String getAuditType_New(String auditType) {

    jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    return jdbcTemplate.queryForObject("Select AUDTI_DATA from BG_BUSINESS_TR_AUDITEVENT_TYPE where AUDIT_EVENT_TYPE  = '" + auditType + "'", String.class);
    }

}

	

