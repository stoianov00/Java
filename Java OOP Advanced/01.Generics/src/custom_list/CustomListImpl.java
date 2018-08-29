package custom_list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomListImpl<T extends Comparable<T>> implements CustomList<T> {
    private List<T> list;

    public CustomListImpl() {
        this.list = new ArrayList<>();
    }

    @Override
    public void add(T element) {
        this.list.add(element);
    }

    @Override
    public T remove(int index) {
        return this.list.remove(index);
    }

    @Override
    public boolean contains(T element) {
        return this.list.contains(element);
    }

    @Override
    public void swap(int firstIndex, int secondIndex) {
        T temp = this.list.get(firstIndex);
        this.list.set(firstIndex, this.list.get(secondIndex));
        this.list.set(secondIndex, temp);
    }

    @Override
    public int countGreaterThan(T element) {
        return this.list.stream().filter(e -> e.compareTo(element) > 0).collect(Collectors.toList()).size();
    }

    @Override
    public T getMax() {
        T max = this.list.get(0);
        for (T element : list) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }

        return max;
    }

    @Override
    public T getMin() {
        T min = this.list.get(0);
        for (T element : list) {
            if (element.compareTo(min) < 0) {
                min = element;
            }
        }

        return min;
    }

    @Override
    public void print() {
        this.list.forEach(System.out::println);
    }

    @Override
    public Iterable<T> getElements() {
        return this.list;
    }

}
