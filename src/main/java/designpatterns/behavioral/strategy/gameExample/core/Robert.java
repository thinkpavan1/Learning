package designpatterns.behavioral.strategy.gameExample.core;


import designpatterns.behavioral.strategy.gameExample.refill.Refillable;
import designpatterns.behavioral.strategy.gameExample.reparable.Reparable;

public class Robert extends Soldier {
    public Robert(Reparable reparable, Refillable refillable) {
        super.refillable = refillable;
        super.reparable = reparable;
    }

    @Override
    public void attack() {
        System.out.println("Robert attaching");
    }
}
