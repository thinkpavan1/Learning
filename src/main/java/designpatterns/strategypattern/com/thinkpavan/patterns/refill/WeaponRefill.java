package designpatterns.strategypattern.com.thinkpavan.patterns.refill;

public class WeaponRefill implements Refillable {
    @Override
    public void refill() {
        System.out.println("Refill weapons");
    }
}
