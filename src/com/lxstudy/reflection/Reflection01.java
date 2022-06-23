package com.lxstudy.reflection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author Lexie
 * @version 1.0
 */

public class Reflection01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //1. 使用Properties 类，可以读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();

        //2. 使用反射机制解决（快速入门）
        //(1) 加载类，返回一个Class类型的对象,Class 是一个类，名字叫做Class
        Class cls = Class.forName(classfullpath);
        //(2) 通过 cls 得到你加载的类 com.lxstudy.Cat 的对象实例
        Object o = cls.newInstance();
        //(3) 通过 cls 得到你加载的类 com.lxstudy.Cat 的 methodName"hi" 的方法对象
        Method method1 = cls.getMethod(methodName);
        //(4) 通过 method1 调用方法：即通过方法对象来实现调用方法
        System.out.println("==========================");
        method1.invoke(o);  //传统方法  对象.方法(), 反射机制   方法.invoke(对象)

        //3. java.lang.reflect.Field：代表类的成员变量，Field对象表示某个类的成员变量
        //得到name字段
        //Field nameFiled = cls.getField("name");//异常，getField 不能得到私有的属性
        Field ageFileed = cls.getField("age");
        System.out.println(ageFileed.get(o));//传统写法 对象.成员变量，反射：成员变量对象.get(对象)

        //4. java.lang.reflect.Constructor：代表类的构造方法，Constructor表示构造器
        //()中可以指定构造器参数列表，没有则返回无参构造器
        Constructor constructor = cls.getConstructor();
        System.out.println(constructor);//Cat()
        //这里传入的 String.class 就是String类的Class对象
        Constructor constructor2 = cls.getConstructor(String.class);
        System.out.println(constructor2);//Cat(String)

    }
}
