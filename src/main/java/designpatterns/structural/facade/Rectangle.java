package designpatterns.structural.facade;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println ( "Drawing Rectangle" );
    }
}
