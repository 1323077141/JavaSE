package Java8.com.atguigu.Lambda;

import org.junit.Test;

import java.util.*;

public class TestLambda {

    //原来的匿名内部类
    @Test
    public void test1(){
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        TreeSet<Integer> ts = new TreeSet<>(com);
    }
    //Lambda
    @Test
    public void test2(){
         Comparator com = (x,y) ->Integer.compare(x,y);
         TreeSet<Integer> ts = new TreeSet<>(com);
    }

    List<Employee> employees = Arrays.asList(
            new Employee("张三",18,5555),
            new Employee("李四",20,9999),
            new Employee("王五",38,6666),
            new Employee("赵六",28,8888),
            new Employee("田七",48,7777)
    );

    public List<Employee> filterEmployees(List<Employee> list){
        List<Employee> emps = new ArrayList<>();
        for (Employee item : list){
            if (item.getAge() >= 35){
                emps.add(item);
            }
        }
        return emps;
    }

    //优化方式1:设计模式


}
