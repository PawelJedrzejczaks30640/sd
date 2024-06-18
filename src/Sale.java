import java.util.Date;

public class Sale {
    private static int counterNumberID = 0;
    private String numberID;
    private double cost;
    private double pricePaid;
    private Date finalDeadLineToPay;
    private Client client;
    private Product product;

    public Sale(double cost, double pricePaid, Client client, Product product) {
        this.numberID = "#" + ++counterNumberID;
        this.cost = cost;
        this.pricePaid = pricePaid;
        this.client = client;
        this.product = product;
    }

    public Sale(double cost, double pricePaid, Client client, Product product, Date finalDeadLineToPay) {
        this.numberID = "#" + ++counterNumberID;
        this.cost = cost;
        this.pricePaid = pricePaid;
        this.client = client;
        this.product = product;
        this.finalDeadLineToPay = finalDeadLineToPay;
    }

    public String getNumberID() {
        return numberID;
    }

    public double getCost() {
        return cost;
    }

    public void setPricePaid(double pricePaid) {
        this.pricePaid = pricePaid;
    }

    public double getPricePaid() {
        return pricePaid;
    }

    public Product getProduct() {
        return product;
    }

    public Client getClient() {
        return client;
    }

    public void setFinalDeadLineToPay(Date finalDeadLineToPay) {

        this.finalDeadLineToPay = finalDeadLineToPay;
    }

    public Date getFinalDeadLineToPay() {
        return finalDeadLineToPay;
    }
}
