<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'item.label', default: 'Item')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#edit-item" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/home/index')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="edit-item" class="content scaffold-edit" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.item}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.item}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.item}" method="POST" enctype="multipart/form-data">
                <g:hiddenField name="version" value="${this.item?.version}" />
                <fieldset class="form">
                    <f:field bean="item" property="name"/>
                    <f:field bean="item" property="price"/>
                    <f:field bean="item" property="negotiable"/>
                    <f:field bean="item" property="shippingOption"/>
                    <f:field bean="item" property="itemCondition"/>
                    <f:field bean="item" property="itemUsage"/>
                    <f:field bean="item" property="description"/>
                    <f:field bean="item" property="weight"/>
                    <f:field bean="item" property="color"/>
                    <f:field bean="item" property="material"/>
                    <div class="fieldcontain required">
                        <label>Image</label>
                        <span class="required-indicator"></span>
                        <input type="file" id="itemImage" name="itemImage"/>
                    </div>
                </fieldset>
                <fieldset class="buttons">
                    <input class="save" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
