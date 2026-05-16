package ru.yandex.practicum.sleeptracker;

import java.util.List;

public class SleepingSessionsCount implements AnalysisFunctions {

    @Override
    public SleepAnalysisResult analyze(List<SleepingSession> sessions) {

        String result = Integer.toString(sessions.size());

        return new SleepAnalysisResult("Количество сессий сна", result + " сессий", "Подсчет количества сессий сна");
    }
}
