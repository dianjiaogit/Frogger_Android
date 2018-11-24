package com.example.jiaodian.frogger;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class Tests {

    @Test
    public void testInitialFrogCharacter() {
        assertEquals(1, Frog.id);
    }

    @Test
    public void testTotalLogNumber() {
        Logs logs = new Logs();
        for (int i = 1; i < 100; i++) {
            for (int j = 1; j < 100; j++) {
                logs = logs.create(i, j, 0, 200, 800, 400);
                assertEquals(i * j, logs.size());
            }
        }
    }

    @Test
    public void testTotalTruckNumber() {
        Trucks trucks = new Trucks();
        for (int i = 1; i < 100; i++) {
            for (int j = 1; j < 100; j++) {
                trucks = trucks.create(i, j, 0, 200, 800, 400);
                assertEquals(i * j, trucks.size());
            }
        }
    }

    @Test
    public void testLogDirection() {
        Logs logs = new Logs();
        for (int i = 1; i < 100; i++) {
            for (int j = 1; j < 100; j++) {
                logs.onTest = true;
                logs = logs.create(i, j, 0, 200, 800, 400);
                int toLeft = 0;
                int toRight = 0;
                for (Log l : logs) {
                    if (l.toLeft) {
                        toLeft += 1;
                    } else {
                        toRight += 1;
                    }
                }
                assertEquals(i * (int) Math.ceil((double) j / 2), toLeft);
                assertEquals(i * (j / 2), toRight);
            }
        }
    }

    @Test
    public void testTruckDirection() {
        Trucks trucks = new Trucks();
        for (int i = 1; i < 100; i++) {
            for (int j = 1; j < 100; j++) {
                trucks.onTest = true;
                trucks = trucks.create(i, j, 0, 200, 800, 400);
                int toLeft = 0;
                int toRight = 0;
                for (Truck l : trucks) {
                    if (l.toLeft) {
                        toLeft += 1;
                    } else {
                        toRight += 1;
                    }
                }
                assertEquals(i * (int) Math.ceil((double) j / 2), toLeft);
                assertEquals(i * (j / 2), toRight);
            }
        }
    }
}
