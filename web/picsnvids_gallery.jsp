<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %>
<%@ page import="de.incave.picsnvids.Picsnvids" %>
<%@ page import="de.incave.picsnvids.FilledGallery" %>
<%@ page import="de.incave.picsnvids.Photo" %>
<%
    int gid;
    try {
        gid = Integer.parseInt( request.getParameter("gid") );
    }
    catch (NumberFormatException ex) {
        gid = 0;
    }
    FilledGallery aGallery = new Picsnvids().getGallery( gid );
%>
 
<% String pageTitle = aGallery.getTitle(); %>
<%! String pageName = "picsnvids"; %>

<%@ include file="themes/normal/head.tpl.html" %>

    <table border="0" id="gallery">
        <tr>
<%  int cellCount = 0;
    for( Photo aPhoto : aGallery.getPhotos() ) { %>

            <td>
                <a href="picsnvids_photo.jsp?pid=<%=aPhoto.getPid() %>">
                    <img src="http://www.incave.de/picnvid/<%= aGallery.getPath() %>/thumbs/tn<%= aPhoto.getFilename() %>" alt="<%= aPhoto.getFilename() %>" title="" /> <br />
                    <%= aPhoto.getFilename() %>
                </a>
            </td>
            
<%      if (cellCount++ >= 4) { %>
            </tr><tr>
          <% cellCount=0; } } %>
        </tr>
    </table>



<%@ include file="themes/normal/foot.tpl.html" %>
