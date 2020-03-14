

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Pallabi
 */
public class HotelComparison {

    private static final HotelInformation[] hotel = new HotelInformation[3];
    private String cheapestHotelName, customerType;
    private String[] bookingDates;

    public HotelComparison() {
        cheapestHotelName = "";
        customerType = "";
        bookingDates = new String[]{};
        hotel[0] = new HotelInformation("GreenValley", 3, 1100, 900, 800, 800);
        hotel[1] = new HotelInformation("RedRiver", 4, 1600, 600, 1100, 500);
        hotel[2] = new HotelInformation("BlueHills", 5, 2200, 1500, 1000, 400);
    }

    public void inputProcess(String input) {
        String[] arr = input.split(":");
        if (arr.length > 0) {
            customerType = arr[0];
            bookingDates = arr[1].split(",");
        }
    }

    public void calculate() {
        int numOfWeekdays = 0;
        int numOfWeekends = 0;
        float final_price;
        try {
            for (String day : bookingDates) {
                if (day.contains("mon") || day.contains("tue") || day.contains("wed") || day.contains("thu")
                        || day.contains("fri")) {
                    numOfWeekdays++;
                } else {
                    numOfWeekends++;
                }
            }
            for (int i = 0; i < 3; i++) {
                if (customerType.equalsIgnoreCase("Regular")) {
                    final_price = numOfWeekdays * hotel[i].getRegularWeekDay() + numOfWeekends * hotel[i].getRegularWeekEnd();
                    hotel[i].setTotalPrice(final_price);
                } else if (customerType.equalsIgnoreCase("Rewards")) {
                    final_price = numOfWeekdays * hotel[i].getRewardeeWeekDay() + numOfWeekends * hotel[i].getRewardeeWeekEnd();
                    hotel[i].setTotalPrice(final_price);
                } else {
                    throw new HotelExceptions("Invalid customer type: Expected regular or rewardee");
                }
            }
        } catch (HotelExceptions e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

    }

    public void sort() {
        float minValue = hotel[0].getTotalPrice();
        int rating = hotel[0].getHotelRating();
        cheapestHotelName = hotel[0].getHotelName();
        for (int i = 1; i < 3; i++) {
            if (minValue > hotel[i].getTotalPrice()) {
                minValue = hotel[i].getTotalPrice();
                cheapestHotelName = hotel[i].getHotelName();
                rating = hotel[i].getHotelRating();
            } else if (minValue == hotel[i].getTotalPrice()) {
                if (hotel[i].getHotelRating() > rating) {
                    cheapestHotelName = hotel[i].getHotelName();
                    rating = hotel[i].getHotelRating();
                } else if (hotel[i].getHotelRating() == rating) {
                    cheapestHotelName = cheapestHotelName + " & " + hotel[i].getHotelName();
                }
            }
        }
    }

    public void display() {
        System.out.println(cheapestHotelName);
    }

    public static void main(String[] args) {
        HotelComparison obj = new HotelComparison();
       String input = "Regular: 16Mar2009, 17Mar2009, 18Mar2009";
       // String input = "Regular: 20Mar2009, 21Mar2009, 22Mar2009";
        //String input = "Rewards: 26Mar2009, 27Mar2009, 28Mar2009";
        obj.inputProcess(input);
        obj.calculate();
        obj.sort();
        obj.display();
    }
}
