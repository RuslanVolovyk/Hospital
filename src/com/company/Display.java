package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Администратор on 01.03.2017.
 */
public class Display implements Observer {

    private Room room;
    private List<Room> listRoom = new ArrayList<>();


    public void addNewRoom(ArrayList<Room> listRoom) {
        this.listRoom = listRoom;
        for (Room room : listRoom) {
            room.addObserver(this);

        }
    }

    @Override
    public void update(Observable o, Object arg) {
        for (int i = 0; i < listRoom.size(); i++) {
            synchronized (listRoom.get(i)) {
                System.out.println("Room №" + listRoom.get(i).getCount() + " Doctors: " + listRoom.get(i).getDoctorCount() +
                        " | Visitors: " + listRoom.get(i).getVisitorCount());
            }
        }
    }
}