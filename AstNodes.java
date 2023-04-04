import java.util.List;
import java.util.ArrayList;
public class AstNodes{

}

class exprNodes extends AstNodes{
    public List<AstNodes> expression;
    public exprNodes(){
        this.expression=new ArrayList<>();
    }
    public void addExpression(AstNodes a){
        expression.add(a);
    }
}

class Number extends AstNodes{
    public double num;
    public Number(double num){
        this.num = num;
    }

    @Override
    public String toString(){
        return Double.toString(num);
    }
}

class Variable extends AstNodes{
    public String var;
    public Variable(String var){
        this.var = var;
    }
    @Override
    public String toString(){
        return var;
    }
}

class VariableDeclare extends AstNodes{
    public String var;
    public double num;

    public VariableDeclare(String var, double num){
        this.var = var;
        this.num = num;
    }

    @Override
    public String toString(){

        return var + "=" + num;

    }
}

class Infix extends AstNodes{
    public AstNodes left;
    public String operator;
    public AstNodes right;


    public Infix(AstNodes left, String operator, AstNodes right){
        this.left = left;
        this.operator = operator;
        this.right = right;
    }
    @Override
    public String toString(){

        return left.toString() + operator + right.toString();

    }
}

class afunction extends AstNodes{
    public String var;
    public double num;

    public afunction(String var,double num){
        this.var = var;
        this.num = num;
    }

    @Override
    public String toString(){
        return var + "(" + num + ")";
    }
}

class bfunction extends AstNodes{
    public String var;
    public double num1;
    public double num2;

    public bfunction(String var,double num1,double num2){
        this.var = var;
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public String toString(){
        return var + "(" + num1 + "," + num2 + ")";
    }
}