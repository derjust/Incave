/*
 * Counter.java
 *
 * Created on 29. Oktober 2006, 11:06
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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author tiwaz
 */
public class Counter   {
    private int hits;
    private int todayHits;
    private int yesterdayHits;
    private int onlineCount;
        
    /** Creates a new instance of Counter */
    public Counter(String ip) throws SQLException, NamingException  {
        SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
        Date todayDate = new Date();
        String today = sdf.format( todayDate );
        String yesterday = sdf.format( todayDate.getTime() - 24L*60L*60L*1000L  );

        DataSource ds = Database.getIncaveDatabase();
        Connection con = ds.getConnection();
        Statement s = con.createStatement();
        ResultSet rs;
        
        try {
            s.execute("INSERT INTO counter (`ip`, `time`) VALUES('" + ip + "','" + today + "')");
        } catch (SQLException ex) { /*User bereits geloggt */ }

        s.execute("select count(*) from `counter`");
        rs = s.getResultSet();
        rs.next();
        hits = rs.getInt(1);

        s.execute("select count(*) from `counter` where `time`='"+today+"'");
        rs = s.getResultSet();
        rs.next();
        todayHits = rs.getInt(1);

        s.execute("select count(*) from `counter` where `time`='"+yesterday+"'");
        rs = s.getResultSet();
        rs.next();
        yesterdayHits = rs.getInt(1);
        
        rs.close();
        con.close();
        
    }
    
        public int getHits() {
        return hits;
    }
    
    public int getTodayHits() {
        return todayHits;
    }
    
    public int getYesterdayHits() {
        return yesterdayHits;
    }
    
    public int getOnlineCount() {
        return onlineCount;
    }
    
}
