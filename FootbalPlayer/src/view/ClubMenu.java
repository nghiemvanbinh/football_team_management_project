package view;

import controller.ClubController;
import controller.CoachController;
import controller.DataController;
import controller.PlayerController;
import model.Club;
import model.Coach;
import model.FootballPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClubMenu extends OverView {
    public void ClubMenu() {
        /*-----------------varClub-----------------------*/
        int chooseClub = 0;
        do {
            menuClub();
            try {
                chooseClub = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("");
                chooseClub = 0;
            }
            switch (chooseClub) {
                case 1:// Thêm club
                    long num = 0;
                    List<FootballPlayer> footballaddClub = new ArrayList<>();
                    List<Coach> coachesAddClub = new ArrayList<>();
                    players = playerc.readPlayerFromFile(filePlayer);
                    coaches = coachc.readCoachFromFile(fileCoach);
                    if (players.isEmpty()) {
                        System.out.println("----------------------------------------------");
                        System.out.println("      Danh sách cầu thủ trống thoát!");
                        System.out.println("------------------------------------------------");
                    } else if (coaches.isEmpty()) {
                        System.out.println("--------------------------------------------------");
                        System.out.println("       Danh sách huấn luận viên trống");
                        System.out.println("--------------------------------------------------");
                    } else {
                        do {
                            System.out.println("---------------------------------------------");
                            System.out.println("         Nhập vào tên đội bóng");
                            System.out.println("---------------------------------------------");
                            String name = sc.nextLine();
                            clubs = clubc.readClubFromFile(fileClub);
                            num = clubs.stream().filter(item -> item.getNameClub().equals(name)).count();
                            if (num != 0) {
                                System.out.println("----------------------------------------------");
                                System.out.println("    Đội bóng đã tồn tại, nhập tên khác:");
                                System.out.println("----------------------------------------------");
                            } else club.setNameClub(name);
                        } while (num > 0);
                        do {
                            System.out.println("--------------------------------------------------");
                            System.out.println("        Danh sách cầu thủ");
                            System.out.println("--------------------------------------------------");
                            for (FootballPlayer fp : players) {
                                fp.showInfo();
                            }
                            System.out.println();
                            System.out.println("-------------------------------------------------------");
                            System.out.println(" Mời chọn ID cầu thủ cho đội bóng, nhập q để thoát");
                            System.out.println("--------------------------------------------------------");
                            String id = sc.nextLine();
                            if (id.equals("q")) break;
                            FootballPlayer football = players.stream().filter(
                                            item -> item.getIdPlayer().equals(id))
                                    .findAny().orElse(null);
                            if (football != null) {
                                long num1 = footballaddClub.stream().filter(item -> item.getIdPlayer().
                                        equals(id)).count();
                                if (num1 == 0 && checkPlayerInClub(clubs, id) == true) {
                                    footballaddClub.add(football);
                                    System.out.println("----------------------------------------------");
                                    System.out.println("          Thêm cầu thủ thành công");
                                    System.out.println("----------------------------------------------");
                                } else {
                                    System.out.println("----------------------------------------------");
                                    System.out.println("    Cầu thủ đã có đội bóng, nhập lại!");
                                    System.out.println("----------------------------------------------");
                                }
                            } else {
                                System.out.println("----------------------------------------------------");
                                System.out.println("       ID vừa nhập không đúng, nhập lại!");
                                System.out.println("-----------------------------------------------------");
                            }
                        }
                        while (true);

                        do {
                            System.out.println("-------------------------------------------------------------");
                            System.out.println("              Danh sách huấn luận viên:");
                            System.out.println("-------------------------------------------------------------");
                            for (Coach fp : coaches) {
                                fp.showInfo();
                            }
                            System.out.println();
                            System.out.println("-------------------------------------------------------------------");
                            System.out.println("    Mời chọn ID huấn luận viên cho đội bóng, nhập q để thoát");
                            System.out.println("-------------------------------------------------------------------");
                            String id = sc.nextLine();
                            if (id.equals("q")) break;
                            Coach coach1 = coaches.stream().filter(
                                            item -> item.getIdCoach().equals(id))
                                    .findAny().orElse(null);
                            if (coach1 != null) {
                                long num1 = coachesAddClub.stream().filter(item -> item.getIdCoach().
                                        equals(id)).count();
                                if (num1 == 0 && checkCoachInClub(clubs, id) == true) {
                                    coachesAddClub.add(coach1);
                                    System.out.println("-------------------------------------------");
                                    System.out.println("     Thêm huấn luận viên thành công");
                                    System.out.println("-------------------------------------------");
                                } else {
                                    System.out.println("----------------------------------------------------");
                                    System.out.println("  Huấn luận viên đã có câu lạc bộ, nhập lại:");
                                    System.out.println("----------------------------------------------------");
                                }
                            } else {
                                System.out.println("---------------------------------------------");
                                System.out.println("     ID vừa nhập không tồn tại, nhập lại:");
                                System.out.println("---------------------------------------------");
                            }
                        } while (true);
                        if (!footballaddClub.isEmpty() && !coachesAddClub.isEmpty()) {
                            club.setFootballPlayers(footballaddClub);
                            club.setCoaches(coachesAddClub);
                            clubc.writeClubToFile(club, fileClub);
                            System.out.println("---------------------------------------------");
                            System.out.println("           Thêm đội bóng thành công");
                            System.out.println("---------------------------------------------");
                        } else {
                            System.out.println("----------------------------------------");
                            System.out.println("      Thêm không thành công, thoát");
                            System.out.println("----------------------------------------");
                        }
                    }
                    break;
                case 2:// show club
                    clubs = clubc.readClubFromFile(fileClub);
                    if (clubs.isEmpty()) {
                        System.out.println("---------------------------------------");
                        System.out.println("     Danh sách các đội bóng trống!");
                        System.out.println("---------------------------------------");
                    } else {
                        System.out.println("----------------------------------------");
                        System.out.println("         Danh sách đội bóng là:");
                        System.out.println("----------------------------------------");
                        for (Club fp : clubs) {
                            fp.showInfo();
                        }
                        System.out.println();
                    }
                    break;
                case 3:// Xóa club
                    clubs = clubc.readClubFromFile(fileClub);
                    if (!clubs.isEmpty()) {
                        System.out.println("-------------------------------------------");
                        System.out.println("          Danh sách các đội bóng:");
                        System.out.println("-------------------------------------------");
                        for (Club fp : clubs) {
                            fp.showInfo();
                        }
                        System.out.println();
                        System.out.println("----------------------------------------------");
                        System.out.println("     Mời nhập tên đội bóng bạn muốn xóa:");
                        System.out.println("----------------------------------------------");
                        String id = sc.nextLine();
                        long checkidClub = clubs.stream().filter(i -> i.getNameClub().equals(id)).count();
                        if (checkidClub == 0) {
                            System.out.println("------------------------------------------");
                            System.out.println("     Không đúng tên đội bóng nào trong danh sách!");
                            System.out.println("------------------------------------------");
                        } else {
                            clubs.removeIf(fp -> fp.getNameClub().equals(id));
                            clubc.updateClubFile(clubs, fileClub);
                            System.out.println("-----------------------------------");
                            System.out.println("         Xóa thành công!");
                            System.out.println("-----------------------------------");
                        }
                    } else {
                        System.out.println("---------------------------------------");
                        System.out.println("     Không có đội bóng nào để xóa!");
                        System.out.println("---------------------------------------");
                    }
                    break;
                case 4:
                    System.out.println("----------------------------------");
                    System.out.println("           Quay lại main");
                    System.out.println("----------------------------------");
                    break;
                default:
                    System.out.println("-----------------------------------");
                    System.out.println("         Mời bạn nhập lại");
                    System.out.println("-----------------------------------");
                    break;
            }
        } while (chooseClub != 4);
    }

    static void menuClub() {
        System.out.println("#################################################################");
        System.out.println("                    MENU-CLUB");
        System.out.println("#################################################################");
        System.out.println("1. Thêm đội bóng");
        System.out.println("2. Hiển thị các đội bóng");
        System.out.println("3. Xóa đội bóng");
        System.out.println("4. Quay lại");
        System.out.println("Mời bạn nhập:");
    }

    private static boolean checkCoachInClub(List<Club> club, String id) {
        for (Club cl : club) {
            long num2 = cl.getCoaches().stream().filter(i -> i.getIdCoach().equals(id)).count();
            if (num2 != 0) {
                return false;
            }
        }
        return true;
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
}
