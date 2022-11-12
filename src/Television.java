public class Television extends Purchase {
    String model;
    int diagonal;
    String country;



    public Television (String series, String model, int diagonal, String screenType, String country, int price) {
        super (series, screenType, price);
        this.model = model;
        this.diagonal = diagonal;
        this.country = country;
    }

    @Override
    public String toString () {
        return "Television: " + "Series = " + series + " Screen type = " + screenType + " Diagonal = " + diagonal + " model = " + model +" Country = "+country+ " price = " + price;
    }
}