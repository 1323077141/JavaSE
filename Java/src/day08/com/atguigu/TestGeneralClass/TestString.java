package day08.com.atguigu.TestGeneralClass;

import org.junit.Test;

/**
 * Created by Administrator on 2018-06-28.
 */
public class TestString {

    /**
     * String 代表不可变的字符序列，底层使用char[] 存放。
     * String 是final的。
     */
    @Test
    public void test1(){
        //String 类的四种构造方式
//        String str1 = new String();
//        String str2 = new String("hhhhh");
//        char[] a = {'a','a','b','c'};
//        String str3 = new String(a);
//        String str4 = new String(a,0,a.length);
        String str1 = "JAVAEE";
        String str2 = "JAVAEE";
        String str3 = new String("JAVAEE");
        String str4 = "JAVAEE" + "Android";
        String str5 = "Android";
        String str6 = str1 + str5;
        str5 = str5 + "Hadoop";
        String str7 = str6.intern();
        String str8 = "JAVAEEAndroid";
        System.out.println(str1 == str2);  //true
        System.out.println(str1 == str3);  //false
        System.out.println(str1.equals(str3)); //true

        System.out.println(str4 == str6);  //false
        System.out.println(str4.equals(str6)); //true
        System.out.println(str7 == str4); //true
        System.out.println(str8 == str4); //true

    }
}
