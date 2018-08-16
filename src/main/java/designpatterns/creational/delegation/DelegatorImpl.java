package designpatterns.creational.delegation;

public class DelegatorImpl implements DelegatorInterface{

    DelegatorInterface delgator;

    public void deleteToA(){
        delgator = new A();
    }
    
    public void deleteToB(){
        delgator = new B();
    }
    
    @Override
    public void printYourClassName() {
        if( delgator == null ){
            throw new IllegalStateException(" i dont know whome to delegate");
        }
        delgator.printYourClassName ();
    }
}
