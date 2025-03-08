class MyStackTester {

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        
        stack.push(1);
        stack.push(2);

        stack.pop();

        System.out.println(stack.peek());
    }

}