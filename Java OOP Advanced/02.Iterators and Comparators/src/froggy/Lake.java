package froggy;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Lake<T> implements Iterable<T> {
    private List<T> indexes;

    public Lake(List<T> indexes) {
        this.indexes = indexes;
    }

    @Override
    public Iterator<T> iterator() {
        return new Frog();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        for (T number : this) {
            action.accept(number);
        }
    }

    private final class Frog implements Iterator<T> {
        private int cursor;
        private boolean isEven;

        private Frog() {
            this.cursor = 0;
            this.isEven = true;
        }

        @Override
        public boolean hasNext() {
            boolean hasNext = this.cursor < indexes.size();

            if (!this.isEven && !hasNext) {
                return false;
            } else if (this.isEven && !hasNext) {
                if (indexes.size() == 1) {
                    return false;
                }

                this.isEven = false;
                this.cursor = 1;

                return true;
            }

            return true;
        }

        @Override
        public T next() {
            T t = indexes.get(this.cursor);
            this.cursor += 2;

            return t;
        }

    }
}
