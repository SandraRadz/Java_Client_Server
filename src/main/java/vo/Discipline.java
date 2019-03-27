package vo;

import java.io.Serializable;

public class Discipline implements Serializable {

    private static int discCount=0;

    private int discId;
    private String discName;
    private float creditsNum;


    public Discipline(int id, String name, float credit){
        discId=id;
        discName=name;
        this.creditsNum=credit;
        discCount++;
    }

    public Discipline(String name, float credit){
        discId=++discCount;
        discName=name;
        this.creditsNum=credit;
    }


    public int getDiscId() {
        return discId;
    }

    public void setDiscId(int discId) {
        this.discId = discId;
    }

    public String getDiscName() {
        return discName;
    }

    public void setDiscName(String discName) {
        this.discName = discName;
    }

    public float getCreditsNum() {
        return creditsNum;
    }

    public void setCreditsNum(float creditsNum) {
        this.creditsNum = creditsNum;
    }

    public static int getDiscCount() {
        return discCount;
    }

    public String toString(){
        return discId+". "+discName+" ("+creditsNum+")";
    }
}
