/*
 * Taglib.java
 *
 * Created on 4. November 2006, 00:27
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package de.incave.credits;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.*;  

/**
 *
 * @author tiwaz
 */
public class Taglib implements Tag {
    private PageContext pageContext;
    private Tag parent;
    private String number;
    
    /** Creates a new instance of Taglib */
    public Taglib() {
    }

    public void setPageContext(PageContext pc) {
        pageContext = pc;
    }

    public void setParent(Tag t) {
        parent = t;
    }

    public Tag getParent() {
        return parent;
    }
    
    public void setNumber(String number) {
        this.number = number;
    }

    public int doStartTag() throws JspException {
        return SKIP_BODY;
    }

    public int doEndTag() throws JspException {
        try
        {
            pageContext.getOut().write("<span class='title'>ICQ: </span>" +
                    "<a href='http://wwp.icq.com/scripts/search.dll?to="+number+"' target='_blank'>" +
                    "<img src='http://web.icq.com/whitepages/online?icq="+number+"&amp;img=2' alt='ICQ-Status'></a>");
        }
        catch(java.io.IOException e)
        {
            throw new JspTagException("IO Error: " + e.getMessage());
        }
        return EVAL_PAGE;        
    }

    public void release() {
    }
    
}
