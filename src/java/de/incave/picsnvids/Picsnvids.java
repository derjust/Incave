/*
 * picsnvids.java
 *
 * Created on 29. Oktober 2006, 15:17
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package de.incave.picsnvids;

import de.incave.database.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author tiwaz
 */
public class Picsnvids {
    
    /** Creates a new instance of picsnvids */
    public Picsnvids() {
    }
    
    public Iterable<Gallery> getGalleries( int pageNr ) throws SQLException, NamingException {
        Vector<Gallery> allGalleries = new Vector<Gallery>();

        DataSource ds = Database.getIncaveDatabase();
        Connection con = ds.getConnection();
        Statement s = con.createStatement();
        s.execute("SELECT `GID`, `Title`, `Author`, `Path`, `Thumbnail`, `Time` FROM `picnvid_galleries` ORDER BY `Time` DESC LIMIT "+pageNr*15+", 15");
        ResultSet rs = s.getResultSet();
        while (rs.next()) {
            allGalleries.add( new Gallery( rs.getInt("GID"), rs.getString("Title"), 
                    rs.getString("Author"), rs.getString("Path"), rs.getString("Thumbnail"), rs.getTimestamp("Time") ) );
        }
        rs.close();
        con.close();
        
        return allGalleries;
    }
  
    public FilledGallery getGallery( int gid ) throws NamingException, SQLException {
        FilledGallery aGallery;
        Vector<Photo> photos = new Vector<Photo>();
        Vector<Gallery> subgalleries = new Vector<Gallery>();
        
        DataSource ds = Database.getIncaveDatabase();
        Connection con = ds.getConnection();
        Statement s = con.createStatement();
        ResultSet rs;
        s.execute("SELECT `PID`, `File` FROM `picnvid_photos` WHERE `GID`='"+gid+"' ORDER BY `PID`");
        rs = s.getResultSet();
        while (rs.next()) {
            photos.add( new Photo(rs.getInt("PID"), rs.getString("File")));
            System.out.println(rs.getString("File"));
        }
        
        s.execute("SELECT `GID`, `Title`, `Author`, `Path`, `Thumbnail`, `Time` FROM `picnvid_galleries` WHERE `GID`='"+gid+"'");
        rs = s.getResultSet();
        rs.next();
        aGallery = new FilledGallery( rs.getInt("GID"), rs.getString("Title"), 
                    rs.getString("Author"), rs.getString("Path"), rs.getString("Thumbnail"), 
                    rs.getTimestamp("Time"), subgalleries, photos );
        
        rs.close();
        con.close();        
        
        return aGallery;
    }
    
    public void deleteGellery( int gid) {
        
    }
    
    public void modifyGallery( int gid, FilledGallery newGallery ) {
        
    }
    
    public void addGallery( FilledGallery newGallery ){
        
    }
    
    public void removePhoto( int pid ) {
        
    }
    
    /*
    public float getVote( pid ) {
        
    }
    
    public int setVote(int pid, int voteValue ) {
        
    }
    
    public Iterable<Photo> getTopPhotos( int count ) {
        
    }
    
    */
}
