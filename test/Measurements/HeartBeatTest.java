package test.Measurements;

import java.time.LocalDateTime;

import org.junit.Test;

import Measurements.HeartBeat;

public class HeartBeatTest {
    @Test(expected = Exception.class)
    public void testInvalidHeartBeatsPerMinute() throws Exception {
        HeartBeat heartBeat = new HeartBeat(-10, LocalDateTime.now());
    }
}