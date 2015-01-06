<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="toplate"/>
    <title>Form</title>
</head>
<body>


<g:form controller="person" action="add">
    <label>First Name: </label>    <g:textField name="firstName"/><br/>
    <label>Last Name: </label>     <g:textField name="lastName"/><br/>
    <label>Age: </label>     <g:textField name="age"/><br/>

    <g:actionSubmit value="Add"/>
</g:form>


</body>
</html>