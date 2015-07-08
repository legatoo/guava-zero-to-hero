package forwardList;

import com.google.common.collect.ForwardingList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.lang.System.out;

/**
 * Author: Yang Yifan
 * MisId: yangyifan03
 * Project: guava-zero-to-hero
 * Date: 7/8/15
 * Time: 7:47 PM
 */
public class AddLoggingList<E> extends ForwardingList<E> {
    final List<E> delegate = new ArrayList<E>();


    @Override
    protected List<E> delegate() {
        return delegate;
    }

    //first call this method, then add(int, element)
    @Override public boolean add(E element) {
        return standardAdd(element);
    }

    @Override
    public void add(int index, E element) {
        log(index, element);
        super.add(index, element);
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        return standardAddAll(collection);
    }

    private void log(int index, E element) {
        out.println("Add " + element + " at index " + index);
    }
}
