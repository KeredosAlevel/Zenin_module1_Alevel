import java.util.Random;

public class PersonService {
    public static Customer generateRandomCustomer () {
        Customer customer = new Customer(0," ",0);
        Random random = new Random ();
        customer.id = random.nextInt (100000);
        customer.email = generateRandomEmail ();
        customer.age = random.nextInt(90);
        return customer;
    }

    private static String generateRandomEmail () {
        StringBuilder email = new StringBuilder ( );
        String alphabet = "a_b!c#d$e%f^g&h*i(j)_l-m=n+op.q,r's;t]u[v*w|xyz";
        while (email.length () < 10 ) {
            int character = (int) (Math.random () * 26);
            email.append(alphabet.charAt(character));
        }
        email.append ( Integer.valueOf ((int) (Math.random () * 120 )).toString());
        email.append ( "@gmail.com.ua" );
        return email.toString ( );
    }
}