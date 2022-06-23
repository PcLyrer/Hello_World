package com.lxstudy.classload_;

/**
 * @author Lexie
 * @version 1.0
 * 演示类加载--初始化阶段
 */

public class ClassLoad03 {
    public static void main(String[] args) throws ClassNotFoundException {
        //分析：
        //1. 加载B类，并生成 B的class对象
        //2. 链接 num = 0;
        //3. 初始化阶段
        //   依次自动收集类中的所有静态变量的赋值动作和静态代码块中的语句
        /*
                clinit() {
                    System.out.println("B 的静态代码块被执行");
                    //num = 300;
                    num = 100;
                }
                //合并:num = 100;

         */
        //4. "B() 构造器被执行"
        //new B();//类加载,new  才会输出 第4句
        //System.out.println(B.num);//100，直接使用类的静态属性，也会导致类的加载

        //看看加载类的时候，是有同步机制控制
        /*
        protected Class<?> loadClass(String name, boolean resolve)
        throws ClassNotFoundException
        {
            //因为有这个机制，才能保证某个类在内存中，只用一个Class对象
            synchronized (getClassLoadingLock(name)) {
                //....
            }
        }
         */
        B b = new B();
    }
}
class B {
    static {
        System.out.println("B 的静态代码块被执行");
        num = 300;
    }
    static int num = 100;

    public B() {//构造器
        System.out.println("B() 构造器被执行");
    }
}