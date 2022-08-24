package ml.codeboy.openweathermap;

import com.google.gson.reflect.TypeToken;
import ml.codeboy.Util;
import ml.codeboy.openweathermap.data.ApiResponse;
import ml.codeboy.openweathermap.data.Location;

import java.io.IOException;
import java.lang.reflect.Type;

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

    public Location getLocation(String city){
        String url = "https://api.openweathermap.org/geo/1.0/direct?q={city}&limit=1&appid={API key}";
        url = url.replace("{city}", city);
        url = url.replace("{API key}", apiKey);
        Type locationsArray = new TypeToken<Location[]>(){}.getType();
        try {
            Location[]locations=Util.getObject(url, locationsArray);
            if(locations.length==0)
                throw new RuntimeException("Can not find city "+city);
            return locations[0];
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
