package designpatterns.creational.prototype;

public enum ShapeTypes {
    SQUARE ( "Square" ), RECTANGLE ( "Rectangle" );

    private final String type;

    private ShapeTypes(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
