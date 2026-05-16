package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

public class SleepingSessionCountTest {

    @Test
    public void getSleepingSessionAmount() {

        List<SleepingSession> sleepingSessions = List.of(
                new SleepingSession(
                        LocalDateTime.of(2025, 10, 1, 22, 15),
                        LocalDateTime.of(2025, 10, 2, 6, 15),
                        SleepingQuality.GOOD
                ),
                new SleepingSession(
                        LocalDateTime.of(2025, 10, 5, 23, 0),
                        LocalDateTime.of(2025, 10, 6, 7, 0),
                        SleepingQuality.BAD
                )
        );

        SleepingSessionsCount sleepingSessionsCount = new SleepingSessionsCount();

        Assertions.assertEquals("2 сессий", sleepingSessionsCount.analyze(sleepingSessions).getResult());

    }

    @Test
    public void shouldReturnZeroIfSessionIsEmpty() {

        List<SleepingSession> sleepingSessions = List.of();

        SleepingSessionsCount sleepingSessionsCount = new SleepingSessionsCount();

        Assertions.assertEquals("0 сессий", sleepingSessionsCount.analyze(sleepingSessions).getResult());

    }
}
