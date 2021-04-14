package entity;

public class Character {
    private int ID;
    private String first_name;
    private String last_name;
    private String classs;
    private String race;


    public Character(int ID, String first_name, String last_name, String classs, String race ){
      this.ID = ID;
      this.first_name = first_name;
      this.last_name = last_name;
      this.classs = classs;
      this.race = race;
    }



    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getClasss() {
        return classs;
    }

    public String getRace() {
        return race;
    }




    public String toString(){
        {return  "You have chosen [CharacterID=" + ID +", First Name: " + first_name + ", Last Name: " + last_name + ", Class: " + classs + ", Race: " + race + "]";}
    }


    public void setID(int ID) {
        this.ID = ID;
    }
    public int getID() {
        return ID;
    }
}



