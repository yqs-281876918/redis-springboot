package com.yqs.redis.pojo;

import java.io.Serializable;

public class User implements Serializable
{
    public String name;
    public int age;

    public User(){}
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
