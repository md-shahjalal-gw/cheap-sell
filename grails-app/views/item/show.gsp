<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'item.label', default: 'Item')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-item" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/home/index')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="show-item" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>

            <g:if test="${item?.imageBytes}">
                <div class="fieldcontain required">
                    <label>&nbsp;</label>
                    <img src="${createLink(controller:'item', action: 'showImage', id: "${item.id}")}" width='300'/>
                </div>
            </g:if>

            <div class="fieldcontain required">
                <label>Name:</label>${item?.name}
            </div>

            <div class="fieldcontain required">
                <label>Price:</label>${item?.price}
            </div>

            <div class="fieldcontain required">
                <label>Shipping Option:</label>${item?.shippingOption}
            </div>

            <div class="fieldcontain required">
                <label>Item Condition:</label>${item?.itemCondition}
            </div>

            <div class="fieldcontain required">
                <label>Item Usage:</label>${item?.itemUsage}
            </div>

            <div class="fieldcontain required">
                <label>Description:</label>${item?.description}
            </div>

            <div class="fieldcontain required">
                <label>Weight:</label>${item?.weight}
            </div>

            <div class="fieldcontain required">
                <label>Color:</label>${item?.color}
            </div>

            <div class="fieldcontain required">
                <label>Material:</label>${item?.material}
            </div>

            <div class="fieldcontain required">
                <label>Purchase Date:</label><g:formatDate format="MM/dd/yyyy" date="${item?.purchaseDate}"/>
            </div>

            <div class="fieldcontain required">
                <label>Original Price:</label>${item?.originalPrice}
            </div>

            <g:if test="${!ownItem && estimatedPrice != null}">
                <div class="fieldcontain required">
                    <label>Estimated Price:</label>${estimatedPrice}
                </div>
            </g:if>

            <g:form resource="${this.item}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.item}"><g:message code="default.button.edit.label" default="Edit" /></g:link>

                    <g:if test="${!ownItem}">
                        <g:if test="${isInCart}">
                            <g:link controller="cart" action="removeFromCart" params="[id: this.item.id]">Remove from Cart</g:link>
                        </g:if>
                        <g:else>
                            <g:link controller="cart" action="buyNow" params="[id: this.item.id]">Buy Now</g:link>
                            <g:link controller="cart" action="addToCart" params="[id: this.item.id]">Add to Cart</g:link>
                        </g:else>
                    </g:if>
                    <g:else>
                        <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                    </g:else>
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
