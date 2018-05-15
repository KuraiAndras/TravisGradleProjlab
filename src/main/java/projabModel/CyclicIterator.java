package projabModel;

import java.util.Collection;
import java.util.Iterator;

/**
 * Iterator class for iterating in a cycle
 *
 * @param <E> Stored object
 * @param <C> List
 */
public class CyclicIterator<E, C extends Collection<E>> implements Iterator<E> {
    /**
     * Elements we woud like to iterate through.
     */
    final private C mElements;
    /**
     * Iterator we use to iterate.
     */
    private Iterator<E> mIterator;

    /**
     * This method iterate through a list.
     * @param elements A List to iterate through.
     */
    CyclicIterator(C elements) {
        mElements = elements;
        mIterator = elements.iterator();
    }

    /**
     * Returns true if the iteration has more elements.
     */
    @Override
    public boolean hasNext() {
        if (!mIterator.hasNext()) {
            mIterator = mElements.iterator();
        }
        return mIterator.hasNext();
    }

    /**
     * This method returns the next element in the iteration.
     */
    @Override
    public E next() {
        if (!mIterator.hasNext()) {
            mIterator = mElements.iterator();
        }
        return mIterator.next();
    }

    /**
     * This method removes from the underlying collection the last element returned by this iterator.
     * @param item Item we would like to remove.
     * @param current Currently iteratted element.
     */
    void remove(E item, E current) {
        if (item == current) {
            mElements.remove(item);
            mIterator = mElements.iterator();
        } else {
            mElements.remove(item);
            mIterator = mElements.iterator();
            this.next();
        }
    }
}
