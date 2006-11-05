/*
 * Photo.java
 *
 * Created on 29. Oktober 2006, 20:01
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package de.incave.picsnvids;

/**
 *
 * @author tiwaz
 */
public class Photo {
    private int pid;
    private String filename;
    /** Creates a new instance of Photo */
    public Photo(int pid, String filename) {
        this.pid = pid;
        this.filename = filename;
    }

    public int getPid() {
        return pid;
    }

    public String getFilename() {
        return filename;
    }
    
}
