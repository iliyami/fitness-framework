package test.Measurements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Measurements.DailyMeasure;
import Measurements.MeasuresManagement;

public class MeasuresManagementTest {
    MeasuresManagement measuresManagement;

    public MeasuresManagementTest() {
        measuresManagement = new MeasuresManagement();
    }

    @Test
    public void testEmptyDailyMeasures() {
        assertTrue(measuresManagement.getDailyMeasures().isEmpty());
    }

    @Test
    public void testAddOneNewDailtMeasure() throws Exception {
        DailyMeasure dailyMeasure = new DailyMeasure(1.80, 80);
        measuresManagement.addNewDailyMeasure(dailyMeasure);
        assertEquals(1, measuresManagement.getDailyMeasures().size());
        measuresManagement.removeDailyMeasure(dailyMeasure.getId());
        assertEquals(0, measuresManagement.getDailyMeasures().size());
    }

    @Test
    public void testAddManyNewDailtMeasure() throws Exception {
        DailyMeasure dailyMeasure1 = new DailyMeasure(1.80, 80);
        DailyMeasure dailyMeasure2 = new DailyMeasure(1.90, 100);
        measuresManagement.addNewDailyMeasure(dailyMeasure1);
        measuresManagement.addNewDailyMeasure(dailyMeasure2);
        assertEquals(2, measuresManagement.getDailyMeasures().size());
        measuresManagement.removeDailyMeasure(dailyMeasure1.getId());
        measuresManagement.removeDailyMeasure(dailyMeasure2.getId());
    }

    @Test
    public void testRemoveDailtMeasure() throws Exception {
        DailyMeasure dailyMeasure = new DailyMeasure(1.80, 80);
        measuresManagement.addNewDailyMeasure(dailyMeasure);
        measuresManagement.removeDailyMeasure(-2);
        assertEquals(1, measuresManagement.getDailyMeasures().size());
        measuresManagement.removeDailyMeasure(dailyMeasure.getId());
        assertEquals(0, measuresManagement.getDailyMeasures().size());
    }
}