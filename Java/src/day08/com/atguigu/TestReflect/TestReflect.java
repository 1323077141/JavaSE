package day08.com.atguigu.TestReflect;

import org.junit.Test;

import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Properties;

public class TestReflect {


    @Test
    public void testRun1() throws Exception{
        String className = "day08.com.atguigu.TestReflect.Person";
        Class clazz = Class.forName(className);
        //调用指定的构造器


        //1.获取指定的属性
        Field name = clazz.getField("name");
        Person p = (Person) clazz.newInstance();
        //赋值
        name.set(p,"Tom");

    }

    @Test
    public void testOthers(){
        Class clazz = Person.class;
        //获取父类
        Class superClass = clazz.getSuperclass();
        //获取带泛型的父类
        Type type = clazz.getGenericSuperclass();
        //获取父类的泛型
        ParameterizedType param = (ParameterizedType)type;
        Type[] args = param.getActualTypeArguments();
        System.out.println(((Class)args[0]).getName());
        //获取实现的接口
        Class[] interfaces = clazz.getInterfaces();
        //获取所在的包
        Package pack = clazz.getPackage();
        //获取注释
        Annotation[] anns = clazz.getAnnotations();
    }

    /**
     * 获取构造器
     * @throws Exception
     */
    @Test
    public void testConstructor() throws Exception{
        String className = "day08.com.atguigu.TestReflect.Person";
        Class clazz = Class.forName(className);

        Constructor[] cons = clazz.getDeclaredConstructors();
    }

    /**
     * 关于类加载器
     */
    @Test
    public void test4() throws Exception{
        ClassLoader loader1 = ClassLoader.getSystemClassLoader();
        System.out.println(loader1);  //app

        ClassLoader loader2 = loader1.getParent();
        System.out.println(loader2);  //ext

        ClassLoader loader3 = loader2.getParent();
        System.out.println(loader3);  //bootstrap(无法直接获取)

        Class clazz = Person.class;
        ClassLoader loader4 = clazz.getClassLoader();
        System.out.println(loader4);  //app

        String className = "java.lang.Object";
        Class clazz1 = Class.forName(className);
        ClassLoader loader5 = clazz1.getClassLoader();
        System.out.println(loader5); //null


        //掌握
        ClassLoader loader = this.getClass().getClassLoader();
        InputStream is = loader.getResourceAsStream("com\\atguigu\\java\\jdbc.properties");
        Properties properties = new Properties();
        properties.load(is);
        properties.get("user");


    }

    /**
     * 创建运行时类的实例:
     */
    @Test
    public void test5() throws Exception{

        String className = "day08.com.atguigu.TestReflect.Person";
        Class clazz = Class.forName(className);
        //创建运行时类对象,调用的是空参构造器,且权限要足够
        Object obj = clazz.newInstance();
        Person p = (Person)obj;
        System.out.println(p);
        //getFields只能获取到运行时类及其父类中声明为Public 的属性
        //getDeclaredFields:获取运行时类本身声明的所有的属性

        Field[] fields = clazz.getFields();
        Field[] fields1 = clazz.getDeclaredFields();
        for (Field item : fields1){
            String str = Modifier.toString(item.getModifiers());
            System.out.println(str);
            Class type = item.getType();
            System.out.println(type.getName());
        }

        Method[] m = clazz.getMethods();
        for (Method method : m){
            method.getAnnotations();
            System.out.println(Modifier.toString(method.getModifiers()));
            //返回值
            Class returnType = method.getReturnType();
            //方法名
            System.out.println(method.getName());
            //形参列表
            Class[] params = method.getParameterTypes();
            //异常类型
            Class[] exceptions = method.getExceptionTypes();
        }

    }

    /**
     * 获取Class 的实例 :四种
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
        String className = "day08.com.atguigu.TestReflect.Person";
        Class clazz3 = Class.forName(className);
        System.out.println(clazz3);

        //4.通过类的加载器
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class clazz = classLoader.loadClass(className);
        System.out.println(clazz.getName());

        //通过Class 创建对应的实例
//        clazz3.newInstance();

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
