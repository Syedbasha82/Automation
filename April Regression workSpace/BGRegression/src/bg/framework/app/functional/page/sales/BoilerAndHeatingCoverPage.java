package bg.framework.app.functional.page.sales;

import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;

import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: !jithendb
 * Date: 27/02/12
 * Time: 10:25
 * To change this template use File | Settings | File Templates.
 */
public class BoilerAndHeatingCoverPage extends BasePage {
    private final static String FILE_NAME = "resources/sales/BoilerAndHeatingCoverPage.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();

    public void navigateToGetAnInsuranceQuotePage() {
        verifyAndClickWithLinkText(pageProperties.getProperty("BoilerAndHeatingCover.HomeCare400ByXPath"), "Get A Quote");
    }
}
