/*
 * Link.java
 *
 * Created on 28. Oktober 2006, 23:58
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package de.incave.links;

import java.io.Serializable;

/**
 *
 * @author tiwaz
 */
public class Link implements Serializable {
    private int id;
    private String text;
    private String picture;
    private String url;
    /** Creates a new instance of Link */
    public Link(int id, String text, String picture, String url) {
        this.id = id;
        this.text = text;
        this.picture = picture;
        this.url = url;
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

    public String getUrl() {
        return url;
    }
    
}
