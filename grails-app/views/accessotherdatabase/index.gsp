
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="tooplate" />
</head>

<body>

<h3>This is from MySQL</h3>
<table border="1" style="width:60%">
    <tr><th>Order</th><th>First Name</th><th>Last Name</th><th>Age</th></tr>
    <g:each in="${records}" var="c" status="i">
        <tr>
            <td>${i+1}</td>
            <td>${c.first_name}</td>
            <td>${c.last_name}</td>
            <td>${c.age}</td>
        </tr>
    </g:each>
</table>

<g:link controller="accessotherdatabase" action="postgres">PostgresQL</g:link>



</body>
</html>

