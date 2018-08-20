package designpatterns.structural.facade;

public class ShapeMakerFacadeImpl implements ShapeMakerFacade {

    private Rectangle rectangle;
    private Square square;
    private Circle circle;

    public ShapeMakerFacadeImpl() {
        rectangle = new Rectangle ();
        square = new Square ();
        circle = new Circle ();
    }

    @Override
    public void drawCircle() {
        circle.draw ();
    }

    @Override
    public void drawSquare() {
        square.draw ();
    }

    @Override
    public void drawRectangle() {
        rectangle.draw ();
    }
}
