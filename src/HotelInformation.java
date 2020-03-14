/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pallabi
 */


public class HotelInformation {
    String hotelName;
    private int regularWeekDay;
    private final int regularWeekEnd;
    private final int rewardWeekDay;
    private final int rewardWeekEnd;
    private int hotelRating;
    private float total_price;

    HotelInformation(String name, int rating, int regularWeekDay, int regularWeekEnd, 
            int rewardeeWeekDay, int rewardeeWeekEnd) {
        this.hotelName = name;
        this.hotelRating = rating;
        this.regularWeekDay = regularWeekDay;
        this.regularWeekEnd = regularWeekEnd;
        this.rewardWeekDay = rewardeeWeekDay;
        this.rewardWeekEnd = rewardeeWeekEnd;
        this.total_price = 0;
    }
     public String getHotelName() {
        return hotelName;
    }
    public int getHotelRating() {
        return hotelRating;
    }

    public int getRegularWeekDay() {
         return regularWeekDay;
    }

    public int getRegularWeekEnd() {
        return regularWeekEnd;
    }

    public int getRewardeeWeekDay() {
        return rewardWeekDay;
    }

    public int getRewardeeWeekEnd() {
        return rewardWeekEnd;
    }
    public void setTotalPrice(float price) {
        this.total_price = price;
    }
    public float getTotalPrice() {
        return total_price;
    }

}
