package designpatterns.structural.decoratorpattern.main;

import designpatterns.structural.decoratorpattern.core.CourtBooking;
import designpatterns.structural.decoratorpattern.core.SyntheticCourtBooking;
import designpatterns.structural.decoratorpattern.decorator.BallPacket;
import designpatterns.structural.decoratorpattern.decorator.Coaching;
import designpatterns.structural.decoratorpattern.decorator.Racket;

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
