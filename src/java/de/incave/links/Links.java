/*
 * Links.java
 *
 * Created on 28. Oktober 2006, 23:58
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package de.incave.links;

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
public class Links {
    
    /** Creates a new instance of Links */
    public Links() {
    }
    
    public Iterable<Link> getAllLinks() throws NamingException, SQLException {
        Vector<Link> links = new Vector<Link>(); 
        DataSource ds = Database.getIncaveDatabase();
        Connection con = ds.getConnection();
        Statement s = con.createStatement();
        s.execute("SELECT `ID`, `Text`, `Picture`, `URL` FROM `links` ORDER BY ID");
        ResultSet rs = s.getResultSet();
        while (rs.next()) {
            links.add( new Link( rs.getInt("ID"), rs.getString("Text"), 
                    rs.getString("Picture"), rs.getString("URL") ) );
            System.out.println(rs.getString("Text"));
        }
        rs.close();
        con.close();
        
        return links;
    }
    
    public void addLink( Link newLink ) {
        
    }
    
    public void editLink( int id, Link newLink ) {
        
    }
    
    public void deleteLink( int id ) {
        
    }
}
