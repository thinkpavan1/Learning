package designpatterns.behavioral.strategy.gameExample.reparable;

public class ExternalRepair implements Reparable {
    @Override
    public void repair() {
        System.out.println("External Repair");
    }
}
