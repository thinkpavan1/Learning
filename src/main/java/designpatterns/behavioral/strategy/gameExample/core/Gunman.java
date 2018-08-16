package designpatterns.behavioral.strategy.gameExample.core;


import designpatterns.behavioral.strategy.gameExample.refill.Refillable;
import designpatterns.behavioral.strategy.gameExample.reparable.Reparable;

public class Gunman extends Soldier {
    public Gunman(Reparable reparable, Refillable refillable) {
        super.refillable = refillable;
        super.reparable = reparable;
    }

    @Override
    public void attack() {
        System.out.println("Attach from gunman");
    }
}
