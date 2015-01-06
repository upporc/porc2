<%--
  Created by IntelliJ IDEA.
  User: LT530
  Date: 12/30/2014
  Time: 11:40 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="tooplate" />
</head>

<body>

<h3>This is from PostgreSQL</h3>
<table border="1" style="width:60%">
    <tr><th>Order</th>        <th>ID</th><th>Attribute</th><th>Values</th></tr>
    <g:each in="${records}" var="c" status="i">
        <tr>
            <td>${i+1}</td>
            <td>${c.pt_id}</td>
            <td>${c.attribute}</td>
            <td>${c.values}</td>
        </tr>
    </g:each>
</table>



</body>
</html>