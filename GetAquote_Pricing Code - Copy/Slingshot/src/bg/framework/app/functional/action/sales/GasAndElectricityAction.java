package bg.framework.app.functional.action.sales;

import bg.framework.app.functional.page.sales.EnergySmartTariffPage;
import bg.framework.app.functional.page.sales.GasAndElectricityPage;

/**
 * Created by IntelliJ IDEA.
 * User: !jithendb
 * Date: 25/01/12
 * Time: 16:47
 * To change this template use File | Settings | File Templates.
 */
public class GasAndElectricityAction {
    public OurTariffAction navigateToOurTariffsPage() {
        GasAndElectricityPage gasAndElectricityPage = new GasAndElectricityPage();
        gasAndElectricityPage.navigateToOurTariffsPage();
        return new OurTariffAction();
    }

    
    public OurTariffAction navigateTariffsPage() {
        GasAndElectricityPage gasAndElectricityPage = new GasAndElectricityPage();
        gasAndElectricityPage.navigateToOurTariffsFromCrossellPage();
        return new OurTariffAction();
    }

    public EnergySmartTariffAction navigateToEnergySmartPage() {
        EnergySmartTariffPage energySmartTariffPage = new EnergySmartTariffPage();
        energySmartTariffPage.navigateToAnonyEnergySmartPage();
        return new EnergySmartTariffAction();
    }
    public GetAPriceAction navigateToGetAPricePage(){
        GasAndElectricityPage gasAndElectricityPage = new GasAndElectricityPage();
        gasAndElectricityPage.navigateToEnergyGetAPricePage();
        return new GetAPriceAction();
    }
}
