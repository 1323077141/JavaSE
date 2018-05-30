package day08.com.atguigu.polymorphism;

/**
 *  1.基本数据类型：判断基本数据类型的值是否相等
 *  2.引用数据类型: 比较引用类型变量的地址值是否相等
 *  关于String 类:存放在字符串常量值
 *
 */
public class TestEquals {
    public static void mian(String[] args){
        int i = 12;
        int j = 12;
        System.out.println(i == j); //true
        char c = 12;
        System.out.println(i == c); //true
        float f = 12.0f;
        System.out.println(i == f); //true
        int k = 65;
        char a = 'A';
        System.out.println(k == a); //true


        Person p1 = new Person("AA",12);
        Person p2 = new Person("AA",12);
        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));


        Object obj1 = new Object();
        Object obj2 = new Object();
        System.out.println(obj1 == obj2);  //false

        String str1 = "AA";
        String str2 = "AA";   //str2与str1引用地址相同
        String str3 = new String("AA");
        System.out.println(str1 == str2);      //true
        System.out.println(str1.equals(str2));   //true
        System.out.println(str1 == str3);      //false
        System.out.println(str1.equals(str3));   //true
        System.out.println(p1.getName() == p2.getName());  //true


    }

}
