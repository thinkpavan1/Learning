package designpatterns.behavioral.strategy.gameExample.reparable;

public class InternalRepair implements Reparable {
    @Override
    public void repair() {
        System.out.println("Self repair");
    }
}
