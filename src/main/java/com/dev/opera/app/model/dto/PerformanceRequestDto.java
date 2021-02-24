package com.dev.opera.app.model.dto;

public class PerformanceRequestDto {
    private String performanceTitle;
    private String performanceDescription;

    public String getPerformanceDescription() {
        return performanceDescription;
    }

    public void setPerformanceDescription(String performanceDescription) {
        this.performanceDescription = performanceDescription;
    }

    public String getPerformanceTitle() {
        return performanceTitle;
    }

    public void setPerformanceTitle(String performanceTitle) {
        this.performanceTitle = performanceTitle;
    }
}
