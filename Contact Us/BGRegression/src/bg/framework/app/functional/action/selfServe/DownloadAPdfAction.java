package bg.framework.app.functional.action.selfServe;

import bg.framework.app.functional.page.selfServe.DownloadAPdfPage;

public class DownloadAPdfAction {

	DownloadAPdfPage downloadAPdfPage = new DownloadAPdfPage(); 
	
	public DownloadAPdfAction navigatetoLatestStatement(){
		downloadAPdfPage.navigatetoLatestStatement();
		return this;
	}
	
	public DownloadAPdfAction downloadPDF(){
		downloadAPdfPage.downloadPDF();
		return this;
	}
	
	public DownloadAPdfAction verifyPDFDownload(){
		downloadAPdfPage.verifyPDFDownload();
		return this;
	}
	
	public DownloadAPdfAction verifyPDFDownloadGasMessage(){
		downloadAPdfPage.verifyPDFDownloadGasMessage();
		return this;
	}
	
	public DownloadAPdfAction verifyPDFDownloadBillEntry(){
		downloadAPdfPage.verifyPDFDownloadBillEntry();
		return this;
	}
	
	public DownloadAPdfAction logout(){
		downloadAPdfPage.logout();
		return this;
	}
	
}
