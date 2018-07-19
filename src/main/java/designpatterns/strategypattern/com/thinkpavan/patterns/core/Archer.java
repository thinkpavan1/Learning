package designpatterns.strategypattern.com.thinkpavan.patterns.core;


import designpatterns.strategypattern.com.thinkpavan.patterns.refill.Refillable;
import designpatterns.strategypattern.com.thinkpavan.patterns.reparable.Reparable;

public class Archer extends Soldier {
    Archer(Reparable reparable, Refillable refillable){
        super.refillable = refillable;
        super.reparable = reparable;
    }
    @Override
    public void attack() {
        System.out.println("Archer attach");
    }
}
