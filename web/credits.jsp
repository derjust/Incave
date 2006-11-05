<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="de.incave.credits.Credit" %>
<%@page import="de.incave.credits.Credits" %>
<%@ taglib uri="/WEB-INF/credits" prefix="c" %>

<%! String pageTitle = "credits"; %>
<%! String pageName = pageTitle; %>

<%@ include file="themes/normal/head.tpl.html" %>

<%
    Iterable<Credit> allCredits = new Credits().getAllCredits();
    for( Credit aCredit : allCredits ) { %>
<div class="creditItem">
    <div class="creditPic"><img border="0" src="<%= aCredit.getPicture() %>" width="100" height="145" alt=""></div>
<h2> <%= aCredit.getTitle() %> </h2>
<div class="creditContent"> <%= aCredit.getText() %>
    <% if ( aCredit.getIcq()>0) { %>
        <h3>Kontak:</h3>
        <span class="title">Email: </span> <%= aCredit.getEmail() %> <br /></br />
         <c:ICQ number="<%= 
                aCredit.getIcq() %>"/>
    <% } %>
</div>
</div>

<% } %>
<div class="creditItem">
    <h2> Disclaimer </h2>
    <div class="creditContent">
        Wir legen Wert auf die Feststellung, dass unsere Links zu anderen Seiten im Internet sorgfältig geprüft wurden. Dennoch haben wir keinen dauerhaften Einfluss auf deren Inhalte. Daher distanzieren wir uns hiermit ausdrücklich von wenig wahrscheinlichen, aber möglichen inhaltlichen Entgleisungen jeder Art. Sollten Sie von einem Link unserer Seiten zu ungesetzlichen oder moralisch fragwürdigen Inhalten gelangen, bitten wir umgehend um Rückmeldung. 
    </div>
</div>
<a href="http://validator.w3.org/check?uri=referer" target='_blank'>
<img src="http://www.w3.org/Icons/valid-html401" border=0 alt="Valid HTML 4.01 Transitional" height="31" width="88"></a>
<a href="http://jigsaw.w3.org/css-validator/" target='_blank'>
<img style="border:0;width:88px;height:31px" src="http://jigsaw.w3.org/css-validator/images/vcss" alt="Valid CSS!" ></a>

<%@ include file="themes/normal/foot.tpl.html" %>