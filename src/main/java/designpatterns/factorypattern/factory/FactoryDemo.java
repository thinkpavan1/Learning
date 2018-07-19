package designpatterns.factorypattern.factory;


import designpatterns.factorypattern.pojo.Shape;

public class FactoryDemo {
    public static void main(String[] args) {
        Shape obj = ShapeFatory.getShape("SQUARE");
        obj.draw();
        obj = ShapeFatory.getShape("RECTANGLE");
        obj.draw();
        obj = ShapeFatory.getShape("CIRCLE");
        obj.draw();
    }
}
