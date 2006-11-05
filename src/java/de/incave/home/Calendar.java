/*
 * Calendar.java
 *
 * Created on 29. Oktober 2006, 11:07
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package de.incave.home;

import de.incave.database.Database;
import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author tiwaz
 */
public class Calendar {

    /** Creates a new instance of Calendar */
    public Calendar() {
        
    }
    
    public Iterable<CalendarEntry> getAllEvents() throws NamingException, SQLException  {
        return getEvents("");
    }
    
    public Iterable<CalendarEntry> getNextEvents( int count ) throws NamingException, SQLException {
        return getEvents("WHERE `Time` >= " + new SimpleDateFormat("yyyy-MM-dd").format( new Date() ) );
    }
    
    
    private Iterable<CalendarEntry> getEvents( String sql) throws NamingException, SQLException {
        Vector<CalendarEntry> allEvents = new Vector<CalendarEntry>();
        DataSource ds = Database.getIncaveDatabase();
        Connection con = ds.getConnection();
        Statement s = con.createStatement();
        ResultSet rs;
        
        s.execute( "SELECT `ID`, `Time`, `Title`, `Text`, `Price`, `Flyer` FROM `calendar` " + sql + " ORDER BY `Time`");
        rs = s.getResultSet();      
        while( rs.next() ) {
            allEvents.add( new CalendarEntry( rs.getInt("ID"), rs.getTimestamp("Time"), 
                    rs.getString("Title"), rs.getString("Text"), 
                    rs.getFloat("Price"), rs.getString("Flyer") ) );
        } 
  
        rs.close();
        con.close();
        
        return allEvents;        
    }

}
