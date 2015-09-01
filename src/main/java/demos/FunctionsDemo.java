package demos;

import com.google.common.base.Functions;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import model.UserModel;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;
/**
 * Author: Yang Yifan
 * MisId: yangyifan03
 * Project: guava-zero-to-hero
 * Date: 9/1/15
 * Time: 2:08 PM
 */
public class FunctionsDemo {
    public static void main(String[] args) {
        ImmutableMap<Integer, UserModel> users = new ImmutableMap.Builder<Integer, UserModel>()
            .put(1, UserModel.userGenerator())
            .put(2, UserModel.userGenerator())
            .put(3, UserModel.userGenerator())
            .put(4, UserModel.userGenerator())
            .put(5, UserModel.userGenerator())
            .build();


        out.println(users);

        //map 查找中guava的应用，返回的还是view
        UserModel userModel_guava = Functions.forMap(users, UserModel.getDefaultUserModel()).apply(6);
        out.println("Get entry by guava: " + userModel_guava);

        UserModel userModel = null;
        if(!users.containsKey(6)){
            userModel = UserModel.getDefaultUserModel();
        }
        out.println("Get entry tranditional way: " + userModel);

        //返回key在一个范围内的所有entries,guava实现
        Map<Integer, UserModel> subMap_guava = Maps.filterKeys(users, Predicates.in(Lists.newArrayList(1,2)));
        out.println(subMap_guava);
        //传统实现
        Map<Integer, UserModel> subMap = new HashMap<Integer, UserModel>(users);
        subMap.keySet().retainAll(Lists.newArrayList(1,2));
        out.println(subMap);

        subMap.get(6);
    }
}
