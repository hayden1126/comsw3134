class MyStack<T> implements MyStackInterface<T> {
    private T [] myItems;
    private int mySize;
    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public MyStack() {
        ensureCapacity(DEFAULT_CAPACITY);
        mySize = 0;
    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity( int newCapacity )
    {
        if( newCapacity < mySize ) {
            return;
        }

        T [] old = myItems;
        myItems = (T []) new Object[ newCapacity ];
        for( int i = 0; i < size( ); i++ ) {
            myItems[ i ] = old[ i ];
        }

    }

	public void push(T x) {

        if( myItems.length == size() ) {
            ensureCapacity( size() * 2 + 1 );
        }

        myItems[size()] = x;
        mySize++;  
    }

	public T pop() {

        // T tmp = myItems[size()-1];
        // myItems[size()-1] = null;
        // mySize--;
        // return tmp;

        mySize--;
        return myItems[size()];
    }

	public T peek() {
        return myItems[size()-1];
    }

	public boolean isEmpty() {
        return size() == 0;
    }

	public int size() {
        return mySize;
    }
}