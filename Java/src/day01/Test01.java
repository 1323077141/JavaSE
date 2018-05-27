package day01;

import com.sun.org.apache.bcel.internal.generic.SWAP;

/**
 * Created by Administrator on 2018-05-22.
 * 方法的参数传递
 */
public class Test01 {
    public static void main(String[] args){
        Test01 t = new Test01();
        int i = 10;
        int j = 5;
        System.out.println("i:" + i + " j:" + j);

        t.swap(i,j);
        System.out.println("i:" + i + " j:" + j);
    }

    //定义一个方法交换值
    public void swap(int i ,int j){
        int temp = i;
        i = j;
        j = temp;
    }
}
