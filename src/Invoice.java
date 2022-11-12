import java.util.List;

public class Invoice {
    List<Purchase> purchase;
    Customer customer;
    toType type;

    public Invoice (List<Purchase> purchase , Customer customer , toType type) {
        this.purchase = purchase;
        this.customer = customer;
        this.type = type;
    }

    @Override
    public String toString () {
        return "\n"+ "Invoice:" + " Purchase = " + purchase + ", " + customer + ", type = " + type ;
    }
}