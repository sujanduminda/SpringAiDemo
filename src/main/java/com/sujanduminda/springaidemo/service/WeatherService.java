package com.sujanduminda.springaidemo.service;

import com.sujanduminda.springaidemo.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Random;

@Service
public class WeatherService {

    private final OpenWeatherClient openWeatherClient;
    private final String apiKey;

    public WeatherService(OpenWeatherClient openWeatherClient,
                          @Value("${openweathermap.api.key:}") String apiKey) {
        this.openWeatherClient = openWeatherClient;
        this.apiKey = apiKey;
    }

    public WeatherResponse getWeatherForCity(String city) {
        if (city == null || city.isBlank()) return null;

        if (apiKey == null || apiKey.isBlank()) {
            // No API key configured -> return a mock response for quick testing
            return buildMockResponse(city);
        }

        // Use OpenWeatherMap client to fetch real data
        try {
            return openWeatherClient.fetchWeather(city, apiKey);
        } catch (Exception ex) {
            // In case of error return null (controller will map to 404) or could return error object
            return null;
        }
    }

    private WeatherResponse buildMockResponse(String city) {
        Random r = new Random(city.hashCode());
        double temp = 5 + r.nextDouble() * 20; // 5..25
        String[] examples = {"clear sky", "few clouds", "scattered clouds", "light rain", "sunny"};
        String desc = examples[Math.abs(r.nextInt()) % examples.length];

        WeatherResponse w = new WeatherResponse();
        w.setCity(city);
        w.setTemperature(temp);
        w.setDescription(desc);
        w.setTimestamp(Instant.now().toString());
        w.setSource("mock");
        return w;
    }
}
