package org.example.dto2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class js2 {
    public static void main(String[] args) throws IOException {
        // Read the JSON file into a Map
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File("C:\\Users\\Ashok\\Documents\\Custom Office Templates\\dump\\weq.json");
        Map<String, Object> jsonMap = objectMapper.readValue(jsonFile, Map.class);

        // Create a list of DTO objects
        List<FeatureDTO> featureDTOList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
            FeatureDTO featureDTO = new FeatureDTO();
            featureDTO.setFeatureName(entry.getKey());

            Map<String, Object> featureMap = (Map<String, Object>) entry.getValue();
            List<String> featureTags = (List<String>) featureMap.get("FeatureTags");
            featureDTO.setFeatureTags(featureTags);

            List<ScenarioDTO> scenarioDTOList = new ArrayList<>();
            List<Map<String, Object>> scenarioList = (List<Map<String, Object>>) featureMap.get("Scenarios");
            for (Map<String, Object> scenarioMap : scenarioList) {
                ScenarioDTO scenarioDTO = new ScenarioDTO();
                scenarioDTO.setScenarioName((String) scenarioMap.get("Scenario"));
                List<String> scenarioTags = (List<String>) scenarioMap.get("tags");
                scenarioDTO.setScenarioTags(scenarioTags);
                scenarioDTOList.add(scenarioDTO);
            }
            featureDTO.setScenarioDTOList(scenarioDTOList);

            String featureFilePath = (String) featureMap.get("featureFilePath");
            featureDTO.setFeatureFilePath(featureFilePath);

            featureDTOList.add(featureDTO);
        }

        // Write the DTO objects to a CSV file using OpenCSV library
        File csvFile = new File("C:\\Users\\Ashok\\Documents\\Custom Office Templates\\dump\\file4.csv");
        FileWriter fileWriter = new FileWriter(csvFile);
        CSVWriter csvWriter = new CSVWriter(fileWriter);

        // Write the header row
        String[] header = {"Feature Name", "Scenario Name", "Feature Tags - Team", "Feature Tags - Component",
                "Feature Tags - Category", "Feature Tags - Other", "Scenario Tags - Other"};
        csvWriter.writeNext(header);

        // Write the data rows
        for (FeatureDTO featureDTO : featureDTOList) {
            String featureName = featureDTO.getFeatureName();
            List<String> featureTags = featureDTO.getFeatureTags();

            // Divide feature tags into 2 columns
            String featureTagsTeam = "EMPTY";
            String featureTagsComponent = "EMPTY";
            String featureTagsCategory = "EMPTY";
            String featureTagsOther = "";
            if (featureTags != null) {
                for (String tag : featureTags) {
                    if (tag.startsWith("@team-")) {
                        featureTagsTeam = tag.substring(6);
                    } else if (tag.startsWith("@component:")) {
                        featureTagsComponent = tag.substring(11);
                    } else if (tag.startsWith("@category:")) {
                        featureTagsCategory = tag.substring(10);
                    } else {
                        featureTagsOther += tag + ", ";
                    }
                }
                // Remove the trailing comma and space
                if (!featureTagsOther.isEmpty()) {
                    featureTagsOther = featureTagsOther.substring(0, featureTagsOther.length() - 2);
                }
            }

            List<ScenarioDTO> scenarioDTOList = featureDTO.getScenarioDTOList();
            for (ScenarioDTO scenarioDTO : scenarioDTOList) {
                String scenarioName = scenarioDTO.getScenarioName();
                List<String> scenarioTags = scenarioDTO.getScenarioTags();
                String scenarioTagsOther = "";
                if (scenarioTags != null) {
                    for (String tag : scenarioTags) {
                        if (!tag.startsWith("Team:") && !tag.startsWith("Component:")) {
                            scenarioTagsOther += tag + ", ";
                        }
                    }
                    // Remove the trailing comma and space
                    if (!scenarioTagsOther.isEmpty()) {
                        scenarioTagsOther = scenarioTagsOther.substring(0, scenarioTagsOther.length() - 2);
                    }
                }
                String[] row = {featureName, scenarioName, featureTagsTeam, featureTagsComponent,
                        featureTagsCategory, featureTagsOther, scenarioTagsOther};
                csvWriter.writeNext(row);
            }

        }

        // Close the CSV writer
        csvWriter.close();

//        // Convert the DTO objects back to JSON
//        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
//        String json = objectMapper.writeValueAsString(featureDTOList);
//        System.out.println(json);
    }
}



