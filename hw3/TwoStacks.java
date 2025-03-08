class TwoStacks<T> {
    private T [] myItems;
    private int mySize1;
    private int mySize2;
    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public TwoStacks() {
        myItems = (T[]) new Object[DEFAULT_CAPACITY];
        mySize1 = 0;
        mySize2 = 0;
    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity( int newCapacity )
    {
        if (newCapacity < size1() + size2()) {
            return;
        }

        T [] old = myItems;
        int oldCapacity = old.length;
        myItems = (T []) new Object[ newCapacity ];

        for (int i=0; i<size1(); i++) {
            myItems[i] = old[i];
        }
        for (int i=1; i<=size2(); i++) {
            myItems[newCapacity-i] = old[oldCapacity-i];
        }

    }

    public void push1(T x) {

        if( myItems.length == size1() + size2()) {
            ensureCapacity( myItems.length * 2 + 1 );
        }
        myItems[size1()] = x; 
        mySize1++;
    }

    public void push2(T x) {

        if( myItems.length == size1() + size2()) {
            ensureCapacity( myItems.length * 2 + 1 );
        }
        myItems[myItems.length-size2()-1] = x;  
        mySize2++;
    }

    public T pop1() {
        mySize1--;
        return myItems[size1()];
    }

    public T pop2() {
        mySize2--;
        return myItems[myItems.length-size2()-1];
    }

    public T peek1() {
        if (isEmpty1()) { return null; } 
        return myItems[size1()-1];
    }

    public T peek2() {
        if (isEmpty2()) { return null; } 
        return myItems[myItems.length-size2()];
    }

    public boolean isEmpty1() {
        return size1() == 0;
    }

    public boolean isEmpty2() {
        return size2() == 0;
    }

    public int size1() {
        return mySize1;
    }

    public int size2() {
        return mySize2;
    }
}
