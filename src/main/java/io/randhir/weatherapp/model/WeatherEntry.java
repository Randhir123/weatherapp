package io.randhir.weatherapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Map;

public class WeatherEntry implements Serializable {

    private Instant timestamp;
    private double minTemperature;
    private double maxTemperature;
    private Integer weatherId;
    private String weatherMain;

    @JsonProperty("timestamp")
    public Instant getTimestamp() {
        return this.timestamp;
    }

    @JsonSetter("dt")
    public void setTimestamp(long unixTime) {
        this.timestamp = Instant.ofEpochMilli(unixTime * 1000);
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    @JsonProperty("main")
    public void setMain(Map<String, Object> main) {
        setMaxTemperature(Double.parseDouble(main.get("temp_max").toString()));
        setMinTemperature(Double.parseDouble(main.get("temp_max").toString()));
    }

    public Integer getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(Integer weatherId) {
        this.weatherId = weatherId;
    }

    public String getWeatherMain() {
        return weatherMain;
    }

    public void setWeatherMain(String weatherMain) {
        this.weatherMain = weatherMain;
    }

    @JsonProperty("weather")
    public void setWeather(List<Map<String, Object>> entries) {
        Map<String, Object> weather = entries.get(0);
        setWeatherId((Integer)weather.get("id"));
        setWeatherMain(weather.get("main").toString());
    }
}
