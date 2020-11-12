package com.example.a355app;

import java.util.ArrayList;

public class Restaurant {
    public static final String LOW_COST = "low priced";
    public static final String MED_COST = "moderately priced";
    public static final String HIGH_COST = "high priced";

    public static final int SOLO = 1;
    public static final int PAIR = 2;
    public static final int GROUP = 3;

    private String cost = LOW_COST;
    private String name = "McDonalds";
    private int numOfPeople = SOLO;

    private String typeOfFood;
    private ArrayList<String> keywords = new ArrayList<>();


    /*** maybe move this code to its own class (based on bookshelf lab) ********
     ArrayList<Restaurant> LowCostPlaces = new ArrayList<Restaurant>();
     ArrayList<Restaurant> MedCostPlaces = new ArrayList<Restaurant>();
     ArrayList<Restaurant> HighCostPlaces = new ArrayList<Restaurant>();
     *****************************************************************************/

    public Restaurant (String cost, String name, int numOfPeople, String typeOfFood, ArrayList<String> keywords){

        if(!(cost.equals("$") || cost.equals("$$") || cost.equals("$$$"))){
            cost = "$";
        }

        if(numOfPeople > 2){
            numOfPeople = 3;
        }

        this.cost = cost;
        this.name = name;
        this.numOfPeople = numOfPeople;

        this.typeOfFood = typeOfFood;

        this.keywords = keywords;
    }

    public Restaurant(){
        this("$", "McDonalds", 1, "American", new ArrayList<String>());
        keywords.add("Fast Food");
        keywords.add("American");
        keywords.add("McDonalds");
    }

    public void setCost(String newCost){
        this.cost = newCost;
    }

    public String getCost(){
        return cost;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public String getName(){
        return name;
    }

    public void setNumOfPeople(int newNumOfPeople){
        this.numOfPeople = newNumOfPeople;
    }

    public int getNumOfPeople(){
        return numOfPeople;
    }


    public String toString(){
        String cost = "";
        String numOfPeople = "";

        switch(getCost()){
            case "$":
                cost = LOW_COST;
                break;
            case "$$":
                cost = MED_COST;
                break;
            case "$$$":
                cost = HIGH_COST;
                break;
            default :
                cost = LOW_COST;
                System.out.println("System chose the lowest parameter due to error");
                break;
        }

        switch(getNumOfPeople()){
            case 1:
                numOfPeople = "1 person";
                break;
            case 2:
                numOfPeople = "2 people";
                break;
            case 3:
                numOfPeople = "3 or more people";
                break;
            default:
                numOfPeople = "1 person";
                System.out.println("System chose the lowest parameter due to error");
        }

        return "You're eating at " + name + ", a " + cost + " restaurant, with " + numOfPeople + ". Enjoy!\n" +
                "\ttype of food associated for " + name + " is: " + typeOfFood.toString() + "\n" +
                "\t" + name + " keywords are: " + keywords.toString() + "\n";
    }

    public ArrayList<String> getKeywords(){
        return keywords;
    }

    public void setTypeOfFood(String typeOfFood){
        this.typeOfFood = typeOfFood;
    }

    public String getTypeOfFood(){
        return typeOfFood;
    }

}
