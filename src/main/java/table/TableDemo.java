package table;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;

import java.util.Set;

import static java.lang.System.out;

/**
 * Author: Yang Yifan
 * MisId: yangyifan03
 * Project: guava-zero-to-hero
 * Date: 7/8/15
 * Time: 11:23 AM
 */
public class TableDemo {
    public static void main(String[] args) {
        Table<Integer, Integer, String> tableDemo = HashBasedTable.create();


//        +-------+--------+------+-------+
//        |       |        |      |       |
//        |       |   1    |  2   |  3    |
//        +-------------------------------+
//        |   1   |        |      |       |
//        |       |    a   |   b  |    c  |
//        +-------------------------------+
//        |   2   |        |      |       |
//        |       |     e  |  f   |    g  |
//        +-------+--------+------+-------+

        tableDemo.put(1, 1, "a");
        tableDemo.put(1, 2, "b");
        tableDemo.put(1, 3, "c");

        tableDemo.put(2, 1, "e");
        tableDemo.put(2, 2, "f");
        tableDemo.put(2, 3, "g");

        out.println(tableDemo.row(1));

        Set<Cell<Integer, Integer, String>> cells = tableDemo.cellSet();
        for (Cell cell : cells) {
            out.println("Row: " + cell.getRowKey() + " Column: " + cell.getColumnKey() + " Value: " + cell.getValue());
        }
    }
}
