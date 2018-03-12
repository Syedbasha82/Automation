package bg.framework.app.functional.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.pool.OracleDataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.CRMExecutionDataProfile;
import bg.framework.app.functional.entities.SiebelExecutionDataProfile;
import bg.framework.app.functional.entities.UserProfile;

import com.sun.rowset.CachedRowSetImpl;

public class SiebelDataBase {

    // private static OracleDataSource dataSource;
    protected Properties siebelInfo = new PropertyLoader(
            "resources/common/siebelInformation.properties").load();
    private static String connectionString = "jdbc:oracle:thin:@HOST:PORT:DBNAME";
    private static String userName;
    private static String password;
    private OracleDataSource dataSource;
    private String siebelEnv;
    private static String[] SiebelDataXml = new String[2000];
    private static String DayofTheYear, UCRN, HomeNumber, PostCode, TelephoneNumber, TelephoneType, Title, FirstName, LastName;
    public enum siebelEnvironments {
        JSD_53, JSD_61,JSD_03, JSD_36, JSD_100, JSD_76, JSD_22, JSD_05, JSD_08, JSD_28, JSD_52, JSD_20, JSD_35, JSD_74, JSD_12, JSD_06, JSD_68,JSD_ETE16, JSD_99, JSD_ETE07, JSD_ETE05, JSD_ETE03, JSD_PPROD2
    }

    /**
     * @param Env Connects to the Siebel Environment based on the the
     *            {@link siebelEnvironments} provided. The Environment has to be
     *            configured in test.dev.properties/common.properties file with
     *            the property as "siebel.environment" this param is case
     *            insensitive.
     */
    public SiebelDataBase(String Env) {
        siebelEnv = Env;
        updateConnectionString();
        updateJDBCString();

    }

    public SiebelDataBase() {
        siebelEnv = ApplicationConfig.SIEBEL_ENVIRONMENT;
        updateConnectionString();
        updateJDBCString();
    }

    private OracleDataSource updateJDBCString() {
        siebelEnv = siebelEnv.trim().toUpperCase();
        siebelEnvironments siebelValue;
        if (siebelEnv.contains(" "))
            siebelEnv = siebelEnv.replace(" ", "_");
        siebelValue = siebelEnvironments.valueOf(siebelEnv);

        if (dataSource != null) {
            return dataSource;
        }
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            dataSource = new OracleDataSource();
            dataSource.setURL("jdbc:oracle:thin:@"
                    + siebelInfo.getProperty(siebelValue + ".host") + ":"
                    + siebelInfo.getProperty(siebelValue + ".port") + ":"
                    + siebelInfo.getProperty(siebelValue + ".database"));
            dataSource.setUser(siebelInfo.getProperty(siebelValue + ".username"));
            dataSource.setPassword(siebelInfo.getProperty(siebelValue + ".password"));
            return dataSource;
        } catch (Exception e) {
            System.err.println("ERROR: failed to load JDBC driver.");
            e.printStackTrace();
        }
        return null;

    }

    private void updateConnectionString() {
        siebelEnv = siebelEnv.trim().toUpperCase();
        siebelEnvironments siebelValue;
        if (siebelEnv.contains(" "))
            siebelEnv = siebelEnv.replace(" ", "_");
        siebelValue = siebelEnvironments.valueOf(siebelEnv);

        connectionString = connectionString.replaceFirst("HOST",
                siebelInfo.getProperty(siebelValue + ".host"));
        connectionString = connectionString.replaceFirst("PORT",
                siebelInfo.getProperty(siebelValue + ".port"));
        connectionString = connectionString.replaceFirst("DBNAME",
                siebelInfo.getProperty(siebelValue + ".database"));
        userName = siebelInfo.getProperty(siebelValue + ".username");
        password = siebelInfo.getProperty(siebelValue + ".password");

    }

    private CachedRowSet executeQuery(String query) {
        CachedRowSet resultData = null;
        Connection conn;
        try {
            resultData = new CachedRowSetImpl();
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(connectionString, userName, password);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            resultData.populate(rs);

            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return resultData;

    }

    private int executeUpdateQuery(String query) {

        Connection conn = null;
        int updCount = 0;
        try {

            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(connectionString, userName, password);
            conn.setAutoCommit(true);
            Statement st = conn.createStatement();
            updCount = st.executeUpdate(query);

            st.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            Report.updateTestLog("Caught Exception: " + e.getMessage() + "\n For Query: "
                    + query, "FAIL");
        } finally {
            conn = null;

        }
        return updCount;

    }

    public String getLastName(String strUCRN) {
    	String strColname;
    	try{
    		String queryLastName = "Select X_LAST_NAME FROM S_CONTACT CON,S_PER_ORG_UNIT CONACC,"
                    + "S_ORG_EXT ACC  WHERE ACC.ROW_ID=CONACC.OU_ID AND CON.ROW_ID=CONACC.PER_ID AND "
                    + "x_ucrn_num='USERUCRN' and rownum=1";
            queryLastName = queryLastName.replace("USERUCRN", strUCRN);

            SimpleJdbcTemplate jdbcTemplate = new SimpleJdbcTemplate(updateJDBCString());
            strColname = (String) jdbcTemplate.queryForObject(queryLastName,
                    String.class);
    	}
    	catch(org.springframework.dao.EmptyResultDataAccessException e){
    		strColname = "";
    	}
        
    	LastName = strColname;
        return strColname;

    }

    public String getTitle(String strUCRN) {

        String queryTitle = "Select PER_TITLE FROM S_CONTACT CON,S_PER_ORG_UNIT CONACC,"
                + "S_ORG_EXT ACC  WHERE ACC.ROW_ID=CONACC.OU_ID AND CON.ROW_ID=CONACC.PER_ID AND "
                + "x_ucrn_num='USERUCRN' and rownum=1";
        queryTitle = queryTitle.replace("USERUCRN", strUCRN);
        System.out.println(queryTitle);
         String strColname= null;
        SimpleJdbcTemplate jdbcTemplate = new SimpleJdbcTemplate(updateJDBCString());
        try{
            strColname = (String) jdbcTemplate
                .queryForObject(queryTitle, String.class);}
        catch(EmptyResultDataAccessException e){
            Report.updateTestLog("Data not available in Siebel","FAIL");
            strColname = "Mr";
        }
        
        Title = strColname;
        return strColname;

    }

    public String getFirstName(String strUCRN) {
    	String strColname;
    	try
    	{
    		String queryFirstName = "Select X_FST_NAME FROM S_CONTACT CON,S_PER_ORG_UNIT CONACC,"
                    + "S_ORG_EXT ACC  WHERE ACC.ROW_ID=CONACC.OU_ID AND CON.ROW_ID=CONACC.PER_ID AND "
                    + "x_ucrn_num='USERUCRN' and rownum=1";
            queryFirstName = queryFirstName.replace("USERUCRN", strUCRN);
            SimpleJdbcTemplate jdbcTemplate2 = new SimpleJdbcTemplate(updateJDBCString());
             strColname = (String) jdbcTemplate2.queryForObject(queryFirstName,
                    String.class);
            return strColname;
    	}
    	catch(org.springframework.dao.EmptyResultDataAccessException e){
    		strColname = "";
    	}
    	
    	FirstName = strColname;
    	return strColname;
    }

    public String getAccountNumber(String strUCRN) {
        String qryfetchUCRN = "SELECT  DISTINCT soe.ou_num  FROM s_contact con,s_per_org_unit spou,"
                + "s_org_ext soe,s_quote_soln sqs WHERE con.row_id = spou.per_id AND spou.ou_id =  soe.row_id "
                + "AND soe.row_id = sqs.inv_accnt_id  AND con.fst_name='USERUCRN'";
        qryfetchUCRN = qryfetchUCRN.replace("USERUCRN", strUCRN);
        SiebelDataBase siebelHandle = new SiebelDataBase(siebelEnv);
        ResultSet rs = siebelHandle.executeQuery(qryfetchUCRN);
        String retVal = null;
        try {
            if (rs.next())
                retVal = rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
            Report.updateTestLog("Caught Exception: " + e.getMessage() + "\n For Query: "
                    + qryfetchUCRN, "FAIL");

        }
        
        return retVal;
    }

    
    
       
    
    public int setBrandSainsbury(String AccountNumber) {
        String bnameQuery = "update  s_org_ext set x_white_label = 'Sainsburys Energy' where ou_num = '" + AccountNumber + "'";
        return (executeUpdateQuery(bnameQuery));
    }

    public int setBrandBritishGas(String AccountNumber) {
        String bnameQuery = "update  s_org_ext set x_white_label = 'British Gas' where ou_num = '" + AccountNumber + "'";
        return (executeUpdateQuery(bnameQuery));
    }

    public int setResponsibilityType(String AccountNumber,String resptype) {

        String resType = "update S_PER_ORG_UNIT set X_RESP_TYPE='"+resptype+"' where OU_ID=(select ROW_ID "
                + " from S_ORG_EXT where ou_num ='" + AccountNumber + "')";
        return executeUpdateQuery(resType);
    }

    public int setAccountStatus(String strAcctNum, int period) {

        String acctStatus = "";
        if (period >= 0)
            acctStatus = "Active";
        else if (period < 0)
            acctStatus = "Inactive";
        String strMakeActiveQry = "UPDATE s_quote_soln SET status_cd ='"
                + acctStatus
                + "',end_dt = to_char(add_months(sysdate,"
                + period
                + "),'dd-mon-yyyy')"
                + " WHERE inv_accnt_id=(SELECT DISTINCT sqs.inv_accnt_id FROM s_contact sc, s_per_org_unit spou, s_org_ext soe, "
                + "s_quote_soln sqs WHERE sc.row_id = spou.per_id AND spou.ou_id =  soe.row_id AND soe.row_id = sqs.inv_accnt_id "
                + "AND soe.OU_NUM ='" + "USERACCTNUMBER" + "')";
        strMakeActiveQry = strMakeActiveQry.replace("USERACCTNUMBER", strAcctNum);

        return executeUpdateQuery(strMakeActiveQry);

    }

    public int setStatus(String acctNumber, int period, String status) {
        String strMakeActiveQry = "UPDATE s_quote_soln SET status_cd ='"
                + status
                + "',end_dt = to_char(add_months(sysdate,"
                + period
                + "),'dd-mon-yyyy')"
                + " WHERE inv_accnt_id=(SELECT DISTINCT sqs.inv_accnt_id FROM s_contact sc, s_per_org_unit spou, s_org_ext soe, "
                + "s_quote_soln sqs WHERE sc.row_id = spou.per_id AND spou.ou_id =  soe.row_id AND soe.row_id = sqs.inv_accnt_id "
                + "AND soe.OU_NUM ='" + "USERACCTNUMBER" + "')";
        strMakeActiveQry = strMakeActiveQry.replace("USERACCTNUMBER", acctNumber);
        System.out.println("Update MakeActive Query: " + strMakeActiveQry);
        return executeUpdateQuery(strMakeActiveQry);
    }

    public List<String> getAddress(String accnum) {
        String query = "SELECT T8.X_HOUSE_NO,T8.ADDR_NUM,T8.ADDR,T8.CITY,T8.ZIPCODE FROM SIEBEL.S_EMPLOYEE T1, "
                + "SIEBEL.S_ORG_EXT T2,SIEBEL.S_ACCNT_POSTN T3,SIEBEL.S_CON_ADDR T4,SIEBEL.S_ORG_INT T5,SIEBEL.S_POSTN T6,SIEBEL.S_CONTACT T7, "
                + "SIEBEL.S_ADDR_PER T8,SIEBEL.S_ADDR_PER T9,SIEBEL.S_INDUST T10,SIEBEL.S_PER_ORG_UNIT T11,SIEBEL.S_PRI_LST T12, "
                + "SIEBEL.S_DOC_AGREE T13,SIEBEL.S_PER_ORG_UNIT T14,SIEBEL.S_ORG_EXT T15 WHERE T15.BU_ID = T5.ROW_ID (+) AND "
                + "T15.PAR_OU_ID = T2.ROW_ID (+) AND T15.CURR_PRI_LST_ID = T12.ROW_ID (+) AND T15.PR_INDUST_ID = T10.ROW_ID (+)"
                + "AND T15.PR_ADDR_ID = T9.ROW_ID (+) AND T15.PR_BL_ADDR_ID = T8.ROW_ID (+) AND T15.PR_BL_ADDR_ID = T4.ADDR_PER_ID (+) AND "
                + "T15.ROW_ID = T4.ACCNT_ID (+) AND T15.PR_SRV_AGREE_ID = T13.ROW_ID (+) AND T15.PR_CON_ID = T7.ROW_ID (+) AND T15.PR_CON_ID = "
                + "T14.PER_ID (+) AND T15.ROW_ID = T14.OU_ID (+) AND T15.PR_POSTN_ID = T6.ROW_ID AND T15.PR_POSTN_ID = T3.POSITION_ID AND T15.ROW_ID = "
                + "T3.OU_EXT_ID AND T6.PR_EMP_ID = T1.ROW_ID (+) AND T11.OU_ID = T15.ROW_ID AND T15.OU_NUM = '" + accnum + "'";
       
      
        ResultSet rs = executeQuery(query);
        List<String> address = new ArrayList<String>();
        try {
        	
        System.out.println(query);
                System.out.println(ApplicationConfig.SIEBEL_ENVIRONMENT);
            while (rs.next()) {
                address.add(rs.getString(1));
                address.add(rs.getString(2));
                address.add(rs.getString(3));
                address.add(rs.getString(4));
                address.add(rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(address);
        if (address.isEmpty()){
            Report.updateTestLog("Customer address not found in Siebel", "FAIL");
        }
        return address;
    }

   
    public String getTelephoneType(String ucrn) {
        String query = "Select s_contact_xm.attrib_38 from s_contact_xm, s_contact where s_contact.x_pri_tel = s_contact_xm.row_id and x_ucrn_num = '" + ucrn + "'";
        //SiebelDataBase siebelHandle = new SiebelDataBase(siebelEnv);
        ResultSet rs = executeQuery(query);
        String retVal = null;
       
        try {
        	
            if (rs.next())
                retVal = rs.getString(1);
            else
                retVal="Home Telephone";
        } catch (SQLException e) {
            return "Home Telephone";
        }
        
        TelephoneType = retVal;
        return retVal;
    }

    public String getTelephoneNumber(String ucrn) {
        String query = "Select s_contact_xm.attrib_34 from s_contact_xm, s_contact where s_contact.x_pri_tel = s_contact_xm.row_id and x_ucrn_num = '" + ucrn + "'";
        System.out.println("ENVIRON"+siebelEnv);
        SiebelDataBase siebelHandle = new SiebelDataBase(siebelEnv);
        ResultSet rs = siebelHandle.executeQuery(query);
        String retVal = null;
        try {
//        	 System.out.println(rs.getString(1));
            if (rs.next())            	
                retVal = rs.getString(1);
            else
                retVal = "01234567890";
        } catch (SQLException e) {
            return "01234567890";
        }
        
        TelephoneNumber = retVal;
        return retVal;
    }
    public static void main(String a[]){
    	SiebelDataBase siebelHandle = new SiebelDataBase("JSD_ETE16");
    	String postcodeQry="Select Zipcode from s_addr_per where row_id in (select sqs.addr_id from s_quote_soln sqs , s_org_ext soe , s_per_org_unit spou, s_contact con" +
    			 " where con.row_id = spou.per_id and spou.ou_id = soe.row_id and soe.ROW_ID = sqs.INV_ACCNT_ID and soe.ou_num = '850027136914')";
    	ResultSet rs = siebelHandle.executeQuery(postcodeQry);
    	try {
    		//System.out.println("FIRST"+rs.getString(1));
			if(rs.next()){
				 System.out.println("INSIDE IF"+rs.getString(1));
						
			}else{
				System.out.println("ELSE");
			}
		} catch (SQLException e) {
			
			System.out.println("547869686");
		}
    }
    
    public String getPostCode(String accountNo) {
        String qryfetchUCRN = "Select Zipcode from s_addr_per where row_id in (select sqs.addr_id from s_quote_soln sqs , s_org_ext soe , s_per_org_unit spou, s_contact con "
        		+"where con.row_id = spou.per_id and spou.ou_id = soe.row_id and soe.ROW_ID = sqs.INV_ACCNT_ID and soe.ou_num = '"+accountNo+"')";
        SiebelDataBase siebelHandle = new SiebelDataBase(siebelEnv);
        ResultSet rs = siebelHandle.executeQuery(qryfetchUCRN);
        String retVal = null;
        try {
            if (rs.next())
                retVal = rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
            Report.updateTestLog("Caught Exception: " + e.getMessage() + "\n For Query: "
                    + qryfetchUCRN, "FAIL");

        }
        
        PostCode = retVal;
        return retVal;
    }

    public String getEmailAddress(String ucrn) {
        
    	String query = "Select SIEBEL.S_CONTACT_XM.ATTRIB_01 from S_CONTACT_XM SIEBEL where x_ucrn_num = '" + ucrn + "'";
        SiebelDataBase siebelHandle = new SiebelDataBase(siebelEnv);
        ResultSet rs = siebelHandle.executeQuery(query);
        String retVal = null;
        try {
            if (rs.next())
                retVal = rs.getString(1);
            else
                retVal = "";
        } catch (SQLException e) {
            return "";
        }
        
        return retVal;
    }
    
    public boolean executeSiebel(UserProfile userProfile){
    	 String TimeStamp="";
    	 boolean SiebelExecute;
		 SiebelExecutionDataProfile SiebelExecutionData = new TestDataHelper().getSiebelExecutionDataProfile(userProfile.getUCRN());
		 TimeStamp = Calendar.getInstance().toString();
		 DayofTheYear = TimeStamp.substring(TimeStamp.indexOf("DAY_OF_YEAR"), TimeStamp.indexOf(",DAY_OF_WEEK")).replace("DAY_OF_YEAR=", "");
		 UCRN = userProfile.getUCRN();
		 try{
			 if(UCRN.equalsIgnoreCase(SiebelExecutionData.getUCRN()) && DayofTheYear.equalsIgnoreCase(SiebelExecutionData.getDayofTheYear())){
				 SiebelExecute = false;
			 }
			 else
			 {
				 SiebelExecute = true;
			 }
		 }
		 catch(java.lang.NullPointerException NullException){
			 SiebelExecute = true;
		 }
		 
		 return SiebelExecute;
    }
    
    public void updateSiebelExecutionData(UserProfile userProfile) throws IOException{
    	String LogPath = System.getProperty("user.dir");
		String[] UserData = new String[20];
		String temp="";
		int i = 1, UserDataCount= 0, UserDetailLocation = 0,j=1;
		boolean UserDetailPresent = false, UserDetailSetFlag = false;
		UserData[1] = "<entry>";
		UserData[2] = "<string>"+userProfile.getUCRN()+"</string>";
		UserData[3] = "<SiebelExecutionDataProfile>";
		UserData[4] = "<ucrn>"+userProfile.getUCRN()+"</ucrn>";
		UserData[5] = "<dayoftheyear>"+DayofTheYear+"</dayoftheyear>";
		UserData[6] = "<title>"+Title+"</title>";
		UserData[7] = "<firtsname>"+FirstName+"</firtsname>";
		UserData[8] = "<lastname>"+LastName+"</lastname>";
		UserData[9] = "<homenumber></homenumber>";
		UserData[10] = "<postcode>"+PostCode+"</postcode>";
		UserData[11] = "<phonenumber>"+TelephoneNumber+"</phonenumber>";
		UserData[12] = "<phonetype>"+TelephoneType+"</phonetype>";
		UserData[13] = "</SiebelExecutionDataProfile>";
		UserData[14] = "</entry>";
		
		BufferedReader reader = new BufferedReader(new FileReader(LogPath+"\\src\\resources\\TestData\\bgr\\SiebelExecutionData.xml"));
		
		//Reading Data From XML file
		while(reader.read() != -1){
			temp = reader.readLine();
			if(!temp.contains("map")){
				SiebelDataXml[i] = "<"+temp;
				i++;
			}
			
		}
		UserDataCount = i-1;
		reader.close();
		
		
		//Flush out Expired Data
		for(i = 1; i<= (UserDataCount); i++){
			if(SiebelDataXml[i].contains("<title>")){
				if((!SiebelDataXml[i-1].contains(DayofTheYear))){
					flushExpired(i);
				}
			}
		}
		
		
		// Replace the Current User Data in the place of expired data
		for(i = 1; i <= UserDataCount;i++){
			if(SiebelDataXml[i] == ""){
				if(j<15){
					SiebelDataXml[i]= UserData[j];
					UserDetailSetFlag = true;
					j++;
				}
				
			}
		}
		
		
		// Replace the CurrentData with userdata when the store limit exceeds
		if(UserDetailSetFlag == false && UserDataCount >1800){
			for(i=1;i<17;i++){
				SiebelDataXml[i]= UserData[i];
				UserDetailSetFlag = true;
			}
		}
		
		// Appends the user data
		if(UserDetailSetFlag == false && UserDataCount < 1800){
			j=1;
			for(i=UserDataCount+1;i<=UserDataCount+16;i++){
				SiebelDataXml[i]= UserData[j];
				UserDetailSetFlag = true;
				j++;
			}
		}
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(LogPath+"\\src\\resources\\TestData\\bgr\\SiebelExecutionData.xml"));
		writer.append("<map>");
		writer.newLine();
		for(i=1; i<=1800;i++){
			if(SiebelDataXml[i] != "" && SiebelDataXml[i] != null){
				writer.append(SiebelDataXml[i]);
				writer.newLine();
			}
		}
		writer.append("</map>");
		writer.close();
		
	}
	
	public void flushExpired(int titleLocation){
		for(int i =titleLocation - 5;i <=(titleLocation+8);i++){
			SiebelDataXml[i] = "";
		}
    }
    
}
