import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ShopService {

    public static List<Purchase> readFromCSV ()  {
        File file = new File("Purchase.csv");
        Scanner scanner = null;
        try {
            scanner = new Scanner ( file );
        } catch ( FileNotFoundException e ) {
            e.printStackTrace ( );
        }
        List<Purchase> goods = new ArrayList<> ( );

        while ( true ) {
            assert scanner != null;
            if (!scanner.hasNext ( )) break;
            String line = scanner.nextLine ( );
            String[] items = line.split ( "," );

            for (int i = 0; i < items.length; i++) {
                Television television = new Television("","",0,"","",0);
                Telephone telephone = new Telephone("","",0 ,"","",0);

                if (items[0].contains ( "Television" )) {
                    television.series = items[1];
                    television.model = items[2];
                    television.diagonal = Integer.parseInt ( items[3] );
                    television.screenType = items[4];
                    television.country = items[5];
                    television.price = Integer.parseInt ( items[6] );
                    goods.add ( television );
                } else if (items[0].contains ( "Telephone" )) {
                    telephone.series = items[1];
                    telephone.model = items[2];
                    telephone.diagonal = Integer.parseInt(items[3]);
                    telephone.screenType = items[4];
                    telephone.country=items[5];
                    telephone.price = Integer.parseInt ( items[6] );
                    goods.add ( telephone );
                }
            }
        }
        scanner.close ( );
        return goods;
    }

    public static Invoice createInvoices (int limit) throws Exception {

        Customer customer = PersonService.generateRandomCustomer ();
        List<Purchase> goods = randomOrder (readFromCSV ());
        toType type = toType.retail;
        int totalPrice = 0;
        for (Purchase good : goods) {
            totalPrice += good.price;
        } if (totalPrice > limit) {
            type = toType.wholesale;
        } log (customer, goods);
        return new Invoice (goods, customer, type);
    }

    public static List<Purchase> randomOrder (List<Purchase> goods) {
        Random random = new Random ();
        List<Purchase> randomOrder = new ArrayList<> ();
        int randomNum = random.nextInt (5);
        for (int i = 0; i < randomNum; i++) {
            randomOrder.add (goods.get(random.nextInt(goods.size ())));
        }
        return randomOrder;
    }

    public static void log (Customer customer, List<Purchase> goods) {

        try (FileWriter writer = new FileWriter ( "informationOutput.txt" , true )) {

            writer.write (String.valueOf (customer));
            writer.write (String.valueOf (goods));
            writer.flush ();
        } catch (IOException ex) {
            System.out.println (ex.getMessage());
        }
    }

    public static List<Invoice> invoices (int limited) throws FileNotFoundException {
        List<Invoice> invoices = new ArrayList<> ();

        invoices.add (createInvoices(limited));
        invoices.add (createInvoices(limited));
        invoices.add (createInvoices(limited));
        invoices.add (createInvoices(limited));
        invoices.add (createInvoices(limited));
        invoices.add (createInvoices(limited));
        invoices.add (createInvoices(limited));
        invoices.add (createInvoices(limited));
        invoices.add (createInvoices(limited));
        invoices.add (createInvoices(limited));
        invoices.add (createInvoices(limited));
        invoices.add (createInvoices(limited));
        invoices.add (createInvoices(limited));
        invoices.add (createInvoices(limited));
        invoices.add (createInvoices(limited));
        return invoices;
    }
}