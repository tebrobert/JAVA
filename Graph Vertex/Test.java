import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        Vertex<Integer>
            root = new LVertex<Integer>(1),
            n1 = new LVertex<Integer>(10),
            n2 = new LVertex<Integer>(20),
            n3 = new LVertex<Integer>(30),
            n4 = new LVertex<Integer>(40),
            n5 = new LVertex<Integer>(50),
            n6 = new LVertex<Integer>(60),
            n7 = new LVertex<Integer>(70),
            n8 = new LVertex<Integer>(80),
            n9 = new LVertex<Integer>(90);
        
        root.link(n1);
        root.link(n2);
        n1.link(n3);
        n1.link(n4);
        n1.link(n5);
        n2.link(n6);
        n2.link(n7);
        n2.link(n8);
        n3.link(n9);
        n4.link(n9);
        n6.link(n7);
        n8.link(n7);
        
        for (Vertex<Integer> v : root.bfs())
            System.out.println(v.label());
        System.out.println();
        
        for (Vertex<Integer> v : root.dfs())
            System.out.println(v.label());
        System.out.println();
    }
}
