package com.mizuki.boot.bean;

public class Son {
    private String name;

    public Son() {
    }

    public Son(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Son{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
