package entity;

public class race {

    // Declare Race
    private int raceID;
    private String race;


    // Race constructor
    public race (int raceID, String race){
        this.raceID = raceID;
        this.race = race;

    }

    public race() {

    }


    public String race() {
        return race;
    }

    public int getRaceID() {
        return raceID;
    }


    public String toString() {return  "You have chosen [raceID=" + raceID + ", race=" + race + "]";}


}
