public class Customer {
    int id;
    String email;
    int age;

    public Customer(int id, String email, int age) {

        this.id = id;
        this.email = email;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer = " + "ID: " + id + " EMAIL: " + email + " AGE: " + age;
    }
}
