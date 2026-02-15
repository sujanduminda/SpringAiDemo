package com.sujanduminda.springaidemo.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sujanduminda.springaidemo.model.WeatherResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class OpenWeatherClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper mapper = new ObjectMapper();

    public WeatherResponse fetchWeather(String city, String apiKey) throws Exception {
        String url = UriComponentsBuilder.fromHttpUrl("https://api.openweathermap.org/data/2.5/weather")
                .queryParam("q", city)
                .queryParam("appid", apiKey)
                .queryParam("units", "metric")
                .toUriString();

        ResponseEntity<String> resp = restTemplate.getForEntity(url, String.class);
        if (!resp.getStatusCode().is2xxSuccessful() || resp.getBody() == null) {
            throw new RuntimeException("OpenWeather API error: " + resp.getStatusCode());
        }

        JsonNode root = mapper.readTree(resp.getBody());
        String name = root.path("name").asText(city);
        double temp = root.path("main").path("temp").asDouble(Double.NaN);
        String desc = "";
        JsonNode weatherArr = root.path("weather");
        if (weatherArr.isArray() && weatherArr.size() > 0) {
            desc = weatherArr.get(0).path("description").asText("");
        }

        WeatherResponse w = new WeatherResponse();
        w.setCity(name);
        w.setTemperature(temp);
        w.setDescription(desc);
        w.setTimestamp(java.time.Instant.now().toString());
        w.setSource("openweathermap");
        return w;
    }
}
