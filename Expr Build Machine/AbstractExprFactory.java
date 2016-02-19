public interface AbstractExprFactory<T> {
    Neg<T> newNeg(Expr<T> a);
    Binary<T> newBinary(Expr<T> a, Expr<T> b, char operation);
    Var<T> newVar();
    Const<T> newConst(T value);
}
