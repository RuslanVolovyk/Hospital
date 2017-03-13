package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static final double PROBABILITY_DOCTOR = 0.2;
    private static final double PROBABILITY_VISITOR = 0.5;
    private static final int  NUMBERS_ROOMS = 2;


    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start");

        Random random = new Random();


        ArrayList <Room> list = new ArrayList<>();
        for (int i = 0; i <NUMBERS_ROOMS; i++) {
            list.add(new Room(i));
        }

       Display display =  new Display();
        display.addNewRoom(list);

        while(true) {
            for (int i = 0; i <list.size(); i++) {

                if (random.nextDouble() < PROBABILITY_VISITOR) {
                    new Visitor(list.get(i)).start();
                }
                if (random.nextDouble() < PROBABILITY_DOCTOR) {
                    new Doctor(list.get(i)).start();
                }
                Thread.sleep(200);
            }
        }

    }

}