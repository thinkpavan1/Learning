package designpatterns.strategypattern.com.thinkpavan.patterns.reparable;

public class InternalRepair implements Reparable {
    @Override
    public void repair() {
        System.out.println("Self repair");
    }
}
