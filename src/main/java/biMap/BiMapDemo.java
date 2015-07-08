package biMap;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import static java.lang.System.out;

/**
 * Author: Yang Yifan
 * MisId: yangyifan03
 * Project: guava-zero-to-hero
 * Date: 7/8/15
 * Time: 10:58 AM
 */
public class BiMapDemo {

    public static void main(String[] args) {
        BiMap<String, Integer> userToId = HashBiMap.create();

        userToId.put("yangyifan03", 1);
        userToId.put("meituan", 2);


        out.println(userToId.get("meituan"));
        out.println(userToId.inverse().get(2));



    }
}
