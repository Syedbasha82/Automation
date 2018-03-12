package bg.framework.app.functional.action.sales;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.page.sales.ProductsAndServicesPage;

/**
 * Created by IntelliJ IDEA.
 * User: !jithendb
 * Date: 25/01/12
 * Time: 15:55
 * To change this template use File | Settings | File Templates.
 */
public class ProductAndServicesAction {
    public OurTariffAction navigateToOurTariffsPage() {
        ProductsAndServicesPage productsAndServicesPage = new ProductsAndServicesPage();
        productsAndServicesPage.navigateToGasAndElectricityPage();
        return new OurTariffAction();
    }

    public GasAndElectricityAction navigateToGasAndElectricityPage() {
        ProductsAndServicesPage productsAndServicesPage = new ProductsAndServicesPage();
        productsAndServicesPage.navigateToGasAndElectricityPage();
        return new GasAndElectricityAction();
    }

    public HomePageAction navigateBackToHomePage() {
        ProductsAndServicesPage productsAndServicesPage = new ProductsAndServicesPage();
        productsAndServicesPage.navigateBackToHomePage();
        return new HomePageAction();
    }
}
