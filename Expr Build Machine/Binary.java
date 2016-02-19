public interface Binary<T> extends Expr<T> {
    Expr<T> a();        // первый операнд
    Expr<T> b();        // второй операнд
    char operation();   // ’+’, ’-’, ’*’, ’/’
}
