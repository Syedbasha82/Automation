	package bg.framework.app.functional.action.bgb;
	
	import bg.framework.app.functional.entities.GetAQuoteDetails;
	import bg.framework.app.functional.page.bgb.GaqQuotePage;
	import bg.framework.app.functional.page.bgb.GetaQuoteBusinessPage;
	import bg.framework.app.functional.page.bgb.GetaQuoteDetailsPage;
	import bg.framework.app.functional.page.bgb.GetaquoteCombinedEnergyPage;
	
	
	public class GetaquoteCombinedEnergyAction {
	
    static String strRefNo = null;
	
    public GetaquoteCombinedEnergyAction(String strRefNo) {
        GetaquoteCombinedEnergyAction.strRefNo = strRefNo;
    }
	
    public GetaquoteCombinedEnergyAction() {
	
    }

    public GetaquoteCombinedEnergyAction clickCombinedEnergyLink() {
    	GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
       gaqbusinesspage.getaquoteClickCompinedLink();
	
       return this;
   }
    
    public GetaquoteCombinedEnergyAction enterGetaQuoteDetails(GetAQuoteDetails getDetails) {
    	GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
       gaqbusinesspage.enterGetaQuoteDetails(getDetails);
	
       return this;
   }
	
	    public GetaquoteCombinedEnergyAction firstYearTextVerify(GetAQuoteDetails getDetails) {
	GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
	       gaqbusinesspage.firstYearTextVerify(getDetails);
	
	       return this;
	   }
	
		public GetaquoteCombinedEnergyAction click1stYearTabDual(GetAQuoteDetails getDetails) {
			GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
			gaqbusinesspage.click1stYearTabDual(getDetails);
			return this;
		}
		
		public GetaquoteCombinedEnergyAction click2ndYearTabDual(GetAQuoteDetails getDetails) {
			GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
			gaqbusinesspage.click2ndYearTabDual(getDetails);
			return this;
		}
		
		public GetaquoteCombinedEnergyAction click3rdYearTabDual(GetAQuoteDetails getDetails) {
			GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
			gaqbusinesspage.click3rdYearTabDual(getDetails);
			return this;
		}	
		
		
		public GetaquoteCombinedEnergyAction clickCompreTabDual(GetAQuoteDetails getDetails) {
			GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
			gaqbusinesspage.clickCompreTabDual(getDetails);
			return this;
		}		
		
		public GetaquoteCombinedEnergyAction clickCompareTabDualQuarter(GetAQuoteDetails getDetails) {
			GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
			gaqbusinesspage.clickCompareTabDualQuarter(getDetails);
			return this;
		}	
		
		
		public GetaquoteCombinedEnergyAction firstYearAddressCalMonthlyQuarter(
				GetAQuoteDetails getDetails, String FirstMonthlyQuarter, String Dual) {
			GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
			gaqbusinesspage.firstYearAddressCalMonthlyQuarter(getDetails,
					FirstMonthlyQuarter, Dual);
			return new GetaquoteCombinedEnergyAction();
		}
		
		public GetaquoteCombinedEnergyAction secondYearAddressCalMonthlyQuarter(
				GetAQuoteDetails getDetails, String FirstMonthlyQuarter, String Dual) {
			GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
			gaqbusinesspage.secondYearAddressCalMonthlyQuarter(getDetails,
					FirstMonthlyQuarter, Dual);
			return new GetaquoteCombinedEnergyAction();
		}
		
		public GetaquoteCombinedEnergyAction thirdYearAddressCalMonthlyQuarter(
				GetAQuoteDetails getDetails, String FirstMonthlyQuarter, String Dual) {
			GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
			gaqbusinesspage.thirdYearAddressCalMonthlyQuarter(getDetails,
					FirstMonthlyQuarter, Dual);
			return new GetaquoteCombinedEnergyAction();
		}
		
		public GetaquoteCombinedEnergyAction firstYearCalculationForGasEle(GetAQuoteDetails getDetails, String FirstMonthly) {
			GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
			gaqbusinesspage.firstYearCalculationForGasEle(getDetails, FirstMonthly);
			return new GetaquoteCombinedEnergyAction();
		}
		
		public GetaquoteCombinedEnergyAction secondYearCalculationForGasEle(GetAQuoteDetails getDetails, String FirstMonthly) {
			GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
			gaqbusinesspage.secondYearcalculationForGasEle(getDetails, FirstMonthly);
			return new GetaquoteCombinedEnergyAction();
		}
		
		public GetaquoteCombinedEnergyAction thirdYearCalculationForGasEle(GetAQuoteDetails getDetails, String FirstMonthly) {
			GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
			gaqbusinesspage.thirdYearcalculationForGasEle(getDetails, FirstMonthly);
			return new GetaquoteCombinedEnergyAction();
		}
		
		public GetaquoteCombinedEnergyAction electricityAddressAndUsage(GetAQuoteDetails getDetails) {
			GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
   gaqbusinesspage.enterElectricityAddressAndUsage(getDetails);
		
   return this;
		}

		public GetaquoteCombinedEnergyAction enterSupplycodeMannualyElectricity(GetAQuoteDetails getDetails) {
	GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
   gaqbusinesspage.enterSupplycodeMannualyElectricity(getDetails);
		
		   return this;
		}

		public GetaquoteCombinedEnergyAction enterSupplycodeMannualyGas(GetAQuoteDetails getDetails) {
		GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
		gaqbusinesspage.enterSupplycodeMannualyGas(getDetails);
		
   return this;
		}

		public GetaquoteCombinedEnergyAction enterConsumptionForEle(GetAQuoteDetails getDetails,int i) {
	GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
   gaqbusinesspage.enterConsumptionForEle(getDetails,i);
		
		   return this;
		} 

		public GetaquoteCombinedEnergyAction enterGasAddressAndUsage(GetAQuoteDetails getDetails) {
		GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
		gaqbusinesspage.enterGasAddressAndUsage(getDetails);
   return this;
		}

		public GetaquoteCombinedEnergyAction enterConsumptionForGas(GetAQuoteDetails getDetails,int i) {
		GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
		gaqbusinesspage.enterConsumptionForGas(getDetails,i);
		return this;
		} 

		public GetaquoteCombinedEnergyAction calculateQuoteForElec() {
		GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
		gaqbusinesspage.calculateQuoteForElec();
		
		return this;
		} 

		public GetaquoteCombinedEnergyAction elecSupplyDetailsManuall(GetAQuoteDetails getDetails) {
	GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
	gaqbusinesspage.elecSupplyDetailsManuall(getDetails);
   return this;
		}
		
		public GetaquoteCombinedEnergyAction updateSupplypointValues(int i) {
	GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
	gaqbusinesspage.updateSupplypointValues(i);
   return this;
		}

		public GetaquoteCombinedEnergyAction gascSupplyDetailsManually(GetAQuoteDetails getDetails) {
	GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
			gaqbusinesspage.gascSupplyDetailsManually(getDetails);
   return this;
		}
		
		public GetaquoteCombinedEnergyAction calculatingConsumption1YearEle(
				GetAQuoteDetails getDetails, int j) {
			GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
			gaqbusinesspage.calculatingConsumption1YearEle(getDetails, j);
			return this;
		}
		
		public GetaquoteCombinedEnergyAction calculatingConsumption1YearGas(
				GetAQuoteDetails getDetails, int j) {
			GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
			gaqbusinesspage.calculatingConsumption1YearGas(getDetails, j);
			return this;
		}
		
		public GetaquoteCombinedEnergyAction calculatingConsumption2YearEle(
				GetAQuoteDetails getDetails, int j) {
			GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
			gaqbusinesspage.calculatingConsumption2YearEle(getDetails, j);
			return this;
		}
		
		public GetaquoteCombinedEnergyAction calculatingConsumption2YearGas(
				GetAQuoteDetails getDetails, int j) {
			GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
			gaqbusinesspage.calculatingConsumption2YearGas(getDetails, j);
			return this;
		}
		
		public GetaquoteCombinedEnergyAction calculatingConsumption3YearEle(
				GetAQuoteDetails getDetails, int j) {
			GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
			gaqbusinesspage.calculatingConsumption3YearEle(getDetails, j);
			return this;
		}
		
		public GetaquoteCombinedEnergyAction calculatingConsumption3YearGas(
				GetAQuoteDetails getDetails, int j) {
			GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
			gaqbusinesspage.calculatingConsumption3YearGas(getDetails, j);
			return this;
		}
		
		
		public GetaquoteCombinedEnergyAction validateSecondYearContractQuarter(GetAQuoteDetails getDetails) {
			GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
			gaqbusinesspage.validateSecondYearContractQuarter(getDetails);
			return this;
		}
		
		public GetaquoteCombinedEnergyAction click3rdYearTabDualQuarter(GetAQuoteDetails getDetails) {
			GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
			gaqbusinesspage.click3rdYearTabDualQuarter(getDetails);
			return this;
		}
		
		public GetaquoteCombinedEnergyAction clickMonthlyQuotepageContinue1stYear() {
			GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
			gaqbusinesspage.clickMonthlyContinueQuotePage1stYear();
			return this;
		}
			
		public GetaquoteCombinedEnergyAction clickMonthlyQuotepageContinue2ndYear() {
			GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
			gaqbusinesspage.clickMonthlyContinueQuotePage2ndYear();
			return this;
		}
		
		public GetaquoteCombinedEnergyAction clickMonthlyQuotepageContinue3rdYear() {
			GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
			gaqbusinesspage.clickMonthlyContinueQuotePage3rdYear();
			return this;
		}
		
		public GetaquoteCombinedEnergyAction gasunitpricefromdbMonthlyQuarter1stYear(
				GetAQuoteDetails getDetails, String monthlyquarter, String Dual) {
			GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
			gaqbusinesspage.gasunitpricefromdb1stYear(getDetails, monthlyquarter, Dual);
			return new GetaquoteCombinedEnergyAction();
		}
		
		public GetaquoteCombinedEnergyAction gasPricefromdbMonthlyQuarter2ndYear(
				GetAQuoteDetails getDetails, String monthlyquarter, String Dual) {
			GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
			gaqbusinesspage.gasunitpricefromdb2ndYear(getDetails, monthlyquarter, Dual);
			return new GetaquoteCombinedEnergyAction();
		}
		
		public GetaquoteCombinedEnergyAction gasPricefromdbMonthlyQuarter3rdYear(
				GetAQuoteDetails getDetails, String monthlyquarter, String Dual) {
			GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
			gaqbusinesspage.gasunitpricefromdb3rdYear(getDetails, monthlyquarter, Dual);
			return new GetaquoteCombinedEnergyAction();
		}
		
		public GetaquoteCombinedEnergyAction clickQuaterlybutton1stYearGas(GetAQuoteDetails getDetails){
			GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
			gaqbusinesspage.clickQuaterlybutton1stYearGas(getDetails);
			return new GetaquoteCombinedEnergyAction();
		}
		
		public GetaquoteCombinedEnergyAction clickQuaterlybutton1stYear(GetAQuoteDetails getDetails){
			GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
			gaqbusinesspage.clickQuaterlybutton1stYear(getDetails);
			return new GetaquoteCombinedEnergyAction();
		}
		
		public GetaquoteCombinedEnergyAction defaultConsumptionSupplyCode1year(
				GetAQuoteDetails getDetails, int i) {
			GetaquoteCombinedEnergyPage ogaqQuotePage = new GetaquoteCombinedEnergyPage();
			ogaqQuotePage.defaultConsumptionSupplyCode1year(getDetails, i);
			return this;
		}
		
		public GetaquoteCombinedEnergyAction defaultConsumptionSupplyCode2year(
				GetAQuoteDetails getDetails, int i) {
			GetaquoteCombinedEnergyPage ogaqQuotePage = new GetaquoteCombinedEnergyPage();
			ogaqQuotePage.defaultConsumptionSupplyCode2year(getDetails, i);
			return this;
		}
		
		public GetaquoteCombinedEnergyAction defaultConsumptionSupplyCode3year(
				GetAQuoteDetails getDetails, int i) {
			GetaquoteCombinedEnergyPage ogaqQuotePage = new GetaquoteCombinedEnergyPage();
			ogaqQuotePage.defaultConsumptionSupplyCode3year(getDetails, i);
			return this;
		}
		
    public GetaquoteCombinedEnergyAction clickElecquoteLink() {
        GetaQuoteBusinessPage gaqbusinesspage = new GetaQuoteBusinessPage();
        gaqbusinesspage.getaquoteClickElecquoteLink();
		
        return this;
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

    public GetaquoteCombinedEnergyAction elecSupplyDetailsYes(GetAQuoteDetails getDetails) {
        GetaQuoteDetailsPage ogetDetails = new GetaQuoteDetailsPage();
        ogetDetails.electricitySupplyDetailsClickRbYes(getDetails);
        return new GetaquoteCombinedEnergyAction();
    }

    public GetaquoteCombinedEnergyAction elecSupplyDetailsNo(GetAQuoteDetails getDetails) {
        GetaQuoteDetailsPage ogetDetails = new GetaQuoteDetailsPage();
        ogetDetails.electricitySupplyDetailsClickRbNo(getDetails);
        return new GetaquoteCombinedEnergyAction();
    }

    public GetaquoteCombinedEnergyAction gasSupplyDetailsYes(GetAQuoteDetails getDetails) {
        GetaQuoteDetailsPage ogetDetails = new GetaQuoteDetailsPage();
        ogetDetails.gasSupplyDetailsClickRbYes(getDetails);
        return new GetaquoteCombinedEnergyAction();
    }

    public GetaquoteCombinedEnergyAction dualGasSupplyDetailsYes(GetAQuoteDetails getDetails) {
        GetaQuoteDetailsPage ogetDetails = new GetaQuoteDetailsPage();
        ogetDetails.dualGasSupplyDetailsClickRbYes(getDetails);
        return new GetaquoteCombinedEnergyAction();
    }

    public GetaquoteCombinedEnergyAction gasSupplyDetailsNo(GetAQuoteDetails getDetails) {
        GetaQuoteDetailsPage ogetDetails = new GetaQuoteDetailsPage();
        ogetDetails.gasSupplyDetailsClickRbNo(getDetails);
        return new GetaquoteCombinedEnergyAction();
    }

    public GetaquoteCombinedEnergyAction dualGasSupplyDetailsNo(GetAQuoteDetails getDetails) {
        GetaQuoteDetailsPage ogetDetails = new GetaQuoteDetailsPage();
        ogetDetails.dualGasSupplyDetailsClickRbNo(getDetails);
        return new GetaquoteCombinedEnergyAction();
    }

    public GetaquoteCombinedEnergyAction retreiveElecQuotesUI() {
        GetaQuoteDetailsPage ogetDetails = new GetaQuoteDetailsPage();
        ogetDetails.retreiveElecQuotesUI();
		
        return new GetaquoteCombinedEnergyAction();
    }
		
    public GetaquoteCombinedEnergyAction validateSecondYearContract(GetAQuoteDetails gaqDetails)
    {
    	GaqQuotePage getAQuotePage=new GaqQuotePage();
    	//getAQuotePage.validateSecondYearContract(gaqDetails);
    	return new GetaquoteCombinedEnergyAction();
    }

    public GetaquoteCombinedEnergyAction retreiveDualQuotesUI() {
        GetaQuoteDetailsPage ogetDetails = new GetaQuoteDetailsPage();
        ogetDetails.retreiveDualQuotesUI();
		
        return new GetaquoteCombinedEnergyAction();
    }

    public GetaquoteCombinedEnergyAction clickCalculateQuoteForElec() {
        GetaQuoteDetailsPage ogetDetails = new GetaQuoteDetailsPage();
        ogetDetails.calculateQuoteForElec();
        return new GetaquoteCombinedEnergyAction();
    }

    public GetaquoteCombinedEnergyAction clickCalculateQuoteForGas() {
        GetaQuoteDetailsPage ogetDetails = new GetaQuoteDetailsPage();
        ogetDetails.calculateQuoteForGasquote();
        return new GetaquoteCombinedEnergyAction();
    }

    public GetaquoteCombinedEnergyAction clickCalculateQuoteForDual() {
        GetaQuoteDetailsPage ogetDetails = new GetaQuoteDetailsPage();
        ogetDetails.calculateQuoteForDualquote();
        return new GetaquoteCombinedEnergyAction();
    }

    public GetaquoteCombinedEnergyAction verifyElecDBGaqrate(GetAQuoteDetails getDetails) {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.verifyElecGaqrate(getDetails);
        return this;
    }

    public GetaquoteCombinedEnergyAction verifyElecQuotePageChargeRate(GetAQuoteDetails getDetails) {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.verifyElecQuotePageCharge(getDetails);
        return this;
    }

    public GetaquoteCombinedEnergyAction verifyGasDBGaqrate(GetAQuoteDetails getDetails) {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.verifyGasGaqRate(getDetails);
        return this;
    }

    public GetaquoteCombinedEnergyAction verifyGasQuotePageCharge(GetAQuoteDetails getDetails) {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.verifyGasQuotePageCharge(getDetails);
        return this;
    }
		
    public GetaquoteCombinedEnergyAction selectElectricityPaymentOptionMonthly() {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.selectElectricityPaymentOptionMonthly();
        return this;
    }

    public GetaquoteCombinedEnergyAction selectElectricityPaymentOptionQuaterly() {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.selectElectricityPaymentOptionQuaterly();
        return this;
    }

    public GetaquoteCombinedEnergyAction selectGasPaymentOptionMonthly() {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.selectGasPaymentOptionMonthly();
        return this;
    }

    public GetaquoteCombinedEnergyAction selectGasPaymentOptionQuaterly() {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.selectGasPaymentOptionQuaterly();
        return this;
    }

    public GetaquoteCombinedEnergyAction clickQuaterlyQuotepageContinue() {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.clickQuaterlyContinueQuotePage();
        return this;
		
    }

    public GetaquoteCombinedEnergyAction clickGasQuaterlyQuotepageContinue() {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.clickGasQuaterlyContinueQuotePage();
        return this;
		
    }

    public GetaquoteCombinedEnergyAction clickDualQuaterlyQuotepageContinue() {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.clickDualQuaterlyContinueQuotePage();
        return this;
		
    }

    public GetaquoteCombinedEnergyAction navigateToElecRbYesSupplypage(GetAQuoteDetails getDetails) {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.clickContinuElecRbYesSupplypage(getDetails, strRefNo);
        return this;
    }
		
    public GetaquoteCombinedEnergyAction navigateToElecRbNoSupplypage(GetAQuoteDetails getDetails) {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.clickContinuElecRbNoSupplypage(getDetails, strRefNo);
        return this;
    }

    public GetaquoteCombinedEnergyAction navigateToGasRbYesSupplypage(GetAQuoteDetails getDetails) {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.clickContinuGasRbYesSupplypage(getDetails, strRefNo);
        return this;
    }

    public GetaquoteCombinedEnergyAction navigateToGasRbNoSupplypage(GetAQuoteDetails getDetails) {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.clickContinuGasRbNoSupplypage(getDetails, strRefNo);
        return this;
    }

    public GetaquoteCombinedEnergyAction businessPageDetails(GetAQuoteDetails getDetails) {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.enterBusinesspageDetails(getDetails, strRefNo);
        return this;
    }
		
    public GetaquoteCombinedEnergyAction paymentPageDetailsMonthly(GetAQuoteDetails getDetails) {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.enterPaymentpageDetailsMonthly(getDetails, strRefNo);
        return this;
    }

    public GetaquoteCombinedEnergyAction paymentPageDetailsQuaterly(GetAQuoteDetails getDetails) {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.enterPaymentpageDetailsQuaterly(getDetails, strRefNo);
        return this;
    }

    public GetaquoteCombinedEnergyAction summaryPage(GetAQuoteDetails getDetails) {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.enterSummarypage(getDetails, strRefNo);
        return this;
    }

    public GetaquoteCombinedEnergyAction thankYouPage() {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.gaqThankyouPage(strRefNo);
        return this;
    }

    public GetaquoteCombinedEnergyAction gaqDBLeadVerify(GetAQuoteDetails getDetails) {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.verifyleadGaq(getDetails, strRefNo);
        return this;
    }
		
    public GetaquoteCombinedEnergyAction verifyExistingQuoteValues(GetAQuoteDetails getDetails) {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.verifyExistingQuoteValues(getDetails);
        return this;
		
    }
		
		public GetaquoteCombinedEnergyAction saveCurrentQuote1Year() {
		
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		    ogaqQuotePage.saveCurrentQuote1Year();
        return this;
		
    }
		public GetaquoteCombinedEnergyAction saveCurrentQuote2Year() {
			
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		    ogaqQuotePage.saveCurrentQuote2Year();
        return this;
		
    }
		public GetaquoteCombinedEnergyAction saveCurrentQuote3Year() {
			
		    GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		    ogaqQuotePage.saveCurrentQuote3year();
		    return this;
		
		}
		public GetaquoteCombinedEnergyAction saveCurrentQuoteCompareAllTab() {
			
		    GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		    ogaqQuotePage.saveCurrentQuoteCompareAllTab();
		    return this;
		
		}
    public GetaquoteCombinedEnergyAction retreiveSavedQuote(GetAQuoteDetails getDetails) {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.retreiveSavedQuote(getDetails);
        return this;
    }
		
    public GetaquoteCombinedEnergyAction verifySavedQuoteStatus() {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.verifySavedQuoteStatus();
        return this;
		
    }
		
		public GetaquoteCombinedEnergyAction verifyUnSavedQuoteStatus(String Qrnno) {
			GetaquoteCombinedEnergyPage ogaqQuotePage = new GetaquoteCombinedEnergyPage();
		    ogaqQuotePage.verifyUnSavedQuoteStatus(Qrnno);
        return this;
		
    }
		
    public GetaquoteCombinedEnergyAction verifyAbandonedQuoteStatus(GetAQuoteDetails getDetails) {
        GaqQuotePage ogaqQuotePage = new GaqQuotePage();
        ogaqQuotePage.verifyAbandonedQuoteStatus(getDetails);
        return this;
		
    }
		
		public GetaquoteCombinedEnergyAction navigateToBusinessHome() {
			 GaqQuotePage ogaqQuotePage = new GaqQuotePage();
		        ogaqQuotePage.navigateToBusinessHome();
		        return this;///
			}
		
		public GetaquoteCombinedEnergyAction verifySavedQuoteStatusBaddata() {
			GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
			gaqbusinesspage.verifySavedQuoteStatusBaddata();
			return new GetaquoteCombinedEnergyAction();
		}
		
			public GetaquoteCombinedEnergyAction verifyBadDataTypeUnsaved() {
			GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
			gaqbusinesspage.verifyBadDataTypeUnsaved();
			return new GetaquoteCombinedEnergyAction();
		}

    public GetaquoteCombinedEnergyAction verifyBadDataType() {
			GetaquoteCombinedEnergyPage gaqbusinesspage = new GetaquoteCombinedEnergyPage();
			gaqbusinesspage.verifyBadDataType();
			return new GetaquoteCombinedEnergyAction();
    }

		
	}
