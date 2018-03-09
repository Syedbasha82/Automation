package bg.framework.app.functional.action.sales;

import bg.framework.app.functional.page.sales.OnlinePriceFreezeJune2013TariffPage;

/**
 * Created by IntelliJ IDEA.
 * User: !boobalas
 * Date: 31/01/12
 * Time: 11:51
 * To change this template use File | Settings | File Templates.
 */
public class OnlinePriceFreezeJune2013TariffAction {

    public void OnlinePriceFreezeJune2013PF() {
        OnlinePriceFreezeJune2013TariffPage onlinePriceFreezeJune2013PF = new OnlinePriceFreezeJune2013TariffPage();
        onlinePriceFreezeJune2013PF.fillTariffDetails();
    }

    public OurTariffAction navigateToOurTariffPage() {
        OnlinePriceFreezeJune2013TariffPage azTariffPage = new OnlinePriceFreezeJune2013TariffPage();
        azTariffPage.navigateToOurTariffPage();
        return new OurTariffAction();
    }
}
