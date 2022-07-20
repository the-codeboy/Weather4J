package ml.codeboy.openweathermap.data;

import java.util.List;

public class ApiResponse {
    List<HourlyForecast>list;
    City city;

    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder(city.toString());
        for (HourlyForecast hf:list){
            builder.append("\n").append(hf);
        }
        return builder.toString();
    }

    public List<HourlyForecast> getList() {
        return list;
    }

    public City getCity() {
        return city;
    }
}
