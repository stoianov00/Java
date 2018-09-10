package listyIterator.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private static final String EXCEPTION_MESSAGE = "Invalid Operation!";

    private List<String> collection;
    private int currentIndex;

    public ListyIterator() {

    }

    public ListyIterator(List<String> collection) {
        this.collection = new ArrayList<>(collection);
        this.currentIndex = 0;
    }

    public boolean hasNext() {
        return this.currentIndex < this.collection.size() - 1;
    }

    public boolean move() {
        boolean canMove = this.hasNext();
        if (canMove) {
            this.currentIndex++;
        }

        return canMove;
    }

    public void print() {
        if (this.collection.isEmpty()) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }

        System.out.println(this.collection.get(this.currentIndex));
    }

    public void printAll() {
        for (String s : this.collection) {
            System.out.printf("%s ", s);
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new ListIterator();
    }

    private final class ListIterator implements Iterator<String> {
        private int counter;

        private ListIterator() {
            this.counter = 0;
        }

        @Override
        public boolean hasNext() {
            return this.counter < collection.size();
        }

        @Override
        public String next() {
            return collection.get(counter++);
        }
    }

}
