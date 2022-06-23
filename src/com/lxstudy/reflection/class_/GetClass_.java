package com.lxstudy.reflection.class_;

import com.lxstudy.Car;

/**
 * @author Lexie
 * @version 1.0
 * 演示得到Class对象的各种方式（6）
 */

public class GetClass_ {
    public static void main(String[] args) throws ClassNotFoundException {
        //1. Class.forName
        String classAllPath = "com.lxstudy.Car";//一般通过配置文件获取
        Class<?> cls1 = Class.forName(classAllPath);
        System.out.println(cls1);

        //2. 通过 类名.class,应用场景：用于参数传递
        Class cls2 = Car.class;
        System.out.println(cls2);

        //3. 对象.getClass() 应用场景：有独享实例
        Car car = new Car();
        Class cls3 = car.getClass();
        System.out.println(cls3);

        //4. 通过类加载器【4种】来获取到类的 Class对象
        //(1) 先得到类加载器 car
        ClassLoader classLoader = car.getClass().getClassLoader();
        //(2) 通过类加载器得到 Class 对象
        Class cls4 = classLoader.loadClass(classAllPath);
        System.out.println(cls4);

        //cls1 , cls2, cls3, cls4
        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode());
        System.out.println(cls3.hashCode());
        System.out.println(cls4.hashCode());

        //5. 基本数据类型(int, char,boolean,float,double,byte,long,short)
        Class<Integer> integerClass = int.class;
        Class<Character> characterClass = char.class;
        System.out.println(integerClass);//int,底层是Integer，有自动装箱和拆箱的过程

        //6. 基本数据类型对应的包装类，可以通过 .TYPE 得到Class类对象
        Class<Integer> type1 = Integer.TYPE;
        Class<Character> type2 = Character.TYPE;
        System.out.println(type1);//int

        System.out.println(integerClass.hashCode());//1163157884
        System.out.println(type1.hashCode());//1163157884，说明是同一个
    }
}
