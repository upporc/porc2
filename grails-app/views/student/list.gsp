
<!--
http://grails.asia/grails-example-upload-excel-data-file-to-database
-->


<%@ page import="upporc.Student" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="tooplate">
    <title>Person List</title>
</head>
<body>
<div class="nav" role="navigation">
    <ul>
        <li><g:link class="create" action="upload">Upload Data</g:link></li>
    </ul>
</div>
<div id="list-person" class="content scaffold-list" role="main">
    <h1>Person List</h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>
            <!-- <g:sortableColumn property="dateOfBirth" title="Date Of Birth" />   -->
            <g:sortableColumn property="firstName" title="First Name" />
            <g:sortableColumn property="lastName" title="Last Name" />
            <!-- <g:sortableColumn property="numberOfChildren" title="Number Of Children" /> __>
        </tr>
        </thead>
        <tbody>
        <g:each in="${personInstanceList}" status="i" var="personInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                <td><g:link action="show" id="${personInstance.id}">
                    ${fieldValue(bean: personInstance, field: "lastName")}
                </g:link></td>
                <td>${fieldValue(bean: personInstance, field: "firstName")}</td>

            </tr>
        </g:each>
        </tbody>
    </table>
    <div class="pagination">
        <g:paginate total="${personInstanceTotal}" />
    </div>
</div>
</body>
</html>