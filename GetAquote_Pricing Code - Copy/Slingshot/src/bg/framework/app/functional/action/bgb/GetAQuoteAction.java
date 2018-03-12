package bg.framework.app.functional.action.bgb;

import java.io.FileNotFoundException;

import bg.framework.app.functional.entities.GetAQuoteDetails;
import bg.framework.app.functional.page.bgb.GaqQuotePage;
import bg.framework.app.functional.page.bgb.GetaQuoteBusinessPage;
import bg.framework.app.functional.page.bgb.GetaQuoteDetailsPage;

public class GetAQuoteAction {

    static String strRefNo = null;

    public GetAQuoteAction(String strRefNo) {
        GetAQuoteAction.strRefNo = strRefNo;
    }

    public GetAQuoteAction() {

    }

   public GetaQuoteDetailsPage clickCombinedEnergyLink() {
       GetaQuoteBusinessPage gaqbusinesspage = new GetaQuoteBusinessPage();
       gaqbusinesspage.getaquoteClickElecquoteLink();
       return new GetaQuoteDetailsPage();
   }

    public GetaQuoteDetailsPage clickElecquoteLink() {
        GetaQuoteBusinessPage gaqbusinesspage = new GetaQuoteBusinessPage();
        gaqbusinesspage.getaquoteClickElecquoteLink();
        return new GetaQuoteDetailsPage();
    }

    public GetaQuoteDetailsPage clickGasquoteLink() {
        GetaQuoteBusinessPage gaqbusinesspage = new GetaQuoteBusinessPage();
        gaqbusinesspage.getaquoteClickGasquoteLink();
        return new GetaQuoteDetailsPage();
    }

    public GetaQuoteDetailsPage clickDualquoteLink() {
        GetaQuoteBusinessPage gaqbusinesspage = new GetaQuoteBusinessPage();
        gaqbusinesspage.getaquoteClickDualquoteLink();
        return new GetaQuoteDetailsPage();
    }
	
    public GetAQuoteAction elecSupplyDetailsYes(GetAQuoteDetails getDetails) {
        GetaQuoteDetailsPage ogetDetails = new GetaQuoteDetailsPage();
        ogetDetails.electricitySupplyDetailsClickRbYes(getDetails);
        return new GetAQuoteAction();
    }

    public GetAQuoteAction elecSupplyDetailsNo(GetAQuoteDetails getDetails) {
        GetaQuoteDetailsPage ogetDetails = new GetaQuoteDetailsPage();
        ogetDetails.electricitySupplyDetailsClickRbNo(getDetails);
        return new GetAQuoteAction();
    }

    public GetAQuoteAction gasSupplyDetailsYes(GetAQuoteDetails getDetails) {
        GetaQuoteDetailsPage ogetDetails = new GetaQuoteDetailsPage();
        ogetDetails.gasSupplyDetailsClickRbYes(getDetails);
        return new GetAQuoteAction();
    }

    public GetAQuoteAction dualGasSupplyDetailsYes(GetAQuoteDetails getDetails) {
        GetaQuoteDetailsPage ogetDetails = new GetaQuoteDetailsPage();
        ogetDetails.dualGasSupplyDetailsClickRbYes(getDetails);
        return new GetAQuoteAction();
    }

    public GetAQuoteAction gasSupplyDetailsNo(GetAQuoteDetails getDetails) {
        GetaQuoteDetailsPage ogetDetails = new GetaQuoteDetailsPage();
        ogetDetails.gasSupplyDetailsClickRbNo(getDetails);
        return new GetAQuoteAction();
    }

    public GetAQuoteAction dualGasSupplyDetailsNo(GetAQuoteDetails getDetails) {
        GetaQuoteDetailsPage ogetDetails = new GetaQuoteDetailsPage();
        ogetDetails.dualGasSupplyDetailsClickRbNo(getDetails);
        return new GetAQuoteAction();
    }

    public GetAQuoteAction retreiveElecQuotesUI() {
        GetaQuoteDetailsPage ogetDetails = new GetaQuoteDetailsPage();
        ogetDetails.retreiveElecQuotesUI();
        return new GetAQuoteAction();
    }

    public GetAQuoteAction retreiveElectricityQuotesUI() {
        GetaQuoteDetailsPage ogetDetails = new GetaQuoteDetailsPage();
        ogetDetails.retreiveElectricityQuotesUI();
        return new GetAQuoteAction();
    }

	public GetAQuoteAction gasunitpricefromdbMonthlyQuarter1Year(
			GetAQuoteDetails getDetails, String monthlyquarter, String Dual) {
		GaqQuotePage getAQuotePage = new GaqQuotePage();
		getAQuotePage.gasunitpricefromdb1Year(getDetails, monthlyquarter, Dual);
    	return new GetAQuoteAction();
    }

	public GetAQuoteAction gasunitpricefromdbMonthlyQuarter2Year(
			GetAQuoteDetails getDetails, String monthlyquarter, String Dual) {
		GaqQuotePage getAQuotePage = new GaqQuotePage();
		getAQuotePage.gasunitpricefromdb2Year(getDetails, monthlyquarter, Dual);
    	return new GetAQuoteAction();
    }

	public GetAQuoteAction gasunitpricefromdbMonthlyQuarter3Year(
			GetAQuoteDetails getDetails, String monthlyquarter, String Dual) {
		GaqQuotePage getAQuotePage = new GaqQuotePage();
		getAQuotePage.gasunitpricefromdb3Year(getDetails, monthlyquarter, Dual);
    	return new GetAQuoteAction();
    }

	public GetAQuoteAction clickQuaterlybutton2ndYearGas(
			GetAQuoteDetails getDetails) {
		GaqQuotePage getAQuotePage = new GaqQuotePage();
		getAQuotePage.clickQuaterlybutton2ndYearGas(getDetails);
    	return new GetAQuoteAction();
    }

	public GetAQuoteAction clickQuaterlybutton1stYearGas(
			GetAQuoteDetails getDetails) {
		GaqQuotePage getAQuotePage = new GaqQuotePage();
		getAQuotePage.clickQuaterlybutton1stYearGas(getDetails);
    	return new GetAQuoteAction();
    }

	public GetAQuoteAction clickQuaterlybutton3rdYearGas(
			GetAQuoteDetails getDetails) {
		GaqQuotePage getAQuotePage = new GaqQuotePage();
		getAQuotePage.clickQuaterlybutton3rdYearGas(getDetails);
    	return new GetAQuoteAction();
    }

	public GetAQuoteAction validateSecondYearContractMonthly(
			GetAQuoteDetails getDetails) {
		GaqQuotePage getAQuotePage = new GaqQuotePage();
    	getAQuotePage.validateSecondYearContractMonthly(getDetails);
    	return new GetAQuoteAction();
    }

	public GetAQuoteAction firstYearCalulationQuarterMonthlyAndNotch(
			GetAQuoteDetails getDetails, int i, String Year, String ele) {
		GaqQuotePage getAQuotePage = new GaqQuotePage();
		getAQuotePage.firstYearCalulationQuarterMonthlyAndNotch(getDetails, i,
				Year, ele);
    	return new GetAQuoteAction();
    }

	public GetAQuoteAction secondYearCalulationQuarterMonthlyAndNotch(
			GetAQuoteDetails getDetails, int i, String Year, String ele) {
		GaqQuotePage getAQuotePage = new GaqQuotePage();
		getAQuotePage.secondYearCalulationQuarterMonthlyAndNotch(getDetails, i,
				Year, ele);
    	return new GetAQuoteAction();
    }

	public GetAQuoteAction thirdYearCalulationQuarterMonthlyAndNotch(
			GetAQuoteDetails getDetails, int i, String Year, String ele) {
		GaqQuotePage getAQuotePage = new GaqQuotePage();
		getAQuotePage.thirdYearCalulationQuarterMonthlyAndNotch(getDetails, i,
				Year, ele);
    	return new GetAQuoteAction();
    }

	public GetAQuoteAction firstYearAddressCalMonthlyQuarter(
			GetAQuoteDetails getDetails, String FirstMonthlyQuarter, String ele) {
		GaqQuotePage getAQuotePage = new GaqQuotePage();
		getAQuotePage.firstYearAddressCalMonthlyQuarter(getDetails,
				FirstMonthlyQuarter, ele);
		return new GetAQuoteAction();
	}

	public GetAQuoteAction secondYearAddressCalMonthlyQuarter(
			GetAQuoteDetails getDetails, String FirstMonthlyQuarter, String ele) {
		GaqQuotePage getAQuotePage = new GaqQuotePage();
		getAQuotePage.secondYearAddressCalMonthlyQuarter(getDetails,
				FirstMonthlyQuarter, ele);
		return new GetAQuoteAction();
	}

	public GetAQuoteAction thirdYearAddressCalMonthlyQuarter(
			GetAQuoteDetails getDetails, String FirstMonthlyQuarter, String ele) {
		GaqQuotePage getAQuotePage = new GaqQuotePage();
		getAQuotePage.thirdYearAddressCalMonthlyQuarter(getDetails,
				FirstMonthlyQuarter, ele);
		return new GetAQuoteAction();
	}

	public GetAQuoteAction validateSecondYearContractQuarter(
			GetAQuoteDetails getDetails) {
		GaqQuotePage getAQuotePage = new GaqQuotePage();
    	getAQuotePage.validateSecondYearContractQuarter(getDetails);
    	return new GetAQuoteAction();
    }

    public GetAQuoteAction retreiveDualQuotesUI() {
        GetaQuoteDetailsPage ogetDetails = new GetaQuoteDetailsPage();
        ogetDetails.retreiveDualQuotesUI();
        return new GetAQuoteAction();
    }

    public GetAQuoteAction clickCalculateQuoteForElec() {
        GetaQuoteDetailsPage ogetDetails = new GetaQuoteDetailsPage();
        ogetDetails.calculateQuoteForElec();
        return new GetAQuoteAction();
    }

    public GetAQuoteAction clickCalculateQuoteForGas() {
        GetaQuoteDetailsPage ogetDetails = new GetaQuoteDetailsPage();
        ogetDetails.calculateQuoteForGasquote();
        return new GetAQuoteAction();
    }

    public GetAQuoteAction clickCalculateQuoteForDual() {
        GetaQuoteDetailsPage ogetDetails = new GetaQuoteDetailsPage();
        ogetDetails.calculateQuoteForDualquote();
        return new GetAQuoteAction();
    }

    public GetAQuoteAction verifyElecDBGaqrate(GetAQuoteDetails getDetails) {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.verifyElecGaqrate(getDetails);
        return this;
    }

	public GetAQuoteAction verifyElecQuotePageChargeRate(
			GetAQuoteDetails getDetails) {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.verifyElecQuotePageCharge(getDetails);
        return this;
    }

    public GetAQuoteAction verifyGasDBGaqrate(GetAQuoteDetails getDetails) {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.verifyGasGaqRate(getDetails);
        return this;
    }

    public GetAQuoteAction verifyGasQuotePageCharge(GetAQuoteDetails getDetails) {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.verifyGasQuotePageCharge(getDetails);
        return this;
    }

    public GetAQuoteAction selectElectricityPaymentOptionMonthly() {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.selectElectricityPaymentOptionMonthly();
        return this;
    }

    public GetAQuoteAction selectElectricityPaymentOptionQuaterly() {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.selectElectricityPaymentOptionQuaterly();
        return this;
    }

    public GetAQuoteAction selectElectricityPaymentOptionQuaterly2Year() {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.selectElectricityPaymentOptionQuaterly2Year();
        return this;
    }

    public GetAQuoteAction selectGasPaymentOptionMonthly() {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.selectGasPaymentOptionMonthly();
        return this;
    }

    public GetAQuoteAction selectGasPaymentOptionQuaterly() {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.selectGasPaymentOptionQuaterly();
        return this;
    }

    public GetAQuoteAction clickMonthlyQuotepageContinue() {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.clickMonthlyContinueQuotePage();
        return this;

    }

    public GetAQuoteAction clickQuaterlyQuotepageContinue() {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.clickQuaterlyContinueQuotePage();
        return this;

    }

   public GetAQuoteAction clickQuaterlyContinueQuotePage2ndYear() {
       GaqQuotePage ogaqQuotePage = new GaqQuotePage();
       ogaqQuotePage.clickQuaterlyContinueQuotePage2ndYear();
       return this;

   }

   public GetAQuoteAction clickQuaterlyContinueQuotePage3rdYear() {
       GaqQuotePage ogaqQuotePage = new GaqQuotePage();
       ogaqQuotePage.clickQuaterlyContinueQuotePage3rdYear();
       return this;

   }

	public GetAQuoteAction clickContinueQuotePage2ndYearGas() {
       GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		ogaqQuotePage.clickContinueQuotePage2ndYearGas();
       return this;

   }

	public GetAQuoteAction clickContinueQuotePage1stYearGas() {
       GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		ogaqQuotePage.clickContinueQuotePage1stYearGas();
       return this;

   }

   public GetAQuoteAction click3rdYearTab() {
       GaqQuotePage ogaqQuotePage = new GaqQuotePage();
       ogaqQuotePage.click3rdYearTab();
       return this;
  }

   public GetAQuoteAction clickcompareallTab() {
       GaqQuotePage ogaqQuotePage = new GaqQuotePage();
       ogaqQuotePage.clickcompareallTab();
       return this;
  }

	public GetAQuoteAction click2ndYearTab() {
       GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		ogaqQuotePage.click2ndYearTabGas();
       return this;
  }

	public GetAQuoteAction click1stYearTabGas() {
       GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		ogaqQuotePage.click1stYearTabGas();
       return this;
  }

	public GetAQuoteAction click3rdYearTabGas() {
       GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		ogaqQuotePage.click3rdYearTabGas();
       return this;
  }

   public GetAQuoteAction clickQuaterlybutton3rdYear() {
       GaqQuotePage ogaqQuotePage = new GaqQuotePage();
       ogaqQuotePage.clickQuaterlybutton3rdYear();
       return this;

   }

	public GetAQuoteAction clickMonthlybuttonCompareAllTab() {
       GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		ogaqQuotePage.clickMonthlybuttonCompareAllTab();
       return this;

   }

	public GetAQuoteAction clickQuaterlybuttonCompareAllTab() {
       GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		ogaqQuotePage.clickQuaterlybuttonCompareAllTab();
       return this;

   }

	public GetAQuoteAction compareAllEleRatesMonthly() {
       GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		ogaqQuotePage.compareAllEleRatesMonthly();
       return this;

   }

	public GetAQuoteAction compareAllEleRatesQuarterly() {
       GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		ogaqQuotePage.compareAllEleRatesQuarterly();
       return this;

   }

	public GetAQuoteAction compareAllRatesMonthlyGas() {
       GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		ogaqQuotePage.compareAllRatesMonthlyGAS();
       return this;

   }

	public GetAQuoteAction compareAllRatesQuarterGas() {
       GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		ogaqQuotePage.compareAllRatesQuarterGAS();
       return this;

   }

	public GetAQuoteAction compareAllMonthlySignUP(int j) {
       GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		ogaqQuotePage.compareAllMonthlySignUP(j);
       return this;

   }

	public GetAQuoteAction compareAllQuarterSignUP(int j) {
    GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		ogaqQuotePage.compareAllQuarterSignUP(j);
    return this;

	}

	public GetAQuoteAction compareAllMonthlySignUPGAS(int j) {
    GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		ogaqQuotePage.compareAllMonthlySignUP(j);
    return this;

	}

	public GetAQuoteAction compareAllQuarterSignUPGAS(int i) {
    GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		ogaqQuotePage.compareAllQuarterSignUP(i);
    return this;

	}

    public GetAQuoteAction clickGasQuaterlyQuotepageContinue() {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.clickGasQuaterlyContinueQuotePage();
        return this;

    }

    public GetAQuoteAction clickDualQuaterlyQuotepageContinue() {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.clickDualQuaterlyContinueQuotePage();
        return this;

    }

	public GetAQuoteAction navigateToElecRbYesSupplypage(
			GetAQuoteDetails getDetails) {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.clickContinuElecRbYesSupplypage(getDetails, strRefNo);
        return this;
    }

	public GetAQuoteAction clickContinuElecSupplypage(
			GetAQuoteDetails getDetails) throws InterruptedException {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.clickContinuElecSupplypage(getDetails);
        return this;
    }

	public GetAQuoteAction navigateToElecRbNoSupplypage(
			GetAQuoteDetails getDetails) {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.clickContinuElecRbNoSupplypage(getDetails, strRefNo);
        return this;
    }

	public GetAQuoteAction navigateToGasRbYesSupplypage(
			GetAQuoteDetails getDetails) {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.clickContinuGasRbYesSupplypage(getDetails, strRefNo);
        return this;
    }

	public GetAQuoteAction navigateToGasRbNoSupplypage(
			GetAQuoteDetails getDetails) {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.clickContinuGasRbNoSupplypage(getDetails, strRefNo);
        return this;
    }

    public GetAQuoteAction businessPageDetails(GetAQuoteDetails getDetails) {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.enterBusinesspageDetails(getDetails, strRefNo);
        return this;
    }

    public GetAQuoteAction paymentPageDetailsMonthly(GetAQuoteDetails getDetails) {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.enterPaymentpageDetailsMonthly(getDetails, strRefNo);
        return this;
    }

	public GetAQuoteAction paymentPageDetailsQuaterly(
			GetAQuoteDetails getDetails) {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.enterPaymentpageDetailsQuaterly(getDetails, strRefNo);
        return this;
    }

    public GetAQuoteAction summaryPage(GetAQuoteDetails getDetails) {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.enterSummarypage(getDetails, strRefNo);
        return this;
    }

    public GetAQuoteAction thankYouPage() {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.gaqThankyouPage(strRefNo);
        return this;
    }

    public GetAQuoteAction gaqDBLeadVerify(GetAQuoteDetails getDetails) {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.verifyleadGaq(getDetails, strRefNo);
        return this;
    }

    public GetAQuoteAction verifyExistingQuoteValues(GetAQuoteDetails getDetails) {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.verifyExistingQuoteValues(getDetails);
        return this;
    }
    
	public GetAQuoteAction validateDBWithoutSupplyCode(
			GetAQuoteDetails getDetails) {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		ogaqQuotePage.validateDBWithoutSupplyCode(getDetails);
        return this;
    }

	public GetAQuoteAction saveCurrentQuote1Year() {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		ogaqQuotePage.saveCurrentQuote1Year();
        return this;
    }

	public GetAQuoteAction saveCurrentQuote2Year() {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		ogaqQuotePage.saveCurrentQuote2Year();
        return this;
    }

	public GetAQuoteAction saveCurrentQuote3year() {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		ogaqQuotePage.saveCurrentQuote3year();
        return this;
    }

	public GetAQuoteAction saveCurrentQuoteCompareAllTab() {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		ogaqQuotePage.saveCurrentQuoteCompareAllTab();
        return this;
    }

	public GetAQuoteAction saveCurrentQuote2year() {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		ogaqQuotePage.saveCurrentQuote2year();
        return this;
    }

	public GetAQuoteAction saveCurrentQuote1year() {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		ogaqQuotePage.saveCurrentQuote1year();
        return this;
    }

    public GetAQuoteAction retreiveSavedQuote(GetAQuoteDetails getDetails) {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.retreiveSavedQuote(getDetails);
        return this;
    }

    public GetAQuoteAction verifySavedQuoteStatus() {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.verifySavedQuoteStatus();
        return this;
    }

    public GetAQuoteAction verifySavedQuoteStatusBaddata() {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.verifySavedQuoteStatusBaddata();
        return this;
    }

    public GetAQuoteAction salesafter2ndtab() {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.salesafter2ndtab();
        return this;
    }

    public GetAQuoteAction verifyUnSavedQuoteStatus() {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.verifyUnSavedQuoteStatus();
        return this;
    }

	public GetAQuoteAction savedtextverificationmonthly(
			GetAQuoteDetails getDetails) {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.savedtextverificationmonthly(getDetails);
        return this;
    }

	public GetAQuoteAction savedtextverificationquarter(
			GetAQuoteDetails getDetails) {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.savedtextverificationquarter(getDetails);
        return this;
    }

	public GetAQuoteAction verifyAbandonedQuoteStatus(
			GetAQuoteDetails getDetails) {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.verifyAbandonedQuoteStatus(getDetails);
        return this;
    }

    public GetAQuoteAction verifyBadDataType() {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.verifyBadDataType();
        return this;
    }

    public GetAQuoteAction verifyBadDataTypeUnsaved() {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.verifyBadDataTypeUnsaved();
        return this;
    }

	public GetAQuoteAction navigateToBusinessHome() {
		 GaqQuotePage ogaqQuotePage = new GaqQuotePage();
	        ogaqQuotePage.navigateToBusinessHome();
	        return this;
	}

	public GetAQuoteAction enterElectricityAddress(GetAQuoteDetails getDetails) {
		 GetaQuoteDetailsPage ogaqQuotePage = new GetaQuoteDetailsPage();
	        ogaqQuotePage.enterElectricityAddress(getDetails);
	        return this;

	}

	public GetAQuoteAction enterConsumptionForEle(GetAQuoteDetails getDetails,
			int i) {
		 GetaQuoteDetailsPage ogaqQuotePage = new GetaQuoteDetailsPage();
		ogaqQuotePage.enterConsumptionForEle(getDetails, i);
	        return this;
	}

	public GetAQuoteAction clickGasMeterOptionNO() {
		 GetaQuoteDetailsPage ogaqQuotePage = new GetaQuoteDetailsPage();
		ogaqQuotePage.clickGasMeterOptionNO();
	        return this;
	}

	public GetAQuoteAction gasMeterYESandNO(GetAQuoteDetails getDetails)
			throws InterruptedException {
		 GetaQuoteDetailsPage ogaqQuotePage = new GetaQuoteDetailsPage();
		ogaqQuotePage.gasMeterYESandNO(getDetails);
	        return this;
	}

	public GetAQuoteAction enterConsumptionForGas(GetAQuoteDetails getDetails,
			int i) {
		 GetaQuoteDetailsPage ogaqQuotePage = new GetaQuoteDetailsPage();
		ogaqQuotePage.enterConsumptionForGas(getDetails, i);
	        return this;

	}

	public GetAQuoteAction calculatingConsumption1Year(
			GetAQuoteDetails getDetails, int j) {
		GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		ogaqQuotePage.calculatingConsumption1Year(getDetails, j);
	        return this;
	}

	public GetAQuoteAction calculatingConsumption2Year(
			GetAQuoteDetails getDetails, int j) {
		GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		ogaqQuotePage.calculatingConsumption2Year(getDetails, j);
	        return this;

	}

	public GetAQuoteAction calculatingConsumption3Year(
			GetAQuoteDetails getDetails, int j) {
		GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		ogaqQuotePage.calculatingConsumption3Year(getDetails, j);
	        return this;
	}

	public GetAQuoteAction calculatingConsumption3YearGas(
			GetAQuoteDetails getDetails, int j) {
		GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		ogaqQuotePage.calculatingConsumption3YearGas(getDetails, j);
	        return this;

	}

	public GetAQuoteAction calculatingConsumption2YearGas(
			GetAQuoteDetails getDetails, int j) {
		GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		ogaqQuotePage.calculatingConsumption2YearGas(getDetails, j);
	        return this;
	}

	public GetAQuoteAction calculatingConsumption1YearGas(
			GetAQuoteDetails getDetails, int j) {
		GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		ogaqQuotePage.calculatingConsumption1YearGas(getDetails, j);
	        return this;
	}

	public GetAQuoteAction defaultConsumptionSupplyCode1year(
			GetAQuoteDetails getDetails, int i) {
		GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		ogaqQuotePage.defaultConsumptionSupplyCode1year(getDetails, i);
	        return this;
	}

	public GetAQuoteAction defaultConsumptionSupplyCode2year(
			GetAQuoteDetails getDetails, int i) {
		GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		ogaqQuotePage.defaultConsumptionSupplyCode2year(getDetails, i);
		return this;
	}

	public GetAQuoteAction defaultConsumptionSupplyCode3year(
			GetAQuoteDetails getDetails, int i) {
		GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		ogaqQuotePage.defaultConsumptionSupplyCode3year(getDetails, i);
		return this;
	}
}
