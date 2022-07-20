package ml.codeboy.openweathermap;

import ml.codeboy.Util;
import ml.codeboy.openweathermap.data.ApiResponse;

import java.io.IOException;

public class OpenWeatherApi {
    private final String apiKey;

    public OpenWeatherApi(String apiKey) {
        this.apiKey = apiKey;
    }

    public ApiResponse getForecast(String lat, String lon, String units, String lang) throws IOException {
        String url = "https://api.openweathermap.org/data/2.5/forecast?lat={lat}&lon={lon}&appid={API key}&units={units}&lang={lang}";
        url = url.replace("{lat}", lat);
        url = url.replace("{lon}", lon);
        url = url.replace("{API key}", apiKey);
        url = url.replace("{units}", units);
        url = url.replace("{lang}", lang);
        return Util.getObject(url, ApiResponse.class);
    }

}
