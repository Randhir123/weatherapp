package io.randhir.weatherapp;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Arrays;
import java.util.List;

@ConfigurationProperties("weather.app")
public class WeatherAppProperties {

    private Api api = new Api();
    private List<String> locations = Arrays.asList("India/Bangalore");

    public Api getApi() {
        return api;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public static class Api {
        private String key;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }
}
