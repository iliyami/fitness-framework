
package Workout;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import Exercise.Exercise;

// using singleton
public class WorkoutSessionInventory {
    private static WorkoutSessionInventory singleWorkoutSessionInventory = null;
    private List<WorkoutSession> workoutSessions = new ArrayList<WorkoutSession>();
  
    public static WorkoutSessionInventory getInstance()
    {
        if (singleWorkoutSessionInventory == null){
        	singleWorkoutSessionInventory = new WorkoutSessionInventory();
        }
        return singleWorkoutSessionInventory;
    }
    
    public int workoutSessionsCount() {
    	return this.workoutSessions.size();
    }
    
    public WorkoutSession getWorkoutSessionById(int id){
        Iterator<WorkoutSession> iterator = this.workoutSessions.iterator();
        while (iterator.hasNext()) {
        	WorkoutSession workoutSession = iterator.next();
            if (workoutSession.getId() == id) {
                return workoutSession;
            }
        }
        return null;
    }

    public void addOrUpdateWorkoutSession(WorkoutSession workoutSession){
    	WorkoutSession existedworkoutSession = getWorkoutSessionById(workoutSession.getId());
        deleteWorkoutSession(existedworkoutSession);
        this.workoutSessions.add(workoutSession);
    }

    public void deleteWorkoutSession(WorkoutSession workoutSession){
    	workoutSessions.remove(workoutSession);
    }
}