package day08.com.atguigu.TestCollection;

import org.junit.Test;

import java.util.*;

/**
 * 存储对象:数组（基本数据类型  & 引用数据类型） ;集合（引用数据类型）
 * 数组存储对象:一旦创建长度不可变，不知道具体的的数组个数
 * 集合存储对象: Collection包含List(具体实现类Vector,ArrayList,LinkedList)和set子接口(具体实现类TreeSet,HashSet(->LinkedHashSet))
 *              Map实现类HashMap(->LinkedHashMap),HashTable(->Properties),TreeMap
 *Java集合分为Collection和Map体系
 *  Collection接口
 *      set:元素无序，不可重复
 *          TreeSet
 *          HashSet
 *              LinkedHashSet
 *      List:元素有序，可重复
 *          Vector
 *          ArrayList
 *          LinkedList
 *  Map接口：key-value 键值对
 *      HashMap
 *          LinkedHashMap
 *      HashTable
 *          Properties
 *      TreeMap
 *
 */
public class TestCollection {

    @Test
    public void testIterator(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add("AA");
        coll.add(new Date());
        coll.add("BB");
        Person p = new Person("MM",12);
        coll.add(p);
        Iterator iterator = coll.iterator();
        while (iterator.next() != null){
            //java.util.NoSuchElementException
            System.out.println(iterator.next());
        }

    }

    @Test
    public void testCollection3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add("AA");
        coll.add(new Date());
        coll.add("BB");
        Person p = new Person("MM",12);
        coll.add(p);
        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll1.add(new String("AA"));
        //10.removeAll(Collection coll)  删除与coll相同部分的元素
        coll.removeAll(coll1);
        //equals(Object obj):判断两个集合中的元素是否完全相同
        Collection coll2 = new ArrayList();
        coll2.add(123);
        coll2.add(new String("AA"));
        System.out.println(coll1.equals(coll2));   //true
        //12.hashCode()
        System.out.println(coll.hashCode());   //哈希值
        //13.toArray() 将集合转化为数组
        Object [] obj = coll.toArray();
        for(Object item: obj){
            System.out.println(item);
        }
        //14.iterator():返回一个Iterator接口实现类的对象  遍历集合元素
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }

    @Test
    public void testCollection2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add("AA");
        coll.add(new Date());
        coll.add("BB");
        Person p = new Person("MM",12);
        coll.add(p);
        //1.contains(Object o):判断依据------根据元素所在类的equals方法进行判断
        //String类已重写equals方法
        //若集合中的元素为自定义类，则需重写equals方法
        System.out.println(coll.contains(123)); //true
        boolean b2 = coll.contains(p);
        System.out.println(b2);   //true
        coll.add(new Person("MM",12));
        boolean b3 = coll.contains(new Person("MM",12));
        System.out.println(b3);   //false  ,若Person 类重写equals，则为true
        //7.containsAll(Collection coll)
        Collection coll2 = new ArrayList();
        coll2.add(123);
        coll2.add(new String("AA"));
        System.out.println(coll.containsAll(coll2));   //true
        //8.retainAll(Collection coll):保留与coll相同元素的部分,返回给当前集合
        coll.retainAll(coll2);
        System.out.println(coll);
        //9.remove(Object o)
        System.out.println(coll.remove("BB"));


    }

    @Test
    public void testCollection1(){
        Collection coll = new ArrayList();
        System.out.println(coll.size());   //元素个数
        coll.add(123);     //add(Object o),添加元素
        coll.add("AA");
        coll.add(new Date());
        coll.add("BB");
        System.out.println(coll.size());
        //3.addAll(Collection coll)
        Collection coll2 = Arrays.asList(1,2,3);
        coll.addAll(coll2);
        System.out.println(coll.size());
        //查看集合元素
        System.out.println(coll);
        //4.isEmpty(),是否为空
        System.out.println(coll.isEmpty());
        //5.clear() 清空集合元素
        coll.clear();
        System.out.println(coll.isEmpty());

    }

}
