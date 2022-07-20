package ml.codeboy;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Util {
    private static final Gson gson = new Gson();

    public static String readUrl(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Weather4J");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
            String inputLine;
            StringBuilder stringBuilder = new StringBuilder();
            while ((inputLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(inputLine);
            }

            String result = stringBuilder.toString();
            return result;
        }
    }

    public static <T> T getObject(String url, Type type) throws IOException {
        return gson.fromJson(Util.readUrl(url), type);
    }
}
