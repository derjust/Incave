/*
 * CalendarEntry.java
 *
 * Created on 29. Oktober 2006, 14:45
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package de.incave.home;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author tiwaz 
 */ 
public class CalendarEntry {
    private int id; 
    private Timestamp time;
    private String text;
    private String title;
    private float price;
    private String flyer;
    /** Creates a new instance of CalendarEntry */
    public CalendarEntry(int id, Timestamp time, String title, String text, float price, String flyer) {
        this.id = id;
        this.time = time;
        this.title = title;
        this.text = text;
        this.price = price;
        this.flyer = flyer;
    }

    public int getId() {
        return id;
    }

    public Timestamp getTime() {
        return time;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    public float getPrice() {
        return price;
    }

    public String getFlyer() {
        return flyer;
    }
    
}
