package models;
import java.util.ArrayList;
import java.util.List;


public class Hero {
    private String hName;
//    private Integer hAge;
    private String hStrength;
    private String hWeakness;
    private Integer id;
    private static ArrayList<Hero>instances = new ArrayList<>();

    public Hero(String name,String strength,String weakness){

       this.hName = name;
//        this.hAge  = age;
        this.hStrength = strength;
        this. hWeakness = weakness;
        instances.add(this);
        this. id = instances.size();
    }




    public String getName(){
        return hName;
    }

//    public Integer getAge() {
//        return hAge;
//    }



    public String getStrength() {
        return hStrength;
    }

    public String getWeakness() {
        return hWeakness;
    }

    public int getId() {
        return id;
    }
    public static Hero findById(int id){
        return instances.get(id-1);
    }

    public static ArrayList<Hero> all() {
        return instances;
    }
    public static void clear(){
        instances.clear();
    }


}
