package view;

import controller.DataController;
import controller.SkillController;
import model.Club;
import model.PlayerSkill;
import model.Skill;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 public class SkillMenu extends OverView{
    public void SkillMenu() {
        int chooseSkill = 0;
        /*-----------------------------------------------*/
        do {
            menuSkill();
            try {
                chooseSkill = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("");
                chooseSkill = 0;
            }
            switch (chooseSkill) {
                case 1:
                    skill.Input(sc);
                    skills = skillc.readSkillFromFile(fileSkill);
                    long num = skills.stream().filter(item -> item.getId().
                            equals(skill.getId())).count();
                    if (num == 0) {
                        skillc.writeSkillToFile(skill, fileSkill);
                        System.out.println("-------------------------------------------");
                        System.out.println("           Thêm skill thành công");
                        System.out.println("-------------------------------------------");
                    } else{
                        System.out.println("--------------------------------------");
                        System.out.println("          Skill đã tồn tại");
                        System.out.println("--------------------------------------");
                    }
                    break;
                case 2:
                    skills = skillc.readSkillFromFile(fileSkill);
                    if(skills.isEmpty()){
                        System.out.println("---------------------------------------");
                        System.out.println("      Danh sách skill rỗng");
                        System.out.println("---------------------------------------");
                    }
                    else {
                        System.out.println("----------------------------------------");
                        System.out.println("       Danh sách skill là:");
                        System.out.println("----------------------------------------");
                        for (Skill fp : skills) {
                            fp.showInfo();
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    skills = skillc.readSkillFromFile(fileSkill);
                    if (skills.isEmpty()){
                        System.out.println("-----------------------------------------");
                        System.out.println("    Không có skill nào để xóa");
                        System.out.println("-----------------------------------------");
                    }
                    else {
                        System.out.println("----------------------------------------");
                        System.out.println("       Danh sách skill là:");
                        System.out.println("----------------------------------------");
                        for (Skill fp : skills) {
                            fp.showInfo();
                        }
                        System.out.println();
                        System.out.println("----------------------------------------------");
                        System.out.println("       Mời bạn nhập Id Skill muốn xóa");
                        System.out.println("----------------------------------------------");
                        String id = sc.nextLine();
                        long filterskill= skills.stream().filter(i -> i.getId().equals(id)).count();
                        if (filterskill == 0) {
                            System.out.println("----------------------------------------------------");
                            System.out.println("        Không đúng Id skill nào!");
                            System.out.println("----------------------------------------------------");
                        }
                        else {
                            skills.removeIf(fp -> fp.getId().equals(id));
                            skillc.updateSkillFile(skills, fileCoach);
                            playerSkills = skillPlayer.readSkillPlayersFromFile(fileplayerskill);
                            skillPlayer.updatePlayerSkillFile(deleteSkilOfPlSkill(playerSkills,id),fileplayerskill);
                            System.out.println("------------------------------------");
                            System.out.println("           Xóa thành công!");
                            System.out.println("------------------------------------");
                        }
                    }
                    break;
                case 4:
                    System.out.println("-----------------------------");
                    System.out.println("      Quay lại main");
                    System.out.println("-----------------------------");
                    break;
                default:
                    System.out.println("----------------------------");
                    System.out.println("    Mời bạn nhập lại");
                    System.out.println("-----------------------------");
                    break;
            }
        } while (chooseSkill != 4);
    }
     private List<PlayerSkill> deleteSkilOfPlSkill(ArrayList<PlayerSkill> pl,String id){
         pl.removeIf(fp -> fp.getSkill().getId().equals(id));
         return pl;
     }
    
    static void menuSkill() {
        System.out.println("#################################################################");
        System.out.println("                    MENU-SKILL");
        System.out.println("#################################################################");
        System.out.println("1. Thêm 1 skill");
        System.out.println("2. Hiển thị danh sách các skill");
        System.out.println("3. Xóa skill");
        System.out.println("4. Quay lại");
        System.out.println("Mời bạn nhập");
    }

}
