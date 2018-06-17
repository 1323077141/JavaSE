package day08.com.atguigu.TestGeneric;

import org.junit.Test;

import java.util.*;

/**
 * 泛型的使用
 * 1.在集合中使用泛型
 * 2.自定义泛型类，泛型接口，泛型方法
 * 3.泛型与继承的关系
 * 4.通配符
 *
 *
 */
public class TestGeneric {

    //自定义泛型类的使用
    @Test
    public void test4(){
        Order<Boolean> order = new Order<Boolean>();
//        order.getT();
        order.setT(true);
        System.out.println(order.getT());
        order.add();
        List<Boolean> list = order.list;


        SubOrder o = new SubOrder();


    }


    @Test
    public void test3(){
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("AA",78);
        map.put("BB",87);
        map.put("CC",98);
        Set<Map.Entry<String,Integer>> set = map.entrySet();
        for(Map.Entry<String,Integer> item : set){
            System.out.println(item.getKey() + "---->" + item.getValue());
        }

    }

    //2.在集合中使用泛型
    @Test
    public void test2(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(78);
        list.add(89);
        for(Integer item : list){
            int score = item;
            System.out.println(score);
        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


    //1.在集合中没有使用泛型的时候
    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(89);
        list.add(87);
        list.add(67);
        //1.没有使用泛型，作为Object子类均可以添加进来
        list.add(new String("AA"));
        //2.强转为Int时，强转可能报ClassCastException异常
        for(Object item : list){
            int score = (Integer)item;
            System.out.println(score);
        }

    }


}
