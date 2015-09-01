package demos;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * Author: Yang Yifan
 * MisId: yangyifan03
 * Project: guava-zero-to-hero
 * Date: 8/31/15
 * Time: 5:19 PM
 */
public class BloomFilterDemo {
    public static void main(String[] args) {
        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), 100000);
        bloomFilter.put(159746);
        System.out.println(bloomFilter.mightContain(159746));
        bloomFilter.mightContain(159746);
    }
}
