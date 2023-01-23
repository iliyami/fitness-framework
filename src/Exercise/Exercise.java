package Exercise;

import java.time.LocalDateTime;

/**
 * Exercise
 */
public class Exercise {
    private int id;
    private String name;
    private String instruction;
    private Integer popularity;
    private ExerciseType exerciseType;
    private Muscle targetMuscle;

    public Exercise(int id, String name, String instruction, int popularity, ExerciseType exerciseType, Muscle targetMuscle) {
        this.id = id;
        this.name = name;
        this.instruction = instruction;
        this.popularity = popularity;
        this.exerciseType = exerciseType;
        this.targetMuscle = targetMuscle;
    }

    public static Exercise createExercise(String name, String instruction, int popularity, ExerciseType exerciseType, Muscle targetMuscle) {
        final Exercise newExercise = new Exercise(LocalDateTime.now().hashCode(), name, instruction, popularity, exerciseType, targetMuscle);
        // TODO add to inventory
        return newExercise;
    }

    public Muscle getTargetMuscle() {
        return targetMuscle;
    }
    public void setTargetMuscle(Muscle targetMuscle) {
        this.targetMuscle = targetMuscle;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getInstruction() {
        return instruction;
    }
    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
    public int getPopularity() {
        return popularity;
    }
    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }
    public ExerciseType getExerciseType() {
        return exerciseType;
    }
    public void setExerciseType(ExerciseType exerciseType) {
        this.exerciseType = exerciseType;
    }
    public boolean updateExercise(String name, String instruction, int popularity, ExerciseType exerciseType, Muscle targetMuscle) {
        this.name = (name == null) ? this.name : name;
        this.instruction = (instruction == null) ? this.instruction : instruction;
        this.popularity = popularity;
        this.exerciseType = exerciseType;
        this.targetMuscle = targetMuscle;
        return true;
    }
}