package scd_a2;

import java.util.EmptyStackException;

class ExceptionHandling {
    static class EmptyStackException extends Exception {
        public EmptyStackException(String message) {
            super(message);
        }
    }
}

class GenericStack<T> {
    private Object[] stack;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public GenericStack() {
        this.stack = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void push(T item) {
        ensureCapacity();
        stack[size++] = item;
    }

    @SuppressWarnings("unchecked")
    public T pop() throws ExceptionHandling.EmptyStackException {
        if (isEmpty()) {
            throw new ExceptionHandling.EmptyStackException("Stack is empty. Cannot perform pop operation.");
        }
        T item = (T) stack[--size];
        stack[size] = null; 
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size == stack.length) {
            int newCapacity = stack.length * 2;
            stack = java.util.Arrays.copyOf(stack, newCapacity);
        }
    }
}

public class MainQ1 {
    public static void main(String[] args) {
        try {
            GenericStack<Integer> intStack = new GenericStack<>();
            intStack.push(1);
            intStack.push(2);
            intStack.push(3);

            System.out.println("Stack size: " + intStack.size());
            System.out.println("Popped: " + intStack.pop());
            System.out.println("Popped: " + intStack.pop());
            System.out.println("Stack size: " + intStack.size());

            if (!intStack.isEmpty()) {
                System.out.println("Stack is not empty.");
            } else {
                System.out.println("Stack is empty.");
            }
        } catch (ExceptionHandling.EmptyStackException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Program Exited Successfully.");
        }
    }
}
