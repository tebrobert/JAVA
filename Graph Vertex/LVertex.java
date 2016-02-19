import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.ArrayDeque;

public class LVertex<T> implements Vertex<T> {
    public LVertex(T l) {
        Arr = new ArrayList<LVertex<T>>();
        label = l;
    }
    
	public T label() {
		return label;
	}
    
	public void link(Vertex<T> v) {
		if (!Arr.contains((LVertex<T>)v)) {
			Arr.add((LVertex<T>)v);
			v.link(this);
		}
	}
    
	public void unlink(Vertex<T> v) {
		if (Arr.contains((LVertex<T>)v)) {
			Arr.remove((LVertex<T>)v);
			v.unlink(this);
		}
	}
    
	public Iterable<Vertex<T>> dfs() {
		return new DfsItMaker<T>(this);
	}
    
	public Iterable<Vertex<T>> bfs() {
		return new BfsItMaker<T>(this);
	}
    
	public Iterator<Vertex<T>> iterator() {
		return new It<T>(Arr, this);
	}
    
	public int length() {
		return Arr.size();
	}
    
	public LVertex<T> get(int i) {
		return Arr.get(i);
	}
    
	private T label;
	private ArrayList<LVertex<T>> Arr;
}

class DfsItMaker<T> implements Iterable<Vertex<T>> {
	DfsItMaker(LVertex<T> v) {
		this.v = v;
		Its = new ArrayList<LVertex<T>>();
	}
    
	public Iterator<Vertex<T>> iterator() {
		Its.add(v);
		dr(v);
		return new It<T>(Its, v);
	}
    
	void dr(LVertex<T> x) {
		for (int j = 0; j < x.length(); j++) {
			LVertex<T> k = x.get(j);
			if (!Its.contains(k)) {
				Its.add(k);
				dr(k);
			}
		}
	}
    
	private LVertex<T> v;
	private ArrayList<LVertex<T>> Its;
}

class BfsItMaker<T> implements Iterable<Vertex<T>> {
	BfsItMaker(LVertex<T> v) {
		this.v = v;
		Its = new ArrayList<LVertex<T>>();
	}
    
	public Iterator<Vertex<T>> iterator() {
		Q = new ArrayDeque<LVertex<T>>();
		Its.add(v);
		br(v);
		return new It<T>(Its, v);
	}
    
	void br(LVertex<T> x) {
		for (int j = 0; j < x.length(); j++) {
			LVertex<T> k = x.get(j);
			if (!Its.contains(k)) {
				Its.add(k);
				Q.add(k);
			}
		}
        
		for(; !Q.isEmpty(); ) {
			LVertex<T> k = Q.poll();
			br(k);
		}
	}
    
	private LVertex<T> v;
	private ArrayList<LVertex<T>> Its;
	private ArrayDeque<LVertex<T>> Q;
}

class It<T> implements Iterator<Vertex<T>> {
	It(ArrayList<LVertex<T>> Its, LVertex<T> v) {
		i = 0;
		Arr = Its;
		this.v = v;
	}
    
	public boolean hasNext() {
		return i<Arr.size();
	}
    
	public Vertex<T> next() {
		if (!this.hasNext())
			return last;
        
		last = Arr.get(i);
		i++;
		return last;
	}
    
	public void remove() {
		v.unlink(last);
	}
    
	private int i;
	private ArrayList<LVertex<T>> Arr;
	private LVertex<T> last, v;
}
