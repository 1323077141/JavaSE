package com.restruct.unit1;

/**
 * 影片
 */
public class Movie {
    public static final int REGULAR = 0;    //普通片
    public static final int NEW_RELEASE = 1;    //新片
    public static final int CHILDREND = 2;  //儿童片

    private String _title;  //标题
    private int _priceCode; //价格

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int priceCode) {
        _priceCode = priceCode;
    }

    public double getCharge(int daysRented){
        double result = 0;
        switch (getPriceCode()){
            case Movie.REGULAR:
                result += 2;
                if (daysRented > 2){
                    result += (daysRented - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += daysRented * 3;
                break;
            case Movie.CHILDREND:
                result += 1.5;
                if (daysRented > 3){
                    result += (daysRented - 3) * 1.5;
                }
                break;
        }
        return result;
    }

    /**
     * 常客积分计算
     * @return
     */
    int getFrequentRentalPoints(int daysRented){
        if ((getPriceCode() == Movie.NEW_RELEASE) &&
                daysRented > 1)
            return 2;
        else
            return 1;
    }
}
