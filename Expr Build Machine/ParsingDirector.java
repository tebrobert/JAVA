public class ParsingDirector {
    private int pos;
    private char sym;
    private String str;
    private StackMachine SM;
    
    public ParsingDirector(StackMachine SM) {
        this.SM = SM;
    }
    
    public void parse(String s) {
        pos = 0;
        sym = s.charAt(0);
        str = s;
        parseE();
    }
    
    private void parseE() {
        parseT();
        parseEnu();
    }
    
    private void parseEnu() {
        int pr;
        if (sym == '+') {
            next();
            parseT();
            SM.add();
            parseEnu();
        }
        else if (sym == '-') {
            next();
            parseT();
            SM.sub();
            parseEnu();
        }
    }
    
    private void parseT() {
        parseF();
        parseTnu();
    }
    
    private void parseTnu() {
        int pr;
        if (sym == '*') {
            next();
            parseF();
            SM.mul();
            parseTnu();
        }
        else if (sym == '/') {
            next();
            parseF();
            SM.div();
            parseTnu();
        }
    }
    
    private void parseF() {
        int pr, n=0;
        if ((sym >= '0') && (sym <= '9')) {
            for (pr = 0; (sym >= '0') && (sym <= '9') && (n == 0); n = next())
                pr = pr * 10 + (sym - '0');
            
            SM.pushConst(pr);
        }
        else if (sym == 'x') {
            SM.pushVar();
            next();
        }
        else if (sym == '(') {
            next();
            parseE();
            // if(sym!=')')
                // error();
            next();
        }
        else if (sym == '-') {
            next();
            parseF();
            SM.pushConst(-1);
            SM.mul();
        }
    }
    
    private int next() {
        int n;
        pos++;
        
        for(; (pos < str.length()) && (str.charAt(pos) == ' '); pos++);
        
        if (pos < str.length()) {
            sym = str.charAt(pos);
            return 0;
        }
        
        return 1;
    }
}
