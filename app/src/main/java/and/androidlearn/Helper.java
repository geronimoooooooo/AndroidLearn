package and.androidlearn;

import java.io.Serializable;



public class Helper implements Serializable {
    private String name;
    public int favouriteNumber;

    public Helper(){}

    public Helper(String name, int favouriteNumber){
        this.name=name;
        this.favouriteNumber= favouriteNumber;
    }

    public String getName(){
        return name;
    }
    public int getFavouriteNumber(){
        return favouriteNumber;
    }


}
