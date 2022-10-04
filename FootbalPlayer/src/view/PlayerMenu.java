package view;

import controller.*;
import model.Club;
import model.FootballPlayer;
import model.PlayerSkill;
import model.Skill;
import org.w3c.dom.CDATASection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerMenu extends OverView{
    public void PlayerMenu() {
        int choosePlayer = 0;
        do {
            menuPlayer();
            try {
                choosePlayer = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("");
                choosePlayer = 0;
            }
            switch (choosePlayer) {
                case 1:// Thêm cầu thủ vào file
                    player.Input(sc);
                    players = playerc.readPlayerFromFile(filePlayer);
                    long num = players.stream().filter(item ->
                            item.getIdPlayer().equals(player.getIdPlayer())).count();
                    if (num == 0) {
                        playerc.writePlayerToFile(player, filePlayer);
                        System.out.println("-----------------------------------");
                        System.out.println("       Thêm cầu thủ thành công!");
                        System.out.println("-----------------------------------");
                    } else {
                        System.out.println("---------------------------");
                        System.out.println("     Cầu thủ đã tồn tại!");
                        System.out.println("---------------------------");
                    }
                    break;
                case 2:// Hiển thị danh sách cầu thủ

                    players = playerc.readPlayerFromFile(filePlayer);
                    if(players.isEmpty()) {
                        System.out.println("--------------------------------------");
                        System.out.println("     Không có cầu thủ nào để show!");
                        System.out.println("--------------------------------------");
                    }
                    else {
                        System.out.println("--------------------------------");
                        System.out.println("      Danh sách cầu thủ là:");
                        System.out.println("--------------------------------");
                        for (FootballPlayer fp : players) {
                            fp.showInfo();
                        }
                        System.out.println();
                    }
                    break;
                case 3:// Cập nhật cầu thủ vào file
                    players = playerc.readPlayerFromFile(filePlayer);
                    if (players.isEmpty()) {
                        System.out.println("------------------------------------------------");
                        System.out.println("          Không có cầu thủ nào để xóa!");
                        System.out.println("------------------------------------------------");
                    }
                    else {
                        System.out.println("--------------------------------------");
                        System.out.println("           Danh sách cầu thủ!");
                        System.out.println("--------------------------------------");
                        for (FootballPlayer fp : players) {
                            fp.showInfo();
                        }
                        System.out.println();
                        System.out.println("---------------------------------------------");
                        System.out.println("       Mời nhập id cầu thủ bạn muốn xóa!");
                        System.out.println("---------------------------------------------");
                        String id = sc.nextLine();
                        // xóa danh skillplayer
                        players.removeIf(fp -> fp.getIdPlayer().equals(id));
                        playerc.updatePlayerFile(players, filePlayer);
                        // xóa cầu thủ khỏi clb
                        playerSkills = skillPlayer.readSkillPlayersFromFile(fileplayerskill);
                        skillPlayer.updatePlayerSkillFile(deletePlayerOfPLSkill(playerSkills,id),fileplayerskill);
                        clubs = clubc.readClubFromFile(fileClub);
                        clubc.updateClubFile(deletePlayerInCLub(clubs,id),fileClub);
                        System.out.println("---------------------------------");
                        System.out.println("            Đã xóa");
                        System.out.println("---------------------------------");
                    }
                    break;
                case 4:// Thêm 1 cầu thủ vào 1 đội bóng
                    clubs = clubc.readClubFromFile(fileClub);
                    if (clubs.isEmpty()) {
                        System.out.println("----------------------------------------------");
                        System.out.println("        Bạn chưa có đội bóng nào để thêm!");
                        System.out.println("-----------------------------------------------");
                    }
                    else {
                        do {
                            System.out.println("-----------------------------------");
                            System.out.println("        Danh sách các cầu thủ");
                            System.out.println("-----------------------------------");
                            for (Club fp : clubs) {
                                fp.showInfo();
                            }
                            System.out.println("----------------------------------------------------------");
                            System.out.println("Nhập id đội bóng bạn muốn thêm cầu thủ, nhập q để thoát!");
                            System.out.println("---------------------------------------------------------");
                            String name = sc.nextLine();
                            if (name.equals("q")) break;
                            Club cl = checkNameTest(clubs, name);
                            if (cl == null) {
                                System.out.println("----------------------------------------------------");
                                System.out.println("         Không có tên đội bóng! Mời nhập lại!");
                                System.out.println("----------------------------------------------------");
                            }
                            else {
                                do {
                                    players = playerc.readPlayerFromFile(filePlayer);
                                    for (FootballPlayer fp : players) {
                                        fp.showInfo();
                                    }
                                    System.out.println("-------------------------------------------------");
                                    System.out.println("      Nhập id cầu thủ bạn muốn thêm, q thoát!");
                                    System.out.println("-------------------------------------------------");
                                    String idfb = sc.nextLine();
                                    if (idfb.equals("q")) break;
                                    if (checkPlayerList(players, idfb) == null) {
                                        System.out.println("---------------------------------");
                                        System.out.println("Id không tồn tại, nhập lại!");
                                        System.out.println("-----------------------------------");
                                    } else {
                                        if (!checkPlayerInClub(clubs, idfb)) {
                                            System.out.println("-----------------------------------");
                                            System.out.println("Cầu thủ đã tồn tại mời " +
                                                    "nhập lại cầu thủ khác!");
                                            System.out.println("-----------------------------------");
                                        } else {
                                            System.out.println("-----------------------------------");
                                            System.out.println("Thêm cầu thủ thành công!");
                                            System.out.println("-----------------------------------");
                                            cl.getFootballPlayers().add(checkPlayerList(players, idfb));
                                            clubs.removeIf(fp -> fp.getNameClub().equals(cl.getNameClub()));
                                            clubs.add(cl);
                                            clubc.updateClubFile(clubs, fileClub);
                                            choosePlayer = 0;
                                        }
                                    }
                                } while (true);
                            }
                        } while (true);
                    }
                    break;
                case 5:// Thêm 1 skill cho cầu thủ
                    players = playerc.readPlayerFromFile(filePlayer);
                    skills = skillc.readSkillFromFile(fileSkill);
                    String idPlayer = null;
                    String idSkill = null;
                    boolean check = false;
                    playerSkills = skillPlayer.readSkillPlayersFromFile(fileplayerskill);
                    if (playerSkills.isEmpty()) check = true;
                    if (players.isEmpty()) {
                        System.out.println("--------------------------------------");
                        System.out.println("   Danh sách cầu thủ trống!");
                        System.out.println("--------------------------------------");
                    }
                    else if (skills.isEmpty()) {
                        System.out.println("--------------------------------------");
                        System.out.println("    Danh sách skil trống!");
                        System.out.println("--------------------------------------");
                    }
                    else {
                        do {
                            System.out.println("-----------------------------------------");
                            System.out.println("         Danh sách cầu thủ");
                            System.out.println();
                            showPlayers(players, filePlayer);
                            System.out.println();
                            System.out.println("------------------------------------------------");
                            System.out.println("Nhập id cầu thủ bạn muốn add skill, q để thoát");
                            System.out.println("------------------------------------------------");
                            idPlayer = sc.nextLine();
                            if (idPlayer.equals("q")) break;
                            if (checkPlayerList(players, idPlayer) == null) {
                                System.out.println("--------------------------------------------");
                                System.out.println("Id ko hợp lệ " +
                                        "nhập lại ");
                                System.out.println("----------------------------------------------");
                            }
                            else break;

                        } while (true);
                        do {
                            System.out.println("---------------------------------------------");
                            System.out.println("Danh sách kỹ năng có thể add");
                            System.out.println();
                            showSklills(skills, fileSkill);
                            System.out.println();
                            System.out.println("----------------------------------------------");
                            System.out.println("Nhập id cầu thủ bạn muốn add skill, q để thoát");
                            System.out.println("----------------------------------------------");
                            idSkill = sc.nextLine();
                            if (idPlayer.equals("q")) break;
                            if (checkSkillList(skills, idSkill) == null) {
                                System.out.println("-------------------------------------------");
                                System.out.println("Id ko hợp lệ " +
                                        "nhập lại ");
                                System.out.println("------------------------------------------------");
                            }
                            else break;
                        } while (true);
                    }
                    if (idPlayer != null && idSkill != null) {
                        FootballPlayer playersk = checkPlayerList(players, idPlayer);
                        Skill skillsk = checkSkillList(skills, idSkill);
                        playerSkill = new PlayerSkill(playersk, skillsk);
                        playerSkills.removeIf(fp -> fp.getFp().getIdPlayer().equals(playersk.getIdPlayer()));
                        playerSkills.add(playerSkill);
                        if (check == true) {
                            skillPlayer.writeSkillPlayerToFile(playerSkill, fileplayerskill);
                        } else {
                            skillPlayer.updatePlayerSkillFile(playerSkills, fileplayerskill);
                        }
                        System.out.println("-----------------------------------------");
                        System.out.println("       Danh sách sau khi add là:");
                        System.out.println("-----------------------------------------");
                        playerSkills = skillPlayer.readSkillPlayersFromFile(fileplayerskill);
                        System.out.println(playerSkills);
                    } else {
                        System.out.println("-------------------------------------");
                        System.out.println("       Thêm thất bại thoát");
                        System.out.println("-------------------------------------");
                    }
                    break;
                case 6:
                    System.out.println("------------------------------");
                    System.out.println("       Quay lại main");
                    System.out.println("------------------------------");
                    break;
                default:
                    System.out.println("--------------------------------------------");
                    System.out.println("Lựa chọn không hợp lệ, mời bạn nhập lại");
                    System.out.println("--------------------------------------------");
                    break;
            }
        } while (choosePlayer != 6);
    }
    static void menuPlayer() {
        System.out.println("#################################################################");
        System.out.println("                    MENU-PLAYER");
        System.out.println("#################################################################");
        System.out.println("1. Thêm cầu thủ");
        System.out.println("2. Hiển thị danh sách cầu thủ");
        System.out.println("3. Xóa cầu thủ");
        System.out.println("4. Thêm cầu thủ vào 1 đội bóng");
        System.out.println("5. Update 1 skill cho một cầu thủ");
        System.out.println("6. Quay lại");
        System.out.println("Mời bạn chọn:");
    }

    private static boolean checkPlayerInClub(List<Club> club, String id) {
        for (Club cl : club) {
            long num2 = cl.getFootballPlayers().stream().filter(i -> i.getIdPlayer().equals(id)).count();
            if (num2 != 0) {
                return false;
            }
        }
        return true;
    }

    private static Club checkNameTest(List<Club> clubs, String id) {
        for (int i = 0; i < clubs.size(); i++) {
            if (clubs.get(i).getNameClub().equals(id)) {
                return clubs.get(i);
            }
        }
        return null;
    }

    private static FootballPlayer checkPlayerList(List<FootballPlayer> fb, String id) {
        for (int i = 0; i < fb.size(); i++) {
            if (fb.get(i).getIdPlayer().equals(id)) {
                return fb.get(i);
            }
        }
        return null;

    }
    private static Skill checkSkillList(List<Skill> fb, String id) {
        for (int i = 0; i < fb.size(); i++) {
            if (fb.get(i).getId().equals(id)) {
                return fb.get(i);
            }
        }
        return null;
    }

    private static void showPlayers(List<FootballPlayer> list, String file) {
        PlayerController data = new PlayerController();
        list = data.readPlayerFromFile(file);
        for (FootballPlayer fp : list) {
            fp.showInfo();
        }
    }
    private static void showSklills(List<Skill> list, String file) {
        SkillController data = new SkillController();
        list = data.readSkillFromFile(file);
        for (Skill fp : list) {
            fp.showInfo();
        }
    }
    private List<PlayerSkill> deletePlayerOfPLSkill(ArrayList<PlayerSkill> pl,String id){
        pl.removeIf(fp -> fp.getFp().getIdPlayer().equals(id));
        return pl;
    }
    private List<Club> deletePlayerInCLub(ArrayList<Club> cl,String id){
       ArrayList<Club> clp = new ArrayList<>();
        for (Club c:cl){
            c.getFootballPlayers().removeIf(fb->fb.getIdPlayer().equals(id));
            clp.add(c);
        }
        clp.removeIf(fp->fp.getFootballPlayers().isEmpty());
        return clp;
    }
}
