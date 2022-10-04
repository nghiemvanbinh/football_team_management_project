package view;

import controller.*;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//import static view.CoachMenu.CoachMenu;
import static view.SkillMenu.*;
//import static view.ClubMenu.ClubMenu;


class OverView {
    //----------------------Main------------------------//
    protected Scanner sc = new Scanner(System.in);
    //-----------------------player---------------------//
    protected String filePlayer = "filePlayer.txt";
    protected ArrayList<FootballPlayer> players = new ArrayList<>();
    protected FootballPlayer player = new FootballPlayer();
    protected PlayerController playerc = new PlayerController();
    protected PlayerSkill playerSkill =new PlayerSkill();
    protected ArrayList<PlayerSkill> playerSkills = new ArrayList<>();
    protected SkillPlayer skillPlayer = new SkillPlayer();
    protected String  fileplayerskill = "fileplayerskill.txt";
    static PlayerMenu pl = new PlayerMenu();
    /*-----------------varClub-----------------------*/
    protected String fileClub = "fileClub.txt";
    protected ArrayList<Club> clubs = new ArrayList<>();
   protected  Club club = new Club();
   protected ClubController clubc = new ClubController();
   protected List<Coach> coaches = new ArrayList<>();
    static ClubMenu clubMenu = new ClubMenu();
    /*-----------------varSkill----------------------*/
    protected SkillController skillc = new SkillController();

    protected Skill skill = new Skill();
    protected String fileSkill = "fileSkill.txt";
    protected List<Skill> skills = new ArrayList<>();
    static SkillMenu skillMenu = new SkillMenu();
    //----------------------------------------------//

   //----------------------Coach---------------------//

    protected String fileCoach = "fileCoach.txt";
    protected CoachController coachc = new CoachController();
    static CoachMenu coachMenu = new CoachMenu();

    //------------------- coach----------------//
    static void MenuProcess() {
        //------------------varMain-------------------------//
        int chooseMain = 0;
        Scanner sc = new Scanner(System.in);
        do {
            viewMain();
            try {
                chooseMain = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("");
                chooseMain = 0;
            }
            switch (chooseMain) {
                case 1:// Mode HLV
                    coachMenu.CoachMenu();
                    break;
                case 2:// Mode Player
                    pl.PlayerMenu();
                    break;
                case 3:// Mode Club
                    clubMenu.ClubMenu();
                    break;
                case 4:// Mode Skill
                    skillMenu.SkillMenu();
                    break;
                case 5:
                    System.out.println("Kết thúc chương trình".toUpperCase());
                    break;
                default:
                    System.out.println("Bạn nhập sai mời nhập lại lựa chọn:");
                    break;
            }
        } while (chooseMain != 5);
    }

    static void viewMain() {
        System.out.println("#################################################################");
        System.out.println("                    MENU-MAIN");
        System.out.println("#################################################################");
        System.out.println("1. Quản lí HLV");
        System.out.println("2. Quản lí cầu thủ");
        System.out.println("3. Quản lí đội bóng");
        System.out.println("4. Quản lí skill");
        System.out.println("5. Thoát");
        System.out.println("Mời bạn chọn:");
    }
}
