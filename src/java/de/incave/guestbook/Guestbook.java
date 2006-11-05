/*
 * Guestbook.java
 *
 * Created on 29. Oktober 2006, 02:03
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package de.incave.guestbook;

import de.incave.database.Database;
import de.incave.links.Link;
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
public class Guestbook {
    
    /** Creates a new instance of Guestbook */
    public Guestbook() {
    }
    
    public Iterable<GuestbookEntry> getEntries( int start) throws SQLException, NamingException {
        Vector<GuestbookEntry> entries = new Vector<GuestbookEntry>(); 
        DataSource ds = Database.getIncaveDatabase();
        Connection con = ds.getConnection();
        Statement s = con.createStatement();
        s.execute("select `ID`, `Name`, `Email`, `ICQ`, `Homepage`, `Time`, `Text`, `AdminText` from `guestbook` ORDER BY `Time` DESC, ID");
        ResultSet rs = s.getResultSet();
        while (rs.next()) {
            entries.add( new GuestbookEntry( rs.getInt("ID"), rs.getString("Name"), rs.getString("Email"),
                    rs.getString("Homepage"), rs.getInt("ICQ"),  rs.getString("Text"), rs.getString("AdminText"), rs.getTimestamp("Time") ) );
        }
        rs.close();
        con.close();
        
        return entries;        
    }
    
    public int getGuestbookEntrySize() throws NamingException, SQLException {
        DataSource ds = Database.getIncaveDatabase();
        Connection con = ds.getConnection();
        Statement s = con.createStatement();
        s.execute("SELECT COUNT(*) FROM `guestbook`");
        ResultSet rs = s.getResultSet();
        int size = rs.getInt(0);
        rs.close();
        con.close();
        
        return size;
    }
    
    void addGuestbookEntry( GuestbookEntry newEntry) {
        
    }
    
    void modifyGuestbookEntry( int id, GuestbookEntry newEntry ) {
        
    }
    
    void commentGuestbookEntry( int id, String comment ) {
        
    }
    
    void deleteGuestbookEntry( int id ) {
        
    }
}
