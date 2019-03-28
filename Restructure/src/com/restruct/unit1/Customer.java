package com.restruct.unit1;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 顾客
 */
public class Customer {
    private String _name;
    private Vector _rentals = new Vector(); //租赁的记录

    public Customer(String name){
        _name = name;
    }

    public void addRentals(Rental rental){
        _rentals.addElement(rental);
    }

    public String getName(){
        return _name;
    }

    /**
     * 重构:
     * 1.提取switch代码
     * 2.提取多余的临时变量
     * 3.提炼“常客积分计算”代码:
     * 4.提取计算总量代码
     *
     * @return
     */
    public String statement(){
//        double totalAmount = 0;
//        int frequentRenterPoints = 0;
        Enumeration retals = _rentals.elements();
        String result = "Rental Record for " + getName() + " \n ";
        while(retals.hasMoreElements()){
            Rental each = (Rental) retals.nextElement();
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }
        result += "Amount owed id " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    //总量:相当于totalAmount
    private double getTotalCharge(){
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()){
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    //积分总量:相当于frequentRenterPoints
    private int getTotalFrequentRenterPoints(){
        int result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()){
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRentalPoints();
        }
        return result;
    }

    public static void main(String[] args) {
        //重构准备:准备测试
        Movie movie1 = new Movie();
        movie1.setPriceCode(Movie.REGULAR);
        movie1.setTitle("普通票");

        Movie movie2 = new Movie();
        movie2.setTitle("新票");
        movie2.setPriceCode(Movie.NEW_RELEASE);

        Movie movie3 = new Movie();
        movie3.setTitle("儿童票");
        movie3.setPriceCode(Movie.CHILDREND);

        Rental rental1 = new Rental(movie1,2);
        Rental rental2 = new Rental(movie2,10);
        Rental rental3 = new Rental(movie3,1);
        Customer customer = new Customer("Tom");
        customer.addRentals(rental1);
        customer.addRentals(rental2);
        customer.addRentals(rental3);
        System.out.println(customer.statement());
    }

}
