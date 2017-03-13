package com.company;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Администратор on 27.02.2017.
 */
public class Room extends Observable{

    private int doctorCount;
    private int visitorCount;
    private  int count;

    public Room(int count) {
        this.count=count;


    }

    public synchronized void notifyDisplay() {
        setChanged();
        notifyObservers();
    }
    public int getCount(){
        return count;
    }

    public int  getDoctorCount() {
        return doctorCount;
    }

    public int getVisitorCount() {
        return visitorCount;
    }

    public void incDoctorCount(int newCount) {
        this.doctorCount += newCount;
    }

    public void incVisitorCount(int newCount) {
        this.visitorCount += newCount;
    }

}