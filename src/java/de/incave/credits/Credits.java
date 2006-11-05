/*
 * Credits.java
 *
 * Created on 29. Oktober 2006, 00:00
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package de.incave.credits;

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
public class Credits {
    
    /** Creates a new instance of Credits */
    public Credits() {
    }
    
    public Iterable<Credit> getAllCredits() throws SQLException, NamingException {
        Vector<Credit> credits = new Vector<Credit>();
        DataSource ds = Database.getIncaveDatabase();
        Connection con = ds.getConnection();
        Statement s = con.createStatement();
        s.execute("SELECT `ID`, `Title`, `Text`, `ICQ`, `Email`, `Picture` FROM `credits` ORDER BY ID;");
        ResultSet rs = s.getResultSet();
        while (rs.next()) {
            credits.add( new Credit( rs.getInt("ID"), rs.getString("Title"), 
                    rs.getString("Text"), rs.getString("Picture"), rs.getInt("ICQ"), rs.getString("Email") ) );
        }
        rs.close();
        con.close();
        
        return credits;
    }
    
    public void addCredit( Credit newCredit ) {
        
    }
    
    public void editCredit( int id, Credit newCredit ) {
        
    }
    
    public void deleteCredite( int id ) {
        
    }
    
}
