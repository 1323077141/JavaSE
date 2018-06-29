package day08.com.atguigu.TestGeneralClass;

/**
 * 1.模拟一个trim方法，去除字符串两端的空格
 *
 * 2.讲一个字符串进行反转。将字符串中指定部分进行反转
 *
 * 3.获取一个字符串在另一个字符串中出现的次数
 *
 * 4.获取两个字符串中最大相同子串
 *
 * 5.对字符串中字符进行自然顺序排序
 *
 */
public class TestStringPractice {


    //2.讲一个字符串进行反转。将字符串中指定部分进行反转
    public static String reverseString1(String str,int start,int end){
        String str1 = str.substring(0,start);
        for (int i = end; i >= start; i--){
            char c = str.charAt(i);
            str1 += c;
        }
        str1 += str.substring(end);
        return str1;
    }

    public static String reverseString(String str,int start,int end){
        char[] c = str.toCharArray();
        return reverseArray(c,start,end);
    }

    public static String reverseArray(char[] c,int start,int end){
        for (int i = start,j = end; i < j; i++,j--){
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
        }
        return new String(c);
    }


    //1.模拟一个trim方法，去除字符串两端的空格
    public static String myTrim(String str){
        int start = 0;
        int end = str.length() - 1;
        while(start < end && str.charAt(start) == ' '){
            start++;
        }
        while (start < end && str.charAt(end) == ' '){
            end--;
        }
        return str.substring(start,end + 1);
    }

}
