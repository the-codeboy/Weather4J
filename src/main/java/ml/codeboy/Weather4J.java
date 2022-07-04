package ml.codeboy;

import ml.codeboy.data.ApiResponse;

import java.io.IOException;

public class Weather4J {
    private final String apiKey;

    public Weather4J(String apiKey) {
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
