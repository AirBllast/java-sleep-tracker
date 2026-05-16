package ru.yandex.practicum.sleeptracker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SleepTrackerApp {

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Не найден файл лога");
            return;
        }

        String filePath = args[0];

        List<AnalysisFunctions> analysisFunctions = List.of(
                new SleepingSessionsCount(),
                new MaxSessionDuration(),
                new MinSessionDuration(),
                new AverageSessionDuration(),
                new BadSessionCount(),
                new SleeplessNightCount(),
                new PersonType()
        );

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath, StandardCharsets.UTF_8))) {

            List<SleepingSession> sleepingSessions = bufferedReader.lines()
                    .filter(line -> !line.isBlank())
                    .map(line -> {
                        String[] split = line.split(";");
                        return new SleepingSession(LocalDateTime.parse(split[0], DATE_TIME_FORMATTER),
                                LocalDateTime.parse(split[1], DATE_TIME_FORMATTER), SleepingQuality.valueOf(split[2]));
                    })
                    .toList();

            System.out.println("\n------------------Анализ Сна------------------\n");

            analysisFunctions.stream()
                    .map(function -> function.analyze(sleepingSessions))
                    .forEach(analysisResult -> {
                        System.out.println("АНАЛИЗ:    " + analysisResult.getFunctionName());
                        System.out.println("РЕЗУЛЬТАТ: " + analysisResult.getResult());
                        System.out.println("ИНФО:      " + analysisResult.getDescription());
                        System.out.println("----------------------------------------------");
                    });

        } catch (IOException e) {
            System.out.println("Произошла ошибка во время чтения файла.");
        }
    }
}