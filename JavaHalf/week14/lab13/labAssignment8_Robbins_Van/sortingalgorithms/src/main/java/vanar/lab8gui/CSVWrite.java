package vanar.lab8gui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import com.opencsv.CSVWriter;

public class CSVWrite {
    private String[] headers;
    private File fileName;
    private FileWriter fileOut;
    private CSVWriter writer;

    public CSVWrite(String[] headers, File fileName) {
        this.headers = headers;
        this.fileName = fileName;
        try {
            this.fileOut = new FileWriter(fileName);
            this.writer = new CSVWriter(fileOut, 
                                        CSVWriter.DEFAULT_SEPARATOR, 
                                        CSVWriter.NO_QUOTE_CHARACTER, // Disable quoting
                                        CSVWriter.DEFAULT_ESCAPE_CHARACTER, 
                                        CSVWriter.DEFAULT_LINE_END);
            System.out.println("CSVWriter initialized successfully.");
        } catch (IOException e) {
            System.err.println("Error initializing CSVWriter: " + e.getMessage());
            e.printStackTrace();
            this.writer = null; // Ensure writer is null if initialization fails
        }
    }

    public void headerCSV() {
        if (writer == null) {
            System.err.println("Cannot write headers: CSVWriter is not initialized.");
            return;
        }
        writer.writeNext(headers);
        flushWriter();
    }

    public void writeLine(String[] data) {
        if (writer == null) {
            System.err.println("Cannot write data: CSVWriter is not initialized.");
            return;
        }
        writer.writeNext(data);
        flushWriter();
    }

    private void flushWriter() {
        try {
            if (writer != null) {
                writer.flush();
            }
        } catch (IOException e) {
            System.err.println("Error flushing CSVWriter: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (writer != null) {
                writer.close();
            }
            if (fileOut != null) {
                fileOut.close();
            }
        } catch (IOException e) {
            System.err.println("Error closing CSVWriter: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void setFileName(File fileName) {
        this.fileName = fileName;
    }

    public File getFileName() {
        return fileName;
    }

    public String[] getHeaders() {
        return headers;
    }

    public void setHeaders(String[] headers) {
        this.headers = headers;
    }
}
