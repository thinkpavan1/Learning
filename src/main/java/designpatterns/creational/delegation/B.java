package designpatterns.creational.delegation;

public class B implements  DelegatorInterface {
    @Override
    public void printYourClassName() {
        System.out.println ( "I am class B" );
    }
}
