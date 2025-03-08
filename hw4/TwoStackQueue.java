import java.util.Stack;
import java.util.NoSuchElementException;

class TwoStackQueue<T> implements TwoStackQueueInterface<T> {
    private int theSize = 0;
    private static final int LIMIT_TO_UPDATE = 10;
    private Stack<T> enqueueStack = new Stack<>();
    private Stack<T> dequeueStack = new Stack<>();

	public void enqueue(T x) {
        theSize++;
        enqueueStack.push(x);
    }

	public T dequeue() {
        updateStacks();
        if (isEmpty()) { throw new NoSuchElementException("Queue is empty"); }

        theSize--;
        T tmp = dequeueStack.pop();
        return tmp;
    }

    @SuppressWarnings("unchecked")
    private void updateStacks() {
        if (!dequeueStack.isEmpty() && enqueueStack.size() - dequeueStack.size() < LIMIT_TO_UPDATE) {
            return;
        }

        dequeueStack.clear();

        for (int i=0; i<size(); i++) {
            dequeueStack.push(enqueueStack.pop());
        }
        enqueueStack.clear();

        Stack<T> tmp = (Stack<T>) dequeueStack.clone();
        for (int i=0; i<size(); i++) {
            enqueueStack.push(tmp.pop());
        }
    }

	public int size() {
        return theSize;
    }

	public boolean isEmpty() {
        return theSize == 0;
    }

    public T peek() {
        updateStacks();
        return dequeueStack.peek();
    }
}
