/*
 * FilledGallery.java
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
public class FilledGallery extends Gallery {
    private Iterable<Gallery> subgalleries;
    private Iterable<Photo> photos;
    /** Creates a new instance of FilledGallery */
    public FilledGallery(int gid, String title, String author, String path, String thumbnail, Timestamp time, Iterable<Gallery> subgalleries, Iterable<Photo> photos) {
        super( gid,  title,  author, path, thumbnail,  time);
        this.subgalleries = subgalleries;
        this.photos = photos;
    }
    
    public Iterable<Gallery> getSubgalleries() {
        return subgalleries;
    }
    
    public Iterable<Photo> getPhotos() {
        return photos;
    }
    
}
