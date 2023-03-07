package org.example;
import static org.junit.Assert.assertTrue;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(File.class)
public class FileOperationsTest {

    @Test
    public void testFileOperations() throws IOException {
        mockStatic(File.class);

        File file = new File("C:\\Users\\Ashok\\eclipse-workspace\\demo-project\\src\\main\\java\\org\\example\\test1.txt");
        when(file.exists()).thenReturn(false);
        when(file.createNewFile()).thenReturn(true);

        boolean fileCreated = file.createNewFile();
        boolean fileExists = file.exists();

        verifyStatic();
        assertTrue(fileCreated);
        assertTrue(fileExists);
    }
}

