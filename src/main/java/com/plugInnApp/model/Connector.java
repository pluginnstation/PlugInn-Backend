
package com.plugInnApp.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Connector {

    @JsonProperty("type")
    public String type;
    @JsonProperty("total")
    public Integer total;
    @JsonProperty("available")
    public Integer available;
    @JsonProperty("kw")
    public Double kw;
    @JsonProperty("speed")
    public String speed;

}
