package designpatterns.behavioral.strategy.mathExample;

public class MultiplicationStrategy implements MathStrategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1*num2;
    }
}
