class TwoStackQueueTester {
    public static void main(String[] args) {

        TwoStackQueue<Integer> myQ = new TwoStackQueue<>();

        System.out.println("size: " + myQ.size());
        myQ.enqueue(1);
        myQ.enqueue(2);
        System.out.println("size: " + myQ.size());
        System.out.println("peeking: " + myQ.peek());
        System.out.println("dequeued: " + myQ.dequeue());
        System.out.println("size: " + myQ.size());
        System.out.println("peeking: " + myQ.peek());

    }
}