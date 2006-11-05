<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="de.incave.home.Counter" %>
<%@page import="de.incave.home.News" %>
<%@page import="de.incave.home.NewsEntry" %>
<%@page import="de.incave.home.Calendar" %>
<%@page import="de.incave.home.CalendarEntry" %>
<%@page import="java.text.DateFormat" %>

<%! String pageTitle = "home"; %>
<%! String pageName = pageTitle; %>

<%@ include file="themes/normal/head.tpl.html" %>

<% Counter myCounter = new Counter(request.getRemoteAddr()); %>
<div id="counter">
    <div id="allHits"> Besucher: <%= myCounter.getHits() %> </div>
    <div id="todayHits"> Heute:  <%= myCounter.getTodayHits() %> </div>
    <div id="yesterdayHits"> Gestern: <%= myCounter.getYesterdayHits() %> </div>
    <div id="onlineCount"> Online: <%= myCounter.getOnlineCount() %> </div>
</div>
<div style="clear:both"></div>

<h2>.: news </h2>
<%  Iterable<NewsEntry> allNews = new News().getAllNews(5);
    for( NewsEntry aNews : allNews ) { %>
    <div class="newsentry">
        <div class="head">
            <div class="title"> <%= aNews.getTitle() %> </div>
            <div class="right"> <%= aNews.getAuthor() %>  <br />
             <%= DateFormat.getDateInstance().format(aNews.getPosttime().getTime()) %> - <%= DateFormat.getTimeInstance().format(aNews.getPosttime().getTime()) %> </div>
            
        </div>
        <div class="body">
            <div class="text"> <%= aNews.getText() %> </div>
        </div>
        <div class="foot"><a href="forum/thread.php?postid=<%= aNews.getThreadid() %>#post<%= aNews.getThreadid() %>"><img src="style/home/reply.png" alt="Antworten" title="" /></a></div>
    </div>
    <% } %>

<h2>.: calendar </h2>
<%  Iterable<CalendarEntry> allEvents = new Calendar().getNextEvents(5);
    for( CalendarEntry aEvent : allEvents ) { %>
    <div class="calendarentry">
        <div class="flyer"> <img src="<%= aEvent.getFlyer() %>" alt="Flyer" title="" /> </div>
        <div class="text"> 
            <h3> <%= aEvent.getTitle() %> </h3>
            am <%= DateFormat.getDateInstance().format(aEvent.getTime()) %> <br />
            um <%= DateFormat.getTimeInstance().format(aEvent.getTime()) %> <br />
            .:mehr Infos
        </div>
    </div>
    <% } %>
<%@ include file="themes/normal/foot.tpl.html" %>
