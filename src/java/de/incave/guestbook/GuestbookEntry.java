/*
 * GuestbookEntry.java
 *
 * Created on 29. Oktober 2006, 02:04
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package de.incave.guestbook;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author tiwaz
 */
public class GuestbookEntry implements Serializable {
    private int id;
    private String name;
    private String email;
    private String homepage;
    private int icq;
    private String msn;
    private String yim;
    private String aim;
    private String text;
    private String comment;
    private Timestamp time;
    /** Creates a new instance of GuestbookEntry */
    public GuestbookEntry(int id, String name, String email, String homepage, int icq, String text, String comment, Timestamp time) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.homepage = homepage;
        this.icq = icq;
        this.text = text;
        this.comment = comment;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getHomepage() {
        return homepage;
    }

    public int getIcq() {
        return icq;
    }

    public String getText() {
        return text;
    }

    public String getComment() {
        return comment;
    }

    public Timestamp getTime() {
        return time;
    }
    
}
