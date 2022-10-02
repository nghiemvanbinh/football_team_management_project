package model;

import java.util.Scanner;

public class FootballPlayer extends Member{

    private String idPlayer;
    private String position;
    private int goal;
    private int assist;

    public FootballPlayer() {
    }

    public FootballPlayer(String idPlayer, String position, int goal, int assist) {
        this.idPlayer = idPlayer;
        this.position = position;
        this.goal = goal;
        this.assist = assist;
    }

    public FootballPlayer(String fullname, int age, String nationality, int salary, String idPlayer, String position, int goal, int assist) {
        super(fullname, age, nationality, salary);
        this.idPlayer = idPlayer;
        this.position = position;
        this.goal = goal;
        this.assist = assist;
    }

    public String getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(String idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public int getAssist() {
        return assist;
    }

    public void setAssist(int assist) {
        this.assist = assist;
    }

    public void Input(Scanner sc) {
        super.Input(sc);
        System.out.println("Nhập vào mã Id cầu thủ");
        idPlayer = sc.nextLine();
        System.out.println("Nhập vào vị trí chơi boóng");
        position = sc.nextLine();
        System.out.println("Nhập vào số bàn thắng");
        goal = Integer.parseInt(sc.nextLine());
        if(goal < 0){
            throw new ArithmeticException("Goals cannot be negative!");
        }
        System.out.println("Nhập vào kiến tạo");
        assist = Integer.parseInt(sc.nextLine());
        if(assist < 0){
            throw new ArithmeticException("Assists cannot be negative!");
        }
    }



    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("FootballPlayer{" +
                "idPlayer='" + idPlayer + '\'' +
                ", position='" + position + '\'' +
                ", goal=" + goal +
                ", assist=" + assist +
                '}');
    }
}
