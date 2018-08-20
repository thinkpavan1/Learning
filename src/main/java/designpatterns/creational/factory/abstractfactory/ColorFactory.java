package designpatterns.creational.factory.abstractfactory;


import designpatterns.creational.factory.pojo.*;

public class ColorFactory extends AbstractFactory{

    @Override
    public Shape getShape() {
        return null;
    }

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public Color getColor(String colorType){
        if( colorType.equals("GREEN")){
            return new Green ();
        }else if (colorType.equals("RED")){
            return new Red ();
        } else if (colorType.equals("BLUE")){
            return new Blue ();
        }else {
            throw new UnsupportedOperationException("Color type : "+colorType+" not supported");
        }
    }



}