package com.lxstudy.reflection.class_;

import com.lxstudy.Car;

import java.lang.reflect.Field;

/**
 * @author Lexie
 * @version 1.0
 * 演示 Class类的常用方法
 */

public class Class02 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        String classAllPath = "com.lxstudy.Car";
        //1. 获取到 Car 类对应的 Class对象
        //<?> 表示不确定的 Java类型
        Class<?> cls = Class.forName(classAllPath);
        //2. 输出cls
        System.out.println(cls);//com.lxstudy.Car 显示cls对象，是哪个类的Class对象
        System.out.println(cls.getClass());//cls的运行类型 java.lang.Class
        //3. 得到包名
        System.out.println(cls.getPackage().getName());//com.lxstudy
        //4. 得到全类名
        System.out.println(cls.getName());//com.lxstudy.Car
        //5. 通过 cls 创建对象实例
        Car car = (Car) cls.newInstance();//此时就是创建的Car实例(从Object向下转型后)
        System.out.println(car);//car.toString()
        //6. 通过反射获取属性，不能获取私有属性
        Field brand = cls.getField("brand");
        System.out.println("brand=" + brand);//brand=public java.lang.String com.lxstudy.Car.brand
        System.out.println(brand.get(car));//BWM
        //7. 通过反射给属性赋值
        brand.set(car, "梅赛德斯奔驰");
        System.out.println(brand.get(car));//梅赛德斯奔驰
        //8. 希望可以得到所有的属性(字段)
        System.out.println("======所有的字段======");
        Field[] fields = cls.getFields();
        for (Field f: fields) {
            System.out.println(f.getName());//依次输出各个属性字段的名称
        }
    }
}
