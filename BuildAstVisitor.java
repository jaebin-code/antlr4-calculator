import java.util.List;
import java.util.ArrayList;
public class BuildAstVisitor extends ExprBaseVisitor<AstNodes> {

    @Override
    public AstNodes visitVariableExpr(ExprParser.VariableExprContext ctx) {
        String var = ctx.getChild(0).getText();
        return new Variable(var);
    }

    @Override
    public AstNodes visitInfixExpr(ExprParser.InfixExprContext ctx) {
        AstNodes left = visit(ctx.getChild(0));
        AstNodes right = visit(ctx.getChild(2));
        String operator = ctx.getChild(1).getText();
        switch (operator) {
            case "+":
                operator = "ADD";
                break;
            case "-":
                operator = "SUB";
                break;
            case "*":
                operator = "MUL";
                break;
            case "/":
                operator = "DIV";
                break;
        }
        return new Infix(left, operator, right);
    }

    @Override
    public AstNodes visitBfunctionExpr(ExprParser.BfunctionExprContext ctx) {
        String var = ctx.getChild(0).getText();
        String num1 = ctx.getChild(2).getText();
        String num2 = ctx.getChild(4).getText();
        double number1 = Double.parseDouble(num1);
        double number2 = Double.parseDouble(num2);
        return new bfunction(var, number1, number2);
    }

    @Override
    public AstNodes visitAfunctionExpr(ExprParser.AfunctionExprContext ctx) {
        String var = ctx.getChild(0).getText();
        String num1 = ctx.getChild(2).getText();
        double number1 = Double.parseDouble(num1);
        return new afunction(var, number1);
    }

    @Override
    public AstNodes visitNumberExpr(ExprParser.NumberExprContext ctx) {
        String check = ctx.getChild(0).getText();
        String num;
        double num1;
        if (check.equals("-")) {
            num = ctx.getChild(1).getText();
            num1 = Double.parseDouble(num)*-1;
        } else {
            num1 = Double.parseDouble(check);
        }
        return new Number(num1);
    }

    @Override
    public AstNodes visitParensExpr(ExprParser.ParensExprContext ctx) {
        return visit(ctx.getChild(1));
    }

    @Override
    public AstNodes visitAssignExpr(ExprParser.AssignExprContext ctx) {
        String var = ctx.getChild(0).getText();
        String check = ctx.getChild(2).getText();
        String num;
        double num1;
        if (check.equals("-")) {
            num = ctx.getChild(3).getText();
            num1 = -1 * Double.parseDouble(num);
        } else {
            num1 = Double.parseDouble(check);
        }
        return new VariableDeclare(var, num1);
    }
}

