package com.example.a355app;

import org.junit.Test;
import org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

public class FiltersTests {

    @Test
    public void Correct_Cost(){
        assertEquals("$", Activity2.costOfRestaurant());
        System.out.println("low cost (true)");
    }


}







