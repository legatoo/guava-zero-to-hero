package sets;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import java.util.Set;

import static java.lang.System.out;

/**
 * Author: Yang Yifan
 * MisId: yangyifan03
 * Project: guava-zero-to-hero
 * Date: 7/8/15
 * Time: 3:50 PM
 */
public class SetsDemo {
    public static void main(String[] args) {
        Set<String> set1 = ImmutableSet.of("one", "two", "three", "six", "seven", "eight");
        Set<String> set2 = ImmutableSet.of("two", "three", "five", "seven");
        out.println("Set1: " + set1);
        out.println("Set2: " + set2);

        //intersection will be returned as a setView and can be copy to a new set
        //for frequent use
        Sets.SetView<String> intection = Sets.intersection(set1, set2);
        ImmutableSet<String> immutableInterction = intection.immutableCopy();
        out.println("Union: " + Sets.union(set1, set2));
        out.println("Intersection:" + immutableInterction);
        out.println("Difference (set1 to set2): " + Sets.difference(set1, set2));
        out.println("Difference (set2 to set1): " + Sets.difference(set2, set1));
        //not in intersection
        out.println("SymmetricDifference: " + Sets.symmetricDifference(set1, set2));

        out.println("All possible subsets of set2:");
        for (Set<String> sub : Sets.powerSet(set2)) {
            out.println(sub);
        }
    }
}
