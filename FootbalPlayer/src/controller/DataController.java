package controller;

import com.google.gson.Gson;
import model.FootballPlayer;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
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
    public void updatePlayerFile(ArrayList<FootballPlayer> list,String fileName){
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
}
