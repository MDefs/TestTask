package com.example.demo;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonParser {

    OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public ArrayList parser() throws IOException {
        JsonParser jsonParser = new JsonParser();
        String getResponse = jsonParser.run("https://lb.api-sandbox.openprocurement.org/api/2.4/contracts/800384f02be04ce091277202897de676/documents");
        String json = getResponse.substring(10, getResponse.length()-2);

        String[] jsonStrings = json.split("}, ");

        ArrayList<ArrayList<String>> value = new ArrayList<>();
        Matcher matcher;

        for (int i = 0; i < jsonStrings.length; i++) {
            String[] jsonString = jsonStrings[i].split(",\\s");
            value.add(new ArrayList<>());
            for (int j = 0; j < jsonString.length; j++) {
                matcher = Pattern.compile("\\s\"(.+)\"").matcher(jsonString[j]);
                while (matcher.find()) value.get(i).add(matcher.group(1));
            }
        }

        return value;
    }

}
