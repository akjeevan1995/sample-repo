package org.example;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({BufferedReader.class, FileReader.class})
public class BufferReaderFileOperationsTest {
    @Test
    public void testReadFile() throws Exception {
        // mock BufferedReader
        BufferedReader mockedBufferedReader = PowerMockito.mock(BufferedReader.class);
        PowerMockito.when(mockedBufferedReader.readLine()).thenReturn("This is a test file", null);

        // mock FileReader
        FileReader mockedFileReader = PowerMockito.mock(FileReader.class);
        PowerMockito.when(mockedFileReader.read(Mockito.any(char[].class))).thenReturn(-1);

        // mock the creation of a new BufferedReader object
        PowerMockito.whenNew(BufferedReader.class).withAnyArguments().thenReturn(mockedBufferedReader);
        PowerMockito.whenNew(FileReader.class).withAnyArguments().thenReturn(mockedFileReader);

        // create a new instance of the class under test
        BufferReaderFileOperations bufferReaderFileOperations = new BufferReaderFileOperations();

        // call the method that you want to test
        String result = bufferReaderFileOperations.readFile(new File("test.txt"));

        // assert the result
        Assert.assertEquals("This is a test file", result);

        // verify that the readLine method of the mocked BufferedReader was called
        PowerMockito.verifyNew(BufferedReader.class).withArguments(mockedFileReader);
        PowerMockito.verifyNew(FileReader.class).withArguments(Mockito.any(File.class));
       // PowerMockito.verify(mockedBufferedReader).readLine();
       // PowerMockito.verifyNew(mockedBufferedReader).readLine();
    }
}


