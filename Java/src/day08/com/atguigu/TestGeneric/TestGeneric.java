package day08.com.atguigu.TestGeneric;

import org.junit.Test;

import java.util.*;

/**
 * 泛型的使用
 * 1.在集合中使用泛型
 * 2.自定义泛型类，泛型接口，泛型方法
 * 3.泛型与继承的关系
 * 4.通配符
 *  PS：不可以在static,trycatch块中修饰符中使用泛型的声明
 *  可以读取声明为通配符的集合类的对象
 *  不可以向声明为通配符的集合类中写入对象，除了null值.
 *
 */
public class TestGeneric {

    /**
     * 通配符 ?
     * List<所有> 是List<?>的子类
     *
     *  ? extends A 可以存放A及其子类
     *  ? super A 可以存放A及其父类
     *
     *
     */
    @Test
    public void test6(){
        List<?> list = null;
        List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list = list1;
        list = list2;
    }

    /**
     * 泛型与继承的关系
     * 若A是B的子类，那么List<A>就不是List<B>的子接口
     */
    @Test
    public void test5(){

        Object obj = null;
        String str = "AA";
        obj = str;

        Object [] obj1 = null;
        String[] str1 = new String[]{"AA","BB","CC","DD"};
        obj1 = str1;

        List<Object> list = null;
        List<String> list1 = new ArrayList<String>();
//        list = list1;    错误



    }


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
