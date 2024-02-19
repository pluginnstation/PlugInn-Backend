package com.plugInnApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChargingPointFinderRequest {
    private String latitude;
    private String longitude;
}
