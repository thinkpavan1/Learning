package designpatterns.behavioral.strategy.mathExample;

public class Context {

    private MathStrategy strategy;

    public void setStrategy(MathStrategy strategy ){
        this.strategy = strategy;
    }

    public int doOperation(int num1, int num2){
        return strategy.doOperation ( num1,num2 );
    }
}
