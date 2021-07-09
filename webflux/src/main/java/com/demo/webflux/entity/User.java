package com.demo.webflux.entity;

/**
 * @ Description   :  User
 * @ Author        :  baolong.sun
 * @ CreateDate    :  2021/7/9$ 下午7:12$
 * @ UpdateUser    :  baolong.sun
 * @ UpdateDate    :  2021/7/9$ 下午7:12$
 * @ UpdateRemark  :  update detail
 * @ Version       :  1.0
 */
public class User {
    private String name;
    private String gender;
    private Integer age;

    public User(String name, String gender, Integer age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
