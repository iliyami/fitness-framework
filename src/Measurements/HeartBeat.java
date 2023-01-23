package Measurements;

import java.time.LocalDateTime;

public class HeartBeat {
    private static int count = 0;
    private int id;
    private int beatsPerMinute;
    private LocalDateTime dateTime;

    public HeartBeat(int beatsPerMinute, LocalDateTime dateTime) {
        this.id = count++;
        this.setBeatsPerMinute(beatsPerMinute);
        this.dateTime = dateTime;
    }

    public void setBeatsPerMinute(int beatsPerMinute) {
        if (beatsPerMinute < 0) {
            throw new Error("heart beats per minute value must be positive");
        }
        this.beatsPerMinute = beatsPerMinute;
    }

    public int getId() {
        return this.id;
    }

    public int getBeatsPerMinute() {
        return this.beatsPerMinute;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }
}