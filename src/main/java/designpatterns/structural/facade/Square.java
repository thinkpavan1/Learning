package designpatterns.structural.facade;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println ( "Drawing Square" );
    }
}
