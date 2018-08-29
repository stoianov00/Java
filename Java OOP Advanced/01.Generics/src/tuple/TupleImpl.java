package tuple;

public class TupleImpl<Item1, Item2> implements Tuple<Item1, Item2> {
    private Item1 item1;
    private Item2 item2;

    @Override
    public Item1 getItem1() {
        return this.item1;
    }

    @Override
    public void setItem1(Item1 item1) {
        this.item1 = item1;
    }

    @Override
    public Item2 getItem2() {
        return this.item2;
    }

    @Override
    public void setItem2(Item2 item2) {
        this.item2 = item2;
    }

}
