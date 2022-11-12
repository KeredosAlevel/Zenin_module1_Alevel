import java.util.*;
import java.util.stream.Collectors;

public class main<MaksimZenim> {

    public static String soldCategory(List<Invoice> invoices) {
        int telephones = (int) invoices.stream().flatMap(x -> (x.purchase.stream())).filter(x ->x.toString().contains("Telephone")).count();
        int televisions = (int) invoices.stream().flatMap(x -> (x.purchase.stream())).filter(x ->x.toString().contains("Television")).count();

        return "Number of items sold by category Televisions: " + televisions + "\n" +"Number of items sold by category Telephones: " + telephones;
    }

    public static String smalCheck(List<Invoice> invoices) {
        Optional<Invoice> minSum = invoices.stream().min(Comparator.comparing(invoice -> invoice.purchase.stream().
                                                                              sorted(Comparator.comparing(Purchase::getPrice)).mapToInt(Purchase::getPrice).sum()));

        int getMinSum = minSum.stream().flatMap(x -> x.purchase.stream()).mapToInt(Purchase::getPrice).sum();

        Customer customer = minSum.get().customer;

        return "The smallest check amount: " + getMinSum + "\n"+ customer;
    }

    public static String allSum(List<Invoice> invoices) {
        int sum = 0;
        sum = sum + invoices.stream().flatMap(x -> x.purchase.stream()).mapToInt(Purchase::getPrice).sum();

        return "All purchases sum: " + sum;
    }

    public static String checks(List<Invoice> invoices) {
        int retail = (int) invoices.stream().filter(x -> (x.type.equals(toType.retail))).count();

        return "Retail checks: " + retail;
    }

    public static String checksOneType(List<Invoice> invoices) {
        List<Invoice> telephoneList = invoices.stream().filter(x -> x.purchase.toString().contains("Telephone")).filter(x -> 
                                            !x.purchase.toString().contains("Television")).collect(Collectors.toList());
        
        List<Invoice> televisionList = invoices.stream().filter(x -> x.purchase.toString().contains("Television")).filter(x -> 
                                            !x.purchase.toString().contains("Telephone")).collect(Collectors.toList());

        return "Checking receipts for one type of product: " + telephoneList + televisionList;
    }

    public static String checksFrstThre(List<Invoice> invoices) {
        
        List<Invoice> firstThreeChecks = invoices.stream().limit(3).collect(Collectors.toList());

        return "Checking the first three checks: " + firstThreeChecks;
    }

    public static String checksLegalAge(List<Invoice> invoices) {
        
        List<Invoice> checksU18 = invoices.stream().filter(x -> (x.customer.age) < 18).collect(Collectors.toList());

        return "Underage Buyer Information: " + checksU18;
    }

    public static String sortedChecks(List<Invoice> invoices) {
        
        List<Invoice> ageSort = invoices.stream().sorted(Comparator.comparing(invoice -> invoice.customer.age))
                .collect(Collectors.toList());
        
        Collections.reverse(ageSort);
        
        List<Invoice> quantitySort = ageSort.stream().sorted(Comparator.comparing(invoice -> (long) invoice.purchase.size())).collect(Collectors.toList());
        
        List<Invoice> totalSum = quantitySort.stream().sorted(Comparator.comparing(invoice -> invoice.purchase.stream().
                               sorted(Comparator.comparing(Purchase::getPrice)).mapToInt(Purchase::getPrice).sum())).collect(Collectors.toList());

        return "Sorted checks by age: " + ageSort + "\n"+"Sorted checks by total sum: " + totalSum +
                "\n"+"Sorted checks by quantity: " + quantitySort;
    }
}
