import java.util.Stack;

public class ExprBuilder implements StackMachine {
	private Expr<Integer> a, b;
	private Stack<Expr<Integer>> S;
	private AbstractExprFactory<Integer> f;
    
	public ExprBuilder(AbstractExprFactory<Integer> f) {
		this.f = f;
		this.S = new Stack<Expr<Integer>>();
	}
    
	public void pushConst(int v) {
		S.push(f.newConst(v));
	}
    
	public void pushVar() {
		S.push(f.newVar());
	}
    
	public void neg() {
		a = S.pop();
		S.push(f.newNeg(a));
	}
    
	public void add() {
		b = S.pop();
		a = S.pop();
		S.push(f.newBinary(a, b, '+'));
	}
    
	public void sub() {
		b = S.pop();
		a = S.pop();
		S.push(f.newBinary(a, b, '-'));
	}
    
	public void mul() {
		b = S.pop();
		a = S.pop();
		S.push(f.newBinary(a, b, '*'));
	}
    
	public void div() {
		b = S.pop();
		a = S.pop();
		S.push(f.newBinary(a, b, '/'));
	}
    
	public Expr<Integer> result(){
		return S.pop();
	}
}
