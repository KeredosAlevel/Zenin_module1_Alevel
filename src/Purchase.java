public abstract class Purchase {
    String series;
    String screenType;
    Integer price;

    public Purchase(String series , String screenType , int price ) {
        this.series = series;
        this.screenType = screenType;
        this.price = price;
    }
    public Integer getPrice () {
        return price;
    }

    @Override
    public String toString () {
        return "Purchase:" + "Series = " + series + " screenType = " + screenType + " price = " + price ;
    }
}