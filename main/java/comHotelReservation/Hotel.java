package comHotelReservation;

public class Hotel {
    private String hotelName;
    private float rating;
    private int weekDayCostForRegularCustomer;
    
    public String getHotelName() {
        return hotelName;
    }
    
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
    
    public float getRating() {
        return rating;
    }
    
    public void setRating(float rating) {
        this.rating = rating;
    }
    
    public int getWeekDayCostForRegularCustomer() {
        return weekDayCostForRegularCustomer;
    }
    
    public void setWeekDayCostForRegularCustomer(int weekDayCostForRegularCustomer) {
        this.weekDayCostForRegularCustomer = weekDayCostForRegularCustomer;
    }
}
