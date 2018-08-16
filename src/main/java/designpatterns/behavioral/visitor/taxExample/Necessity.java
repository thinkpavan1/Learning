package designpatterns.behavioral.visitor.taxExample;

public class Necessity implements Commodities {
    private double price;

    public Necessity(double price) {
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
