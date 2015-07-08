package ordering;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Ordering;

import java.util.Map;

import static java.lang.System.out;

/**
 * Author: Yang Yifan
 * MisId: yangyifan03
 * Project: guava-zero-to-hero
 * Date: 7/8/15
 * Time: 4:48 PM
 */
public class OrderingDemo {
    public static void main(String[] args) {
        Map<Integer, String> testMap = ImmutableMap.of(1, "a", 2, "b", 5, "c", 3, "c", 4, "c");

        Ordering<Map.Entry<Integer, String>> order = Ordering.natural().onResultOf(
                new Function<Map.Entry<Integer, String>, String>() {
                    public String apply(Map.Entry<Integer, String> input) {
                        return input.getValue();
                    }
                }
        );

        for (Map.Entry<Integer, String> entry : order.sortedCopy(testMap.entrySet())) {
            //when the key has the same value, the result won't be on the key's order
            out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }

        out.println("-----------------------");


        final Ordering<Integer> order2 = Ordering.natural().nullsLast().onResultOf(Functions.forMap(testMap, null))
                .compound(Ordering.natural()); //deal with same value sort on key

        ImmutableSortedMap<Integer, String> sortedMap = ImmutableSortedMap.copyOf(testMap, order2);
        for (Map.Entry<Integer, String> entry : sortedMap.entrySet()) {
            //when the key has the same value, the result will be on the key's order
            out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
    }
}
