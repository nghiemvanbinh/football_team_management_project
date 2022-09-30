package view;

import controller.DataController;
import model.FootballPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static void showMenu(){
        System.out.println("1. Thêm cầu thủ");
        System.out.println("2. Hiển thị danh sách cầu thủ");
        System.out.println("3. Xóa cầu thủ");
    }
    public static void main(String[] args) {
        int choose=0;

        DataController data = new DataController();
        var filePlayer = "filePlayer";

     do{
         Scanner sc = new Scanner(System.in);
         ArrayList<FootballPlayer> players = new ArrayList<>();
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
                for (FootballPlayer player1:players){
                    player1.showInfo();
                }
                break;
             case 3:
                 System.out.println("Nhập Id ban muon xoa");
                 String id = sc.nextLine();
                 players = data.readPlayerFromFile(filePlayer);
                 ArrayList<FootballPlayer> playerss = new ArrayList<>();
                 for (FootballPlayer fb: players
                      ) {
                     if(fb.getIdPlayer().equals(id)){
                         playerss.add(fb);
                     }
                 }
                 players.removeAll(playerss);
              //   ArrayList<FootballPlayer> removedList = players.stream().filter(l-> l.equals(id)).collect(Collectors.toList());
                 data.updatePlayerFile(players,filePlayer);
                 break;
         }
     }while (choose!=4);

    }
}