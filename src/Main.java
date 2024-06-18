import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Client c=new Client("Jan", "Kowalski");
        Subscription sub=new Subscription("ABC", "AAA", 50, 2);
        SoftwareLicense lic=new SoftwareLicense("LIC",
                "BBB", 1200,"ASD123",
                new Date(),
                typeOfLicense.SINGLE_USER);
        c.buySubscription(sub);
        c.buySoftwareLicense(lic);
        c.pay(sub, 100);
        c.pay(lic, 500);
        System.out.println("Total cost: "+c.calculateTotalPaidCost());
        System.out.println("Total cost to be paid: "+c.calculateTotalCostToBePaid());
    }
}