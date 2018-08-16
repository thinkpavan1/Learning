package designpatterns.behavioral.strategy.gameExample.core;


import designpatterns.behavioral.strategy.gameExample.refill.Refillable;
import designpatterns.behavioral.strategy.gameExample.reparable.Reparable;

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
