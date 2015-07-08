package iterables;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.lang.System.out;

/**
 * Author: Yang Yifan
 * MisId: yangyifan03
 * Project: guava-zero-to-hero
 * Date: 7/8/15
 * Time: 2:35 PM
 */
public class IterablesDemo {

    public static void main(String[] args) {
        checkNotNull(args);
        ImmutableList<Integer> list1 = ImmutableList.of(1, 2, 3, 4);
        ImmutableList<Integer> list2 = ImmutableList.of(1, 2, 3, 4);

        Iterable<Integer> listContract = Iterables.concat(list1, list2);

        out.println(listContract);

        //count object frequency in a iterable
        out.println(Iterables.frequency(listContract, 1));

        //divide an interables into sublist of size n, n is the parameters
        Iterable<List<Integer>> partions = Iterables.partition(listContract, 2);
        out.println(partions);

        //same elements in same order
        out.println(Iterables.elementsEqual(list1, list2));

        //concat multiple collection in live
        List<Integer> list_1 = Lists.newArrayList(1, 2, 3);
        List<Integer> list_2 = Lists.newArrayList(3, 4, 5);
        List<Integer> list_3 = Lists.newArrayList(7, 8, 9);

        Iterable<Integer> all = Iterables.unmodifiableIterable(
                Iterables.concat(list_1, list_2, list_3)
        );

        out.println(all);

        list_3.add(10);

        out.println(all);
    }
}
