package day08.com.atguigu.TestReflect;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflect {

    /**
     * 获取Class 的实例
     */
    @Test
    public void test3() throws Exception{
        //1.调用运行时类本身的.class属性
        Class clazz1 = Person.class;
        System.out.println(clazz1.getName());

        //2.通过运行时类对象获取
        Person p = new Person();
        Class clazz2 = p.getClass();
        System.out.println(clazz2.getName());

        //3.通过Class的静态方法获取
        String className = "com.atguigu.TestReflect.TestReflect";
        Class clazz3 = Class.forName(className);
        System.out.println(clazz3);

        //4.通过类的加载器
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class clazz = classLoader.loadClass(className);
        System.out.println(clazz.getName());

        //通过Class 创建对应的实例
        clazz3.newInstance();

    }

    //反射以后
    @Test
    public void test2() throws Exception{
        Class<Person> clazz = Person.class;
        //1.创建clazz对应的运行时类的对象
        Person p =  clazz.newInstance();
        //2.指定类属性值
        Field f1 = clazz.getField("name"); //只适用于public 属性
        f1.set(p,"Jerry");

        Field f2 = clazz.getDeclaredField("age");  //private
        f2.setAccessible(true);
        f2.set(p,22);
        //3.调用方法
        Method m1 = clazz.getMethod("show");
        m1.invoke(p);

        Method m2 = clazz.getMethod("display", String.class);
        m2.invoke(p,"China");


    }

    //反射以前
    @Test
    public void test1(){
        Person p = new Person();
        p.setAge(10);
        p.setName("Tom");
        p.show();
        p.display("China");
    }

}
