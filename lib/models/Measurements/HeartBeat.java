package Measurements;

import java.time.LocalDateTime;

public class HeartBeat {
    private int id;
    private int beatsPerMinute;
    private LocalDateTime dateTime;

    public HeartBeat(int beatsPerMinute, LocalDateTime dateTime) {
        this.beatsPerMinute = beatsPerMinute;
        this.dateTime = dateTime;
    }

    public int getBeatsPerMinute() {
        return this.beatsPerMinute;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

}