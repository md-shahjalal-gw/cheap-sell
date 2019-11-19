<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'creditInformation.label', default: 'CreditInformation')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-creditInformation" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/home/index')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="show-creditInformation" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>

            <div class="fieldcontain required">
                <label>Card Holder:</label>${creditInformation?.cardHolder}
            </div>

            <div class="fieldcontain required">
                <label>Card Number:</label>${creditInformation?.cardNumber}
            </div>

            <div class="fieldcontain required">
                <label>cvc:</label>${creditInformation?.cvc}
            </div>

            <div class="fieldcontain required">
                <label>Expire Month:</label>${creditInformation?.expireMonth}
            </div>

            <div class="fieldcontain required">
                <label>Expire Year:</label>${creditInformation?.expireYear}
            </div>

            <div class="fieldcontain required">
                <label>Address 1:</label>${creditInformation?.address1}
            </div>

            <div class="fieldcontain required">
                <label>Address 2:</label>${creditInformation?.address2}
            </div>

            <div class="fieldcontain required">
                <label>City:</label>${creditInformation?.city}
            </div>

            <div class="fieldcontain required">
                <label>Zip:</label>${creditInformation?.zip}
            </div>

            <div class="fieldcontain required">
                <label>State:</label>${creditInformation?.state}
            </div>


            <g:form resource="${this.creditInformation}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.creditInformation}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
