package com.lxstudy.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Lexie
 * @version 1.0
 * 演示通过反射机制创建实例
 */

public class ReflectCreateInstance {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //1. 先获取到User类的 Class对象
        Class<?> userClass = Class.forName("com.lxstudy.reflection.User");
        //2. 通过public 的无参构造器创建实例
        Object o = userClass.newInstance();
        System.out.println(o);
        //3. 通过public 的有参构造器创建实例
        /*
            constructor 对象就是
            public User(String name) {//public 有参
                this.name = name;
            }
         */
        //3.1 先得到对应的构造器
        Constructor<?> constructor = userClass.getConstructor(String.class);
        //3.2 创建实例，并传入实参
        Object tom = constructor.newInstance("汤姆");
        System.out.println("tom=" +tom);
        //4. 通过非 public的 有参构造器创建实例
        //4.1 得到private 的构造器对象
        Constructor<?> declaredConstructor = userClass.getDeclaredConstructor(int.class, String.class);
        //4.2 创建实例
        //暴破【暴力破解】，使用反射可以访问private的构造器/方法/属性
        declaredConstructor.setAccessible(true);
        Object o1 = declaredConstructor.newInstance(20, "小明");//IllegalAccessException异常
        System.out.println(o1);
    }

}
class User {
    private int age = 10;
    private String name = "tom";
    public User(){}//public 无参
    public User(String name) {//public 有参
        this.name = name;
    }
    private User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User [age=" + age + ", name=" + name + "]";
    }
}