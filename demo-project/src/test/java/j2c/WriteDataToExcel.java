package j2c;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.JSONArray;
import org.json.JSONObject;

public class WriteDataToExcel {

    public static void main(String[] args) throws IOException {
        // Read the nested JSON file
        String jsonFilePath = "C:\\Users\\Ashok\\Documents\\Custom Office Templates\\dump\\mnop.json";
        FileInputStream inputStream = new FileInputStream(jsonFilePath);
        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        String jsonString = new String(buffer);
        inputStream.close();

        // Parse the JSON string
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray fn = jsonObject.getJSONArray("Feature ");
        JSONArray ln = jsonObject.getJSONArray("Scenarios");
       // JSONArray ph = jsonObject.getJSONArray("data");

        // Create a new Excel workbook and sheet
        Workbook workbook = WorkbookFactory.create(true);
        Sheet sheet = workbook.createSheet("Data");

        // Write the JSON data to the Excel sheet
        int rowIndex = 0;
        Row row = sheet.createRow(rowIndex++);
        JSONObject firstObject = fn.getJSONObject(0);
        Iterator<String> keys = firstObject.keys();
        int columnIndex = 0;
        while (keys.hasNext()) {
            String FeatureTags = keys.next();
            Cell cell = row.createCell(columnIndex++);
            cell.setCellValue(FeatureTags);
        }
        for (int i = 0; i < ln.length(); i++) {
            JSONObject jsonObject2 = ln.getJSONObject(i);
            Row row2 = sheet.createRow(rowIndex++);
            int columnIndex2 = 0;
            Iterator<String> keys2 = jsonObject2.keys();
            while (keys2.hasNext()) {
                String Scenarios = keys2.next();
                String value = jsonObject2.getString(Scenarios);
                Cell cell = row2.createCell(columnIndex2++);
                cell.setCellValue(value);
            }
        }

        // Save the Excel workbook
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Ashok\\Documents\\Custom Office Templates\\out.xlsx");
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
