import java.util.Stack;

public class Evaluator implements StackMachine {
    private int x, a, b;
    private Stack<Integer> S;
        
    public Evaluator(int x) {
        this.x = x;
        this.S = new Stack<Integer>();
    }
    
    public void pushConst(int v) {
        this.S.push(v);
    }
    
    public void pushVar() {
        this.S.push(x);
    }
        
    public void neg() {
        a = this.S.pop();
        this.S.push(-a);
    }
    
    public void add() {
        b = this.S.pop();
        a = this.S.pop();
        this.S.push(a + b);
    }
    
    public void sub() {
        b = this.S.pop();
        a = this.S.pop();
        this.S.push(a - b);
    }
    
    public void mul() {
        b = (int)(this.S.pop());
        a = (int)(this.S.pop());
        this.S.push(a * b);
    }
    
    public void div() {
        b = this.S.pop();
        a = this.S.pop();
        this.S.push(a /b);
    }
    
    public int result() {
        a = this.S.pop();
        return a;
    }
}
