package com.lxstudy.reflection;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

/**
 * @author Lexie
 * @version 1.0
 * 演示如何通过反射获取类的结构信息
 */

public class ReflectionUtils {
    public static void main(String[] args) {

    }

    //第一组方法API
    @Test
    public void api_01() throws ClassNotFoundException {
        //得到Class对象
        //Class<Person> personClass = Person.class;
        Class<?> personClass = Class.forName("com.lxstudy.reflection.Person");

        //1. getName:获取全类名
        System.out.println(personClass.getName());//com.lxstudy.reflection.Person
        //2. getSimpleName:获取简单类名
        System.out.println(personClass.getSimpleName());//Person
        //3. getFields:获取所有public修饰的属性，包含本类以及父类的
        Field[] fields = personClass.getFields();//快捷键   fields.for
        for (Field field : fields) {//增强for
            System.out.println("本类及父类的属性=" + field.getName());//name hobby
        }
        //4. getDeclaredFields:获取本类中所有属性
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类中的所有属性=" + declaredField.getName());
        }
        //5. getMethods:获取所有public修饰的方法，包含本类以及父类的
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println("本类及父类的方法=" + method.getName());//本类，父类，超类Object
        }
        //6. getDeclaredMethods:获取本类中所有方法
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类中的所有方法=" + declaredMethod.getName());
        }
        //7. getConstructors:获取所有public修饰的构造器，包含本类的
        Constructor<?>[] constructors = personClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("本类所有public构造器=" + constructor.getName());
        }
        //8. getDeclaredConstructors:获取本类中所有构造器
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("本类中的所有构造器=" + declaredConstructor.getName());//只输出名字，没有形参
        }
        //9. getPackage:以Package形式返回包信息
        System.out.println(personClass.getPackage());
        //10.getSuperClass:以Class形式返回父类信息
        Class<?> superclass = personClass.getSuperclass();
        System.out.println("父类的信息=" + superclass);//全路径
        //11.getInterfaces:以Class[]形式返回接口信息
        Class<?>[] interfaces = personClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("接口信息=" + anInterface);
        }
        //12.getAnnotations:以Annotation形式返回注解信息
        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("注解信息=" + annotation);//注解
        }
    }
    @Test
    public void api_02() throws ClassNotFoundException {
        Class<?> personClass = Class.forName("com.lxstudy.reflection.Person");
        //getDeclaredFields:获取本类中所有属性
        //规定：说明:默认修饰符是0 , public 是1 , private是2 , protected是4，static是8，final 是16
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类中的所有属性=" + declaredField.getName()
            + " 该属性的修饰符值=" + declaredField.getModifiers()
            + " 该属性的类型=" + declaredField.getType());
        }
    }

    @Test
    public void api_03() throws ClassNotFoundException {
        Class<?> personClass = Class.forName("com.lxstudy.reflection.Person");

        //getDeclaredMethods:获取本类中所有方法
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类中的所有方法=" + declaredMethod.getName()
            + " 该方法的访问修饰符值=" + declaredMethod.getModifiers()
            + " 该方法返回类型=" + declaredMethod.getReturnType());

            //输出当前这个方法的形参列表
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println(declaredMethod.getName() + "的形参列表为" + parameterType);
            }
        }
    }

    @Test
    public void api_04() throws ClassNotFoundException {
        Class<?> personClass = Class.forName("com.lxstudy.reflection.Person");

        //getDeclaredConstructors:获取本类中所有构造器
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("本类中的所有构造器=" + declaredConstructor.getName());

            Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println(declaredConstructor.getName() + " 的形参列表" + parameterType);
            }
        }
    }
}

class A {
    public String hobby;

    public void hi() {
    }

    public A() {
    }

    public A(String hobby) {
        this.hobby = hobby;
    }

}
interface IA{}
interface IB{}
@Deprecated
class Person extends A implements IA,IB{
    //属性
    public String name;
    protected int age;
    protected static int height;//4 + 8 =12
    String job;
    private double sal;

    //构造器
    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    private Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //方法
    public void m1(String name, int age, double sal) {
    }

    protected String m2() {
        return null;
    }

    void m3() {
    }

    private void m4() {
    }

}
