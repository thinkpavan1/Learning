package designpatterns.decoratorpattern.decorator;


import designpatterns.decoratorpattern.core.CourtBooking;

public class Racket extends TennisCourtDecorator {
    CourtBooking courtBooking;

    public Racket(CourtBooking courtBooking) {
        this.courtBooking = courtBooking;
    }

    @Override
    public double cost() {
        System.out.println("Adding Racket");
        return courtBooking.cost()+ 100;
    }
}
