/*package bg.framework.app.functional.page.Slingshot;


import static bg.framework.app.functional.entities.FunctionalCategory.Login;
import static bg.framework.app.functional.entities.FunctionalCategory.Slingshot;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
//import org.joda.time.DateTime;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import oracle.sql.DATE;

//import org.apache.james.mime4j.field.datetime.DateTime;
import org.joda.time.DateTime;
import org.testng.annotations.Test;

import sun.misc.BASE64Encoder;
import static bg.framework.app.functional.entities.FunctionalCategory.*;
import bg.framework.app.functional.entities.UserProfile;
//@Test(groups ={Login,Slingshot})

public class Encryptions {
	
	private static final IvParameterSpec CBC_IV = new IvParameterSpec(new byte[] { 7,
            34,
            56,
            78,
            90,
            87,
            65,
            43,
            12,
            34,
            56,
            78,
            -123,
            87,
            65,
            43 });
	 private static final String ALGORITHM = "AES";
     private static final String BLOCK_MODE = "CBC";
     private static final String PADDING = "PKCS5Padding";
     private static final String emailAddressField="emailAddress";
     private static final String isAgent="isAgent";
     private static final String isAgentflag="true";
     private static final String businessPartnerOrganizationNumber="businessPartnerOrganizationNumber";
     private static final String emailAddress="emailAddress";
     String orgnumber="2000855183";
     public String encryptAndSendData(String email,String validation)
		     throws InstantiationException, IllegalAccessException {
		            final StringBuilder encryptData = new StringBuilder();
		            if(validation.equals("CSAAGENT")){
						encryptData.append(emailAddressField);
			            encryptData.append("=");
			            encryptData.append(email);
			            encryptData.append("&");
						encryptData.append(isAgent);
			            encryptData.append("=");
						encryptData.append(isAgentflag);
					
		            }else if(validation.equals("USEREMAIL")){
						encryptData.append(emailAddress);
			            encryptData.append("=");
			            encryptData.append(email);
			            encryptData.append("&");
						encryptData.append(businessPartnerOrganizationNumber);
			            encryptData.append("=");
						encryptData.append(orgnumber);							
		            }else if(validation.equalsIgnoreCase("PASSWORD")){
		            	DateTime jodaDate = new DateTime();
						System.out.println("Joda timestamp is :"+jodaDate);
						java.sql.Timestamp dateTime = new java.sql.Timestamp(jodaDate.getMillis());
						System.out.println("sql timestamp is :"+dateTime);

						String TIME="TIME";
						String EQUALS="=";
						String timestamp="2013-01-26 07:50:46.414";
//						String encryptedData = aa.encrypt("TIME=2012-11-24 19:07:50.151&EMAIL=chithra.kkesavan@cognizant.com");
						String AMPERSAND="&";
						String EMAIL="EMAIL";
						encryptData.append(TIME);
			            encryptData.append(EQUALS);
			            encryptData.append(timestamp);
			            encryptData.append(AMPERSAND);
			            encryptData.append(EMAIL);
			            encryptData.append(EQUALS);
			            encryptData.append(email);

		            }
		            String encryptedLink = encrypt(encryptData.toString());
		            System.out.println("link - "+encryptedLink);
		            return encryptedLink; 
		            
		      }

	public String encrypt(final String data) {
        String encryptedData = null;
        if ((data != null) && !data.equals("")) {
            final SecretKeySpec keySpec = generateAESKey();
            Cipher cipher;
            try {
                cipher = Cipher.getInstance(ALGORITHM + "/" + BLOCK_MODE + "/" + PADDING);
                encryptedData = encryptData(cipher, keySpec, data);
            } catch (final NoSuchAlgorithmException noSuchAlgorithmException) {
            	System.out.println(noSuchAlgorithmException.getMessage());
                //logger.error("No Algorithm Found : {}", noSuchAlgorithmException.getMessage());
            } catch (final NoSuchPaddingException noSuchPaddingException) {
            	System.out.println(noSuchPaddingException.getMessage());
                //logger.error("Incorrect Padding : {}", noSuchPaddingException.getMessage());
            }
        }
        return encryptedData;
    }

   private SecretKeySpec generateAESKey() {
       byte[] keyAsBytes = null;
       try {
           final SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
           sr.setSeed("78956".getBytes());
           final KeyGenerator kg = KeyGenerator.getInstance(ALGORITHM);
           kg.init(256, sr);
           final SecretKey secretKey = kg.generateKey();
           keyAsBytes = secretKey.getEncoded();
       } catch (final Exception e) {
    	   System.out.println(e.getMessage());
       }
       return new SecretKeySpec(keyAsBytes, ALGORITHM);
   }
   
   private String encryptData(final Cipher cipher, final SecretKeySpec key, final String plainText) {
       byte[] encrypted = null;
       try {
       try {
		cipher.init(Cipher.ENCRYPT_MODE, key, CBC_IV);
	} catch (InvalidAlgorithmParameterException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       encrypted = cipher.doFinal(plainText.getBytes());
       } catch (final IllegalBlockSizeException ibe) {
    	   System.out.println(ibe.getMessage());
       } catch (final BadPaddingException bpe) {
    	   System.out.println(bpe.getMessage());
       } catch (final InvalidKeyException ike) {
    	   System.out.println(ike.getMessage());
       }
       return encodeData(encrypted);
   }
   
   private String encodeData(final byte[] data) {
       String encodedData = null;
       final BASE64Encoder base64Encoder = new BASE64Encoder();
       encodedData = base64Encoder.encodeBuffer(data);
       return encodedData.trim();
   }
   
   //commented
   public static void main(String args[]){
	   try {
		//Encryption encrypt=new Encryption().encryptAndSendData("shanmugapriyan.j2@cognizant.com");
		   new Encryptions().encryptAndSendData("shanmugapriyan.j2@cognizant.com","PASSWORD");
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
   }
}
*/