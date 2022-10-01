package model;

import java.util.Scanner;

public class Coach extends Member{
    private String coachtype;
    private String idCoach;
    private int experience;

    public Coach() {
    }

    public Coach(String fullname, int age, String nationality, int salary, String coachtype) {
        super(fullname, age, nationality, salary);
        this.coachtype = coachtype;
    }

    public Coach(String fullname, int age, String nationality, int salary, String coachtype, String idCoach, int experience) {
        super(fullname, age, nationality, salary);
        this.coachtype = coachtype;
        this.idCoach = idCoach;
        this.experience = experience;
    }

    public String getCoachtype() {
        return coachtype;
    }

    public void setCoachtype(String coachtype) {
        this.coachtype = coachtype;
    }

    public String getIdCoach() {
        return idCoach;
    }

    public void setIdCoach(String idCoach) {
        this.idCoach = idCoach;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public void Input(Scanner sc) {
        super.Input(sc);
        System.out.println("Nhập vào vị trí huấn luyện");
        coachtype = sc.nextLine();
        System.out.println("Nhập vào mã Id huấn luận viên");
        idCoach = sc.nextLine();
        System.out.println("Nhập vào số năm kinh nghiệm");
        experience = Integer.parseInt(sc.nextLine());
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Coach{" +
                "coachtype='" + coachtype + '\'' +
                ", idCoach='" + idCoach + '\'' +
                ", experience=" + experience +
                '}');
    }
}
