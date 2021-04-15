package comHotelReservation;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class HotelRunnerTest {
    
    @Test
    /**
     * when given
     * check in date = 2020-09-11
     * checkout date = 2020-09-11
     */
    public void givenRangeOfDates_returnCheapestHotelAtThatPeriod1() {
        HotelRunner hotelRunner = new HotelRunner();
        Assert.assertEquals("Lakewood (rating: 3), total cost = 110", hotelRunner.cheapestHotel(LocalDate.parse("2020-09-11"), LocalDate.parse("2020-09-11")));
    }
    
    @Test
    /**
     * when given
     * check in date = 2020-09-11
     * checkout date = 2020-09-12
     */
    public void givenRangeOfDates_returnCheapestHotelAtThatPeriod2() {
        HotelRunner hotelRunner = new HotelRunner();
        Assert.assertEquals("Lakewood (rating: 3), total cost = 200\n" + "Bridgewood (rating: 4), total cost = 200", hotelRunner.cheapestHotel(LocalDate.parse("2020-09-11"), LocalDate.parse("2020-09-12")));
    }
    
    @Test
    public void givenRangeOfDates_returnCheapestBestRatedHotelAtThatPeriod() {
        HotelRunner hotelRunner = new HotelRunner();
        Assert.assertEquals("Bridgewood (rating: 4), total cost = 200", hotelRunner.cheapestBestRatedHotel(LocalDate.parse("2020-09-11"), LocalDate.parse("2020-09-12")));
    }
    
    @Test
    public void givenRangeOfDates_returnTopRatedHotelAtThatPeriod() {
        HotelRunner hotelRunner = new HotelRunner();
        Assert.assertEquals("Ridgewood (rating: 5), cost = 370", hotelRunner.topRatedHotel(LocalDate.parse("2020-09-11"), LocalDate.parse("2020-09-12")));
    }
}
