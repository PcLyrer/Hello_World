package com.lxstudy.reflection.class_;

import com.lxstudy.Cat;

/**
 * @author Lexie
 * @version 1.0
 * 对Class类特点的梳理
 */

public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //Class 类图
        //1. Class也是类， 因此也继承0bject类[类图]
        //2. Class类对象不是new出来的，而是系统创建的
        //(1) 传统new 对象
        /* ClassLoader类
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return loadClass(name, false);
            }
         */
        //Cat cat = new Cat();
        //(2) 反射方式,刚才没有debug 到 ClassLoafer类的 loadClass，
        // 原因是：没有注销Cat cat = new Cat();已经进行了一次类加载，就不会再加载了
        /*
            ClassLoader类，仍然是通过 ClassLoader 类加载Cat类的 Class对象
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return loadClass(name, false);
            }
         */
        Class cls = Class.forName("com.lxstudy.Cat");

        //3. 对于某个类的Class类对象，在内存中只有一份，因为类只加载一次[如上面没有注销的代码]
        Class cls2 = Class.forName("com.lxstudy.Cat");
        System.out.println(cls.hashCode());//460141958
        System.out.println(cls2.hashCode());//460141958,hashCode一样，说明是同一个对象
        Class cls3 = Class.forName("com.lxstudy.Dog");
        System.out.println(cls3.hashCode());//1163157884

        //4. 每个类的实例都会记得自己是由哪个Class实例所生成

        //5. 通过Class对象可以完整地得到一个类的完整结构， 通过一系列API
        //6. Class对象是存放在堆的
        //7. 类的字节码二进制数据，是放在方法区的，有的地方称为类的元数据(包括 方法代码，变量名，方法名，访问权限等等)
    }
}
