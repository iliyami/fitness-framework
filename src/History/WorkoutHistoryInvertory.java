/* This singleton class is additional */
/* TODO should remove this file */

// package History;

// import java.util.ArrayList;
// import java.util.Iterator;
// import java.util.List;

// // using singleton
// public class WorkoutHistoryInvertory {
//     private static WorkoutHistoryInvertory singleWorkoutHistoryInvertory = null;
//     private List<WorkoutHistory> workoutHistories = new ArrayList<WorkoutHistory>();
  
//     public static WorkoutHistoryInvertory getInstance()
//     {
//         if (singleWorkoutHistoryInvertory == null){
//             singleWorkoutHistoryInvertory = new WorkoutHistoryInvertory();
//         }
//         return singleWorkoutHistoryInvertory;
//     }

//     public WorkoutHistory getWorkoutHistoryById(int id){
//         Iterator<WorkoutHistory> iterator = this.workoutHistories.iterator();
//         while (iterator.hasNext()) {
//             WorkoutHistory workoutHistory = iterator.next();
//             if (workoutHistory.getId() == id) {
//                 return workoutHistory;
//             }
//         }
//         return null;
//     }

//     public void addWorkoutHistory(WorkoutHistory workoutHistory){
//         WorkoutHistory existedWorkoutHistory = getWorkoutHistoryById(workoutHistory.getId());
//         if (existedWorkoutHistory == null)
//             this.workoutHistories.add(workoutHistory); 
//     }

//     public void updateWorkoutHistory(WorkoutHistory workoutHistory){
//         WorkoutHistory existedWorkoutHistory = getWorkoutHistoryById(workoutHistory.getId());
//         if(existedWorkoutHistory != null)
//             deleteWorkoutHistory(existedWorkoutHistory);
//         this.workoutHistories.add(workoutHistory);
//     }

//     public void deleteWorkoutHistory(WorkoutHistory workoutHistory){
//         workoutHistories.remove(workoutHistory);
//     }
// }