package maps;

import com.google.common.base.Function;
import com.google.common.collect.*;

import java.util.List;

import static java.lang.System.out;

/**
 * Author: Yang Yifan
 * MisId: yangyifan03
 * Project: guava-zero-to-hero
 * Date: 7/8/15
 * Time: 3:53 PM
 */
public class MapsDemo {
    public static void main(String[] args) {
        List<String> list = ImmutableList.of("zero", "one", "three");

        Function<String, Integer> strLenFunction = new Function<String, Integer>() {
            public Integer apply(String input) {
                return input.length();
            }
        };

        ImmutableMap<Integer, String> indexMap = Maps.uniqueIndex(
                Ordering.natural().onResultOf(strLenFunction).sortedCopy(list), strLenFunction);
        out.println(indexMap);

        ImmutableMap<Integer, String> map1 = ImmutableMap.of(1, "a", 2, "b", 3, "c", 4, "d");
        ImmutableMap<Integer, String> map2 = ImmutableMap.of(2, "x", 3, "c", 5, "e", 6, "f");

        out.println(map1);
        out.println(map2);

        MapDifference<Integer, String> mapDif = Maps.difference(map1, map2);
        out.println("Entries in common: " + mapDif.entriesInCommon());
        out.println("Entries in left map only: " + mapDif.entriesOnlyOnLeft());
        out.println("Entries in right map only: " + mapDif.entriesOnlyOnRight());
        //same key but difference value
        out.println("Same key, different values: key-->" + mapDif.entriesDiffering().keySet().iterator().next() +
                " in left is " + mapDif.entriesDiffering().get(2).leftValue() +
                " in right is " + mapDif.entriesDiffering().get(2).rightValue());


    }
}
