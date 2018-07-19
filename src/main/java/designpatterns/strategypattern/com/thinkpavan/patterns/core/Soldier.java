package designpatterns.strategypattern.com.thinkpavan.patterns.core;


import designpatterns.strategypattern.com.thinkpavan.patterns.refill.Refillable;
import designpatterns.strategypattern.com.thinkpavan.patterns.reparable.Reparable;

public abstract class Soldier {
    Reparable reparable;
    Refillable refillable;
    public abstract void attack();

    public void refill(){
        refillable.refill();
    }

    public void repair(){
        reparable.repair();
    }
}
