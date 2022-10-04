package view;

import controller.CoachController;
import controller.DataController;
import model.Club;
import model.Coach;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CoachMenu extends OverView{
    public void CoachMenu()
    {
        CoachController data = new CoachController();
        int chooseCoach = 0;
        List<Coach> coaches = new ArrayList<>();
        Coach coach = new Coach();
        do {
            menuCoach();
            try {
                chooseCoach = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("");
                chooseCoach = 0;
            }
            switch (chooseCoach) {
                case 1:
                    coach.Input(sc);
                    coaches = data.readCoachFromFile(fileCoach);
                    long num = coaches.stream().filter(item -> item.getIdCoach().
                            equals(coach.getIdCoach())).count();
                    if (num == 0) {
                        data.writeCoachToFile(coach, fileCoach);
                        System.out.println("--------------------------------------");
                        System.out.println("  Thêm huấn luận viên thành công");
                        System.out.println("--------------------------------------");
                    } else {
                        System.out.println("---------------------------------");
                        System.out.println("   Huấn luận viên đã tồn tại ");
                        System.out.println("---------------------------------");
                    }
                    break;
                case 2:
                    coaches = data.readCoachFromFile(fileCoach);
                    if(coaches.isEmpty()){
                        System.out.println("------------------------------------");
                        System.out.println("   Danh sách huấn luận viên rỗng");
                        System.out.println("------------------------------------");
                    }
                    else {
                        System.out.println("---------------------------------------");
                        System.out.println("     Danh sách huấn luận viên là:");
                        System.out.println("---------------------------------------");
                        for (Coach fp : coaches) {
                            fp.showInfo();
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    coaches = data.readCoachFromFile(fileCoach);
                    if (coaches.isEmpty()){
                        System.out.println("--------------------------------------------");
                        System.out.println("    Không có huấn luận viên nào để xóa");
                        System.out.println("--------------------------------------------");
                    }
                    else {
                        System.out.println("--------------------------------------");
                        System.out.println("      Danh sách huấn luận viên:");
                        System.out.println("--------------------------------------");
                        for (Coach fp : coaches) {
                            fp.showInfo();
                        }
                        System.out.println();
                        System.out.println("-------------------------------------------------------");
                        System.out.println("        Mời nhập id huấn luận viên bạn muốn xóa");
                        System.out.println("-------------------------------------------------------");
                        String id = sc.nextLine();
                        long filterHLv = coaches.stream().filter(i -> i.getIdCoach().equals(id)).count();
                        if (filterHLv == 0) {
                            System.out.println("----------------------------------------------------");
                            System.out.println("        Không đúng Id huấn luận viên nào");
                            System.out.println("----------------------------------------------------");
                        }
                        else {
                            coaches.removeIf(fp -> fp.getIdCoach().equals(id));
                            data.updateCoachFile(coaches, fileCoach);
                            clubs = clubc.readClubFromFile(fileClub);
                            clubc.updateClubFile(deleteCoachInCLub(clubs,id),fileClub);
                            System.out.println("------------------------------------");
                            System.out.println("           Xóa thành công!");
                            System.out.println("------------------------------------");
                        }
                    }
                    break;
                case 4:
                    System.out.println("---------------------------------");
                    System.out.println("         Quay lại menu-main!");
                    System.out.println("---------------------------------");
                    break;
                default:
                    System.out.println("----------------------------------");
                    System.out.println("           Mời nhập lại");
                    System.out.println("----------------------------------");
                    break;
            }
        } while (chooseCoach != 4);
    }
    private List<Club> deleteCoachInCLub(ArrayList<Club> cl, String id){
        ArrayList<Club> clp = new ArrayList<>();
        for (Club c:cl){
            c.getCoaches().removeIf(fb->fb.getIdCoach().equals(id));
            clp.add(c);
        }
        clp.removeIf(fp->fp.getCoaches().isEmpty());
        return clp;
    }
    static void menuCoach() {
        System.out.println("#################################################################");
        System.out.println("                    MENU-COACH");
        System.out.println("#################################################################");
        System.out.println("1. Thêm HLV");
        System.out.println("2. Hiển thị HLV");
        System.out.println("3. Xóa HLV");
        System.out.println("4. Quay lại");
        System.out.println("Mời bạn nhập");
    }
}
