package designpatterns.behavioral.strategy.gameExample.refill;

public class NoRefill implements Refillable {
    @Override
    public void refill() {
        System.out.println("Refill not needed");
    }
}
