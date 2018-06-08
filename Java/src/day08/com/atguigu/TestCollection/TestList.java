package day08.com.atguigu.TestCollection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestList {

    //ArrayList:List的主要实现类

    /**
     * ArrayList 相对于Collection新增加的方法
     */
    @Test
    public void TestList1(){
        List list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(new String("AA"));
        list.add(new String("GG"));
        System.out.println(list);   //按照添加的顺序输出
        //1.void add(int index,Object o):在指定的索引位置添加元素
        list.add(0,555);
        //get(int index) : 获取指定位置的元素
        Object o = list.get(1);
        System.out.println(o);
        //Object remove(int index)  删除该位置的元素并返回此元素
        list.remove(0);
        System.out.println(list);
        //Object set(int index,Object ele) 设置指定位置的元素为ele
        list.set(0,111);
        //List subList(int formIndex,int toIndex) 将formIndex到toIndex(左闭右开)的list集合返回

        //indexOf(Object obj) 返回obj在集合中首次出现的位置,若无，返回-1

        //lastIndexOf(Object obj) 返回obj 在集合中最后一次出现的位置，若无，返回-1
    }

    @Test
    public void testList2(){
        List list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(new String("AA"));
        list.add(new String("GG"));
        list.add(456);
        System.out.println(list.indexOf(456));  //1
        System.out.println(list.lastIndexOf(456));  //4
        System.out.println(list.indexOf(123) == list.lastIndexOf(123));  //true
        System.out.println(list.indexOf(444));   //-1

        List list1 = list.subList(0,3);
        System.out.println(list1);

    }



}
