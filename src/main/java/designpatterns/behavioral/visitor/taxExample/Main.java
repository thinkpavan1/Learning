package designpatterns.behavioral.visitor.taxExample;

public class Main {
    public static void main(String[] args) {
        Liquor liquor = new Liquor (100);
        System.out.println ( liquor.accept ( new TaxVisitor ( ) ) );

        Tobacco tobacco = new Tobacco ( 100 );
        System.out.println ( tobacco.accept ( new TaxVisitor ( ) ) );

        Necessity necessity = new Necessity ( 100 );
        System.out.println ( necessity.accept ( new TaxVisitor ( ) ) );
    }
}
