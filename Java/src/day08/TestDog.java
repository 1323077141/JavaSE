package day08;

/**
 * 子类对象实例化全过程
 * 1.首先在堆空间中开辟空间存放dog对象，在该空间中分别有age,name,hostname三个属性
 * 2.构造器的调用过程，dog-----animal ------ creator ------ object
 */
public class TestDog {

    public static void main(String[] args){
        Dog d =new Dog();
        d.setAge(10);
        d.setName("花花");
        d.setHostname("小明");
    }

}
//生物
class Creator{
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Creator(){
        super();
        System.out.println("this is creator constructor...");
    }
}
//动物
class Animal extends Creator{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal(){
        super();
        System.out.println("this is animal constructor...");
    }
}
//狗
class Dog extends Animal{
    private String hostname;

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Dog(){
        super();
        System.out.println("tihs is dog constructor....");
    }
}
