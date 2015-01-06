<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="tooplate"/>
    <title>Form</title>
</head>
<body>


<g:form controller="book" action="save">
    <label>Title: </label>
    <g:textField name="title"/><br/>
    <label>Author: </label>
    <g:textField name="author"/><br/>
    <label>ISBN: </label>
    <g:textField name="ISBN"/><br/>

    <g:actionSubmit value="Save"/>
</g:form>


</body>
</html>