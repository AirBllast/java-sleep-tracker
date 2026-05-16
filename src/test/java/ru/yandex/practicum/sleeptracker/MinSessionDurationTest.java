package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

public class MinSessionDurationTest {

    @Test
    public void getMinSessionDuration() {
        List<SleepingSession> sleepingSessions = List.of(
                new SleepingSession(
                        LocalDateTime.of(2025, 10, 1, 23, 0),
                        LocalDateTime.of(2025, 10, 2, 6, 0),
                        SleepingQuality.GOOD
                ),
                new SleepingSession(
                        LocalDateTime.of(2025, 10, 5, 23, 0),
                        LocalDateTime.of(2025, 10, 6, 7, 0),
                        SleepingQuality.GOOD
                )
        );

        MinSessionDuration minSessionDuration = new MinSessionDuration();

        Assertions.assertEquals("420 мин", minSessionDuration.analyze(sleepingSessions).getResult());
    }

    @Test
    public void shouldReturnZeroIfSessionIsEmpty() {
        List<SleepingSession> sleepingSessions = List.of();
        MinSessionDuration minSessionDuration = new MinSessionDuration();

        Assertions.assertEquals("0 мин", minSessionDuration.analyze(sleepingSessions).getResult());
    }
}

