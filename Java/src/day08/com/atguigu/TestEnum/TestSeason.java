package day08.com.atguigu.TestEnum;


public class TestSeason {
    public static  void main(String[] args){
        Season spring = Season.SPRING;
        System.out.println(spring);

        Season1[] season1s = Season1.values();  //获取枚举类的所有对象
        for (int i = 0; i < season1s.length ; i++){
            System.out.println(season1s[i]);
        }
        String str = "SPRING";
        Season1 sea = Season1.valueOf(str);//返回该值对应的枚举类:报错(java.lang.IllegalArgumentException)
        System.out.println(sea);

        Thread.State[] states = Thread.State.values();
        for(int i = 0; i < states.length ; i++){
            System.out.println(states[i]);
        }

    }



}
//枚举类
class Season{
    //1.提供类的属性，声明为 private final
    private final String seasonName;
    private final String seansonDesc;
    //2.声明为final 的属性在构造中初始化
    private Season(String seasonName,String seansonDesc){
        this.seasonName = seasonName;
        this.seansonDesc = seansonDesc;
    }
    //3.通过公共的方法调用属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeansonDesc() {
        return seansonDesc;
    }

    //4.构造枚举类的对象
    public static final Season SPRING = new Season("spring","春天");
    public static final Season SUMMER = new Season("summer","夏天");
    public static final Season AUTUMN = new Season("autumn","秋天");
    public static final Season WINTER = new Season("winter","冬天");
}
//枚举类
enum Season1{
    SPRING("spring","春天"),
    SUMMER("summer","夏天"),
    AUTUMN("autumn","秋天"),
    WINTER("winter","冬天");

    private final String seasonName;
    private final String seansonDesc;
    private Season1(String seasonName,String seansonDesc){
        this.seasonName = seasonName;
        this.seansonDesc = seansonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeansonDesc() {
        return seansonDesc;
    }
}
