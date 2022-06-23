package com.lxstudy.homework;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Lexie
 * @version 1.0
 */

public class Homework02 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IOException {
        //1. 得到 File对应的 Class 对象
        Class<File> fileClass = File.class;
        //2. 得到所有构造器
        Constructor<?>[] declaredConstructors = fileClass.getDeclaredConstructors();
        int i = 0;
        //遍历输出
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("File类的第" + (++i) + "个构造器=" + declaredConstructor);
        }
        //3. 得到有一个指定参数的构造器 java.io.File(java.lang.String)
        Constructor<File> constructor = fileClass.getConstructor(String.class);
        //4. 创建对象
        File file = constructor.newInstance("E:\\JAVASTUDY\\JavaIOfile\\homework.txt");
        File file2 = constructor.newInstance("E:\\JAVASTUDY\\JavaIOfile\\mytemp\\homework.txt");
        //4.1 直接调用方法
        file.createNewFile();
        //4.2 反射调用方法
        Method createNewFile = fileClass.getMethod("createNewFile");
        createNewFile.invoke(file2);
        System.out.println("文件创建成功~");
    }
}
