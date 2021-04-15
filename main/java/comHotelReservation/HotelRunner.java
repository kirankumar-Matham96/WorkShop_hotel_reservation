package comHotelReservation;

import java.time.LocalDate;
import java.util.*;

public class HotelRunner {
    Map<String, Hotel> hotelMap = new HashMap<>();
    
    public Map<String, Hotel> getHotelMap() {
        return hotelMap;
    }
    
    public HotelRunner() {
        setHotelDetails();
    }
    
    /**
     * contains all the details of the different hotels
     */
    
    public void setHotelDetails() {
        
        //hotels
        Hotel hotel1 = new Hotel();
        Hotel hotel2 = new Hotel();
        Hotel hotel3 = new Hotel();
        
        //hotel1 details
        hotel1.setHotelName("Lakewood");
        hotel1.setWeekDayCostForRegularCustomer(110);
        hotel1.setWeekEndCostForRegularCustomer(90);
        
        //hotel2 details
        hotel2.setHotelName("Bridgewood");
        hotel2.setWeekDayCostForRegularCustomer(150);
        hotel2.setWeekEndCostForRegularCustomer(50);
        
        //hotel3 details
        hotel3.setHotelName("Ridgewood");
        hotel3.setWeekDayCostForRegularCustomer(220);
        hotel3.setWeekEndCostForRegularCustomer(150);
        
        hotelMap.put("Lakewood", hotel1);
        hotelMap.put("Bridgewood", hotel2);
        hotelMap.put("Ridgewood", hotel3);
    }
    
    /**
     * To find the cheapest hotel in the given dates
     */
    public void runnerForHotelRunner() {
        LocalDate checkInDate = LocalDate.parse(checkInDateTaker());
        LocalDate checkOutDate = LocalDate.parse(checkOutDateTaker());
        System.out.println(costCalculator(checkInDate, checkOutDate));
    }
    
    /**
     * to get the check-indate inputs from user
     *
     * @return
     */
    public String checkInDateTaker() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter check-in date: (YYYY-MM-DD)");
        String checkInDate = scanner.next();
        return checkInDate;
    }
    
    /**
     * to get the check-out date inputs from user
     *
     * @return
     */
    public String checkOutDateTaker() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter check-out date: (YYYY-MM-DD)");
        String checkOutDate = scanner.next();
        return checkOutDate;
    }
    
    /**
     * finds minimum
     */
    public int minimumFinder(int value1, int value2, int value3) {
        return (value1 < value2) ? ((value1 < value3) ? value1 : value3) : ((value2 < value3) ? value2 : value3);//ternary operators used
    }
    
    /**
     * date iterator
     *
     * @return
     */
    public String costCalculator(LocalDate checkin, LocalDate checkout) {
        
        int lakewoodCost = hotelMap.get("Lakewood").getWeekDayCostForRegularCustomer();
        int bridgewoodCost = hotelMap.get("Bridgewood").getWeekDayCostForRegularCustomer();
        int ridgewoodCost = hotelMap.get("Ridgewood").getWeekDayCostForRegularCustomer();
        
        for(LocalDate date = checkin; date.isBefore(checkout); date = date.plusDays(1)) {
            lakewoodCost += lakewoodCost;
            bridgewoodCost += bridgewoodCost;
            ridgewoodCost += ridgewoodCost;
        }
        
        int minCost = minimumFinder(lakewoodCost, bridgewoodCost, ridgewoodCost);
        
        if(lakewoodCost == minCost) {
            return "Lakewood, total cost = " + lakewoodCost;
        }
        if(bridgewoodCost == minCost) {
            return "Lakewood, total cost = " + bridgewoodCost;
        }
        if(ridgewoodCost == minCost) {
            return "Lakewood, total cost = " + ridgewoodCost;
        }
        return "more than one cheap hotels";
    }
}
