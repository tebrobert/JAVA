public class SetElement<T> {
	private T x;
	private SetElement<T> parent;
	private int depth;
    
	public SetElement(T x) {
		this.x = x;
		this.depth = 0;
		this.parent = this;
	}
    
	public T x() {
		return x;
	}
    
	public Boolean equivalent(SetElement<T> elem) {
		return find(this) == find(elem);
	}
    
	public void union(SetElement<T> y) {
		SetElement<T> rootx = find(this);
		SetElement<T> rooty = find(y);
        
		if (rootx.depth < rooty.depth)
			rootx.parent = rooty;
        else {
			rooty.parent = rootx;
			if (rootx.depth == rooty.depth)
				rootx.depth++;
		}
	}
    
	private SetElement<T> find(SetElement<T> x) {
		if (x.parent == x)
			return x;
		return x.parent = find(x.parent);
	}
}
