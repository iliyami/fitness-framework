package Measurements;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DailyMeasure {
    private static int count = 0;
    private int id;
    private double height;
    private double weight;
    private LocalDate date;
    private List<HeartBeat> heartBeatRecords;

    public DailyMeasure(double height, double weight) {
        this.id = count++;
        this.setHeight(height);
        this.setWeight(weight);
        this.date = LocalDate.now();
        this.heartBeatRecords = new ArrayList<HeartBeat>();
    }

    public void addHeartBeatRecord(HeartBeat heartBeat) {
        this.heartBeatRecords.add(heartBeat);
    }

    public void removeHeartBeatRecord(int heartBeatId) {
        return;
    }

    public void recordHeartBeat() {
        Random random = new Random();
        int LOW = 20;
        int HIGH = 150;
        int beatsPerMinute = random.nextInt(HIGH - LOW) + LOW;
        HeartBeat heartBeat = new HeartBeat(beatsPerMinute, LocalDateTime.now());
        this.heartBeatRecords.add(heartBeat);
    }

    public void setWeight(double weight) {
        if (weight < 0) {
            throw new Error("weight value must be positive");
        }
        this.weight = weight;
    }

    public void setHeight(double height) {
        if (height < 0) {
            throw new Error("height value must be positive");
        }
        this.height = height;
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

    public LocalDate getDate() {
        return this.date;
    }

    public List<HeartBeat> getHeartBeatRecords() {
        return this.heartBeatRecords;
    }

    public double getBMI() {
        return this.weight / (this.height * this.height);
    }

}