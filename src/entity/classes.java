package entity;

public class classes {
    private long classID;
    private String name;



    public classes (long classID, String name){
        this.classID = classID;
        this.name = name;

    }




    public long getClassID() {
        return classID;
    }


    public String getName() {
        return name;
    }



    public String toString() {return  "You have chosen [classID=" + classID + ", name=" + name + "]";}


}
