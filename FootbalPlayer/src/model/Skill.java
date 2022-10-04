package model;

import java.text.ParseException;
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

//    public boolean setDefense(int defense,Scanner sc) {
//        int def = Integer.parseInt(sc.nextLine());
//
//        this.defense = defense;
//        return true;
//
//    }

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
        while (!numcheck(strength,sc));
        System.out.println("Nhập vào chỉ số tốc độ");
        while (!numcheck(speed,sc));
        System.out.println("Nhập vào chỉ số tấn công");
        while (!numcheck(attack,sc));
        System.out.println("Nhập chỉ số phòng thủ");
        while (!numcheck(defense,sc));

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
    public boolean numcheck( int num,Scanner sc) {
       try {
           num = Integer.parseInt(sc.nextLine());
           if(num >15) {
               return true;
           }
           else {
               System.out.println("Nhập phải lớn hơn 15");
               return false;
           }
       }catch (Exception e){
           System.out.println("Nhập sai yêu cầu nhập lại");
       }
       return false;
    }
}
