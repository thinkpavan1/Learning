package designpatterns.strategypattern.com.thinkpavan.patterns.reparable;

public class NoRepair implements Reparable {
    @Override
    public void repair() {
        System.out.println("Repair not needed");
    }
}
