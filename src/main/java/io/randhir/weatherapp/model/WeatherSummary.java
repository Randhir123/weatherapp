package io.randhir.weatherapp.model;

public class WeatherSummary {
    private final String country;
    private final String city;
    private final double minTemperature;
    private final double maxTemperature;
    private final String prediction;

    public String getPrediction() {
        return prediction;
    }

    public WeatherSummary(String country, String city, double minTemperature, double maxTemperature, String prediction) {
        this.country = country;
        this.city = city;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.prediction = prediction;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }
}
