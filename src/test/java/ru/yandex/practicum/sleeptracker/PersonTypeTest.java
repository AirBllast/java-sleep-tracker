package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

public class PersonTypeTest {

    @Test
    public void getPersonType() {

        List<SleepingSession> sleepingSessions = List.of(
                new SleepingSession(
                        LocalDateTime.of(2025, 10, 1, 23, 15),
                        LocalDateTime.of(2025, 10, 2, 9, 15),
                        SleepingQuality.GOOD
                ), //Сова
                new SleepingSession(
                        LocalDateTime.of(2025, 10, 5, 23, 10),
                        LocalDateTime.of(2025, 10, 6, 9, 10),
                        SleepingQuality.BAD
                ), // Сова
                new SleepingSession(
                        LocalDateTime.of(2025, 10, 6, 21, 0),
                        LocalDateTime.of(2025, 10, 7, 6, 30),
                        SleepingQuality.NORMAL
                ), //Жаворонок
                new SleepingSession(
                        LocalDateTime.of(2025, 10, 7, 22, 30),
                        LocalDateTime.of(2025, 10, 8, 8, 0),
                        SleepingQuality.BAD
                ) // Голубь
        );

        PersonType personType = new PersonType();

        Assertions.assertEquals("Ваш хронотип сова", personType.analyze(sleepingSessions).getResult());
    }

    @Test
    public void shouldReturnDoveIfLarkEqualsOwl() {

        List<SleepingSession> sleepingSessions = List.of(
                new SleepingSession(
                        LocalDateTime.of(2025, 10, 1, 23, 15),
                        LocalDateTime.of(2025, 10, 2, 9, 15),
                        SleepingQuality.GOOD
                ), //Сова
                new SleepingSession(
                        LocalDateTime.of(2025, 10, 5, 23, 10),
                        LocalDateTime.of(2025, 10, 6, 9, 10),
                        SleepingQuality.BAD
                ), // Сова
                new SleepingSession(
                        LocalDateTime.of(2025, 10, 6, 21, 0),
                        LocalDateTime.of(2025, 10, 7, 6, 30),
                        SleepingQuality.NORMAL
                ), //Жаворонок
                new SleepingSession(
                        LocalDateTime.of(2025, 10, 7, 21, 30),
                        LocalDateTime.of(2025, 10, 8, 4, 0),
                        SleepingQuality.BAD
                ) //Жаворонок
        );

        PersonType personType = new PersonType();

        Assertions.assertEquals("Ваш хронотип голубь", personType.analyze(sleepingSessions).getResult());
    }

    @Test
    public void shouldNotCountSleeplessNightsAndDaySessions() {

        List<SleepingSession> sleepingSessions = List.of(
                new SleepingSession(
                        LocalDateTime.of(2025, 10, 1, 23, 15),
                        LocalDateTime.of(2025, 10, 2, 9, 15),
                        SleepingQuality.GOOD
                ), //Сова
                new SleepingSession(
                        LocalDateTime.of(2025, 10, 5, 12, 10),
                        LocalDateTime.of(2025, 10, 5, 15, 10),
                        SleepingQuality.BAD
                ), // День
                new SleepingSession(
                        LocalDateTime.of(2025, 10, 5, 23, 10),
                        LocalDateTime.of(2025, 10, 6, 9, 10),
                        SleepingQuality.BAD
                ), // Сова
                new SleepingSession(
                        LocalDateTime.of(2025, 10, 6, 21, 0),
                        LocalDateTime.of(2025, 10, 7, 6, 30),
                        SleepingQuality.NORMAL
                ), //Жаворонок
                new SleepingSession(
                        LocalDateTime.of(2025, 10, 7, 21, 30),
                        LocalDateTime.of(2025, 10, 8, 4, 0),
                        SleepingQuality.BAD
                ) //Жаворонок
        );

        PersonType personType = new PersonType();

        Assertions.assertEquals("Ваш хронотип голубь", personType.analyze(sleepingSessions).getResult());
    }
}