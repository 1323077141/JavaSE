package day08.com.atguigu.polymorphism;

/**
 * 多态性:父类的引用指向子类的实体
 *
 */
public class TestPerson {

    public static void main(String[] args){
//        Person p = new Person();
//        p.eat();
//        p.walk();
//
//        Man m = new Man();
//        m.eat();
//        m.walk();

        //父类的引用指向子类的实体
        Person p1 = new Man();
        Person p2 = new Woman();
        p1.eat();
        p1.walk();
        p2.eat();
        p2.walk();



    }

}
