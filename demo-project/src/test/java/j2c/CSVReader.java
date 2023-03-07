package j2c;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static void main(String[] args) {

        String csvFile = "C:\\Users\\Ashok\\Documents\\Custom Office Templates\\dump\\file.csv";
        String line = "";
        String cvsSplitBy = ",";

        List<String[]> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                String[] fields = line.split(cvsSplitBy);
                records.add(fields);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Process records as desired
        for (String[] record : records) {
            System.out.println(record[0] + " " + record[1] + " " + record[2] + " " + record[3] + " " + record[4]);
//            System.out.println(record.toString());
        }
    }
}
