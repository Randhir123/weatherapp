package io.randhir.weatherapp.web;

import io.randhir.weatherapp.WeatherAppProperties;
import io.randhir.weatherapp.model.WeatherEntry;
import io.randhir.weatherapp.model.WeatherForecast;
import io.randhir.weatherapp.model.WeatherService;
import io.randhir.weatherapp.model.WeatherSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class WeatherSummaryController {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private WeatherAppProperties properties;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getSummaryWeather() {
        Map<String, Object> model = new LinkedHashMap<>();
        model.put("summary", getSummary());
        return new ModelAndView("summary", model);
    }

    private Object getSummary() {
        List<WeatherSummary> summary = new ArrayList<>();
        String location = this.properties.getLocations().get(0);
        String country = location.split("/")[0];
        String city = location.split("/")[1];
        WeatherForecast forecast = this.weatherService.getWeatherForecast(country, city);
        List<WeatherEntry> entries = forecast.getEntries();
        for (int i = 0; i < 3; i++) {
            WeatherEntry entry = entries.get(i);
            summary.add(new WeatherSummary(
                    country, city, entry.getMinTemperature(),
                    entry.getMaxTemperature(),
                    entry.getWeatherMain()));
        }
        return summary;
    }
}
