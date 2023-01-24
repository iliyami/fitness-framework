package History;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import Workout.WorkoutSession;

public class WorkoutHistoryController {
    private ArrayList<WorkoutHistory> workoutHistories;
    private static WorkoutHistoryController _instance = null;

    private WorkoutHistoryController() {
        workoutHistories = new ArrayList<WorkoutHistory>();
    }

    public static WorkoutHistoryController getInstance()
    {
        if (_instance == null)
            _instance = new WorkoutHistoryController();
  
        return _instance;
    }

    public List<WorkoutHistory> getWorkoutHistories() {
        return workoutHistories;
    }

    public void setWorkoutHistories(ArrayList<WorkoutHistory> workoutHistories) {
        this.workoutHistories = workoutHistories;
    }

    public Boolean saveHistory(WorkoutSession session) {
        
        return workoutHistories.add(new WorkoutHistory(session));
    }

    public WorkoutHistory getWorkoutHistoryById(int id){
        Iterator<WorkoutHistory> iterator = this.workoutHistories.iterator();
        while (iterator.hasNext()) {
            WorkoutHistory workoutHistory = iterator.next();
            if (workoutHistory.getId() == id) {
                return workoutHistory;
            }
        }
        return null;
    }

    public Boolean updateHistory(int workoutHistoryId, WorkoutSession session) {
        boolean isUpdated = false;
        for (int i = 0; i < workoutHistories.size(); i++) {
            final WorkoutHistory item = workoutHistories.get(i);
            if (item.getId() == workoutHistoryId) {
                workoutHistories.set(i, item.updateWorkoutHistory(session));
                isUpdated = true;
            }
        }
        return isUpdated;
    }

    public Boolean deleteHistory(int id) {
        boolean isDeleted = false;
        for (int i = 0; i < workoutHistories.size(); i++) {
            final WorkoutHistory item = workoutHistories.get(i);
            if (item.getId() == id) {
                workoutHistories.remove(i);
                isDeleted = true;
            }
        }
        return isDeleted;
    }
}