<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/home/index')}"><g:message code="default.home.label"/></a></li>
%{--                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>--}%
%{--                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>--}%
            </ul>
        </div>
        <div id="show-user" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>

            <div class="fieldcontain required">
                <label>First Name:</label>${user?.firstName}
            </div>

            <div class="fieldcontain required">
                <label>Last Name:</label>${user?.lastName}
            </div>

            <div class="fieldcontain required">
                <label>Contact Phone:</label>${user?.contactPhone}
            </div>

            <div class="fieldcontain required">
                <label>User Profile Type:</label>${user?.userProfileType}
            </div>

            <div class="fieldcontain required">
                <label>Date of Birth:</label><g:formatDate format="MM/dd/yyyy" date="${user?.dateOfBirth}"/>
            </div>

            <div class="fieldcontain required">
                <label>Contact Street 1:</label>${user?.contactStreet1}
            </div>

            <div class="fieldcontain required">
                <label>Contact Street 2:</label>${user?.contactStreet2}
            </div>

            <div class="fieldcontain required">
                <label>Contact City:</label>${user?.contactCity}
            </div>

            <div class="fieldcontain required">
                <label>Contact State:</label>${user?.contactState}
            </div>

            <div class="fieldcontain required">
                <label>Rating:</label>${user?.rating}
            </div>

            <g:form resource="${this.user}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.user}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
%{--                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />--}%
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
