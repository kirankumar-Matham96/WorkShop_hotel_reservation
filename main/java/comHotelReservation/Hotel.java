package comHotelReservation;

public class Hotel {
    private String hotelName;
    private int rating;
    private int weekDayCostForRegularCustomer;
    private int weekEndCostForRegularCustomer;
    private int weekDayCostForRewardCustomer;
    private int weekEndCostForRewardCustomer;
    
    public String getHotelName() {
        return hotelName;
    }
    
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
    
    public int getRating() {
        return rating;
    }
    
    public void setRating(int rating) {
        this.rating = rating;
    }
    
    public int getWeekDayCostForRegularCustomer() {
        return weekDayCostForRegularCustomer;
    }
    
    public void setWeekDayCostForRegularCustomer(int weekDayCostForRegularCustomer) {
        this.weekDayCostForRegularCustomer = weekDayCostForRegularCustomer;
    }
    
    public int getWeekEndCostForRegularCustomer() {
        return weekEndCostForRegularCustomer;
    }
    
    public void setWeekEndCostForRegularCustomer(int weekEndCostForRegularCustomer) {
        this.weekEndCostForRegularCustomer = weekEndCostForRegularCustomer;
    }
    
    public int getWeekDayCostForRewardCustomer() {
        return weekDayCostForRewardCustomer;
    }
    
    public void setWeekDayCostForRewardCustomer(int weekDayCostForRewardCustomer) {
        this.weekDayCostForRewardCustomer = weekDayCostForRewardCustomer;
    }
    
    public int getWeekEndCostForRewardCustomer() {
        return weekEndCostForRewardCustomer;
    }
    
    public void setWeekEndCostForRewardCustomer(int weekEndCostForRewardCustomer) {
        this.weekEndCostForRewardCustomer = weekEndCostForRewardCustomer;
    }
}
