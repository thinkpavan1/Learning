package designpatterns.strategypattern.com.thinkpavan.patterns.reparable;

public class ExternalRepair implements Reparable {
    @Override
    public void repair() {
        System.out.println("External Repair");
    }
}
