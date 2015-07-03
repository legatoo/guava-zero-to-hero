package Utils;

import com.google.common.collect.Multiset;
import model.Foo;

import java.math.BigInteger;
import java.util.Random;
import java.util.UUID;
import java.security.SecureRandom;


/**
 * Author: Yang Yifan
 * MisId: yangyifan03
 * Project: guava-zero-to-hero
 * Date: 7/1/15
 * Time: 3:53 PM
 */
public class Filler {
    public static void fillFoo(Multiset<Foo> multiset){
        Random random = new Random();
        SecureRandom secureRandom = new SecureRandom();
        for(int i = 0; i < 100; i++){
            Foo foo = new Foo();
            foo.setId(random.nextInt(50)+1);
            foo.setName(UUID.randomUUID().toString());
            for(int j = 0; j < 10; j++){
                foo.getMembers().add(new BigInteger(130, secureRandom).toString(32));
            }

            multiset.add(foo);
        }
    }
}
