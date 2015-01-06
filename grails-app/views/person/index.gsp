<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="tooplate"/>
    <title>Persons</title>
</head>
<body>

${persons}
<g:each in="${persons}" var="person" status="i">
    <h3>&nbsp &nbsp ${i+1}. ${person.lastName}, ${person.firstName}</h3>
    &nbsp &nbsp &nbsp &nbsp Age: ${person.age}

    <br/>
</g:each>
<p>&nbsp
    </p>
&nbsp &nbsp
<a href="./form.gsp">Add a person</a>
<p>
    &nbsp &nbsp    <a href="../">return to home</a>
</p>



<img src="${createLinkTo(dir: 'images', file: 'springsource.png')}" />

<img src="<g:createLinkTo dir="images" file="grails_logo.png" />" />

</body>
</html>