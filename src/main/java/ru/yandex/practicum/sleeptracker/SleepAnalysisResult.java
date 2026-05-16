package ru.yandex.practicum.sleeptracker;

public class SleepAnalysisResult {
    private String functionName;
    private String result;
    private String description;

    public SleepAnalysisResult(String functionName, String result, String description) {
        this.functionName = functionName;
        this.result = result;
        this.description = description;
    }

    public String getFunctionName() {
        return functionName;
    }

    public String getResult() {
        return result;
    }

    public String getDescription() {
        return description;
    }
}
