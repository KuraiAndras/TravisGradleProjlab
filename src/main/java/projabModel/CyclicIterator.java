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
    final private C mElements;
    private Iterator<E> mIterator;

    /**
     * @param elements List to iterate through
     */
    CyclicIterator(C elements) {
        mElements = elements;
        mIterator = elements.iterator();
    }

    @Override
    public boolean hasNext() {
        if (!mIterator.hasNext()) {
            mIterator = mElements.iterator();
        }
        return mIterator.hasNext();
    }

    @Override
    public E next() {
        if (!mIterator.hasNext()) {
            mIterator = mElements.iterator();
        }
        return mIterator.next();
    }

    void remove(E item, E current) {
        if (item == current) {
            mElements.remove(item);
            mIterator = mElements.iterator();
        } else {
            mElements.remove(item);
            mIterator = mElements.iterator();
            while (this.next() != current) {

            }
        }
    }
}
