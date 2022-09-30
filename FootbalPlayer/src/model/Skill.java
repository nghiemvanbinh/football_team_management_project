package model;

public class Skill {
    private int strength;
    private int speed;
    private int attack;
    private int reach;
    private int defense;
    private int stamina;
    private String strongfoot;

    public Skill() {
    }

    public Skill(int strength, int speed, int attack, int reach, int defense, int stamina, String strongfoot) {
        this.strength = strength;
        this.speed = speed;
        this.attack = attack;
        this.reach = reach;
        this.defense = defense;
        this.stamina = stamina;
        this.strongfoot = strongfoot;
    }

}
