package bg.framework.app.functional.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("PredictNextBill")

public class PredictNextBill {
	private String gasEstimatedRead;
	private String elecEstimatedRead;
	private String elecDualEstimatedRead;
	
	
	public PredictNextBill()
	{
	}
	public PredictNextBill(String gasEstimatedRead,String elecEstimatedRead,String elecDualEstimatedRead)
	{
		this.gasEstimatedRead=gasEstimatedRead;
		this.elecEstimatedRead=elecEstimatedRead;
		this.elecDualEstimatedRead=elecDualEstimatedRead;
	}
	public String getGasEstimate()
	{
		return gasEstimatedRead;
	}
	public String getElecEstimate()
	{
		return elecEstimatedRead;
	}
	
	public String getElecDualEstimate()
	{
		return elecDualEstimatedRead;
	}
}

