package bg.framework.app.functional.action.sales;

import bg.framework.app.functional.page.sales.AZTariffPage;

/**
 * Created by IntelliJ IDEA.
 * User: !jithendb
 * Date: 12/01/12
 * Time: 02:26
 * To change this template use File | Settings | File Templates.
 */
public class AZTariffAction {
    public AZTariffAction VerifyAZTariffPage() {
        AZTariffPage azTariffPage = new AZTariffPage();
        azTariffPage.fillTariffDetails();
        return this;
    }

    public OurTariffAction navigateToOurTariffPage() {
        AZTariffPage azTariffPage = new AZTariffPage();
        azTariffPage.navigateToOurTariffPage();
        return new OurTariffAction();
    }
}
