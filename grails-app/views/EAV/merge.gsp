<%--
  Created by IntelliJ IDEA.
  User: LT530
  Date: 1/3/2015
  Time: 12:39 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Entity, Attributes & Values</title>
</head>

<body>

<h3>This is EAV after combination</h3>

<div id="no-id">
    <table border="1" style="width:60%">

        <thead><td>id</td><td>${vname1}</td><td>${vname2}</td></thead>

        <g:each in="${rs}" var="rec" status="i">
            <tr></tr><td>${rec.id}</td><td> ${rec.v1}</td><td>${rec.v2}</td></tr>
        </g:each>


    </table>



</div>



</body>
</html>