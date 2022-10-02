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
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private PrintWriter printWriter;
    private Scanner scanner;

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
    public void writePlayerToFile(FootballPlayer player, String filename) {
        openFileToWrite(filename);
        Gson gson = new Gson();
        String json = gson.toJson(player);
        printWriter.println(json);
        closeFileAfterWrite(filename);
    }
    public ArrayList<FootballPlayer> readPlayerFromFile(String filename){
        openFileToRead(filename);
        ArrayList<FootballPlayer> players = new ArrayList<>();
        while (scanner.hasNextLine()){
            Gson gson = new Gson();
            String data = scanner.nextLine();
            FootballPlayer emp = gson.fromJson(data, FootballPlayer.class);
            players.add(emp);
        }
        closeFileAfterRead(filename);
        return players;
    }
    public void updatePlayerFile(List<FootballPlayer> list, String fileName){
      File file = new File(fileName);
      if(file.exists()){
          file.delete();
      }
      openFileToWrite(fileName);
      for (var player : list){
          Gson gson = new Gson();
          String json = gson.toJson(player);
          printWriter.println(json);
      }
      closeFileAfterWrite(fileName);
    }

    //-------------------------Coach---------------------------//
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
  //-------------------------Club-----------------------------------//
  public void writeClubToFile(Club club, String filename) {
      openFileToWrite(filename);
      Gson gson = new Gson();
      String json = gson.toJson(club);
      printWriter.println(json);
      closeFileAfterWrite(filename);
  }
    public ArrayList<Club> readClubFromFile(String filename){
        openFileToRead(filename);
        ArrayList<Club> clubs = new ArrayList<>();
        while (scanner.hasNextLine()){
            Gson gson = new Gson();
            String data = scanner.nextLine();
            Club  emp = gson.fromJson(data,Club.class);
            clubs.add(emp);
        }
        closeFileAfterRead(filename);
        return clubs;
    }
    public void updateClubFile(List<Club> list, String fileName){
        File file = new File(fileName);
        if(file.exists()){
            file.delete();
        }
        openFileToWrite(fileName);
        for (var club: list){
            Gson gson = new Gson();
            String json = gson.toJson(club);
            printWriter.println(json);
        }
        closeFileAfterWrite(fileName);
    }
    //--------------------skill-----------------------------------//
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
    /*---------------Skill- and footballPlayer-----------*/
    public void writeSkillPlayerToFile(ArrayList<PlayerSkill> pl, String filename) {
        openFileToWrite(filename);
        Gson gson = new Gson();
        String json = gson.toJson(pl);
        printWriter.println(json);
        closeFileAfterWrite(filename);
    }
    public ArrayList<PlayerSkill> readPlayerSkilFromFile(String filename){
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
