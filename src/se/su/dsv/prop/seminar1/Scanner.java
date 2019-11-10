package se.su.dsv.prop.seminar1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Scanner {
    public static final char NULL = (char) 0;
    public static final char EOF = (char) -1; // End of file.

    private InputStreamReader reader = null;
    private char current = NULL;

    public Scanner() {
    }

    public void open(String fileName) throws IOException {
        if(reader != null){
            reader.close();
        }

        reader = new InputStreamReader(new FileInputStream(fileName));
    }

    public char current() {
        return current;
    }

    public void moveNext() throws IOException {
        if (reader == null)
            throw new IOException("No open file.");
        if (current != EOF)
            current = (char) reader.read();
    }

    public void close() throws IOException {
        if (reader != null)
            reader.close();
    }
}
