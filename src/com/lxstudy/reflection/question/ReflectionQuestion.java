package com.lxstudy.reflection.question;

import com.lxstudy.Cat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author Lexie
 * @version 1.0
 * 反射问题的引入
 */

public class ReflectionQuestion {


    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //根据配置文件  re.properties  指定信息创建对象并调用方法
        //传统的方式
//        Cat cat = new Cat();
//        cat.hi();

        //使用IO流尝试做一下 ---》 明白反射

        //1. 使用Properties 类，可以读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();
        System.out.println("classfullpath=" + classfullpath);
        System.out.println("methodName=" + methodName);

        //2. 创建类型 ----》 传统方式行不通 ==》反射机制
        new com.lxstudy.Cat();//这样可以
        //new classfullpath();//这样不行，因为 classfullpath 已经是一个String类型

        //3. 使用反射机制解决（快速入门）
        //(1) 加载类，返回一个Class类型的对象
        //    Class 是一个类，名字叫做Class
        Class cls = Class.forName(classfullpath);//会抛出 ClassNotFoundException 异常
        //(2) 通过 cls 得到你加载的类 com.lxstudy.Cat 的对象实例
        Object o = cls.newInstance();
        System.out.println("o的运行类型=" + o.getClass());
        //(3) 通过 cls 得到你加载的类 com.lxstudy.Cat 的 methodName"hi" 的方法对象
        //    即：在反射中，可以把方法视为对象(万物皆对象)
        Method method1 = cls.getMethod(methodName);
        //(4) 通过 method1 调用方法：即通过方法对象来实现调用方法
        System.out.println("==========================");
        method1.invoke(o);  //传统方法  对象.方法(), 反射机制   方法.invoke(对象)
    }
}
