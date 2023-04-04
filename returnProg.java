
public class returnProg extends ExprBaseVisitor<exprNodes> {
    @Override
    public exprNodes visitProg(ExprParser.ProgContext ctx) {
        exprNodes prog = new exprNodes();
        BuildAstVisitor exprVisitor = new BuildAstVisitor();

        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (i == ctx.getChildCount() - 1) {

            }
            else {
                prog.addExpression(exprVisitor.visit(ctx.getChild(i)));
            }
        }
        return prog;
    }
}
