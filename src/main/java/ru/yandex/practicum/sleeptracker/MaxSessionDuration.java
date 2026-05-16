package ru.yandex.practicum.sleeptracker;

import java.util.Comparator;
import java.util.List;

public class MaxSessionDuration implements AnalysisFunctions {
    @Override
    public SleepAnalysisResult analyze(List<SleepingSession> sessions) {

        String result = sessions.stream().max(Comparator.comparing(SleepingSession::getDuration))
                .map(session -> Long.toString(session.getDuration().toMinutes()))
                .orElse("0");


        return new SleepAnalysisResult("Максимальная продолжительность", result + " мин",
                "Самый длительной сон");
    }
}