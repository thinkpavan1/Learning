package designpatterns.behavioral.visitor.taxExample;

public interface Visitable {
    double accept(Visitor visitor);
}
