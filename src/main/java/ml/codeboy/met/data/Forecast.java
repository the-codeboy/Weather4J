package ml.codeboy.met.data;

import java.time.Instant;

public class Forecast {
    private final Instant time;
    private final double airTemperature,humidity,windSpeed;
    private final String symbol;

    public Forecast(Instant time, double airTemperature, double humidity, double windSpeed, String symbol) {
        this.time = time;
        this.airTemperature = airTemperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.symbol = symbol;
    }

    public Instant getTime() {
        return time;
    }

    public double getAirTemperature() {
        return airTemperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public String getSymbol() {
        return symbol;
    }
}
