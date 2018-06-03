package day08.com.atguigu.TestStatic;

public class TestStatic {

    public static void main(String[] args){
        SportsMan m1 = new SportsMan("金龙",23);
        m1.nation = "中国";
        SportsMan m2 = new SportsMan("银龙",21);
        System.out.println(m1);
        System.out.println(m2);
    }

}
class SportsMan{
    String name;
    int age;
    static String nation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public SportsMan(){

    }

    public SportsMan(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "SportsMan{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nation=" + nation +
                '}';
    }
}
