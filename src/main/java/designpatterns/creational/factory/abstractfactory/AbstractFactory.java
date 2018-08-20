package designpatterns.creational.factory.abstractfactory;


import designpatterns.creational.factory.pojo.Color;
import designpatterns.creational.factory.pojo.Shape;

public abstract class  AbstractFactory {
    public abstract Shape getShape();
    public abstract Color getColor();

    public abstract Color getColor(String colorType);
}