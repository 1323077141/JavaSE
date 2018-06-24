package day08.com.atguigu.TestIO;

import org.junit.Test;

import java.io.*;

public class TestObjectInputOutputStream {

    /**
     * 反序列化过程:
     *
     */
    @Test
    public void testObjectInputStream() throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("person.txt")));
        Person p1 = (Person) ois.readObject();
        System.out.println(p1);
        Person p2 = (Person) ois.readObject();
        System.out.println(p2);
        ois.close();
    }


    /**
     * 对象的序列化过程：
     * 将内存中的对象通过ObjectOutputStream转换为二进制,存储在硬盘文件中
     *
     *
     */
    @Test
    public void testObjectOutputStream() throws Exception{
        Person p1 = new Person("小明",23);
        Person p2 = new Person("小红",21);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("person.txt")));
        oos.writeObject(p1);
        oos.flush();
        oos.writeObject(p2);
        oos.flush();

        oos.close();

    }

}

/**
 * 要实现序列化的类:
 * 1.要求此类是可序列化的:继承Serializable
 * 2.要求类的属性同样也要继承Serializable接口
 * 3.提供一个版本号:private static final long SerialVersionUID
 */
class Person implements Serializable
{
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}