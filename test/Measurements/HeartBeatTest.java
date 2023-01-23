package test.Measurements;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import Measurements.HeartBeat;

public class HeartBeatTest {
    private HeartBeat heartBeat1;
    private HeartBeat heartBeat2;

    @Before
    public void runBeforeTests() throws Exception {
        heartBeat1 = new HeartBeat(60, LocalDateTime.now());
        heartBeat2 = new HeartBeat(80, LocalDateTime.now());
    }

    @Test
    public void testGetId() {
        assertEquals(heartBeat2.getId(), heartBeat1.getId() + 1);
    }

    @Test(expected = Exception.class)
    public void testInvalidConstructorHeartBeatsPerMinute() throws Exception {
        new HeartBeat(-10, LocalDateTime.now());
    }


    @Test
    public void testGetDateTime() {
        assertEquals(LocalDateTime.class, heartBeat1.getDateTime().getClass());
        assertEquals(LocalDateTime.class, heartBeat2.getDateTime().getClass());
    }

    @Test
    public void testGetBeatsPerMinute() {
        assertEquals(60, heartBeat1.getBeatsPerMinute());
        assertEquals(80, heartBeat2.getBeatsPerMinute());
    }

    @Test
    public void testSetBeatsPerMinute() throws Exception {
        heartBeat1.setBeatsPerMinute(100);
        assertEquals(100, heartBeat1.getBeatsPerMinute());
    }

    @Test(expected = Exception.class)
    public void testInvalidSetBeatsPerMinute() throws Exception {
        heartBeat1.setBeatsPerMinute(-1);
    }
}