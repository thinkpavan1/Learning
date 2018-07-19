package designpatterns.decoratorpattern.core;

public class SyntheticCourtBooking extends CourtBooking{
    @Override
    public void info() {
        System.out.println("Synthetic Court Booking");
    }

    @Override
    public double cost() {
        System.out.println("Synthetic Court Booking");
        return 200;
    }
}
