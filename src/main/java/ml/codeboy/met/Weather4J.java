package ml.codeboy.met;

import ml.codeboy.Util;
import ml.codeboy.met.data.ApiResponse;
import ml.codeboy.met.data.Forecast;

import java.io.IOException;
import java.util.List;

public class Weather4J {
    public static List<Forecast> getForecasts(String lat, String lon) {
        String json = null;
        try {
            json = Util.readUrl("https://api.met.no/weatherapi/locationforecast/2.0/compact.json?lat=" + lat + "&lon=" + lon);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ApiResponse response = new ApiResponse(json);
        return response.getForecasts();
    }
}
