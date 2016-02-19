public class ExprFactory<T> implements AbstractExprFactory<T> {
    public Neg<T> newNeg(Expr<T> a) {
        return new NodeNeg(a);
    }
    
    public Binary<T> newBinary(Expr<T> a, Expr<T> b, char operation) {
        return new NodeBin(a,b,operation);
    }
    
    public Var<T> newVar() {
        return new NodeVar();
    }
    
    public Const<T> newConst(T value) {
        return new NodeCon(value);
    }
}

class NodeNeg implements Neg {
    private Expr a;
    
    NodeNeg(Expr a) {
        this.a = a;
    }
    
    public Expr a() {
        return a;
    }
    
    public void accept(ExprVisitor v) {
        v.visitNeg(this);
    }
}

class NodeBin implements Binary {
    private Expr a,b;
    private char opr;
    
    NodeBin(Expr a, Expr b, char opr) {
        this.a = a;
        this.b = b;
        this.opr = opr;
    }
    
    public Expr a() {
        return a;
    }
    
    public Expr b() {
        return b;
    }
    
    public char operation() {
        return opr;
    }
    
    public void accept(ExprVisitor v) {
        v.visitBinary(this);
    }
}

class NodeVar implements Var {
    public void accept(ExprVisitor v) {
        v.visitVar(this);
    }
}

class NodeCon implements Const {
    private Object val;
    
    NodeCon(Object val) {
        this.val=val;
    }
    
    public Object value() {
        return val;
    }
    
    public void accept(ExprVisitor v) {
        v.visitConst(this);
    }
}
