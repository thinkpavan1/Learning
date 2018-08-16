package designpatterns.behavioral.strategy.gameExample.reparable;

public class NoRepair implements Reparable {
    @Override
    public void repair() {
        System.out.println("Repair not needed");
    }
}
