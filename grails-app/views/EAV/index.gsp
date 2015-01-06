<%--
  Created by IntelliJ IDEA.
  User: LT530
  Date: 1/3/2015
  Time: 3:13 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="tooplate" />
    <title></title>
</head>

<body>
<h3>Variable to be converted</h3>


<g:form  controller="EAV" action="eav" method="post">
    <input type="text" name="var1" class="input-xxlarge" placeholder="Variable name">
    <button class="btn btn-inverse">Submit</button>
</g:form>

</body>
</html>