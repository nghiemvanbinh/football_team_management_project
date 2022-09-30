package view;

import controller.DataController;
import model.FootballPlayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static void showMenu(){
        System.out.println("1. Thêm cầu thủ");
        System.out.println("2. Xóa cầu thủ");;
    }
    public static void main(String[] args) {
        int choose=0;
        Scanner sc = new Scanner(System.in);
        DataController data = new DataController();
        var filePlayer = "filePlayer";
        ArrayList<FootballPlayer> players = new ArrayList<>();
     do{
         showMenu();
         System.out.println("Mời lựa chọn");
         choose = Integer.parseInt(sc.nextLine());
         switch (choose){
             case 1:
                 FootballPlayer player = new FootballPlayer();
                 player.Input(sc);
                 data.writePlayerToFile(player,filePlayer);
                 break;
             case 2:
                players = data.readPlayerFromFile(filePlayer);
                for (FootballPlayer bvc:players){
                    bvc.showInfo();
                }
                break;
         }
     }while (choose!=3);

    }
}