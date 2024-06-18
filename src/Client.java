
import java.util.ArrayList;
import java.util.Date;

public class Client {
    private String fName;
    private String lName;
    private String email;
    private String phone;
    private double discount;
    private static ArrayList<Sale> sales = new ArrayList<>();

    public Client(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    public Client(String fName, String lName, String email, String phone, double discount) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phone = phone;
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Illegal discount");
        }
        this.discount = discount;
    }

    public String getFName() {
        return fName;
    }

    public String getLName() {
        return lName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public double getDiscount() {
        return discount;
    }

    public double buySoftwareLicense(SoftwareLicense softwareLicense) {
        if (sales.contains(softwareLicense)) {
            throw new IllegalArgumentException("Product sold");
        }
        double price = softwareLicense.getPrice() * (1-(this.discount / 100));
        Sale sale = new Sale(price, 0, this, softwareLicense);
        sales.add(sale);
        return price;
    }

    public double buySubscription(Subscription subscription) {
        if (sales.contains(subscription)) {
            throw new IllegalArgumentException("Product sold");
        }
        double price = (subscription.getPrice() * (1-(this.discount / 100))) * subscription.getRenewalPeriod();
        Sale sale = new Sale(price, 0, this, subscription);
        sales.add(sale);
        return price;
    }

    public void pay(Product product, double amount) {
        int salesCounter = 0;
        for (Sale sale : sales) {
            if (sale.getProduct() == product) {
                if (sale.getClient() != this) {
                    throw new IllegalArgumentException("other clients product");
                }
                if (sale.getCost() - sale.getPricePaid() < 0) {
                    throw new IllegalArgumentException("already paid");
                }
                //Date now = new Date();
                //if (now.after(sale.getFinalDeadLineToPay())) {
                //    throw new IllegalArgumentException("too late to pay");
                //}

                sale.setPricePaid(sale.getPricePaid() + amount);
                if (sale.getPricePaid() > sale.getCost()) {
                    throw new IllegalArgumentException("too much paid");
                }
                break;
            }
            salesCounter++;
        }
        if (salesCounter == sales.size()) {
            throw new IllegalArgumentException("such product doesn't exist");
        }
    }

    public double calculateTotalPaidCost() {
        double totalCost = 0;
        for (Sale sale : sales) {
            if (sale.getClient() == this) {
                totalCost += sale.getPricePaid();
            }
        }
        return totalCost;
    }

    public double calculateTotalCostToBePaid() {
        double totalCost = 0;
        for (Sale sale : sales) {
            if (sale.getClient() == this) {
                totalCost += (sale.getCost() - sale.getPricePaid());
            }
        }
        return totalCost;
    }
}
