package designpatterns.behavioral.visitor.taxExample;

public class TaxVisitor implements Visitor {
    @Override
    public double visit(final Liquor liquor) {
        return liquor.getPrice ()+ liquor.getPrice () * .30 ;
    }

    @Override
    public double visit(final Tobacco tobacco) {
        return tobacco.getPrice ()+ tobacco.getPrice () * .40 ;
    }

    @Override
    public double visit(final Necessity necessity) {
        return necessity.getPrice ()+ necessity.getPrice () * .05 ;
    }
}