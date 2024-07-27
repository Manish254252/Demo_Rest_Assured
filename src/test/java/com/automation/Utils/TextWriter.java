package com.automation.Utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TextWriter {
    public void writeText(String text, String fileName) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/test/resources/Texts/" + fileName, true));

        bufferedWriter.write(text);
        bufferedWriter.newLine();
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
