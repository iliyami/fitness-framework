package Measurements;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class MeasuresManagement {
    private List<DailyMeasure> dailyMeasures;

    public MeasuresManagement() {
        this.dailyMeasures = new ArrayList<DailyMeasure>();
    }

    public List<DailyMeasure> getDailyMeasures() {
        return this.dailyMeasures;
    }

    public List<DailyMeasure> getDailyMeasuresByDate(LocalDate date) {
        List<DailyMeasure> foundedMeasures = new ArrayList<DailyMeasure>();
        for (DailyMeasure dailyMeasure : dailyMeasures) {
            if (dailyMeasure.getDate().isEqual(date)) {
                foundedMeasures.add(dailyMeasure);
            }
        }
        return foundedMeasures;
    }

    public List<DailyMeasure> getDailyMeasuresBetween(LocalDate startDate, LocalDate endDate) {
        if (endDate.isBefore(startDate)) {
            throw new Error("end date should be after start data");
        }
        List<DailyMeasure> foundedMeasures = new ArrayList<DailyMeasure>();
        for (DailyMeasure dailyMeasure : dailyMeasures) {
            if (dailyMeasure.getDate().isAfter(startDate) && dailyMeasure.getDate().isBefore(startDate)) {
                foundedMeasures.add(dailyMeasure);
            }
        }
        return foundedMeasures;
    }

    public void addNewDailyMeasure(DailyMeasure dailyMeasure) {
        this.dailyMeasures.add(dailyMeasure);
    }

    public void removeDailyMeasure(int dailyMeasureId) {
        this.dailyMeasures.removeIf(dailyMeasure -> dailyMeasure.getId() == dailyMeasureId);
    }
}