package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

public class SleeplessNightCountTest {

    @Test
    public void shouldCountMissingDatesAsSleeplessNights() {

        List<SleepingSession> sleepingSessions = List.of(
                new SleepingSession(
                        LocalDateTime.of(2025, 10, 1, 22, 15),
                        LocalDateTime.of(2025, 10, 2, 6, 15),
                        SleepingQuality.GOOD
                ),
                new SleepingSession(
                        LocalDateTime.of(2025, 10, 5, 23, 10),
                        LocalDateTime.of(2025, 10, 6, 9, 0),
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
                // Всего 8 суток - пропущены 3 ночи плюс 8.10 не лег спать
        );

        SleeplessNightCount sleeplessNightCount = new SleeplessNightCount();

        Assertions.assertEquals("4 ночей", sleeplessNightCount.analyze(sleepingSessions).getResult());
    }

    @Test
    public void shouldNotCountNightsAsSleepless() {

        List<SleepingSession> sleepingSessions = List.of(
                new SleepingSession(
                        LocalDateTime.of(2025, 10, 1, 2, 15),
                        LocalDateTime.of(2025, 10, 1, 6, 15),
                        SleepingQuality.GOOD
                ),
                new SleepingSession(
                        LocalDateTime.of(2025, 10, 2, 23, 15),
                        LocalDateTime.of(2025, 10, 3, 3, 0),
                        SleepingQuality.GOOD
                )
        ); // Всего 3 суток - спать ложился 2 раза - 1 ночь бессонная

        SleeplessNightCount sleeplessNightCount = new SleeplessNightCount();

        Assertions.assertEquals("1 ночей", sleeplessNightCount.analyze(sleepingSessions).getResult());
    }

    @Test
    public void shouldCountAsSleeplessNights() {

        List<SleepingSession> sleepingSessions = List.of(
                new SleepingSession(
                        LocalDateTime.of(2025, 10, 1, 17, 15),
                        LocalDateTime.of(2025, 10, 1, 23, 59),
                        SleepingQuality.GOOD
                ), // Бессонная ночь
                new SleepingSession(
                        LocalDateTime.of(2025, 10, 2, 6, 0),
                        LocalDateTime.of(2025, 10, 2, 14, 15),
                        SleepingQuality.GOOD
                ) // Бессонная ночь
        );

        SleeplessNightCount sleeplessNightCount = new SleeplessNightCount();

        Assertions.assertEquals("2 ночей", sleeplessNightCount.analyze(sleepingSessions).getResult());
    }


    @Test
    public void shouldThrowsExceptionIfSessionsIsEmpty() {

        List<SleepingSession> sleepingSessions = List.of();
        SleeplessNightCount sleeplessNightCount = new SleeplessNightCount();

        Assertions.assertThrows(IllegalArgumentException.class, () -> sleeplessNightCount.analyze(sleepingSessions));
    }
}
