package designpatterns.structural.decorator.core;

public abstract class CourtBooking {
    private String info;

    public abstract double cost();

    public void info(){
        System.out.println("You are booking a court");
    }
}
