package bg.framework.app.functional.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("MakeAPaymentCardDetails")

public class MakeAPaymentCardDetails {
	
	private String cardNumber;
	private String cardType;
	private String nameOnCard;
	private String expiryMonth;
	private String expiryYear;
	private String securityCode;
	
	
	public String getCardNumber() {
		return cardNumber;
	}
	public String getCardType() {
		return cardType;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public String getExpiryMonth() {
		return expiryMonth;
	}
	public String getExpiryYear() {
		return expiryYear;
	}
	public String getSecurityCode() {
		return securityCode;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
}
