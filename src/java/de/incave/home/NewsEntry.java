/*
 * NewsEntry.java
 *
 * Created on 29. Oktober 2006, 12:22
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package de.incave.home;

import java.sql.Timestamp;

/**
 *
 * @author tiwaz
 */
public class NewsEntry {
    private int threadid;
    private String author;
    private Timestamp posttime;
    private String title;
    private String text;
    /** Creates a new instance of NewsEntry */
    public NewsEntry(int threadid, String author, String title, String text, Timestamp posttime) {
            this.threadid = threadid;
            this.author = author;
            this.title = title;
            this.text = text;
            this.posttime = posttime;
    }

    public int getThreadid() {
        return threadid;
    }

    public String getAuthor() {
        return author;
    }

    public Timestamp getPosttime() {
        return posttime;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
    
}
