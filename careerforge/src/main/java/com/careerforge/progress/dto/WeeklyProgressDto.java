package com.careerforge.progress.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeeklyProgressDto {
    private LocalDate date;
    private String dayOfWeek;
    private long completedCount;
}
