package com.example.a355app;

import org.junit.Test;
import org.junit.Assert.*;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class FiltersTests {

    @Test
    public void Correct_Cost(){
        assertEquals("$", Activity2.costOfRestaurant());
        System.out.println("low cost (true)");

        try{
            System.out.println("THE VALUE RETURNED FROM METHOD IS: " + Activity4.processRestaurants("$"));
        }
        catch(FileNotFoundException ex){
            System.out.println("NOT WORKING");
        }
    }


}







