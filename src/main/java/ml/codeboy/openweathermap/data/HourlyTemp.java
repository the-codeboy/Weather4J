package ml.codeboy.openweathermap.data;

public class HourlyTemp {
    float temp,feels_like,temp_min,temp_max;

    public float getTemp() {
        return temp;
    }

    public float getFeels_like() {
        return feels_like;
    }

    public float getTemp_min() {
        return temp_min;
    }

    public float getTemp_max() {
        return temp_max;
    }

    @Override
    public String toString() {
        return "HourlyTemp{" +
                "temp=" + temp +
                ", feels_like=" + feels_like +
                ", temp_min=" + temp_min +
                ", temp_max=" + temp_max +
                '}';
    }
}
