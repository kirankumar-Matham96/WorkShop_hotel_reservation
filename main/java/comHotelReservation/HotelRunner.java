package comHotelReservation;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class HotelRunner {
    
    //variables
    int lakewoodWeekDayCost;
    int bridgewoodWeekDayCost;
    int ridgewoodWeekDayCost;
    int lakewoodWeekendCost;
    int bridgewoodWeekendCost;
    int ridgewoodWeekendCost;
    int lakewoodWeekCost;
    int bridgewoodWeekCost;
    int ridgewoodWeekCost;
    Map<String, Hotel> hotelMap = new HashMap<>();
    
    /**
     * getter for hotelMap
     * @return
     */
    public Map<String, Hotel> getHotelMap() {
        return hotelMap;
    }
    
    /**
     * calls setHotelDetails method to set Hotel ratings and costs
     */
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
        hotel2.setRating(4);
        
        //hotel3 details
        hotel3.setHotelName("Ridgewood");
        hotel3.setWeekDayCostForRegularCustomer(220);
        hotel3.setWeekEndCostForRegularCustomer(150);
        hotel3.setRating(5);
        
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
        
        System.out.println("Select option:\n1.Find cheapest hotel\n2.Find cheapest best rated hotel\n3.Find top rated hotel\n4.Exit");
        Scanner scanner = new Scanner(System.in);
        switch(scanner.nextInt()) {
            case 1:
                System.out.println(cheapestHotel(checkInDate, checkOutDate));//to find cheapest hotel
                System.out.println("\n  Thanks for choosing our service!");
                break;
            case 2:
                System.out.println(cheapestBestRatedHotel(checkInDate, checkOutDate));//to find cheapest best rated hotel
                System.out.println("\n  Thanks for choosing our service!");
                break;
            case 3:
                System.out.println(topRatedHotel(checkInDate, checkOutDate));//to find best rated hotel
                System.out.println("\n  Thanks for choosing our service!");
                break;
            default:
                System.out.println("\n  Thanks for choosing our service!");
        }
    }
    
    /**
     * Finds the best rated hotel and cost
     *
     * @param checkInDate  check in date
     * @param checkOutDate checkout date
     * @return best rated hotel
     */
    public String topRatedHotel(LocalDate checkInDate, LocalDate checkOutDate) {
        int highestRated = maximumFinder(hotelMap.get("Lakewood").getRating(), hotelMap.get("Bridgewood").getRating(), hotelMap.get("Ridgewood").getRating());
        totalCostFinder(checkInDate, checkOutDate);
        
        if(highestRated == hotelMap.get("Lakewood").getRating()) {
            return "Lakewood (rating: " + highestRated + "), cost = " + lakewoodWeekCost;
        } else if(highestRated == hotelMap.get("Bridgewood").getRating()) {
            return "Bridgewood (rating: " + highestRated + "), cost = " + bridgewoodWeekCost;
        } else if(highestRated == hotelMap.get("Ridgewood").getRating()) {
            return "Ridgewood (rating: " + highestRated + "), cost = " + ridgewoodWeekCost;
        }
        return "All hotels rated the same!";
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
     *
     * @param value1 cost for hotel Lakewood
     * @param value2 cost for hotel Bridgewood
     * @param value3 cost for hotel Ridgewood
     * @return minimum cost
     */
    public int minimumFinder(int value1, int value2, int value3) {
        return (value1 < value2) ? ((value1 < value3) ? value1 : value3) : ((value2 < value3) ? value2 : value3);//ternary operators used
    }
    
    /**
     * returns maximum of two
     *
     * @param value1 rating for hotel 1 passed
     * @param value2 rating for hotel 2 passed
     * @return highest rating
     */
    public int maximumFinder(int value1, int value2) {
        return (value1 > value2) ? value1 : value2;//ternary operators used
    }
    
    /**
     * finds maximum
     *
     * @param value1 rating for hotel Lakewood
     * @param value2 rating for hotel Bridgewood
     * @param value3 rating for hotel Ridgewood
     * @return highest rating
     */
    public int maximumFinder(int value1, int value2, int value3) {
        return (value1 > value2) ? ((value1 > value3) ? value1 : value3) : ((value2 > value3) ? value2 : value3);//ternary operators used
    }
    
    /**
     * gets the day of the date given
     * date time API used
     *
     * @return
     */
    public DayOfWeek getDayOfDate(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day;
    }
    
    /**
     * Total cost finder
     *
     * @param checkin
     * @param checkout
     */
    public void totalCostFinder(LocalDate checkin, LocalDate checkout) {
        lakewoodWeekDayCost = hotelMap.get("Lakewood").getWeekDayCostForRegularCustomer();
        bridgewoodWeekDayCost = hotelMap.get("Bridgewood").getWeekDayCostForRegularCustomer();
        ridgewoodWeekDayCost = hotelMap.get("Ridgewood").getWeekDayCostForRegularCustomer();
        
        lakewoodWeekendCost = hotelMap.get("Lakewood").getWeekEndCostForRegularCustomer();
        bridgewoodWeekendCost = hotelMap.get("Bridgewood").getWeekEndCostForRegularCustomer();
        ridgewoodWeekendCost = hotelMap.get("Ridgewood").getWeekEndCostForRegularCustomer();
        
        for(LocalDate date = checkin; date.isBefore(checkout) || date.isEqual(checkout); date = date.plusDays(1)) {
            
            DayOfWeek day = getDayOfDate(date);
            
            if(day.toString().equals("SUNDAY") || day.toString().equals("SATURDAY")) {
                lakewoodWeekCost += lakewoodWeekendCost;
                bridgewoodWeekCost += bridgewoodWeekendCost;
                ridgewoodWeekCost += ridgewoodWeekendCost;
            } else {
                lakewoodWeekCost += lakewoodWeekDayCost;
                bridgewoodWeekCost += bridgewoodWeekDayCost;
                ridgewoodWeekCost += ridgewoodWeekDayCost;
            }
        }
    }
    
    /**
     * finds cheapest hotel
     */
    public String cheapestHotel(LocalDate checkin, LocalDate checkout) {
        totalCostFinder(checkin, checkout);
        int minCost = minimumFinder(lakewoodWeekCost, bridgewoodWeekCost, ridgewoodWeekCost);
        
        if(lakewoodWeekCost == minCost && ridgewoodWeekCost == minCost && bridgewoodWeekCost == minCost) {
            return "All hotels cost the same!\n" + "Lakewood (rating: " + hotelMap.get("Lakewood").getRating() + "), total cost = " + minCost + "\n" + "Bridgewood (rating: " + hotelMap.get("Bridgewood").getRating() + "), total cost = " + minCost + "\n" + "Ridgewood (rating: " + hotelMap.get("Ridgewood").getRating() + "), total cost = " + minCost;
        } else if(ridgewoodWeekCost == minCost && bridgewoodWeekCost == minCost) {
            return "Bridgewood (rating: " + hotelMap.get("Bridgewood").getRating() + "), total cost = " + minCost + "\n" + "Ridgewood (rating: " + hotelMap.get("Ridgewood").getRating() + "), total cost = " + minCost;
        } else if(lakewoodWeekCost == minCost && bridgewoodWeekCost == minCost) {
            return "Lakewood (rating: " + hotelMap.get("Lakewood").getRating() + "), total cost = " + minCost + "\n" + "Bridgewood (rating: " + hotelMap.get("Bridgewood").getRating() + "), total cost = " + minCost;
        } else if(lakewoodWeekCost == minCost && ridgewoodWeekCost == minCost) {
            return "Lakewood (rating: " + hotelMap.get("Lakewood").getRating() + "), total cost = " + minCost + "\n" + "Ridgewood (rating: " + hotelMap.get("Ridgewood").getRating() + "), total cost = " + minCost;
        } else if(lakewoodWeekCost == minCost) {
            return "Lakewood (rating: " + hotelMap.get("Lakewood").getRating() + "), total cost = " + minCost;
        } else if(bridgewoodWeekCost == minCost) {
            return "Bridgewood (rating: " + hotelMap.get("Bridgewood").getRating() + "), total cost = " + minCost;
        } else if(ridgewoodWeekCost == minCost) {
            return "Ridgewood (rating: " + hotelMap.get("Ridgewood").getRating() + "), total cost = " + minCost;
        }
        return "something went wrong!";
    }
    
    /**
     * finds the cheapest best rated hotel
     *
     * @return hotel name with rating and cost
     */
    public String cheapestBestRatedHotel(LocalDate checkin, LocalDate checkout) {
        
        totalCostFinder(checkin, checkout);
        int minCost = minimumFinder(lakewoodWeekCost, bridgewoodWeekCost, ridgewoodWeekCost);
        
        if(lakewoodWeekCost == minCost && ridgewoodWeekCost == minCost && bridgewoodWeekCost == minCost) {
            int highestRating = maximumFinder(hotelMap.get("Lakewood").getRating(), hotelMap.get("Bridgewood").getRating(), hotelMap.get("Ridgewood").getRating());
            if(highestRating == hotelMap.get("Lakewood").getRating()) {
                return "Lakewood (rating: " + highestRating + "), total cost = " + minCost;
            } else if(highestRating == hotelMap.get("Bridgewood").getRating()) {
                return "Bridgewood (rating: " + highestRating + "), total cost = " + minCost;
            } else if(highestRating == hotelMap.get("Ridgewood").getRating()) {
                return "Ridgewood (rating: " + highestRating + "), total cost = " + minCost;
            }
            return "All hotels rated the same!";
        } else if(ridgewoodWeekCost == minCost && bridgewoodWeekCost == minCost) {
            int highestRating = maximumFinder(hotelMap.get("Bridgewood").getRating(), hotelMap.get("Ridgewood").getRating());
            if(highestRating == hotelMap.get("Bridgewood").getRating()) {
                return "Bridgewood (rating: " + highestRating + "), total cost = " + minCost;
            } else if(highestRating == hotelMap.get("Ridgewood").getRating()) {
                return "Ridgewood (rating: " + highestRating + "), total cost = " + minCost;
            }
            return "Bridgewood (rating: " + highestRating + "), Ridgewood: total cost = " + minCost;
        } else if(lakewoodWeekCost == minCost && bridgewoodWeekCost == minCost) {
            int highestRating = maximumFinder(hotelMap.get("Lakewood").getRating(), hotelMap.get("Bridgewood").getRating());
            if(highestRating == hotelMap.get("Lakewood").getRating()) {
                return "Lakewood (rating: " + highestRating + "), total cost = " + minCost;
            } else if(highestRating == hotelMap.get("Bridgewood").getRating()) {
                return "Bridgewood (rating: " + highestRating + "), total cost = " + minCost;
            }
            return "Lakewood,Bridgewood (rating: " + highestRating + "): total cost = " + minCost;
        } else if(lakewoodWeekCost == minCost && ridgewoodWeekCost == minCost) {
            int highestRating = maximumFinder(hotelMap.get("Lakewood").getRating(), hotelMap.get("Ridgewood").getRating());
            if(highestRating == hotelMap.get("Lakewood").getRating()) {
                return "Lakewood (rating: " + highestRating + "), total cost = " + minCost;
            } else if(highestRating == hotelMap.get("Bridgewood").getRating()) {
                return "Ridgewood (rating: " + highestRating + "), total cost = " + minCost;
            }
            return "Lakewood,Ridgewood (rating: " + highestRating + "): total cost = " + minCost;
        } else if(lakewoodWeekCost == minCost) {
            return "Lakewood (rating: " + hotelMap.get("Lakewood").getRating() + "), total cost = " + minCost;
        } else if(bridgewoodWeekCost == minCost) {
            return "Bridgewood (rating: " + hotelMap.get("Bridgewood").getRating() + "), total cost = " + minCost;
        } else if(ridgewoodWeekCost == minCost) {
            return "Ridgewood (rating: " + hotelMap.get("Ridgewood").getRating() + "), total cost = " + minCost;
        }
        return "something went wrong!";
    }
}
