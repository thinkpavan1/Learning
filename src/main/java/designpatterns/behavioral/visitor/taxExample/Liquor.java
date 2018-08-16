package designpatterns.behavioral.visitor.taxExample;

public class Liquor implements Commodities{

    private double price;

    public Liquor(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }


    public double accept(Visitor visitor) {
        return visitor.visit ( this );
    }
}
