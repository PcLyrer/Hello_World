package com.lxstudy;

/**
 * @author Lexie
 * @version 1.0
 */

public class Cat {
    private String name = "招财猫";
    public int age = 0;
    public void hi() {  //常用方法
        //System.out.println("hi" + name);
    }
    public void cry() {
        System.out.println(name + "喵喵叫");
    }
    public Cat(){

    }

    public Cat(String name) {
        this.name = name;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
