package designpatterns.creational.prototype;

public class PrototypeDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        ShapeCache cache = new ShapeCache ();
        Shape shape = cache.getShape ( "Square" );
        shape.draw ();
        shape = cache.getShape ( "Rectangle" );
        shape.draw ();
    }
}
