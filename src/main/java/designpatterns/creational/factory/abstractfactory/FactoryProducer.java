package designpatterns.creational.factory.abstractfactory;


import designpatterns.creational.factory.factory.ShapeFatory;

public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if( choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFatory ();
        }else if (choice.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        } else{
            throw new UnsupportedOperationException("Not a valid choice");
        }
    }
}
