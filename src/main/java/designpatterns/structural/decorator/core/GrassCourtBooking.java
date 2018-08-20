package designpatterns.structural.decorator.core;

public class GrassCourtBooking extends CourtBooking {
    @Override
    public void info() {
        System.out.println("Grass Court Booking");
    }

    @Override
    public double cost() {
        System.out.println("Grass Court Booking cost ");
        return 100;
    }
}
