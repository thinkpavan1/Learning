package designpatterns.creational.factorypattern.abstractfactory;


import designpatterns.creational.factorypattern.pojo.Color;
import designpatterns.creational.factorypattern.pojo.Shape;

public abstract class  AbstractFactory {
    public abstract Shape getShape();
    public abstract Color getColor();

    public abstract Color getColor(String colorType);
}