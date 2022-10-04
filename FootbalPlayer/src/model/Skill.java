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
        strength = numcheck(sc, 0);
        System.out.println("Nhập vào chỉ số tốc độ");
        speed = numcheck(sc, 0);
        System.out.println("Nhập vào chỉ số tấn công");
<<<<<<< HEAD
        attack = numcheck(sc,0);
        System.out.println("Nhập chỉ số phòng thủ");
        defense = numcheck(sc,0);
=======
        attack = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập chỉ số phòng thủ");
        defense = Integer.parseInt(sc.nextLine());
>>>>>>> 448a8a804567f0677c389097dd4897b6179943b6

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
    public int numcheck(Scanner s, int check) {
        boolean c = false;
        boolean cp = false;
        int res = 0;
        do {
            try {
                res = Integer.parseInt(s.nextLine());
                c = true;
            } catch (NumberFormatException e) {
                System.out.println("Try a number this time");
            }
            do {
                if (res < check) {
                    try {
                        System.out.println("Invalid number, number must be greater than " + check);
                        res = Integer.parseInt(s.nextLine());
                        c = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Try a number this time");
                    }
                } else {
                    cp = true;
                }
            } while (cp == false);
            return res;
        } while (c == false);
    }
}
