package Measurements;

import java.util.List;
import java.time.LocalDate;

public class MeasuresManagement {
    private List<DailyMeasure> dailyMeasures;
    
    public List<DailyMeasure> getDailyMeasures() {
        return this.dailyMeasures;
    }

    public List<DailyMeasure> getDailyMeasuresByDate(LocalDate date) {
        return this.dailyMeasures;
    }

    public List<DailyMeasure> getDailyMeasuresBetween(LocalDate startDate, LocalDate endDate) {
        return this.dailyMeasures;
    }

    public void addNewDailyMeasure() {
        return;
    }

    public void removeDailyMeasure(int dailyMeasureId) {
        return;
    }
}