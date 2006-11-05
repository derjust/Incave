<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<%@page import="java.io.StringWriter" %>
<%@page import="java.io.PrintWriter" %>

<%! String pageTitle = "Error"; %>
<%! String pageName = pageTitle; %>

<%@ include file="themes/normal/head.tpl.html" %>

<p> Ups, da ist ein Fehler aufgetreten. </p>

<p> <%= exception.getMessage() %> </p>
<!--
<% StringWriter sw = new StringWriter();PrintWriter pw = new PrintWriter(sw);
exception.printStackTrace(pw); out.print(sw); sw.close(); pw.close();%>
-->

<%@ include file="themes/normal/foot.tpl.html" %>
