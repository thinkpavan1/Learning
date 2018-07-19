package designpatterns.strategypattern.com.thinkpavan.patterns.main;


import designpatterns.strategypattern.com.thinkpavan.patterns.core.Robert;
import designpatterns.strategypattern.com.thinkpavan.patterns.core.Soldier;
import designpatterns.strategypattern.com.thinkpavan.patterns.refill.TimeBasedRefill;
import designpatterns.strategypattern.com.thinkpavan.patterns.reparable.ExternalRepair;

public class Main {
    public static void main(String[] args) {
        Soldier soldier = new Robert (new ExternalRepair (), new TimeBasedRefill ());
        soldier.attack();
        soldier.refill();
        soldier.repair();
    }
}
