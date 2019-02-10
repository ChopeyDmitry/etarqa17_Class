package model;

public class Team {
    private String teamName;
    private String discription;

//    public Team(String teamName, String discription) {
//        this.teamName = teamName;
//        this.discription = discription;
//    }

    public Team withTeamName(String teamName) {
        this.teamName = teamName;
        return this;
    }

    public Team withDiscription(String discription) {
        this.discription = discription;
        return this;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getDiscription() {
        return discription;
    }
}
