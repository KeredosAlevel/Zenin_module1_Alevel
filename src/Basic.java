import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Basic {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a limit (below): ");

        int limit = scanner.nextInt();

        informationOutput(limit);
    }

    private static void informationOutput(int limit) throws FileNotFoundException {

        List <Invoice> invoices = ShopService.invoices(limit);

        System.out.println(main.soldCategory(invoices));
        System.out.println(main.smalCheck(invoices));
        System.out.println(main.allSum(invoices));
        System.out.println(main.checks(invoices));
        System.out.println(main.checksOneType(invoices));
        System.out.println(main.checksFrstThre(invoices));
        System.out.println(main.checksLegalAge(invoices));
        System.out.println(main.sortedChecks(invoices));
    }
}