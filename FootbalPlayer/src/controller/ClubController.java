package controller;

import com.google.gson.Gson;
import model.Club;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class ClubController extends DataController {

    //-------------------------Club-----------------------------------//
    public void writeClubToFile(Club club, String filename) {
        openFileToWrite(filename);
        Gson gson = new Gson();
        String json = gson.toJson(club);
        printWriter.println(json);
        closeFileAfterWrite(filename);
    }
    public ArrayList<Club> readClubFromFile(String filename) {
        openFileToRead(filename);
        ArrayList<Club> clubs = new ArrayList<>();
        while (scanner.hasNextLine()) {
            Gson gson = new Gson();
            String data = scanner.nextLine();
            Club emp = gson.fromJson(data, Club.class);
            clubs.add(emp);
        }
        closeFileAfterRead(filename);
        return clubs;
    }
    public void updateClubFile(List<Club> list, String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        openFileToWrite(fileName);
        for (var club : list) {
            Gson gson = new Gson();
            String json = gson.toJson(club);
            printWriter.println(json);
        }
        closeFileAfterWrite(fileName);
    }
}
