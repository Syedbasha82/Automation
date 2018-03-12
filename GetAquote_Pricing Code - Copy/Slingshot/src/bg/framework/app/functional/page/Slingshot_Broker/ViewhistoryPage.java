package bg.framework.app.functional.page.Slingshot_Broker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import bg.framework.app.functional.util.RobotSendKeys;

import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.common.SlingshotErrorMessages;
import bg.framework.app.functional.util.PropertyLoader;

public class ViewhistoryPage extends BasePage {
	
	private final static String FILE_NAME = "resources/Slightshot_Broker/Viewhistory.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	SlingshotErrorMessages errormsg = new SlingshotErrorMessages();
	public static final String TIMESTAMP_FORMATTER= "dd MMMM, yyyy";	
	DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
    Calendar cal=Calendar.getInstance();
    String functionResult;
    
    public void viewhistory()
    {
    	verifyAndClickWithXpath(pageProperties.getProperty("ViewhistoryPage.Viewhistory"), "View history");
    	verifyPageTitle("view history");
    }
    public void quotestab()
    {
    	verifyAndClickWithXpath(pageProperties.getProperty("ViewhistoryPage.Quotestab"), "Quotes");
    }
    public void tenderstab()
    {
    	verifyAndClickWithXpath(pageProperties.getProperty("ViewhistoryPage.tendertab"), "Quotes");
    }
    public void queriestab()
    {
    	verifyAndClickWithXpath(pageProperties.getProperty("ViewhistoryPage.queriestab"), "queries");
    }
    public void breamcrumblinkNavigation()
    {
    	verifyAndClickWithXpath(pageProperties.getProperty("ViewhistoryPage.homebreadcrumblink"), "Home");
    	browser.browserBack();
    }
    
    public void quotesLHNlink()
    {
    	verifyAndClickWithXpath(pageProperties.getProperty("ViewhistoryPage.QuotesLHNlink"), "Quotes");
    }
    public void tenderLHNlink()
    {
    	verifyAndClickWithXpath(pageProperties.getProperty("ViewhistoryPage.tenderLHNlink"), "tender");
    }
    public void queriesLHNlink()
    {
    	verifyAndClickWithXpath(pageProperties.getProperty("ViewhistoryPage.queriesLHNlink"), "queries");
    }
    public void reportsLHNlink()
    {
    	verifyAndClickWithXpath(pageProperties.getProperty("ViewhistoryPage.reportsLHNlink"), "reports");
    }
    public void documentsLHNlink()
    {
    	verifyAndClickWithXpath(pageProperties.getProperty("ViewhistoryPage.documentsLHNlink"), "documents");
    }
    public void logout()
    {
    	verifyAndClickWithXpath(pageProperties.getProperty("ViewhistoryPage.logout"), "logout");
    }
    public void createnewquote()
    {
    	verifyAndClickWithXpath(pageProperties.getProperty("ViewhistoryPage.createnewquote"), "create new quote");
    }
    public void createnewtender()
    {
    	verifyAndClickWithXpath(pageProperties.getProperty("ViewhistoryPage.createnewquote"), "create new tender");
    }
    public void createnewqueries()
    {
    	verifyAndClickWithXpath(pageProperties.getProperty("ViewhistoryPage.createnewquote"), "create new queries");
    }
  
    
    public void quotestab_navigation()
    {
    	tenderLHNlink();
    	browser.browserBack();    	
    	queriesLHNlink();
    	browser.browserBack();
    	reportsLHNlink();
    	browser.browserBack();
    	documentsLHNlink();
    	browser.browserBack();
    	breamcrumblinkNavigation();
    	browser.browserBack();
    	logout();
    }
    public void tenderstab_navigation()
    {
    	quotesLHNlink();   
    	browser.browserBack(); 
    	queriesLHNlink();
    	browser.browserBack(); 
    	reportsLHNlink();
    	browser.browserBack(); 
    	documentsLHNlink();
    	browser.browserBack(); 
    	breamcrumblinkNavigation();
    	browser.browserBack();
    	logout();
    }
    public void queriestab_navigation()
    {
    	quotesLHNlink();  
    	browser.browserBack(); 
    	queriesLHNlink();
    	browser.browserBack(); 
    	reportsLHNlink();
    	browser.browserBack(); 
    	browser.browserBack(); 
    	documentsLHNlink();
    	browser.browserBack(); 
    	breamcrumblinkNavigation();
    	browser.browserBack();
    	logout();
    }
    
    public void noquotes()
    {
    	verifyIsTextPresent("No quotes have been created");
    
    }
    public void notenders()
    {
    	verifyIsTextPresent("No tenders have been created");
    }
    public void noqueries()
    {
    	verifyIsTextPresent("No queries have been created");
    }
    public void subpartnerhistorylandipage()
    {
    	verifyAndClickWithXpath(pageProperties.getProperty("ViewhistoryPage.subpartnerhistorylandingpage"), "Subpartner history landing page");
    	verifyPageTitle("");
    }
    public void backtoviewhistory()
    {
     	verifyAndClickWithXpath(pageProperties.getProperty("ViewhistoryPage.subpartner_backtoviewhistory"), "back to view history");
     	verifyPageTitle("");
    }
    public void breadcrumbsubpartnerhistory()
    {
    	verifyAndClickWithXpath(pageProperties.getProperty("ViewhistoryPage.subpartner_viewhistorybreadcrumb"), "view history");
    	browser.browserBack();
    	verifyAndClickWithXpath(pageProperties.getProperty("ViewhistoryPage.subpartner_homebreadcrumb"), "Home");
    	browser.browserBack();
    }
    public void homebreadcrumb()
    {
    	verifyAndClickWithXpath(pageProperties.getProperty("ViewhistoryPage.subpartner_homebreadcrumb"), "Home");
    	browser.browserBack();
    }
    
    public void findSubpartner(){
    	
    	String searchtext="searchtext1";    	
    	String searchtext1="searchtext2";    
    	verifyAndInputByXpath(pageProperties.getProperty("SubmitMeterReadPage.findsubpartner_searchtext"), "Search text", searchtext);
    	verifyAndClickWithXpath(pageProperties.getProperty("ViewhistoryPage.findsubpartner_find"), "find");
    	verifyIsTextPresent("No matching records found");
    	verifyAndInputByXpath(pageProperties.getProperty("SubmitMeterReadPage.findsubpartner_searchtext"), "Search text", searchtext1);
    	verifyAndClickWithXpath(pageProperties.getProperty("ViewhistoryPage.findsubpartner_find"), "find");
    	verifyIsTextPresent("abc");   	
    	
    }
    public void backtosubpartnerhistory()
    {
    	verifyAndClickWithXpath(pageProperties.getProperty("ViewhistoryPage.backtosubpartnerhistory"), "back to subpartnerhistory");
    }
    public void subpartnerdetailslandingpage()
    {
    	verifyAndInputByXpath(pageProperties.getProperty("SubmitMeterReadPage.findsubpartner_searchtext"), "Search text", " ");
    	verifyAndClickWithXpath(pageProperties.getProperty("ViewhistoryPage.findsubpartner_find"), "find");
    	verifyIsTextPresent("abc");
    	verifyAndClickWithXpath(pageProperties.getProperty("ViewhistoryPage.findsubpartner_Selectthefindlink"), "find");
    	
    }
    
    public void test12()
    {
    			//browser.open("https://10.224.70.44/");
    			//browser.test1();  	
    }
    
    
}
