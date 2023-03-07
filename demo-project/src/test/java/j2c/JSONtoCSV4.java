package j2c;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONtoCSV4 {
    private static final String CSV_SEPARATOR = ",";

    public static void main(String[] args) throws IOException {

//        String json1 = new String(Files.readAllBytes(Paths.get("C:\\Users\\Ashok\\Documents\\Custom Office Templates\\dump\\mnop.json")));
//        ObjectMapper mapper = new ObjectMapper();
//        JsonNode root = mapper.readTree(json1);


        String jsonString = "{\"Feature : Scheduler Plugin API tests related to database logic\":{\"FeatureTags\":[\"@team-appsrvrsec\",\"@component:TpeServerPlugins\",\"@category:PluginScheduler\",\"@feature:Scheduler\"],\"Scenarios\":[{\"Scenario\":\"Retrive database request parameters\",\"tags\":[]},{\"Scenario\":\"Execute database request through scheduler plugin\",\"tags\":[]},{\"Scenario\":\"Retrive syncsend section\",\"tags\":[]}],\"featureFilePath\":\"C:\\\\Users\\\\Ashok\\\\Documents\\\\asd.txt\"},\"Feature : Tpe mc functionality testing\":{\"FeatureTags\":[\"@team-appsrvrsec\",\"@component:Messagecenter\",\"@category:Messagecenter\",\"@APPSRVRSECFARM\",\"Release: 2017+R2.37\",\"@bug:SDP-65458\"],\"Scenarios\":[{\"Scenario\":\"verify results of tpe mc testing\",\"tags\":[]}],\"featureFilePath\":\"C:\\\\Users\\\\Ashok\\\\Documents\\\\asd1.txt\"}}";
        try {
            JSONObject json = new JSONObject(jsonString);
            JSONArray features = json.names();

            String csv = "Feature,FeatureTags,Scenario,Tags,featureFilePath\n";

            for (int i = 0; i < features.length(); i++) {

                String feature = features.getString(i);
                JSONObject featureDetails = json.getJSONObject(feature);

                JSONArray featureTags = featureDetails.getJSONArray("FeatureTags");

                JSONArray scenarios = featureDetails.getJSONArray("Scenarios");

                String featureFilePath = featureDetails.getString("featureFilePath");

                for (int j = 0; j < scenarios.length(); j++) {
                    JSONObject scenario = scenarios.getJSONObject(j);

                    String scenarioName = scenario.getString("Scenario");

                    JSONArray scenarioTags = scenario.getJSONArray("tags");
                    String scenarioTagsString = scenarioTags.toString();

                    csv += feature + CSV_SEPARATOR + featureTags + CSV_SEPARATOR + scenarioName + CSV_SEPARATOR + scenarioTagsString + CSV_SEPARATOR + featureFilePath + "\n";
                }
            }
            FileWriter writer = new FileWriter("C:\\Users\\Ashok\\Documents\\Custom Office Templates\\data20.csv");
            writer.append(csv);
            writer.flush();
            writer.close();
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
    }
}

