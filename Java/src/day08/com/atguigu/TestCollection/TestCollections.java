package day08.com.atguigu.TestCollection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
