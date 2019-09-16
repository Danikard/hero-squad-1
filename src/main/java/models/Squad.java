package models;
import java.util.ArrayList;
import java.util.List;


public class Squad {
    private String sName;
//    private Integer sSize;
    private String sCause;
    private Integer id;
    private static ArrayList<Squad> instances = new ArrayList<Squad>();
    private ArrayList<Hero> sHeroes;

    public Squad(String name,String cause){

        sName = name;
//        sSize = size;
        sCause = cause;
        instances.add(this);
       id = instances.size();
    }
    public String getName(){
        return sName;
    }

//    public Integer getAge() {
//        return sSize;
//    }

    public String getCause() {
        return sCause;
    }

    public int getId() {
        return id;
    }
    public static Squad findById(int id){
        return instances.get(id-1);
    }

    public static List<Squad> all() {
        return instances;
    }
    public static void clear(){
        instances.clear();
    }
}
