package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

public class BadSessionCountTest {

    @Test
    public void getBadSessionAmount() {

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
                ),
                new SleepingSession(
                        LocalDateTime.of(2025, 10, 6, 23, 0),
                        LocalDateTime.of(2025, 10, 7, 7, 0),
                        SleepingQuality.NORMAL
                ),
                new SleepingSession(
                        LocalDateTime.of(2025, 10, 7, 23, 0),
                        LocalDateTime.of(2025, 10, 8, 7, 0),
                        SleepingQuality.BAD
                )
        );

        BadSessionCount badSessionCount = new BadSessionCount();

        Assertions.assertEquals("2 раз(а)", badSessionCount.analyze(sleepingSessions).getResult());

    }

    @Test
    public void shouldReturnZeroIfSessionIsEmpty() {

        List<SleepingSession> sleepingSessions = List.of();

        BadSessionCount badSessionCount = new BadSessionCount();

        Assertions.assertEquals("0 раз(а)", badSessionCount.analyze(sleepingSessions).getResult());

    }
}
