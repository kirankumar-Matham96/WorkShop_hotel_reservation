package comHotelReservation;

import java.time.DayOfWeek;
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
        hotel1.setRating(3);
        
        //hotel2 details
        hotel2.setHotelName("Bridgewood");
        hotel2.setWeekDayCostForRegularCustomer(150);
        hotel2.setWeekEndCostForRegularCustomer(50);
        hotel1.setRating(4);
        
        //hotel3 details
        hotel3.setHotelName("Ridgewood");
        hotel3.setWeekDayCostForRegularCustomer(220);
        hotel3.setWeekEndCostForRegularCustomer(150);
        hotel1.setRating(5);
        
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
     * gets the day of the date given
     * date time API used
     * @return
     */
    public DayOfWeek getDayOfDate(LocalDate date){
        DayOfWeek day = date.getDayOfWeek();
        return day;
    }
    
    /**
     * date iterator
     * and cost calculator
     * @return
     */
    public String costCalculator(LocalDate checkin, LocalDate checkout) {
        
        int lakewoodWeekDayCost = hotelMap.get("Lakewood").getWeekDayCostForRegularCustomer();
        int bridgewoodWeekDayCost = hotelMap.get("Bridgewood").getWeekDayCostForRegularCustomer();
        int ridgewoodWeekDayCost = hotelMap.get("Ridgewood").getWeekDayCostForRegularCustomer();
        
        int lakewoodWeekendCost = hotelMap.get("Lakewood").getWeekEndCostForRegularCustomer();
        int bridgewoodWeekendCost = hotelMap.get("Bridgewood").getWeekEndCostForRegularCustomer();
        int ridgewoodWeekendCost = hotelMap.get("Ridgewood").getWeekEndCostForRegularCustomer();
    
        int lakewoodWeekCost = 0;
        int bridgewoodWeekCost = 0;
        int ridgewoodWeekCost = 0;
        
        for(LocalDate date = checkin; date.isBefore(checkout) || date.isEqual(checkout); date = date.plusDays(1)) {
           
            DayOfWeek day = getDayOfDate(date);
           
            if(day.toString().equals("SUNDAY") || day.toString().equals("SATURDAY")){
                lakewoodWeekCost += lakewoodWeekendCost;
                bridgewoodWeekCost += bridgewoodWeekendCost;
                ridgewoodWeekCost += ridgewoodWeekendCost;
            }
            else{
                lakewoodWeekCost += lakewoodWeekDayCost;
                bridgewoodWeekCost += bridgewoodWeekDayCost;
                ridgewoodWeekCost += ridgewoodWeekDayCost;
            }
        }
        
        
    
        int minCost = minimumFinder(lakewoodWeekCost, bridgewoodWeekCost, ridgewoodWeekCost);
        
        if(lakewoodWeekCost == minCost && ridgewoodWeekCost == minCost && bridgewoodWeekCost == minCost){
            return "All hotels cost the same!";
        }
        else if(ridgewoodWeekCost == minCost && bridgewoodWeekCost == minCost){
            return "Ridgewood & Bridgewood, total cost = " + minCost;
        }
        else if(lakewoodWeekCost == minCost && bridgewoodWeekCost == minCost){
            return "Lakewood & Bridgewood, total cost = " + minCost;
        }
        else if(lakewoodWeekCost == minCost && ridgewoodWeekCost == minCost){
            return "Lakewood & Ridgewood, total cost = " + minCost;
        }
        else if(lakewoodWeekCost == minCost) {
            return "Lakewood, total cost = " + minCost;
        }
        else if(bridgewoodWeekCost == minCost) {
            return "Bridgewood, total cost = " + minCost;
        }
        else if(ridgewoodWeekCost == minCost) {
            return "Ridgewood, total cost = " + minCost;
        }
        return "something went wrong!";
    }
}
