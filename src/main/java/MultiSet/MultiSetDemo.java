package MultiSet;

import com.google.common.base.Joiner;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.util.List;
import static java.lang.System.out;

/**
 * Author: Yang Yifan
 * MisId: yangyifan03
 * Project: guava-zero-to-hero
 * Date: 7/1/15
 * Time: 3:41 PM
 */
public class MultiSetDemo {

    /**
     * MultiSet:
     * 可以理解为一个Array，也可以看做是一个Map。关键看你的视角是怎样的。
     * MultiSet中可以放任何对象，使用对象的equals和hashcode来区别存储在里面的对象。
     * 如果把它看做是一个Array，那么他的表现和一个真正的Array没有任何的区别
     * 如果把它看做是一个Map，那么他是Map<E, Integer>,其中后面的Integer代表了该对象的出现频率。（可以看做是Map，但是实际不是）
     *
     * @param args
     */
    public static void main(String[] args) {
        Multiset<String> mset1 = HashMultiset.create();
        Multiset<String> mset2 = HashMultiset.create();

        mset1.add("a", 2);
        mset1.add("b", 3);
        mset1.add("c", 5);
        mset1.add("d", 3);
        
        mset2.add("a", 1);
        mset2.add("b", 2);
        mset2.add("c", 3);

        //Keep elements in mset1 if it's in mset2, and remove it if not.
        //Guarantee mset1.count(*) <= mset2.count(*)
        Multisets.retainOccurrences(mset1, mset2);

        out.println("The Size of multiset1 is " + mset1.size());
        out.println("The Size of multiset2 is " + mset2.size());
        out.println("The Size of multiset1 entry is " + mset1.entrySet().size());
        out.println("The Size of multiset2 entry is " + mset2.entrySet().size());

        //Order by frequency, and extract top as list
        ImmutableList<String> ranking = Multisets.copyHighestCountFirst(mset2).asList();
        List<String> top = ranking.subList(0, mset2.count(ranking.get(0)));

        Joiner joiner = Joiner.on("-").skipNulls();
        out.println(joiner.join(top));

        //if all element in mset2 are all in mset1, don't care about frequency
        out.println("If multiset1 contains multiset2's element: " + mset1.containsAll(mset2));
        //Not only elements in mset2 are contained in mset1, but also mset1.count(*) >= mset2.cout(*)
        out.println("If multiset1.count(*) >= multiset2.count(*): " + Multisets.containsOccurrences(mset1, mset2));

        mset1.setCount("b", 3);
        if(Multisets.containsOccurrences(mset1, mset2)){
            Multisets.removeOccurrences(mset1, mset2); //subtract mset2's element frequency from mset1
        }
        out.println(mset1);


        //remove element in mset2 from mset1
        mset1.removeAll(mset2);
        assert !mset1.contains("a") && !mset1.contains("b") && !mset1.contains("c");
        out.println(mset1.count("d"));

    }
}
