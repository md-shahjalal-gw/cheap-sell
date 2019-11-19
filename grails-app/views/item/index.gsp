<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'item.label', default: 'Item')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-item" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/home/index')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="list-item" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>

            <fieldset class="form">
                <g:form action="index" method="GET">
                    <fieldset class="form">
                        <label for="query">Search:</label>
                        <g:textField name="query" value="${params.query}"/>
                    </fieldset>
                </g:form>
            </fieldset>

            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>

            <table>
                <tr>
                    <g:each in="${itemList}" var="item" status="i">
                        <g:if test="${i % 5 == 0}">
                            </tr>
                            <tr>
                        </g:if>
                        <td style="text-align: center;">
                            <g:link controller="item" action="show" id="${item.id}">
                                <img src="${createLink(controller:'item', action: 'showImage', id: "${item.id}")}" width="200" height="200" class="product-image"/>
                            </g:link>
                            <span class="product-details">
                                <p class="product-description">
                                    ${item.name}, Price: $${item.price} <br>
                                    ${item.description}
                                    <g:if test="${item.price == 0}">
                                        <font color="red">Free!</font>
                                    </g:if>
                                </p>
                            </span>
                        </td>
                    </g:each>
                </tr>
            </table>

%{--            <f:table collection="${itemList}" properties="name, itemUsage, description, price"/>--}%

            <div class="pagination">
                <g:paginate total="${itemCount ?: 0}" />
            </div>
        </div>
    </body>
</html>