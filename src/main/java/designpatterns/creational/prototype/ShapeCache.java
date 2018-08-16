package designpatterns.creational.prototype;

import com.google.common.collect.Maps;

import java.util.Map;

public class ShapeCache {

    private Map<String, Shape> shapes = Maps.newHashMap ( );

    public ShapeCache(){
        loadCache ();
    }

    public void loadCache() {
        shapes.put ( "Square", new Square ( 1 ) );
        shapes.put ( "Rectangle", new Rectangle ( 2 ) );
    }

    public Shape getShape(String type) throws CloneNotSupportedException {
        return (Shape) shapes.get ( type ).clone ( );
    }
}