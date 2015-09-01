package demos;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.ImmutableMap;
import template.SmsTemplate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author: Yang Yifan
 * MisId: yangyifan03
 * Project: guava-zero-to-hero
 * Date: 9/1/15
 * Time: 5:31 PM
 */
public class SmsAssemble {
    public static void main(String[] args) {
        ImmutableMap<String, String> smsParts = new ImmutableMap.Builder<String, String>()
            .put("hotel", "7-days")
            .put("customer", "Steven")
            .put("room", "bussiness-room")
            .put("night_num", "2")
            .build();

        String patternStr = "(\\{([^\\}]+)})";
        Matcher matcher = Pattern.compile(patternStr).matcher(SmsTemplate.SMS);
        StringBuffer sb = new StringBuffer();
        Function<String, String> lookup = Functions.forMap(smsParts, "");

        while (matcher.find()){
            matcher.appendReplacement(sb, lookup.apply(matcher.group(2)));
        }
        matcher.appendTail(sb);

        System.out.println(sb.toString());


    }

}
