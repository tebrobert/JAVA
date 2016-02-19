public interface ExprVisitor<T> {
    void visitNeg(Neg<T> e);
    void visitBinary(Binary<T> e);
    void visitVar(Var<T> e);
    void visitConst(Const<T> e);
}
