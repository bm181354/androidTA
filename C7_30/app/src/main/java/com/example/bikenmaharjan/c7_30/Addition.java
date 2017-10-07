package com.example.bikenmaharjan.c7_30; /**
 * Created by bikenmaharjan on 10/7/17.
 */

import java.util.Random;


public class Addition {

    public int getRandom(){

        Random rnd = new Random();

        // maximum - minimum + 1;
        return 1 + (int)(Math.random() * 9);

    }

    public int add(int numOne,int numtwo){

        return numOne + numtwo;

    }

}
