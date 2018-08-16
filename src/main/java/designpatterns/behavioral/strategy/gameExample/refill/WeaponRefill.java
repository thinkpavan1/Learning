package designpatterns.behavioral.strategy.gameExample.refill;

public class WeaponRefill implements Refillable {
    @Override
    public void refill() {
        System.out.println("Refill weapons");
    }
}
