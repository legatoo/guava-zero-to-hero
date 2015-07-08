package forwardList;

import com.google.common.collect.ImmutableList;

import java.util.List;

import static java.lang.System.out;
/**
 * Author: Yang Yifan
 * MisId: yangyifan03
 * Project: guava-zero-to-hero
 * Date: 7/8/15
 * Time: 7:45 PM
 */
public class ForwardListDemo {
    public static void main(String[] args) {
        //this list will log every add operation
        AddLoggingList<String> addLoggingList = new AddLoggingList<String>();
        for (int i = 0; i < 5; i++) {
            addLoggingList.add(String.valueOf(i));
        }

        out.println(addLoggingList.size());
        out.println(addLoggingList);

        List<String> collection = ImmutableList.of("a", "b", "c");
        addLoggingList.addAll(collection);

    }
}
