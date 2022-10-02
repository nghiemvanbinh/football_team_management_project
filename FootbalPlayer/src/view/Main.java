package view;

import controller.DataController;
import model.Club;
import model.Coach;
import model.FootballPlayer;
import model.Skill;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    static void menuMain() {
        System.out.println("--------MenuMain----------");
        System.out.println("1. Quản lí HLV");
        System.out.println("2. Quản lí cầu thủ");
        System.out.println("3. Quản lí đội bóng");
        System.out.println("4. Quản lí skill");
        System.out.println("5. Out");
        System.out.println("Mời bạn chọn");
    }

    static void menuCoach() {
        System.out.println("--------MenuCoach----------");
        System.out.println("1. Thêm HLV");
        System.out.println("2. Hiển thị HLV");
        System.out.println("3. Xóa HLV");
        System.out.println("4. Quay lại");
        System.out.println("Mời bạn nhập");
    }

    static void menuPlayer() {
        System.out.println("-----------MenuPlayer---------");
        System.out.println("1. Thêm cầu thủ");
        System.out.println("2. Hiển thị danh sách cầu thủ");
        System.out.println("3. Xóa cầu thủ");
        System.out.println("4. Thêm cầu thủ vào 1 đội bóng");
        System.out.println("5. Thêm 1 skill cho một cầu thủ");
        System.out.println("6. Quay lại");
        System.out.println("Mời bạn chọn");
    }

    static void menuClub() {
        System.out.println("-----------MenuClub------------");
        System.out.println("1. Thêm đội bóng");
        System.out.println("2. Hiển thị các đội bóng");
        System.out.println("3. Xóa đội bóng");
        System.out.println("4. Quay lại");
        System.out.println("Mời bạn nhập ");
    }

    static void menuSkill() {
        System.out.println("-----------MenuSkill----------------");
        System.out.println("1. Thêm 1 skill");
        System.out.println("2. Hiển thị danh sách các skill");
        System.out.println("3. Xóa skill");
        System.out.println("4. Quay lại");
        System.out.println("Mời bạn nhập");
    }

    public static void main(String[] args) {

        //------------------varMain-------------------------//
        int chooseMain = 0;
        Scanner sc = new Scanner(System.in);
        DataController data = new DataController();
        /*------------------varCoach----------------------*/

        int chooseCoach = 0;
        String fileCoach = "fileCoach";
        List<Coach> coaches = new ArrayList<>();
        Coach coach = new Coach();

        /*-------------------------------------------------*/


        /*-----------------varFootbalPlayer----------------*/
        int choosePlayer = 0;
        String filePlayer = "filePlayer";
        List<FootballPlayer> players = new ArrayList<>();
        FootballPlayer player = new FootballPlayer();
        /*------------------------------------------------*/

        /*-----------------varClub-----------------------*/

        int chooseClub = 0;
        String fileClub = "fileClub";
        ArrayList<Club> clubs = new ArrayList<>();
        Club club = new Club();

        /*-----------------------------------------------*/

        /*-----------------varSkill----------------------*/
        int chooseSkill = 0;
        String fileSkill = "fileSkill";
        List<Skill> skills = new ArrayList<>();
        Skill skill = new Skill();
        /*-----------------------------------------------*/

        do {
            menuMain();
            try {
                chooseMain = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("");
                chooseMain = 0;
            }
            switch (chooseMain) {
                case 1:// Mode HLV
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
                                } else System.out.println("Cầu thủ đã tồn tại ");
                                break;
                            case 2:
                                coaches = data.readCoachFromFile(fileCoach);
                                for (Coach fp : coaches) {
                                    fp.showInfo();
                                }
                                break;
                            case 3:
                                System.out.println("Danh sách huấn luận viên");
                                coaches = data.readCoachFromFile(fileCoach);
                                if(coaches.isEmpty()) System.out.println("Không có huấn luận viên nào để xóa");
                                else {
                                    for (Coach fp : coaches) {
                                        fp.showInfo();
                                    }
                                    System.out.println("Mời nhập id huấn luận viên bạn muốn xóa");
                                    String id = sc.nextLine();
                                    long filterHLv = coaches.stream().filter(i -> i.getIdCoach().equals(id)).count();
                                    if (filterHLv == 0) System.out.println("Không đúng Id huấn luận viên nào");
                                    else {
                                        coaches.removeIf(fp -> fp.getIdCoach().equals(id));
                                        data.updateCoachFile(coaches, fileCoach);
                                        System.out.println("Da xoa");
                                    }
                                }
                                break;
                            case 4:
                                System.out.println("Quay lại main");
                                break;
                            default:
                                System.out.println("Mời nhập lại");
                                break;
                        }
                    } while (chooseCoach != 4);
                    break;
                case 2:// Mode Player
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
                                players = data.readPlayerFromFile(filePlayer);
                                long num = players.stream().filter(item ->
                                        item.getIdPlayer().equals(player.getIdPlayer())).count();
                                if (num == 0) {
                                    data.writePlayerToFile(player, filePlayer);
                                } else System.out.println("Cầu thủ đã tồn tại ");
                                break;
                            case 2:// Hiển thị danh sách cầu thủ
                                players = data.readPlayerFromFile(filePlayer);
                                for (FootballPlayer fp : players) {
                                    fp.showInfo();
                                }
                                break;
                            case 3:// Cập nhật cầu thủ vào file
                                players = data.readPlayerFromFile(filePlayer);

                                if(players.isEmpty() ) System.out.println("Không có cầu thủ nào để xóa");
                                else {
                                    for (FootballPlayer fp : players) {
                                        fp.showInfo();
                                    }
                                    System.out.println("Mời nhập id cầu thủ bạn muốn xóa");
                                    String id = sc.nextLine();
                                    players.removeIf(fp -> fp.getIdPlayer().equals(id));
                                    data.updatePlayerFile(players, filePlayer);
                                    System.out.println("Da xoa");
                                }
                                break;
                            case 4:// Thêm 1 cầu thủ vào 1 đội bóng
                                clubs = data.readClubFromFile(fileClub);
                                if (clubs.isEmpty()) System.out.println("Bạn chưa có đội bóng nào để thêm");
                                else {
                                    for (Club fp : clubs) {
                                        fp.showInfo();
                                    }
                                    do {
                                        System.out.println("Nhập id đội bóng bạn muốn thêm cầu thủ, nhập q để thoát");
                                        String name = sc.nextLine();
                                        if (name.equals("q")) break;
                                        Club cl = checkNameTest(clubs, name);
                                        if (cl == null)
                                            System.out.println("Không có tên đội bóng! Mời nhập lại");
                                        else {
                                            do {
                                                players = data.readPlayerFromFile(filePlayer);
                                                for (FootballPlayer fp : players) {
                                                    fp.showInfo();
                                                }
                                                System.out.println("Nhập id cầu thủ bạn muốn thêm, q thoát");
                                                String idfb = sc.nextLine();
                                                if (idfb.equals("q")) break;
                                                if (checkPlayerList(players, idfb) == null) {
                                                    System.out.println("Id không tồn tại, nhập lại");
                                                } else {
                                                    if (!checkPlayerInClub(clubs, idfb)) {
                                                        System.out.println("Cầu thủ đã tồn tại mời " +
                                                                "nhập lại cầu thủ khác");
                                                    } else {
                                                        System.out.println("Thêm cầu thủ thành công");
                                                        cl.getFootballPlayers().add(checkPlayerList(players, idfb));
                                                        clubs.removeIf(fp -> fp.getNameClub().equals(cl.getNameClub()));
                                                        clubs.add(cl);
                                                        data.updateClubFile(clubs, fileClub);
                                                    }
                                                }
                                            } while (true);
                                        }
                                    } while (true);

                                }
                                break;
                            case 5:// Thêm 1 skill cho cầu thủ
                                System.out.println("đang phat trien");

                                break;
                            case 6:
                                System.out.println("Quay lại main");
                                break;
                            default:
                                System.out.println("Mời bạn nhập lại");
                                break;
                        }
                    } while (choosePlayer != 6);
                    break;
                case 3:// Mode Club
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
                                do {
                                    System.out.println("Nhập vào tên đội bóng");
                                    String name = sc.nextLine();
                                    clubs = data.readClubFromFile(fileClub);
                                    num = clubs.stream().filter(item -> item.getNameClub().equals(name)).count();
                                    if (num != 0) System.out.println("Đội bóng đã tồn tại, nhập lại:");
                                    else club.setNameClub(name);
                                } while (num > 0);
                                do {
                                    players = data.readPlayerFromFile(filePlayer);
                                    for (FootballPlayer fp : players) {
                                        fp.showInfo();
                                    }
                                    System.out.println("Mời chọn ID cầu thủ cho đội bóng, nhập q để thoát");
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
                                            System.out.println("Thêm cầu thủ thành công");
                                        } else {
                                            System.out.println("Cầu thủ đã có đội bóng, nhập lại");
                                        }
                                    } else {
                                        System.out.println("Nhập sai Id không có, nhập lại");
                                    }
                                } while (true);

                                do {
                                    coaches = data.readCoachFromFile(fileCoach);
                                    for (Coach fp : coaches) {
                                        fp.showInfo();
                                    }
                                    System.out.println("Mời chọn ID huấn luận viên cho đội bóng, nhập q để thoát");
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
                                            System.out.println("Thêm thành công");
                                        } else {
                                            System.out.println("Huấn luận viên đã có câu lạc bộ, nhập lại");
                                        }
                                    } else {
                                        System.out.println("Nhập sai Id không có, nhập lại");
                                    }
                                } while (true);

                                if (!footballaddClub.isEmpty() && !coachesAddClub.isEmpty()) {
                                    club.setFootballPlayers(footballaddClub);
                                    club.setCoaches(coachesAddClub);
                                    data.writeClubToFile(club, fileClub);
                                } else {
                                    System.out.println("Thêm không thành công, thoát");
                                }
                                break;
                            case 2:// show club
                                clubs = data.readClubFromFile(fileClub);
                                for (Club fp : clubs) {
                                    fp.showInfo();
                                }
                                break;
                            case 3:// Xóa club
                                clubs = data.readClubFromFile(fileClub);
                                if (!clubs.isEmpty()) {
                                    for (Club fp : clubs) {
                                        fp.showInfo();
                                    }
                                    System.out.println("Mời nhập tên đội bóng bạn muốn xóa");
                                    String id = sc.nextLine();
                                    long checkidClub = clubs.stream().filter(i->i.getNameClub().equals(id)).count();
                                    if(checkidClub == 0) System.out.println("Không đúng tên đội bóng cần xóa");
                                    else {
                                        clubs.removeIf(fp -> fp.getNameClub().equals(id));
                                        data.updateClubFile(clubs, fileClub);
                                        System.out.println("Da xoa");
                                    }
                                } else {
                                    System.out.println("Không có đội bóng nào để xóa");
                                }
                                break;
                            case 4:
                                System.out.println("Quay lại main");
                                break;
                            default:
                                System.out.println("Mời bạn nhập lại");
                                break;
                        }
                    } while (chooseClub != 4);
                    break;
                case 4:// Mode Skill
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
                                skills = data.readSkillFromFile(fileSkill);
                                long num = skills.stream().filter(item -> item.getId().
                                        equals(skill.getId())).count();
                                if (num == 0) {
                                    data.writeSkillToFile(skill, fileSkill);
                                } else System.out.println("Skill đã tồn tại");
                                break;
                            case 2:
                                skills = data.readSkillFromFile(fileSkill);
                                for (Skill fp : skills) {
                                    fp.showInfo();
                                }
                                break;
                            case 3:
                                skills = data.readSkillFromFile(fileSkill);
                                if(skills.isEmpty()) System.out.println("Không có skill nào để xóa");
                                else {
                                    for (Skill fp : skills) {
                                        fp.showInfo();
                                    }
                                    System.out.println("Mời bạn nhập Id Skill muốn xóa");
                                    String id = sc.nextLine();
                                    skills.removeIf(i -> i.getId().equals(id));
                                    data.updateSkillFile(skills, fileSkill);
                                }
                                break;
                            case 4:
                                System.out.println("Quay lại main");
                                break;
                            default:
                                System.out.println("Mời bạn nhập lại");
                                break;
                        }
                    } while (chooseSkill != 4);
                    break;
                case 5:
                    System.out.println("Kết thúc");
                    break;
                default:
                    System.out.println("Mời nhập lại lựa chọn");
                    break;
            }
        } while (chooseMain != 5);
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
}