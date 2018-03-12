package bg.framework.common.functional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;


public class WebDriverFactory {

	public enum browserType {
		iehta, firefox, chrome, headless, safari
	}
	
	public WebDriver getDriver(browserType browsertype) {
//		 File profileDir = new
//		 File("C://Documents and Settings/!jithendb/Application Data/Mozilla/Firefox/Profiles/pvdnt82r.default");
		// File profileDir = new
		// File("C://Documents and Settings/!jithendb/Application Data/Mozilla/Firefox/Profiles/yjgv0yt2.default");

		FirefoxProfile ffProfile = new ProfilesIni().getProfile("default");
		//ffProfile.setAcceptUntrustedCertificates(true);
		ffProfile.setAcceptUntrustedCertificates(false);
		//File ff = new File("C:\\Users\\531644\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		//FirefoxBinary firefoxBinary = new FirefoxBinary(ff);
		//FirefoxProfile firefoxProfile = new FirefoxProfile();
		
		switch (browsertype) {
		case iehta:
            DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
            ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			return new InternetExplorerDriver(ieCapabilities);
		case firefox:
			return new FirefoxDriver(ffProfile);
		case chrome:
            System.setProperty("webdriver.chrome.driver", "D://chrome Driver/chromedriver.exe");
			return new ChromeDriver();
		case headless:
			HtmlUnitDriver driver = new HtmlUnitDriver();
			driver.setJavascriptEnabled(true);
			return driver;
		default:
			return null;
			//return new FirefoxDriver(ffProfile);
		}

	}
}
