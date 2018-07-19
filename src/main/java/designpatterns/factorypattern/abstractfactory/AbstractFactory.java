package designpatterns.factorypattern.abstractfactory;


import designpatterns.factorypattern.pojo.Color;
import designpatterns.factorypattern.pojo.Shape;

public abstract class  AbstractFactory {
    public abstract Shape getShape();
    public abstract Color getColor();

    public abstract Color getColor(String colorType);
}