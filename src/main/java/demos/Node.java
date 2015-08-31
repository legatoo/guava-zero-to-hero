package demos;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Yang Yifan
 * MisId: yangyifan03
 * Project: guava-zero-to-hero
 * Date: 8/31/15
 * Time: 2:11 PM
 */
public class Node {
    private Integer id;
    private String title;
    private List<Integer> items;
    private transient int transientInt;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Integer> getItems() {
        return items;
    }

    public void setItems(List<Integer> items) {
        this.items = items;
    }

    public int getTransientInt() {
        return transientInt;
    }

    public void setTransientInt(int transientInt) {
        this.transientInt = transientInt;
    }

    @Override public String toString() {
        return "Node{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", items=" + items +
            ", transientInt=" + transientInt +
            '}';
    }

    public static Node nodeGenerator(Integer id) {
        Node node = new Node();
        node.setId(id);
        node.setTitle(id == null ? "#" : "#" + id);
        node.setItems(new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
        }});
        node.setTransientInt(0);
        return node;
    }
}
