import java.util.LinkedList;

class ExpressionTree implements ExpressionTreeInterface {

	public int eval() {
        return eval(root);
    }

    private int eval(ExpressionNode node) {
        if (node.element.matches("[0-9]+")) {
            return Integer.parseInt(node.element);
        }
        int x = eval(node.left);
        int y = eval(node.right);

        switch(node.element) {
            case "+":
                return x+y;
            case "-":
                return x-y;
            case "*":
                return x*y;
            case "/":  
                return x/y;
        }
        return 0; // Never reaches this line unless invalid node;
    }

	public String postfix() {
        return postfix(root);
    }

    private String postfix(ExpressionNode current) {
        if (current == null) {
            return "";
        }
        if (current.left == null) { // both left and right are null
            return current.element;
        }
        return postfix(current.left) + " " + postfix(current.right) + " " + current.element;
    }

	public String prefix() {
        return prefix(root);
    }

    private String prefix(ExpressionNode current) {
        if (current == null) {
            return "";
        }
        if (current.left == null) { // if both left and right are null
            return current.element;
        }
        return current.element + " " + prefix(current.left) + " " + prefix(current.right);
    }    

	public String infix() {
        return infix(root);
    }

    private String infix(ExpressionNode current) {
        if (current == null) {
            return "";
        }
        if (current.left == null) { // both left and right are null
            return current.element;
        }
        return "(" + infix(current.left) + " " + current.element + " " + infix(current.right) + ")";
    }  
    

    public ExpressionTree(String expression) { // expression in postfix
        try {
            if (expression == null || expression.trim().isEmpty()) {
                throw new InvalidExpressionException("Expression cannot be empty or whitespace");
            }

            LinkedList<ExpressionNode> theStack = new LinkedList<ExpressionNode>();
            String[] elements = expression.split(" ");

            for (String ele : elements) {
                if (ele.trim().isEmpty()) { continue; }

                if (ele.matches("[0-9]+")) { // Operands
                    theStack.push(new ExpressionNode(ele));
                } else if ("+-*/".indexOf(ele) != -1) { // Operators
                    if (theStack.size() < 2) {
                        throw new InvalidExpressionException("Not enough operands for operator: " + ele);
                    }
                    ExpressionNode x = theStack.pop();
                    ExpressionNode y = theStack.pop();
                    theStack.push(new ExpressionNode(ele, y, x));
                } else {
                    throw new InvalidExpressionException("Invalid Operand: " + ele);
                }
            }

            if (theStack.size() != 1) {
                throw new InvalidExpressionException("Invalid Expression: " + expression);
            } else {
                root = theStack.peek();
            }

        } catch (InvalidExpressionException e) {
            System.err.println("Error building expression tree: " + e.getMessage());
        }
    }

    private class InvalidExpressionException extends Exception {
        public InvalidExpressionException(String m) {
            super(m);
        } 
    }

    public static class ExpressionNode {

        public ExpressionNode(String theElement) {
            this(theElement, null, null);
        }

        public ExpressionNode(String theElement, ExpressionNode lt, ExpressionNode rt) {
            element = theElement;
            left = lt;
            right = rt;
        }

        public String toString() {
            String l = (left == null) ? "null" : left.element;
            String r = (right == null) ? "null" : right.element;
            return String.format("%s : %s %s", element, l, r);
        }

        String element;
        ExpressionNode left;
        ExpressionNode right;
    }
    private ExpressionNode root;
}