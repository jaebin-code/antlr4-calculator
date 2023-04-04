import java.io.IOException;
import java.util.ArrayList;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

public class program {

    public static void main(String[] args) throws IOException {
                
        // Get Lexer
        ExprLexer lexer = new ExprLexer(CharStreams.fromStream(System.in));
        
        // Get a list of matched tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // Pass tokens to parser
        ExprParser parser = new ExprParser(tokens);
        
        // Make AST from prog and print the tree
        ParseTree AST = parser.prog();
        returnProg prog_visit = new returnProg();
        exprNodes prog = prog_visit.visit(AST);
        Evaluate Calculator = new Evaluate();
        // Evaluate AST result
        ArrayList<String> resultlist = new ArrayList<>();

        AstCall call = new AstCall();
        for(AstNodes node: prog.expression){
            if(node!=null) {
                double result = Calculator.Calculator(node);
                call.Call(node, 0);
                resultlist.add(Double.toString(result));
            }
        }
        for(int i = 0; i<resultlist.size(); i++){
            System.out.println(resultlist.get(i));
        }
    }
}