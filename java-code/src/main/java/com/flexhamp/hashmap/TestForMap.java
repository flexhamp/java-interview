package com.flexhamp.hashmap;


public class TestForMap {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public TestForMap setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public TestForMap setAge(Integer age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "TestForMap{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
