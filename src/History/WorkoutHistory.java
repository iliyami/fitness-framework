package History;

import Workout.WorkoutSession;
import java.time.LocalDateTime;


public class WorkoutHistory {
    private int id;
    private LocalDateTime timestamp;
    private WorkoutSession workoutSession;

    public WorkoutHistory(WorkoutSession workoutSession) {
        final LocalDateTime time = LocalDateTime.now();
        this.setId(time.toString().hashCode());
        this.setTimestamp(timestamp);
        this.setWorkoutSession(workoutSession);
    }

    public WorkoutHistory getWorkoutHistory(WorkoutSession workoutSession) {
        WorkoutHistory dummyhistory = new WorkoutHistory(workoutSession);
        return dummyhistory;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public WorkoutSession getWorkoutSession() {
        return workoutSession;
    }

    public void setWorkoutSession(WorkoutSession workoutSession) {
        this.workoutSession = workoutSession;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public WorkoutHistory updateWorkoutHistory(WorkoutSession workoutSession) {
        final WorkoutHistory tempWorkoutHistory = this;
        tempWorkoutHistory.workoutSession = workoutSession;
        tempWorkoutHistory.timestamp = LocalDateTime.now();
        return tempWorkoutHistory;
    }
}