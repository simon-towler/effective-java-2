//has memory leak
public class Stack {
    //declare store for the stack elems
    private Object[] elements;
    //init variable to hold stack size
    private int size = 0;
    //init stack capacity
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    //no-arg constructor

    /**
     * Constructs a new Stack object instance
     * with an empty array of Object elements of the DEFAULT_INITIAL_CAPACITY
     */
    public Stack() {
        //init store for stack elems
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }


    //public API methods

    /**
     * Checks stack capacity would not be breached before
     * pushing the given Object e onto the stack
     * at position old-size + 1.
     * @param e Any Object to be pushed onto the Stack
     */
    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    /**
     * Checks there are still element positions in the stack before
     * returning the top element.
     * @return
     */
    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        return elements[--size];
    }


    //private methods

    /**
     * Ensure space for at least one more element, roughly
     * doubling the capacity each time the array needs to grow.
     */
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + i);
    }
}