package designpatterns.strategypattern.com.thinkpavan.patterns.refill;

public class TimeBasedRefill implements  Refillable{
    @Override
    public void refill() {
        System.out.println("Wait and refill");
    }
}
