package ru.yandex.practicum.sleeptracker;

import java.util.List;

public class AverageSessionDuration implements AnalysisFunctions {
    @Override
    public SleepAnalysisResult analyze(List<SleepingSession> sessions) {

        double average = sessions.stream().mapToLong(session -> session.getDuration().toMinutes())
                .average()
                .orElse(0.0);

        String result = String.format("%.2f мин", average);

        return new SleepAnalysisResult("Средняя продолжительность сна", result, "Средняя продолжительность сна");
    }
}
