<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Books</title>
</head>
<body>


<g:each in="${books}" var="book" status="i">
    <h3>${i+1}. ${book.title}, ${book.author}</h3>
    <p>
        ISBN: ${book.ISBN}
    </p>
    <br/>
</g:each>

<a href="./form.gsp">Add a book</a>
<p><a href="../"> return to home</a>
</p>

<!--

http://grails.org/doc/latest/guide/theWebLayer.html
template file _bookTemplate.gsp under /view/book
if only one item in the model
<g:render template="bookTemplate" model="[book: Book]" />
-->

<g:render template="bookTemplate" var="book" collection="${books}" />

</body>
</html>