<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="de.incave.links.Link" %>
<%@page import="de.incave.links.Links" %>

<%! String pageTitle = "links"; %>
<%! String pageName = pageTitle; %>

<%@ include file="themes/normal/head.tpl.html" %>

<%
    Iterable<Link> allLinks = new Links().getAllLinks();
    for( Link aLink : allLinks ) { %>

       <div class="linkItem">
         <div class="linkText"> <%=aLink.getText() %> </div>
         <div class="linkPic">
             <a href="<%=aLink.getUrl() %>" target="_blank">
                 <% if (aLink.getPicture().endsWith("swf")) { %>
                 <object type='application/x-shockwave-flash' data='<%= aLink.getPicture() %>' codebase='http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0' width='468' height='80'>
                    <param name='allowScriptAccess' value='sameDomain'/>
                    <param name='movie' value='<%= aLink.getPicture() %>'/>
                    <param name='loop' value='true'/>
                    <param name='menu' value='false'/>
                    <param name='quality' value='high'/>
                    <param name='play' value='true'/>
                    <p style='text-align:center;'>
                        <a href='http://www.macromedia.com/go/getflash/'>
                            <img src='/images/get-flash-player.gif' 
                                title='get Macromedia Flash Player' style='border:none;'/>
                        </a>
                    </p>
                    <noscript>Bitte das Flash-Plugin installieren</noscript>
                </object>
                 <% } else { %>
                 <img src="<%= aLink.getPicture() %>" width="468" height="80" alt="<%=aLink.getUrl() %>" />
                 <% } %>
             </a>
         </div>

       </div>
       <div style="clear:both;"></div>

   <% } %>
        <p>
            Wir freuen uns immer, wenn unser Banner auch auf anderen Seiten erscheint.<br />
            Folgenden Quelltext einfach kopieren:
        </p>
        <div class="linkItem">
            <div class="linkText">
                <textarea rows="4"><object type='application/x-shockwave-flash' data='http://incave.de/linkImages/incave.swf' codebase='http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0' width='468' height='80'>
<param name='allowScriptAccess' value='sameDomain'/>
<param name='movie' value='http://incave.de/linkImages/incave.swf'/>
<param name='loop' value='true'/>
<param name='menu' value='false'/>
<param name='quality' value='high'/>
<param name='play' value='true'/>
<p style='text-align:center;'>
	<a href='http://www.macromedia.com/go/getflash/'>
	<img src='/images/get-flash-player.gif' 
		title='get Macromedia Flash Player' style='border:none;'/>
	</a>
</p>
<noscript>Bitte das Flash-Plugin installieren</noscript>
</object>
            </textarea>
        </div>
        <div class="linkpic">
            <object type='application/x-shockwave-flash' data='linkImages/incave.swf' codebase='http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0' width='468' height='80'>
                <param name='allowScriptAccess' value='sameDomain'/>
                <param name='movie' value='linkImages/incave.swf'/>
                <param name='loop' value='true'/>
                <param name='menu' value='false'/>
                <param name='quality' value='high'/>
                <param name='play' value='true'/>
                <p style='text-align:center;'>
                    <a href='http://www.macromedia.com/go/getflash/'>
                        <img src='/images/get-flash-player.gif' 
                             title='get Macromedia Flash Player' style='border:none;'/>
                    </a>
                </p>
                <noscript>Bitte das Flash-Plugin installieren</noscript>
            </object>
        </div>
     </div>


<%@ include file="themes/normal/foot.tpl.html" %>
