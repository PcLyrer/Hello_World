package com.lxstudy.classload_;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * @author Lexie
 * @version 1.0
 */

public class ClassLoad_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入key");
        String key = scanner.next();
        switch (key) {
            case "1":
                Pig pig = new Pig();//编译时就会报错，称为静态加载
                pig.cry();
                break;
            case "2":
                try {
                    //反射  --》  动态加载(只有到运行这行代码时，才进行加载)
                    Class<?> cls = Class.forName("Person");//加载Person类
                    Object o = cls.newInstance();
                    Method m = cls.getMethod("hi");
                    m.invoke(o);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("OK");
                break;
            default:
                System.out.println("do nothing..");
                break;

        }
    }
}
//因为 new Pig() 是静态加载，必须编写Dog
//Person类是动态加载，所以，没有编写Person类也不会报错，只有个当动态加载该类时，才会报错
class Pig {
    public void cry() {
        System.out.println("小猪 嗷嗷 叫~");
    }
}
