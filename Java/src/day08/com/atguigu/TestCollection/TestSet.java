package day08.com.atguigu.TestCollection;

import org.junit.Test;

import java.util.*;

/**
 *  set中常用的方法都是Collection下的定义的
 */
public class TestSet {

    /**
     *
     * Set中元素的存储是使用Hash算法的
         * 不可重复性:调用equals方法判断两者是否相同,Object中的equals方法是比较地址，
         * 因此在set中添加自定义类，必需重写equals和hasCode方法；首先调用HasCode方法,再调用equals方法
     *
     */
    @Test
    public void testHashSet1(){

        Set set = new HashSet();
        set.add(123);
        set.add(456);
        set.add(new String("AA"));
        set.add(new String("BB"));
        set.add(null);
        set.add(new Person("Tom",12));
        set.add(new Person("Tom",12));
        System.out.println(set.size());
        System.out.println(set);   //set是无序的:存储位置是无序的
    }

    /**
     * 使用链表维护了一个添加进集合中的顺序。当遍历集合元素时，是按照添加顺序遍历的。但是存储位置是无序的。
     * LinkedHashSet插入性能略低于HashSet,但在迭代访问Set中全部元素时有很好的性能。
     *
     */
    @Test
    public void testLinkedHashSet(){
        Set set = new LinkedHashSet();
        set.add(123);
        set.add(456);
        set.add(new String("AA"));
        set.add(new String("BB"));
        set.add(null);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }


    /**
     *  1.TreeSet在添加元素时，必须为同一类型
     *  2.可以按照元素的指定顺序遍历,如String,包装类默认是以从小到大的顺序遍历的。
     *  3.当向TreeSet中添加自定义类时，有两种排序方式:①自然排序②定制排序
     *  4.自然排序。要求自定义类实现java.lang.Comparable接口并重写CompareTo方法，在此方法中，指明按照哪个属性排序
     *  5.向TreeSet中添加元素时，首先按照compareTo方法进行比较，一旦返回0，虽然仅是这两个属性值相同，但是程序会认为这两个对象是相同的
     *  进而后一个对象就不能添加进来。
     *
     *  compareTo与HashCode与equals三者保持一致。
     *
     */
    @Test
    public void testTreeSet(){

        Set set = new TreeSet();
//        set.add("CC");
//        set.add("DD");
//        set.add("EE");
//        set.add(new String("AA"));
//        set.add(new String("BB"));
        set.add(new Person("CC",23));
        set.add(new Person("MM",21));
        set.add(new Person("GG",25));
        set.add(new Person("JJ",24));
        set.add(new Person("DD",20));
        set.add(new Person("KK",20));

        for (Object item : set){
            System.out.println(item);
        }

    }

    /**
     * 定制排序:
     *
     */
    @Test
    public void testTreeSet2(){
        //1.创建一个实现了Comparator接口的类对象
        Comparator com = new Comparator() {
            //2.向TreeSet中添加Customer对象，在此方法中指明是按照Customer的哪个属性排序的

            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Customer && o2 instanceof Customer){
                    Customer c1 = (Customer) o1;
                    Customer c2 = (Customer) o2;
                    int i = c1.getId().compareTo(c2.getId());
                    if(i == 0){
                        return c1.getName().compareTo(c2.getName());
                    }else{
                        return i;
                    }
                }
                return 0;
            }
        };

        //2.将此对象作为形参传递给TreeSet的构造器中
        TreeSet set = new TreeSet(com);
        //3.添加元素
        set.add(new Customer("AA",1003));
        set.add(new Customer("BB",1002));
        set.add(new Customer("GG",1004));
        set.add(new Customer("AA",1004));
        set.add(new Customer("DD",1001));
        set.add(new Customer("CC",1007));

        for(Object item : set){
            System.out.println(item);
        }
    }

    @Test
    public void testTreeSet3(){
        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Customer && o2 instanceof Customer){
                    Customer c2 = (Customer) o2;
                    Customer c1 = (Customer) o1;
                    int i = c1.getId().compareTo(c2.getId());
                    if(i == 0){
                        return c1.getName().compareTo(c2.getName());
                    }
                    return i;
                }
                return 0;
            }
        });
        set.add(new Customer("AA",1003));
        set.add(new Customer("BB",1002));
        set.add(new Customer("GG",1004));
        set.add(new Customer("AA",1004));
        set.add(new Customer("DD",1001));
        set.add(new Customer("CC",1007));

        for(Object item : set){
            System.out.println(item);
        }
    }

}
