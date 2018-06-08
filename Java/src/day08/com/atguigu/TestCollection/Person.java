package day08.com.atguigu.TestCollection;


public class Person implements Comparable{
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
//        int result = name != null ? name.hashCode() : 0;
//        result = 31 * result + age;
//        return result;
        final int prime = 31;
        int result = 1;
        result = prime * result + ((age == null) ? 0 : age.hashCode());
        result = prime * result + ((name == null) ? 0 : age.hashCode());
        return result;
    }

    public Person(){
        super();
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    //当向TreeSet中添加元素时，依据此方法决定排列顺序
    @Override
    public int compareTo(Object o) {
        if(o instanceof Person){
            Person p = (Person) o;
//            return this.age.compareTo(p.getAge());
            int i = this.age.compareTo(p.getAge());
            if (i == 0){
                return this.name.compareTo(p.getName());
            }else{
                return i;
            }

        }

        return 0;
    }
}
