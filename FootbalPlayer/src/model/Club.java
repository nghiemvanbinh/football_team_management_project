package model;

import java.util.List;
import java.util.stream.Collectors;

public class Club {
    private String nameClub;
    private List<FootballPlayer> footballPlayers ;
    private List<Coach> coaches;

    public Club() {
    }

    public Club(String nameClub, List<FootballPlayer> footballPlayers, List<Coach> coaches) {
        this.nameClub = nameClub;
        this.footballPlayers = footballPlayers;
        this.coaches = coaches;
    }

    public String getNameClub() {
        return nameClub;
    }

    public void setNameClub(String nameClub) {
        this.nameClub = nameClub;
    }

    public List<FootballPlayer> getFootballPlayers() {
        return footballPlayers;
    }

    public void setFootballPlayers(List<FootballPlayer> footballPlayers) {
        this.footballPlayers = footballPlayers;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public void setCoaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    @Override
    public String toString() {
        return "Club{" +
                "nameClub='" + nameClub + '\'' +
                ", footballPlayers=" + footballPlayers.stream().collect(Collectors.toList()) +
                ", coaches=" + coaches +
                '}';
    }
    public void showInfo(){

        System.out.println(toString());
    }
}
