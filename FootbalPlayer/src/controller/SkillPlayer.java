package controller;

import com.google.gson.Gson;
import model.PlayerSkill;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SkillPlayer extends DataController{
    public void writeSkillPlayerToFile(PlayerSkill pl, String filename) {
        openFileToWrite(filename);
        Gson gson = new Gson();
        String json = gson.toJson(pl);
        printWriter.println(json);
        closeFileAfterWrite(filename);
    }
    public ArrayList<PlayerSkill> readSkillPlayersFromFile(String filename){
        openFileToRead(filename);
        ArrayList<PlayerSkill> pl = new ArrayList<>();
        while (scanner.hasNextLine()){
            Gson gson = new Gson();
            String data = scanner.nextLine();
            PlayerSkill emp = gson.fromJson(data,PlayerSkill.class);
            pl.add(emp);
        }
        closeFileAfterRead(filename);
        return pl;
    }
    public void updatePlayerSkillFile(List<PlayerSkill> list, String fileName){
        File file = new File(fileName);
        if(file.exists()){
            file.delete();
        }
        openFileToWrite(fileName);
        for (var skill: list){
            Gson gson = new Gson();
            String json = gson.toJson(skill);
            printWriter.println(json);
        }
        closeFileAfterWrite(fileName);
    }
}
