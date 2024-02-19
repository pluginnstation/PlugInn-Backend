
package com.plugInnApp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpeningHours {

    @JsonProperty("Monday")
    public List<String> monday;
    @JsonProperty("Tuesday")
    public List<String> tuesday;
    @JsonProperty("Wednesday")
    public List<String> wednesday;
    @JsonProperty("Thursday")
    public List<String> thursday;
    @JsonProperty("Friday")
    public List<String> friday;
    @JsonProperty("Saturday")
    public List<String> saturday;
    @JsonProperty("Sunday")
    public List<String> sunday;

}
