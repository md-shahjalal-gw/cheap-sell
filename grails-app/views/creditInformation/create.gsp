<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'creditInformation.label', default: 'CreditInformation')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#create-creditInformation" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/home/index')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="create-creditInformation" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.creditInformation}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.creditInformation}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.creditInformation}" method="POST">
                <fieldset class="form">
                    <f:field bean="creditInformation" property="cardNumber"/>
                    <f:field bean="creditInformation" property="cardHolder"/>
                    <f:field bean="creditInformation" property="cvc"/>
                    <f:field bean="creditInformation" property="expireMonth"/>
                    <f:field bean="creditInformation" property="expireYear"/>
                    <f:field bean="creditInformation" property="address1"/>
                    <f:field bean="creditInformation" property="address2"/>
                    <f:field bean="creditInformation" property="city"/>
                    <f:field bean="creditInformation" property="state"/>
                    <f:field bean="creditInformation" property="zip"/>
                    <f:field bean="creditInformation" property="phone"/>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
