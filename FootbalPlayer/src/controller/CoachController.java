package controller;

import com.google.gson.Gson;
import model.Coach;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoachController extends DataController{

    public void writeCoachToFile(Coach coach, String filename) {
        openFileToWrite(filename);
        Gson gson = new Gson();
        String json = gson.toJson(coach);
        printWriter.println(json);
        closeFileAfterWrite(filename);
    }
    public ArrayList<Coach> readCoachFromFile(String filename){
        openFileToRead(filename);
        ArrayList<Coach> coaches = new ArrayList<>();
        while (scanner.hasNextLine()){
            Gson gson = new Gson();
            String data = scanner.nextLine();
            Coach  emp = gson.fromJson(data, Coach.class);
            coaches.add(emp);
        }
        closeFileAfterRead(filename);
        return coaches;
    }
    public void updateCoachFile(List<Coach> list, String fileName){
        File file = new File(fileName);
        if(file.exists()){
            file.delete();
        }
        openFileToWrite(fileName);
        for (var coach: list){
            Gson gson = new Gson();
            String json = gson.toJson(coach);
            printWriter.println(json);
        }
        closeFileAfterWrite(fileName);
    }
}
