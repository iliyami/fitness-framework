import Measurements.MeasuresManagement;
import Measurements.DailyMeasure;

public class MockMeasurements {
    public static void main(String[] args) {
        DailyMeasure dailyMeasure = new DailyMeasure();
        dailyMeasure.setHeight(1.80);
        dailyMeasure.setWeight(80);
        System.out.println("BMI: ");
        System.out.println(dailyMeasure.getBMI());
    }
}
