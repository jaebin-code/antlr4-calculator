public class AstCall {
    public void Call(AstNodes node,int level){
        String tab="";
        for ( int i = 0; i < level; i++){
            tab+="\t";
        }
        if( node instanceof Infix){
            Infix a = (Infix) node;
            System.out.println(tab+a.operator);
            level+=1;
            this.Call(a.left,level); // 재귀적으로 노드 탐색
            this.Call(a.right,level);
        }
        else if( node instanceof Number){
            Number a = (Number) node;
            System.out.println(tab+a.num);
        }
        else if( node instanceof Variable){
            Variable a = (Variable) node;
            System.out.println(tab + a.var);
        }
        else if ( node instanceof VariableDeclare){
            VariableDeclare a = (VariableDeclare) node;
            System.out.println("ASSIGN");
            System.out.println("\t"+a.var);
            System.out.println("\t"+a.num);
        }
        else if ( node instanceof afunction){
            afunction a = (afunction) node;
            System.out.println(tab + "sqrt");
            System.out.println(tab + "\t" + a.num);
        }
        else if ( node instanceof bfunction){
            bfunction a = (bfunction) node;
            String name = a.var;
            switch(name) {
                case "min":
                    System.out.println(tab + "min");
                    System.out.println(tab + "\t" + a.num1);
                    System.out.println(tab + "\t" + a.num2);
                    break;
                case "max":
                    System.out.println(tab + "max");
                    System.out.println(tab + "\t" + a.num1);
                    System.out.println(tab + "\t" + a.num2);
                    break;
                case "pow":
                    System.out.println(tab + "pow");
                    System.out.println(tab + "\t" + a.num1);
                    System.out.println(tab + "\t" + a.num2);
                    break;
            }
        }
    }
}
