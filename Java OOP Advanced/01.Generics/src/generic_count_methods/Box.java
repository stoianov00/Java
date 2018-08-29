package generic_count_methods;

public class Box<T extends Comparable<T>> implements Comparable<Box<T>> {
    private T data;

    public Box(T data) {
        this.data = data;
    }

    @Override
    public int compareTo(Box<T> other) {
        return this.data.compareTo(other.data);
    }
}
