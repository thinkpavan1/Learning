package designpatterns.decoratorpattern.decorator;


import designpatterns.decoratorpattern.core.CourtBooking;

public class BallPacket extends TennisCourtDecorator {

    CourtBooking courtBooking;

    public BallPacket(CourtBooking courtBooking) {
        this.courtBooking = courtBooking;
    }

    @Override
    public double cost() {
        System.out.println("Adding Ball Packet");
        return courtBooking.cost() + 200;
    }
}
