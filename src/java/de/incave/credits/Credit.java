/*
 * Credit.java
 *
 * Created on 29. Oktober 2006, 00:00
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package de.incave.credits;

import java.io.Serializable;

/**
 *
 * @author tiwaz
 */
public class Credit implements Serializable {
    private int id;
    private String text;
    private String title;
    private int icq;
    private String email;
    private String picture;
        
    /** Creates a new instance of Credit */
    public Credit(int id, String title, String text, String picture, int icq, String email)  {
        this.id = id;
        this.text = text;
        this.picture = picture;
        this.title = title;
        this.icq = icq;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getPicture() {
        return picture;
    }

    public String getTitle() {
        return title;
    }

    public int getIcq() {
        return icq;
    }

    public String getEmail() {
        return email;
    }
    
}
