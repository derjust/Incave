<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="de.incave.picsnvids.Picsnvids" %>
<%@page import="de.incave.picsnvids.Gallery" %>

<%! String pageTitle = "pics'n'vids"; %>
<%! String pageName = "picsnvids"; %>

<%@ include file="themes/normal/head.tpl.html" %>

    <table border="0" id="gallery">
        <tr>
<%  Iterable<Gallery> allGalleries = new Picsnvids().getGalleries(0);
    int cellCount = 0;
    for( Gallery aGallery : allGalleries ) { %>

            <td>
                <a href="javascript:openGallery('<%= aGallery.getGid() %>');">
                    <img src="http://www.incave.de/picnvid/<%= aGallery.getPath() %>/thumbs/<%= aGallery.getThumbnail() %>" alt="<%= aGallery.getTitle() %>" title="" /> <br />
                    <%= aGallery.getTitle() %>
                </a>
            </td>
            
<%      if (cellCount++ >= 4) { %>
            </tr><tr>
          <% cellCount=0; } } %>
        </tr>
    </table>


<%@ include file="themes/normal/foot.tpl.html" %>
