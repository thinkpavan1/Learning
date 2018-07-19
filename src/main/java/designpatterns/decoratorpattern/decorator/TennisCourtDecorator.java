package designpatterns.decoratorpattern.decorator;


import designpatterns.decoratorpattern.core.CourtBooking;

public abstract class TennisCourtDecorator extends CourtBooking {

    @Override
    public void info() {
        System.out.println("Using Tennis Court Decorator");
    }
}
