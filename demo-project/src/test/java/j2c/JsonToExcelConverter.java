package j2c;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class JsonToExcelConverter {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Read the JSON data from file
            JsonNode rootNode = objectMapper.readTree(new File("C:\\Users\\Ashok\\Documents\\Custom Office Templates\\dump\\weq.json"));

            // Create a new Excel workbook
            Workbook workbook = new XSSFWorkbook("C:\\Users\\Ashok\\Documents\\Custom Office Templates\\dump\\data.xlsx");
            // Create a new sheet
            Sheet sheet = workbook.createSheet("Data");

            // Set the header row
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Feature");
            headerRow.createCell(1).setCellValue("Tags");
            headerRow.createCell(2).setCellValue("Scenario");
            headerRow.createCell(3).setCellValue("Feature File Path");

            int rowNum = 1;
            // Iterate through each feature
            Iterator<String> featureNames = rootNode.fieldNames();
            while (featureNames.hasNext()) {
                String featureName = featureNames.next();
                ObjectNode featureNode = (ObjectNode) rootNode.get(featureName);
                // Get the feature tags
                ArrayNode featureTagsNode = (ArrayNode) featureNode.get("FeatureTags");
                String featureTags = featureTagsNode.toString();
                // Get the scenarios for the feature
                ArrayNode scenariosNode = (ArrayNode) featureNode.get("Scenarios");
                for (JsonNode scenarioNode : scenariosNode) {
                    // Get the scenario name
                    String scenarioName = scenarioNode.get("Scenario").asText();
                    // Get the scenario tags
                    ArrayNode scenarioTagsNode = (ArrayNode) scenarioNode.get("tags");
                    String scenarioTags = scenarioTagsNode.toString();
                    // Get the feature file path
                    String featureFilePath = featureNode.get("featureFilePath").asText();

                    // Create a new row in the sheet
                    Row row = sheet.createRow(rowNum++);
                    row.createCell(0).setCellValue(featureName);
                    row.createCell(1).setCellValue(featureTags);
                    row.createCell(2).setCellValue(scenarioName);
                    row.createCell(3).setCellValue(featureFilePath);
                }
            }

            // Auto size the columns
            for (int i = 0; i < 4; i++) {
                sheet.autoSizeColumn(i);
            }

            // Write the workbook to a file
            FileOutputStream outputStream = new FileOutputStream("abc");
            workbook.write(outputStream);
            workbook.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
