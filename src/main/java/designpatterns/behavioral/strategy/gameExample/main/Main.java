package designpatterns.behavioral.strategy.gameExample.main;


import designpatterns.behavioral.strategy.gameExample.core.Robert;
import designpatterns.behavioral.strategy.gameExample.core.Soldier;
import designpatterns.behavioral.strategy.gameExample.refill.TimeBasedRefill;
import designpatterns.behavioral.strategy.gameExample.reparable.ExternalRepair;

public class Main {
    public static void main(String[] args) {
        Soldier soldier = new Robert (new ExternalRepair (), new TimeBasedRefill ());
        soldier.attack();
        soldier.refill();
        soldier.repair();
    }
}
