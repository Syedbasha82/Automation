package bg.framework.app.functional.entities.builders;

import bg.framework.app.functional.entities.UpdateUserFormFields;

public class UpdateUserMeterReadingFieldsBuilder {

    private String gasMeterReading;
    private String electricityMeterReading;

    public UpdateUserMeterReadingFieldsBuilder withGasMeterReading(String gasMeterReading) {
        this.gasMeterReading = gasMeterReading;
        return this;
    }

    public UpdateUserMeterReadingFieldsBuilder withElectricityMeterReading(String electricityMeterReading) {
        this.electricityMeterReading = electricityMeterReading;
        return this;
    }

    public UpdateUserFormFields build() {
        return new UpdateUserFormFields(gasMeterReading, electricityMeterReading);
    }
}
