package designpatterns.behavioral.visitor.taxExample;

public interface Visitor {
    double visit(Liquor liquor);
    double visit(Tobacco tobacco);
    double visit(Necessity necessity);
}
