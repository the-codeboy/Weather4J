package ml.codeboy.data;

public class HourlyForecast {
    int dt;
    String dt_txt;
    HourlyTemp main;

    public int getDt() {
        return dt;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public HourlyTemp getMain() {
        return main;
    }

    @Override
    public String toString() {
        return "HourlyForecast{" +
                "dt=" + dt +
                ", dt_txt='" + dt_txt + '\'' +
                ", main=" + main +
                '}';
    }
}
