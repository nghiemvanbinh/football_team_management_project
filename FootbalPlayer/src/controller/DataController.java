package controller;

import com.google.gson.Gson;
import model.*;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class DataController {
    protected FileWriter fileWriter;
    protected BufferedWriter bufferedWriter;
    protected PrintWriter printWriter;
    protected Scanner scanner;

    public void openFileToWrite(String fileName) {
        try {
            fileWriter = new FileWriter(fileName, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void openFileToRead(String filename) {
        try {
            File file = new File(filename);
            if(!file.exists()){// nếu file chưa tồn tại thì tạo mới file này
                file.createNewFile();
            }
            scanner = new Scanner(Paths.get(filename), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeFileAfterRead(String fileName) {
        try {
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void closeFileAfterWrite(String fileName) {
        try {
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
