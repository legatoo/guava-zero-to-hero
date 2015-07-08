package rangeSet;

import com.google.common.collect.*;

import static java.lang.System.out;

/**
 * Author: Yang Yifan
 * MisId: yangyifan03
 * Project: guava-zero-to-hero
 * Date: 7/8/15
 * Time: 11:50 AM
 */
public class RangeSetDemo {
    public static void main(String[] args) {
        RangeSet<Integer> rangeSet = TreeRangeSet.create();

        rangeSet.add(Range.closed(1, 5));
        rangeSet.add(Range.openClosed(6, 8));

        out.println(rangeSet.asRanges());
        Range<Integer> range = rangeSet.rangeContaining(0);


        RangeMap<Integer, String> rangeMap = TreeRangeMap.create();
        rangeMap.put(Range.closedOpen(1, 5), "Good.");
        rangeMap.put(Range.closedOpen(6, 8), "Excellent.");

        for (int i = 0; i < 10; i++) {
            out.println("if " + i + " in range. " + rangeSet.contains(i));


            for (Range<Integer> r : rangeMap.asMapOfRanges().keySet()) {
                if (r.contains(i)){
                    out.println(i + " is " + rangeMap.asMapOfRanges().get(r));
                }
            }
        }

    }
}
