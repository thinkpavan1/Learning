package designpatterns.creational.factory.factory;


import designpatterns.creational.factory.abstractfactory.AbstractFactory;
import designpatterns.creational.factory.pojo.*;

public class ShapeFatory extends AbstractFactory {
    public static Shape getShape(String shapeType){
        if( shapeType.equals("CIRCLE")){
            return new Circle ();
        } else if( shapeType.equals("RECTANGLE")){
            return new Rectangle ();
        } else if ( shapeType.equals("SQUARE")){
            return new Square ();
        } else{
            throw new UnsupportedOperationException("Shape type :"+shapeType+" is not supported");
        }
    }

    @Override
    public Shape getShape() {
        return null;
    }

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public Color getColor(String colorType) {
        return null;
    }
}
