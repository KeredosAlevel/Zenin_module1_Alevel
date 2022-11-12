public class Telephone extends Purchase {
    String model;
    String country;
    int diagonal;

    public Telephone(String series, String model, int diagonal, String screenType, String country, int price) {
        super(series, screenType, price);

        this.model = model;
        this.country = country;
        this.diagonal = diagonal;
    }


    @Override
    public String toString() {
        return "Telephone: " + "Series = " + series + " Screen type = " + screenType + " Diagonal = " + diagonal + " model = " + model +" Country = "+country+ " price = " + price;
    }
}

