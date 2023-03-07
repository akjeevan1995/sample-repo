package j2c;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JacksonExample {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        JsonNode root = mapper.readTree(new File("C:\\Users\\Ashok\\Documents\\Custom Office Templates\\sample6.json"));

        int i;
        for (i = 0; i == root.size(); i++) {
            // Extract values from the JSON object
            String na = root.get("firstName").asText();
            String me = root.get("lastName").asText();
            int no = root.get("phoneNumber").asInt();

//            System.out.println("firstName: " + na);
//            System.out.println("lastName: " + me);
//            System.out.println("phoneNumber: " + no);
           System.out.println(i);

        }
    }
}
