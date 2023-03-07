package org.example.dto2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class js3 {
    public static void main(String[] args) throws IOException {
        // Read the JSON file into a Map
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File("C:\\Users\\Ashok\\Documents\\Custom Office Templates\\dump\\weq.json");

        Map<String, Object> jsonMap = objectMapper.readValue(jsonFile, Map.class);

        // Create a list of DTO objects using streams
        List<FeatureDTO> featureDTOList = jsonMap.entrySet().stream()
                .map(entry -> {
                    FeatureDTO featureDTO = new FeatureDTO();
                    featureDTO.setFeatureName(entry.getKey());

                    Map<String, Object> featureMap = (Map<String, Object>) entry.getValue();
                    List<String> featureTags = (List<String>) featureMap.get("FeatureTags");
                    featureDTO.setFeatureTags(featureTags);

                    List<ScenarioDTO> scenarioDTOList = ((List<Map<String, Object>>) featureMap.get("Scenarios"))
                            .stream()
                            .map(scenarioMap -> {
                                ScenarioDTO scenarioDTO = new ScenarioDTO();
                                scenarioDTO.setScenarioName((String) scenarioMap.get("Scenario"));
                                List<String> scenarioTags = (List<String>) scenarioMap.get("tags");
                                scenarioDTO.setScenarioTags(scenarioTags);
                                return scenarioDTO;
                            }) .collect(Collectors.toList());
//                            .toList();
                    featureDTO.setScenarioDTOList(scenarioDTOList);

                    String featureFilePath = (String) featureMap.get("featureFilePath");
                    featureDTO.setFeatureFilePath(featureFilePath);

                    return featureDTO;
                })  .collect(Collectors.toList());
//                .toList();

        // Write the DTO objects to a CSV file using OpenCSV library
        File csvFile = new File("C:\\Users\\Ashok\\Documents\\Custom Office Templates\\dump\\file4.csv");
        FileWriter fileWriter = new FileWriter(csvFile);
        CSVWriter csvWriter = new CSVWriter(fileWriter);

        // Write the header row
        String[] header = {"Feature Name", "Scenario Name", "Feature Tags - Team", "Feature Tags - Component",
                "Feature Tags - Category", "Feature Tags - Other", "Scenario Tags - Other"};
        csvWriter.writeNext(header);

        // Write the data rows
        featureDTOList.forEach(featureDTO -> {
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
                } }
                // Remove the trailing comma and space
                if (!featureTagsOther.isEmpty()) {
                    featureTagsOther = featureTagsOther.substring(0, featureTagsOther.length() - 2);
                }

                // Write scenario data rows for each feature
                List<ScenarioDTO> scenarioDTOList = featureDTO.getScenarioDTOList();
            String finalFeatureTagsTeam = featureTagsTeam;
            String finalFeatureTagsComponent = featureTagsComponent;
            String finalFeatureTagsCategory = featureTagsCategory;
            String finalFeatureTagsOther = featureTagsOther;
            scenarioDTOList.forEach(scenarioDTO -> {
                    String[] dataRow = new String[7];
                    dataRow[0] = featureName;
                    dataRow[1] = scenarioDTO.getScenarioName();
                    dataRow[2] = finalFeatureTagsTeam;
                    dataRow[3] = finalFeatureTagsComponent;
                    dataRow[4] = finalFeatureTagsCategory;

                    // If there are no other feature tags, set the column to "EMPTY"
                    if (finalFeatureTagsOther.isEmpty()) {
                        dataRow[5] = "EMPTY";
                    } else {
                        dataRow[5] = finalFeatureTagsOther;
                    }

                    List<String> scenarioTags = scenarioDTO.getScenarioTags();
                    // If there are no scenario tags, set the column to "EMPTY"
                    if (scenarioTags == null || scenarioTags.isEmpty()) {
                        dataRow[6] = "EMPTY";
                    } else {
                        // Concatenate scenario tags with commas
                        String scenarioTagsOther = String.join(",", scenarioTags);
                        dataRow[6] = scenarioTagsOther;
                    }

                    csvWriter.writeNext(dataRow);
                });
//            });

            try {
                csvWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("CSV file written successfully!");
        } );

    }
}


