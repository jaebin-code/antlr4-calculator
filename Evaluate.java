import java.util.HashMap;
import java.util.Map;
public class Evaluate {
    public Map<String, Double> variables;
    public Evaluate(){
        variables=new HashMap<>();
    }

    public double Calculator(AstNodes node){
        double result=0;
        if( node instanceof Infix){
            Infix a = (Infix) node;
            double left = Calculator(a.left);
            double right = Calculator(a.right);
            String operator = a.operator;
            switch(operator){
                case "ADD":
                    result=left+right;
                    break;
                case "SUB":
                    result=left-right;
                    break;
                case "MUL":
                    result=left*right;
                    break;
                case "DIV":
                    result=left/right;
                    break;
            }

        }
        else if( node instanceof Number){
            Number a = (Number) node;
            result=a.num;
        }
        else if( node instanceof Variable){
            Variable a = (Variable) node;
            result=variables.get(a.var);
        }
        else if ( node instanceof VariableDeclare){
            VariableDeclare a = (VariableDeclare) node;
            variables.put(a.var,a.num);
        }
        else if ( node instanceof afunction){
            afunction a = (afunction) node;
            result=(float)Math.sqrt(a.num);
        }
        else if ( node instanceof bfunction){
            bfunction a = (bfunction) node;
            String name = a.var;
            double num1 = a.num1;
            double num2 = a.num2;
            switch(name){
                case "max":
                    result=(double)Math.max(num1,num2);
                    break;
                case "min":
                    result=(double)Math.min(num1,num2);
                    break;
                case "pow":
                    result=(double)Math.pow(num1,num2);
                    break;
            }
        }
        return result;
    }
}
