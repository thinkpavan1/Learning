package designpatterns.structural.decorator.decorator;


import designpatterns.structural.decorator.core.CourtBooking;

public abstract class TennisCourtDecorator extends CourtBooking {

    @Override
    public void info() {
        System.out.println("Using Tennis Court Decorator");
    }
}
