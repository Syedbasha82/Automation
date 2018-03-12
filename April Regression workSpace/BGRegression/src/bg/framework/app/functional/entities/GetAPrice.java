package bg.framework.app.functional.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by IntelliJ IDEA.
 * User: !jithendb
 * Date: 02/02/12
 * Time: 06:58
 * To change this template use File | Settings | File Templates.
 */
@XStreamAlias("GetAPrice")
public class GetAPrice {

    private String firstName;
    private String lastName;
    private String title;
    private String email;
    private String password;
    private String mobileNumber;
    private String fuelType;
    private String postcode;
    private String ucrn;
    private String gasSpend;
    private String gasSpendType;
    private String gasAnnConsump;
    private String gasBedrooms;
    private String gasMeter;
    private String gasSupplier;
    private String gasTariff;
    private String gasPayment;
    private String gasPreferredPayment;
    private String elecSpend;
    private String elecSpendType;
    private String elecAnnConsump;
    private String elecBedrooms;
    private String elecMeter;
    private String elecSupplier;
    private String elecTariff;
    private String elecPayment;
    private String elecPreferredPayment;
    private String phoneType;
    private String dualtype;
    private String economy;

    public GetAPrice() {
    }

    public GetAPrice(String ucrn, String firstName, String lastName, String title, String email,
                     String password,String dualtype,String economy,
                     String mobileNumber, String fuelType, String postcode,
                     String gasSpend, String gasSpendType, String gasAnnConsump, String gasBedrooms, String gasMeter,
                     String gasSupplier, String gasTariff, String gasPayment, String gasPreferredPayment, String elecSpend, String elecSpendType, String elecAnnConsump, String elecBedrooms,
                     String elecSupplier, String elecTariff, String elecPayment, String elecPreferredPayment, String elecMeter, String phoneType) {
        this.ucrn = ucrn;
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.fuelType = fuelType;
        this.postcode = postcode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.gasSpend = gasSpend;
        this.gasSpendType = gasSpendType;
        this.gasAnnConsump = gasAnnConsump;
        this.gasBedrooms = gasBedrooms;
        this.gasMeter = gasMeter;
        this.gasSupplier = gasSupplier;
        this.gasTariff = gasTariff;
        this.gasPayment = gasPayment;
        this.gasPreferredPayment = gasPreferredPayment;
        this.elecSpend = elecSpend;
        this.elecSpendType = elecSpendType;
        this.elecAnnConsump = elecAnnConsump;
        this.elecBedrooms = elecBedrooms;
        this.elecMeter = elecMeter;
        this.elecSupplier = elecSupplier;
        this.elecTariff = elecTariff;
        this.elecPayment = elecPayment;
        this.elecPreferredPayment = elecPreferredPayment;
        this.phoneType = phoneType;
        this.dualtype=dualtype;
        this.economy=economy;
    }

    public String getUcrn() {
        return ucrn;
    }
    
    public String getEconomy() {
        return economy;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTitle() {
        return title;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getMobileType() {
        return phoneType;
    }

    public String getfuelType() {
        return fuelType;
    }

    public String getpostcode() {
        return postcode;
    }

    public String getgasSpend() {
        return gasSpend;
    }

    public String getgasSpendType() {
        return gasSpendType;
    }

    public String getgasAnnConsump() {
        return gasAnnConsump;
    }

    public String getgasBedrooms() {
        return gasBedrooms;
    }

    public String getgasMeter() {
        return gasMeter;
    }

    public String getgasSupplier() {
        return gasSupplier;
    }

    public String getgasTariff() {
        return gasTariff;
    }

    public String getgasPayment() {
        return gasPayment;
    }

    public String getGasPreferredPayment() {
        return gasPreferredPayment;
    }

    public String getelecSpend() {
        return elecSpend;
    }

    public String getelecSpendType() {
        return elecSpendType;
    }

    public String getelecAnnConsump() {
        return elecAnnConsump;
    }

    public String getelecBedrooms() {
        return elecBedrooms;
    }

    public String getelecSupplier() {
        return elecSupplier;
    }

    public String getelecMeter() {
        return elecMeter;
    }

    public String getelecTariff() {
        return elecTariff;
    }

    public String getelecPayment() {
        return elecPayment;
    }

    public String getElecPreferredPayment() {
        return elecPreferredPayment;
    }
    
    public String getDualType() {
        return dualtype;
    }


}
