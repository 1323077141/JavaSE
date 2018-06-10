package day08.com.atguigu.TestCollection;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

/**
 * Map:
 * key是不可重复的，使用Set存放。value可以重复的，使用Collection来存放的。
 *  一个key-value对构成一个entry(Map.Entry)，entry使用Set来存放
 *
 *
 */
public class TestMap {

    /**
     * Properties:
     *
     */
    @Test
    public void test6() throws Exception{
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File("jdbc.properties")));
        String user = properties.getProperty("user");
        System.out.println(user);
        String password = properties.getProperty("password");
        System.out.println(password);
    }

    @Test
    public void test5(){
        Comparator com =  new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //......
                return 0;
            }
        };
        Map map = new TreeMap(com);
        map.put(new Person("AA",23),89);
        map.put(new Person("BB",22),84);
        map.put(new Person("CC",33),83);
        map.put(new Person("DD",21),85);
        map.put(new Person("EE",23),82);
        Set entrySet = map.entrySet();
        for(Object item : entrySet){
            Map.Entry entry = (Map.Entry) item;
            System.out.println(entry.getKey() + "------------" +entry.getValue());
        }
    }

    //自然排序
    @Test
    public void test4(){
        Map map = new TreeMap();
        map.put(new Person("AA",23),89);
        map.put(new Person("BB",22),84);
        map.put(new Person("CC",33),83);
        map.put(new Person("DD",21),85);
        map.put(new Person("EE",23),82);
        Set entrySet = map.entrySet();
        for(Object item : entrySet){
            Map.Entry entry = (Map.Entry) item;
            System.out.println(entry.getKey() + "------------" +entry.getValue());
        }
    }


    @Test
    public void test3(){
        Map map = new LinkedHashMap();
        map.put("AA",123);
        map.put("BB",456);
        map.put(123,"CC");
        map.put(null,null);
        map.put(new Person("DD",23),89);
        Set entrySet = map.entrySet();
        for(Object item : entrySet){
            Map.Entry entry = (Map.Entry) item;
            System.out.println(entry.getKey() + "------------" +entry.getValue());
        }
    }


    /**
     * 遍历Map
     * Set keySet()
     * Collection values()
     * Set entrySet()
     */
    @Test
    public void test2(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put("BB",456);
        map.put(123,"CC");
        map.put(null,null);
        map.put(new Person("DD",23),89);
        //1.遍历Key集
        Set set = map.keySet();
        for(Object obj : set){
            System.out.println(obj);
        }
        //2.遍历value集
        Collection values = map.values();
        Iterator iterator = values.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //3.遍历entrySet
        //方式1
        for(Object obj : set){
            System.out.println(obj + "------" + map.get(obj));
        }
        //方式2
        Set entrySet = map.entrySet();
        for(Object item : entrySet){
            Map.Entry entry = (Map.Entry) item;
            System.out.println(entry.getKey() + "------------" +entry.getValue());
        }
    }


    /**
     * Object put(Object key,Object value)  添加元素
     * Object remove(Object key)  删除元素
     * void putAll(Map t)  添加t中所有的元素
     * void clear()   清空集合
     * Object get(Object key)   根据 key 获取 value 值，若无此key，返回null值
     * boolean containsKey(Object key)  是否包含该key
     * boolean containsValue(Object value) 是否包含该value
     * int size()    该集合的长度
     * boolean isEmpty()   是否为空
     * boolean equals(Object obj)
     */
    @Test
    public void testMap(){

        Map map = new HashMap();
        map.put("AA",123);
        map.put("BB",456);
        map.put(123,"CC");
        map.put(null,null);
        map.put(new Person("DD",23),89);
        map.put(new Person("DD",23),87);  //key为set集合
        System.out.println(map.size());
        //向HashMap中添加元素时，会调用key所在类的equals方法，判断两个key是否相同。
        //若相同，只能添加进后添加的元素
    }

}
