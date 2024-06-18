import java.util.Date;

public class SoftwareLicense implements Product {
    private String name;
    private String description;
    private double price;
    private String licenseKey;
    private Date activateDate;
    private typeOfLicense userType;

    public SoftwareLicense(String name, String description, double price, String licenseKey,
                           Date activateDate, typeOfLicense userType) {
        this.name = name;
        this.description = description;
        if (price == 0) {
            throw new IllegalArgumentException("Price cant be 0");
        }
        this.price = price;
        this.licenseKey = licenseKey;
        this.activateDate = activateDate;
        this.userType = userType;
    }

    public String getLicenseKey() {
        return licenseKey;
    }

    public Date getActivateDate() {
        return activateDate;
    }

    public typeOfLicense getUserType() {
        return userType;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;

    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;

    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;

    }
}
