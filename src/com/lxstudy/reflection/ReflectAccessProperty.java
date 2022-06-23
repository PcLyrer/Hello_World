package com.lxstudy.reflection;

import java.io.ObjectOutputStream;
import java.lang.reflect.Field;

/**
 * @author Lexie
 * @version 1.0
 * 演示反射操作属性
 */

public class ReflectAccessProperty {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        //1. 得到Student类 对应的 Class对象
        Class<?> stuClass = Class.forName("com.lxstudy.reflection.Student");
        //2. 创建对象
        Object o = stuClass.newInstance();
        //3. 使用反射得到 age 属性对象
        Field age = stuClass.getField("age");
        age.set(o, 89);//通过反射来操作属性
        System.out.println(o);
        System.out.println(age.get(o));//返回age属性的值

        //4. 使用反射操作name 属性
        Field name = stuClass.getDeclaredField("name");
        //对 name 使用 暴破，可以操作private 属性
        name.setAccessible(true);
        //name.set(o, "Tom");
        name.set(null, "Tom~~");//因为name 是 static属性，因此o 也可以写成 null
        System.out.println(o);
        //System.out.println(name.get(o));//获取属性值
        System.out.println(name.get(null));//获取属性值，要求name是static
    }
}

class Student {
    public int age;
    private static String name;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student[age=" + age + "]";
    }
}
