
package com.plugInnApp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ChargingPointData {

    @JsonProperty("id")
    public String id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("connectors")
    public List<Connector> connectors;
    @JsonProperty("formatted_address")
    public String formattedAddress;
    @JsonProperty("address_components")
    public AddressComponents addressComponents;
    @JsonProperty("latitude")
    public Double latitude;
    @JsonProperty("longitude")
    public Double longitude;
    @JsonProperty("place_link")
    public String placeLink;
    @JsonProperty("phone_number")
    public String phoneNumber;
    @JsonProperty("opening_hours")
    public OpeningHours openingHours;
    @JsonProperty("rating")
    public Object rating;
    @JsonProperty("review_count")
    public Integer reviewCount;
    @JsonProperty("website")
    public String website;
    @JsonProperty("photo")
    public Object photo;
    @JsonProperty("google_place_id")
    public String googlePlaceId;
    @JsonProperty("google_cid")
    public String googleCid;

}
