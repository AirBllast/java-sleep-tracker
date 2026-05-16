package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

public class SleepTrackerAppTest {

    @Test
    void shouldNotThrowExceptionIfNoArguments() {

        Assertions.assertDoesNotThrow(() -> SleepTrackerApp.main(new String[]{}));
    }

    @Test
    void shouldGetNoExceptionIfWrongFile() {

        Assertions.assertDoesNotThrow(() -> SleepTrackerApp.main(new String[]{"wrong_log.txt"}));
    }

}