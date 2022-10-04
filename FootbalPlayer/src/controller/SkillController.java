package controller;

import com.google.gson.Gson;
import model.PlayerSkill;
import model.Skill;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SkillController extends DataController{
    public void writeSkillToFile(Skill skill, String filename) {
        openFileToWrite(filename);
        Gson gson = new Gson();
        String json = gson.toJson(skill);
        printWriter.println(json);
        closeFileAfterWrite(filename);
    }
    public ArrayList<Skill> readSkillFromFile(String filename){
        openFileToRead(filename);
        ArrayList<Skill> skills = new ArrayList<>();
        while (scanner.hasNextLine()){
            Gson gson = new Gson();
            String data = scanner.nextLine();
            Skill  emp = gson.fromJson(data,Skill.class);
            skills.add(emp);
        }
        closeFileAfterRead(filename);
        return skills;
    }
    public void updateSkillFile(List<Skill> list, String fileName){
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
