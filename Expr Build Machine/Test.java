public class Test {
	public static void main(String[] args) {
		try {
			java.util.Scanner input = new java.util.Scanner(System.in);
			int x = input.nextInt(), r1, r2;
			input.nextLine();
			String expr = input.nextLine();
            
            // t5
			ExprBuilder builder = new ExprBuilder(new ExprFactory<Integer>());
			ParsingDirector dir = new ParsingDirector(builder);
			EvalVisitor v = new EvalVisitor(x);
			dir.parse(expr);
			r1 = v.eval(builder.result());
            
            
            // t2
            Evaluator eval = new Evaluator(x);
            ParsingDirector pd = new ParsingDirector(eval);
            pd.parse(expr);
            r2 = eval.result();
            
            System.out.println(r1);
            System.out.println(r2);
        }
        catch (java.lang.Exception e) {
			System.out.println("exception: " + e);
		}
	}
}
