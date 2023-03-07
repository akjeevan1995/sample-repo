package org.example.dto;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;


import java.io.*;
import java.util.List;


public class FileManagerJson {

    public static void main(String[] args) throws FileNotFoundException {

        try {

            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("C:\\Users\\Ashok\\Documents\\Custom Office Templates\\dump\\weq.json"));
            TypeReference<List<JsonFileData>> typeReference = new TypeReference<List<JsonFileData>>() {};
            List <JsonFileData> jsonFileData = mapper.readValue(inputStream,typeReference);
            for (JsonFileData jfd : jsonFileData){
                System.out.println(jfd.getScenarios().getScenario());
            }


        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonParseException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
