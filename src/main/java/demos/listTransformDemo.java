package demos;

import com.google.common.base.Function;
import com.google.common.base.Throwables;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.sun.istack.internal.NotNull;
import exception.MyException;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/**
 * Author: Yang Yifan
 * MisId: yangyifan03
 * Project: guava-zero-to-hero
 * Date: 8/31/15
 * Time: 11:37 AM
 */
public class ListTransformDemo {
    private static final class MyFunction implements Function<Node, Integer> {
        public Integer apply(@NotNull Node input) {
            return input.getId();
        }
    }

    public static void main(String[] args) {
        Function<Node, Integer> idExtractor = new Function<Node, Integer>() {
            public Integer apply(Node input) {
                out.println("applying function on " + input);
                return input.getId();
            }
        };

        Function<Node, List<Integer>> itemExtractor = new Function<Node, List<Integer>>() {
            public List<Integer> apply(Node input) {
                return input.getItems();
            }
        };


        List<Node> nodes = new ArrayList<Node>();
        nodes.add(Node.nodeGenerator(1));
        nodes.add(Node.nodeGenerator(2));
        nodes.add(Node.nodeGenerator(3));

        //set is supported here
        nodes.set(0, Node.nodeGenerator(0));

        out.println("origin list is: " + nodes);

        List<Integer> nodeIds_view = Lists.transform(nodes, new MyFunction());
        out.println("---------TRANSFORM DONE?----------");  //Lazy load
        out.println("ids from origin list:" + nodeIds_view);


        /**
         * since transform returned a list whose iterator, TransformedListIterator, forbids
         * add and set operattion on it.
         */
        //nodeIds_view.set(0, 5)   //set is not supported here
        //nodeIds_view.add(6);     //add is not supported here

        nodes.add(Node.nodeGenerator(4));
        out.println("ids from origin list after add: " + nodeIds_view);
        //previous added item listed since function is lazy load

        List<Integer> nodeIds_supportCopy = Lists.newArrayList(Lists.transform(nodes, idExtractor));
        out.println("----------TRANSFORM DONE?----------");
        nodeIds_supportCopy.set(0, 5);
        out.println("modification on copy list:" + nodeIds_supportCopy);

        List<List<Integer>> itemLists = Lists.transform(nodes, itemExtractor);
        for (List items : itemLists) {
            items.set(0, 4); //the iterator of internal list still open for add andset operations
        }
        out.println("chang item value inside list: " + itemLists);
        //itemLists.set(0, new ArrayList<Integer>()); //forbid

        //serializable
        Gson gsonObject_view = new Gson();
        out.println("Gson str from view:" + gsonObject_view.toJson(nodeIds_view));
        Gson gsonObject_copy = new Gson();
        out.println("Gson str forom copy: " + gsonObject_copy.toJson(nodeIds_supportCopy));

        out.println("nodes: " + nodes);
        Function<Node, Integer> exceptionFunction = new Function<Node, Integer>() {
            public Integer apply(Node input) {
                try {
                    input.strangeGet(); //checked exception has to be handled
                    return input.getId();
                } catch (MyException e) {
                    //throw MyException("my exception");
                    throw Throwables.propagate(e);
                }

            }
        };

        //单纯下面一句话是不会触发异常的，因为transform是lazy的
        List<Integer> ids = Lists.transform(nodes, exceptionFunction);
        //一个需要被检查的异常在apply中被吞掉了，变成了一个运行时异常，这里需要注意，把返回的东西提前拷贝出来可以让异常发生
        //或者手动捕捉异常
        out.println(ids);
    }
}
