package org.example;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BufferReaderFileOperations {
    public String readFile(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        try {
            return bufferedReader.readLine();
        } finally {
            bufferedReader.close();
        }
    }
}


