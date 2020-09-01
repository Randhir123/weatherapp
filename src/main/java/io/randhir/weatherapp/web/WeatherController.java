package io.randhir.weatherapp.web;

import io.randhir.weatherapp.model.WeatherForecast;
import io.randhir.weatherapp.model.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @RequestMapping("/daily/{country}/{city}")
    public WeatherForecast getWeatherForecast(@PathVariable String country,
                                              @PathVariable String city) {
        WeatherForecast forecast = this.weatherService.getWeatherForecast(country, city);
        return forecast;
    }
}
