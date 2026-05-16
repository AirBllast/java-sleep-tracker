package ru.yandex.practicum.sleeptracker;

import java.util.List;

public class SleepingSessionsCount implements AnalysisFunctions {

    @Override
    public SleepAnalysisResult analyze(List<SleepingSession> sessions) {

        return new SleepAnalysisResult("Количество сессий сна", sessions.size() + " сессий", "Подсчет количества сессий сна");
    }
}
