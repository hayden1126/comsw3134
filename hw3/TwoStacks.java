class TwoStacks<T> {
    private T [] myItems;
    private int mySize1;
    private int mySize2;
    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public TwoStacks() {
        ensureCapacity(DEFAULT_CAPACITY);
        mySize1 = 0;
        mySize2 = 0;
    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity( int newCapacity )
    {
        if( newCapacity < topIndex1()+1 && newCapacity < topIndex2()+1 ) {
            return;
        }

        T [] old = myItems;
        myItems = (T []) new Object[ newCapacity ];

        for (int i=0; i<=topIndex1(); i+=2) {
            myItems[i] = old[i];
        }

        for (int i=1; i<=topIndex2(); i+=2) {
            myItems[i] = old[i];
        }

    }

    public void push1(T x) {

        if( myItems.length >= topIndex1() ) {
            ensureCapacity( myItems.length * 2 + 1 );
        }

        mySize1++; 
        myItems[topIndex1()] = x; 
    }

    public void push2(T x) {

        if( myItems.length >= topIndex2() ) {
            ensureCapacity( myItems.length * 2 + 1 );
        }

        mySize2++;
        myItems[topIndex2()] = x;  
    }

    public T pop1() {
        mySize1--;
        return myItems[topIndex1()+2];
    }

    public T pop2() {
        mySize2--;
        return myItems[topIndex2()+2];
    }

    public T peek1() {
        if (isEmpty1()) { return null; } 
        return myItems[topIndex1()];
    }

    public T peek2() {
        if (isEmpty2()) { return null; } 
        return myItems[topIndex2()];
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

    private int topIndex1() {
        if (isEmpty1()) { return -2; }
        return (size1()-1)*2;
    }

    private int topIndex2() {
        if (isEmpty2()) { return -1; }
        return (size2()*2)-1;
    }
}
