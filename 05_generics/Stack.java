import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<E> {
    //declare store for the stack elems
    private E[] elements;
    //init variable to hold stack size
    private int size = 0;
    //init stack capacity
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    //no-arg constructor

    /**
     * Constructs a new Stack object instance
     * with an empty array of Object elements of the DEFAULT_INITIAL_CAPACITY
     */
    // The elements array will contain only E instances from push(E).
    // This is sufficient to ensure tyep safety, but the runtime
    // type of the array won't be E[]; it will always be Object[]!
    @SuppressWarnings("unchecked")
    public Stack() {
        //init store for stack elems
        //Object[] cast unchecked (but known safe) to E[].
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }


    //public API methods

    /**
     * Checks stack capacity would not be breached before
     * pushing the given Object e onto the stack
     * at position old-size + 1.
     * @param e Any Object to be pushed onto the Stack
     */
    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    // pushAll method without wildcard type - deficient!
    public void pushAll(Iterable<E> src) {
        for (E e: src)
            push(e);
    }

    /**
     * Checks there are still element positions in the stack before
     * returning the top element.
     * @return
     */
    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        E result = elements[--size];
            elements[size] = null; // Eliminate obsolete reference
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //Little program to exercise our generic Stack
    /**
     * Main method.
     * Instantiates a Stack of String.
     * Pushes each String arg onto the Stack.
     * Afterwards pops and prints each Stack elem in upper case.
     * Result is all args printed out in reverse order in upper case.
     * @param args
     */
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for (String arg : args)
                stack.push(arg);
        while (!stack.isEmpty())
            System.out.println(stack.pop().toUpperCase());
    }


    //private methods

    /**
     * Ensure space for at least one more element, roughly
     * doubling the capacity each time the array needs to grow.
     */
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}