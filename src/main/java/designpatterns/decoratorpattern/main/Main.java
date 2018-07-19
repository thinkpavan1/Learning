package designpatterns.decoratorpattern.main;

import designpatterns.decoratorpattern.core.CourtBooking;
import designpatterns.decoratorpattern.core.SyntheticCourtBooking;
import designpatterns.decoratorpattern.decorator.BallPacket;
import designpatterns.decoratorpattern.decorator.Coaching;
import designpatterns.decoratorpattern.decorator.Racket;

public class Main {
    public static void main(String[] args) {
        try{
            CourtBooking a1 = new SyntheticCourtBooking ();
            a1 = new BallPacket (a1);
            a1 = new Racket (a1);
            System.out.println("Total Cost = "+a1.cost());

            a1 = new Coaching (a1);
            System.out.println("Total Cost = "+a1.cost());

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
