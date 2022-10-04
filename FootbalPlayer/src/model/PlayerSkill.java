package model;

public class PlayerSkill {
    private FootballPlayer fp;
    private Skill skill;

    public PlayerSkill() {
    }

    public PlayerSkill(FootballPlayer fp, Skill skill) {
        this.fp = fp;
        this.skill = skill;
    }

    public FootballPlayer getFp() {
        return fp;
    }

    public void setFp(FootballPlayer fp) {
        this.fp = fp;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "PlayerSkill{" +
                "fp=" + fp +
                ", skill=" + skill +
                '}';
    }
<<<<<<< HEAD
   public void showinfo(){
        System.out.println(toString());
    }
=======

>>>>>>> 448a8a804567f0677c389097dd4897b6179943b6
}
