import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import Exercise.Exercise;
import Exercise.ExerciseType;
import Workout.WorkoutPlan;
import Workout.WorkoutSession;
import Workout.ExercisePlan;
import Workout.MuscularExercisePlan;

public class MockExercise {
    public static void main(String[] args) throws InterruptedException {
        Exercise deadliftExercise = new Exercise(
			1, "deadlift", "how to do deadlift explanation", 90, ExerciseType.MUSCULAR
		);
		MuscularExercisePlan deadliftExercisePlan = new MuscularExercisePlan(
			1, 20, deadliftExercise, 10, 3, LocalTime.of(0,1,30)
		);

        List<ExercisePlan> exercisePlans = new ArrayList<ExercisePlan>();
		exercisePlans.add(deadliftExercisePlan);

        WorkoutPlan workoutPlan = new WorkoutPlan(1, "plan1", exercisePlans);

		WorkoutSession firstSession = new WorkoutSession(
			workoutPlan
		);
        
		firstSession.startSession();
		TimeUnit.SECONDS.sleep(5);
		firstSession.finishSession();
    }
}
