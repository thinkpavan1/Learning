package designpatterns.creational.delegation;

public class SimpleDelegatorMain {
    public static void main(String[] args) {
        DelegatorImpl a = new DelegatorImpl ();
        a.deleteToA ();
        a.printYourClassName ();
    }
}
