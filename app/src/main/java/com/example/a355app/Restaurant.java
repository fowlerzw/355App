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

    /*** maybe move this code to its own class (based on bookshelf lab) ********
    ArrayList<Restaurant> LowCostPlaces = new ArrayList<Restaurant>();
    ArrayList<Restaurant> MedCostPlaces = new ArrayList<Restaurant>();
    ArrayList<Restaurant> HighCostPlaces = new ArrayList<Restaurant>();
     *****************************************************************************/

    public Restaurant (String cost, String name, int numOfPeople){

        if(!(cost.equals("$") || cost.equals("$$") || cost.equals("$$$"))){
            cost = "$";
        }
        if(numOfPeople > 2){
            numOfPeople = 3;
        }

        this.cost = cost;
        this.name = name;
        this.numOfPeople = numOfPeople;
    }

    public Restaurant(){
        this("$", "McDonalds", 1);
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

    /** FIGURE OUT WHY THIS DOES NOT WORK ***/
//    @Override
//    public String toString(String cost, String name, int numOfPeople){
//
//        String[] parameters = new String[3];
//        String output = "";
//
//        switch(cost){
//            case "$":
//                parameters[0] = LOW_COST;
//                break;
//            case "$$":
//                parameters[0] = MED_COST;
//                break;
//            case "$$$":
//                parameters[0] = HIGH_COST;
//                break;
//            default :
//                parameters[0] = LOW_COST;
//                System.out.println("System chose the lowest parameter due to error");
//                break;
//        }
//
//        switch(numOfPeople){
//            case 1:
//                parameters[1] = "1 person";
//                break;
//            case 2:
//                parameters[1] = "2 people";
//                break;
//            case 3:
//                parameters[1] = "3 or more people";
//                break;
//            default:
//                parameters[1] = "1 person";
//                System.out.println("System chose the lowest parameter due to error");
//        }
//
//        output = "You are headed to " + name + ", a " + parameters[0] + " with " + parameters[1] + ". Enjoy!";
//
//        return output;
//    }
/** FIGURE OUT WHY ABOVE DOES NOT WORK ****/

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

        return "You're eating at " + name + ", a " + cost + " restaurant, with " + numOfPeople + ". Enjoy!";
    }
}
