package ru.yandex.practicum.sleeptracker;

import java.util.List;

public class BadSessionCount implements AnalysisFunctions {
    @Override
    public SleepAnalysisResult analyze(List<SleepingSession> sessions) {

        long badSessions = sessions.stream()
                .filter(session -> session.getQuality() == SleepingQuality.BAD)
                .count();

        return new SleepAnalysisResult("Подсчет плохих сессий", badSessions + " раз(а)", "Столько раз вы спали плохо");
    }
}
