package day08.com.atguigu.TestEnum;

/**
 * 注解:
 * 1.JDK提供的常用的三个注解
 * @Override: 限定重写父类方法, 该注释只能用于方法
 * @Deprecated: 用于表示某个程序元素(类, 方法等)已过时
 * @SuppressWarnings: 抑制编译器警告
 * 2.如何自定义注解
 * 以SuppressWarnings为例进行创建即可
 *          @interface MyAnnotation
 * 3.元注解：可以对已有的注解进行解释说明。(对其他注解添加注解)
 * Retention: SOURCE   CLASS(默认)  RUNTIME :被修饰的注解的生命周期
 * Target: 指明被修饰的注解能用于修饰哪些程序元素
 * Documented:javadoc（Retention必须设置为RUNTIME）
 * Inherited:被该注解修饰的Annotation具有继承性
 *
 */
public class TestAnnotation {
    public static void main(String[] args) {
        Person p = new Student();
        p.walk();

    }
}
@MyAnnotation(value = "hhh")
class Student extends Person{

    @Override
    public void walk(){
        System.out.println("学生走路");
    }
    @Override
    public void eat(){
        System.out.println("学生吃饭");
    }
}
class Person{
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
    @MyAnnotation(value = "hhh")
    public void walk(){
        System.out.println("走路");
    }

    public void eat(){
        System.out.println("吃饭");
    }
}