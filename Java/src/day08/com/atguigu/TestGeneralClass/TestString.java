package day08.com.atguigu.TestGeneralClass;

import org.junit.Test;

/**
 * Created by Administrator on 2018-06-28.
 */
public class TestString {

    /**
     * String substring(int startpoint)
     * String substring(int start,int end) 返回从start开始到end的子串
     * String replace(char oldChar,char newChar) 不改变自身的字符串
     * String replaceAll(String old,String new)
     * String trim()  去除字符串首尾的空格，不去除中间的
     * String concat(String str) 连接当前字符串与str字符串，不改变原来的字符串
     * String[] split(String regex)
     */
    @Test
    public void test3(){
        String str1 = "北京尚硅谷北京";
        String str2 = "上海尚硅谷";
        String str3 = str1.substring(2);
        System.out.println(str3);

        String str4 = str1.replace("北京","东京");
        System.out.println(str4);
        System.out.println(str1);

    }

    /**
     * String 中常用类
     * public int length() String的长度
     * char charAt(int index) 返回index位置的字符,index从0开始
     * boolean equals(Object anObject)  比较两个字符串是否相等
     * int compareTo(String anotherString) 比较连个字符串大小
     * int indexOf(String s) 返回s 字符串首次出现的位置，若无则为-1
     * int indexOf(String s,int startpoint) 返回s 字符串从startpoint位置开始的首次出现的位置，若无则为-1
     * int lastIndexOf(String s) 返回s 字符串最后一次出现的位置，若无则为-1
     * int lastIndexOf（String s,int startpoint) 返回s 字符串从startpoint位置开始的最后一次出现的位置，若无则为-1
     * boolean startWith(String prefix) 当前字符串是否以prefix 开始
     * boolean endWith(String suffix) 当前字符串是否以suffix 结束
     * boolean regionMatches(int firstStart,String other,int otherStart)
     * 判断当前字符串从firstStart开始的子串与另一个字符串other从otherStart开始,length长度的子串是否相等
     */
    @Test
    public void test2(){

    }

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
