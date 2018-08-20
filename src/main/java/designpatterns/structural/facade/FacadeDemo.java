package designpatterns.structural.facade;

public class FacadeDemo {
    public static void main(String[] args) {
        final ShapeMakerFacade shapeMakerFacade = new ShapeMakerFacadeImpl ();
        shapeMakerFacade.drawCircle ();
        shapeMakerFacade.drawRectangle ();
        shapeMakerFacade.drawSquare ();
    }
}
