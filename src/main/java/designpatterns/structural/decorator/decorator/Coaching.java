package designpatterns.structural.decorator.decorator;


import designpatterns.structural.decorator.core.CourtBooking;

public class Coaching extends TennisCourtDecorator {

    CourtBooking courtBooking;

    public Coaching(CourtBooking courtBooking) {
        this.courtBooking = courtBooking;
    }

    @Override
    public double cost() {
        System.out.println("Adding coaching");
        return courtBooking.cost()+300;
    }
}
