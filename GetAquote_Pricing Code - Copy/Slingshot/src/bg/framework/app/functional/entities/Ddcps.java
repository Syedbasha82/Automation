package bg.framework.app.functional.entities;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Ddcps")
public class Ddcps {

	private String bankFirstName;
	private String bankLastName;
	private String dateOfBirth;
	private String monthOfBirh;
	private String yearOfBirth;
	private String sortCode1;
	private String sortCode2;
	private String sortCode3;
	private String bankAccountNumber;
	private String cardType;
	private String cardHolderName;
	private String cardNumber;
	private String cardStartMonth;
	private String cardStartYear;
	private String cardEndMonth;
	private String cardEndYear;
	private String cardCVV;
	private String payDueAmount;
	private String paymentDay;
	private String mkpAmount;
	private String adjustMonthlyAmount;
	private String refundAmount;
	private String updateFirstName;
	private String updateLastName;
	private String updateDOB;
	private String updateMOB;
	private String updateYOB;
	private String updateSortCode1;
	private String updateSortCode2;
	private String updateSortCode3;
	private String updateAccountNumber;
	
	
	public Ddcps()
	{}
	public Ddcps(String bankFirstName,String bankLastName,String dateOfBirth,String monthOfBirh,String yearOfBirth,String sortCode1
			,String sortCode2,String sortCode3,String bankAccountNumber,String cardType,String cardHolderName,String cardNumber,
			String cardStartMonth,String cardStartYear,String cardEndMonth,String cardEndYear,String cardCVV,String payDueAmount,String paymentDay
			,String mkpAmount,String adjustMonthlyAmount,String refundAmount,String updateFirstName,String updateLastName,
			String updateDOB,String updateMOB,String updateYOB,String updateSortCode1,String updateSortCode2,String updateSortCode3
			,String updateAccountNumber)
	{
		this.bankFirstName=bankFirstName;
		this.bankLastName=bankLastName;
		this.dateOfBirth=dateOfBirth;
		this.monthOfBirh=monthOfBirh;
		this.yearOfBirth=yearOfBirth;
		this.sortCode1=sortCode1;
		this.sortCode2=sortCode2;
		this.sortCode3=sortCode3;
		this.bankAccountNumber=bankAccountNumber;
		this.cardType=cardType;
		this.cardHolderName=cardHolderName;
		this.cardNumber=cardNumber;
		this.cardStartMonth=cardStartMonth;
		this.cardStartYear=cardStartYear;
		this.cardEndMonth=cardEndMonth;
		this.cardEndYear=cardEndYear;
		this.cardCVV=cardCVV;
		this.payDueAmount=payDueAmount;
		this.paymentDay=paymentDay;
		this.mkpAmount=mkpAmount;
		this.adjustMonthlyAmount=adjustMonthlyAmount;
		this.refundAmount=refundAmount;
		this.updateFirstName=updateFirstName;
		this.updateLastName=updateLastName;
		this.updateDOB=updateDOB;
		this.updateMOB=updateMOB;
		this.updateYOB=updateYOB;
		this.updateSortCode1=updateSortCode1;
		this.updateSortCode2=updateSortCode2;
		this.updateSortCode3=updateSortCode3;
		this.updateAccountNumber=updateAccountNumber;
	}
	
	public String getBankFirstName()
	{
		return bankFirstName;}
	
	public String getBankLastName()
	{
		return bankLastName;}
	public String getDateOfBirth()
	{
		return dateOfBirth;}
	public String getMonthOfBirh()
	{
		return monthOfBirh;}
	public String getYearOfBirth()
	{
		return yearOfBirth;}
	public String getSortCode1()
	{
		return sortCode1;}
	public String getSortCode2()
	{
		return sortCode2;}
	public String getSortCode3()
	{
		return sortCode3;}
	public String getBankAccountNumber()
	{
		return bankAccountNumber;}
	public String getCardType()
	{
		return cardType;}
	public String getCardHolderName()
	{
		return cardHolderName;}
	public String getCardNumber()
	{
		return cardNumber;}
	public String getCardStartMonth()
	{
		return cardStartMonth;}
	public String getCardStartYear()
	{
		return cardStartYear;}
	public String getCardEndMonth()
	{
		return cardEndMonth;}
	public String getCardEndYear()
	{
		return cardEndYear;}
	public String getCardCVV()
	{
		return cardCVV;}
	public String getpayDueAmount()
	{
		return payDueAmount;}
	public String getPaymentDay()
	{
		return paymentDay;}
	public String getMkpAmount()
	{
		return mkpAmount;}
	public String getAdjustMonthlyAmount()
	{
		return adjustMonthlyAmount;}
	public String getRefundAmount()
	{
		return refundAmount;}
	public String getUpdateFirstName()
	{
		return updateFirstName;}
	public String getUpdateLastName()
	{
		return updateLastName;}
	public String getUpdateDOB()
	{
		return updateDOB;}
	public String getUpdateMOB()
	{
		return updateMOB;}
	public String getUpdateYOB()
	{
		return updateYOB;}
	public String getUpdateSortCode1()
	{
		return updateSortCode1;}
	public String getUpdateSortCode2()
	{
		return updateSortCode2;}
	public String getUpdateSortCode3()
	{
		return updateSortCode3;}
	public String getUpdateAccountNumber()
	{
		return updateAccountNumber;}
	
}
