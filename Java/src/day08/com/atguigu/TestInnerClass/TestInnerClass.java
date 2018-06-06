package day08.com.atguigu.TestInnerClass;

public class TestInnerClass {

    public static void main(String[] args){
        Person.Dog d = new Person.Dog();   //创建静态内部类对象,可以直接通过外部类调用静态内部类的构造器
        Person p  = new Person();
        Person.Bird b = p.new Bird();     //非静态内部类，必须先创建外部类的对象，铜鼓哦外部类的对象调用内部类的构造器
        b.setName("杜鹃");
    }

}

class Person{
    String name="tom";
    int age;
    class Bird{  //成员内部类
        String name = "jack";
        int id;
        public Bird(){

        }

        public void setName(String name) {
            System.out.println(name);  //杜鹃
            System.out.println(this.name); //jack
            System.out.println(Person.this.name);  //tom
        }

        public void info(){
            show();
        }

    }

    static class Dog{  //成员内部类

    }

    public void show(){
        System.out.println("我是show方法");
    }

    public void method1(){
        class A{  //局部内部类

        }
    }
}
