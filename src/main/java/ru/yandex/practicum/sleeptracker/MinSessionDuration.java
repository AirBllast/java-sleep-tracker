package ru.yandex.practicum.sleeptracker;

import java.util.Comparator;
import java.util.List;

public class MinSessionDuration implements AnalysisFunctions {
    @Override
    public SleepAnalysisResult analyze(List<SleepingSession> sessions) {

        String result = sessions.stream().min(Comparator.comparing(SleepingSession::getDuration))
                .map(session -> Long.toString(session.getDuration().toMinutes()))
                .orElse("0");


        return new SleepAnalysisResult("Минимальная продолжительность", result + " мин",
                "Самый короткий сон");
    }
}
