package Exercise;
/**
 * Exercise
 */
public class Exercise {
    private int id;
    private String name;
    private String instruction;
    private Integer popularity;
    private ExerciseType exerciseType;

    public Exercise(int id, String name, String instruction, int popularity, ExerciseType exerciseType) {
        this.id = id;
        this.name = name;
        this.instruction = instruction;
        this.popularity = popularity;
        this.exerciseType = exerciseType;
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
    public boolean updateExercise(String name, String instruction, int popularity, ExerciseType exerciseType) {
        this.name = (name == null) ? this.name : name;
        this.instruction = (instruction == null) ? this.instruction : instruction;
        this.popularity = popularity;
        this.exerciseType = exerciseType;
        return true;
    }
}