<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'cartItem.label', default: 'CartItem')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-cartItem" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/home/index')}"><g:message code="default.home.label"/></a></li>
            </ul>
        </div>
        <div id="list-cartItem" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>

            <f:table collection="${cartItemList}" properties="name, price, dateAdded"/>

            <div class="pagination">
                <g:paginate total="${cartItemCount ?: 0}" />
            </div>

            <fieldset class="buttons">
                <g:if test="${cartItemCount > 0}">
                    <g:link controller="cartItem" action="checkout">Checkout</g:link>
                </g:if>
            </fieldset>
        </div>
    </body>
</html>