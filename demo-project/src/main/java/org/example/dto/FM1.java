package org.example.dto;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FM1 {
    public static void main(String args[]) throws IOException {
        String jsonString = new String(Files.readAllBytes(Paths.get("C:\\Users\\Ashok\\Documents\\Custom Office Templates\\dump\\weq.json")), StandardCharsets.UTF_8);

            JSONObject json = new JSONObject(jsonString);

        List<String> list = new ArrayList<String>();
        JSONArray jsonArray = json.getJSONArray("Feature");
        for(int i = 0 ; i < jsonArray.length(); i++) {
            list.add(jsonArray.getJSONObject(i).getString("FeatureTags"));

            System.out.println(jsonArray.getJSONObject(i).getString("FeatureTags")); // display usernames
        }
    }
}
