package org.example.dto2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class js1 {
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

            // Set Feature Tags
            List<String> featureTags = (List<String>) featureMap.get("FeatureTags");
            Set<String> teamComponentCategory = new LinkedHashSet<>();
            List<String> otherFeatureTags = new ArrayList<>();
            for (String tag : featureTags) {
                if (tag.startsWith("@team-") || tag.startsWith("@component:") || tag.startsWith("@category:")) {
                    teamComponentCategory.add(tag);
                } else {
                    otherFeatureTags.add(tag);
                }
            }

            featureDTO.setTeamComponentCategory(String.join(",", teamComponentCategory));
            featureDTO.setOtherFeatureTags(String.join(",", otherFeatureTags));

            // Set Scenarios
            List<Map<String, Object>> scenarioList = (List<Map<String, Object>>) featureMap.get("Scenarios");
            Set<String> scenarioSet = new LinkedHashSet<>();
            for (Map<String, Object> scenarioMap : scenarioList) {
                String scenarioName = (String) scenarioMap.get("Scenario");
                scenarioSet.add(scenarioName);
            }
            featureDTO.setScenarioName(String.join(",", scenarioSet));

            // Set Scenario Tags
            Set<String> scenarioTagsSet = new LinkedHashSet<>();
            for (Map<String, Object> scenarioMap : scenarioList) {
                List<String> scenarioTags = (List<String>) scenarioMap.get("tags");
                for (String tag : scenarioTags) {
                    scenarioTagsSet.add(tag);
                }
            }
            featureDTO.setOtherTags(String.join(",", scenarioTagsSet));

            // Set Feature Path
            String featureFilePath = (String) featureMap.get("featureFilePath");
            featureDTO.setFeatureFilePath(featureFilePath);

            featureDTOList.add(featureDTO);
        }

        // Write the DTO objects to a CSV file
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema csvSchema = csvMapper.schemaFor(FeatureDTO.class).withHeader();
        File csvFile = new File("C:\\Users\\Ashok\\Documents\\Custom Office Templates\\dump\\file1.csv");

        csvMapper.writer(csvSchema).writeValue(csvFile, featureDTOList);
    }
}
