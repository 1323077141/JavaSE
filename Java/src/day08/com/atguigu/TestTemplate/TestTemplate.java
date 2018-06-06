package day08.com.atguigu.TestTemplate;

/**
 * 模板方法的设计模式
 * 抽象类模板:
 *  父类可将不确定的方法设定为抽象的，而由子类实现
 */
public class TestTemplate {
    public static void main(String[] args){
//        SubTemplate s = new SubTemplate();
//        s.spendTime();
        new SubTemplate().spendTime();
    }
}

abstract class Template{
    abstract void code();

    public void spendTime(){
        long start = System.currentTimeMillis();

        this.code();

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
class SubTemplate extends Template{
    public void code(){
        boolean flag = false;
        for(int i = 2; i <= 100000;i++){
            for(int j = 2; j <= Math.sqrt(i);j++){
                if(i % j == 0){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                System.out.println(i);
            }
            flag = false;
        }
    }
}


