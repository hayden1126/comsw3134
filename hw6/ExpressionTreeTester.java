public class ExpressionTreeTester {
    public static void main(String[] args) {
        String myExpression = "";
        System.out.println(myExpression);
        ExpressionTree myTree = new ExpressionTree(myExpression);
        System.out.println(myTree.eval());
        System.out.println("Postfix: " + myTree.postfix());
        System.out.println("Prefix: " + myTree.prefix());
        System.out.println("Infix: " + myTree.infix());
    }
}
