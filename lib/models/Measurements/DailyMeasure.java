package Measurements;

import java.time.LocalDateTime;
import java.util.List;

public class DailyMeasure {
    private int id;
    private float height;
    private float weight;
    private LocalDateTime dateTime;
    private List<HeartBeat> heartBeatRecords;

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setHeight(float height) {
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
    
    public float getBMI() {
        return this.weight / (this.height * this.height);
    }
  
    public int getId() {
        return this.id;
    }

    public float getHeight() {
        return this.height;
    }

    public float getWeight() {
        return this.weight;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public List<HeartBeat> getHeartBeatRecords() {
        return this.heartBeatRecords;
    }

}