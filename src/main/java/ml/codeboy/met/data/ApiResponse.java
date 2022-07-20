package ml.codeboy.met.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ApiResponse {
    private final List<Forecast> forecasts = new ArrayList<>();

    public ApiResponse(String json) {
        JsonElement element = JsonParser.parseString(json);
        JsonArray timeseries = element.getAsJsonObject().get("properties").getAsJsonObject().get("timeseries").getAsJsonArray();

        for (JsonElement elem : timeseries) {
            try {
                JsonObject forecast = elem.getAsJsonObject();
                Instant time = Instant.parse(forecast.get("time").getAsString());

                JsonObject data = forecast.get("data").getAsJsonObject();
                JsonObject details = data.get("instant").getAsJsonObject().get("details").getAsJsonObject();
                double airTemperature = details.get("air_temperature").getAsDouble();
                double humidity = details.get("relative_humidity").getAsDouble();
                double windSpeed = details.get("wind_speed").getAsDouble();
                String symbol = data.get("next_1_hours").getAsJsonObject().get("summary").getAsJsonObject().get("symbol_code").getAsString();

                Forecast result = new Forecast(time, airTemperature, humidity, windSpeed, symbol);
                forecasts.add(result);
            } catch (Exception e) {
                //workaround for now
            }
        }
    }

    public List<Forecast> getForecasts() {
        return forecasts;
    }
}
