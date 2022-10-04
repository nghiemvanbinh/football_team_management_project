package controller;

import com.google.gson.Gson;
import model.FootballPlayer;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerController extends DataController{
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
}
