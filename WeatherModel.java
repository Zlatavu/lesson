package Lesson8;

import Lesson7.Weather;

import java.io.IOException;
import java.util.List;

public interface WeatherModel {
    void getWeather(String selectedCity, Period period) throws IOException;
    public List<Weather> getSavedToDBWeather();
}
