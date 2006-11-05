/*
 * Gallery.java
 *
 * Created on 29. Oktober 2006, 15:17
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package de.incave.picsnvids;

import java.sql.Timestamp;

/**
 *
 * @author tiwaz
 */
public class Gallery {
    private int gid;
    private String title;
    private Timestamp time;
    private String author;
    private String thumbnail;
    private String path;
    
    /** Creates a new instance of Gallery */
    public Gallery(int gid, String title, String author, String path, String thumbnail, Timestamp time) {
        this.gid = gid;
        this.title = title;
        this.author = author;
        this.path = path;
        this.thumbnail = thumbnail;
        this.time = time;
    }

    public int getGid() {
        return gid;
    }

    public String getTitle() {
        return title;
    }

    public Timestamp getTime() {
        return time;
    }

    public String getAuthor() {
        return author;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getPath() {
        return path;
    }
    
}
