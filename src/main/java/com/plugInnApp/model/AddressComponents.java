
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
public class AddressComponents {

    @JsonProperty("district")
    public String district;
    @JsonProperty("street_address")
    public String streetAddress;
    @JsonProperty("city")
    public String city;
    @JsonProperty("zipcode")
    public String zipcode;
    @JsonProperty("state")
    public String state;
    @JsonProperty("country")
    public String country;

}
