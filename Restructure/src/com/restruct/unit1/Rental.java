package com.restruct.unit1;

/**
 * 租赁
 */
public class Rental {
    private Movie _movie;   //租赁的影片
    private int _daysRented;    //租赁的时长

    public Rental(Movie movie,int daysRented){
        _movie = movie;
        _daysRented = daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    /**
     * 最好不要在对象属性中使用switch,如果不得不使用,应该在对象自己的类中使用
     * @return
     */
    public double getCharge(){
        return _movie.getCharge(getDaysRented());
    }

    /**
     * 常客积分计算
     * @return
     */
    int getFrequentRentalPoints(){
       return _movie.getFrequentRentalPoints(_daysRented);
    }
}
