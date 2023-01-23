import Measurements.MeasuresManagement;
import Measurements.DailyMeasure;

public class MockMeasurements {
    public static void main(String[] args) throws Exception {
        DailyMeasure dailyMeasure = new DailyMeasure(1.80, 80);
        dailyMeasure.recordHeartBeat();
        System.out.print("BMI: ");
        System.out.println(dailyMeasure.getBMI());

        MeasuresManagement measuresManagement = new MeasuresManagement();
        System.out.print("Initial daily measures: ");
        System.out.println(measuresManagement.getDailyMeasures());
        measuresManagement.addNewDailyMeasure(dailyMeasure);
        measuresManagement.removeDailyMeasure((dailyMeasure.getId()));
    }
}
