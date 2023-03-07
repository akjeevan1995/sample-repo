package org.example.dto2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonToCsvConverterDto2 {

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

        // Write the DTO objects to a CSV file using OpenCSV
        File csvFile = new File("C:\\Users\\Ashok\\Documents\\Custom Office Templates\\dump\\file0.csv");
        FileWriter writer = new FileWriter(csvFile);

        // Write header row
        String[] header = { "featureName", "featureTags", "scenarioName", "scenarioTags", "featureFilePath" };
        CSVWriter csvWriter = new CSVWriter(writer);
        csvWriter.writeNext(header);

        // Write data rows
        for (FeatureDTO featureDTO : featureDTOList) {
            String featureName = featureDTO.getFeatureName();
            String featureTags = String.join(",", featureDTO.getFeatureTags());

            for (ScenarioDTO scenarioDTO : featureDTO.getScenarioDTOList()) {
                String scenarioName = scenarioDTO.getScenarioName();
                String scenarioTags = String.join(",", scenarioDTO.getScenarioTags());

                String featureFilePath = featureDTO.getFeatureFilePath();

                String[] data = { featureName, featureTags, scenarioName, scenarioTags, featureFilePath };
                csvWriter.writeNext(data);
            }
        }

        csvWriter.close();
        System.out.println("CSV file written successfully");
    }
}
