package comHotelReservation;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class HotelRunnerTest {
    
    @Test
    public void givenRangeOfDates_returnCheapestHotelAtThatPeriod() {
        HotelRunner hotelRunner = new HotelRunner();
        Assert.assertEquals("Lakewood, total cost = 220",hotelRunner.costCalculator(LocalDate.parse("2020-09-10"), LocalDate.parse("2020-09-11")));
    }
}
