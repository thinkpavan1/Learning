package java8features.learn.winterbe.com;

public interface Formula {
    double calculate(int a);
    default double sqrt(int a){
        return Math.sqrt ( a );
    }
}
