package stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStackArray_155 {

    public static void main(String[] args) {
        MinStackArray_155 minStack = new MinStackArray_155();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        // Returns -3.
        System.out.println("minStack = " + minStack.getMin());
        minStack.pop();
        minStack.top();
        // Returns 0.
        System.out.println("minStack = " + minStack.getMin());

    }

    int[] array = new int[10];
    int current = -1;

    /**
     * initialize your data structure here.
     */
    public MinStackArray_155() {

    }

    public void push(int x) {
        if (current == array.length - 1) {
            extend();
        }
        array[++current] = x;
    }

    private void extend() {
        int[] newArray = new int[array.length + 10];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public void pop() {
        if (!isEmpty())
            current--;
    }

    public int top() {
        return array[current];
    }

    public int getMin() {
        if (isEmpty())
            return 0;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= current; i++) {
            if(min > array[i])
                min = array[i] ;
        }
        return min;
    }

    private boolean isEmpty() {
        return current == -1;
    }
}
