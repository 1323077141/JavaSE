package day08.com.atguigu.TestFactoryMethod;

/**
 * 工厂方法设计模式
 * Created by Administrator on 2018-06-06.
 */
public class TestFactoryMethod {

    public static void main(String [] args){
        IWorkFactory i = new StudentWorkFactory();
        i.getWork().doWork();

        IWorkFactory i1 = new TeacherWorkFactory();
        i1.getWork().doWork();

    }

}

interface IWorkFactory{
    Work getWork();
}

class StudentWorkFactory implements IWorkFactory{

    @Override
    public Work getWork() {
        return new StudentWork();
    }
}

class TeacherWorkFactory implements IWorkFactory{

    @Override
    public Work getWork() {
        return new TeacherWork();
    }
}

interface Work{
    void doWork();

}

class StudentWork implements Work{

    @Override
    public void doWork() {
        System.out.println("学生工作");
    }
}

class TeacherWork implements Work{

    @Override
    public void doWork() {
        System.out.println("老师工作");
    }
}

