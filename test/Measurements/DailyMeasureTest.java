package test.Measurements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

import Measurements.DailyMeasure;

public class DailyMeasureTest {
    DailyMeasure dailyMeasure;

    public DailyMeasureTest() throws Exception {
        dailyMeasure = new DailyMeasure(1.8, 80);
    }

    @Test
    public void testGetId() {
        assertEquals(0, dailyMeasure.getId());
    }

    @Test
    public void testGetHeight() {
        assertEquals(1.8, dailyMeasure.getHeight(), 0.001);
    }

    @Test
    public void testGetWeight() {
        assertEquals(80, dailyMeasure.getWeight(), 0.001);
    }

    @Test
    public void testGetDate() {
        assertEquals(LocalDate.class, dailyMeasure.getDate().getClass());
    }

    @Test
    public void testGetHeartBeatRecords() {
        assertTrue(dailyMeasure.getHeartBeatRecords().isEmpty());

    }

    @Test
    public void testGetBMI() {
        assertEquals(80 / (1.8 * 1.8), dailyMeasure.getBMI(), 0.001);
    }
}