/*
 * Database.java
 *
 * Created on 29. Oktober 2006, 00:20
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package de.incave.database;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author tiwaz
 */
public class Database {
    
    /** Creates a new instance of Database */
    public Database() {
    }

    public static DataSource getIncaveDatabase() throws NamingException {
        Context c = new InitialContext();
        return (DataSource) c.lookup("java:comp/env/incaveDatabase");
    } 
    
    public static String removeBBCode(String text ) {
        text = text.replace("\r\n", "<br />");
        text = text.replace("[CENTER]", "<span style='text-align:center'>");
        text = text.replace("[/CENTER]","</span>");
        text = text.replace("[IMG]","<img src='");
        text = text.replace("[/IMG]", "' />");
        
        return text;
    }
}
