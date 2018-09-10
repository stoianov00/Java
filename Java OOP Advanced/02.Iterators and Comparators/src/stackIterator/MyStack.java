package stackIterator;

import java.util.Arrays;
import java.util.Iterator;

public class MyStack<T> implements Iterable<T> {
    private static final int INITIAL_CAPACITY = 16;
    private static final String EMPTY_STACK_EXCEPTION_MESSAGE = "No elements";

    private T[] elements;
    private int elementCount;

    @SuppressWarnings("unchecked")
    public MyStack() {
        this.elements = (T[]) new Object[INITIAL_CAPACITY];
    }

    private void growElementsLength() {
        this.elements = Arrays.copyOf(this.elements, this.elements.length * 2);
    }

    public void push(T element) {
        if (this.elementCount == this.elements.length) {
            this.growElementsLength();
        }

        this.elements[elementCount++] = element;
    }

    public T pop() {
        if (this.elementCount == 0) {
            throw new ArrayIndexOutOfBoundsException(EMPTY_STACK_EXCEPTION_MESSAGE);
        }

        T element = this.elements[--elementCount];
        this.elements[elementCount] = null;

        return element;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyStackIterator();
    }

    private final class MyStackIterator implements Iterator<T> {
        private int cursor;

        private MyStackIterator() {
            this.cursor = elementCount - 1;
        }

        @Override
        public boolean hasNext() {
            return this.cursor >= 0;
        }

        @Override
        public T next() {
            return elements[this.cursor--];
        }
    }

}
