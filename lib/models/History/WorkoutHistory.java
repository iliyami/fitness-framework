package History;

import Workout.WorkoutSession;
import java.time.LocalDateTime;


public class WorkoutHistory {
    private int id;
    private LocalDateTime timestamp;
    private WorkoutSession workoutSession;

    public WorkoutHistory(int id, LocalDateTime timestamp, WorkoutSession workoutSession) {
        this.setId(id);
        this.setTimestamp(timestamp);
        this.setWorkoutSession(workoutSession);
    }

    public WorkoutHistory getWorkoutHistory(WorkoutSession workoutSession) {
        WorkoutHistory dummyhistory = new WorkoutHistory("", null, null);
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

    private void setWorkoutSession(WorkoutSession workoutSession) {
        this.workoutSession = workoutSession;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    private void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}