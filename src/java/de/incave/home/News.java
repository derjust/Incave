/*
 * News.java
 *
 * Created on 29. Oktober 2006, 11:07
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package de.incave.home;

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
public class News {
    
    /** Creates a new instance of News */
    public News() {
    }
    
    public Iterable<NewsEntry> getAllNews(int count) throws NamingException, SQLException {
        Vector<NewsEntry> allNews = new Vector<NewsEntry>();
        DataSource ds = Database.getIncaveDatabase();
        Connection con = ds.getConnection();
        Statement s = con.createStatement();
        ResultSet rs;
        
        s.execute(" SELECT postid, starttime, starter, topic, message FROM `bb1_boards` as b " +
                    " INNER JOIN `bb1_threads` as t  ON (b.boardID = t.boardID) " +
                    " INNER JOIN `bb1_posts` as p ON " +
                    "(t.starttime = p.posttime AND t.starter=p.username)" +
                    " WHERE b.title='.:News:.' AND t.closed=0" + 								// Wenn die Reihenfolge falsch ist, dann:
//                  " ORDER BY t.starttime ASC " +	// einkommentieren
                    " ORDER BY t.starttime DESC " +	// auskommentieren
                    " LIMIT "+ count);
        rs = s.getResultSet();      
        while( rs.next() ) {
            allNews.add( new NewsEntry( rs.getInt("postid"), rs.getString("starter"),
                    rs.getString("topic"), Database.removeBBCode( rs.getString("message")), 
                    rs.getTimestamp("starttime")  ) );
        }

        rs.close();
        con.close();
        
        return allNews;
    }
    
}
