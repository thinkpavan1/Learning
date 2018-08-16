package designpatterns.creational.prototype;

public abstract class Shape implements Cloneable {
    public final static String PRINT_MESSAGE = "This is ";

    private int id;
    private ShapeTypes type;

    public Shape(ShapeTypes type, int id) {
        this.type = type;
        this.id = id;
    }

    public abstract void draw();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ShapeTypes getType() {
        return type;
    }

    public void setType(ShapeTypes type) {
        this.type = type;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone ( );
    }

}

class Square extends Shape {
    Square(int id) {
        super ( ShapeTypes.SQUARE, id );
    }

    @Override
    public void draw() {
        System.out.println ( PRINT_MESSAGE+getType () );
    }
}

class Rectangle extends Shape {
    Rectangle(int id) {
        super ( ShapeTypes.RECTANGLE, id );
    }

    @Override
    public void draw() {
        System.out.println ( PRINT_MESSAGE+getType ());
    }
}

