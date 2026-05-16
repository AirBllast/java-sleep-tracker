package ru.yandex.practicum.sleeptracker;

import java.time.LocalTime;
import java.util.List;

public class PersonType implements AnalysisFunctions {
    @Override
    public SleepAnalysisResult analyze(List<SleepingSession> sessions) {

        String result;

        List<SleepingSession> nightSessions = sessions.stream()
                .filter(s -> s.getEndSession().toLocalDate().isAfter(s.getStartSession().toLocalDate()))
                .toList();

        long nightsLikeOwl = nightSessions.stream()
                .filter(s -> s.getEndSession().toLocalDate().isAfter(s.getStartSession().toLocalDate()) &&
                        s.getStartSession().toLocalTime().isAfter(LocalTime.of(23, 0)) &&
                        s.getEndSession().toLocalTime().isAfter(LocalTime.of(9, 0)))
                .count();

        long nightsLikeLark = nightSessions.stream()
                .filter(s -> s.getEndSession().toLocalDate().isAfter(s.getStartSession().toLocalDate()) &&
                        s.getStartSession().toLocalTime().isBefore(LocalTime.of(22, 0)) &&
                        s.getEndSession().toLocalTime().isBefore(LocalTime.of(7, 0)))
                .count();

        long nightsLikeDove = nightSessions.size() - nightsLikeOwl - nightsLikeLark;

        if (nightsLikeOwl > nightsLikeLark && nightsLikeOwl > nightsLikeDove) {
            result = "Ваш хронотип сова";
        } else if (nightsLikeLark > nightsLikeDove && nightsLikeLark > nightsLikeOwl) {
            result = "Ваш хронотип жаворонок";
        } else {
            result = "Ваш хронотип голубь";
        }

        return new SleepAnalysisResult("Определение хронотипа", result, """
                «Совы» любят поздно ложиться и поздно вставать,\s
                а «жаворонки», наоборот, рано ложатся и рано встают.\s
                Также выделяют промежуточный тип «голуби»,\s
                который характеризуются средним временем отхода ко сну и пробуждения.""");
    }
}
