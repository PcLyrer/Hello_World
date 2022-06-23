package com.lxstudy.homework;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Lexie
 * @version 1.0
 */

public class Homework01 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        //方法1
//        Class<PrivateTest> privateTestClass = PrivateTest.class;
//        PrivateTest privateTest = privateTestClass.newInstance();
//        Field name = privateTestClass.getDeclaredField("name");
//        name.setAccessible(true);
//        name.set(privateTest, "I am not HelloKitty!!");
//        System.out.println(privateTest.getName());
        //方法2
        //1. 得到PrivateTest 对应的Class对象
        Class<?> cls = Class.forName("com.lxstudy.homework.PrivateTest");
        //2. 创建对象
        PrivateTest test = (PrivateTest) cls.newInstance();
        //3. 得到name 属性对象
        Field name = cls.getDeclaredField("name");
        //4. 暴破 name
        name.setAccessible(true);
        name.set(test, "Tom cat");
        System.out.println(test.getName());//一种方式
        //5. 得到 getName 方法对象
        Method getName = cls.getMethod("getName");
        //6. 因为getName() 是public，所以可以直接调用
        System.out.println("name属性=" + getName.invoke(test));

    }
}

class PrivateTest {
    private String name = "hellokitty";

    public String getName() {
        return name;
    }
}