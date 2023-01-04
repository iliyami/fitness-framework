package Measurements;

import java.time.LocalDateTime;
import java.util.List;

public class DailyMeasure {
    private int id;
    private double height;
    private double weight;
    private LocalDateTime dateTime;
    private List<HeartBeat> heartBeatRecords;

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void addHeartBeatRecord(HeartBeat heartBeat) {
        this.heartBeatRecords.add(heartBeat);
    }

    public void removeHeartBeatRecord(int heartBeatId) {
        return;
    }

    public void recordHeartBeat() {
        return;
    }
    
    public double getBMI() {
        return this.weight / (this.height * this.height);
    }
  
    public int getId() {
        return this.id;
    }

    public double getHeight() {
        return this.height;
    }

    public double getWeight() {
        return this.weight;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public List<HeartBeat> getHeartBeatRecords() {
        return this.heartBeatRecords;
    }

}