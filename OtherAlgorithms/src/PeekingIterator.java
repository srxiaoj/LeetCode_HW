import java.util.Iterator;


public class PeekingIterator implements Iterator<Integer> {
    private final Iterator<Integer> iterator;
    private boolean hasPeeked;
    private Integer peekedElement;//need to use Integer type
    public static void main(String[] args) {

    }
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        hasPeeked = false;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!hasPeeked) {
            peekedElement = iterator.next();
            hasPeeked = true;
        }
        return peekedElement;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (!hasPeeked)
            return iterator.next();
        else {
            hasPeeked = false;
            return peekedElement;
        }
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext() || hasPeeked;
    }

}
