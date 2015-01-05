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

<h3>This is EAV after conversion</h3>

<div id="no-id">
    <table border="1" style="width:60%">

<thead><td>id</td><td>${varname}</td></thead>

<g:each in="${rs}" var="rec" status="i">
    <tr></tr><td>${rec.id}</td><td> ${rec.v1Name}</td></tr>
</g:each>


</table>
</div>

<br>
<div>
<h3>Additional EAV conversion</h3>
<g:form  controller="EAV" action="eav" method="post">
    <input type="text" name="var1" placeholder="variable name">
    <button class="btn btn-inverse">Submit</button>
</g:form>
</div>

<br>
<div>
<h3>Combination of the conversions</h3>
<g:form  controller="EAV" action="merge" method="post">
    <input type="text" name="v1" placeholder="variable name">
    <input type="text" name="v2" placeholder="variable name">

    <button class="btn btn-inverse">MergeEAVs</button>
</g:form>

</div>

</body>
</html>