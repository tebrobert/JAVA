public class EvalVisitor implements ExprVisitor<Integer> {
    private int x;
    Evaluator ev;
    
    public EvalVisitor(int x) {
        this.ev = new Evaluator(x);
    }
    
    public int eval(Expr<Integer> e) {
        e.accept(this);
        return ev.result();
    }
    
    public void visitNeg(Neg<Integer> e) {
        e.a().accept(this);
        ev.pushConst(-1);
        ev.mul();
    }
    
    public void visitBinary(Binary<Integer> e) {
        e.a().accept(this);
        e.b().accept(this);
        
        switch (e.operation()) {
            case '+':
                ev.add();
                break;
            case '-':
                ev.sub();
                break;
            case '*':
                ev.mul();
                break;
            case '/':
                ev.div();
                break;
        }
    }
    
    public void visitVar(Var<Integer> e) {
        ev.pushVar();
    }
    
    public void visitConst(Const<Integer> e) {
        ev.pushConst(e.value());
    }
}
