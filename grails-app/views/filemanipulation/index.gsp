<%--
  Created by IntelliJ IDEA.
  User: LT530
  Date: 1/2/2015
  Time: 9:55 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head> <meta name="layout" content="main"/>
    <title>PostgreSQL Manipulation</title>
</head>

<body>



<g:each in="${rs}" var="rec" status="i">
    <ul>${rec.name}, ${rec.age}, ${rec.attribute}, ${rec.values}</ul>

    <br/>
</g:each>


<g:link action="download">Download Sample Excel</g:link>



<g:uploadForm action="uploadAction">
    <input type="file" name="filecsv" />
    <input type="submit" value="Upload"/>
</g:uploadForm>



<g:uploadForm action="csvupload">
    <input type="file" name="csvfile" />
    <input type="submit" value="CSVUpload"/>
</g:uploadForm>

</body>
</html>