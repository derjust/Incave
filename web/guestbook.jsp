<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%! String pageTitle = "guestbook"; %>
<%! String pageName = pageTitle; %>

<%@page import="de.incave.guestbook.Guestbook" %>
<%@page import="de.incave.guestbook.GuestbookEntry" %>
<%@page import="java.text.DateFormat" %>

<%@ include file="themes/normal/head.tpl.html" %>

<%
    Iterable<GuestbookEntry> allEntries = new Guestbook().getEntries(0);
    for( GuestbookEntry aEntry : allEntries ) { %>

    <div class="entry">
         <div class="text"> 
            <%= aEntry.getText() %> 
            <% if (aEntry.getComment().length() > 0 ) { %>
                <hr />
            <%= aEntry.getComment() %> <br />
            <span style="font-size:small">Editiert von Admin</span>
            <% } %>
        </div>
        <div class="information">
            <div class="time"><%= DateFormat.getDateInstance().format(aEntry.getTime()) %> - <%=  DateFormat.getTimeInstance().format(aEntry.getTime()) %></div>
            <div class="name"><%= aEntry.getName() %></div>
            
            <% if (aEntry.getEmail().length() > 0) { %>
                <a href="mailto:<%= aEntry.getEmail() %>"><img alt="mail" title="" src="style/guestbook/email.gif" /></a>
            <% } %>
            <% if (aEntry.getHomepage().length() > 0) { %>
                <a target="_blank" href="<%= aEntry.getHomepage() %>"><img alt="www" title="" src="style/guestbook/homepage.gif" /></a>
            <% } %>
            <% if (aEntry.getIcq() > 0) { %>
                <div class="icq"><a href="http://wwp.icq.com/scripts/contact.dll?msgto=<%= aEntry.getIcq() %>"><img alt="icq" title="" src="style/guestbook/icq.gif" /><%= aEntry.getIcq() %></a></div>
            <% } %>
        </div>
    </div>

<% } %>


<%@ include file="themes/normal/foot.tpl.html" %>
