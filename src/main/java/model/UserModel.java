package model;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Author: Yang Yifan
 * MisId: yangyifan03
 * Project: guava-zero-to-hero
 * Date: 9/1/15
 * Time: 2:04 PM
 */
public class UserModel {
    private Integer id;
    private Integer type;
    private String name;

    private static UserModel defaultUserModel;
    static {
        defaultUserModel = getDefaultUserModel();
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override public String toString() {
        return "UserModel{" +
            "id=" + id +
            ", type=" + type +
            ", name='" + name + '\'' +
            '}';
    }

    public static UserModel userGenerator() {
        Random random = new Random();
        SecureRandom secureRandom = new SecureRandom();
        UserModel user = new UserModel();
        user.setId(random.nextInt(50));
        user.setType(random.nextInt(3));
        user.setName(new BigInteger(130, secureRandom).toString(32).substring(0,10));

        return user;
    }

    public static UserModel getDefaultUserModel(){
        if(defaultUserModel == null){
            defaultUserModel = new UserModel();
            defaultUserModel.setId(0);
            defaultUserModel.setType(0);
            defaultUserModel.setName("DEFAULT");
        }

        return defaultUserModel;
    }
}
