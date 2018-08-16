package designpatterns.behavioral.strategy.mathExample;

public class Main {
    public static void main(String[] args) {
        Context context = new Context ();
        int num1 = 5;
        int num2 = 5;

        context.setStrategy ( new AdditionStrategy () );
        int result = context.doOperation ( num1, num2 );

        System.out.println ( result );

        context.setStrategy ( new MultiplicationStrategy () );
        result = context.doOperation ( num1, num2 );

        System.out.println ( result );
        context.setStrategy ( new SubtractionStrategy () );
        result = context.doOperation ( num1, num2 );

        System.out.println ( result );
    }
}
