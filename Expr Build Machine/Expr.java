public interface Expr<T> {
    void accept(ExprVisitor<T> v);
}
