package com.conveyal.r5.point_to_point;

import com.conveyal.r5.streets.FileTravelTimeCalculator;
import com.conveyal.r5.streets.TravelTimeCalculator;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class PointToPointRouterServerTest {

    @Test
    public void testReadTravelTimes() {
        // Just see that this can be parsed without exception. Can't really unit-test this yet.
        TravelTimeCalculator travelTimeCalculator = new FileTravelTimeCalculator("test_data/r5_predicted_tt.csv");
        assertNotNull(travelTimeCalculator);
    }

}