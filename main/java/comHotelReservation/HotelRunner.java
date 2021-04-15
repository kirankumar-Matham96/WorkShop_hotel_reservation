package comHotelReservation;

import java.util.ArrayList;
import java.util.List;

public class HotelRunner {
    
    /**
     * contains all the details of the different hotels
     */
    public void setHotelDetails(){
        List<Hotel> hotelList = new ArrayList<>();
    
        //hotels
        Hotel hotel1 = new Hotel();
        Hotel hotel2 = new Hotel();
        Hotel hotel3 = new Hotel();
    
        //hotel1 details
        hotel1.setHotelName("Lakewood");
        hotel1.setRating(3);
        hotel1.setWeekDayCostForRegularCustomer(110);
        hotel1.setWeekEndCostForRegularCustomer(90);
    
        //hotel2 details
        hotel2.setHotelName("Bridgewood");
        hotel2.setRating(4);
        hotel2.setWeekDayCostForRegularCustomer(160);
        hotel2.setWeekEndCostForRegularCustomer(60);
    
        //hotel3 details
        hotel3.setHotelName("Ridgewood");
        hotel3.setRating(5);
        hotel3.setWeekDayCostForRegularCustomer(220);
        hotel3.setWeekEndCostForRegularCustomer(150);
    
        //adding hotels to the hotel list
        hotelList.add(hotel1);
        hotelList.add(hotel2);
        hotelList.add(hotel3);
    }
}
