package designpatterns.creational.delegation;

public class A implements DelegatorInterface {
    @Override
    public void printYourClassName() {
        System.out.println ( "I am class A" );
    }
}
