package com.mizuki.boot.bean;

public class Pet {
    private String name;

    public Pet(String name) {
        this.name = name;
    }

    public Pet() {
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                '}';
    }
}
