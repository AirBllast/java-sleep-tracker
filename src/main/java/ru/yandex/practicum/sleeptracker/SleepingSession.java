package ru.yandex.practicum.sleeptracker;

import java.time.Duration;
import java.time.LocalDateTime;

public class SleepingSession {
    private final LocalDateTime startSession;
    private final LocalDateTime endSession;
    private final SleepingQuality quality;
    private final Duration duration;

    public SleepingSession(LocalDateTime startSession, LocalDateTime endSession, SleepingQuality quality) {
        this.startSession = startSession;
        this.endSession = endSession;
        this.quality = quality;
        duration = Duration.between(startSession, endSession);
    }

    public LocalDateTime getStartSession() {
        return startSession;
    }

    public LocalDateTime getEndSession() {
        return endSession;
    }

    public SleepingQuality getQuality() {
        return quality;
    }

    public Duration getDuration() {
        return duration;
    }

}


