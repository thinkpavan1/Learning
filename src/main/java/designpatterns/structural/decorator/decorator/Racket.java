package designpatterns.structural.decorator.decorator;


import designpatterns.structural.decorator.core.CourtBooking;

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
