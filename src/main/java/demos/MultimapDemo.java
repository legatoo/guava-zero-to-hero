package demos;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Ordering;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Author: Yang Yifan
 * MisId: yangyifan03
 * Project: guava-zero-to-hero
 * Date: 8/31/15
 * Time: 2:03 PM
 */
public class MultimapDemo {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<Node>();
        nodes.add(Node.nodeGenerator(2));
        nodes.add(Node.nodeGenerator(5));
        nodes.add(Node.nodeGenerator(1));
        nodes.add(Node.nodeGenerator(1));
        nodes.add(Node.nodeGenerator(1));
        nodes.add(Node.nodeGenerator(2));
        nodes.add(Node.nodeGenerator(6));

        ListMultimap<Integer, Node> multiMap = Multimaps.index(nodes, new Function<Node, Integer>() {
            public Integer apply(Node input) {
                return input.getId();
            }
        });

        System.out.println("origin multimap: " + multiMap);
        //multiMap.removeAll(1);  //what index return is a ImmutableMap, which does not support remove
        //System.out.println("after remove: " + multiMap);

        Map<Integer, List<Node>> asMap = Multimaps.asMap(multiMap);
        /**
         * all the operations below are forbidden on immutableMap
         */
        //asMap_generic.remove(1);
        //System.out.println("remove key from generic map: " + asMap_generic);
        //asMap.remove(1);
        //System.out.println("remove key from asMap: " + asMap);

        ImmutableMultimap<Integer, Node> sortedMultiMap = Multimaps.index(
            Ordering.natural().onResultOf(new Function<Node, Integer>() {
                public Integer apply(Node input) {
                    return input.getId();
                }
            }).sortedCopy(nodes),

            new Function<Node, Integer>() {
                public Integer apply(Node input) {
                    return input.getId();
                }
            });

        System.out.println("sorted by key: " + sortedMultiMap);

    }
}
