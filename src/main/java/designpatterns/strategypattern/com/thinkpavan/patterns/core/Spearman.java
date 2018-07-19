package designpatterns.strategypattern.com.thinkpavan.patterns.core;


import designpatterns.strategypattern.com.thinkpavan.patterns.refill.Refillable;
import designpatterns.strategypattern.com.thinkpavan.patterns.reparable.Reparable;

public class Spearman extends Soldier {

    public Spearman(Reparable reparable, Refillable refillable) {
        super.refillable = refillable;
        super.reparable = reparable;
    }
    @Override
    public void attack() {
        System.out.println("Arrack from spear man");
    }
}
