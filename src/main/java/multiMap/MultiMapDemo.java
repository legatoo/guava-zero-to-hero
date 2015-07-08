package multiMap;

import utils.Filler;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.*;
import model.Foo;

import java.util.Map;

import static java.lang.System.out;

/**
 * Author: Yang Yifan
 * MisId: yangyifan03
 * Project: guava-zero-to-hero
 * Date: 7/3/15
 * Time: 3:48 PM
 */
public class MultiMapDemo {

    /**
     * 维护一种一到多的关系。一个有向图。
     *
     * @param args
     */
    public static void main(String[] args) {
        Multimap<Integer, Foo> multimap = ArrayListMultimap.create();

        multimap.put(1, Filler.fooGenerator(9));
        multimap.put(1, Filler.fooGenerator(9));
        multimap.put(2, Filler.fooGenerator(8));
        multimap.put(3, Filler.fooGenerator(null));
        multimap.put(4, Filler.fooGenerator(null));
        multimap.put(null, Filler.fooGenerator(null)); //null is available for key


        out.println(multimap.size());
        out.println("Elements binding to key 1: " + multimap.get(1).size());

        Joiner joiner = Joiner.on("---").skipNulls();

        //iterate all the entries
        for (Map.Entry<Integer, Foo> entry : multimap.entries()) {
            out.println(entry);
        }

        for (Integer key : multimap.keySet()) {
            out.println("Key: " + key + " has " + multimap.get(key).size() + " objects inside.");
        }

        Iterable<Foo> iterables = Iterables.concat(multimap.asMap().values());
        ImmutableList<Foo> elements_values = ImmutableList.copyOf(multimap.values());

        //delete all elements binding to 1
        multimap.removeAll(1);

        ImmutableSet<String> digits = ImmutableSet.of("zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine");
        Function<String, Integer> lengthFunction = new Function<String, Integer>(){
            public Integer apply(String input) {
                return input.length();
            }
        };


        ImmutableMultimap<Integer, String> lengthToString = Multimaps.index(digits, lengthFunction);
        Multimap<Integer, String> sorted  = MultimapBuilder.ListMultimapBuilder.treeKeys().arrayListValues().build();
        sorted = Multimaps.index(digits, lengthFunction);

        ImmutableMultimap<Integer, String> lengthToString2 = Multimaps.index(
                Ordering.natural().onResultOf(lengthFunction).sortedCopy(digits),
                lengthFunction);

        out.println(lengthToString.asMap().get(3));
        ImmutableList<String> valueToKey3 = lengthToString2.get(3).asList();
        out.print(valueToKey3);

        lengthToString2.asMap();
    }

}
