package model;

import java.util.Scanner;

public class Skill {
    private String id;
    private int strength;
    private int speed;
    private int attack;
    private int defense;

    public Skill() {
    }

    public Skill(int strength, int speed, int attack, int defense) {
        this.strength = strength;
        this.speed = speed;
        this.attack = attack;
        this.defense = defense;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void Input(Scanner sc){
        System.out.println("Nhập vào mã của skill");
        id = sc.nextLine();
        System.out.println("Nhập vào chỉ số sức mạnh");
        strength = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập vào chỉ số tốc độ");
        speed = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập vào chỉ số tấn công");

    }

    @Override
    public String toString() {
        return "Skill{" +
                "id='" + id + '\'' +
                ", strength=" + strength +
                ", speed=" + speed +
                ", attack=" + attack +
                ", defense=" + defense +
                '}';
    }

    public void showInfo(){
        System.out.println(toString());
    }
}
