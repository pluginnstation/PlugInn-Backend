package com.plugInnApp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.plugInnApp.model.ChargingPointDestination;
import com.plugInnApp.model.ChargingPointFinderRequest;
import com.plugInnApp.model.ChargingPointResponse;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;

import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/find")
public class ChargeFinderController {
    public static ObjectMapper objectMapper ;

    public ChargeFinderController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @PostMapping("/current-Charging-Station")
    public CompletableFuture<ChargingPointResponse> fetchData(@RequestBody ChargingPointFinderRequest chargingPointFinderRequest) throws Exception {


        AsyncHttpClient client = new DefaultAsyncHttpClient();

        return client.prepareGet("https://ev-charge-finder.p.rapidapi.com/search-by-coordinates-point")
                .addQueryParam("lat", chargingPointFinderRequest.getLatitude())
                .addQueryParam("lng", chargingPointFinderRequest.getLongitude())
                .addQueryParam("limit", "2")
                .addHeader("X-RapidAPI-Key", "630b8ed2cdmshfc95e0e3fc76c0ap1e997djsna4fa2663f6e4")
                .addHeader("X-RapidAPI-Host", "ev-charge-finder.p.rapidapi.com")
                .execute()
                .toCompletableFuture()
                .thenApply(response -> {
                    try {
                        // Convert response body to string
//                        String responseBody = response.getResponseBody(StandardCharsets.UTF_8);
                        ChargingPointResponse responseBody = objectMapper.readValue(response.getResponseBody(StandardCharsets.UTF_8), ChargingPointResponse.class);
                        System.out.println(responseBody.toString());
                        System.out.println(responseBody.toString()+"new changed added to plugInn github file");
                        // Close client
                        client.close();
                        // Return response body
                        return responseBody;
                    } catch (Exception e) {
                        throw new RuntimeException("Failed to read response body", e);
                    }
                });

    }

    @PostMapping("/getSourceToDestination")
    public void findChargingLocation(@RequestBody ChargingPointFinderRequest chargingPointFinderRequest,@RequestBody ChargingPointDestination chargingPointDestination)throws Exception {


        CompletableFuture<ChargingPointResponse> sourceResponseData = getAllChargingLocationFromSource(chargingPointFinderRequest);
        CompletableFuture<ChargingPointResponse> destinationResponseData = getAllChargingLocationFromDestination(chargingPointFinderRequest);

        System.out.println("Source Data Response");
        System.out.println(sourceResponseData);
        System.out.println("Destination Data Response");
        System.out.println(destinationResponseData);
    }
    public static CompletableFuture<ChargingPointResponse> getAllChargingLocationFromSource(ChargingPointFinderRequest chargingPointFinderRequest){
        AsyncHttpClient source = new DefaultAsyncHttpClient();
        return source.prepareGet("https://ev-charge-finder.p.rapidapi.com/search-by-coordinates-point")
                .addQueryParam("lat", chargingPointFinderRequest.getLatitude())
                .addQueryParam("lng", chargingPointFinderRequest.getLongitude())
                .addQueryParam("limit", "2")
                .addHeader("X-RapidAPI-Key", "630b8ed2cdmshfc95e0e3fc76c0ap1e997djsna4fa2663f6e4")
                .addHeader("X-RapidAPI-Host", "ev-charge-finder.p.rapidapi.com")
                .execute()
                .toCompletableFuture()
                .thenApply(response -> {
                    try {
                        // Convert response body to string
//                        String responseBody = response.getResponseBody(StandardCharsets.UTF_8);
                        ChargingPointResponse responseBody = objectMapper.readValue(response.getResponseBody(StandardCharsets.UTF_8), ChargingPointResponse.class);
                        System.out.println(responseBody.toString());
                        System.out.println(responseBody.toString()+"new changed added to plugInn github file");
                        // Close client
                        source.close();
                        // Return response body
                        return responseBody;
                    } catch (Exception e) {
                        throw new RuntimeException("Failed to read response body", e);
                    }
                });

    }

    public static CompletableFuture<ChargingPointResponse> getAllChargingLocationFromDestination(ChargingPointFinderRequest chargingPointFinderRequest){
        AsyncHttpClient destination = new DefaultAsyncHttpClient();
        return destination.prepareGet("https://ev-charge-finder.p.rapidapi.com/search-by-coordinates-point")
                .addQueryParam("lat", chargingPointFinderRequest.getLatitude())
                .addQueryParam("lng", chargingPointFinderRequest.getLongitude())
                .addQueryParam("limit", "2")
                .addHeader("X-RapidAPI-Key", "630b8ed2cdmshfc95e0e3fc76c0ap1e997djsna4fa2663f6e4")
                .addHeader("X-RapidAPI-Host", "ev-charge-finder.p.rapidapi.com")
                .execute()
                .toCompletableFuture()
                .thenApply(response -> {
                    try {
                        // Convert response body to string
//                        String responseBody = response.getResponseBody(StandardCharsets.UTF_8);
                        ChargingPointResponse responseBody = objectMapper.readValue(response.getResponseBody(StandardCharsets.UTF_8), ChargingPointResponse.class);
                        System.out.println(responseBody.toString());
                        System.out.println(responseBody.toString()+"new changed added to plugInn github file");
                        // Close client
                        destination.close();
                        // Return response body
                        return responseBody;
                    } catch (Exception e) {
                        throw new RuntimeException("Failed to read response body", e);
                    }
                });
    }


}
