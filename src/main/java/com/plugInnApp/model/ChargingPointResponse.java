
package com.plugInnApp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class ChargingPointResponse {

    @JsonProperty("status")
    public String status;
    @JsonProperty("request_id")
    public String requestId;
    @JsonProperty("data")
    public List<ChargingPointData> data;

}
