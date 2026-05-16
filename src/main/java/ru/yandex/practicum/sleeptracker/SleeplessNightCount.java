package ru.yandex.practicum.sleeptracker;

import java.time.LocalTime;
import java.time.Period;
import java.util.List;

public class SleeplessNightCount implements AnalysisFunctions {
    @Override
    public SleepAnalysisResult analyze(List<SleepingSession> sessions) {

        if (sessions == null || sessions.isEmpty()) {
            throw new IllegalArgumentException("Список сессий сна не может быть пустым");
        }

        long totalNights = Period.between(sessions.getFirst().getStartSession().toLocalDate(),
                sessions.getLast().getEndSession().toLocalDate()).getDays() + 1;

        long sleepyNights = sessions.stream()
                .filter(s ->
                        s.getEndSession().toLocalDate().isAfter(s.getStartSession().toLocalDate()) ||
                                s.getStartSession().toLocalTime().isBefore(LocalTime.of(6, 0)))
                .map(s -> s.getStartSession().toLocalDate())
                .distinct()
                .count();


        long sleeplessNights = totalNights - sleepyNights;
        String result = Long.toString(sleeplessNights);


        return new SleepAnalysisResult("Бессонные ночи", result + " ночей", "Общее количество бессонных ночей за период");
    }
}
