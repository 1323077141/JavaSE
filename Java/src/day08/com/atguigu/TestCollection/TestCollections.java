package day08.com.atguigu.TestCollection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Collection:集合
 * collections:工具类
 *
 *
 *
 *
 */
public class TestCollections {

    /**
     * Object max(Collection):根据元素的自然顺序，返回给定集合中的最大元素
     * Object max(Collection,Comparator)根据Comparator指定的顺序，返回给定集合中的最大元素
     * Object min(Collection)
     * Object min(Collection,Comparator)
     * int frequency(Collection,Object) 指定集合中Object出现的次数
     * void copy(List dest,List src)将src中的内容复制到dest中（实现需要有正确的方式）
     * boolean repalceAll(List list,Object oldVal,Object newVal) 使用新值替换List中的旧值
     *
     */
    @Test
    public void test2(){

        List list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(789);

        List list1 = Arrays.asList(new Object[list.size()]);
        Collections.copy(list1,list);

        List list2 = Collections.synchronizedList(list); //list2是线程安全的


    }

    /**
     * reverse(List):反转List元素
     * shuffle(List):对List集合元素进行随机排序
     * sort(List):根据元素的自然顺序对指定List集合按升序排序
     * sort(List,Comparator)根据指定的Comparator 产生的顺序对List元素进行排序
     * swap(List,int,int) 将指定list集合中的i处元素和j处元素进行交换
     *
     */
    @Test
    public void test1(){

        List list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(789);

        Collections.reverse(list);
        Collections.shuffle(list);
        Collections.sort(list);
        Collections.swap(list,0,1);
    }

}
