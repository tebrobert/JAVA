public class Test {
    public static void main(String[] args) {
        SetElement<Integer>
            a0 = new SetElement<Integer>(0),
            a1 = new SetElement<Integer>(1),
            a2 = new SetElement<Integer>(2),
            a3 = new SetElement<Integer>(3),
            a4 = new SetElement<Integer>(4),
            a5 = new SetElement<Integer>(5);
        
        a0.union(a1);
        a2.union(a0);
        a2.union(a3);
        a4.union(a5);
        
        System.out.println("" + a0.x() + "=" + a3.x() + ": " + a0.equivalent(a3));
        System.out.println("" + a0.x() + "=" + a5.x() + ": " + a0.equivalent(a5));
    }
}
