package com.projeto.fintech.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class IngestData {
    private String deviceId;
    private long timestamp;
    private String payload;
}