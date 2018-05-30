package day08.com.atguigu.polymorphism;

public class Man extends Person{
    private boolean smoking;

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    public boolean isSmoking() {
        return smoking;
    }

    public Man(){
        super();
    }

    public Man(boolean smoking){
        this.smoking = smoking;
    }

    public void eat(){
        System.out.println("男人吃饭");
    }

    public void walk(){
        System.out.println("男人走路");
    }

    public void entertainment(){
        System.out.println("男人娱乐");
    }

}
