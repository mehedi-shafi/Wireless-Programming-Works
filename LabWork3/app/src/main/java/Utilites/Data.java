package Utilites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 31-Oct-17.
 */
public class Data implements Serializable{

    private static HashMap<String, Integer> images;
    private static HashMap<String, String> divisions;
    private static HashMap<String, ArrayList<String>> place_data;

    public Data(){
        images = new HashMap<>();
        divisions = new HashMap<>();
        place_data = new HashMap<>();
        declaringDivisions();
    }

    public void addImage(String div, int res){
        images.put(div, res);
    }

    public String getDivisionName(String code){
        return divisions.get(code);
    }

    public void addDivision(String div_code, String div_name){
        divisions.put(div_code, div_name);
    }

    public void addPlaces(String division, ArrayList<String> place){
        place_data.put(division, place);
    }

    public int getImageRes(String div){
        return images.get(div);
    }

    public ArrayList<String> getPlaces(String div){
        return place_data.get(div);
    }

    public void declaringDivisions(){
        addDivision("dhaka", "Dhaka");
        addDivision("chittagong", "Chittagong");
        addDivision("khulna", "Khulna");
        addDivision("mymensingh", "Mymensingh");
        addDivision("sylhet", "Sylhet");
        addDivision("barishal", "Barishal");
        addDivision("rangpur", "Rangpur");
        addDivision("rajshahi", "Rajshahi");
    }
}
